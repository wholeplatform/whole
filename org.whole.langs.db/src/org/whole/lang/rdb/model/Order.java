package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface Order extends IRDBEntity {
	public org.whole.lang.rdb.model.OrderEnum.Value getValue();

	public void setValue(org.whole.lang.rdb.model.OrderEnum.Value value);
}
