package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ConstraintNameAdapter extends AbstractEntityAdapter implements ConstraintName {
	private static final long serialVersionUID = 1;

	public ConstraintNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConstraintNameAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConstraintName> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ConstraintName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
