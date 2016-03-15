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
package org.whole.lang.pojo.codebase;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.pojo.builders.IPojoBuilder;
import org.whole.lang.pojo.model.CollectionInterfaceEnum;
import org.whole.lang.pojo.model.ModifierEnum;
import org.whole.lang.pojo.reflect.PojoLanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.util.StringUtils;

public class PojoRevEngTemplateFactory extends AbstractTemplateFactory {
	private String modelName;
	private String packageName;
	private Class<?>[] classes;
	private String excludedInterfaces;
	
	public PojoRevEngTemplateFactory(String modelName, String packageName, Class<?>[] classes, String excludedInterfaces) {
		this.modelName = modelName;
		this.packageName = packageName;
		this.classes = classes;
		this.excludedInterfaces = excludedInterfaces;
	}

	protected boolean includesInterface(String name) {
		return !StringUtils.inList(name, excludedInterfaces);
	}

	protected boolean hasSamePackage(Class<?> clazz) {
		Package pkg = clazz.getPackage();
		return pkg != null ? pkg.getName().equals(packageName) : false;
	}

	public void apply(IBuilderOperation op) {
		buildPojoModel((IPojoBuilder) op.wGetBuilder(PojoLanguageKit.URI));
	}
	
	private void buildPojoModel(IPojoBuilder builder) {
		builder.Library_();
        builder.Annotations();
    	builder.Name(modelName);
        builder.Declarations_(classes.length);
			for(Class<?> clazz: classes)
				buildPojoDeclaration(clazz, builder);
		builder._Declarations();
        builder._Library();
	}

	private void buildPojoDeclaration(Class<?> clazz, IPojoBuilder builder) {
		builder.PojoDeclaration_();
		{
			builder.Annotations();
        	builder.Name(clazz.getSimpleName());
			
			Class<?>[] interfaces = clazz.getInterfaces();
			builder.Names_(interfaces.length);
			for (int i = 0; i < interfaces.length; i++) {
				if (hasSamePackage(interfaces[i])) {
					String interfaceName = interfaces[i].getSimpleName();
					if (includesInterface(interfaceName))
						builder.Name(interfaceName);
				}
			}
			builder._Names();
			buildProperties(clazz, builder);
		}
		builder._PojoDeclaration();
	}

	private void buildProperties(Class<?> clazz, IPojoBuilder builder) {
		builder.Properties_();
		{
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {

				builder.Property_();
				builder.Annotations();

				Type genericFieldType = field.getGenericType();
				buildProperty(genericFieldType, builder);

				builder.Name(field.getName());
				builder._Property();
			}
		}
		builder._Properties();
	}

	private static final boolean isAssignableParametrizedType(Class<?> assignTo, ParameterizedType ptype) {
		if(ptype == null)
			return false;
		Type rawType = ptype.getRawType();
		return assignTo.isAssignableFrom((Class<?>)rawType);
	}
	
	private void buildProperty(Type genericFieldType, IPojoBuilder builder) {
		if (genericFieldType instanceof ParameterizedType &&
				isAssignableParametrizedType(Collection.class, (ParameterizedType)genericFieldType))
			buildCollectionProperty(genericFieldType, builder);
		else if (genericFieldType instanceof ParameterizedType &&
				isAssignableParametrizedType(Map.class, (ParameterizedType)genericFieldType))
			buildMapProperty(genericFieldType, builder);
		else if(genericFieldType instanceof GenericArrayType)
			buildArrayProperty(genericFieldType, builder);
		else if (genericFieldType instanceof Class<?>) {
			if (((Class<?>)genericFieldType).isPrimitive() ||
//						myClazz.equals(EnumValue.class) ||
//						myClazz.equals(Date.class) ||
					genericFieldType.equals(String.class)) {
				buildPrimitiveProperty((Class<?>)genericFieldType, builder);
			} else if (((Class<?>)genericFieldType).isArray()) {
				buildArrayProperty(genericFieldType, builder);
			} else if (Collection.class.isAssignableFrom((Class<?>)genericFieldType)) {
				buildCollectionProperty(genericFieldType, builder);
			} else if (Map.class.isAssignableFrom((Class<?>)genericFieldType)) {
				buildMapProperty(genericFieldType, builder);
			} else if (hasSamePackage((Class<?>)genericFieldType)) {				
				builder.ReferenceType(((Class<?>)genericFieldType).getSimpleName());
			} else {
				buildReferenceProperty((Class<?>)genericFieldType, builder);
			}
		} else
			throw new IllegalArgumentException("Usupported field type: " + genericFieldType);
	}

	private void buildPrimitiveProperty(Class<?> fieldType, IPojoBuilder builder) {
		builder.PrimitiveType(fieldType.getSimpleName());
	}

	private void buildReferenceProperty(Class<?> fieldType, IPojoBuilder builder) {
		String name = fieldType.getName();
		if (StringUtils.isWrapper(name))
			builder.PrimitiveType(StringUtils.unboxFilter(name));
		else {
			builder.Annotations_();
			builder.Modifier(ModifierEnum.DATATYPE);
			builder._Annotations();
			builder.ReferenceType(name);
		}
	}

	private void buildArrayProperty(Type genericFieldType, IPojoBuilder builder) {
		builder.ArrayType_();
		if(genericFieldType instanceof GenericArrayType) {
			Type componentType = ((GenericArrayType)genericFieldType).getGenericComponentType();
			buildProperty(componentType, builder);
		} else if (genericFieldType instanceof Class<?>) {
			buildProperty(((Class<?>)genericFieldType).getComponentType(), builder);
		}
		builder._ArrayType();
	}

	private void buildCollectionProperty(Type genericFieldType, IPojoBuilder builder) {
		builder.CollectionType_();

		if (genericFieldType instanceof ParameterizedType) {
			for (Type atype : ((ParameterizedType)genericFieldType).getActualTypeArguments()) {
				Class<?> rawType = (Class<?>) ((ParameterizedType)genericFieldType).getRawType();
	
				if (List.class.equals(rawType))
					builder.CollectionInterface(CollectionInterfaceEnum.List);
				else if (Set.class.equals(rawType))
					builder.CollectionInterface(CollectionInterfaceEnum.Set);
				else
					builder.CollectionInterface(CollectionInterfaceEnum.Collection);		
	
				buildProperty(atype, builder);
			}
		} else {
			if (List.class.equals((Class<?>)genericFieldType))
				builder.CollectionInterface(CollectionInterfaceEnum.List);
			else if (Set.class.equals((Class<?>)genericFieldType))
				builder.CollectionInterface(CollectionInterfaceEnum.Set);
			else
				builder.CollectionInterface(CollectionInterfaceEnum.Collection);
			
			buildProperty(Object.class, builder);
		}
		builder._CollectionType();
	}

	private void buildMapProperty(Type genericFieldType, IPojoBuilder builder) {
		builder.MapType_();
		if (genericFieldType instanceof ParameterizedType) {
			for (Type atype : ((ParameterizedType)genericFieldType).getActualTypeArguments()) {
				buildProperty(atype, builder);
			}
		} else {
			buildProperty(Object.class, builder);
			buildProperty(Object.class, builder);
		}
		builder._MapType();
	}
}
