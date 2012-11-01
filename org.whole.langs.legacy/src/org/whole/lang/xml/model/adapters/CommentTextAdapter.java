package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class CommentTextAdapter extends AbstractEntityAdapter implements
		CommentText {
	private static final long serialVersionUID = 1;

	public CommentTextAdapter(IEntity implementor) {
		super(implementor);
	}

	public CommentTextAdapter() {
	}

	public void accept(IXmlVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CommentText> wGetEntityDescriptor() {
		return XmlEntityDescriptorEnum.CommentText;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
