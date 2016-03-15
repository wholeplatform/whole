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
package org.whole.lang.workflows.visitors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.util.JavaReflectUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.visitors.MissingVariableException;
import org.whole.lang.workflows.model.BooleanLiteral;
import org.whole.lang.workflows.model.CreateJavaClassInstance;
import org.whole.lang.workflows.model.Expressions;
import org.whole.lang.workflows.model.IWorkflowsEntity;
import org.whole.lang.workflows.model.IntLiteral;
import org.whole.lang.workflows.model.InvokeJavaClassMethod;
import org.whole.lang.workflows.model.InvokeJavaInstanceMethod;
import org.whole.lang.workflows.model.StringLiteral;
import org.whole.lang.workflows.model.Variable;

/**
 * @author Riccardo Solmi
 */
public class WorkflowsDynamicCompilerVisitor extends WorkflowsIdentityDefaultVisitor {
	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false), 0);
		return false;
	}
	
	@Override
	public void visit(IWorkflowsEntity entity) {
		stagedDefaultVisit(entity, 0);
	}

//FIXME add compilation of Assignments before fixing
//	@Override
//	public void visit(CreateEntity entity) {
//    	final Variable resultVariable = entity.getModel();
//
//    	entity.getEntityName().accept(this);
//		final String typeName = getResult().wStringValue();
//
//		IEntityRegistryProvider provider = null;
//		switch (entity.getRegistry().getValue().getOrdinal()) {
//		case RegistryEnum.DEFAULT_ord:
//			provider = RegistryConfigurations.DEFAULT;
//			break;
//		case RegistryEnum.RESOLVER_ord:
//			provider = RegistryConfigurations.RESOLVER;
//			break;
//		case RegistryEnum.ADAPTER_ord:
//			provider = RegistryConfigurations.ADAPTER;
//			break;
//		case RegistryEnum.STRICT_ord:
//			provider = RegistryConfigurations.STRICT;
//			break;
//		case RegistryEnum.CUSTOM_ord:
//			provider = RegistryConfigurations.CUSTOM;
//			break;
//		}
//		final IEntityFactory ef = GenericEntityFactory.instance(provider);
//
//		final Arguments arguments = entity.getArguments();
//		int size = arguments.wSize();
//    	IEntityIterator<?>[] runnableIterators = new IEntityIterator<?>[size];
//
//		if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Assignments, arguments)) {
//	    	for (int i=0; i<size; i++) {
//	    		Assign argument = ((Assignments) arguments).get(i);
//	    		String name = argument.getName().getValue();
//	    		argument.getExpression().accept(this);
//				runnableIterators[i] = getResultIterator();//FIXME
//			}			
//		} else if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Expressions, arguments)) {
//	    	for (int i=0; i<size; i++) {
//				((Expressions) arguments).get(i).accept(this);
//				runnableIterators[i] = getResultIterator();
//			}			
//		}
//
//    	setResultIterator(IteratorFactory.multiValuedRunnableIterator(new AbstractWorkflowsRunnable() {
//			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
//				EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.parseEntityDescriptor(typeName);
//				if (ed == null)
//					throw new IllegalArgumentException("The requested entity does not exist: "+typeName);
//
//				IEntity resultValue;
//				if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Assignments, arguments)) {
//					ResettableScope resettableScope = BindingManagerFactory.instance.createResettableScope();
//					bm.wEnterScope(resettableScope);
//
//					//FIXME
//					for (int i = 0; i < arguments.wSize(); i++) {
//						String name = ((Assignments) arguments).get(i).getName().getValue();
//						bm.wSet(name, EntityUtils.convert(bm.wGet(name), ed.getEntityDescriptor(i)));
//					}
//					resultValue = ef.create(ed, bm);
//
//					resettableScope.reset();
//					bm.wExitScope();
//				} else if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Expressions, arguments)) {
//					if (ed.getEntityKind().isData())
//						resultValue = DataTypeUtils.convert(argsEntities[0], ed);
//					else {
//						IEntity[] values = new IEntity[argsEntities.length];
//						for (int i = 0; i < values.length; i++)
//							values[i] = EntityUtils.convert(argsEntities[i], ed.getEntityDescriptor(i));
//						resultValue = ef.create(ed, values);
//					}
//				} else
//					resultValue = ef.create(ed);
//
//				setResult(bm, resultVariable, resultValue);
//			}
//    	}, runnableIterators).withDomainEntity(entity));
//	}

	@Override
	public void visit(CreateJavaClassInstance entity) {
    	final Variable resultVariable = entity.getResult();

		Expressions arguments = entity.getArguments();
		int size= arguments.wSize();
    	IEntityIterator<?>[] runnableIterators = new IEntityIterator<?>[2+size];

    	entity.getClassName().accept(this);
		runnableIterators[0] = getResultIterator();

		entity.getConstructor().accept(this);
		runnableIterators[1] = getResultIterator();

    	for (int i=0; i<size; i++) {
			arguments.get(i).accept(this);
			runnableIterators[2+i] = getResultIterator();
		}

    	setResultIterator(IteratorFactory.singleValuedRunnableIterator(new AbstractWorkflowsRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				String className = argsEntities[0].wStringValue();
				IEntity constructorData = argsEntities[1];

				Constructor<?> constructor;
				if (DataTypeUtils.getDataKind(constructorData).isString())
					constructor = JavaReflectUtils.getConstructor(
							className, constructorData.wStringValue(), ReflectionFactory.getClassLoader(bm));
				else
					constructor = (Constructor<?>) constructorData.wGetValue();

				Object[] arguments = toArguments(constructor.getParameterTypes(), constructor.isVarArgs(), argsEntities);
				Object resultValue = JavaReflectUtils.invokeConstructor(constructor, arguments);

				setResult(bm, resultVariable, resultValue, constructor.getDeclaringClass());
			}
    	}, runnableIterators).withSourceEntity(entity));
	}

	@Override
	public void visit(InvokeJavaClassMethod entity) {
    	final Variable resultVariable = entity.getResult();

		Expressions arguments = entity.getArguments();
		int size= arguments.wSize();
    	IEntityIterator<?>[] runnableIterators = new IEntityIterator<?>[2+size];

    	entity.getClassName().accept(this);
		runnableIterators[0] = getResultIterator();

		entity.getMethod().accept(this);
		runnableIterators[1] = getResultIterator();

    	for (int i=0; i<size; i++) {
			arguments.get(i).accept(this);
			runnableIterators[2+i] = getResultIterator();
		}

    	setResultIterator(IteratorFactory.multiValuedRunnableIterator(new AbstractWorkflowsRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				String className = argsEntities[0].wStringValue();
				IEntity methodData = argsEntities[1];
				
				Method method;
				if (DataTypeUtils.getDataKind(methodData).isString())
					method = JavaReflectUtils.getMethod(
							className, methodData.wStringValue(), ReflectionFactory.getClassLoader(bm));
				else
					method = (Method) methodData.wGetValue();

				Object[] arguments = toArguments(method.getParameterTypes(), method.isVarArgs(), argsEntities);
				Object resultValue = JavaReflectUtils.invokeMethod(null, method, arguments);

				setResult(bm, resultVariable, resultValue, method.getReturnType());
			}
    	}, runnableIterators).withSourceEntity(entity));
	}

	@Override
	public void visit(InvokeJavaInstanceMethod entity) {
    	final Variable resultVariable = entity.getResult();
    	final Variable instanceVariable = entity.getObject();

		Expressions arguments = entity.getArguments();
		int size= arguments.wSize();
    	IEntityIterator<?>[] runnableIterators = new IEntityIterator<?>[2+size];

    	entity.getClassName().accept(this);
		runnableIterators[0] = getResultIterator();

		entity.getMethod().accept(this);
		runnableIterators[1] = getResultIterator();

    	for (int i=0; i<size; i++) {
			arguments.get(i).accept(this);
			runnableIterators[2+i] = getResultIterator();
		}

    	setResultIterator(IteratorFactory.multiValuedRunnableIterator(new AbstractWorkflowsRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				String className = argsEntities[0].wStringValue();
				IEntity methodData = argsEntities[1];
				
				Method method;
				if (DataTypeUtils.getDataKind(methodData).isString())
					method = JavaReflectUtils.getMethod(
							className, methodData.wStringValue(), ReflectionFactory.getClassLoader(bm));
				else
					method = (Method) methodData.wGetValue();

				IEntity instanceEntity = bm.wGet(instanceVariable.getValue());
				if (instanceEntity == null)
					throw new MissingVariableException(instanceVariable.getValue()).withSourceEntity(getSourceEntity()).withBindings(getBindings());
				Object instance = DataTypeUtils.unbox(instanceEntity, method.getDeclaringClass(), false);
				Object[] arguments = toArguments(method.getParameterTypes(), method.isVarArgs(), argsEntities);
				Object resultValue = JavaReflectUtils.invokeMethod(instance, method, arguments);

				setResult(bm, resultVariable, resultValue, method.getReturnType());
			}
    	}, runnableIterators).withSourceEntity(entity));
	}

	@Override
	public void visit(Variable entity) {
		String varName = entity.getValue();
    	setResultIterator((varName.equals("self") ?
    			IteratorFactory.selfIterator() : IteratorFactory.variableIterator(varName)).withSourceEntity(entity));
	}

	@Override
	public void visit(BooleanLiteral entity) {
		setResultIterator(IteratorFactory.constantIterator(
				BindingManagerFactory.instance.createValue(entity.isValue()), true).withSourceEntity(entity));
	}

	@Override
	public void visit(IntLiteral entity) {
		setResultIterator(IteratorFactory.constantIterator(
				BindingManagerFactory.instance.createValue(entity.getValue()), true).withSourceEntity(entity));
	}

	@Override
	public void visit(StringLiteral entity) {
		setResultIterator(IteratorFactory.constantIterator(
				BindingManagerFactory.instance.createValue(entity.getValue()), true).withSourceEntity(entity));
	}
}
