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
public class VariableDeclarationAdapter extends AbstractEntityAdapter implements VariableDeclaration {
	private static final long serialVersionUID = 1;

	public VariableDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableDeclarationAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.VariableDeclaration;
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

	public Expression getInitializer() {
		return wGet(ImpFeatureDescriptorEnum.initializer).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setInitializer(Expression initializer) {
		wSet(ImpFeatureDescriptorEnum.initializer, initializer);
	}
}
