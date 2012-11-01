package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CharDataAdapter extends AbstractEntityAdapter implements CharData {
	private static final long serialVersionUID = 1;

	public CharDataAdapter(IEntity implementor) {
		super(implementor);
	}

	public CharDataAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CharData> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.CharData;
	}

	public char getValue() {
		return wCharValue();
	}

	public void setValue(char value) {
		wSetValue(value);
	}
}
