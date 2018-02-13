package org.whole.lang.pojo.templates;

import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.ArrayType;
import org.whole.lang.java.model.ParameterizedType;
import org.whole.lang.java.model.PrimitiveType;
import org.whole.lang.java.model.Types;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.factories.PojoEntityFactory;
import org.whole.lang.pojo.model.CollectionInterfaceEnum;
import org.whole.lang.pojo.model.CollectionType;
import org.whole.lang.pojo.model.MapType;
import org.whole.lang.pojo.model.PrimitiveTypeEnum;
import org.whole.lang.pojo.model.Type;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.StringUtils;

public class Helpers {
	public static Type toPojoType(IEntity javaType, IEntity packageName) {

		PojoEntityFactory pef = PojoEntityFactory.instance;

		switch (javaType.wGetEntityDescriptor().getOrdinal()) {

		case JavaEntityDescriptorEnum.SimpleType_ord:
		case JavaEntityDescriptorEnum.QualifiedType_ord:
				String javaTypeName = DataTypeUtils.getAsPersistenceString(javaType);
				String packageNameString = packageName.wStringValue();
				String typeName = (javaTypeName.indexOf('.') == -1 ? (StringUtils.isAmbiguous(javaTypeName) ? "java.lang" : packageNameString) + "." : "") + javaTypeName;

				if (StringUtils.isString(typeName))
					return pef.createPrimitiveType(PrimitiveTypeEnum.String);
				else if ("java.util.Set".equals(typeName))
					return pef.createCollectionType(pef.createCollectionInterface(CollectionInterfaceEnum.Set),
							pef.createReferenceType("java.lang.Object"));
				else if ("java.util.List".equals(typeName))
					return pef.createCollectionType(pef.createCollectionInterface(CollectionInterfaceEnum.List),
							pef.createReferenceType("java.lang.Object"));
				else if ("java.util.Map".equals(typeName))
					return pef.createMapType(pef.createReferenceType("java.lang.Object"),
							pef.createReferenceType("java.lang.Object"));
				else 
					return pef.createReferenceType(typeName);

		case JavaEntityDescriptorEnum.PrimitiveType_ord:
			return (Type) DataTypeUtils.convertCloneIfParented(JavaEntityFactory.instance.createPrimitiveType(((PrimitiveType) javaType).getValue()), PojoEntityDescriptorEnum.PrimitiveType);

		case JavaEntityDescriptorEnum.ArrayType_ord:
			ArrayType arrayType = (ArrayType) javaType;
			return pef.createArrayType(toPojoType(arrayType.getComponentType(), packageName));

		case JavaEntityDescriptorEnum.ParameterizedType_ord:
			ParameterizedType parameterizedType = (ParameterizedType) javaType;
			Types typeArguments = parameterizedType.getTypeArguments();
			Type pojoType = toPojoType(parameterizedType.getType(), packageName);
			if (Matcher.matchImpl(PojoEntityDescriptorEnum.CollectionType, pojoType) && typeArguments.wSize() == 1)
				((CollectionType) pojoType).setElementType(toPojoType(typeArguments.wGet(0), packageName));
			else if (Matcher.matchImpl(PojoEntityDescriptorEnum.MapType, pojoType) && typeArguments.wSize() == 2) {
				((MapType) pojoType).setKeyType(toPojoType(typeArguments.wGet(0), packageName));
				((MapType) pojoType).setValueType(toPojoType(typeArguments.wGet(1), packageName));
			}
			return pojoType;

		default:
			throw new IllegalStateException("cannot convert java type to pojo type: "+javaType);
		}
	}
}
