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
public class IndentAdapter extends AbstractEntityAdapter implements Indent {
	private static final long serialVersionUID = 1;

	public IndentAdapter(IEntity implementor) {
		super(implementor);
	}

	public IndentAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Indent> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Indent;
	}
}
