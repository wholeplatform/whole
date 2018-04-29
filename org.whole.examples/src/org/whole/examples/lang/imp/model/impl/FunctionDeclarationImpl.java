package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Type;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Name;
import org.whole.examples.lang.imp.model.Parameters;
import org.whole.examples.lang.imp.model.Statement;

/** 
 * @generator Whole
 */
public class FunctionDeclarationImpl extends AbstractSimpleEntity implements FunctionDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionDeclaration> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.FunctionDeclaration;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.FunctionDeclaration_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Type type;

	public Type getType() {
		return notifyRequested(ImpFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(ImpFeatureDescriptorEnum.type, this.type, this.type = type);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(ImpFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(ImpFeatureDescriptorEnum.name, this.name, this.name = name);
	}

	private Parameters parameters;

	public Parameters getParameters() {
		return notifyRequested(ImpFeatureDescriptorEnum.parameters, parameters);
	}

	public void setParameters(Parameters parameters) {
		notifyChanged(ImpFeatureDescriptorEnum.parameters, this.parameters, this.parameters = parameters);
	}

	private Statement body;

	public Statement getBody() {
		return notifyRequested(ImpFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statement body) {
		notifyChanged(ImpFeatureDescriptorEnum.body, this.body, this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		case 2:
			return getParameters().wGetAdaptee(false);
		case 3:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(ImpEntityDescriptorEnum.Type));
			break;
		case 1:
			setName(value.wGetAdapter(ImpEntityDescriptorEnum.Name));
			break;
		case 2:
			setParameters(value.wGetAdapter(ImpEntityDescriptorEnum.Parameters));
			break;
		case 3:
			setBody(value.wGetAdapter(ImpEntityDescriptorEnum.Statement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
