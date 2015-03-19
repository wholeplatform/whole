package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ModelDeclarationsImpl extends
		AbstractListCompositeEntity<ModelDeclaration> implements
		ModelDeclarations {
	private static final long serialVersionUID = 1;

	public void accept(IModelsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.ModelDeclarations_ord;
	}

	public EntityDescriptor<ModelDeclarations> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.ModelDeclarations;
	}
}
