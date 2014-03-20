package org.whole.lang.pojo.util;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.AnnotationDeclaration_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.ArrayType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.CollectionType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.DataTypeDeclaration_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.EnumDeclaration_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.MapType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.PojoDeclaration;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.PojoDeclaration_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.PrimitiveType;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.PrimitiveType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.ReferenceType;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.ReferenceType_ord;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.pojo.factories.PojoEntityFactory;
import org.whole.lang.pojo.model.ArrayType;
import org.whole.lang.pojo.model.CollectionInterfaceEnum;
import org.whole.lang.pojo.model.CollectionType;
import org.whole.lang.pojo.model.Constructor;
import org.whole.lang.pojo.model.Constructors;
import org.whole.lang.pojo.model.DataTypeDeclaration;
import org.whole.lang.pojo.model.EnumDeclaration;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.pojo.model.MapType;
import org.whole.lang.pojo.model.ModifierEnum;
import org.whole.lang.pojo.model.Name;
import org.whole.lang.pojo.model.Parameter;
import org.whole.lang.pojo.model.PojoDeclaration;
import org.whole.lang.pojo.model.PrimitiveType;
import org.whole.lang.pojo.model.PrimitiveTypeEnum;
import org.whole.lang.pojo.model.ProductDeclaration;
import org.whole.lang.pojo.model.Property;
import org.whole.lang.pojo.model.ReferenceType;
import org.whole.lang.pojo.model.Type;
import org.whole.lang.pojo.model.CollectionInterfaceEnum.Value;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.templates.PojoTemplateManager;
import org.whole.lang.queries.model.PathExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

public class PojoUtils {

	public static String calculateTypeName(Type type) {
		String typeName = null;
		switch (type.wGetEntityDescriptor().getOrdinal()) {
		case PrimitiveType_ord:
			typeName = StringUtils.toUpperCap(type.wStringValue())+"Data";
			break;
		case ReferenceType_ord:
			typeName = StringUtils.toSimpleName(type.wStringValue());
			break;
		case ArrayType_ord:
			ArrayType arrayType = (ArrayType) type;
			typeName = calculateTypeName(arrayType.getElementType())+"Array";
			break;
		case CollectionType_ord:
			CollectionType collectionType = (CollectionType) type;
			String interfaceName = collectionType.getCollectionInterface().wEnumValue().toString();
			typeName = calculateTypeName(collectionType.getElementType())+interfaceName;
			break;
		case MapType_ord:
			MapType mapType = (MapType) type;
			typeName = calculateTypeName(mapType.getKeyType())+"To"+calculateTypeName(mapType.getValueType())+"Map";
			break;
		}
		return typeName; 
	}
	public static void addDataTypeDeclaration(Type type, String name, Library entity) {
		entity.getDeclarations().wAdd(PojoEntityFactory.instance.createDataTypeDeclaration(
				createResolver(PojoEntityDescriptorEnum.Annotations),
				PojoEntityFactory.instance.createName(name),
				EntityUtils.clone(type)
		));
	}

	public static ProductDeclaration findProductDeclaration(Type type, Library entity) {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		bindings.wDef("name", type);
		return BehaviorUtils.<ProductDeclaration>evaluateFirstResult((PathExpression) PojoTemplateManager.instance().share("findProductDeclarationByName"), entity, bindings);
	}

	private static Map<PrimitiveTypeEnum.Value, Class<?>> primitiveTypesMap;
	private static Map<PrimitiveTypeEnum.Value, Class<?>> primitiveTypesMap() {
		if (primitiveTypesMap == null) {
			primitiveTypesMap = new HashMap<PrimitiveTypeEnum.Value, Class<?>>();
			primitiveTypesMap.put(PrimitiveTypeEnum._boolean, boolean.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum._byte, byte.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum._char, char.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum._double, double.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum._float, float.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum._int, int.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum._long, long.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum._short, short.class);
	    	primitiveTypesMap.put(PrimitiveTypeEnum.String, String.class);
		}
		return primitiveTypesMap;
	}
	public static Class<?> getPrimitiveTypeClass(PrimitiveType primitiveType) {
		return primitiveTypesMap().get(primitiveType.getValue());
	}

	@SuppressWarnings("unchecked")
	private static <E extends IEntity> EntityDescriptor<E> getEntityDescriptor(ProductDeclaration declaration, Library library) {
		String entityTypeName = declaration.getTemplate().wStringValue();;
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(library.getLanguageURI().wStringValue());
		return (EntityDescriptor<E>) languageKit.getEntityDescriptorEnum().valueOf(entityTypeName);
	}

	public static IEntity toDataEntity(Object fromObject, PrimitiveType type, Library library) {
		String edName = StringUtils.toUpperCap(type.wStringValue())+"Data";
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(library.getLanguageURI().wStringValue());
		return GenericEntityFactory.instance(RegistryConfigurations.RESOLVER).create(languageKit.getEntityDescriptorEnum().valueOf(edName), fromObject);
	}
	public static ProductDeclaration findProductDeclarationByTemplateName(EntityDescriptor<?> ed, Library library) {
		PojoEntityFactory pef = PojoEntityFactory.instance;
		PathExpression findProductDeclarationByTemplateName = (PathExpression) PojoTemplateManager.instance().create("findProductDeclarationByTemplateName");
		Name templateName = pef.createName(ed.getName());
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		bindings.wDef("templateName", templateName);
		return BehaviorUtils.evaluateFirstResult(findProductDeclarationByTemplateName, library, bindings);
	}
	public static boolean isFieldOnly(Property property) {
		return property.getAnnotations().wContainsValue(ModifierEnum.FIELD_ONLY);
	}
	public static boolean isReadOnly(Property property) {
		return property.getAnnotations().wContainsValue(ModifierEnum.READ_ONLY);
	}
	public static boolean isAbstract(ProductDeclaration productDeclaration) {
		return productDeclaration.getAnnotations().wContainsValue(ModifierEnum.ABSTRACT);
	}
	public static Object getPropertyValue(Property property, Object fromObject) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class<?> fromClass = fromObject.getClass();
		Object fieldValue;
		Name name = property.getName();
		String filedName = name.wStringValue();
		if (isFieldOnly(property)) {
			Field field = fromClass.getField(filedName);
			fieldValue = field.get(fromObject);
		} else {
			Type type = property.getType();
			boolean isBoolean = type.wContainsValue(PrimitiveTypeEnum._boolean);
			String getterMethodName = (isBoolean ? "is" : "get")+StringUtils.toUpperCap(filedName);
			Method getterMethod = fromClass.getMethod(getterMethodName, new Class[0]);
			fieldValue = getterMethod.invoke(fromObject, new Object[0]);
		}
		return fieldValue;
	}
	public static void setPropertyValue(Property property, Object toObject, Object value) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
		Class<?> fromClass = toObject.getClass();
		Name name = property.getName();
		String fieldName = name.getValue();
		if (isFieldOnly(property)) {
			Field field = fromClass.getField(fieldName);
			field.set(toObject, value);
		} else {
			String setterMethodName = "set"+StringUtils.toUpperCap(fieldName);
			for (Method method : fromClass.getMethods()) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				if (setterMethodName.equals(method.getName())&& 
					parameterTypes.length == 1 && 
					parameterTypes[0].isAssignableFrom(DataTypeUtils.unboxFilter(value.getClass()))){
					method.invoke(toObject, new Object[] { value });
					return;
				}
				
			}
			throw new IllegalArgumentException("missing setter method for property");
		}
	}

	public static List<Type> findMappingTypes(Class<?> fromClass, Library library) {
		ReferenceType exactType = PojoEntityFactory.instance.createReferenceType(fromClass.getName());
		if (findProductDeclaration(exactType, library) != null)
			return Collections.<Type>singletonList(exactType);
		List<Type> mappingTypes = new ArrayList<Type>();
		for (Class<?> implInterface : fromClass.getInterfaces()) {
			ReferenceType implType = PojoEntityFactory.instance.createReferenceType(implInterface.getName());
			if (findProductDeclaration(implType, library) != null)
				mappingTypes.add(implType);
		}
		Class<?> superclass = fromClass.getSuperclass();
		ReferenceType superType = PojoEntityFactory.instance.createReferenceType(superclass.getName());
		if (!fromClass.isInterface()) {
			if (findProductDeclaration(superType, library) != null)
				mappingTypes.add(superType);
		}
		if (!Object.class.equals(superclass) && mappingTypes.isEmpty())
			mappingTypes.addAll(findMappingTypes(superclass, library));
		return mappingTypes;
	}

	public static void translate(Object fromObject, IEntity toIEntity, PojoDeclaration pojoDeclaration, Library library) {
		// translate inherited properties
		IEntityIterator<ReferenceType> superPojosIterator = IteratorFactory.<ReferenceType>childIterator();
		superPojosIterator.reset(pojoDeclaration.getTypes());
		for (ReferenceType superType : superPojosIterator) {
			PojoDeclaration superDeclaration = (PojoDeclaration) findProductDeclaration(superType, library);
			translate(fromObject, toIEntity, superDeclaration, library);
		}

		// translate declared properties
		IEntityIterator<Property> iterator = IteratorFactory.<Property>childIterator();
		iterator.reset(pojoDeclaration.getProperties());
		EntityDescriptor<?> ed = toIEntity.wGetEntityDescriptor();
		Property property = null;
		try {
			while (iterator.hasNext()) {
				property = iterator.next();
				Type type = property.getType();
				Name template = property.getTemplate();
				FeatureDescriptor fd = ed.getFeatureDescriptorEnum().valueOf(template.wStringValue());
				
				Object fieldValue = getPropertyValue(property, fromObject);
				if (fieldValue == null)
					continue;
				if (Matcher.match(PrimitiveType, type))
					toIEntity.wSet(fd, toDataEntity(fieldValue, (PrimitiveType) type, library));
				else if (Matcher.match(ReferenceType, type))
					toIEntity.wSet(fd, create(fieldValue, library));
				else
					toIEntity.wSet(fd, create(fieldValue, type, library));
			}
		} catch (Exception e) {
			throw new IllegalStateException("Cannot translate property: "+property, e);
		}
	}

	public static void translate(IEntity fromEntity, Object toObject, PojoDeclaration pojoDeclaration, Library library) {
		// translate inherited properties
		IEntityIterator<ReferenceType> superPojosIterator = IteratorFactory.<ReferenceType>childIterator();
		superPojosIterator.reset(pojoDeclaration.getTypes());
		for (ReferenceType superType : superPojosIterator) {
			PojoDeclaration superDeclaration = (PojoDeclaration) findProductDeclaration(superType, library);
			translate(fromEntity, toObject, superDeclaration, library);
		}

		// translate declared properties
		IEntityIterator<Property> iterator = IteratorFactory.<Property>childIterator();
		iterator.reset(pojoDeclaration.getProperties());
		EntityDescriptor<?> ed = fromEntity.wGetEntityDescriptor();
		Property property = null;
		try {
			while (iterator.hasNext()) {
				property = iterator.next();
				if (isReadOnly(property))
					continue;
				Type type = property.getType();
				Name template = property.getTemplate();
				FeatureDescriptor fd = ed.getFeatureDescriptorEnum().valueOf(template.wStringValue());
				
				IEntity fieldEntity = fromEntity.wGet(fd);
				if (!EntityUtils.isNotResolver(fieldEntity))
					continue;

				if (Matcher.match(PrimitiveType, type))
					setPropertyValue(property, toObject, fieldEntity.wGetValue());
				else
					setPropertyValue(property, toObject, create(fieldEntity, library));
			}
		} catch (Exception e) {
			throw new IllegalStateException("Cannot translate property: "+property, e);
		}
	}

	public static void translate(Object fromObject, IEntity toIEntity, Library library) {
		Class<?> fromClass = fromObject.getClass();
		ProductDeclaration productDeclaration = findProductDeclaration(PojoEntityFactory.instance.createReferenceType(fromClass.getName()), library);
		if (!Matcher.matchImpl(PojoDeclaration, productDeclaration))
			throw new IllegalStateException("translate can be invoked only on pojo objects");
		translate(fromObject, toIEntity, (PojoDeclaration) productDeclaration, library);
	}

	public static void translate(IEntity fromEntity, Object toObject, Library library) {
		Class<?> toClass = toObject.getClass();
		ProductDeclaration productDeclaration = findProductDeclaration(PojoEntityFactory.instance.createReferenceType(toClass.getName()), library);
		if (!Matcher.matchImpl(PojoDeclaration, productDeclaration))
			throw new IllegalStateException("translate can be invoked only on pojo objects");
		translate(fromEntity, toObject, (PojoDeclaration) productDeclaration, library);
	}

	@SuppressWarnings("unchecked")
	public static <E extends IEntity> E create(Object fromObject, Type type, Library library) {
		// map product type
		ProductDeclaration productDeclaration = findProductDeclaration(type, library);
		E toIEntity = PojoUtils.<E>createEntity(productDeclaration, library);

		// translate contents as needed
		switch (productDeclaration.wGetEntityDescriptor().getOrdinal()) {
		case PojoDeclaration_ord:
			translate(fromObject, toIEntity, (PojoDeclaration) productDeclaration, library);
			break;
		case EnumDeclaration_ord:
			EnumValue enumValue = DefaultDataTypePersistenceParser.instance.parseEnumValue(toIEntity.wGetEntityDescriptor(), fromObject.toString());
			toIEntity.wSetValue(enumValue);
			break;
		case AnnotationDeclaration_ord://TODO
			break;
		case DataTypeDeclaration_ord:
			Type elementType;
			switch (type.wGetEntityDescriptor().getOrdinal()) {
			case PrimitiveType_ord:
			case ReferenceType_ord:
				toIEntity.wSetValue(fromObject);
				break;
			case ArrayType_ord:
				ArrayType arrayType = (ArrayType) type;
				elementType = arrayType.getElementType();
				for (int i = 0; i < Array.getLength(fromObject); i++)
					toIEntity.wAdd(create(Array.get(fromObject, i), elementType, library));
				break;
			case CollectionType_ord:
				CollectionType collectionType = (CollectionType) type;
				Collection<Object> fromCollection = (Collection<Object>) fromObject;
				elementType = collectionType.getElementType();
				for (Object element : fromCollection)
					toIEntity.wAdd(create(element, elementType, library));
				break;
			case MapType_ord:
				MapType mapType = (MapType) type;
				Map<Object, Object> fromMap = (Map<Object, Object>) fromObject;
				Type keyType = mapType.getKeyType();
				elementType = mapType.getValueType();
				for (Entry<Object, Object> element : fromMap.entrySet())
					toIEntity.wSet((IEntity) create(element.getKey(), keyType, library),//FIXME workaround for Java 8 compiler
							create(element.getValue(), elementType, library));
				break;
			}
			break;
		}
		return toIEntity;
	}
	public static <E extends IEntity> E createEntity(ProductDeclaration productDeclaration, Library library) {
		EntityDescriptor<E> ed = getEntityDescriptor(productDeclaration, library);
		return GenericEntityFactory.instance(RegistryConfigurations.RESOLVER).create(ed);
	}
	
	/*
	 * expects a normalized library
	 */
	public static <E extends IEntity> E create(Object fromObject, Library library) {
		// find product type
		Class<? extends Object> fromClass = fromObject.getClass();
		List<Type> types = findMappingTypes(fromClass, library);
		if (types.size() == 0)
			throw new IllegalStateException("Cannot find type mapping for class: "+fromClass.getName());
		else if (types.size() != 1)
			throw new IllegalStateException("Ambiguous type mapping for class: "+fromClass.getName());

		return PojoUtils.<E>create(fromObject, types.get(0), library);
	}

	/*
	 * expects a normalized library
	 */
	public static Object create(IEntity fromEntity, Library library) {
		// find product type
		EntityDescriptor<?> ed = fromEntity.wGetEntityDescriptor();
		ProductDeclaration productDeclaration = findProductDeclarationByTemplateName(ed, library);
		if (productDeclaration == null)
			throw new IllegalStateException("Cannot find type mapping for entity: "+fromEntity);

		// translate contents as needed
		Object toObject = null;
		switch (productDeclaration.wGetEntityDescriptor().getOrdinal()) {
		case PojoDeclaration_ord:
			toObject = createInstance(fromEntity, (PojoDeclaration) productDeclaration, library);
			translate(fromEntity, toObject, (PojoDeclaration) productDeclaration, library);
			break;
		case EnumDeclaration_ord:
			String enumValue = DefaultDataTypePersistenceParser.instance.unparseEnumValue(fromEntity.wGetEntityDescriptor(), fromEntity.wEnumValue());
			toObject = createEnumValue((EnumDeclaration) productDeclaration, enumValue);
			break;
		case AnnotationDeclaration_ord://TODO
			break;
		case DataTypeDeclaration_ord:
			Type type = ((DataTypeDeclaration) productDeclaration).getName();
			switch (type.wGetEntityDescriptor().getOrdinal()) {
			case PrimitiveType_ord:
			case ReferenceType_ord:
				toObject = fromEntity.wGetValue();
				break;
			case ArrayType_ord:
				toObject = Array.newInstance(getClass(((ArrayType) type).getElementType()), fromEntity.wSize());
				for (int i=0; i<fromEntity.wSize(); i++) {
					IEntity element = fromEntity.wGet(i);
					Array.set(toObject, i, create(element, library));
				}
				break;
			case CollectionType_ord:
				Collection<Object> toCollection = ((CollectionType) type).getCollectionInterface().getValue().equals(CollectionInterfaceEnum.Set) ?
						new HashSet<Object>() : new ArrayList<Object>();
				IEntityIterator<IEntity> ci = IteratorFactory.childIterator();
				ci.reset(fromEntity);
				for (IEntity feature : ci)
					toCollection.add(create(feature, library));
				toObject = toCollection;
				break;
			case MapType_ord:
				Map<Object, Object> toMap = new HashMap<Object, Object>();
				for (int i=0; i<fromEntity.wSize(); i++) {
					IEntity key = fromEntity.wGet(i);
					IEntity value = fromEntity.wGet(key);
					toMap.put(create(key, library), create(value, library));
				}
				toObject = toMap;
				break;
			}
			break;
		}
		return toObject;
	}
	
	public static Class<?> getClass(Type type) {
		switch (type.wGetEntityDescriptor().getOrdinal()) {
		case PrimitiveType_ord:
			return getPrimitiveTypeClass((PrimitiveType) type);
		case ReferenceType_ord:
			try {
				return Class.forName(((ReferenceType) type).getValue());
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("Cannot find class for reference type", e);
			}
		case ArrayType_ord:
			return Array.newInstance(getClass(((ArrayType) type).getElementType()), 0).getClass();
		case CollectionType_ord:
			Value collectionInterface = ((CollectionType) type).getCollectionInterface().getValue();
			return collectionInterface.equals(CollectionInterfaceEnum.Set) ? Set.class : List.class;
		case MapType_ord:
			return Map.class;
		}
		return null;
	}

	public static Object createEnumValue(EnumDeclaration enumDeclaration, String value) {
		ReferenceType referenceType = enumDeclaration.getName();
		String toEnumName = referenceType.wStringValue();
		try {
			Class<?> toEnum = Class.forName(toEnumName);
			Method valueOfMethod = toEnum.getMethod("valueOf", new Class[] { String.class });
			return valueOfMethod.invoke(null, value);
		} catch (Exception e) {
			throw new IllegalStateException("Cannot istantiate enum from reference type: "+toEnumName+" using value:"+value, e);
		}
	}

	public static Set<Name> getReadOnlyFields(PojoDeclaration pojoDeclaration) {
		Set<Name> readOnlyFields = new HashSet<Name>();
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		PathExpression findAllReadOnlyFields = (PathExpression) PojoTemplateManager.instance().create("findAllReadOnlyFields");
		for (Name readOnlyField : BehaviorUtils.<Name>compileAndLazyEvaluate(findAllReadOnlyFields, pojoDeclaration, bindings))
			readOnlyFields.add(readOnlyField);
		return readOnlyFields;
	}

	public static List<Constructor> getConstructors(PojoDeclaration pojoDeclaration) {
		Constructors constructors = pojoDeclaration.getConstructors();
		List<Constructor> constructorsList = new ArrayList<Constructor>(constructors.wSize());
		IEntityIterator<Constructor> i = IteratorFactory.<Constructor>childIterator();
		i.reset(constructors);
		for (Constructor constructor : i)
			constructorsList.add(constructor);
		Collections.sort(constructorsList, new Comparator<Constructor>() {
			public int compare(Constructor c1, Constructor c2) {
				return c1.getParameters().wSize()-c2.getParameters().wSize();
			}
		});
		return constructorsList;
	}

	public static Constructor findConstructor(PojoDeclaration pojoDeclaration) {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();

		PathExpression findParameterByTemplate = (PathExpression) PojoTemplateManager.instance().create("findParameterByTemplate");
		List<Constructor> constructors = getConstructors(pojoDeclaration);
		int[] supportedFields = new int[constructors.size()];

		PathExpression findAllReadOnlyFields = (PathExpression) PojoTemplateManager.instance().create("findAllReadOnlyFields");
		IEntityIterator<Name> iterator = BehaviorUtils.<Name>compileAndLazyEvaluate(findAllReadOnlyFields, pojoDeclaration, bindings);
		int readOnlyFieldCount = 0;
		while (iterator.hasNext()) {
			iterator.next();
			for (int i=0; i<supportedFields.length; i++)
				if (BehaviorUtils.evaluateFirstResult(findParameterByTemplate, constructors.get(i), bindings) != null)
					supportedFields[i]++;
			readOnlyFieldCount++;
		}

		for (int i=0; i<supportedFields.length; i++)
			if (supportedFields[i] >= readOnlyFieldCount)
				return constructors.get(i);
		return constructors.get(supportedFields.length-1);
	}

	public static Object createInstanceUsingConstructor(IEntity fromEntity, PojoDeclaration pojoDeclaration, Library library) throws Exception {
		ReferenceType referenceType = pojoDeclaration.getName();
		Class<?> clazz = Class.forName(referenceType.getValue());
		Constructor constructor = findConstructor(pojoDeclaration);

		int params = constructor.getParameters().wSize();
		List<Class<?>> parameterTypes = new ArrayList<Class<?>>(params);
		List<Object> initargs = new ArrayList<Object>(params);

		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		PathExpression findPropertyByTemplate = (PathExpression) PojoTemplateManager.instance().create("findPropertyByTemplate");
		PathExpression findParameterByTemplate = (PathExpression) PojoTemplateManager.instance().create("findParameterByTemplate");
		IEntityIterator<Parameter> iterator = BehaviorUtils.<Parameter>compileAndLazyEvaluate(findParameterByTemplate, constructor, bindings);
		while (iterator.hasNext()) {
			iterator.next();
			Property property = BehaviorUtils.<Property>evaluateFirstResult(findPropertyByTemplate, pojoDeclaration, bindings);
			Type type = property.getType();
			Name template = property.getTemplate();
			FeatureDescriptor fd = fromEntity.wGetEntityDescriptor().getFeatureDescriptorEnum().valueOf(template.wStringValue());

			IEntity fieldEntity = fromEntity.wGet(fd);
			parameterTypes.add(getClass(type));
			initargs.add(Matcher.match(PrimitiveType, type) ? fieldEntity.wGetValue() : create(fieldEntity, library));
		}

		return clazz.getConstructor(parameterTypes.toArray(new Class<?>[0])).newInstance(initargs.toArray());
	}
	public static Object createInstance(IEntity fromEntity, PojoDeclaration pojoDeclaration, Library library) {
		try {
			//TODO add construction strategy using factories
			return createInstanceUsingConstructor(fromEntity, pojoDeclaration, library);
		} catch (Exception e) {
			throw new IllegalStateException("Cannot istantiate class from reference type: "+pojoDeclaration.getName(), e);
		}
	}
}
