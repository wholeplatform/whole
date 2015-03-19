package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class QualifiedFeatureImpl extends AbstractSimpleEntity implements
		QualifiedFeature {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<QualifiedFeature> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedFeature;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedFeature_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private SimpleFeature qualifier;

	public SimpleFeature getQualifier() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.qualifier,
				qualifier);
	}

	public void setQualifier(SimpleFeature qualifier) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.qualifier,
				this.qualifier, this.qualifier = qualifier);
	}

	private FeaturePath feature;

	public FeaturePath getFeature() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.feature,
				feature);
	}

	public void setFeature(FeaturePath feature) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.feature,
				this.feature, this.feature = feature);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getQualifier().wGetAdaptee(false);
		case 1:
			return getFeature().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setQualifier(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.SimpleFeature));
			break;
		case 1:
			setFeature(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.FeaturePath));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
