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
package org.whole.lang.bindings;

import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;
import org.whole.lang.visitors.MissingVariableException;

/**
 * @author Riccardo Solmi
 */
public class BindingManagerFactory {
	public static BindingManagerFactory instance = new BindingManagerFactory();
	private BindingManagerFactory() {
	}

	private EntityDescriptorEnum edEnum;
	private EntityDescriptorEnum getEdEnum() {
		if (edEnum == null)
			edEnum = EntityUtils.getEnvironmentLanguageKit().getEntityDescriptorEnum();
		return edEnum;
	}
	private FeatureDescriptorEnum fdEnum;
	private FeatureDescriptorEnum getFdEnum() {
		if (fdEnum == null)
			fdEnum = EntityUtils.getEnvironmentLanguageKit().getFeatureDescriptorEnum();
		return fdEnum;
	}
	private EntityDescriptor<?> voidEd;
	private EntityDescriptor<?> getVoidEd() {
		if (voidEd == null)
			voidEd = getEdEnum().valueOf("Void");
		return voidEd;
	}

	public IEnvironmentManager createEnvironmentManager() {
		return new EnvironmentManager();
	}

	public IBindingManager createArguments() {
		IBindingManager args = createEnvironmentManager().createEnvironment("env");
		args.wEnterScope();
		return args;
	}
	public IBindingManager createBindingManager() {
		IBindingManager args = createEnvironmentManager().createEnvironment("bm");
		return args;
	}
	public IBindingManager createBindingManager(IBindingScope scope, IEnvironmentManager em) {
		return new BindingManager(em, scope);
	}

	public IBindingScope createSimpleScope() {
		return new SimpleScope();
	}

	public INestableScope createNestedScope(IBindingScope scope, boolean dynamic) {
		return dynamic ? new NestedDynamicScope(scope) : new NestedStaticScope(scope);
	}
	//Same behavior of createNestedScope(createSimpleScope(), true)
	public INestableScope createNestedDynamicSimpleScope() {
		return new NestedDynamicSimpleScope();
	}

	public AbstractFilterScope createIncludeFilterScope(Set<String> names) {
		return new IncludeFilterScope(names);
	}
	public AbstractFilterScope createIncludeReadOnlyFilterScope(Set<String> names) {
		return new IncludeReadOnlyFilterScope(names);
	}
	public AbstractFilterScope createExcludeFilterScope(Set<String> names) {
		return new ExcludeFilterScope(names);
	}
	public AbstractFilterScope createExcludeFilterSimpleScope() {
		return createExcludeFilterScope(new HashSet<String>()).wWithEnclosingScope(createSimpleScope());
	}

	public ITransactionScope createTransactionScope() {
		return new EarlyTransactionScope();
	}

	public IBindingScope createVoidScope() {
		return VoidScope.instance;
	}

	public IBindingScope createEntityScope(IEntity entity) {
		return new EntityScope(entity);
	}

	@SuppressWarnings("unchecked")
	public IBindingScope createJavaBeanScope(Object bean) {
//workaround for Android compatibility
//was		return new JavaBeanScope(bean);
		try {
			Class<IBindingScope> clazz = (Class<IBindingScope>) Class.forName("org.whole.lang.bindings.JavaBeanScope", true, ReflectionFactory.getPlatformClassLoader());
			Constructor<IBindingScope> constructor = clazz.getConstructor(Object.class);
			return constructor.newInstance(bean);
		} catch (Exception e) {
			throw new IllegalStateException("cannot istantiate a JavaBeanScope", e);
		}
	}


	public RuntimeException createNoBindingException(String name) {
		return new MissingVariableException("Binding is undefined: ", null, name);
	}

	public IEntity createValue(boolean value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("BooleanData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(byte value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("ByteData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(char value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("CharData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(double value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("DoubleData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(float value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("FloatData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(int value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("IntData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(long value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("LongData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(short value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("ShortData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(String value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("StringData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(Date value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("DateData"));
		entity.wSetValue(value);
		return entity;
	}
	public IEntity createValue(EnumValue value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("ObjectData")); //TODO ?
		entity.wSetValue((Object) value);
		return entity;
	}
	public IEntity createValue(Object value) {
		IEntity entity = GenericEntityFactory.instance.create(
				getEdEnum().valueOf("ObjectData"));
		entity.wSetValue(value);
		return entity;
	}

	public IEntity createSpecificValue(Object value) {
		return createSpecificValue(value, DataTypeUtils.toUnboxedDataKind(value));
	}
	public IEntity createSpecificValue(Object value, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BOOLEAN:
			return createValue(((Boolean) value).booleanValue());
		case BYTE:
			return createValue(((Byte) value).byteValue());
		case CHAR:
			return createValue(((Character) value).charValue());
		case DOUBLE:
			return createValue(((Double) value).doubleValue());
		case FLOAT:
			return createValue(((Float) value).floatValue());
		case INT:
			return createValue(((Integer) value).intValue());
		case LONG:
			return createValue(((Long) value).longValue());
		case SHORT:
			return createValue(((Short) value).shortValue());
		case DATE:
			return createValue((Date) value);
		case ENUM_VALUE:
			return createValue((EnumValue) value);
		case STRING:
			return createValue((String) value);
		case OBJECT:
		default:
			return createValue(value);
		}
	}
	public IEntity createSpecificValue(IEntity dataEntity) {
		switch (DataTypeUtils.getDataKind(dataEntity)) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BOOLEAN:
			return createValue(dataEntity.wBooleanValue());
		case BYTE:
			return createValue(dataEntity.wByteValue());
		case CHAR:
			return createValue(dataEntity.wCharValue());
		case DOUBLE:
			return createValue(dataEntity.wDoubleValue());
		case FLOAT:
			return createValue(dataEntity.wFloatValue());
		case INT:
			return createValue(dataEntity.wIntValue());
		case LONG:
			return createValue(dataEntity.wLongValue());
		case SHORT:
			return createValue(dataEntity.wShortValue());
		case DATE:
			return createValue(dataEntity.wDateValue());
		case ENUM_VALUE:
			return createValue(dataEntity.wEnumValue());
		case STRING:
			return createValue(dataEntity.wStringValue());
		case OBJECT:
		default:
			return createValue(dataEntity.wGetValue());
		}
	}

	public IEntity createTuple(boolean withContainment) {
		IEntityFactory ef = GenericEntityFactory.instance;
		return ef.create(getEdEnum().valueOf(withContainment ? "ContainmentTuple" : "Tuple"));		
	}
	public IEntity createTuple() {
		return createTuple(false);		
	}
	public IEntity createTuple(boolean withContainment, IEntity... values) {
		IEntityFactory ef = GenericEntityFactory.instance;
		return ef.create(getEdEnum().valueOf(withContainment ? "ContainmentTuple" : "Tuple"), values);		
	}
	public IEntity createTuple(IEntity... values) {
		return createTuple(false, values);		
	}

	public IEntity createVoid() {
		return GenericEntityFactory.instance.create(
				getVoidEd());
	}
	public boolean isVoid(IEntity entity) {
		return Matcher.match(getVoidEd(), entity);
	}

	public IEntity createContextViewModel(IBindingManager bm, IBindingScope scope) {
		IEntityFactory ef = GenericEntityFactory.instance;
		return ef.create(getEdEnum().valueOf("ContextViewModel"),
				ef.create(getEdEnum().valueOf("Environments")),
				ef.create(getEdEnum().valueOf("Bindings")));
	}

	public IEntity createSampleViewModel(IEntity behavior, IEntity result) {
		IEntityFactory ef = GenericEntityFactory.instance;
		return ef.create(getEdEnum().valueOf("SampleViewModel"), behavior, result);
	}

	public IEntity createVariablesViewModel(IOperation operation, Set<String> includeNames) {
		return createVariablesViewModel(operation.getOperationEnvironment(), includeNames);
	}
	public IEntity createVariablesViewModel(IBindingManager bm, Set<String> includeNames) {
		IEntityFactory ef = GenericEntityFactory.instance;
		IEntity environments = ef.create(getEdEnum().valueOf("Environments"));
		
		environments.wAdd(createEnvironment(bm, "env", includeNames, createFlatBindingsModel(bm)));

		return ef.create(getEdEnum().valueOf("VariablesViewModel"),
				ef.create(getEdEnum().valueOf("EnvironmentManager"), (Object) bm.wGetEnvironmentManager()),
				environments);
	}

	public IEntity createEnvironment(IBindingManager bm, String name, Set<String> includeNames, IEntity bindingsModel) {
		IEntityFactory ef = GenericEntityFactory.instance;
		return ef.create(getEdEnum().valueOf("Environment"),
				ef.create(getEdEnum().valueOf("Name"), name),
				createNames(includeNames),
				ef.create(getEdEnum().valueOf("BindingManager"), (Object) bm),
				bindingsModel);
	}

	public IEntity createNames(Set<String> includeNames) {
		IEntityFactory ef = GenericEntityFactory.instance;
		IEntity names = ef.create(getEdEnum().valueOf("Names"));
		
		for (String name : includeNames)
			names.wAdd(ef.create(getEdEnum().valueOf("Name"), name));
		return names;
	}

	public IEntity createFlatScopedBindingsModel(IBindingManager bm) {
		IEntityFactory ef = GenericEntityFactory.instance;
		IEntity scopedBindings = ef.create(getEdEnum().valueOf("ScopedBindings"));

		IBindingScope scope = bm;
		Map<String, IEntity> bindingsMap = new TreeMap<String, IEntity>();

		do {
			for (String name : scope.wLocalNames()) {
				IEntity value = scope.wGet(name);
				if (value == null)
					continue;
				if (!bindingsMap.containsKey(name))
					bindingsMap.put(name, value);
			}
			
			IEntity sourceEntity = scope.getSourceEntity();
			if (sourceEntity != null || scope.wEnclosingScope() == NullScope.instance) {
				int i=0;
				for (Map.Entry<String, IEntity> entry : bindingsMap.entrySet())
					scopedBindings.wAdd(i++, createBinding(entry.getKey(), entry.getValue()));

				bindingsMap.clear();

				scopedBindings.wAdd(0, ef.create(getEdEnum().valueOf("Scope"),
						ef.create(getEdEnum().valueOf("BindingScope"), (Object) scope),
						ef.create(getEdEnum().valueOf("Value"), (Object) scope.getSourceEntity())));
			}
		} while ((scope = scope.wEnclosingScope()) != NullScope.instance);

		return scopedBindings;
	}
	public IEntity createFlatBindingsModel(IBindingManager bm) {
		IEntityFactory ef = GenericEntityFactory.instance;
		IEntity bindings = ef.create(getEdEnum().valueOf("Bindings"));

		Set<String> names = bm.wNames();
		for (String name : new TreeSet<String>(names))
			bindings.wAdd(createBinding(name, bm.wGet(name)));

		return bindings;				
	}
	public IEntity createFlatBindingsModel(IOperation operation, Set<String> includeNames) {
		return createFlatBindingsModel(operation.getOperationEnvironment(), includeNames);
	}
	public IEntity createFlatBindingsModel(IBindingManager bm, Set<String> includeNames) {
		IEntityFactory ef = GenericEntityFactory.instance;
		IEntity bindings = ef.create(getEdEnum().valueOf("Bindings"));

		Set<String> names = bm.wNames();
		for (String name : new TreeSet<String>(includeNames))
			bindings.wAdd(createBinding(name, names.contains(name) ?
					bm.wGet(name) : CommonsEntityFactory.instance.createResolver()));

		return bindings;				
	}

	public IEntity createBinding(String name, IEntity value) {
		IEntityFactory ef = GenericEntityFactory.instance;
		return ef.create(getEdEnum().valueOf("Binding"),
				ef.create(getEdEnum().valueOf("Name"), name),
				ef.create(getEdEnum().valueOf("Value"), (Object) value));				
	}
}
