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
public class JavaPartDeclarationAdapter extends AbstractEntityAdapter implements
		JavaPartDeclaration {
	private static final long serialVersionUID = 1;

	public JavaPartDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public JavaPartDeclarationAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<JavaPartDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.JavaPartDeclaration;
	}

	public PartName getPartName() {
		return wGet(EditorsFeatureDescriptorEnum.partName).wGetAdapter(
				EditorsEntityDescriptorEnum.PartName);
	}

	public void setPartName(PartName partName) {
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
