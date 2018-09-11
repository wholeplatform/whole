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
import org.whole.lang.executables.IExecutable;
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
    		setExecutableResult(iteratorFactory().createEmpty().withSourceEntity(entity));//TODO not supported yet
    		return;
    	}

    	IExecutable<?> ac = new ActionCallIterator(
    			"whole:org.whole.lang.semantics:SemanticsActions:1.0.0#Translate Normalized Function to Query", null);
    	stagedVisit(ac.evaluate(entity, getBindings()));
		IExecutable<?> functionBehavior = getExecutableResult();

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

    	IExecutable<IEntity> executableResult = iteratorFactory().createFunctionApplication(functionUri).withSourceEntity(entity);

		if (functionUri.endsWith("#stagedVisit"))
			executableResult = iteratorFactory().createRecursiveFunctionApplication().withSourceEntity(entity);

    	Expression arguments = entity.getArguments();
		if (!EntityUtils.isResolver(arguments)) {
    		arguments.accept(this);
    		IExecutable<?> argumentsIterator = getExecutableResult();

    		if (!argumentsIterator.getClass().equals(SelfIterator.class))
    			executableResult = iteratorFactory().createCompose(executableResult, argumentsIterator).withSourceEntity(entity);
    	}
		setExecutableResult(executableResult);
  	}

	@Override
	public void visit(TypeCast entity) {
		IExecutable<?> executableResult;
		CastType type = entity.getType();
		if (Matcher.matchImpl(SemanticsEntityDescriptorEnum.EnvType, type))
			executableResult = SemanticsUtils.typeCastIterator().withSourceEntity(entity);
		else
			executableResult = SemanticsUtils.typeCastIterator(type.wStringValue()).withSourceEntity(entity);

		Term expression = entity.getExpression();
		if (!EntityUtils.isResolver(expression)) {
    		expression.accept(this);
    		IExecutable<?> expressionIterator = getExecutableResult();

    		if (!expressionIterator.getClass().equals(SelfIterator.class))
    			executableResult = iteratorFactory().createFor(expressionIterator, executableResult).withSourceEntity(entity);
    	}
		setExecutableResult(executableResult);
	}

//	@Override
//	public void visit(Arguments entity) {
//    	IExecutable<?>[] argumentsIterators = new IExecutable<?>[entity.size()];
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
