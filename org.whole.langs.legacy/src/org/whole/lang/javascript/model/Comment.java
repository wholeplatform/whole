package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface Comment extends IJavaScriptEntity, Statement {
	public CommentKind getKind();

	public void setKind(CommentKind kind);

	public StringData getContents();

	public void setContents(StringData contents);
}
