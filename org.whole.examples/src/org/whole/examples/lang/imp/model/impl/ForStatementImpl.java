package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.ForStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.VariableDeclaration;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.model.Statement;

/** 
 * @generator Whole
 */
public class ForStatementImpl extends AbstractSimpleEntity implements ForStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ForStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.ForStatement_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private VariableDeclaration initializer;

	public VariableDeclaration getInitializer() {
		return notifyRequested(ImpFeatureDescriptorEnum.initializer, initializer);
	}

	public void setInitializer(VariableDeclaration initializer) {
		notifyChanged(ImpFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
	}

	private Expression condition;

	public Expression getCondition() {
		return notifyRequested(ImpFeatureDescriptorEnum.condition, condition);
	}

	public void setCondition(Expression condition) {
		notifyChanged(ImpFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
	}

	private Expression updater;

	public Expression getUpdater() {
		return notifyRequested(ImpFeatureDescriptorEnum.updater, updater);
	}

	public void setUpdater(Expression updater) {
		notifyChanged(ImpFeatureDescriptorEnum.updater, this.updater, this.updater = updater);
	}

	private Statement trueBody;

	public Statement getTrueBody() {
		return notifyRequested(ImpFeatureDescriptorEnum.trueBody, trueBody);
	}

	public void setTrueBody(Statement trueBody) {
		notifyChanged(ImpFeatureDescriptorEnum.trueBody, this.trueBody, this.trueBody = trueBody);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getInitializer().wGetAdaptee(false);
		case 1:
			return getCondition().wGetAdaptee(false);
		case 2:
			return getUpdater().wGetAdaptee(false);
		case 3:
			return getTrueBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setInitializer(value.wGetAdapter(ImpEntityDescriptorEnum.VariableDeclaration));
			break;
		case 1:
			setCondition(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 2:
			setUpdater(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 3:
			setTrueBody(value.wGetAdapter(ImpEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
