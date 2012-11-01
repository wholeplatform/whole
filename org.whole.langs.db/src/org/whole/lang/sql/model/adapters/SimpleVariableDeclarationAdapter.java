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
public class SimpleVariableDeclarationAdapter extends AbstractEntityAdapter
		implements SimpleVariableDeclaration {
	private static final long serialVersionUID = 1;

	public SimpleVariableDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleVariableDeclarationAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleVariableDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SimpleVariableDeclaration;
	}

	public Name getName() {
		return wGet(SQLFeatureDescriptorEnum.name).wGetAdapter(
				SQLEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SQLFeatureDescriptorEnum.name, name);
	}

	public Type getType() {
		return wGet(SQLFeatureDescriptorEnum.type).wGetAdapter(
				SQLEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(SQLFeatureDescriptorEnum.type, type);
	}
}
