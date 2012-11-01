package org.whole.lang.pojo.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.pojo.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class FactoryMethodImpl extends AbstractSimpleEntity implements
		FactoryMethod {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FactoryMethod> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.FactoryMethod;
	}

	public int wGetEntityOrd() {
		return PojoEntityDescriptorEnum.FactoryMethod_ord;
	}

	public void accept(IPojoVisitor visitor) {
		visitor.visit(this);
	}

	private ReferenceType productType;

	public ReferenceType getProductType() {
		return notifyRequested(PojoFeatureDescriptorEnum.productType,
				productType);
	}

	public void setProductType(ReferenceType productType) {
		notifyChanged(PojoFeatureDescriptorEnum.productType, this.productType,
				this.productType = productType);
	}

	private Name productName;

	public Name getProductName() {
		return notifyRequested(PojoFeatureDescriptorEnum.productName,
				productName);
	}

	public void setProductName(Name productName) {
		notifyChanged(PojoFeatureDescriptorEnum.productName, this.productName,
				this.productName = productName);
	}

	private Name template;

	public Name getTemplate() {
		return notifyRequested(PojoFeatureDescriptorEnum.template, template);
	}

	public void setTemplate(Name template) {
		notifyChanged(PojoFeatureDescriptorEnum.template, this.template,
				this.template = template);
	}

	private Parameters parameters;

	public Parameters getParameters() {
		return notifyRequested(PojoFeatureDescriptorEnum.parameters, parameters);
	}

	public void setParameters(Parameters parameters) {
		notifyChanged(PojoFeatureDescriptorEnum.parameters, this.parameters,
				this.parameters = parameters);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getProductType().wGetAdaptee(false);
		case 1:
			return getProductName().wGetAdaptee(false);
		case 2:
			return getTemplate().wGetAdaptee(false);
		case 3:
			return getParameters().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setProductType(value
					.wGetAdapter(PojoEntityDescriptorEnum.ReferenceType));
			break;
		case 1:
			setProductName(value.wGetAdapter(PojoEntityDescriptorEnum.Name));
			break;
		case 2:
			setTemplate(value.wGetAdapter(PojoEntityDescriptorEnum.Name));
			break;
		case 3:
			setParameters(value
					.wGetAdapter(PojoEntityDescriptorEnum.Parameters));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
