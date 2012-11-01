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
public class AsAdapter extends AbstractEntityAdapter implements As {
	private static final long serialVersionUID = 1;

	public AsAdapter(IEntity implementor) {
		super(implementor);
	}

	public AsAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<As> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.As;
	}

	public Rule getRule() {
		return wGet(GrammarsFeatureDescriptorEnum.rule).wGetAdapter(
				GrammarsEntityDescriptorEnum.Rule);
	}

	public void setRule(Rule rule) {
		wSet(GrammarsFeatureDescriptorEnum.rule, rule);
	}

	public Name getName() {
		return wGet(GrammarsFeatureDescriptorEnum.name).wGetAdapter(
				GrammarsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(GrammarsFeatureDescriptorEnum.name, name);
	}
}
