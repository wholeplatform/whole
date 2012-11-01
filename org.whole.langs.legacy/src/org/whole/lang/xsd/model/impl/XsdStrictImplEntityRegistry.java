package org.whole.lang.xsd.model.impl;

/** 
 * @generator Whole
 */
public class XsdStrictImplEntityRegistry extends XsdImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new AnnotationListStrictImpl());
		put(new AnnotationContentsStrictImpl());
		put(new FieldsStrictImpl());
		put(new MemberTypesStrictImpl());
		put(new AttributesStrictImpl());
		put(new NamespaceSpecsListStrictImpl());
		put(new DerivationListStrictImpl());
	}
}
