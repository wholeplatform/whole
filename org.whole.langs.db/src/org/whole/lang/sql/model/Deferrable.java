package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Deferrable extends ISQLEntity {
	public org.whole.lang.sql.model.DeferrableEnum.Value getValue();

	public void setValue(org.whole.lang.sql.model.DeferrableEnum.Value value);
}
