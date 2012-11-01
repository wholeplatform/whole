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
public class FeatureNameImpl extends AbstractSimpleEntity implements
		FeatureName {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FeatureName> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FeatureName;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.FeatureName_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		visitor.visit(this);
	}

	private LanguageName language;

	public LanguageName getLanguage() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.language,
				language);
	}

	public void setLanguage(LanguageName language) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.language,
				this.language, this.language = language);
	}

	private Name entityName;

	public Name getEntityName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.entityName,
				entityName);
	}

	public void setEntityName(Name entityName) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.entityName,
				this.entityName, this.entityName = entityName);
	}

	private FeaturePath featurePath;

	public FeaturePath getFeaturePath() {
		return notifyRequested(
				FirstOrderLogicFeatureDescriptorEnum.featurePath, featurePath);
	}

	public void setFeaturePath(FeaturePath featurePath) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.featurePath,
				this.featurePath, this.featurePath = featurePath);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLanguage().wGetAdaptee(false);
		case 1:
			return getEntityName().wGetAdaptee(false);
		case 2:
			return getFeaturePath().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLanguage(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.LanguageName));
			break;
		case 1:
			setEntityName(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		case 2:
			setFeaturePath(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.FeaturePath));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
