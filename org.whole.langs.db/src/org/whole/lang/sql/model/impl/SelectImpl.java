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
public class SelectImpl extends AbstractSimpleEntity implements Select {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Select> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Select;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Select_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private SelectType selectType;

	public SelectType getSelectType() {
		return notifyRequested(SQLFeatureDescriptorEnum.selectType, selectType);
	}

	public void setSelectType(SelectType selectType) {
		notifyChanged(SQLFeatureDescriptorEnum.selectType, this.selectType,
				this.selectType = selectType);
	}

	private ColumnExpressions columnExprs;

	public ColumnExpressions getColumnExprs() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnExprs,
				columnExprs);
	}

	public void setColumnExprs(ColumnExpressions columnExprs) {
		notifyChanged(SQLFeatureDescriptorEnum.columnExprs, this.columnExprs,
				this.columnExprs = columnExprs);
	}

	private FromClauses fromClauses;

	public FromClauses getFromClauses() {
		return notifyRequested(SQLFeatureDescriptorEnum.fromClauses,
				fromClauses);
	}

	public void setFromClauses(FromClauses fromClauses) {
		notifyChanged(SQLFeatureDescriptorEnum.fromClauses, this.fromClauses,
				this.fromClauses = fromClauses);
	}

	private SQLExpression whereExpr;

	public SQLExpression getWhereExpr() {
		return notifyRequested(SQLFeatureDescriptorEnum.whereExpr, whereExpr);
	}

	public void setWhereExpr(SQLExpression whereExpr) {
		notifyChanged(SQLFeatureDescriptorEnum.whereExpr, this.whereExpr,
				this.whereExpr = whereExpr);
	}

	private SQLExpressions groupByExprs;

	public SQLExpressions getGroupByExprs() {
		return notifyRequested(SQLFeatureDescriptorEnum.groupByExprs,
				groupByExprs);
	}

	public void setGroupByExprs(SQLExpressions groupByExprs) {
		notifyChanged(SQLFeatureDescriptorEnum.groupByExprs, this.groupByExprs,
				this.groupByExprs = groupByExprs);
	}

	private SQLExpression havingExpr;

	public SQLExpression getHavingExpr() {
		return notifyRequested(SQLFeatureDescriptorEnum.havingExpr, havingExpr);
	}

	public void setHavingExpr(SQLExpression havingExpr) {
		notifyChanged(SQLFeatureDescriptorEnum.havingExpr, this.havingExpr,
				this.havingExpr = havingExpr);
	}

	private OrderByColumnExpressions orderByColumnExprs;

	public OrderByColumnExpressions getOrderByColumnExprs() {
		return notifyRequested(SQLFeatureDescriptorEnum.orderByColumnExprs,
				orderByColumnExprs);
	}

	public void setOrderByColumnExprs(
			OrderByColumnExpressions orderByColumnExprs) {
		notifyChanged(SQLFeatureDescriptorEnum.orderByColumnExprs,
				this.orderByColumnExprs,
				this.orderByColumnExprs = orderByColumnExprs);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSelectType().wGetAdaptee(false);
		case 1:
			return getColumnExprs().wGetAdaptee(false);
		case 2:
			return getFromClauses().wGetAdaptee(false);
		case 3:
			return getWhereExpr().wGetAdaptee(false);
		case 4:
			return getGroupByExprs().wGetAdaptee(false);
		case 5:
			return getHavingExpr().wGetAdaptee(false);
		case 6:
			return getOrderByColumnExprs().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSelectType(value.wGetAdapter(SQLEntityDescriptorEnum.SelectType));
			break;
		case 1:
			setColumnExprs(value
					.wGetAdapter(SQLEntityDescriptorEnum.ColumnExpressions));
			break;
		case 2:
			setFromClauses(value
					.wGetAdapter(SQLEntityDescriptorEnum.FromClauses));
			break;
		case 3:
			setWhereExpr(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 4:
			setGroupByExprs(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpressions));
			break;
		case 5:
			setHavingExpr(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLExpression));
			break;
		case 6:
			setOrderByColumnExprs(value
					.wGetAdapter(SQLEntityDescriptorEnum.OrderByColumnExpressions));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 7;
	}
}
