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
public class VariableDeclarationAdapter extends AbstractEntityAdapter implements
		VariableDeclaration {
	private static final long serialVersionUID = 1;

	public VariableDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableDeclarationAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.VariableDeclaration;
	}

	public VariableDeclarationKind getKind() {
		return wGet(JavaScriptFeatureDescriptorEnum.kind).wGetAdapter(
				JavaScriptEntityDescriptorEnum.VariableDeclarationKind);
	}

	public void setKind(VariableDeclarationKind kind) {
		wSet(JavaScriptFeatureDescriptorEnum.kind, kind);
	}

	public VariableInitializers getVariables() {
		return wGet(JavaScriptFeatureDescriptorEnum.variables).wGetAdapter(
				JavaScriptEntityDescriptorEnum.VariableInitializers);
	}

	public void setVariables(VariableInitializers variables) {
		wSet(JavaScriptFeatureDescriptorEnum.variables, variables);
	}
}
