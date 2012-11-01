package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ForeignKeyTableConstraintImpl extends AbstractSimpleEntity
		implements ForeignKeyTableConstraint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForeignKeyTableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ForeignKeyTableConstraint;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ForeignKeyTableConstraint_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private ColumnNames columnNames;

	public ColumnNames getColumnNames() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnNames,
				columnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		notifyChanged(SQLFeatureDescriptorEnum.columnNames, this.columnNames,
				this.columnNames = columnNames);
	}

	private TableName foreignTableName;

	public TableName getForeignTableName() {
		return notifyRequested(SQLFeatureDescriptorEnum.foreignTableName,
				foreignTableName);
	}

	public void setForeignTableName(TableName foreignTableName) {
		notifyChanged(SQLFeatureDescriptorEnum.foreignTableName,
				this.foreignTableName, this.foreignTableName = foreignTableName);
	}

	private ColumnNames foreignColumnNames;

	public ColumnNames getForeignColumnNames() {
		return notifyRequested(SQLFeatureDescriptorEnum.foreignColumnNames,
				foreignColumnNames);
	}

	public void setForeignColumnNames(ColumnNames foreignColumnNames) {
		notifyChanged(SQLFeatureDescriptorEnum.foreignColumnNames,
				this.foreignColumnNames,
				this.foreignColumnNames = foreignColumnNames);
	}

	private Match match;

	public Match getMatch() {
		return notifyRequested(SQLFeatureDescriptorEnum.match, match);
	}

	public void setMatch(Match match) {
		notifyChanged(SQLFeatureDescriptorEnum.match, this.match,
				this.match = match);
	}

	private Action onDelete;

	public Action getOnDelete() {
		return notifyRequested(SQLFeatureDescriptorEnum.onDelete, onDelete);
	}

	public void setOnDelete(Action onDelete) {
		notifyChanged(SQLFeatureDescriptorEnum.onDelete, this.onDelete,
				this.onDelete = onDelete);
	}

	private Action onUpdate;

	public Action getOnUpdate() {
		return notifyRequested(SQLFeatureDescriptorEnum.onUpdate, onUpdate);
	}

	public void setOnUpdate(Action onUpdate) {
		notifyChanged(SQLFeatureDescriptorEnum.onUpdate, this.onUpdate,
				this.onUpdate = onUpdate);
	}

	private Deferrable deferrable;

	public Deferrable getDeferrable() {
		return notifyRequested(SQLFeatureDescriptorEnum.deferrable, deferrable);
	}

	public void setDeferrable(Deferrable deferrable) {
		notifyChanged(SQLFeatureDescriptorEnum.deferrable, this.deferrable,
				this.deferrable = deferrable);
	}

	private DeferCheck deferCheck;

	public DeferCheck getDeferCheck() {
		return notifyRequested(SQLFeatureDescriptorEnum.deferCheck, deferCheck);
	}

	public void setDeferCheck(DeferCheck deferCheck) {
		notifyChanged(SQLFeatureDescriptorEnum.deferCheck, this.deferCheck,
				this.deferCheck = deferCheck);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getColumnNames().wGetAdaptee(false);
		case 1:
			return getForeignTableName().wGetAdaptee(false);
		case 2:
			return getForeignColumnNames().wGetAdaptee(false);
		case 3:
			return getMatch().wGetAdaptee(false);
		case 4:
			return getOnDelete().wGetAdaptee(false);
		case 5:
			return getOnUpdate().wGetAdaptee(false);
		case 6:
			return getDeferrable().wGetAdaptee(false);
		case 7:
			return getDeferCheck().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setColumnNames(value
					.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		case 1:
			setForeignTableName(value
					.wGetAdapter(SQLEntityDescriptorEnum.TableName));
			break;
		case 2:
			setForeignColumnNames(value
					.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		case 3:
			setMatch(value.wGetAdapter(SQLEntityDescriptorEnum.Match));
			break;
		case 4:
			setOnDelete(value.wGetAdapter(SQLEntityDescriptorEnum.Action));
			break;
		case 5:
			setOnUpdate(value.wGetAdapter(SQLEntityDescriptorEnum.Action));
			break;
		case 6:
			setDeferrable(value.wGetAdapter(SQLEntityDescriptorEnum.Deferrable));
			break;
		case 7:
			setDeferCheck(value.wGetAdapter(SQLEntityDescriptorEnum.DeferCheck));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 8;
	}
}
