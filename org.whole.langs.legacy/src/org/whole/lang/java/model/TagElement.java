package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface TagElement extends IJavaEntity, DocElement {
	public TagName getTagName();

	public void setTagName(TagName tagName);

	public DocElements getFragments();

	public void setFragments(DocElements fragments);
}
