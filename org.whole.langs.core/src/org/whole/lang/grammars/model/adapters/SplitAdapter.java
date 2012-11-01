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
public class SplitAdapter extends AbstractEntityAdapter implements Split {
	private static final long serialVersionUID = 1;

	public SplitAdapter(IEntity implementor) {
		super(implementor);
	}

	public SplitAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Split> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Split;
	}

	public Splitter getSplitter() {
		return wGet(GrammarsFeatureDescriptorEnum.splitter).wGetAdapter(
				GrammarsEntityDescriptorEnum.Splitter);
	}

	public void setSplitter(Splitter splitter) {
		wSet(GrammarsFeatureDescriptorEnum.splitter, splitter);
	}

	public Rule getRule() {
		return wGet(GrammarsFeatureDescriptorEnum.rule).wGetAdapter(
				GrammarsEntityDescriptorEnum.Rule);
	}

	public void setRule(Rule rule) {
		wSet(GrammarsFeatureDescriptorEnum.rule, rule);
	}
}
