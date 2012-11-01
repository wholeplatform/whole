package org.whole.lang.visitors;

import java.util.List;

import org.whole.gen.JavaStoreBuilder;
import org.whole.lang.pojo.model.AnnotationDeclaration;
import org.whole.lang.pojo.model.Annotations;
import org.whole.lang.pojo.model.ArrayData;
import org.whole.lang.pojo.model.ArrayType;
import org.whole.lang.pojo.model.BooleanData;
import org.whole.lang.pojo.model.ByteData;
import org.whole.lang.pojo.model.CharData;
import org.whole.lang.pojo.model.CollectionInterface;
import org.whole.lang.pojo.model.CollectionType;
import org.whole.lang.pojo.model.Declarations;
import org.whole.lang.pojo.model.DoubleData;
import org.whole.lang.pojo.model.EnumDeclaration;
import org.whole.lang.pojo.model.FloatData;
import org.whole.lang.pojo.model.IPojoEntity;
import org.whole.lang.pojo.model.IntData;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.pojo.model.LongData;
import org.whole.lang.pojo.model.MapType;
import org.whole.lang.pojo.model.MarkerAnnotation;
import org.whole.lang.pojo.model.ModifierEnum;
import org.whole.lang.pojo.model.MultiplePropertiesAnnotation;
import org.whole.lang.pojo.model.Name;
import org.whole.lang.pojo.model.Names;
import org.whole.lang.pojo.model.PojoDeclaration;
import org.whole.lang.pojo.model.PrimitiveType;
import org.whole.lang.pojo.model.Properties;
import org.whole.lang.pojo.model.Property;
import org.whole.lang.pojo.model.PropertyValuePair;
import org.whole.lang.pojo.model.PropertyValuePairs;
import org.whole.lang.pojo.model.ReferenceType;
import org.whole.lang.pojo.model.ShortData;
import org.whole.lang.pojo.model.SinglePropertyAnnotation;
import org.whole.lang.pojo.model.StringData;
import org.whole.lang.pojo.visitors.PojoIdentityVisitor;

/** 
 * @generator Whole
 */
public class PojoJavaStoreGeneratorVisitor extends PojoIdentityVisitor {
	private final JavaStoreBuilder builder;

	private final boolean isCompiling;

	public PojoJavaStoreGeneratorVisitor(JavaStoreBuilder builder,
			boolean isCompiling) {
		this.builder = builder;
		this.isCompiling = isCompiling;
		builder.addLanguageFactory(this,
				"org.whole.lang.pojo.model.PojoLanguageFactory");
	}

	private final org.eclipse.jdt.core.dom.Expression astOf(IPojoEntity entity) {
		entity.accept(this);
		return builder.getExpression();
	}

	protected org.eclipse.jdt.core.dom.Expression astOf(Object entity) {
		return builder.newNullLiteral();
	}

	public void visit(Library entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPojoModel");
		callExp.arguments().add(astOf(entity.getAnnotations()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getDeclarations()));
		builder.addSubtree(parentNestingSize, "PojoModel", callExp);
	}

	public void visit(Declarations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDeclarations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Declaration", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IPojoEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Declarations", callExp);
	}

	public void visit(EnumDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createEnumDeclaration");
		callExp.arguments().add(astOf(entity.getAnnotations()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getValues()));
		builder.addSubtree(parentNestingSize, "EnumDeclaration", callExp);
	}

	public void visit(AnnotationDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAnnotationDeclaration");
		callExp.arguments().add(astOf(entity.getAnnotations()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getProperties()));
		builder.addSubtree(parentNestingSize, "AnnotationDeclaration", callExp);
	}

	public void visit(PojoDeclaration entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPojoDeclaration");
		callExp.arguments().add(astOf(entity.getAnnotations()));
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getTypes()));
		callExp.arguments().add(astOf(entity.getProperties()));
		builder.addSubtree(parentNestingSize, "PojoDeclaration", callExp);
	}

	public void visit(Properties entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createProperties");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Property", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IPojoEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Properties", callExp);
	}

	public void visit(Property entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSimpleProperty");
		callExp.arguments().add(astOf(entity.getAnnotations()));
		callExp.arguments().add(astOf(entity.getType()));
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "SimpleProperty", callExp);
	}

	public void visit(ReferenceType entity) {
		//TODO check for parent entity of type Property
		if (((Property) entity.wGetParent()).getAnnotations().wContainsValue(ModifierEnum.DATATYPE)) {
			int parentNestingSize = builder.initNestingSize();
			org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
			.newFactoryInvocation(this, "createReferenceType");
			callExp.arguments().add(builder.newLiteral(entity.getValue()));
			builder.addSubtree(parentNestingSize, "ReferenceType", callExp);
		} else {
			int parentNestingSize = builder.initNestingSize();
			org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
					.newFactoryInvocation(this, "createDeclaredType");
			callExp.arguments().add(builder.newLiteral(entity.getValue()));
			builder.addSubtree(parentNestingSize, "DeclaredType", callExp);
		}
	}

	public void visit(PrimitiveType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPrimitiveType");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "PrimitiveType", callExp);
	}

	public void visit(ArrayType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArrayType");
		callExp.arguments().add(astOf(entity.getElementType()));
		builder.addSubtree(parentNestingSize, "ArrayType", callExp);
	}

	public void visit(MapType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMapType");
		callExp.arguments().add(astOf(entity.getKeyType()));
		callExp.arguments().add(astOf(entity.getValueType()));
		builder.addSubtree(parentNestingSize, "MapType", callExp);
	}

	public void visit(CollectionType entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCollectionType");
		callExp.arguments().add(astOf(entity.getCollectionInterface()));
		callExp.arguments().add(astOf(entity.getElementType()));
		builder.addSubtree(parentNestingSize, "CollectionType", callExp);
	}

	public void visit(CollectionInterface entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCollectionInterface");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "CollectionInterface", callExp);
	}

	public void visit(Names entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createNames");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments()
				.add(builder.newArrayCreation("IName", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IPojoEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Names", callExp);
	}

	public void visit(Name entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createName");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "Name", callExp);
	}

	public void visit(Annotations entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createAnnotations");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("Annotation", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IPojoEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "Annotations", callExp);
	}

	public void visit(MarkerAnnotation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createMarkerAnnotation");
		callExp.arguments().add(astOf(entity.getName()));
		builder.addSubtree(parentNestingSize, "MarkerAnnotation", callExp);
	}

	public void visit(SinglePropertyAnnotation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createSinglePropertyAnnotation");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getValue()));
		builder.addSubtree(parentNestingSize, "SinglePropertyAnnotation",
				callExp);
	}

	public void visit(MultiplePropertiesAnnotation entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this,
						"createMultiplePropertiesAnnotation");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getPropertyValuePairs()));
		builder.addSubtree(parentNestingSize, "MultiplePropertiesAnnotation",
				callExp);
	}

	public void visit(PropertyValuePairs entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPropertyValuePairs");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("IPropertyValuePair", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IPojoEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "PropertyValuePairs", callExp);
	}

	public void visit(PropertyValuePair entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createPropertyValuePair");
		callExp.arguments().add(astOf(entity.getName()));
		callExp.arguments().add(astOf(entity.getValue()));
		builder.addSubtree(parentNestingSize, "PropertyValuePair", callExp);
	}

	public void visit(ArrayData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createArrayData");
		org.eclipse.jdt.core.dom.ArrayInitializer initArrayExp = builder
				.newArrayInitializer();
		callExp.arguments().add(
				builder.newArrayCreation("PropertyValue", initArrayExp));
		List list = initArrayExp.expressions();
		for (int i = 0; i < entity.wSize(); i++)
			list.add(astOf((IPojoEntity) entity.wGet(i)));
		builder.addSubtree(parentNestingSize, "ArrayData", callExp);
	}

	public void visit(BooleanData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createBooleanData");
		callExp.arguments().add(builder.newLiteral(entity.isValue()));
		builder.addSubtree(parentNestingSize, "BooleanData", callExp);
	}

	public void visit(ByteData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createByteData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "ByteData", callExp);
	}

	public void visit(CharData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createCharData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "CharData", callExp);
	}

	public void visit(DoubleData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createDoubleData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "DoubleData", callExp);
	}

	public void visit(FloatData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createFloatData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "FloatData", callExp);
	}

	public void visit(IntData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createIntData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "IntData", callExp);
	}

	public void visit(LongData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createLongData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "LongData", callExp);
	}

	public void visit(ShortData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createShortData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "ShortData", callExp);
	}

	public void visit(StringData entity) {
		int parentNestingSize = builder.initNestingSize();
		org.eclipse.jdt.core.dom.MethodInvocation callExp = builder
				.newFactoryInvocation(this, "createStringData");
		callExp.arguments().add(builder.newLiteral(entity.getValue()));
		builder.addSubtree(parentNestingSize, "StringData", callExp);
	}
}