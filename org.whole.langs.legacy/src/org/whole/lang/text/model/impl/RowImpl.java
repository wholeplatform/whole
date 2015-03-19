package org.whole.lang.text.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.text.model.*;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class RowImpl extends AbstractListCompositeEntity<IText> implements Row {
	private static final long serialVersionUID = 1;

	public void accept(ITextVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TextEntityDescriptorEnum.Row_ord;
	}

	public EntityDescriptor<Row> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Row;
	}
}
