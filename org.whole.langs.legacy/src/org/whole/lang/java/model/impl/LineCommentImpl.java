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
public class LineCommentImpl extends AbstractSimpleEntity implements
		LineComment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LineComment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LineComment;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.LineComment_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private TextElement text;

	public TextElement getText() {
		return notifyRequested(JavaFeatureDescriptorEnum.text, text);
	}

	public void setText(TextElement text) {
		notifyChanged(JavaFeatureDescriptorEnum.text, this.text,
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
			setText(value.wGetAdapter(JavaEntityDescriptorEnum.TextElement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
