package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class VariableDeclarationExpressionAdapter extends AbstractEntityAdapter
		implements VariableDeclarationExpression {
	private static final long serialVersionUID = 1;

	public VariableDeclarationExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableDeclarationExpressionAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableDeclarationExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.VariableDeclarationExpression;
	}

	public ExtendedModifiers getModifiers() {
		return wGet(JavaFeatureDescriptorEnum.modifiers).wGetAdapter(
				JavaEntityDescriptorEnum.ExtendedModifiers);
	}

	public void setModifiers(ExtendedModifiers modifiers) {
		wSet(JavaFeatureDescriptorEnum.modifiers, modifiers);
	}

	public Type getType() {
		return wGet(JavaFeatureDescriptorEnum.type).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(JavaFeatureDescriptorEnum.type, type);
	}

	public VariableDeclarationFragments getFragments() {
		return wGet(JavaFeatureDescriptorEnum.fragments).wGetAdapter(
				JavaEntityDescriptorEnum.VariableDeclarationFragments);
	}

	public void setFragments(VariableDeclarationFragments fragments) {
		wSet(JavaFeatureDescriptorEnum.fragments, fragments);
	}
}
