package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface Initializer extends IJavaEntity, AnnotatedBodyDeclaration {
	public Block getBody();

	public void setBody(Block body);
}
