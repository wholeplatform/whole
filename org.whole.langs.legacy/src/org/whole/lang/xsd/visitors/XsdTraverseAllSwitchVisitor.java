package org.whole.lang.xsd.visitors;

import org.whole.lang.xsd.visitors.XsdIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xsd.model.*;

/** 
 * @generator Whole
 */
public class XsdTraverseAllSwitchVisitor extends
		XsdIdentityUnaryVisitor<IVisitor> {
	public XsdTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Schema entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getTargetNamespace());
		wGetVisitor1().visit(entity.getVersion());
		wGetVisitor1().visit(entity.getLanguage());
		wGetVisitor1().visit(entity.getAttributeFormDefault());
		wGetVisitor1().visit(entity.getElementFormDefault());
		wGetVisitor1().visit(entity.getBlockDefault());
		wGetVisitor1().visit(entity.getFinalDefault());
		wGetVisitor1().visit(entity.getDirectives());
		wGetVisitor1().visit(entity.getComponents());
	}

	public void visit(SchemaDirectives entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SchemaDirective entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
	}

	public void visit(Include entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSchemaLocation());
	}

	public void visit(Redefine entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSchemaLocation());
		wGetVisitor1().visit(entity.getDefinitions());
	}

	public void visit(RedefineComponents entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Import entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getSchemaLocation());
	}

	public void visit(Annotation entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getList());
	}

	public void visit(AnnotationList entity) {
		for (AnnotationType child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(AnnotationType entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getSource());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Appinfo entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getSource());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(Documentation entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getSource());
		wGetVisitor1().visit(entity.getLanguage());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(AnnotationContents entity) {
		for (AnnotationContent child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(SchemaComponents entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(NotationDecl entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getPublic());
		wGetVisitor1().visit(entity.getSystem());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(ElementDecl entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getAbstract());
		wGetVisitor1().visit(entity.getNillable());
		wGetVisitor1().visit(entity.getDefaultValue());
		wGetVisitor1().visit(entity.getFixedValue());
		wGetVisitor1().visit(entity.getForm());
		wGetVisitor1().visit(entity.getBlock());
		wGetVisitor1().visit(entity.getFinal());
		wGetVisitor1().visit(entity.getSubstitutionGroup());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getTypeDef());
		wGetVisitor1().visit(entity.getIdentityConstraintDefs());
	}

	public void visit(ElementRef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getRef());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(IdentityConstraintDefs entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(XPathExpression entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getXpath());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(Fields entity) {
		for (Field child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(Selector entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getXpath());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(Field entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getXpath());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(IdentityConstraintDef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSelector());
		wGetVisitor1().visit(entity.getFields());
	}

	public void visit(Unique entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSelector());
		wGetVisitor1().visit(entity.getFields());
	}

	public void visit(Key entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSelector());
		wGetVisitor1().visit(entity.getFields());
	}

	public void visit(Keyref entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getRefer());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSelector());
		wGetVisitor1().visit(entity.getFields());
	}

	public void visit(TypeDef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getFinal());
	}

	public void visit(SimpleTypeContent entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(SimpleTypeDefs entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SimpleTypeDef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getFinal());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(ComplexTypeDef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getFinal());
		wGetVisitor1().visit(entity.getAbstract());
		wGetVisitor1().visit(entity.getMixed());
		wGetVisitor1().visit(entity.getBlock());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(AttributeDecl entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getSimpleType());
		wGetVisitor1().visit(entity.getDefaultValue());
		wGetVisitor1().visit(entity.getFixedValue());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSimpleTypeDef());
	}

	public void visit(AttributeUseOrGroups entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(AttributeUse entity) {
		wGetVisitor1().visit(entity.getUse());
		wGetVisitor1().visit(entity.getForm());
	}

	public void visit(AttributeUseDecl entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getSimpleType());
		wGetVisitor1().visit(entity.getUse());
		wGetVisitor1().visit(entity.getForm());
		wGetVisitor1().visit(entity.getDefaultValue());
		wGetVisitor1().visit(entity.getFixedValue());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getSimpleTypeDef());
	}

	public void visit(AttributeUseRef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getRef());
		wGetVisitor1().visit(entity.getUse());
		wGetVisitor1().visit(entity.getForm());
		wGetVisitor1().visit(entity.getDefaultValue());
		wGetVisitor1().visit(entity.getFixedValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(AnyAttribute entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getNamespaceSpecs());
		wGetVisitor1().visit(entity.getProcessContents());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(AttributeGroupDef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getAttributeUses());
		wGetVisitor1().visit(entity.getAnyAttribute());
	}

	public void visit(AttributeGroupRef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getRef());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(ModelGroup entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(ModelGroupDef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getModelGroup());
	}

	public void visit(ModelGroupRef entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getRef());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(Particles entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Particle entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(List entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getItemType());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getItemTypeDef());
	}

	public void visit(Union entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMemberTypes());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getMemberTypesDefs());
	}

	public void visit(SimpleTypeRestriction entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getBase());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getBaseDef());
		wGetVisitor1().visit(entity.getFacets());
	}

	public void visit(Facets entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Facet entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(StringFacet entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(FixedFacet entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getFixed());
	}

	public void visit(IntegerFacet entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getFixed());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(WhiteSpace entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getFixed());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(Length entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getFixed());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(MinLength entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getFixed());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(MaxLength entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getFixed());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(MinInclusive entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(MaxInclusive entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(MinExclusive entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(MaxExclusive entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(TotalDigits entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getFixed());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(FractionDigits entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getFixed());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(Pattern entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(Enumeration entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getValue());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(SimpleContent entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getDerivation());
	}

	public void visit(ComplexDerivation entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(ComplexRestriction entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getBase());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(ComplexExtension entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getBase());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getContent());
	}

	public void visit(SimpleDerivation entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(SimpleRestriction entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getBase());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getBaseDef());
		wGetVisitor1().visit(entity.getFacets());
		wGetVisitor1().visit(entity.getAttributeUses());
		wGetVisitor1().visit(entity.getAnyAttribute());
	}

	public void visit(SimpleExtension entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getBase());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getAttributeUses());
		wGetVisitor1().visit(entity.getAnyAttribute());
	}

	public void visit(ComplexContent entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMixed());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getDerivation());
	}

	public void visit(DeclaredContent entity) {
		wGetVisitor1().visit(entity.getModelGroup());
		wGetVisitor1().visit(entity.getAttributeUses());
		wGetVisitor1().visit(entity.getAnyAttribute());
	}

	public void visit(ModelGroupWithParticles entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getParticles());
	}

	public void visit(Sequence entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getParticles());
	}

	public void visit(Choice entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getParticles());
	}

	public void visit(All entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getAnnotation());
		wGetVisitor1().visit(entity.getParticles());
	}

	public void visit(Any entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getMinOccurs());
		wGetVisitor1().visit(entity.getMaxOccurs());
		wGetVisitor1().visit(entity.getNamespaceSpecs());
		wGetVisitor1().visit(entity.getProcessContents());
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(Wildcard entity) {
		wGetVisitor1().visit(entity.getNamespaceSpecs());
		wGetVisitor1().visit(entity.getProcessContents());
	}

	public void visit(MemberTypes entity) {
		for (QName child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(NamespaceDecl entity) {
		wGetVisitor1().visit(entity.getPrefix());
		wGetVisitor1().visit(entity.getUri());
	}

	public void visit(NamespaceDecls entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(NSContainer entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
	}

	public void visit(Attributes entity) {
		for (Attribute child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(NamedComponent entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(Reference entity) {
		wGetVisitor1().visit(entity.getNamespaces());
		wGetVisitor1().visit(entity.getId());
		wGetVisitor1().visit(entity.getAttributes());
		wGetVisitor1().visit(entity.getRef());
	}

	public void visit(Annotated entity) {
		wGetVisitor1().visit(entity.getAnnotation());
	}

	public void visit(NamespaceSpecsList entity) {
		for (NamespaceSpec child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(DerivationList entity) {
		for (DerivationControl child : entity)
			wGetVisitor1().visit(child);
	}
}
