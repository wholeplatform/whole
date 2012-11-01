package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Union extends IXsdEntity, SimpleTypeContent {
	public MemberTypes getMemberTypes();

	public void setMemberTypes(MemberTypes memberTypes);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public SimpleTypeDefs getMemberTypesDefs();

	public void setMemberTypesDefs(SimpleTypeDefs memberTypesDefs);
}
