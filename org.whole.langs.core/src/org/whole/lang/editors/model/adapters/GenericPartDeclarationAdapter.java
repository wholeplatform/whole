package org.whole.lang.editors.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.editors.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class GenericPartDeclarationAdapter extends AbstractEntityAdapter
		implements GenericPartDeclaration {
	private static final long serialVersionUID = 1;

	public GenericPartDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public GenericPartDeclarationAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<GenericPartDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.GenericPartDeclaration;
	}

	public GenericPartName getPartName() {
		return wGet(EditorsFeatureDescriptorEnum.partName).wGetAdapter(
				EditorsEntityDescriptorEnum.GenericPartName);
	}

	public void setPartName(GenericPartName partName) {
		wSet(EditorsFeatureDescriptorEnum.partName, partName);
	}

	public EntityNames getEntityNames() {
		return wGet(EditorsFeatureDescriptorEnum.entityNames).wGetAdapter(
				EditorsEntityDescriptorEnum.EntityNames);
	}

	public void setEntityNames(EntityNames entityNames) {
		wSet(EditorsFeatureDescriptorEnum.entityNames, entityNames);
	}
}
