package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ForInComprehensionBlockImpl extends AbstractSimpleEntity implements
		ForInComprehensionBlock {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForInComprehensionBlock> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ForInComprehensionBlock;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ForInComprehensionBlock_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression iterator;

	public Expression getIterator() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.iterator,
				iterator);
	}

	public void setIterator(Expression iterator) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.iterator, this.iterator,
				this.iterator = iterator);
	}

	private Expression iterated;

	public Expression getIterated() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.iterated,
				iterated);
	}

	public void setIterated(Expression iterated) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.iterated, this.iterated,
				this.iterated = iterated);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIterator().wGetAdaptee(false);
		case 1:
			return getIterated().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIterator(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setIterated(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
