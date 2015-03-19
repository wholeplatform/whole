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
public class VariableDeclarationImpl extends AbstractSimpleEntity implements
		VariableDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.VariableDeclaration;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.VariableDeclaration_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private VariableDeclarationKind kind;

	public VariableDeclarationKind getKind() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.kind, kind);
	}

	public void setKind(VariableDeclarationKind kind) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.kind, this.kind,
				this.kind = kind);
	}

	private VariableInitializers variables;

	public VariableInitializers getVariables() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.variables,
				variables);
	}

	public void setVariables(VariableInitializers variables) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.variables,
				this.variables, this.variables = variables);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getKind().wGetAdaptee(false);
		case 1:
			return getVariables().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setKind(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.VariableDeclarationKind));
			break;
		case 1:
			setVariables(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.VariableInitializers));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
