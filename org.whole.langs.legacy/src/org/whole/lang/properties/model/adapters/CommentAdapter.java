package org.whole.lang.properties.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CommentAdapter extends AbstractEntityAdapter implements Comment {
	private static final long serialVersionUID = 1;

	public CommentAdapter(IEntity implementor) {
		super(implementor);
	}

	public CommentAdapter() {
	}

	public void accept(IPropertiesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Comment> wGetEntityDescriptor() {
		return PropertiesEntityDescriptorEnum.Comment;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
