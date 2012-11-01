package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class RenameImpl extends AbstractSimpleEntity implements Rename {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Rename> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Rename;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.Rename_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private LocalIdentifier newIdentifier;

	public LocalIdentifier getNewIdentifier() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.newIdentifier,
				newIdentifier);
	}

	public void setNewIdentifier(LocalIdentifier newIdentifier) {
		notifyChanged(SemanticsFeatureDescriptorEnum.newIdentifier,
				this.newIdentifier, this.newIdentifier = newIdentifier);
	}

	private LocalIdentifier oldIdentifier;

	public LocalIdentifier getOldIdentifier() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.oldIdentifier,
				oldIdentifier);
	}

	public void setOldIdentifier(LocalIdentifier oldIdentifier) {
		notifyChanged(SemanticsFeatureDescriptorEnum.oldIdentifier,
				this.oldIdentifier, this.oldIdentifier = oldIdentifier);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getNewIdentifier().wGetAdaptee(false);
		case 1:
			return getOldIdentifier().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setNewIdentifier(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
			break;
		case 1:
			setOldIdentifier(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
