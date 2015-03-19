package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ChooseImpl extends AbstractListCompositeEntity<Rule> implements
		Choose {
	private static final long serialVersionUID = 1;

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Choose_ord;
	}

	public EntityDescriptor<Choose> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Choose;
	}
}
