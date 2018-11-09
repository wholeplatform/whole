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
public class FunctionNameAdapter extends AbstractEntityAdapter implements FunctionName {
	private static final long serialVersionUID = 1;

	public FunctionNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionNameAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionName> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.FunctionName;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
