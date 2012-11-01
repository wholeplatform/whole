package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface ForeignKeyTableConstraint extends ISQLEntity, TableConstraint {
	public ColumnNames getColumnNames();

	public void setColumnNames(ColumnNames columnNames);

	public TableName getForeignTableName();

	public void setForeignTableName(TableName foreignTableName);

	public ColumnNames getForeignColumnNames();

	public void setForeignColumnNames(ColumnNames foreignColumnNames);

	public Match getMatch();

	public void setMatch(Match match);

	public Action getOnDelete();

	public void setOnDelete(Action onDelete);

	public Action getOnUpdate();

	public void setOnUpdate(Action onUpdate);

	public Deferrable getDeferrable();

	public void setDeferrable(Deferrable deferrable);

	public DeferCheck getDeferCheck();

	public void setDeferCheck(DeferCheck deferCheck);
}
