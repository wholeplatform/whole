package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;

/** 
 * @generator Whole
 */
public class NewLineImpl extends AbstractSimpleEntity implements NewLine {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NewLine> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.NewLine;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.NewLine_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		visitor.visit(this);
	}
}
