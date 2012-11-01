package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface BuiltinValue extends ISchemeEntity, ConstExpression {
	public org.whole.lang.scheme.model.BuiltinValueEnum.Value getValue();

	public void setValue(
			org.whole.lang.scheme.model.BuiltinValueEnum.Value value);
}
