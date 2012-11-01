package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class JavadocImpl extends AbstractSimpleEntity implements Javadoc {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Javadoc> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Javadoc;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.Javadoc_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Tags tags;

	public Tags getTags() {
		return notifyRequested(JavaFeatureDescriptorEnum.tags, tags);
	}

	public void setTags(Tags tags) {
		notifyChanged(JavaFeatureDescriptorEnum.tags, this.tags,
				this.tags = tags);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTags().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTags(value.wGetAdapter(JavaEntityDescriptorEnum.Tags));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
