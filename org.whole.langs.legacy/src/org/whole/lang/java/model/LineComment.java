package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface LineComment extends IJavaEntity, Comment {
	public TextElement getText();

	public void setText(TextElement text);
}
