package org.whole.lang.math.model;

/** 
 * @generator Whole
 */
public interface Constant extends IMathEntity, Number {
	public org.whole.lang.math.model.ConstantEnum.Value getValue();

	public void setValue(org.whole.lang.math.model.ConstantEnum.Value value);
}
