package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface OrderedPair extends IMathEntity, Sequence {
	public Expression getFirst();

	public void setFirst(Expression first);

	public Expression getSecond();

	public void setSecond(Expression second);
}
