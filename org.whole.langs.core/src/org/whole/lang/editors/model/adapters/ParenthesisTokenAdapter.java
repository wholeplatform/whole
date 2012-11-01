package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ParenthesisTokenAdapter extends AbstractEntityAdapter implements
		ParenthesisToken {
	private static final long serialVersionUID = 1;

	public ParenthesisTokenAdapter(IEntity implementor) {
		super(implementor);
	}

	public ParenthesisTokenAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ParenthesisToken> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.ParenthesisToken;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
