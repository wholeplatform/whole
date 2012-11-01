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
public class IndexDeclarationAdapter extends AbstractEntityAdapter implements
		IndexDeclaration {
	private static final long serialVersionUID = 1;

	public IndexDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public IndexDeclarationAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IndexDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.IndexDeclaration;
	}

	public ColumnName getColumnName() {
		return wGet(SQLFeatureDescriptorEnum.columnName).wGetAdapter(
				SQLEntityDescriptorEnum.ColumnName);
	}

	public void setColumnName(ColumnName columnName) {
		wSet(SQLFeatureDescriptorEnum.columnName, columnName);
	}

	public OrderType getOrderType() {
		return wGet(SQLFeatureDescriptorEnum.orderType).wGetAdapter(
				SQLEntityDescriptorEnum.OrderType);
	}

	public void setOrderType(OrderType orderType) {
		wSet(SQLFeatureDescriptorEnum.orderType, orderType);
	}

	public NullOrderType getNullOrderType() {
		return wGet(SQLFeatureDescriptorEnum.nullOrderType).wGetAdapter(
				SQLEntityDescriptorEnum.NullOrderType);
	}

	public void setNullOrderType(NullOrderType nullOrderType) {
		wSet(SQLFeatureDescriptorEnum.nullOrderType, nullOrderType);
	}
}
