package org.whole.lang.versions.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionsAdapter extends AbstractSetEntityAdapter<Version>
		implements Versions {
	private static final long serialVersionUID = 1;

	public VersionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public VersionsAdapter() {
	}

	public void accept(IVersionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Versions> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.Versions;
	}
}
