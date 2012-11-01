package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xml.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CommentImpl extends AbstractSimpleEntity implements Comment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Comment> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.Comment;
	}

	public int wGetEntityOrd() {
		return XmlEntityDescriptorEnum.Comment_ord;
	}

	public void accept(IXmlVisitor visitor) {
		visitor.visit(this);
	}

	private CommentText text;

	public CommentText getText() {
		return notifyRequested(XmlFeatureDescriptorEnum.text, text);
	}

	public void setText(CommentText text) {
		notifyChanged(XmlFeatureDescriptorEnum.text, this.text,
				this.text = text);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getText().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setText(value.wGetAdapter(XmlEntityDescriptorEnum.CommentText));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
