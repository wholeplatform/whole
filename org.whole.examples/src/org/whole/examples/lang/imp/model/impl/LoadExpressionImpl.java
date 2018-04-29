package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.LoadExpression;
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
public class LoadExpressionImpl extends AbstractSimpleEntity implements LoadExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LoadExpression> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.LoadExpression;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.LoadExpression_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Expression fileName;

	public Expression getFileName() {
		return notifyRequested(ImpFeatureDescriptorEnum.fileName, fileName);
	}

	public void setFileName(Expression fileName) {
		notifyChanged(ImpFeatureDescriptorEnum.fileName, this.fileName, this.fileName = fileName);
	}

	private Expression language;

	public Expression getLanguage() {
		return notifyRequested(ImpFeatureDescriptorEnum.language, language);
	}

	public void setLanguage(Expression language) {
		notifyChanged(ImpFeatureDescriptorEnum.language, this.language, this.language = language);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFileName().wGetAdaptee(false);
		case 1:
			return getLanguage().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFileName(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		case 1:
			setLanguage(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
