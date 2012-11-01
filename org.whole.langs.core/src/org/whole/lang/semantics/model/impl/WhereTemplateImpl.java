package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class WhereTemplateImpl extends AbstractSimpleEntity implements
		WhereTemplate {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<WhereTemplate> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.WhereTemplate;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.WhereTemplate_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Expression expression;

	public Expression getExpression() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(Expression expression) {
		notifyChanged(SemanticsFeatureDescriptorEnum.expression,
				this.expression, this.expression = expression);
	}

	private InputBindings where;

	public InputBindings getWhere() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.where, where);
	}

	public void setWhere(InputBindings where) {
		notifyChanged(SemanticsFeatureDescriptorEnum.where, this.where,
				this.where = where);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExpression().wGetAdaptee(false);
		case 1:
			return getWhere().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExpression(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
			break;
		case 1:
			setWhere(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.InputBindings));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
