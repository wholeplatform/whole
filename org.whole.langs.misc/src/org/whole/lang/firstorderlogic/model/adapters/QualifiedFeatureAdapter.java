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
public class QualifiedFeatureAdapter extends AbstractEntityAdapter implements
		QualifiedFeature {
	private static final long serialVersionUID = 1;

	public QualifiedFeatureAdapter(IEntity implementor) {
		super(implementor);
	}

	public QualifiedFeatureAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<QualifiedFeature> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.QualifiedFeature;
	}

	public SimpleFeature getQualifier() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.qualifier)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.SimpleFeature);
	}

	public void setQualifier(SimpleFeature qualifier) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.qualifier, qualifier);
	}

	public FeaturePath getFeature() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.feature).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.FeaturePath);
	}

	public void setFeature(FeaturePath feature) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.feature, feature);
	}
}
