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
public class JavadocAdapter extends AbstractEntityAdapter implements Javadoc {
	private static final long serialVersionUID = 1;

	public JavadocAdapter(IEntity implementor) {
		super(implementor);
	}

	public JavadocAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Javadoc> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Javadoc;
	}

	public Tags getTags() {
		return wGet(JavaFeatureDescriptorEnum.tags).wGetAdapter(
				JavaEntityDescriptorEnum.Tags);
	}

	public void setTags(Tags tags) {
		wSet(JavaFeatureDescriptorEnum.tags, tags);
	}
}
