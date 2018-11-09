package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.ForeignKeyTableConstraint;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.ConstraintName;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.ColumnNames;
import org.whole.lang.sql.model.TableName;
import org.whole.lang.sql.model.Match;
import org.whole.lang.sql.model.Action;
import org.whole.lang.sql.model.Deferrable;
import org.whole.lang.sql.model.DeferCheck;

/** 
 * @generator Whole
 */
public class ForeignKeyTableConstraintImpl extends AbstractSimpleEntity implements ForeignKeyTableConstraint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForeignKeyTableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ForeignKeyTableConstraint;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.ForeignKeyTableConstraint_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getConstraintName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getConstraintName().wEquals(entity.wGet(SQLFeatureDescriptorEnum.constraintName));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("constraintName=");
		buffer.append(constraintName);
	}

	private ConstraintName constraintName;

	public ConstraintName getConstraintName() {
		return notifyRequested(SQLFeatureDescriptorEnum.constraintName, constraintName);
	}

	public void setConstraintName(ConstraintName constraintName) {
		notifyChanged(SQLFeatureDescriptorEnum.constraintName, this.constraintName,
				this.constraintName = constraintName);
	}

	private ColumnNames columnNames;

	public ColumnNames getColumnNames() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnNames, columnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		notifyChanged(SQLFeatureDescriptorEnum.columnNames, this.columnNames, this.columnNames = columnNames);
	}

	private TableName foreignTableName;

	public TableName getForeignTableName() {
		return notifyRequested(SQLFeatureDescriptorEnum.foreignTableName, foreignTableName);
	}

	public void setForeignTableName(TableName foreignTableName) {
		notifyChanged(SQLFeatureDescriptorEnum.foreignTableName, this.foreignTableName,
				this.foreignTableName = foreignTableName);
	}

	private ColumnNames foreignColumnNames;

	public ColumnNames getForeignColumnNames() {
		return notifyRequested(SQLFeatureDescriptorEnum.foreignColumnNames, foreignColumnNames);
	}

	public void setForeignColumnNames(ColumnNames foreignColumnNames) {
		notifyChanged(SQLFeatureDescriptorEnum.foreignColumnNames, this.foreignColumnNames,
				this.foreignColumnNames = foreignColumnNames);
	}

	private Match match;

	public Match getMatch() {
		return notifyRequested(SQLFeatureDescriptorEnum.match, match);
	}

	public void setMatch(Match match) {
		notifyChanged(SQLFeatureDescriptorEnum.match, this.match, this.match = match);
	}

	private Action onDelete;

	public Action getOnDelete() {
		return notifyRequested(SQLFeatureDescriptorEnum.onDelete, onDelete);
	}

	public void setOnDelete(Action onDelete) {
		notifyChanged(SQLFeatureDescriptorEnum.onDelete, this.onDelete, this.onDelete = onDelete);
	}

	private Action onUpdate;

	public Action getOnUpdate() {
		return notifyRequested(SQLFeatureDescriptorEnum.onUpdate, onUpdate);
	}

	public void setOnUpdate(Action onUpdate) {
		notifyChanged(SQLFeatureDescriptorEnum.onUpdate, this.onUpdate, this.onUpdate = onUpdate);
	}

	private Deferrable deferrable;

	public Deferrable getDeferrable() {
		return notifyRequested(SQLFeatureDescriptorEnum.deferrable, deferrable);
	}

	public void setDeferrable(Deferrable deferrable) {
		notifyChanged(SQLFeatureDescriptorEnum.deferrable, this.deferrable, this.deferrable = deferrable);
	}

	private DeferCheck deferCheck;

	public DeferCheck getDeferCheck() {
		return notifyRequested(SQLFeatureDescriptorEnum.deferCheck, deferCheck);
	}

	public void setDeferCheck(DeferCheck deferCheck) {
		notifyChanged(SQLFeatureDescriptorEnum.deferCheck, this.deferCheck, this.deferCheck = deferCheck);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getConstraintName().wGetAdaptee(false);
		case 1:
			return getColumnNames().wGetAdaptee(false);
		case 2:
			return getForeignTableName().wGetAdaptee(false);
		case 3:
			return getForeignColumnNames().wGetAdaptee(false);
		case 4:
			return getMatch().wGetAdaptee(false);
		case 5:
			return getOnDelete().wGetAdaptee(false);
		case 6:
			return getOnUpdate().wGetAdaptee(false);
		case 7:
			return getDeferrable().wGetAdaptee(false);
		case 8:
			return getDeferCheck().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setConstraintName(value.wGetAdapter(SQLEntityDescriptorEnum.ConstraintName));
			break;
		case 1:
			setColumnNames(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		case 2:
			setForeignTableName(value.wGetAdapter(SQLEntityDescriptorEnum.TableName));
			break;
		case 3:
			setForeignColumnNames(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnNames));
			break;
		case 4:
			setMatch(value.wGetAdapter(SQLEntityDescriptorEnum.Match));
			break;
		case 5:
			setOnDelete(value.wGetAdapter(SQLEntityDescriptorEnum.Action));
			break;
		case 6:
			setOnUpdate(value.wGetAdapter(SQLEntityDescriptorEnum.Action));
			break;
		case 7:
			setDeferrable(value.wGetAdapter(SQLEntityDescriptorEnum.Deferrable));
			break;
		case 8:
			setDeferCheck(value.wGetAdapter(SQLEntityDescriptorEnum.DeferCheck));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 9;
	}
}
