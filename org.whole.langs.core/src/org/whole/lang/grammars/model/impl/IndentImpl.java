package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;

/** 
 * @generator Whole
 */
public class IndentImpl extends AbstractSimpleEntity implements Indent {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Indent> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Indent;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Indent_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
