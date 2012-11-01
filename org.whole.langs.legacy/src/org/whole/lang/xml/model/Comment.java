package org.whole.lang.xml.model;

/** 
 * @generator Whole
 */
public interface Comment extends IXmlEntity, IMisc, IContent {
	public CommentText getText();

	public void setText(CommentText text);
}
