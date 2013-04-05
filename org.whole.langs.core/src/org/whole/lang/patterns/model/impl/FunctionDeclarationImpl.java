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
public class FunctionDeclarationImpl extends AbstractSimpleEntity implements
		FunctionDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionDeclaration> wGetEntityDescriptor() {
		return PatternsEntityDescriptorEnum.FunctionDeclaration;
	}

	public int wGetEntityOrd() {
		return PatternsEntityDescriptorEnum.FunctionDeclaration_ord;
	}

	public void accept(IPatternsVisitor visitor) {
		visitor.visit(this);
	}

	private ResultTypes applicationTypes;

	public ResultTypes getApplicationTypes() {
		return notifyRequested(PatternsFeatureDescriptorEnum.applicationTypes,
				applicationTypes);
	}

	public void setApplicationTypes(ResultTypes applicationTypes) {
		notifyChanged(PatternsFeatureDescriptorEnum.applicationTypes,
				this.applicationTypes, this.applicationTypes = applicationTypes);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(PatternsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(PatternsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Expression body;

	public Expression getBody() {
		return notifyRequested(PatternsFeatureDescriptorEnum.body, body);
	}

	public void setBody(Expression body) {
		notifyChanged(PatternsFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getApplicationTypes().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		case 2:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setApplicationTypes(value
					.wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes));
			break;
		case 1:
			setName(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
			break;
		case 2:
			setBody(value.wGetAdapter(PatternsEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
