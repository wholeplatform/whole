package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface Declaration extends IImpEntity, Statement {
	public Type getType();

	public void setType(Type type);

	public Name getName();

	public void setName(Name name);
}
