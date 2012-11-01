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
public class KeywordTokenAdapter extends AbstractEntityAdapter implements
		KeywordToken {
	private static final long serialVersionUID = 1;

	public KeywordTokenAdapter(IEntity implementor) {
		super(implementor);
	}

	public KeywordTokenAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<KeywordToken> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.KeywordToken;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
