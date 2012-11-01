package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class OptionalAdapter extends AbstractEntityAdapter implements Optional {
	private static final long serialVersionUID = 1;

	public OptionalAdapter(IEntity implementor) {
		super(implementor);
	}

	public OptionalAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Optional> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Optional;
	}

	public Rule getRule() {
		return wGet(GrammarsFeatureDescriptorEnum.rule).wGetAdapter(
				GrammarsEntityDescriptorEnum.Rule);
	}

	public void setRule(Rule rule) {
		wSet(GrammarsFeatureDescriptorEnum.rule, rule);
	}
}
