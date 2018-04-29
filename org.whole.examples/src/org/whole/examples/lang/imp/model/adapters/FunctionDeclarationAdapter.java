package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class FunctionDeclarationAdapter extends AbstractEntityAdapter implements FunctionDeclaration {
	private static final long serialVersionUID = 1;

	public FunctionDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public FunctionDeclarationAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FunctionDeclaration> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.FunctionDeclaration;
	}

	public Type getType() {
		return wGet(ImpFeatureDescriptorEnum.type).wGetAdapter(ImpEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(ImpFeatureDescriptorEnum.type, type);
	}

	public Name getName() {
		return wGet(ImpFeatureDescriptorEnum.name).wGetAdapter(ImpEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(ImpFeatureDescriptorEnum.name, name);
	}

	public Parameters getParameters() {
		return wGet(ImpFeatureDescriptorEnum.parameters).wGetAdapter(ImpEntityDescriptorEnum.Parameters);
	}

	public void setParameters(Parameters parameters) {
		wSet(ImpFeatureDescriptorEnum.parameters, parameters);
	}

	public Statement getBody() {
		return wGet(ImpFeatureDescriptorEnum.body).wGetAdapter(ImpEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(ImpFeatureDescriptorEnum.body, body);
	}
}
