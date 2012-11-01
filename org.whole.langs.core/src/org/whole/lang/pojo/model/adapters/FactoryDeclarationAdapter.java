package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FactoryDeclarationAdapter extends AbstractEntityAdapter implements
		FactoryDeclaration {
	private static final long serialVersionUID = 1;

	public FactoryDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public FactoryDeclarationAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FactoryDeclaration> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.FactoryDeclaration;
	}

	public ReferenceType getName() {
		return wGet(PojoFeatureDescriptorEnum.name).wGetAdapter(
				PojoEntityDescriptorEnum.ReferenceType);
	}

	public void setName(ReferenceType name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}

	public Name getPrefix() {
		return wGet(PojoFeatureDescriptorEnum.prefix).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setPrefix(Name prefix) {
		wSet(PojoFeatureDescriptorEnum.prefix, prefix);
	}

	public FactoryMethods getFactoryMethods() {
		return wGet(PojoFeatureDescriptorEnum.factoryMethods).wGetAdapter(
				PojoEntityDescriptorEnum.FactoryMethods);
	}

	public void setFactoryMethods(FactoryMethods factoryMethods) {
		wSet(PojoFeatureDescriptorEnum.factoryMethods, factoryMethods);
	}
}
