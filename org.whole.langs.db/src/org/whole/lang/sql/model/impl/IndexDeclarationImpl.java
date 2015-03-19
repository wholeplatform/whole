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
public class IndexDeclarationImpl extends AbstractSimpleEntity implements
		IndexDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IndexDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.IndexDeclaration;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.IndexDeclaration_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private ColumnName columnName;

	public ColumnName getColumnName() {
		return notifyRequested(SQLFeatureDescriptorEnum.columnName, columnName);
	}

	public void setColumnName(ColumnName columnName) {
		notifyChanged(SQLFeatureDescriptorEnum.columnName, this.columnName,
				this.columnName = columnName);
	}

	private OrderType orderType;

	public OrderType getOrderType() {
		return notifyRequested(SQLFeatureDescriptorEnum.orderType, orderType);
	}

	public void setOrderType(OrderType orderType) {
		notifyChanged(SQLFeatureDescriptorEnum.orderType, this.orderType,
				this.orderType = orderType);
	}

	private NullOrderType nullOrderType;

	public NullOrderType getNullOrderType() {
		return notifyRequested(SQLFeatureDescriptorEnum.nullOrderType,
				nullOrderType);
	}

	public void setNullOrderType(NullOrderType nullOrderType) {
		notifyChanged(SQLFeatureDescriptorEnum.nullOrderType,
				this.nullOrderType, this.nullOrderType = nullOrderType);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getColumnName().wGetAdaptee(false);
		case 1:
			return getOrderType().wGetAdaptee(false);
		case 2:
			return getNullOrderType().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setColumnName(value.wGetAdapter(SQLEntityDescriptorEnum.ColumnName));
			break;
		case 1:
			setOrderType(value.wGetAdapter(SQLEntityDescriptorEnum.OrderType));
			break;
		case 2:
			setNullOrderType(value
					.wGetAdapter(SQLEntityDescriptorEnum.NullOrderType));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
