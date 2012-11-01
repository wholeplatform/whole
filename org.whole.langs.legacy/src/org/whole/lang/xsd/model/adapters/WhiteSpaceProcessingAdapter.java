package org.whole.lang.xsd.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xsd.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsd.model.WhiteSpaceProcessingEnum.Value;

/** 
 * @generator Whole
 */
public class WhiteSpaceProcessingAdapter extends AbstractEntityAdapter
		implements WhiteSpaceProcessing {
	private static final long serialVersionUID = 1;

	public WhiteSpaceProcessingAdapter(IEntity implementor) {
		super(implementor);
	}

	public WhiteSpaceProcessingAdapter() {
	}

	public void accept(IXsdVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WhiteSpaceProcessing> wGetEntityDescriptor() {
		return XsdEntityDescriptorEnum.WhiteSpaceProcessing;
	}

	public Value getValue() {
		return (Value) wEnumValue();
	}

	public void setValue(Value value) {
		wSetValue(value);
	}
}
