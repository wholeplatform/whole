package org.whole.lang.xsd.mapping.visitors;

import org.whole.lang.xsd.mapping.visitors.MappingIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xsd.mapping.model.*;

/** 
 * @generator Whole
 */
public class MappingTraverseAllSwitchVisitor extends
		MappingIdentityUnaryVisitor<IVisitor> {
	public MappingTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(MappingStrategy entity) {
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getSchemaLocation());
		wGetVisitor1().visit(entity.getSynthesized());
		wGetVisitor1().visit(entity.getElementsFormQualified());
		wGetVisitor1().visit(entity.getAttributesFormQualified());
		wGetVisitor1().visit(entity.getMixedDataType());
		wGetVisitor1().visit(entity.getMixedTypes());
		wGetVisitor1().visit(entity.getMappings());
		wGetVisitor1().visit(entity.getDataTypes());
	}

	public void visit(Mappings entity) {
		for (Mapping child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Types entity) {
		for (URI child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(RootMapping entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getEntityType());
	}

	public void visit(ContextMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
	}

	public void visit(ContentMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(MixedStructuralMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(AnyMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(AnyStructuralMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(AnyElementMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(AnyAttributeMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(TypeMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(StructuralMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(ElementMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(AttributeMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getFeatureType());
	}

	public void visit(UnionMapping entity) {
		wGetVisitor1().visit(entity.getContextEntityType());
		wGetVisitor1().visit(entity.getUnionTypes());
	}

	public void visit(DataTypes entity) {
		for (DataType child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(DataType entity) {
		wGetVisitor1().visit(entity.getEntityType());
	}

	public void visit(EnumDataType entity) {
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getEnumValues());
	}

	public void visit(EnumValues entity) {
		for (EnumValue child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(EnumValue entity) {
		wGetVisitor1().visit(entity.getEnumValue());
		wGetVisitor1().visit(entity.getValue());
	}

	public void visit(CustomDataType entity) {
		wGetVisitor1().visit(entity.getEntityType());
		wGetVisitor1().visit(entity.getBuiltInType());
	}
}
