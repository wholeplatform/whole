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
public class SelectAdapter extends AbstractEntityAdapter implements Select {
	private static final long serialVersionUID = 1;

	public SelectAdapter(IEntity implementor) {
		super(implementor);
	}

	public SelectAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Select> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Select;
	}

	public SelectType getSelectType() {
		return wGet(SQLFeatureDescriptorEnum.selectType).wGetAdapter(SQLEntityDescriptorEnum.SelectType);
	}

	public void setSelectType(SelectType selectType) {
		wSet(SQLFeatureDescriptorEnum.selectType, selectType);
	}

	public ColumnExpressions getColumnExprs() {
		return wGet(SQLFeatureDescriptorEnum.columnExprs).wGetAdapter(SQLEntityDescriptorEnum.ColumnExpressions);
	}

	public void setColumnExprs(ColumnExpressions columnExprs) {
		wSet(SQLFeatureDescriptorEnum.columnExprs, columnExprs);
	}

	public FromClauses getFromClauses() {
		return wGet(SQLFeatureDescriptorEnum.fromClauses).wGetAdapter(SQLEntityDescriptorEnum.FromClauses);
	}

	public void setFromClauses(FromClauses fromClauses) {
		wSet(SQLFeatureDescriptorEnum.fromClauses, fromClauses);
	}

	public SQLExpression getWhereExpr() {
		return wGet(SQLFeatureDescriptorEnum.whereExpr).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setWhereExpr(SQLExpression whereExpr) {
		wSet(SQLFeatureDescriptorEnum.whereExpr, whereExpr);
	}

	public SQLExpressions getGroupByExprs() {
		return wGet(SQLFeatureDescriptorEnum.groupByExprs).wGetAdapter(SQLEntityDescriptorEnum.SQLExpressions);
	}

	public void setGroupByExprs(SQLExpressions groupByExprs) {
		wSet(SQLFeatureDescriptorEnum.groupByExprs, groupByExprs);
	}

	public SQLExpression getHavingExpr() {
		return wGet(SQLFeatureDescriptorEnum.havingExpr).wGetAdapter(SQLEntityDescriptorEnum.SQLExpression);
	}

	public void setHavingExpr(SQLExpression havingExpr) {
		wSet(SQLFeatureDescriptorEnum.havingExpr, havingExpr);
	}

	public OrderByColumnExpressions getOrderByColumnExprs() {
		return wGet(SQLFeatureDescriptorEnum.orderByColumnExprs)
				.wGetAdapter(SQLEntityDescriptorEnum.OrderByColumnExpressions);
	}

	public void setOrderByColumnExprs(OrderByColumnExpressions orderByColumnExprs) {
		wSet(SQLFeatureDescriptorEnum.orderByColumnExprs, orderByColumnExprs);
	}
}
