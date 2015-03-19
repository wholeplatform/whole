package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PartDeclarationImpl extends AbstractSimpleEntity implements
		PartDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PartDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.PartDeclaration;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.PartDeclaration_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private PartName partName;

	public PartName getPartName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.partName, partName);
	}

	public void setPartName(PartName partName) {
		notifyChanged(EditorsFeatureDescriptorEnum.partName, this.partName,
				this.partName = partName);
	}

	private EntityName entityName;

	public EntityName getEntityName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.entityName,
				entityName);
	}

	public void setEntityName(EntityName entityName) {
		notifyChanged(EditorsFeatureDescriptorEnum.entityName, this.entityName,
				this.entityName = entityName);
	}

	private FigureName figureName;

	public FigureName getFigureName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.figureName,
				figureName);
	}

	public void setFigureName(FigureName figureName) {
		notifyChanged(EditorsFeatureDescriptorEnum.figureName, this.figureName,
				this.figureName = figureName);
	}

	private EntityFeatures entityFeatures;

	public EntityFeatures getEntityFeatures() {
		return notifyRequested(EditorsFeatureDescriptorEnum.entityFeatures,
				entityFeatures);
	}

	public void setEntityFeatures(EntityFeatures entityFeatures) {
		notifyChanged(EditorsFeatureDescriptorEnum.entityFeatures,
				this.entityFeatures, this.entityFeatures = entityFeatures);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPartName().wGetAdaptee(false);
		case 1:
			return getEntityName().wGetAdaptee(false);
		case 2:
			return getFigureName().wGetAdaptee(false);
		case 3:
			return getEntityFeatures().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPartName(value.wGetAdapter(EditorsEntityDescriptorEnum.PartName));
			break;
		case 1:
			setEntityName(value
					.wGetAdapter(EditorsEntityDescriptorEnum.EntityName));
			break;
		case 2:
			setFigureName(value
					.wGetAdapter(EditorsEntityDescriptorEnum.FigureName));
			break;
		case 3:
			setEntityFeatures(value
					.wGetAdapter(EditorsEntityDescriptorEnum.EntityFeatures));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
