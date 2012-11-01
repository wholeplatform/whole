package org.whole.lang.properties.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertiesModelContext extends EntityContext {
	public PropertiesModelContext(IEntity root) {
		super(root);
	}

	public PropertiesModelContext getComment() {
		return (PropertiesModelContext) wGet(PropertiesFeatureDescriptorEnum.comment);
	}

	public void setComment(PropertiesModelContext comment) {
		wSet(PropertiesFeatureDescriptorEnum.comment, comment);
	}

	public PropertiesModelContext getDefaults() {
		return (PropertiesModelContext) wGet(PropertiesFeatureDescriptorEnum.defaults);
	}

	public void setDefaults(PropertiesModelContext defaults) {
		wSet(PropertiesFeatureDescriptorEnum.defaults, defaults);
	}

	public PropertiesModelContext getEntries() {
		return (PropertiesModelContext) wGet(PropertiesFeatureDescriptorEnum.entries);
	}

	public void setEntries(PropertiesModelContext entries) {
		wSet(PropertiesFeatureDescriptorEnum.entries, entries);
	}

	public PropertiesModelContext getName() {
		return (PropertiesModelContext) wGet(PropertiesFeatureDescriptorEnum.name);
	}

	public void setName(PropertiesModelContext name) {
		wSet(PropertiesFeatureDescriptorEnum.name, name);
	}

	public PropertiesModelContext getValue() {
		return (PropertiesModelContext) wGet(PropertiesFeatureDescriptorEnum.value);
	}

	public void setValue(PropertiesModelContext value) {
		wSet(PropertiesFeatureDescriptorEnum.value, value);
	}
}
