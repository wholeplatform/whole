package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import java.sql.Clob;

/** 
 * @generator Whole
 */
public class ClobValueAdapter extends AbstractEntityAdapter implements ClobValue {
	private static final long serialVersionUID = 1;

	public ClobValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public ClobValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ClobValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ClobValue;
	}

	public Clob getValue() {
		return (Clob) wGetValue();
	}

	public void setValue(Clob value) {
		wSetValue((Object) value);
	}
}
