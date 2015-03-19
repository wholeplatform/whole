package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class CompiledPatternImpl extends AbstractDataEntity implements
		CompiledPattern {
	private static final long serialVersionUID = 1;
	private java.util.regex.Pattern value;

	public java.util.regex.Pattern getValue() {
		return notifyRequested(value);
	}

	public void setValue(java.util.regex.Pattern value) {
		notifyChanged(this.value, this.value = value);
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.CompiledPattern_ord;
	}

	public EntityDescriptor<CompiledPattern> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.CompiledPattern;
	}

	public Object wGetValue() {
		return getValue();
	}

	public void wSetValue(Object value) {
		setValue((java.util.regex.Pattern) value);
	}
}
