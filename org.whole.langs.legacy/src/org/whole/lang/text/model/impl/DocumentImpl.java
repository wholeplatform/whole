package org.whole.lang.text.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.text.model.*;
import org.whole.lang.text.visitors.ITextVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class DocumentImpl extends AbstractListCompositeEntity<IRow> implements Document {
	private static final long serialVersionUID = 1;

	public void accept(ITextVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return TextEntityDescriptorEnum.Document_ord;
	}

	public EntityDescriptor<Document> wGetEntityDescriptor() {
		return TextEntityDescriptorEnum.Document;
	}
}
