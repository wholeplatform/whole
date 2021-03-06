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
public class IdentifierTokenAdapter extends AbstractEntityAdapter implements
		IdentifierToken {
	private static final long serialVersionUID = 1;

	public IdentifierTokenAdapter(IEntity implementor) {
		super(implementor);
	}

	public IdentifierTokenAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IdentifierToken> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.IdentifierToken;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
