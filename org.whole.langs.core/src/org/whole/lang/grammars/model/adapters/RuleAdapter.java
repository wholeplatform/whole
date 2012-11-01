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
public class RuleAdapter extends AbstractEntityAdapter implements Rule {
	private static final long serialVersionUID = 1;

	public RuleAdapter(IEntity implementor) {
		super(implementor);
	}

	public RuleAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Rule> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Rule;
	}
}
