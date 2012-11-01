package org.whole.lang.xsd.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class XsdImplEntityRegistry extends AbstractEntityRegistry {
	public XsdImplEntityRegistry() {
		super(XsdEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new SchemaImpl());
		put(new SchemaDirectivesImpl());
		put(new IncludeImpl());
		put(new RedefineImpl());
		put(new RedefineComponentsImpl());
		put(new ImportImpl());
		put(new AnnotationImpl());
		put(new AnnotationListImpl());
		put(new AppinfoImpl());
		put(new DocumentationImpl());
		put(new AnnotationContentsImpl());
		put(new SchemaComponentsImpl());
		put(new NotationDeclImpl());
		put(new ElementDeclImpl());
		put(new ElementRefImpl());
		put(new IdentityConstraintDefsImpl());
		put(new FieldsImpl());
		put(new SelectorImpl());
		put(new FieldImpl());
		put(new UniqueImpl());
		put(new KeyImpl());
		put(new KeyrefImpl());
		put(new SimpleTypeDefsImpl());
		put(new SimpleTypeDefImpl());
		put(new ComplexTypeDefImpl());
		put(new AttributeDeclImpl());
		put(new AttributeUseOrGroupsImpl());
		put(new AttributeUseDeclImpl());
		put(new AttributeUseRefImpl());
		put(new AnyAttributeImpl());
		put(new AttributeGroupDefImpl());
		put(new AttributeGroupRefImpl());
		put(new ModelGroupDefImpl());
		put(new ModelGroupRefImpl());
		put(new ParticlesImpl());
		put(new ListImpl());
		put(new UnionImpl());
		put(new SimpleTypeRestrictionImpl());
		put(new FacetsImpl());
		put(new WhiteSpaceImpl());
		put(new LengthImpl());
		put(new MinLengthImpl());
		put(new MaxLengthImpl());
		put(new MinInclusiveImpl());
		put(new MaxInclusiveImpl());
		put(new MinExclusiveImpl());
		put(new MaxExclusiveImpl());
		put(new TotalDigitsImpl());
		put(new FractionDigitsImpl());
		put(new PatternImpl());
		put(new EnumerationImpl());
		put(new SimpleContentImpl());
		put(new ComplexRestrictionImpl());
		put(new ComplexExtensionImpl());
		put(new SimpleRestrictionImpl());
		put(new SimpleExtensionImpl());
		put(new ComplexContentImpl());
		put(new DeclaredContentImpl());
		put(new SequenceImpl());
		put(new ChoiceImpl());
		put(new AllImpl());
		put(new AnyImpl());
		put(new BoundedImpl());
		put(new UnboundedImpl());
		put(new MemberTypesImpl());
		put(new NameImpl());
		put(new QNameImpl());
		put(new AnyURIImpl());
		put(new NamespaceDeclImpl());
		put(new NamespaceDeclsImpl());
		put(new AttributesImpl());
		put(new ProcessContentsImpl());
		put(new AnyNamespaceSpecsImpl());
		put(new OtherNamespaceSpecsImpl());
		put(new NamespaceSpecsListImpl());
		put(new TargetNamespaceSpecImpl());
		put(new LocalNamespaceSpecImpl());
		put(new DerivationAllImpl());
		put(new DerivationListImpl());
		put(new DerivationControlImpl());
		put(new UseImpl());
		put(new WhiteSpaceProcessingImpl());
		put(new MixedTextImpl());
		put(new XPathStringImpl());
		put(new StringDataImpl());
		put(new IntegerDataImpl());
		put(new BooleanDataImpl());
		put(new QualifyImpl());
	}
}
