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
public class TryStatementImpl extends AbstractSimpleEntity implements
		TryStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TryStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.TryStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.TryStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Statements _try;

	public Statements getTry() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum._try, _try);
	}

	public void setTry(Statements _try) {
		notifyChanged(JavaScriptFeatureDescriptorEnum._try, this._try,
				this._try = _try);
	}

	private CatchClauses handlers;

	public CatchClauses getHandlers() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.handlers,
				handlers);
	}

	public void setHandlers(CatchClauses handlers) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.handlers, this.handlers,
				this.handlers = handlers);
	}

	private Statements _finally;

	public Statements getFinally() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum._finally,
				_finally);
	}

	public void setFinally(Statements _finally) {
		notifyChanged(JavaScriptFeatureDescriptorEnum._finally, this._finally,
				this._finally = _finally);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTry().wGetAdaptee(false);
		case 1:
			return getHandlers().wGetAdaptee(false);
		case 2:
			return getFinally().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTry(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Statements));
			break;
		case 1:
			setHandlers(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.CatchClauses));
			break;
		case 2:
			setFinally(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Statements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
