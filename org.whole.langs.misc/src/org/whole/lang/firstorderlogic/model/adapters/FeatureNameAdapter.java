package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FeatureNameAdapter extends AbstractEntityAdapter implements
		FeatureName {
	private static final long serialVersionUID = 1;

	public FeatureNameAdapter(IEntity implementor) {
		super(implementor);
	}

	public FeatureNameAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FeatureName> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.FeatureName;
	}

	public LanguageName getLanguage() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.language).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.LanguageName);
	}

	public void setLanguage(LanguageName language) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.language, language);
	}

	public Name getEntityName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.entityName)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setEntityName(Name entityName) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.entityName, entityName);
	}

	public FeaturePath getFeaturePath() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.featurePath)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.FeaturePath);
	}

	public void setFeaturePath(FeaturePath featurePath) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.featurePath, featurePath);
	}
}
