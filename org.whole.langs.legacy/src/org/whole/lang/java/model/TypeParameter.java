package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface TypeParameter extends IJavaEntity {
	public SimpleName getName();

	public void setName(SimpleName name);

	public Types getTypeBounds();

	public void setTypeBounds(Types typeBounds);

	public Annotations getAnnotations();

	public void setAnnotations(Annotations annotations);
}
