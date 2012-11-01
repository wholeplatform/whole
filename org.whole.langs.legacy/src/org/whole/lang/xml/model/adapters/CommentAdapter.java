package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;

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

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Comment> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Comment;
	}

	public CommentText getText() {
		return wGet(XmlFeatureDescriptorEnum.text).wGetAdapter(
				XmlEntityDescriptorEnum.CommentText);
	}

	public void setText(CommentText text) {
		wSet(XmlFeatureDescriptorEnum.text, text);
	}
}
