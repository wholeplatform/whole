package org.whole.lang.xsd.visitors;

import org.whole.lang.xsd.model.*;

/** 
 * @generator Whole
 */
public class XsdIdentityDefaultVisitor extends XsdIdentityVisitor {
	public void visit(IXsdEntity entity) {
	}

	public void visit(NSContainer entity) {
	}

	public void visit(Schema entity) {
		visit((IXsdEntity) entity);
		visit((NSContainer) entity);
	}

	public void visit(SchemaDirectives entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(SchemaDirective entity) {
		visit((NSContainer) entity);
	}

	public void visit(Include entity) {
		visit((IXsdEntity) entity);
		visit((SchemaDirective) entity);
		visit((Annotated) entity);
	}

	public void visit(Annotated entity) {
	}

	public void visit(Redefine entity) {
		visit((IXsdEntity) entity);
		visit((Include) entity);
	}

	public void visit(RedefineComponents entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(Import entity) {
		visit((IXsdEntity) entity);
		visit((SchemaDirective) entity);
		visit((Annotated) entity);
	}

	public void visit(Annotation entity) {
		visit((IXsdEntity) entity);
		visit((SchemaDirective) entity);
		visit((SchemaComponent) entity);
		visit((RedefineComponent) entity);
	}

	public void visit(SchemaComponent entity) {
	}

	public void visit(RedefineComponent entity) {
	}

	public void visit(AnnotationList entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(AnnotationType entity) {
		visit((NSContainer) entity);
	}

	public void visit(Appinfo entity) {
		visit((IXsdEntity) entity);
		visit((AnnotationType) entity);
	}

	public void visit(Documentation entity) {
		visit((IXsdEntity) entity);
		visit((AnnotationType) entity);
	}

	public void visit(AnnotationContent entity) {
	}

	public void visit(AnyContent entity) {
		visit((AnnotationContent) entity);
	}

	public void visit(AnnotationContents entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(SchemaComponents entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(NamedComponent entity) {
		visit((NSContainer) entity);
	}

	public void visit(NotationDecl entity) {
		visit((IXsdEntity) entity);
		visit((NamedComponent) entity);
		visit((Annotated) entity);
		visit((SchemaComponent) entity);
	}

	public void visit(ElementDecl entity) {
		visit((IXsdEntity) entity);
		visit((NamedComponent) entity);
		visit((Particle) entity);
		visit((SchemaComponent) entity);
	}

	public void visit(Particle entity) {
		visit((NSContainer) entity);
		visit((Annotated) entity);
	}

	public void visit(Reference entity) {
		visit((NSContainer) entity);
	}

	public void visit(ElementRef entity) {
		visit((IXsdEntity) entity);
		visit((Reference) entity);
		visit((Particle) entity);
	}

	public void visit(IdentityConstraintDefs entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(XPathExpression entity) {
		visit((NSContainer) entity);
		visit((Annotated) entity);
	}

	public void visit(Fields entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(Selector entity) {
		visit((IXsdEntity) entity);
		visit((XPathExpression) entity);
	}

	public void visit(Field entity) {
		visit((IXsdEntity) entity);
		visit((XPathExpression) entity);
	}

	public void visit(IdentityConstraintDef entity) {
		visit((NamedComponent) entity);
		visit((Annotated) entity);
	}

	public void visit(Unique entity) {
		visit((IXsdEntity) entity);
		visit((IdentityConstraintDef) entity);
	}

	public void visit(Key entity) {
		visit((IXsdEntity) entity);
		visit((IdentityConstraintDef) entity);
	}

	public void visit(Keyref entity) {
		visit((IXsdEntity) entity);
		visit((IdentityConstraintDef) entity);
	}

	public void visit(TypeDef entity) {
		visit((NamedComponent) entity);
		visit((SchemaComponent) entity);
		visit((RedefineComponent) entity);
	}

	public void visit(SimpleTypeContent entity) {
		visit((NSContainer) entity);
		visit((Annotated) entity);
	}

	public void visit(SimpleTypeDefs entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(SimpleTypeDef entity) {
		visit((IXsdEntity) entity);
		visit((TypeDef) entity);
		visit((Annotated) entity);
	}

	public void visit(ComplexTypeDef entity) {
		visit((IXsdEntity) entity);
		visit((TypeDef) entity);
		visit((Annotated) entity);
	}

	public void visit(AttributeDecl entity) {
		visit((IXsdEntity) entity);
		visit((NamedComponent) entity);
		visit((Annotated) entity);
		visit((SchemaComponent) entity);
	}

	public void visit(AttributeUseOrGroups entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(AttributeUseOrGroup entity) {
	}

	public void visit(AttributeUse entity) {
		visit((AttributeUseOrGroup) entity);
	}

	public void visit(AttributeUseDecl entity) {
		visit((IXsdEntity) entity);
		visit((AttributeDecl) entity);
		visit((AttributeUse) entity);
	}

	public void visit(AttributeUseRef entity) {
		visit((IXsdEntity) entity);
		visit((Reference) entity);
		visit((AttributeUse) entity);
		visit((Annotated) entity);
	}

	public void visit(AnyAttribute entity) {
		visit((IXsdEntity) entity);
		visit((NSContainer) entity);
		visit((Wildcard) entity);
		visit((Annotated) entity);
	}

	public void visit(Wildcard entity) {
	}

	public void visit(AttributeGroupDef entity) {
		visit((IXsdEntity) entity);
		visit((NamedComponent) entity);
		visit((Annotated) entity);
		visit((SchemaComponent) entity);
		visit((RedefineComponent) entity);
	}

	public void visit(AttributeGroupRef entity) {
		visit((IXsdEntity) entity);
		visit((Reference) entity);
		visit((Annotated) entity);
		visit((AttributeUseOrGroup) entity);
	}

	public void visit(ModelGroup entity) {
		visit((Particle) entity);
	}

	public void visit(ModelGroupDef entity) {
		visit((IXsdEntity) entity);
		visit((NamedComponent) entity);
		visit((Annotated) entity);
		visit((SchemaComponent) entity);
		visit((RedefineComponent) entity);
	}

	public void visit(ModelGroupRef entity) {
		visit((IXsdEntity) entity);
		visit((Reference) entity);
		visit((ModelGroup) entity);
	}

	public void visit(Particles entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(List entity) {
		visit((IXsdEntity) entity);
		visit((SimpleTypeContent) entity);
	}

	public void visit(Union entity) {
		visit((IXsdEntity) entity);
		visit((SimpleTypeContent) entity);
	}

	public void visit(SimpleTypeRestriction entity) {
		visit((IXsdEntity) entity);
		visit((SimpleTypeContent) entity);
	}

	public void visit(Facets entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(Facet entity) {
		visit((NSContainer) entity);
		visit((Annotated) entity);
	}

	public void visit(StringFacet entity) {
		visit((Facet) entity);
	}

	public void visit(FixedFacet entity) {
		visit((Facet) entity);
	}

	public void visit(IntegerFacet entity) {
		visit((FixedFacet) entity);
	}

	public void visit(WhiteSpace entity) {
		visit((IXsdEntity) entity);
		visit((FixedFacet) entity);
	}

	public void visit(Length entity) {
		visit((IXsdEntity) entity);
		visit((IntegerFacet) entity);
	}

	public void visit(MinLength entity) {
		visit((IXsdEntity) entity);
		visit((IntegerFacet) entity);
	}

	public void visit(MaxLength entity) {
		visit((IXsdEntity) entity);
		visit((IntegerFacet) entity);
	}

	public void visit(MinInclusive entity) {
		visit((IXsdEntity) entity);
		visit((StringFacet) entity);
	}

	public void visit(MaxInclusive entity) {
		visit((IXsdEntity) entity);
		visit((StringFacet) entity);
	}

	public void visit(MinExclusive entity) {
		visit((IXsdEntity) entity);
		visit((StringFacet) entity);
	}

	public void visit(MaxExclusive entity) {
		visit((IXsdEntity) entity);
		visit((StringFacet) entity);
	}

	public void visit(TotalDigits entity) {
		visit((IXsdEntity) entity);
		visit((IntegerFacet) entity);
	}

	public void visit(FractionDigits entity) {
		visit((IXsdEntity) entity);
		visit((IntegerFacet) entity);
	}

	public void visit(Pattern entity) {
		visit((IXsdEntity) entity);
		visit((StringFacet) entity);
	}

	public void visit(Enumeration entity) {
		visit((IXsdEntity) entity);
		visit((StringFacet) entity);
	}

	public void visit(SimpleContent entity) {
		visit((IXsdEntity) entity);
		visit((NSContainer) entity);
		visit((Annotated) entity);
		visit((ComplexTypeContent) entity);
	}

	public void visit(ComplexTypeContent entity) {
	}

	public void visit(ComplexDerivation entity) {
		visit((NSContainer) entity);
		visit((Annotated) entity);
	}

	public void visit(ComplexRestriction entity) {
		visit((IXsdEntity) entity);
		visit((ComplexDerivation) entity);
	}

	public void visit(ComplexExtension entity) {
		visit((IXsdEntity) entity);
		visit((ComplexDerivation) entity);
	}

	public void visit(SimpleDerivation entity) {
		visit((NSContainer) entity);
		visit((Annotated) entity);
	}

	public void visit(SimpleRestriction entity) {
		visit((IXsdEntity) entity);
		visit((SimpleDerivation) entity);
	}

	public void visit(SimpleExtension entity) {
		visit((IXsdEntity) entity);
		visit((SimpleDerivation) entity);
	}

	public void visit(ComplexContent entity) {
		visit((IXsdEntity) entity);
		visit((NSContainer) entity);
		visit((Annotated) entity);
		visit((ComplexTypeContent) entity);
	}

	public void visit(DeclaredContent entity) {
		visit((IXsdEntity) entity);
		visit((ComplexTypeContent) entity);
	}

	public void visit(ModelGroupWithParticles entity) {
		visit((ModelGroup) entity);
	}

	public void visit(Sequence entity) {
		visit((IXsdEntity) entity);
		visit((ModelGroupWithParticles) entity);
	}

	public void visit(Choice entity) {
		visit((IXsdEntity) entity);
		visit((ModelGroupWithParticles) entity);
	}

	public void visit(All entity) {
		visit((IXsdEntity) entity);
		visit((ModelGroupWithParticles) entity);
	}

	public void visit(Any entity) {
		visit((IXsdEntity) entity);
		visit((Particle) entity);
		visit((Wildcard) entity);
	}

	public void visit(Occurrence entity) {
	}

	public void visit(Bounded entity) {
		visit((IXsdEntity) entity);
		visit((Occurrence) entity);
	}

	public void visit(Unbounded entity) {
		visit((IXsdEntity) entity);
		visit((Occurrence) entity);
	}

	public void visit(MemberTypes entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(Name entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(QName entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(NamespaceSpec entity) {
	}

	public void visit(AnyURI entity) {
		visit((IXsdEntity) entity);
		visit((NamespaceSpec) entity);
	}

	public void visit(NamespaceDecl entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(NamespaceDecls entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(Attributes entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(ProcessContents entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(NamespaceSpecs entity) {
	}

	public void visit(AnyNamespaceSpecs entity) {
		visit((IXsdEntity) entity);
		visit((NamespaceSpecs) entity);
	}

	public void visit(OtherNamespaceSpecs entity) {
		visit((IXsdEntity) entity);
		visit((NamespaceSpecs) entity);
	}

	public void visit(NamespaceSpecsList entity) {
		visit((IXsdEntity) entity);
		visit((NamespaceSpecs) entity);
	}

	public void visit(TargetNamespaceSpec entity) {
		visit((IXsdEntity) entity);
		visit((NamespaceSpec) entity);
	}

	public void visit(LocalNamespaceSpec entity) {
		visit((IXsdEntity) entity);
		visit((NamespaceSpec) entity);
	}

	public void visit(DerivationSet entity) {
	}

	public void visit(DerivationAll entity) {
		visit((IXsdEntity) entity);
		visit((DerivationSet) entity);
	}

	public void visit(DerivationList entity) {
		visit((IXsdEntity) entity);
		visit((DerivationSet) entity);
	}

	public void visit(DerivationControl entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(Use entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(WhiteSpaceProcessing entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(MixedText entity) {
		visit((IXsdEntity) entity);
		visit((AnnotationContent) entity);
	}

	public void visit(XPath entity) {
	}

	public void visit(XPathString entity) {
		visit((IXsdEntity) entity);
		visit((XPath) entity);
	}

	public void visit(StringData entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(IntegerData entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(BooleanData entity) {
		visit((IXsdEntity) entity);
	}

	public void visit(Qualify entity) {
		visit((IXsdEntity) entity);
	}
}
