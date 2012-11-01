package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.model.DataTypeEnum.Value;

/** 
 * @generator Whole
 */
public class DataTypeAdapter extends AbstractEntityAdapter implements DataType {
	private static final long serialVersionUID = 1;

	public DataTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public DataTypeAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DataType> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.DataType;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
