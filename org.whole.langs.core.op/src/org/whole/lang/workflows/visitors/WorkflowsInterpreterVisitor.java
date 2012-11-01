/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Set;

import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.util.ResourceArtifactsOperations;
import org.whole.lang.artifacts.visitors.ArtifactsDeleteVisitor;
import org.whole.lang.artifacts.visitors.ArtifactsSynchronizerVisitor;
import org.whole.lang.artifacts.visitors.ArtifactsSynchronizerVisitor.Synchronize;
import org.whole.lang.artifacts.visitors.ArtifactsSynchronizerVisitor.Traverse;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.ResettableScope;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.codebase.URLPersistenceProvider;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.codebase.JavaClassTemplateFactory;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.java.util.JavaReflectUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.queries.iterators.QueriesIteratorFactory;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateFactory;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.MissingVariableException;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.workflows.model.Arguments;
import org.whole.lang.workflows.model.Assign;
import org.whole.lang.workflows.model.AssignActivity;
import org.whole.lang.workflows.model.Assignments;
import org.whole.lang.workflows.model.BooleanLiteral;
import org.whole.lang.workflows.model.Condition;
import org.whole.lang.workflows.model.ConditionalCase;
import org.whole.lang.workflows.model.CreateEntity;
import org.whole.lang.workflows.model.CreateJavaClassInstance;
import org.whole.lang.workflows.model.CreateModel;
import org.whole.lang.workflows.model.DeleteArtifacts;
import org.whole.lang.workflows.model.EmptyActivity;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.model.Expressions;
import org.whole.lang.workflows.model.ForeachLoop;
import org.whole.lang.workflows.model.IWorkflowsEntity;
import org.whole.lang.workflows.model.IntLiteral;
import org.whole.lang.workflows.model.InvokeJavaClassMethod;
import org.whole.lang.workflows.model.InvokeJavaInstanceMethod;
import org.whole.lang.workflows.model.InvokeOperation;
import org.whole.lang.workflows.model.InvokeQuery;
import org.whole.lang.workflows.model.LoadArtifacts;
import org.whole.lang.workflows.model.LoadJavaModel;
import org.whole.lang.workflows.model.LoadModel;
import org.whole.lang.workflows.model.Name;
import org.whole.lang.workflows.model.ObjectLiteral;
import org.whole.lang.workflows.model.OperationEnum;
import org.whole.lang.workflows.model.Parallel;
import org.whole.lang.workflows.model.Parse;
import org.whole.lang.workflows.model.PersistenceActivity;
import org.whole.lang.workflows.model.RegistryEnum;
import org.whole.lang.workflows.model.ResourceKind;
import org.whole.lang.workflows.model.ResourceKindEnum;
import org.whole.lang.workflows.model.SaveArtifacts;
import org.whole.lang.workflows.model.SaveModel;
import org.whole.lang.workflows.model.Sequence;
import org.whole.lang.workflows.model.StringLiteral;
import org.whole.lang.workflows.model.SwitchControl;
import org.whole.lang.workflows.model.SwitchTypeEnum;
import org.whole.lang.workflows.model.Task;
import org.whole.lang.workflows.model.Text;
import org.whole.lang.workflows.model.Unparse;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.WhileLoop;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WorkflowsInterpreterVisitor extends WorkflowsTraverseAllVisitor {
	@Override
	public InterpreterOperation getOperation() {
		return (InterpreterOperation) super.getOperation();
	}

    protected void setResult(Variable variable, IEntity model) {
    	if (DataTypeUtils.getDataKind(variable).isString())
    		getBindings().wDef(variable.getValue(), model);
    	setResult(model);
    }
    protected void setResult(Variable variable, Object resultValue, Class<?> resultType) {
		if (resultValue instanceof IEntityIterator) {
			setResultIterator((IEntityIterator<?>) resultValue);
		} else if (Void.TYPE.equals(resultType)) {
			if (EntityUtils.isNotResolver(variable))
				throw new IllegalArgumentException("cannot bind a void result");
			setResult(null);
		} else
			setResult(variable, box(resultValue, resultType));
	}

	protected String getResultString() {
    	return getResult().wStringValue();
    }
	protected Object getResultValue() {
    	return getResult().wGetValue();
    }
    protected void setResultValue(Object value) {
    	setResult(BindingManagerFactory.instance.createSpecificValue(value));
    }

	protected void evaluate(IWorkflowsEntity composite) {
		setResult(null);
		if (composite.wIsAdapter())
			CommonsInterpreterVisitor.visitAdapter((IEntityAdapter) composite, getOperation());
		else
			composite.accept(this);
	}

	public void visit(Task entity) {
		entity.getAssignments().accept(this);

		entity.getDescription().accept(this);
		String description = PrettyPrinterOperation.toPrettyPrintString(getResult());

		Reader reader = getOperation().getReader();

		try {
			if (!reader.ready()) {
				PrintWriter printWriter = getOperation().getPrintWriter();
				printWriter.println(description);
				printWriter.println("Confirm task completion[Yes/no]: ");
				printWriter.flush();
			}
			BufferedReader bufferedReader = new BufferedReader(reader);
			if (bufferedReader.readLine().equalsIgnoreCase("no"))
				throw new VisitException("task not completed: "+description);
		} catch (IOException e) {
			throw new VisitException(e);
		}
	}
	
	@Override
	public void visit(Sequence entity) {
		entity.getFlowObjects().accept(this);
	}
	@Override
	public void visit(Parallel entity) {
		entity.getFlowObjects().accept(this);
	}

//TODO ? remove from interpreter or add to model ?
//	public void visit(Repeat entity) {
//		for (int i=0; i<entity.getTimes().wIntValue(); i++)
//			entity.getFlowObject().accept(this);
//	}

	public void visit(WhileLoop entity) {
		Condition condition = entity.getCondition();
		while (BehaviorUtils.evaluatePredicate(condition, 0, getBindings())) {
			handleCancelRequest();

			entity.getFlowObject().accept(this);
		}
	}

	protected void resetIterator(IEntityIterator<?> iterator) {
		IEntity selfEntity = getBindings().wGet("self");
		iterator.reset(selfEntity != null ? selfEntity : NullEntity.instance);
	}

	@Override
	public void visit(ForeachLoop entity) {
		evaluate(entity.getCompositeVariable());

		IEntityIterator<?> iterator = null;
		if (isResultIterator()) {
			iterator = getResultIterator();
			setResultIterator(null);
			resetIterator(iterator);
		} else {
			IEntity result = getResult();
			if (result == null)
				return;
			
			iterator = IteratorFactory.childIterator();
			iterator.reset(result);
		}

		Variable elementVariable = entity.getElementVariable();
		String elementVar = DataTypeUtils.getDataKind(elementVariable).isString() ?
				elementVariable.wStringValue() : null;
		Variable indexVariable = entity.getIndexVariable();
		String indexVar = DataTypeUtils.getDataKind(indexVariable).isString() ?
				indexVariable.wStringValue() : null;

		int index = 0;
		while (iterator.hasNext()) {
			handleCancelRequest();

			if (indexVar != null)
				getBindings().wDefValue(indexVar, index++); 
			if (elementVar != null)
				getBindings().wDef(elementVar, iterator.next());
			entity.getFlowObject().accept(this);
		}
	}

	@Override
	public void visit(SwitchControl entity) {
		boolean isExclusive = entity.getSwitchType().wContainsValue(SwitchTypeEnum.exclusive);

		IEntityIterator<ConditionalCase> i = IteratorFactory.childIterator();
		i.reset(entity.getConditionalCases());

		boolean executed = false;
		while ((!isExclusive || !executed) && i.hasNext()) {
			i.next().accept(this);
			executed |= getResult().wBooleanValue();
		}

		if (!executed)
			entity.getDefaultCase().accept(this);
	}

//TODO ? remove from interpreter or add to model ?
//	public void visit(DoWhileControl entity) {
//		do {
//			entity.getFlowObject().accept(visitor1);
//		} while (booleanValue(entity.getCondition()));
//	}

	public void visit(ConditionalCase entity) {
		Condition condition = entity.getCondition();
		boolean isSatisfied = BehaviorUtils.evaluatePredicate(condition, 0, getBindings());
		if (isSatisfied)
			entity.getFlowObject().accept(this);
		setResultValue(isSatisfied);
	}

//TODO ? remove from interpreter or add to model ?
//	public void visit(IfElseControl entity) {
//		if (booleanValue(entity.getCondition()))
//			entity.getTrueFlowObject().accept(visitor1);
//		else
//			entity.getFalseFlowObject().accept(visitor1);
//	}

	@Override
	public void visit(BooleanLiteral entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.wBooleanValue()));
	}
	@Override
	public void visit(IntLiteral entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.wIntValue()));
	}

	@Override
	public void visit(StringLiteral entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.wStringValue()));
	}

	@Override
	public void visit(ObjectLiteral entity) {
		setResult(entity);
	}

	@Override
	public void visit(Name entity) {
		setResult(entity);
	}

	@Override
	public void visit(Text entity) {
		setResult(BindingManagerFactory.instance.createValue(entity.wStringValue()));
	}

	@Override
	public void visit(Variable entity) {
		IEntity result = getBindings().wGet(entity.getValue());
		if (result == null)
			throw new MissingVariableException(entity.getValue());

		setResult(result);
	}

	@Override
	public void visit(EmptyActivity entity) {
	}

	@Override
	public void visit(AssignActivity entity) {
		entity.getAssignments().accept(this);
	}

	@Override
	public void visit(Assignments entity) {
		define(getBindings(), entity);
	}

	public void define(IBindingScope bm, Assignments assignments) {
		for (int i = 0; i < assignments.wSize(); i++)
			define(bm, assignments.get(i));
	}
	public void define(IBindingScope bm, Assign entity) {
		String name = entity.getName().getValue();
		evaluate(entity.getExpression());
		
		if (isResultIterator()) {
			IEntityIterator<?> iterator = getResultIterator();
			setResultIterator(null);
			resetIterator(iterator);
			if (iterator.hasNext()) {
				IEntity first = iterator.next();
				if (iterator.hasNext()) {
					bm.wDef(name, BindingManagerFactory.instance.createTuple());
					bm.wAdd(name, first);
					do {
						bm.wAdd(name, iterator.next());
					} while (iterator.hasNext());
				} else
					bm.wDef(name, first);
			}
		} else if (getResult() != null) 
			bm.wDef(name, getResult());
	}

	@Override
	public void visit(InvokeOperation entity) {
		IBindingManager bm = getBindings();
		bm.wEnterScope();

		entity.getBindings().accept(this);

		entity.getModel().accept(this);
		IEntity model = getResult();

		switch (entity.getOperation().getValue().getOrdinal()) {
		case OperationEnum.VALIDATOR_ord:
			ValidatorOperation.validate(model, bm);
			break;
		case OperationEnum.NORMALIZER_ord:
			NormalizerOperation.normalize(model, bm);
			break;
		case OperationEnum.PRETTY_PRINTER_ord:
			PrettyPrinterOperation.prettyPrint(model, bm);
			break;
		case OperationEnum.INTERPRETER_ord:
			InterpreterOperation.interpret(model, bm, (Reader) null, (Writer) null);
			break;
		case OperationEnum.ARTIFACTS_GENERATOR_ord:
			ArtifactsGeneratorOperation.generate(model, bm);
			break;
		case OperationEnum.JAVA_COMPILER_ord:
			performJavaCompilerOperation(model);
		}

		bm.wExitScope();

		//FIXME workaround
		if (OperationEnum.NORMALIZER == entity.getOperation().getValue())
			bm.setResult(model);
	}

	protected  void performJavaCompilerOperation(IEntity model) {
		throw new UnsupportedOperationException("The Eclipse JDT is not available");
	}

	@Override
	public void visit(InvokeQuery entity) {
		Variable queryName = entity.getQueryName();
		Arguments arguments = entity.getArguments();

		IEntityIterator<?>[] argsIterators = new IEntityIterator<?>[0];

		Set<String> filterNames = getOperation().getResultsScope().wNames();
		IBindingManager args = BindingManagerFactory.instance.createBindingManager(
				BindingManagerFactory.instance.createExcludeFilterScope(
						getBindings(), filterNames),
						getBindings().wGetEnvironmentManager());

		if (!EntityUtils.isNotResolver(arguments)) {
			setResultValue(argsIterators);
			arguments.accept(this);
			argsIterators = (IEntityIterator<?>[]) getResultValue();
		} else if (Matcher.match(WorkflowsEntityDescriptorEnum.Expressions, arguments)) {
			argsIterators = new IEntityIterator<?>[arguments.wSize()];
			for (int i = 0; i < argsIterators.length; i++) {
				((Expressions) arguments).get(i).accept(this);
				argsIterators[i] = getResultIterator();
				setResultIterator(null);
			}
		} else
			define(args, (Assignments) arguments);

		IEntityIterator<?> iterator = QueriesIteratorFactory.callIterator(
				queryName.getValue(), argsIterators);
		iterator.setBindings(args);
		resetIterator(iterator);
		while (iterator.hasNext())
			iterator.next();
	}

	@Override
	public void visit(CreateEntity entity) {
		entity.getEntityName().accept(this);
		String typeName = getResultString();
		EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.parseEntityDescriptor(typeName);
		if (ed == null)
			throw new IllegalArgumentException("The requested entity does not exist: "+typeName);

		IEntityRegistryProvider provider = null;
		switch (entity.getRegistry().getValue().getOrdinal()) {
		case RegistryEnum.DEFAULT_ord:
			provider = RegistryConfigurations.DEFAULT;
			break;
		case RegistryEnum.RESOLVER_ord:
			provider = RegistryConfigurations.RESOLVER;
			break;
		case RegistryEnum.ADAPTER_ord:
			provider = RegistryConfigurations.ADAPTER;
			break;
		case RegistryEnum.STRICT_ord:
			provider = RegistryConfigurations.STRICT;
			break;
		case RegistryEnum.CUSTOM_ord:
			provider = RegistryConfigurations.CUSTOM;
			break;
		}
		IEntityFactory ef = GenericEntityFactory.instance(provider);
		IEntity model;

		Arguments arguments = entity.getArguments();
		if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Assignments, arguments)) {
			ResettableScope resettableScope = BindingManagerFactory.instance.createResettableScope();
			getBindings().wEnterScope(resettableScope);

			arguments.accept(this);
			for (int i = 0; i < arguments.wSize(); i++) {
				String name = ((Assignments) arguments).get(i).getName().getValue();
				getBindings().wSet(name, EntityUtils.convert(getBindings().wGet(name), ed.getEntityDescriptor(i)));
			}
			model = ef.create(ed, getBindings());

			resettableScope.reset();
			getBindings().wExitScope();
		} else if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Expressions, arguments)) {
			if (ed.getEntityKind().isData()) {
				((Expressions) arguments).get(0).accept(this);
				model = DataTypeUtils.convert(getResult(), ed);
			} else {
				IEntity[] values = new IEntity[arguments.wSize()];
				for (int i = 0; i < values.length; i++) {
					((Expressions) arguments).get(i).accept(this);
					values[i] = EntityUtils.convert(getResult(), ed.getEntityDescriptor(i));
				}
				model = ef.create(ed, values);
			}
		} else
			model = ef.create(ed);

		setResult(entity.getModel(), model);
	}
	@Override
	public void visit(CreateModel entity) {
		ResettableScope resettableScope = BindingManagerFactory.instance.createResettableScope();
		getBindings().wEnterScope(resettableScope);

		entity.getBindings().accept(this);

		entity.getTemplate().accept(this);
		IEntity model = getResult();
		//TODO remove ?
		if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Name, entity.getTemplate())) {
			IEntityIterator<IEntity> tii = QueriesIteratorFactory.templateInterpreterIterator(getResult());
			tii.reset(entity);
			tii.setBindings(getBindings());
			model = tii.next();
		}

		resettableScope.reset();
		getBindings().wExitScope();

		setResult(entity.getModel(), model);
	}

	@Override
	public void visit(LoadJavaModel entity) {
		IEntity model = getJavaTemplateFactory(entity).create();

		setResult(entity.getModel(), model);
	}

	protected ITemplateFactory<CompilationUnit> getJavaTemplateFactory(LoadJavaModel entity) {
		entity.getClassName().accept(this);
		String className = getResultString();

		if (!Matcher.matchImpl(WorkflowsEntityDescriptorEnum.ClassPath, entity.getClassProvider()))
			throw new UnsupportedOperationException("The Eclipse Workspace is not available");

		try {
			return new JavaClassTemplateFactory(className);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(DeleteArtifacts entity) {
		entity.getModel().accept(this);
		IArtifactsEntity model = (IArtifactsEntity) getResult();

		entity.getRootResource().accept(this);
		String resource = getResultString();
		ResourceKind resourceKind = entity.getRootResourceKind();

		IBindingManager bindings = createArtifactsBindings(resource, resourceKind);

		ArtifactsDeleteVisitor.delete(model, bindings);
	}

	@Override
	public void visit(LoadArtifacts entity) {
		IArtifactsEntity model = null;
		Variable variable = entity.getModel();
		String variableName = variable.getValue();
		boolean isDefined = getBindings().wIsSet(variableName);
		if (isDefined) {
			variable.accept(this);
			model = (IArtifactsEntity) getResult();
		}

		entity.getRootResource().accept(this);
		String resource = getResultString();
		ResourceKind resourceKind = entity.getRootResourceKind();

		Traverse traverse = Traverse.valueOf(
				DataTypeUtils.getAsPersistenceString(entity.getTraversalStrategy()));
		Synchronize synchronize = Synchronize.valueOf(
				DataTypeUtils.getAsPersistenceString(entity.getSynchronizeStrategy()));

		IPersistenceKit defaultPersistenceKit = getPersistenceKit(entity.getDefaultPersistence());

		IArtifactsEntity result = ArtifactsSynchronizerVisitor.synchronize(
				model, traverse, synchronize, createArtifactsBindings(resource, resourceKind),
				defaultPersistenceKit, true);

		if (isDefined) {
			if (EntityUtils.hasParent(model))
				model.wGetParent().wSet(model, result);
			getBindings().wSet(variableName, result);
		} else
			getBindings().wDef(variableName, result);
	}

	@Override
	public void visit(SaveArtifacts entity) {
		entity.getModel().accept(this);
		IArtifactsEntity model = (IArtifactsEntity) getResult();

		entity.getRootResource().accept(this);
		String resource = getResultString();
		ResourceKind resourceKind = entity.getRootResourceKind();

		Traverse traverse = Traverse.valueOf(
				DataTypeUtils.getAsPersistenceString(entity.getTraversalStrategy()));
		Synchronize synchronize = Synchronize.valueOf(
				DataTypeUtils.getAsPersistenceString(entity.getSynchronizeStrategy()));

		IPersistenceKit defaultPersistenceKit = getPersistenceKit(entity.getDefaultPersistence());

		ArtifactsSynchronizerVisitor.synchronize(
					model, traverse, synchronize,
						createArtifactsBindings(resource, resourceKind),
							defaultPersistenceKit, false);
	}

	protected IBindingManager createArtifactsBindings(String resource, ResourceKind resourceKind) {
		if (ResourceKindEnum.WORKSPACE.equals(resourceKind.getValue()))
			throw new UnsupportedOperationException("The Eclipse Workspace is not available");

		File rootResource = new File(resource);
		if (!rootResource.exists())
			throw new IllegalArgumentException("root resource does not exist");

		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		bindings.wDefValue("artifactsOperations", new ResourceArtifactsOperations());
		bindings.wDefValue("rootResource", rootResource);
		bindings.wDefValue("folder", rootResource.getParentFile());
		bindings.wDefValue("folderLocation", rootResource.getParent());
		bindings.wDef("resourceKind", resourceKind);
		return bindings;
	}

	@Override
	public void visit(LoadModel entity) {
		IPersistenceKit persistenceKit = getPersistenceKit(entity.getPersistence());

		IPersistenceProvider provider = getPersistenceProvider(entity, true);

		try {
			IEntity model = persistenceKit.readModel(provider);
			setResult(entity.getModel(), model);
		} catch (Exception e) {
			throw new IllegalArgumentException("Failed to load the resource with the given persistence: "
					+getResourceString(entity)+", "+getPersistenceId(entity.getPersistence()), e);
		}
	}
	@Override
	public void visit(SaveModel entity) {
		IPersistenceKit persistenceKit = getPersistenceKit(entity.getPersistence());

		IPersistenceProvider provider = getPersistenceProvider(entity, false);

		entity.getModel().accept(this);
		IEntity model = getResult();

		try {
			persistenceKit.writeModel(model, provider);
			afterWriteModel(entity, provider);
		} catch (Exception e) {
			throw new IllegalArgumentException("Failed to save the resource with the given persistence: "
					+getResourceString(entity)+", "+getPersistenceId(entity.getPersistence()), e);
		}
	}
	protected String getResourceString(PersistenceActivity entity) {
		ResourceKind resourceKind = EntityUtils.safeGet(entity.getResourceKind(), ResourceKindEnum.FILE_SYSTEM);
		if (resourceKind.wContainsValue(ResourceKindEnum.VARIABLE)) {
			Variable variable = (Variable) entity.getResource();
			return variable.getValue();
		} else {
			entity.getResource().accept(this);
			return getResultString();
		}
	}
	protected String getPersistenceId(Expression entity) {
		try {
			entity.accept(this);
			return getResultString();
		} catch (Exception e) {
			return null;
		}
	}
	protected IPersistenceKit getPersistenceKit(Expression entity) {
		try {
			String persistenceId = getPersistenceId(entity);
			return ReflectionFactory.hasPersistenceKit(persistenceId) ? ReflectionFactory.getPersistenceKit(persistenceId) : null;
		} catch (Exception e) {
			return null;
		}
	}
	protected void afterWriteModel(SaveModel entity, IPersistenceProvider provider) throws Exception {
		if (entity.getResourceKind().wContainsValue(ResourceKindEnum.VARIABLE)) {
			String result = ((StringPersistenceProvider) provider).getStore();		
			Variable variable = (Variable) entity.getResource();
			getBindings().wDefValue(variable.getValue(), result);
		}
	}
	protected IPersistenceProvider getPersistenceProvider(PersistenceActivity entity, boolean isInput) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		getBindings().wEnterScope(bm, true);
		entity.getBindings().accept(this);
		getBindings().wExitScope();
		
		String resource = getResourceString(entity);

		ResourceKind resourceKind = EntityUtils.safeGet(entity.getResourceKind(), ResourceKindEnum.FILE_SYSTEM);
		switch (resourceKind.getValue().getOrdinal()) {
		case ResourceKindEnum.FILE_SYSTEM_ord:
			return getFileSystemProvider(bm, resource, isInput);
		case ResourceKindEnum.WORKSPACE_ord:
			return getWorkspaceProvider(bm, resource, isInput);
		case ResourceKindEnum.CLASSPATH_ord:
			ReflectionFactory.setClassLoader(bm, ReflectionFactory.getClassLoader(getBindings()));
			return getClasspathProvider(bm, resource, isInput);
		case ResourceKindEnum.URL_ord:
			return getURLProvider(bm, resource, isInput);
		case ResourceKindEnum.VARIABLE_ord:
			return getStringProvider(bm, resource, isInput);
		default:
			throw new IllegalArgumentException("Unsupported resource kind");
		}
	}
	protected IPersistenceProvider getFileSystemProvider(IBindingManager bm, String resourceString, boolean isInput) {
		try {
			return new FilePersistenceProvider(new File(resourceString), bm);
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot access the resource: "+resourceString, e);
		}
	}
	protected IPersistenceProvider getURLProvider(IBindingManager bm, String resourceString, boolean isInput) {
//		if (isInput)
			try {
				return new URLPersistenceProvider(new URL(resourceString), bm);
			} catch (Exception e) {
				throw new IllegalArgumentException("Cannot load the specified resource", e);
			}
//		else
//			throw new UnsupportedOperationException("Save model to a URL not implemented yet");
	}
	protected IPersistenceProvider getStringProvider(IBindingManager bm, String resourceString, boolean isInput) {
		return new StringPersistenceProvider(getBindings().wIsSet(resourceString) ? getBindings().wStringValue(resourceString) : "", bm);
	}
	protected IPersistenceProvider getWorkspaceProvider(IBindingManager bm, String resourceString, boolean isInput) {
		throw new UnsupportedOperationException("The Eclipse Workspace is not available");
	}
	protected IPersistenceProvider getClasspathProvider(IBindingManager bm, String resourceString, boolean isInput) {
		if (isInput)
			return new ClasspathPersistenceProvider(resourceString, bm);
		else
			throw new UnsupportedOperationException("Cannot save the specified resource");
	}

	@Override
	public void visit(Parse entity) {
		entity.getText().accept(this);
		CharSequence text = (CharSequence) getResultValue();

		entity.getGrammar().accept(this);
		IEntity grammarOrUri = getResult();
		if (!EntityUtils.isData(grammarOrUri)) {
			stagedVisit(grammarOrUri);
			grammarOrUri = ((Grammar) grammarOrUri).getUri();
		}
		String grammarUri = grammarOrUri.wStringValue();

		IEntity model;
		if (EntityUtils.isNotResolver(entity.getNt())) {
			entity.getNt().accept(this);
			model = GrammarsUtils.parse(text, grammarUri, getResult().wStringValue());
		} else
			model = GrammarsUtils.parse(text, grammarUri);

		setResult(entity.getModel(), model);
	}
	@Override
	public void visit(Unparse entity) {
		entity.getGrammar().accept(this);
		IEntity grammarOrUri = getResult();
		if (!EntityUtils.isData(grammarOrUri)) {
			stagedVisit(grammarOrUri);
			grammarOrUri = ((Grammar) grammarOrUri).getUri();
		}
		String grammarUri = grammarOrUri.wStringValue();

		entity.getModel().accept(this);
		IEntity model = getResult();

		Expression text = entity.getText();
		Appendable appendable = new StringBuilder();
		boolean hasAppendable = false;

		String variableName = null;
		if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Variable, text)) {
			variableName = ((Variable) text).getValue();
			if (getBindings().wIsSet(variableName)) {
				try {
					appendable = (Appendable) getBindings().wGetValue(variableName);
					hasAppendable = true;
				} catch (Exception e) {
					throw new IllegalArgumentException("The text of an Unparse activity must be an Appendable", e);
				}
			}
		} else if (EntityUtils.isNotResolver(text)) {
			text.accept(this);
			appendable = (Appendable) getResultValue();
			hasAppendable = true;
		}

		//TODO if (EntityUtils.isImpl(entity.getNt())) {

		GrammarsUtils.unparse(model, appendable, grammarUri);

		IEntity resultEntity = hasAppendable ? BindingManagerFactory.instance.createValue(appendable) :
				BindingManagerFactory.instance.createValue(appendable.toString());

		if (variableName != null && !getBindings().wIsSet(variableName))
			getBindings().wDef(variableName, resultEntity);

		setResult(resultEntity);
	}

	@Override
	public void visit(CreateJavaClassInstance entity) {
		entity.getClassName().accept(this);
		String className = getResultString();

		entity.getConstructor().accept(this);
		IEntity constructorData = getResult();
		Constructor<?> constructor;
		if (DataTypeUtils.getDataKind(constructorData).isString())
			constructor = JavaReflectUtils.getConstructor(
					className, constructorData.wStringValue(), ReflectionFactory.getClassLoader(getBindings()));
		else
			constructor = (Constructor<?>) constructorData.wGetValue();

		Object[] arguments = toArguments(constructor.getParameterTypes(),
				constructor.isVarArgs(), entity.getArguments());
		Object resultValue = JavaReflectUtils.invokeConstructor(constructor, arguments);

		setResult(entity.getResult(), resultValue, constructor.getDeclaringClass());
	}
	@Override
	public void visit(InvokeJavaClassMethod entity) {
		entity.getClassName().accept(this);
		String className = getResultString();

		entity.getMethod().accept(this);
		IEntity methodData = getResult();
		Method method;
		if (DataTypeUtils.getDataKind(methodData).isString())
			method = JavaReflectUtils.getMethod(
					className, methodData.wStringValue(), ReflectionFactory.getClassLoader(getBindings()));
		else
			method = (Method) methodData.wGetValue();

		Object[] arguments = toArguments(method.getParameterTypes(),
				method.isVarArgs(), entity.getArguments());
		Object resultValue = JavaReflectUtils.invokeMethod(null, method, arguments);

		setResult(entity.getResult(), resultValue, method.getReturnType());
	}

	@Override
	public void visit(InvokeJavaInstanceMethod entity) {
		entity.getClassName().accept(this);
		String className = getResultString();

		entity.getMethod().accept(this);
		IEntity methodData = getResult();
		Method method;
		if (DataTypeUtils.getDataKind(methodData).isString())
			method = JavaReflectUtils.getMethod(
					className, methodData.wStringValue(), ReflectionFactory.getClassLoader(getBindings()));
		else
			method = (Method) methodData.wGetValue();

		Object[] arguments = toArguments(method.getParameterTypes(),
				method.isVarArgs(), entity.getArguments());
		Variable object = entity.getObject();
		Object instance = unbox(method.getDeclaringClass(), object, false);
		Object resultValue = JavaReflectUtils.invokeMethod(instance, method, arguments);

		setResult(entity.getResult(), resultValue, method.getReturnType());
	}

	private Object unbox(Class<?> parameterType, Expression expression) {
		return unbox(parameterType, expression, true);
	}
	private Object unbox(Class<?> parameterType, Expression expression, boolean unboxResolver) {
		setResult(null);
		expression.accept(this);
		IEntity result = getResult();
		if (result == null)
			throw new IllegalArgumentException("cannot evaluate expression: "+expression);
		return DataTypeUtils.unbox(result, parameterType, unboxResolver);
	}
	private IEntity box(Object value, Class<?> resultType) {
		if (value == null && !IEntity.class.isAssignableFrom(resultType))
			return BindingManagerFactory.instance.createSpecificValue(
					value, DataTypeUtils.toDataKind(resultType));
		else
			return DataTypeUtils.box(value, CommonsEntityDescriptorEnum.Any);
	}

	private Object[] toArguments(Class<?>[] parameterTypes, boolean varArgs, Expressions expressions) {
		if (!EntityUtils.isNotResolver(expressions)) {
			setResultValue(new Object[0]);
			expressions.accept(this);
			return (Object[]) getResultValue();
		}

		int expressionsSize = expressions.wSize();
		if (expressionsSize < parameterTypes.length)
			throw new IllegalArgumentException("wrong parameter number");
		
		Object[] parameters = new Object[parameterTypes.length];
		
		// map simple parameters
		int length = parameterTypes.length - (varArgs ? 1 : 0);
		for (int i = 0; i < length; i++)
			parameters[i] = unbox(parameterTypes[i], expressions.get(i));
		
		// map varArgs parameters
		if (varArgs) {
			Class<?> parameterType = parameterTypes[length].getComponentType();
			Object varArgsArray = Array.newInstance(parameterType,
					expressionsSize - length);
			for (int j = 0, i = length; i < expressionsSize; i++, j++)
				Array.set(varArgsArray, j, unbox(parameterType, expressions.get(i)));
			
			parameters[length] = varArgsArray;
		}
		return parameters;
	}
}
