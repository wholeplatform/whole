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
public class FactoryMethodAdapter extends AbstractEntityAdapter implements
		FactoryMethod {
	private static final long serialVersionUID = 1;

	public FactoryMethodAdapter(IEntity implementor) {
		super(implementor);
	}

	public FactoryMethodAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FactoryMethod> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.FactoryMethod;
	}

	public ReferenceType getProductType() {
		return wGet(PojoFeatureDescriptorEnum.productType).wGetAdapter(
				PojoEntityDescriptorEnum.ReferenceType);
	}

	public void setProductType(ReferenceType productType) {
		wSet(PojoFeatureDescriptorEnum.productType, productType);
	}

	public Name getProductName() {
		return wGet(PojoFeatureDescriptorEnum.productName).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setProductName(Name productName) {
		wSet(PojoFeatureDescriptorEnum.productName, productName);
	}

	public Name getTemplate() {
		return wGet(PojoFeatureDescriptorEnum.template).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setTemplate(Name template) {
		wSet(PojoFeatureDescriptorEnum.template, template);
	}

	public Parameters getParameters() {
		return wGet(PojoFeatureDescriptorEnum.parameters).wGetAdapter(
				PojoEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(PojoFeatureDescriptorEnum.parameters, parameters);
	}
}
