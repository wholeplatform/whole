package org.whole.lang.versions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionAdapter extends AbstractEntityAdapter implements Version {
	private static final long serialVersionUID = 1;

	public VersionAdapter(IEntity implementor) {
		super(implementor);
	}

	public VersionAdapter() {
	}

	public void accept(IVersionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Version> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.Version;
	}

	public VersionLabel getVersionLabel() {
		return wGet(VersionsFeatureDescriptorEnum.versionLabel).wGetAdapter(
				VersionsEntityDescriptorEnum.VersionLabel);
	}

	public void setVersionLabel(VersionLabel versionLabel) {
		wSet(VersionsFeatureDescriptorEnum.versionLabel, versionLabel);
	}

	public History getHistory() {
		return wGet(VersionsFeatureDescriptorEnum.history).wGetAdapter(
				VersionsEntityDescriptorEnum.History);
	}

	public void setHistory(History history) {
		wSet(VersionsFeatureDescriptorEnum.history, history);
	}

	public VersionsRefs getPredecessors() {
		return wGet(VersionsFeatureDescriptorEnum.predecessors).wGetAdapter(
				VersionsEntityDescriptorEnum.VersionsRefs);
	}

	public void setPredecessors(VersionsRefs predecessors) {
		wSet(VersionsFeatureDescriptorEnum.predecessors, predecessors);
	}

	public VersionsRefs getSuccessors() {
		return wGet(VersionsFeatureDescriptorEnum.successors).wGetAdapter(
				VersionsEntityDescriptorEnum.VersionsRefs);
	}

	public void setSuccessors(VersionsRefs successors) {
		wSet(VersionsFeatureDescriptorEnum.successors, successors);
	}

	public Versionable getVersionable() {
		return wGet(VersionsFeatureDescriptorEnum.versionable).wGetAdapter(
				VersionsEntityDescriptorEnum.Versionable);
	}

	public void setVersionable(Versionable versionable) {
		wSet(VersionsFeatureDescriptorEnum.versionable, versionable);
	}
}
