package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ProductionsImpl extends
		AbstractCollectionCompositeEntity<Production> implements Productions {
	private static final long serialVersionUID = 1;

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Productions_ord;
	}

	public EntityDescriptor<Productions> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Productions;
	}
}
