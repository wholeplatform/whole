package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface SimpleColumnConstraint extends ISQLEntity, ColumnConstraint {
	public org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value getValue();

	public void setValue(org.whole.lang.sql.model.SimpleColumnConstraintEnum.Value value);
}
