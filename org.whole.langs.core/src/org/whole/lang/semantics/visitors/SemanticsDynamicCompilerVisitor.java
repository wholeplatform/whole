/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

import org.whole.lang.actions.evaluators.ActionCallEvaluator;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.evaluators.SelfEvaluator;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.resources.FunctionLibraryRegistry;
import org.whole.lang.semantics.model.CastType;
import org.whole.lang.semantics.model.Expression;
import org.whole.lang.semantics.model.FunctionApplication;
import org.whole.lang.semantics.model.FunctionBody;
import org.whole.lang.semantics.model.ISemanticsEntity;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.model.SemanticFunction;
import org.whole.lang.semantics.model.SemanticTheory;
import org.whole.lang.semantics.model.Term;
import org.whole.lang.semantics.model.TypeCast;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.util.SemanticsUtils;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SemanticsDynamicCompilerVisitor extends SemanticsIdentityDefaultVisitor {
	public static final String firstAncestorWithTypeAtStageURI = "whole:org.whole.lang.semantics:SemanticsLibrarySemantics#firstAncestorWithTypeAtStage";
	public static final String translateNormalizedFunctionToQueryURI = "whole:org.whole.lang.semantics:SemanticsActions:1.0.0#Translate Normalized Function to Query";
	public static final String toVariableFlatNameURI = "whole:org.whole.lang.semantics:SemanticsActions:1.0.0#toVariableFlatName";

    public static SemanticTheory getSemanticTheoryInScope(IEntity entity) {
		SemanticTheory semanticTheory = null;
		if (EntityUtils.hasParent(entity)) {
	    	if (FunctionLibraryRegistry.instance().getFunctionModel(firstAncestorWithTypeAtStageURI, false, null) != null) {
	    		IBindingManager bm = BindingManagerFactory.instance.createArguments();
	    		bm.wDefValue("ancestorType", SemanticsEntityDescriptorEnum.SemanticTheory.getURI());
	    		bm.wDefValue("atStage", 0);
	    		semanticTheory = (SemanticTheory) BehaviorUtils.apply(firstAncestorWithTypeAtStageURI, entity, bm);
			} else
				semanticTheory = Matcher.findAncestor(SemanticsEntityDescriptorEnum.SemanticTheory, entity);
		}
		return semanticTheory;
    }

    public static SemanticFunction getSemanticFunctionInScope(IEntity entity) {
		SemanticFunction semanticFunction = null;
    	if (EntityUtils.hasParent(entity)) {
	    	if (FunctionLibraryRegistry.instance().getFunctionModel(firstAncestorWithTypeAtStageURI, false, null) != null) {
	    		IBindingManager bm = BindingManagerFactory.instance.createArguments();
	    		bm.wDefValue("ancestorType", SemanticsEntityDescriptorEnum.SemanticFunction.getURI());
	    		bm.wDefValue("atStage", 0);
	    		semanticFunction = (SemanticFunction) BehaviorUtils.apply(firstAncestorWithTypeAtStageURI, entity, bm);
			} else
				semanticFunction = Matcher.findAncestor(SemanticsEntityDescriptorEnum.SemanticFunction, entity);
		}
		return semanticFunction;
    }

    
	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false), 0);
		return false;
	}
	
	@Override
	public void visit(ISemanticsEntity entity) {
		stagedDefaultVisit(entity, 0);
	}

    public static String getLibraryUri(IEntity entity, IBindingManager bm) {
    	if (bm.wIsSet(CompoundResourceRegistry.libraryUri))
			return bm.wStringValue(CompoundResourceRegistry.libraryUri);
		else {
			SemanticTheory st = getSemanticTheoryInScope(entity);
			if (st != null)
				return st.getUri().wStringValue();
			else
				throw new WholeIllegalArgumentException("Library URI is not available").withSourceEntity(entity).withBindings(bm);
		}
    }

	@Override
	public void visit(SemanticFunction entity) {
    	FunctionBody rules = entity.getRules();
    	if (Matcher.match(SemanticsEntityDescriptorEnum.InferenceRules, rules)) {
    		setExecutableResult(executableFactory().createEmpty().withSourceEntity(entity));//TODO not supported yet
    		return;
    	}

    	IExecutable ac = new ActionCallEvaluator(translateNormalizedFunctionToQueryURI, (IExecutable[]) null);
    	stagedVisit(ac.evaluate(entity, getBindings()));
		IExecutable functionBehavior = getExecutableResult();

		FunctionLibraryRegistry.instance().putFunctionCode(getLibraryUri(entity, getBindings())+"#"+entity.getName().getValue(), functionBehavior);
	}

	@Override
	public void visit(FunctionApplication entity) {
		Name functionName = entity.getName();
		if (EntityUtils.isResolver(functionName)) {
			SemanticFunction sf = getSemanticFunctionInScope(entity);
			if (sf != null)
				functionName = sf.getName();
		}
		if (EntityUtils.isResolver(functionName) || !functionName.wGetAdaptee(false).wGetEntityDescriptor().getDataKind().isString())
			throw new WholeIllegalArgumentException("Invalid name in FunctionApplication").withSourceEntity(entity).withBindings(getBindings());

    	String functionUri = functionName.getValue();
    	if (functionUri.indexOf("#") == -1)
    		functionUri = getLibraryUri(entity, getBindings())+"#"+functionUri;

    	IExecutable executableResult = executableFactory().createFunctionApplication(functionUri).withSourceEntity(entity);

		if (functionUri.endsWith("#stagedVisit"))
			executableResult = executableFactory().createRecursiveFunctionApplication().withSourceEntity(entity);

    	Expression arguments = entity.getArguments();
		if (!EntityUtils.isResolver(arguments)) {
    		arguments.accept(this);
    		IExecutable argumentsExecutable = getExecutableResult();

    		if (!argumentsExecutable.undecoratedExecutable().getClass().equals(SelfEvaluator.class))
    			executableResult = executableFactory().createCompose(executableResult, argumentsExecutable).withSourceEntity(entity);
    	}
		setExecutableResult(executableResult);
  	}

	@Override
	public void visit(TypeCast entity) {
		IExecutable executableResult;
		CastType type = entity.getType();
		if (Matcher.matchImpl(SemanticsEntityDescriptorEnum.EnvType, type))
			executableResult = SemanticsUtils.typeCastExecutable().withSourceEntity(entity);
		else
			executableResult = SemanticsUtils.typeCastExecutable(type.wStringValue()).withSourceEntity(entity);

		Term expression = entity.getExpression();
		if (!EntityUtils.isResolver(expression)) {
    		expression.accept(this);
    		IExecutable expressionExecutable = getExecutableResult();

    		if (!expressionExecutable.undecoratedExecutable().getClass().equals(SelfEvaluator.class))
    			executableResult = executableFactory().createFor(expressionExecutable, executableResult).withSourceEntity(entity);
    	}
		setExecutableResult(executableResult);
	}

//	@Override
//	public void visit(Arguments entity) {
//    	IExecutable[] argumentsIterators = new IExecutable[entity.size()];
//    	for (int i=0, size=entity.size(); i<size; i++) {
//    		entity.get(i).accept(this);
//			argumentsIterators[i] = getExecutableResult();
//		}
//
//    	if (argumentsIterators.length == 0)
//    		setExecutableResult(iteratorFactory().selfIterator().withDomainEntity(entity)); 
//    	else if (argumentsIterators.length == 1) {
//    		setExecutableResult(argumentsIterators[0]);
//		} else {//== if (argumentsIterators.length > 1) {
//			setExecutableResult(iteratorFactory().pointwiseProductIterator(argumentsIterators).withDomainEntity(entity));
//		}
//	}
}
