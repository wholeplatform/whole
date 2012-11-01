package org.whole.lang.properties.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class PropertiesAdapter extends AbstractEntityAdapter implements
		Properties {
	private static final long serialVersionUID = 1;

	public PropertiesAdapter(IEntity implementor) {
		super(implementor);
	}

	public PropertiesAdapter() {
	}

	public void accept(IPropertiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Properties> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Properties;
	}

	public Comment getComment() {
		return wGet(PropertiesFeatureDescriptorEnum.comment).wGetAdapter(
				PropertiesEntityDescriptorEnum.Comment);
	}

	public void setComment(Comment comment) {
		wSet(PropertiesFeatureDescriptorEnum.comment, comment);
	}

	public Properties getDefaults() {
		return wGet(PropertiesFeatureDescriptorEnum.defaults).wGetAdapter(
				PropertiesEntityDescriptorEnum.Properties);
	}

	public void setDefaults(Properties defaults) {
		wSet(PropertiesFeatureDescriptorEnum.defaults, defaults);
	}

	public Entries getEntries() {
		return wGet(PropertiesFeatureDescriptorEnum.entries).wGetAdapter(
				PropertiesEntityDescriptorEnum.Entries);
	}

	public void setEntries(Entries entries) {
		wSet(PropertiesFeatureDescriptorEnum.entries, entries);
	}
}
