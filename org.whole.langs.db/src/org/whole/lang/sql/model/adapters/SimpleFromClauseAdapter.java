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
public class SimpleFromClauseAdapter extends AbstractEntityAdapter implements SimpleFromClause {
	private static final long serialVersionUID = 1;

	public SimpleFromClauseAdapter(IEntity implementor) {
		super(implementor);
	}

	public SimpleFromClauseAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SimpleFromClause> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.SimpleFromClause;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
