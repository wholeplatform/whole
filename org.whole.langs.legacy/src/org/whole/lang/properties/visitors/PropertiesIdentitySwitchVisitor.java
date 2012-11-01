package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class PropertiesIdentitySwitchVisitor extends AbstractVisitor
		implements IPropertiesVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case PropertiesEntityDescriptorEnum.Properties_ord:
			visit((Properties) entity);
			break;
		case PropertiesEntityDescriptorEnum.Entries_ord:
			visit((Entries) entity);
			break;
		case PropertiesEntityDescriptorEnum.Property_ord:
			visit((Property) entity);
			break;
		case PropertiesEntityDescriptorEnum.Comment_ord:
			visit((Comment) entity);
			break;
		case PropertiesEntityDescriptorEnum.PropertyName_ord:
			visit((PropertyName) entity);
			break;
		case PropertiesEntityDescriptorEnum.PropertyValue_ord:
			visit((PropertyValue) entity);
			break;
		}
	}
}
