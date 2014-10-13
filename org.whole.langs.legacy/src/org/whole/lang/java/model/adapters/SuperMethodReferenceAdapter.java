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
public class SuperMethodReferenceAdapter extends AbstractEntityAdapter
		implements SuperMethodReference {
	private static final long serialVersionUID = 1;

	public SuperMethodReferenceAdapter(IEntity implementor) {
		super(implementor);
	}

	public SuperMethodReferenceAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SuperMethodReference> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SuperMethodReference;
	}

	public Name getQualifier() {
		return wGet(JavaFeatureDescriptorEnum.qualifier).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setQualifier(Name qualifier) {
		wSet(JavaFeatureDescriptorEnum.qualifier, qualifier);
	}

	public Types getTypeArguments() {
		return wGet(JavaFeatureDescriptorEnum.typeArguments).wGetAdapter(
				JavaEntityDescriptorEnum.Types);
	}

	public void setTypeArguments(Types typeArguments) {
		wSet(JavaFeatureDescriptorEnum.typeArguments, typeArguments);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}
}
