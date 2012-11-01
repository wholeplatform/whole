package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface PairValue extends ISchemeEntity, ConstExpression {
	public ConstExpression getCar();

	public void setCar(ConstExpression car);

	public ConstExpression getCdr();

	public void setCdr(ConstExpression cdr);
}
