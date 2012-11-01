package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ArrayComprehensionExpressionAdapter extends AbstractEntityAdapter
		implements ArrayComprehensionExpression {
	private static final long serialVersionUID = 1;

	public ArrayComprehensionExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ArrayComprehensionExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ArrayComprehensionExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ArrayComprehensionExpression;
	}

	public Expression getExpression() {
		return wGet(JavaScriptFeatureDescriptorEnum.expression).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaScriptFeatureDescriptorEnum.expression, expression);
	}

	public ComprehensionBlocks getBlocks() {
		return wGet(JavaScriptFeatureDescriptorEnum.blocks).wGetAdapter(
				JavaScriptEntityDescriptorEnum.ComprehensionBlocks);
	}

	public void setBlocks(ComprehensionBlocks blocks) {
		wSet(JavaScriptFeatureDescriptorEnum.blocks, blocks);
	}

	public Expression getFilter() {
		return wGet(JavaScriptFeatureDescriptorEnum.filter).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setFilter(Expression filter) {
		wSet(JavaScriptFeatureDescriptorEnum.filter, filter);
	}
}
