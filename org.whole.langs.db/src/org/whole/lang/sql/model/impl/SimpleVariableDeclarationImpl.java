package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.SimpleVariableDeclaration;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.Name;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.Type;

/** 
 * @generator Whole
 */
public class SimpleVariableDeclarationImpl extends AbstractSimpleEntity implements SimpleVariableDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SimpleVariableDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SimpleVariableDeclaration;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.SimpleVariableDeclaration_ord;
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

	private Type type;

	public Type getType() {
		return notifyRequested(SQLFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(SQLFeatureDescriptorEnum.type, this.type, this.type = type);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
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
			setType(value.wGetAdapter(SQLEntityDescriptorEnum.Type));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
