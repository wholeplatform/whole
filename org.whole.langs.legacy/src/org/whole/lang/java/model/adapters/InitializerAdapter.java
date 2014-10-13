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
public class InitializerAdapter extends AbstractEntityAdapter implements
		Initializer {
	private static final long serialVersionUID = 1;

	public InitializerAdapter(IEntity implementor) {
		super(implementor);
	}

	public InitializerAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Initializer> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Initializer;
	}

	public Javadoc getJavadoc() {
		return wGet(JavaFeatureDescriptorEnum.javadoc).wGetAdapter(
				JavaEntityDescriptorEnum.Javadoc);
	}

	public void setJavadoc(Javadoc javadoc) {
		wSet(JavaFeatureDescriptorEnum.javadoc, javadoc);
	}

	public ExtendedModifiers getModifiers() {
		return wGet(JavaFeatureDescriptorEnum.modifiers).wGetAdapter(
				JavaEntityDescriptorEnum.ExtendedModifiers);
	}

	public void setModifiers(ExtendedModifiers modifiers) {
		wSet(JavaFeatureDescriptorEnum.modifiers, modifiers);
	}

	public Block getBody() {
		return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(
				JavaEntityDescriptorEnum.Block);
	}

	public void setBody(Block body) {
		wSet(JavaFeatureDescriptorEnum.body, body);
	}
}
