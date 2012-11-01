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
public class TagElementImpl extends AbstractSimpleEntity implements TagElement {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<TagElement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TagElement;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.TagElement_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private TagName tagName;

	public TagName getTagName() {
		return notifyRequested(JavaFeatureDescriptorEnum.tagName, tagName);
	}

	public void setTagName(TagName tagName) {
		notifyChanged(JavaFeatureDescriptorEnum.tagName, this.tagName,
				this.tagName = tagName);
	}

	private DocElements fragments;

	public DocElements getFragments() {
		return notifyRequested(JavaFeatureDescriptorEnum.fragments, fragments);
	}

	public void setFragments(DocElements fragments) {
		notifyChanged(JavaFeatureDescriptorEnum.fragments, this.fragments,
				this.fragments = fragments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTagName().wGetAdaptee(false);
		case 1:
			return getFragments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTagName(value.wGetAdapter(JavaEntityDescriptorEnum.TagName));
			break;
		case 1:
			setFragments(value
					.wGetAdapter(JavaEntityDescriptorEnum.DocElements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
