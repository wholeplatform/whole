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
public class ArrayComprehensionExpressionImpl extends AbstractSimpleEntity
		implements ArrayComprehensionExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ArrayComprehensionExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.expression,
				this.expression, this.expression = expression);
	}

	private ComprehensionBlocks blocks;

	public ComprehensionBlocks getBlocks() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.blocks, blocks);
	}

	public void setBlocks(ComprehensionBlocks blocks) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.blocks, this.blocks,
				this.blocks = blocks);
	}

	private Expression filter;

	public Expression getFilter() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.filter, filter);
	}

	public void setFilter(Expression filter) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.filter, this.filter,
				this.filter = filter);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getBlocks().wGetAdaptee(false);
		case 2:
			return getFilter().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setBlocks(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.ComprehensionBlocks));
			break;
		case 2:
			setFilter(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
