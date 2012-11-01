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
public class WhenAdapter extends AbstractEntityAdapter implements When {
	private static final long serialVersionUID = 1;

	public WhenAdapter(IEntity implementor) {
		super(implementor);
	}

	public WhenAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<When> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.When;
	}

	public Predicate getPredicate() {
		return wGet(GrammarsFeatureDescriptorEnum.predicate).wGetAdapter(
				GrammarsEntityDescriptorEnum.Predicate);
	}

	public void setPredicate(Predicate predicate) {
		wSet(GrammarsFeatureDescriptorEnum.predicate, predicate);
	}

	public Rule getRule() {
		return wGet(GrammarsFeatureDescriptorEnum.rule).wGetAdapter(
				GrammarsEntityDescriptorEnum.Rule);
	}

	public void setRule(Rule rule) {
		wSet(GrammarsFeatureDescriptorEnum.rule, rule);
	}
}
