package org.whole.lang.unifiedlambdadelta.model;

/** 
 * @generator Whole
 */
public interface Name extends IUnifiedLambdaDeltaEntity {
	public Access getAccess();

	public void setAccess(Access access);

	public Prefix getPrefix();

	public void setPrefix(Prefix prefix);

	public Postfix getPostfix();

	public void setPostfix(Postfix postfix);
}
