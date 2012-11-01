package org.whole.lang.xsd.visitors;

import org.whole.lang.xsd.visitors.XsdIdentityUnaryVisitor;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.xsd.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class XsdTraverseAllVisitor extends XsdIdentityUnaryVisitor<IXsdVisitor> {
	public XsdTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public XsdTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Schema entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getTargetNamespace().accept(wGetVisitor1());
		entity.getVersion().accept(wGetVisitor1());
		entity.getLanguage().accept(wGetVisitor1());
		entity.getAttributeFormDefault().accept(wGetVisitor1());
		entity.getElementFormDefault().accept(wGetVisitor1());
		entity.getBlockDefault().accept(wGetVisitor1());
		entity.getFinalDefault().accept(wGetVisitor1());
		entity.getDirectives().accept(wGetVisitor1());
		entity.getComponents().accept(wGetVisitor1());
	}

	public void visit(SchemaDirectives entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SchemaDirective entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
	}

	public void visit(Include entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSchemaLocation().accept(wGetVisitor1());
	}

	public void visit(Redefine entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSchemaLocation().accept(wGetVisitor1());
		entity.getDefinitions().accept(wGetVisitor1());
	}

	public void visit(RedefineComponents entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Import entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getSchemaLocation().accept(wGetVisitor1());
	}

	public void visit(Annotation entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getList().accept(wGetVisitor1());
	}

	public void visit(AnnotationList entity) {
		for (AnnotationType child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(AnnotationType entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getSource().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Appinfo entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getSource().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(Documentation entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getSource().accept(wGetVisitor1());
		entity.getLanguage().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(AnnotationContents entity) {
		for (AnnotationContent child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(SchemaComponents entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(NotationDecl entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getPublic().accept(wGetVisitor1());
		entity.getSystem().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(ElementDecl entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getType().accept(wGetVisitor1());
		entity.getAbstract().accept(wGetVisitor1());
		entity.getNillable().accept(wGetVisitor1());
		entity.getDefaultValue().accept(wGetVisitor1());
		entity.getFixedValue().accept(wGetVisitor1());
		entity.getForm().accept(wGetVisitor1());
		entity.getBlock().accept(wGetVisitor1());
		entity.getFinal().accept(wGetVisitor1());
		entity.getSubstitutionGroup().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getTypeDef().accept(wGetVisitor1());
		entity.getIdentityConstraintDefs().accept(wGetVisitor1());
	}

	public void visit(ElementRef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getRef().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(IdentityConstraintDefs entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(XPathExpression entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getXpath().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(Fields entity) {
		for (Field child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(Selector entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getXpath().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(Field entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getXpath().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(IdentityConstraintDef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSelector().accept(wGetVisitor1());
		entity.getFields().accept(wGetVisitor1());
	}

	public void visit(Unique entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSelector().accept(wGetVisitor1());
		entity.getFields().accept(wGetVisitor1());
	}

	public void visit(Key entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSelector().accept(wGetVisitor1());
		entity.getFields().accept(wGetVisitor1());
	}

	public void visit(Keyref entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getRefer().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSelector().accept(wGetVisitor1());
		entity.getFields().accept(wGetVisitor1());
	}

	public void visit(TypeDef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getFinal().accept(wGetVisitor1());
	}

	public void visit(SimpleTypeContent entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(SimpleTypeDefs entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SimpleTypeDef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getFinal().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(ComplexTypeDef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getFinal().accept(wGetVisitor1());
		entity.getAbstract().accept(wGetVisitor1());
		entity.getMixed().accept(wGetVisitor1());
		entity.getBlock().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(AttributeDecl entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getSimpleType().accept(wGetVisitor1());
		entity.getDefaultValue().accept(wGetVisitor1());
		entity.getFixedValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSimpleTypeDef().accept(wGetVisitor1());
	}

	public void visit(AttributeUseOrGroups entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(AttributeUse entity) {
		entity.getUse().accept(wGetVisitor1());
		entity.getForm().accept(wGetVisitor1());
	}

	public void visit(AttributeUseDecl entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getSimpleType().accept(wGetVisitor1());
		entity.getUse().accept(wGetVisitor1());
		entity.getForm().accept(wGetVisitor1());
		entity.getDefaultValue().accept(wGetVisitor1());
		entity.getFixedValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getSimpleTypeDef().accept(wGetVisitor1());
	}

	public void visit(AttributeUseRef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getRef().accept(wGetVisitor1());
		entity.getUse().accept(wGetVisitor1());
		entity.getForm().accept(wGetVisitor1());
		entity.getDefaultValue().accept(wGetVisitor1());
		entity.getFixedValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(AnyAttribute entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getNamespaceSpecs().accept(wGetVisitor1());
		entity.getProcessContents().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(AttributeGroupDef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getAttributeUses().accept(wGetVisitor1());
		entity.getAnyAttribute().accept(wGetVisitor1());
	}

	public void visit(AttributeGroupRef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getRef().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(ModelGroup entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(ModelGroupDef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getModelGroup().accept(wGetVisitor1());
	}

	public void visit(ModelGroupRef entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getRef().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(Particles entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Particle entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(List entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getItemType().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getItemTypeDef().accept(wGetVisitor1());
	}

	public void visit(Union entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMemberTypes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getMemberTypesDefs().accept(wGetVisitor1());
	}

	public void visit(SimpleTypeRestriction entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getBase().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getBaseDef().accept(wGetVisitor1());
		entity.getFacets().accept(wGetVisitor1());
	}

	public void visit(Facets entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Facet entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(StringFacet entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(FixedFacet entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
	}

	public void visit(IntegerFacet entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(WhiteSpace entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(Length entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(MinLength entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(MaxLength entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(MinInclusive entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(MaxInclusive entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(MinExclusive entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(MaxExclusive entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(TotalDigits entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(FractionDigits entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getFixed().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(Pattern entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(Enumeration entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getValue().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(SimpleContent entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getDerivation().accept(wGetVisitor1());
	}

	public void visit(ComplexDerivation entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(ComplexRestriction entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getBase().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(ComplexExtension entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getBase().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getContent().accept(wGetVisitor1());
	}

	public void visit(SimpleDerivation entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(SimpleRestriction entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getBase().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getBaseDef().accept(wGetVisitor1());
		entity.getFacets().accept(wGetVisitor1());
		entity.getAttributeUses().accept(wGetVisitor1());
		entity.getAnyAttribute().accept(wGetVisitor1());
	}

	public void visit(SimpleExtension entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getBase().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getAttributeUses().accept(wGetVisitor1());
		entity.getAnyAttribute().accept(wGetVisitor1());
	}

	public void visit(ComplexContent entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMixed().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getDerivation().accept(wGetVisitor1());
	}

	public void visit(DeclaredContent entity) {
		entity.getModelGroup().accept(wGetVisitor1());
		entity.getAttributeUses().accept(wGetVisitor1());
		entity.getAnyAttribute().accept(wGetVisitor1());
	}

	public void visit(ModelGroupWithParticles entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getParticles().accept(wGetVisitor1());
	}

	public void visit(Sequence entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getParticles().accept(wGetVisitor1());
	}

	public void visit(Choice entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getParticles().accept(wGetVisitor1());
	}

	public void visit(All entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
		entity.getParticles().accept(wGetVisitor1());
	}

	public void visit(Any entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getMinOccurs().accept(wGetVisitor1());
		entity.getMaxOccurs().accept(wGetVisitor1());
		entity.getNamespaceSpecs().accept(wGetVisitor1());
		entity.getProcessContents().accept(wGetVisitor1());
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(Wildcard entity) {
		entity.getNamespaceSpecs().accept(wGetVisitor1());
		entity.getProcessContents().accept(wGetVisitor1());
	}

	public void visit(MemberTypes entity) {
		for (QName child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(NamespaceDecl entity) {
		entity.getPrefix().accept(wGetVisitor1());
		entity.getUri().accept(wGetVisitor1());
	}

	public void visit(NamespaceDecls entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(NSContainer entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
	}

	public void visit(Attributes entity) {
		for (Attribute child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(NamedComponent entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(Reference entity) {
		entity.getNamespaces().accept(wGetVisitor1());
		entity.getId().accept(wGetVisitor1());
		entity.getAttributes().accept(wGetVisitor1());
		entity.getRef().accept(wGetVisitor1());
	}

	public void visit(Annotated entity) {
		entity.getAnnotation().accept(wGetVisitor1());
	}

	public void visit(NamespaceSpecsList entity) {
		for (NamespaceSpec child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(DerivationList entity) {
		for (DerivationControl child : entity)
			child.accept(wGetVisitor1());
	}
}
