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
public class LiteralTokenAdapter extends AbstractEntityAdapter implements
		LiteralToken {
	private static final long serialVersionUID = 1;

	public LiteralTokenAdapter(IEntity implementor) {
		super(implementor);
	}

	public LiteralTokenAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LiteralToken> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.LiteralToken;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
