package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CustomDataTypeAdapter extends AbstractEntityAdapter implements
		CustomDataType {
	private static final long serialVersionUID = 1;

	public CustomDataTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public CustomDataTypeAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CustomDataType> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.CustomDataType;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
