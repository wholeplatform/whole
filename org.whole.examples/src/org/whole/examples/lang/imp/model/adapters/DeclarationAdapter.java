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
public class DeclarationAdapter extends AbstractEntityAdapter implements Declaration {
	private static final long serialVersionUID = 1;

	public DeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public DeclarationAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Declaration> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.Declaration;
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
}
