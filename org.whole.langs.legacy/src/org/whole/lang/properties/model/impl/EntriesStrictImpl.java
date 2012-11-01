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
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return PropertiesEntityDescriptorEnum.Entries_ord;
	}

	public EntityDescriptor<Entries> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Entries;
	}
}
