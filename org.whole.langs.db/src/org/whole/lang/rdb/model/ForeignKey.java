package org.whole.lang.rdb.model;

/** 
 * @generator Whole
 */
public interface ForeignKey extends IRDBEntity {
	public StringData getName();

	public void setName(StringData name);

	public StringData getTargetTable();

	public void setTargetTable(StringData targetTable);

	public Action getUpdateAction();

	public void setUpdateAction(Action updateAction);

	public Action getDeleteAction();

	public void setDeleteAction(Action deleteAction);

	public Deferrability getDeferrability();

	public void setDeferrability(Deferrability deferrability);

	public ColumnReferences getColumnReferences();

	public void setColumnReferences(ColumnReferences columnReferences);
}
