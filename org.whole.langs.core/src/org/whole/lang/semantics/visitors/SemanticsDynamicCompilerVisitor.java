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

import org.whole.lang.actions.iterators.ActionCallIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.SelfIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
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
	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false), 0);
		return false;
	}
	
	@Override
	public void visit(ISemanticsEntity entity) {
		stagedDefaultVisit(entity, 0);
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
    	if (Matcher.match(SemanticsEntityDescriptorEnum.InferenceRules, rules)) {
    		setResultIterator(IteratorFactory.emptyIterator().withSourceEntity(entity));//TODO not supported yet
    		return;
    	}

    	IEntityIterator<?> ac = new ActionCallIterator(
    			"whole:org.whole.lang.semantics:SemanticsActions:1.0.0#Translate Normalized Function to Query", null);
    	stagedVisit(BehaviorUtils.evaluate(ac, entity, getBindings()));
		IEntityIterator<?> functionBehavior = getResultIterator();

		FunctionLibraryRegistry.instance().putFunctionCode(getLibraryUri(entity)+"#"+entity.getName().getValue(), functionBehavior);
	}

	@Override
	public void visit(FunctionApplication entity) {
		Name functionName = entity.getName();
		if (EntityUtils.isResolver(functionName)) {
			SemanticFunction sf = Matcher.findAncestor(SemanticsEntityDescriptorEnum.SemanticFunction, entity);
			if (sf != null)
				functionName = sf.getName();
		}
		if (EntityUtils.isResolver(functionName))
			throw new IllegalArgumentException("Unnamed FunctionApplication");

    	String functionUri = functionName.getValue();
//    	if (functionUri.indexOf("#") == -1)
//    		functionUri = getLibraryUri(entity)+"#"+functionUri;

		IEntityIterator<IEntity> resultIterator = IteratorFactory.functionApplicationIterator(functionUri).withSourceEntity(entity);
		
		//TODO test only
		if (functionUri.endsWith("#stagedVisit"))
			resultIterator = IteratorFactory.recursiveFunctionApplicationIterator().withSourceEntity(entity);

    	Expression arguments = entity.getArguments();
		if (!EntityUtils.isResolver(arguments)) {
    		arguments.accept(this);
    		IEntityIterator<?> argumentsIterator = getResultIterator();

    		if (!argumentsIterator.getClass().equals(SelfIterator.class))
    			resultIterator = IteratorFactory.composeIterator(resultIterator, argumentsIterator).withSourceEntity(entity);
    	}
		setResultIterator(resultIterator);
  	}

	@Override
	public void visit(TypeCast entity) {
		IEntityIterator<IEntity> resultIterator;
		CastType type = entity.getType();
		if (Matcher.matchImpl(SemanticsEntityDescriptorEnum.EnvType, type))
			resultIterator = SemanticsUtils.typeCastIterator().withSourceEntity(entity);
		else
			resultIterator = SemanticsUtils.typeCastIterator(type.wStringValue()).withSourceEntity(entity);

		Term expression = entity.getExpression();
		if (!EntityUtils.isResolver(expression)) {
    		expression.accept(this);
    		IEntityIterator<?> expressionIterator = getResultIterator();

    		if (!expressionIterator.getClass().equals(SelfIterator.class))
    			resultIterator = IteratorFactory.forIterator(expressionIterator, resultIterator).withSourceEntity(entity);
    	}
		setResultIterator(resultIterator);
	}

//	@Override
//	public void visit(Arguments entity) {
//    	IEntityIterator<?>[] argumentsIterators = new IEntityIterator<?>[entity.size()];
//    	for (int i=0, size=entity.size(); i<size; i++) {
//    		entity.get(i).accept(this);
//			argumentsIterators[i] = getResultIterator();
//		}
//
//    	if (argumentsIterators.length == 0)
//    		setResultIterator(QueriesIteratorFactory.selfIterator().withDomainEntity(entity)); 
//    	else if (argumentsIterators.length == 1) {
//			setResultIterator(argumentsIterators[0]);
//		} else {//== if (argumentsIterators.length > 1) {
//			setResultIterator(QueriesIteratorFactory.pointwiseProductIterator(argumentsIterators).withDomainEntity(entity));
//		}
//	}
}
