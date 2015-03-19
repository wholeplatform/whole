package org.whole.lang.versions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.versions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VersionImpl extends AbstractSimpleEntity implements Version {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Version> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.Version;
	}

	public int wGetEntityOrd() {
		return VersionsEntityDescriptorEnum.Version_ord;
	}

	public void accept(IVersionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getVersionLabel().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getVersionLabel().wEquals(
					entity.wGet(VersionsFeatureDescriptorEnum.versionLabel));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("versionLabel=");
		buffer.append(versionLabel);
	}

	private VersionLabel versionLabel;

	public VersionLabel getVersionLabel() {
		return notifyRequested(VersionsFeatureDescriptorEnum.versionLabel,
				versionLabel);
	}

	public void setVersionLabel(VersionLabel versionLabel) {
		notifyChanged(VersionsFeatureDescriptorEnum.versionLabel,
				this.versionLabel, this.versionLabel = versionLabel);
	}

	private History history;

	public History getHistory() {
		return notifyRequested(VersionsFeatureDescriptorEnum.history, history);
	}

	public void setHistory(History history) {
		notifyChanged(VersionsFeatureDescriptorEnum.history, this.history,
				this.history = history, false);
	}

	private VersionsRefs predecessors;

	public VersionsRefs getPredecessors() {
		return notifyRequested(VersionsFeatureDescriptorEnum.predecessors,
				predecessors);
	}

	public void setPredecessors(VersionsRefs predecessors) {
		notifyChanged(VersionsFeatureDescriptorEnum.predecessors,
				this.predecessors, this.predecessors = predecessors, false);
	}

	private VersionsRefs successors;

	public VersionsRefs getSuccessors() {
		return notifyRequested(VersionsFeatureDescriptorEnum.successors,
				successors);
	}

	public void setSuccessors(VersionsRefs successors) {
		notifyChanged(VersionsFeatureDescriptorEnum.successors,
				this.successors, this.successors = successors, false);
	}

	private Versionable versionable;

	public Versionable getVersionable() {
		return notifyRequested(VersionsFeatureDescriptorEnum.versionable,
				versionable);
	}

	public void setVersionable(Versionable versionable) {
		notifyChanged(VersionsFeatureDescriptorEnum.versionable,
				this.versionable, this.versionable = versionable, false);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getVersionLabel().wGetAdaptee(false);
		case 1:
			return getHistory().wGetAdaptee(false);
		case 2:
			return getPredecessors().wGetAdaptee(false);
		case 3:
			return getSuccessors().wGetAdaptee(false);
		case 4:
			return getVersionable().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setVersionLabel(value
					.wGetAdapter(VersionsEntityDescriptorEnum.VersionLabel));
			break;
		case 1:
			setHistory(value.wGetAdapter(VersionsEntityDescriptorEnum.History));
			break;
		case 2:
			setPredecessors(value
					.wGetAdapter(VersionsEntityDescriptorEnum.VersionsRefs));
			break;
		case 3:
			setSuccessors(value
					.wGetAdapter(VersionsEntityDescriptorEnum.VersionsRefs));
			break;
		case 4:
			setVersionable(value
					.wGetAdapter(VersionsEntityDescriptorEnum.Versionable));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}

	public int wAdjacentSize() {
		return 4;
	}
}
