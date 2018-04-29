package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.ForeachStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Name;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.model.Statement;

/** 
 * @generator Whole
 */
public class ForeachStatementImpl extends AbstractSimpleEntity implements ForeachStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForeachStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.ForeachStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.ForeachStatement_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(ImpFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(ImpFeatureDescriptorEnum.name, this.name, this.name = name);
	}

	private Expression arrayExp;

	public Expression getArrayExp() {
		return notifyRequested(ImpFeatureDescriptorEnum.arrayExp, arrayExp);
	}

	public void setArrayExp(Expression arrayExp) {
		notifyChanged(ImpFeatureDescriptorEnum.arrayExp, this.arrayExp, this.arrayExp = arrayExp);
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
			return getName().wGetAdaptee(false);
		case 1:
			return getArrayExp().wGetAdaptee(false);
		case 2:
			return getTrueBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(ImpEntityDescriptorEnum.Name));
			break;
		case 1:
			setArrayExp(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 2:
			setTrueBody(value.wGetAdapter(ImpEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
