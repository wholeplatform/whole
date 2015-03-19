package org.whole.lang.properties.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.properties.model.*;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class EntriesStrictImpl extends AbstractSetCompositeEntity<Property>
		implements Entries {
	private static final long serialVersionUID = 1;

	public void accept(IPropertiesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return PropertiesEntityDescriptorEnum.Entries_ord;
	}

	public EntityDescriptor<Entries> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Entries;
	}
}
