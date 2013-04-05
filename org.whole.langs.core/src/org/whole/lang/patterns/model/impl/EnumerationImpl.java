package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EnumerationImpl extends AbstractSimpleEntity implements
		Enumeration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Enumeration> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.Enumeration;
	}

	public int wGetEntityOrd() {
		return PatternsEntityDescriptorEnum.Enumeration_ord;
	}

	public void accept(IPatternsVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(PatternsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Type resultType;

	public Type getResultType() {
		return notifyRequested(PatternsFeatureDescriptorEnum.resultType,
				resultType);
	}

	public void setResultType(Type resultType) {
		notifyChanged(PatternsFeatureDescriptorEnum.resultType,
				this.resultType, this.resultType = resultType);
	}

	private EnumValues values;

	public EnumValues getValues() {
		return notifyRequested(PatternsFeatureDescriptorEnum.values, values);
	}

	public void setValues(EnumValues values) {
		notifyChanged(PatternsFeatureDescriptorEnum.values, this.values,
				this.values = values);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getResultType().wGetAdaptee(false);
		case 2:
			return getValues().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
			break;
		case 1:
			setResultType(value.wGetAdapter(PatternsEntityDescriptorEnum.Type));
			break;
		case 2:
			setValues(value
					.wGetAdapter(PatternsEntityDescriptorEnum.EnumValues));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
