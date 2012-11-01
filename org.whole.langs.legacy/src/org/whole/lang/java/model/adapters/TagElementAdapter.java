package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class TagElementAdapter extends AbstractEntityAdapter implements
		TagElement {
	private static final long serialVersionUID = 1;

	public TagElementAdapter(IEntity implementor) {
		super(implementor);
	}

	public TagElementAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TagElement> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.TagElement;
	}

	public TagName getTagName() {
		return wGet(JavaFeatureDescriptorEnum.tagName).wGetAdapter(
				JavaEntityDescriptorEnum.TagName);
	}

	public void setTagName(TagName tagName) {
		wSet(JavaFeatureDescriptorEnum.tagName, tagName);
	}

	public DocElements getFragments() {
		return wGet(JavaFeatureDescriptorEnum.fragments).wGetAdapter(
				JavaEntityDescriptorEnum.DocElements);
	}

	public void setFragments(DocElements fragments) {
		wSet(JavaFeatureDescriptorEnum.fragments, fragments);
	}
}
