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
public class OperatorTokenAdapter extends AbstractEntityAdapter implements
		OperatorToken {
	private static final long serialVersionUID = 1;

	public OperatorTokenAdapter(IEntity implementor) {
		super(implementor);
	}

	public OperatorTokenAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<OperatorToken> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.OperatorToken;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
