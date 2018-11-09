package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.Foreach;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.Name;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.ArrayExpr;
import org.whole.lang.sql.model.SQLStatement;

/** 
 * @generator Whole
 */
public class ForeachImpl extends AbstractSimpleEntity implements Foreach {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Foreach> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Foreach;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Foreach_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(SQLFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(SQLFeatureDescriptorEnum.name, this.name, this.name = name);
	}

	private ArrayExpr arrayExp;

	public ArrayExpr getArrayExp() {
		return notifyRequested(SQLFeatureDescriptorEnum.arrayExp, arrayExp);
	}

	public void setArrayExp(ArrayExpr arrayExp) {
		notifyChanged(SQLFeatureDescriptorEnum.arrayExp, this.arrayExp, this.arrayExp = arrayExp);
	}

	private SQLStatement trueBody;

	public SQLStatement getTrueBody() {
		return notifyRequested(SQLFeatureDescriptorEnum.trueBody, trueBody);
	}

	public void setTrueBody(SQLStatement trueBody) {
		notifyChanged(SQLFeatureDescriptorEnum.trueBody, this.trueBody, this.trueBody = trueBody);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getArrayExp().wGetAdaptee(false);
		case 2:
			return getTrueBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SQLEntityDescriptorEnum.Name));
			break;
		case 1:
			setArrayExp(value.wGetAdapter(SQLEntityDescriptorEnum.ArrayExpr));
			break;
		case 2:
			setTrueBody(value.wGetAdapter(SQLEntityDescriptorEnum.SQLStatement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
