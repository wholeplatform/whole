package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.SaveStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Expression;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SaveStatementImpl extends AbstractSimpleEntity implements SaveStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SaveStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.SaveStatement;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.SaveStatement_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression exp;

	public Expression getExp() {
		return notifyRequested(ImpFeatureDescriptorEnum.exp, exp);
	}

	public void setExp(Expression exp) {
		notifyChanged(ImpFeatureDescriptorEnum.exp, this.exp, this.exp = exp);
	}

	private Expression fileName;

	public Expression getFileName() {
		return notifyRequested(ImpFeatureDescriptorEnum.fileName, fileName);
	}

	public void setFileName(Expression fileName) {
		notifyChanged(ImpFeatureDescriptorEnum.fileName, this.fileName, this.fileName = fileName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getExp().wGetAdaptee(false);
		case 1:
			return getFileName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setExp(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 1:
			setFileName(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
