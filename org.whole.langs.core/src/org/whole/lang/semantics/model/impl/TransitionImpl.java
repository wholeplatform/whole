package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TransitionImpl extends AbstractSimpleEntity implements Transition {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Transition> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Transition;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.Transition_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Configuration sourceConfiguration;

	public Configuration getSourceConfiguration() {
		return notifyRequested(
				SemanticsFeatureDescriptorEnum.sourceConfiguration,
				sourceConfiguration);
	}

	public void setSourceConfiguration(Configuration sourceConfiguration) {
		notifyChanged(SemanticsFeatureDescriptorEnum.sourceConfiguration,
				this.sourceConfiguration,
				this.sourceConfiguration = sourceConfiguration);
	}

	private ConfigurationOrTransition targetConfiguration;

	public ConfigurationOrTransition getTargetConfiguration() {
		return notifyRequested(
				SemanticsFeatureDescriptorEnum.targetConfiguration,
				targetConfiguration);
	}

	public void setTargetConfiguration(
			ConfigurationOrTransition targetConfiguration) {
		notifyChanged(SemanticsFeatureDescriptorEnum.targetConfiguration,
				this.targetConfiguration,
				this.targetConfiguration = targetConfiguration);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSourceConfiguration().wGetAdaptee(false);
		case 1:
			return getTargetConfiguration().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSourceConfiguration(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Configuration));
			break;
		case 1:
			setTargetConfiguration(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.ConfigurationOrTransition));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
