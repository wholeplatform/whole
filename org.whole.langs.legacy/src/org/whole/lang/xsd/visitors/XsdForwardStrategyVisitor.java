package org.whole.lang.xsd.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class XsdForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IXsdVisitor> implements IXsdVisitor {
	public XsdForwardStrategyVisitor() {
		this(new XsdIdentityVisitor());
	}

	public XsdForwardStrategyVisitor(IXsdVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IXsdEntity) entity).accept(this);
	}

	public void visit(Schema entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SchemaDirectives entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Include entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Redefine entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RedefineComponents entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Import entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Annotation entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnnotationList entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Appinfo entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Documentation entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnnotationContents entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SchemaComponents entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NotationDecl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ElementDecl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ElementRef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IdentityConstraintDefs entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Fields entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Selector entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Field entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Unique entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Key entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Keyref entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleTypeDefs entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleTypeDef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComplexTypeDef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AttributeDecl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AttributeUseOrGroups entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AttributeUseDecl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AttributeUseRef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyAttribute entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AttributeGroupDef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AttributeGroupRef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ModelGroupDef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ModelGroupRef entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Particles entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(List entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Union entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleTypeRestriction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Facets entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WhiteSpace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Length entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MinLength entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MaxLength entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MinInclusive entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MaxInclusive entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MinExclusive entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MaxExclusive entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TotalDigits entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FractionDigits entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Pattern entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Enumeration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleContent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComplexRestriction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComplexExtension entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleRestriction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleExtension entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ComplexContent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DeclaredContent entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Sequence entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Choice entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(All entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Any entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Bounded entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Unbounded entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MemberTypes entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(QName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyURI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NamespaceDecl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NamespaceDecls entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Attributes entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ProcessContents entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AnyNamespaceSpecs entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(OtherNamespaceSpecs entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NamespaceSpecsList entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TargetNamespaceSpec entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LocalNamespaceSpec entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DerivationAll entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DerivationList entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DerivationControl entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Use entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WhiteSpaceProcessing entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MixedText entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(XPathString entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntegerData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanData entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Qualify entity) {
		wGetStrategy().visit(entity);
	}
}
