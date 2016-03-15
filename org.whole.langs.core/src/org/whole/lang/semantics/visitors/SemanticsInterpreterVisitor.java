/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.semantics.visitors;

import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.ActionCall;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.resources.FunctionLibraryRegistry;
import org.whole.lang.semantics.model.BindingOpEnum;
import org.whole.lang.semantics.model.BindingsScope;
import org.whole.lang.semantics.model.EntityType;
import org.whole.lang.semantics.model.EnvironmentVariable;
import org.whole.lang.semantics.model.FunctionApplication;
import org.whole.lang.semantics.model.FunctionBody;
import org.whole.lang.semantics.model.LanguageType;
import org.whole.lang.semantics.model.LocalBinding;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.model.SemanticFunction;
import org.whole.lang.semantics.model.SemanticTheory;
import org.whole.lang.semantics.model.StructuredVariable;
import org.whole.lang.semantics.model.TypeCast;
import org.whole.lang.semantics.model.Variable;
import org.whole.lang.semantics.model.VariableValue;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.util.SemanticsUtils;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
*/
public class SemanticsInterpreterVisitor extends SemanticsTraverseAllChildrenVisitor {
	public void setResultIterator(IEntityIterator<?> queryIterator) {
		queryIterator.setBindings(getBindings());
		super.setResultIterator(queryIterator);
	}

    @Override
    public void visit(SemanticTheory entity) {
    	SemanticTheory semanticTheory = EntityUtils.clone(entity);
    	IBindingManager bm = getBindings();
    	bm.wEnterScope();
		NormalizerOperation.normalize(semanticTheory, bm);
		bm.wExitScope();

    	FunctionLibraryRegistry.instance().addResource(semanticTheory, libraryUri = semanticTheory.getUri().getValue(), false);

   		semanticTheory.getFunctions().accept(this);

		setResult(BindingManagerFactory.instance.createVoid());
    }

    protected String libraryUri;
    protected String getLibraryUri(IEntity entity) {
		if (libraryUri == null) {
			SemanticTheory st = Matcher.findAncestor(SemanticsEntityDescriptorEnum.SemanticTheory, entity);
			libraryUri = st != null ? st.getUri().getValue() : getBindings().wStringValue("libraryUri");
		}
		return libraryUri;
    }

    @Override
    public void visit(SemanticFunction entity) {
    	FunctionBody rules = entity.getRules();
    	if (Matcher.match(SemanticsEntityDescriptorEnum.InferenceRules, rules))
    		return;

		FunctionLibraryRegistry.instance().putFunctionModel(
				getLibraryUri(entity)+"#"+entity.getName().getValue(), entity);

		IBindingManager bm = getBindings();
    	if (!bm.wIsSet("LazyInterpretation") || !bm.wBooleanValue("LazyInterpretation"))
	   		DynamicCompilerOperation.compile(entity, getBindings());
    }

    @Override
    public void visit(FunctionApplication entity) {
    	handleCancelRequest();
    	DynamicCompilerOperation.compile(entity, getBindings());
    }

    @Override
    public void visit(TypeCast entity) {
    	DynamicCompilerOperation.compile(entity, getBindings());
    }

    @Override
    public void visit(Name entity) {
    	setResult(entity);
    }

    @Override
    public void visit(EntityType entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
    }

    @Override
    public void visit(LanguageType entity) {
    	setResult(BindingManagerFactory.instance.createValue(entity.getValue()));
    }

    @Override
    public void visit(StructuredVariable entity) {
		ActionsEntityFactory aef = ActionsEntityFactory.instance;
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		ActionCall actionCall = aef.createActionCall(
				aef.createLabel("whole:org.whole.lang.semantics:SemanticsActions:1.0.0#toVariableFlatName"),
				qef.createVariableRefStep("variable").wGetAdapter(ActionsEntityDescriptorEnum.SelectedEntities));

		getBindings().wDef("variable", entity);
		IEntity varNameEntity = BehaviorUtils.evaluate(actionCall, 0, getOperation());
		
    	if (isSelectedFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS))
    		setResult(varNameEntity);
    	else {
    		IEntity varValue = BindingUtils.wGet(getBindings(), varNameEntity.wStringValue());
    		if (varValue == null)
    			throw new MissingVariableException(entity.toString()).withSourceEntity(entity).withBindings(getBindings());

    		setResult(varValue);
    	}
    }

    @Override
    public void visit(Variable entity) {
    	if (isSelectedFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS))
        	setResult(entity);
    	else {
    		IEntity varValue = BindingUtils.wGet(getBindings(), entity.getValue());
    		if (varValue == null)
    			throw new MissingVariableException(entity.toString()).withSourceEntity(entity).withBindings(getBindings());

    		setResult(varValue);
    	}
    }

    @Override
    public void visit(VariableValue entity) {
    	IEntity oldSematics = setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, false);
    	try {
    		entity.getIdentifier().accept(this);
    	} finally {
    		setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, oldSematics);
    	}
    }

    @Override
    public void visit(EnvironmentVariable entity) {
    	IEntity oldSematics = setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, true);
    	try {
	    	entity.getEnvironment().accept(this);
			IBindingManager bm = getBindings().wGetEnvironmentManager()
					.getEnvironment(getResult().wStringValue());
	
			entity.getVariable().accept(this);
			String varName = getResult().wStringValue();

			IEntity varValue = bm.wGet(varName);
			if (varValue == null)
				throw new MissingVariableException(entity.getVariable().toString()).withSourceEntity(entity).withBindings(getBindings());

			setResult(varValue);
    	} finally {
    		setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, oldSematics);
    	}
    }

    @Override
    public void visit(BindingsScope entity) {
    	IEntity oldSematics = setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, true);
    	try {
	    	entity.getIdentifier().accept(this);
			IBindingManager bm = getBindings().wGetEnvironmentManager()
					.getEnvironment(getResult().wStringValue());

			for (LocalBinding b : entity.getBindings()) {
				setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, true);
				b.getIdentifier().accept(this);
				String varName = getResult().wStringValue();
	
				setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, false);
				IEntity varValue = BehaviorUtils.evaluate(b.getExpression(), 0, getOperation());
	
	    		switch (b.getOp().getValue().getOrdinal()) {
	    		case BindingOpEnum.UNBIND_ord:
	    			bm.wUnset(varName);
	    			break;
	    		case BindingOpEnum.BIND_ord:
	    			bm.wDef(varName, varValue);
	    			break;
	    		case BindingOpEnum.FRESH_BIND_ord:
	    			//TODO
	    			bm.wDef(varName, varValue);
	    			break;
	    		case BindingOpEnum.MATCH_BIND_ord:
	    			//TODO
	    			bm.wDef(varName, varValue);
	    			break;
	    		}
			}

			setResult(BindingManagerFactory.instance.createValue(bm));
    	} finally {
    		setFeature(SemanticsUtils.USE_IDENTIFIER_SEMANTICS, oldSematics);
    	}
    }
}
