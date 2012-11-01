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
public class ImportDeclarationAdapter extends AbstractEntityAdapter implements
		ImportDeclaration {
	private static final long serialVersionUID = 1;

	public ImportDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ImportDeclarationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ImportDeclaration> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ImportDeclaration;
	}

	public Name getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}

	public ImportModifier getOnDemand() {
		return wGet(JavaFeatureDescriptorEnum.onDemand).wGetAdapter(
				JavaEntityDescriptorEnum.ImportModifier);
	}

	public void setOnDemand(ImportModifier onDemand) {
		wSet(JavaFeatureDescriptorEnum.onDemand, onDemand);
	}

	public ImportModifier getStatic() {
		return wGet(JavaFeatureDescriptorEnum._static).wGetAdapter(
				JavaEntityDescriptorEnum.ImportModifier);
	}

	public void setStatic(ImportModifier _static) {
		wSet(JavaFeatureDescriptorEnum._static, _static);
	}
}
