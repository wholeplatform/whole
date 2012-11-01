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
public class NameDeclarationAdapter extends AbstractEntityAdapter implements
		NameDeclaration {
	private static final long serialVersionUID = 1;

	public NameDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public NameDeclarationAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NameDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.NameDeclaration;
	}

	public Name getName() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.name).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public Type getType() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.type).wGetAdapter(
				FirstOrderLogicEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.type, type);
	}

	public Path getModelBinding() {
		return wGet(FirstOrderLogicFeatureDescriptorEnum.modelBinding)
				.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Path);
	}

	public void setModelBinding(Path modelBinding) {
		wSet(FirstOrderLogicFeatureDescriptorEnum.modelBinding, modelBinding);
	}
}
