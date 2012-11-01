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
public class PartDeclarationAdapter extends AbstractEntityAdapter implements
		PartDeclaration {
	private static final long serialVersionUID = 1;

	public PartDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public PartDeclarationAdapter() {
	}

	public void accept(IEditorsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PartDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.PartDeclaration;
	}

	public PartName getPartName() {
		return wGet(EditorsFeatureDescriptorEnum.partName).wGetAdapter(
				EditorsEntityDescriptorEnum.PartName);
	}

	public void setPartName(PartName partName) {
		wSet(EditorsFeatureDescriptorEnum.partName, partName);
	}

	public EntityName getEntityName() {
		return wGet(EditorsFeatureDescriptorEnum.entityName).wGetAdapter(
				EditorsEntityDescriptorEnum.EntityName);
	}

	public void setEntityName(EntityName entityName) {
		wSet(EditorsFeatureDescriptorEnum.entityName, entityName);
	}

	public FigureName getFigureName() {
		return wGet(EditorsFeatureDescriptorEnum.figureName).wGetAdapter(
				EditorsEntityDescriptorEnum.FigureName);
	}

	public void setFigureName(FigureName figureName) {
		wSet(EditorsFeatureDescriptorEnum.figureName, figureName);
	}

	public EntityFeatures getEntityFeatures() {
		return wGet(EditorsFeatureDescriptorEnum.entityFeatures).wGetAdapter(
				EditorsEntityDescriptorEnum.EntityFeatures);
	}

	public void setEntityFeatures(EntityFeatures entityFeatures) {
		wSet(EditorsFeatureDescriptorEnum.entityFeatures, entityFeatures);
	}
}
