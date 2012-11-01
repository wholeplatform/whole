package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import java.sql.Blob;

/** 
 * @generator Whole
 */
public class BlobValueAdapter extends AbstractEntityAdapter implements
		BlobValue {
	private static final long serialVersionUID = 1;

	public BlobValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public BlobValueAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BlobValue> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.BlobValue;
	}

	public Blob getValue() {
		return (Blob) wGetValue();
	}

	public void setValue(Blob value) {
		wSetValue((Object) value);
	}
}
