package org.whole.lang.xsd.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.xsd.model.*;

/** 
 * @generator Whole
 */
public interface IXsdVisitor extends IVisitor {
	public void visit(Schema entity);

	public void visit(SchemaDirectives entity);

	public void visit(Include entity);

	public void visit(Redefine entity);

	public void visit(RedefineComponents entity);

	public void visit(Import entity);

	public void visit(Annotation entity);

	public void visit(AnnotationList entity);

	public void visit(Appinfo entity);

	public void visit(Documentation entity);

	public void visit(AnnotationContents entity);

	public void visit(SchemaComponents entity);

	public void visit(NotationDecl entity);

	public void visit(ElementDecl entity);

	public void visit(ElementRef entity);

	public void visit(IdentityConstraintDefs entity);

	public void visit(Fields entity);

	public void visit(Selector entity);

	public void visit(Field entity);

	public void visit(Unique entity);

	public void visit(Key entity);

	public void visit(Keyref entity);

	public void visit(SimpleTypeDefs entity);

	public void visit(SimpleTypeDef entity);

	public void visit(ComplexTypeDef entity);

	public void visit(AttributeDecl entity);

	public void visit(AttributeUseOrGroups entity);

	public void visit(AttributeUseDecl entity);

	public void visit(AttributeUseRef entity);

	public void visit(AnyAttribute entity);

	public void visit(AttributeGroupDef entity);

	public void visit(AttributeGroupRef entity);

	public void visit(ModelGroupDef entity);

	public void visit(ModelGroupRef entity);

	public void visit(Particles entity);

	public void visit(List entity);

	public void visit(Union entity);

	public void visit(SimpleTypeRestriction entity);

	public void visit(Facets entity);

	public void visit(WhiteSpace entity);

	public void visit(Length entity);

	public void visit(MinLength entity);

	public void visit(MaxLength entity);

	public void visit(MinInclusive entity);

	public void visit(MaxInclusive entity);

	public void visit(MinExclusive entity);

	public void visit(MaxExclusive entity);

	public void visit(TotalDigits entity);

	public void visit(FractionDigits entity);

	public void visit(Pattern entity);

	public void visit(Enumeration entity);

	public void visit(SimpleContent entity);

	public void visit(ComplexRestriction entity);

	public void visit(ComplexExtension entity);

	public void visit(SimpleRestriction entity);

	public void visit(SimpleExtension entity);

	public void visit(ComplexContent entity);

	public void visit(DeclaredContent entity);

	public void visit(Sequence entity);

	public void visit(Choice entity);

	public void visit(All entity);

	public void visit(Any entity);

	public void visit(Bounded entity);

	public void visit(Unbounded entity);

	public void visit(MemberTypes entity);

	public void visit(Name entity);

	public void visit(QName entity);

	public void visit(AnyURI entity);

	public void visit(NamespaceDecl entity);

	public void visit(NamespaceDecls entity);

	public void visit(Attributes entity);

	public void visit(ProcessContents entity);

	public void visit(AnyNamespaceSpecs entity);

	public void visit(OtherNamespaceSpecs entity);

	public void visit(NamespaceSpecsList entity);

	public void visit(TargetNamespaceSpec entity);

	public void visit(LocalNamespaceSpec entity);

	public void visit(DerivationAll entity);

	public void visit(DerivationList entity);

	public void visit(DerivationControl entity);

	public void visit(Use entity);

	public void visit(WhiteSpaceProcessing entity);

	public void visit(MixedText entity);

	public void visit(XPathString entity);

	public void visit(StringData entity);

	public void visit(IntegerData entity);

	public void visit(BooleanData entity);

	public void visit(Qualify entity);
}
