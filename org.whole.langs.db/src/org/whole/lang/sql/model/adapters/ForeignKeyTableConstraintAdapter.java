package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ForeignKeyTableConstraintAdapter extends AbstractEntityAdapter implements ForeignKeyTableConstraint {
	private static final long serialVersionUID = 1;

	public ForeignKeyTableConstraintAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForeignKeyTableConstraintAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForeignKeyTableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ForeignKeyTableConstraint;
	}

	public ConstraintName getConstraintName() {
		return wGet(SQLFeatureDescriptorEnum.constraintName).wGetAdapter(SQLEntityDescriptorEnum.ConstraintName);
	}

	public void setConstraintName(ConstraintName constraintName) {
		wSet(SQLFeatureDescriptorEnum.constraintName, constraintName);
	}

	public ColumnNames getColumnNames() {
		return wGet(SQLFeatureDescriptorEnum.columnNames).wGetAdapter(SQLEntityDescriptorEnum.ColumnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		wSet(SQLFeatureDescriptorEnum.columnNames, columnNames);
	}

	public TableName getForeignTableName() {
		return wGet(SQLFeatureDescriptorEnum.foreignTableName).wGetAdapter(SQLEntityDescriptorEnum.TableName);
	}

	public void setForeignTableName(TableName foreignTableName) {
		wSet(SQLFeatureDescriptorEnum.foreignTableName, foreignTableName);
	}

	public ColumnNames getForeignColumnNames() {
		return wGet(SQLFeatureDescriptorEnum.foreignColumnNames).wGetAdapter(SQLEntityDescriptorEnum.ColumnNames);
	}

	public void setForeignColumnNames(ColumnNames foreignColumnNames) {
		wSet(SQLFeatureDescriptorEnum.foreignColumnNames, foreignColumnNames);
	}

	public Match getMatch() {
		return wGet(SQLFeatureDescriptorEnum.match).wGetAdapter(SQLEntityDescriptorEnum.Match);
	}

	public void setMatch(Match match) {
		wSet(SQLFeatureDescriptorEnum.match, match);
	}

	public Action getOnDelete() {
		return wGet(SQLFeatureDescriptorEnum.onDelete).wGetAdapter(SQLEntityDescriptorEnum.Action);
	}

	public void setOnDelete(Action onDelete) {
		wSet(SQLFeatureDescriptorEnum.onDelete, onDelete);
	}

	public Action getOnUpdate() {
		return wGet(SQLFeatureDescriptorEnum.onUpdate).wGetAdapter(SQLEntityDescriptorEnum.Action);
	}

	public void setOnUpdate(Action onUpdate) {
		wSet(SQLFeatureDescriptorEnum.onUpdate, onUpdate);
	}

	public Deferrable getDeferrable() {
		return wGet(SQLFeatureDescriptorEnum.deferrable).wGetAdapter(SQLEntityDescriptorEnum.Deferrable);
	}

	public void setDeferrable(Deferrable deferrable) {
		wSet(SQLFeatureDescriptorEnum.deferrable, deferrable);
	}

	public DeferCheck getDeferCheck() {
		return wGet(SQLFeatureDescriptorEnum.deferCheck).wGetAdapter(SQLEntityDescriptorEnum.DeferCheck);
	}

	public void setDeferCheck(DeferCheck deferCheck) {
		wSet(SQLFeatureDescriptorEnum.deferCheck, deferCheck);
	}
}
