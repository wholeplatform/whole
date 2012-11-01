package org.whole.lang.versions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionLabelAdapter extends AbstractEntityAdapter implements
		VersionLabel {
	private static final long serialVersionUID = 1;

	public VersionLabelAdapter(IEntity implementor) {
		super(implementor);
	}

	public VersionLabelAdapter() {
	}

	public void accept(IVersionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VersionLabel> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.VersionLabel;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
