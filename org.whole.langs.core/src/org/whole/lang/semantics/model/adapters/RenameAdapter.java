package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class RenameAdapter extends AbstractEntityAdapter implements Rename {
	private static final long serialVersionUID = 1;

	public RenameAdapter(IEntity implementor) {
		super(implementor);
	}

	public RenameAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Rename> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.Rename;
	}

	public LocalIdentifier getNewIdentifier() {
		return wGet(SemanticsFeatureDescriptorEnum.newIdentifier).wGetAdapter(
				SemanticsEntityDescriptorEnum.LocalIdentifier);
	}

	public void setNewIdentifier(LocalIdentifier newIdentifier) {
		wSet(SemanticsFeatureDescriptorEnum.newIdentifier, newIdentifier);
	}

	public LocalIdentifier getOldIdentifier() {
		return wGet(SemanticsFeatureDescriptorEnum.oldIdentifier).wGetAdapter(
				SemanticsEntityDescriptorEnum.LocalIdentifier);
	}

	public void setOldIdentifier(LocalIdentifier oldIdentifier) {
		wSet(SemanticsFeatureDescriptorEnum.oldIdentifier, oldIdentifier);
	}
}
