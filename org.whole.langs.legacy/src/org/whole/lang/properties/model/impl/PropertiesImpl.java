package org.whole.lang.properties.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.properties.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertiesImpl extends AbstractSimpleEntity implements Properties {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Properties> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Properties;
	}

	public int wGetEntityOrd() {
		return PropertiesEntityDescriptorEnum.Properties_ord;
	}

	public void accept(IPropertiesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Comment comment;

	public Comment getComment() {
		return notifyRequested(PropertiesFeatureDescriptorEnum.comment, comment);
	}

	public void setComment(Comment comment) {
		notifyChanged(PropertiesFeatureDescriptorEnum.comment, this.comment,
				this.comment = comment);
	}

	private Properties defaults;

	public Properties getDefaults() {
		return notifyRequested(PropertiesFeatureDescriptorEnum.defaults,
				defaults);
	}

	public void setDefaults(Properties defaults) {
		notifyChanged(PropertiesFeatureDescriptorEnum.defaults, this.defaults,
				this.defaults = defaults);
	}

	private Entries entries;

	public Entries getEntries() {
		return notifyRequested(PropertiesFeatureDescriptorEnum.entries, entries);
	}

	public void setEntries(Entries entries) {
		notifyChanged(PropertiesFeatureDescriptorEnum.entries, this.entries,
				this.entries = entries);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getComment().wGetAdaptee(false);
		case 1:
			return getDefaults().wGetAdaptee(false);
		case 2:
			return getEntries().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setComment(value
					.wGetAdapter(PropertiesEntityDescriptorEnum.Comment));
			break;
		case 1:
			setDefaults(value
					.wGetAdapter(PropertiesEntityDescriptorEnum.Properties));
			break;
		case 2:
			setEntries(value
					.wGetAdapter(PropertiesEntityDescriptorEnum.Entries));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
