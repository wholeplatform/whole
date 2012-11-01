package org.whole.lang.tests.model;

/** 
 * @generator Whole
 */
public interface Comment extends ITestsEntity, TestStatement {
	public CommentKind getKind();

	public void setKind(CommentKind kind);

	public Description getDescription();

	public void setDescription(Description description);
}
