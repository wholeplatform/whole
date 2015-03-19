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
public class ForInStatementImpl extends AbstractSimpleEntity implements
		ForInStatement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForInStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ForInStatement;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.ForInStatement_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private VariableDeclarationOrExpression iterator;

	public VariableDeclarationOrExpression getIterator() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.iterator,
				iterator);
	}

	public void setIterator(VariableDeclarationOrExpression iterator) {
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

	private Statement body;

	public Statement getBody() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statement body) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIterator().wGetAdaptee(false);
		case 1:
			return getIterated().wGetAdaptee(false);
		case 2:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIterator(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.VariableDeclarationOrExpression));
			break;
		case 1:
			setIterated(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 2:
			setBody(value.wGetAdapter(JavaScriptEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
