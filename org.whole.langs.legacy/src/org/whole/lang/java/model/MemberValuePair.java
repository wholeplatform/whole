package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface MemberValuePair extends IJavaEntity {
	public SimpleName getName();

	public void setName(SimpleName name);

	public Expression getValue();

	public void setValue(Expression value);
}
