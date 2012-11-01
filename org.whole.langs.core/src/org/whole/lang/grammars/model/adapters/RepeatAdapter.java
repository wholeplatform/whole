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
public class RepeatAdapter extends AbstractEntityAdapter implements Repeat {
	private static final long serialVersionUID = 1;

	public RepeatAdapter(IEntity implementor) {
		super(implementor);
	}

	public RepeatAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Repeat> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Repeat;
	}

	public Size getLowerBound() {
		return wGet(GrammarsFeatureDescriptorEnum.lowerBound).wGetAdapter(
				GrammarsEntityDescriptorEnum.Size);
	}

	public void setLowerBound(Size lowerBound) {
		wSet(GrammarsFeatureDescriptorEnum.lowerBound, lowerBound);
	}

	public Bound getUpperBound() {
		return wGet(GrammarsFeatureDescriptorEnum.upperBound).wGetAdapter(
				GrammarsEntityDescriptorEnum.Bound);
	}

	public void setUpperBound(Bound upperBound) {
		wSet(GrammarsFeatureDescriptorEnum.upperBound, upperBound);
	}

	public Rule getSeparator() {
		return wGet(GrammarsFeatureDescriptorEnum.separator).wGetAdapter(
				GrammarsEntityDescriptorEnum.Rule);
	}

	public void setSeparator(Rule separator) {
		wSet(GrammarsFeatureDescriptorEnum.separator, separator);
	}

	public Rule getRule() {
		return wGet(GrammarsFeatureDescriptorEnum.rule).wGetAdapter(
				GrammarsEntityDescriptorEnum.Rule);
	}

	public void setRule(Rule rule) {
		wSet(GrammarsFeatureDescriptorEnum.rule, rule);
	}
}
