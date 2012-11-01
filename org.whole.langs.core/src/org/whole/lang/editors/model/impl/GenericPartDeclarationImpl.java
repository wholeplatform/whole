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
public class GenericPartDeclarationImpl extends AbstractSimpleEntity implements
		GenericPartDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<GenericPartDeclaration> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.GenericPartDeclaration;
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.GenericPartDeclaration_ord;
	}

	public void accept(IEditorsVisitor visitor) {
		visitor.visit(this);
	}

	private GenericPartName partName;

	public GenericPartName getPartName() {
		return notifyRequested(EditorsFeatureDescriptorEnum.partName, partName);
	}

	public void setPartName(GenericPartName partName) {
		notifyChanged(EditorsFeatureDescriptorEnum.partName, this.partName,
				this.partName = partName);
	}

	private EntityNames entityNames;

	public EntityNames getEntityNames() {
		return notifyRequested(EditorsFeatureDescriptorEnum.entityNames,
				entityNames);
	}

	public void setEntityNames(EntityNames entityNames) {
		notifyChanged(EditorsFeatureDescriptorEnum.entityNames,
				this.entityNames, this.entityNames = entityNames);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPartName().wGetAdaptee(false);
		case 1:
			return getEntityNames().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPartName(value
					.wGetAdapter(EditorsEntityDescriptorEnum.GenericPartName));
			break;
		case 1:
			setEntityNames(value
					.wGetAdapter(EditorsEntityDescriptorEnum.EntityNames));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
