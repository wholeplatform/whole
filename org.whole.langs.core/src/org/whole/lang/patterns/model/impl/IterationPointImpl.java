package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class IterationPointImpl extends AbstractSimpleEntity implements
		IterationPoint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<IterationPoint> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.IterationPoint;
	}

	public int wGetEntityOrd() {
		return PatternsEntityDescriptorEnum.IterationPoint_ord;
	}

	public void accept(IPatternsVisitor visitor) {
		visitor.visit(this);
	}

	private PathExpression iterator;

	public PathExpression getIterator() {
		return notifyRequested(PatternsFeatureDescriptorEnum.iterator, iterator);
	}

	public void setIterator(PathExpression iterator) {
		notifyChanged(PatternsFeatureDescriptorEnum.iterator, this.iterator,
				this.iterator = iterator);
	}

	private Template template;

	public Template getTemplate() {
		return notifyRequested(PatternsFeatureDescriptorEnum.template, template);
	}

	public void setTemplate(Template template) {
		notifyChanged(PatternsFeatureDescriptorEnum.template, this.template,
				this.template = template);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIterator().wGetAdaptee(false);
		case 1:
			return getTemplate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIterator(value
					.wGetAdapter(PatternsEntityDescriptorEnum.PathExpression));
			break;
		case 1:
			setTemplate(value
					.wGetAdapter(PatternsEntityDescriptorEnum.Template));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
