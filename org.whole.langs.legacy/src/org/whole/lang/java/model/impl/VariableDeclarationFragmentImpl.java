package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VariableDeclarationFragmentImpl extends AbstractSimpleEntity
		implements VariableDeclarationFragment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableDeclarationFragment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.VariableDeclarationFragment;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.VariableDeclarationFragment_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private ExtraDimensions extraDimensions;

	public ExtraDimensions getExtraDimensions() {
		return notifyRequested(JavaFeatureDescriptorEnum.extraDimensions,
				extraDimensions);
	}

	public void setExtraDimensions(ExtraDimensions extraDimensions) {
		notifyChanged(JavaFeatureDescriptorEnum.extraDimensions,
				this.extraDimensions, this.extraDimensions = extraDimensions);
	}

	private Expression initializer;

	public Expression getInitializer() {
		return notifyRequested(JavaFeatureDescriptorEnum.initializer,
				initializer);
	}

	public void setInitializer(Expression initializer) {
		notifyChanged(JavaFeatureDescriptorEnum.initializer, this.initializer,
				this.initializer = initializer);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getExtraDimensions().wGetAdaptee(false);
		case 2:
			return getInitializer().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		case 1:
			setExtraDimensions(value
					.wGetAdapter(JavaEntityDescriptorEnum.ExtraDimensions));
			break;
		case 2:
			setInitializer(value
					.wGetAdapter(JavaEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
