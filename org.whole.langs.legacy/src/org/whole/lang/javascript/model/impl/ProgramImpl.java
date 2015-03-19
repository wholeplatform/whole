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
public class ProgramImpl extends AbstractSimpleEntity implements Program {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Program> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Program;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.Program_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Statements statements;

	public Statements getStatements() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.statements,
				statements);
	}

	public void setStatements(Statements statements) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.statements,
				this.statements, this.statements = statements);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getStatements().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setStatements(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Statements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
