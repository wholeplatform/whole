package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ChooseAdapter extends AbstractListEntityAdapter<Rule> implements
		Choose {
	private static final long serialVersionUID = 1;

	public ChooseAdapter(IEntity implementor) {
		super(implementor);
	}

	public ChooseAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Choose> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Choose;
	}
}
