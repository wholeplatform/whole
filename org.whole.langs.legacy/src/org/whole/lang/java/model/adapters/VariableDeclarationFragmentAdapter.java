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
public class VariableDeclarationFragmentAdapter extends AbstractEntityAdapter
		implements VariableDeclarationFragment {
	private static final long serialVersionUID = 1;

	public VariableDeclarationFragmentAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableDeclarationFragmentAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableDeclarationFragment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.VariableDeclarationFragment;
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}

	public ExtraDimensions getExtraDimensions() {
		return wGet(JavaFeatureDescriptorEnum.extraDimensions).wGetAdapter(
				JavaEntityDescriptorEnum.ExtraDimensions);
	}

	public void setExtraDimensions(ExtraDimensions extraDimensions) {
		wSet(JavaFeatureDescriptorEnum.extraDimensions, extraDimensions);
	}

	public Expression getInitializer() {
		return wGet(JavaFeatureDescriptorEnum.initializer).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setInitializer(Expression initializer) {
		wSet(JavaFeatureDescriptorEnum.initializer, initializer);
	}
}
