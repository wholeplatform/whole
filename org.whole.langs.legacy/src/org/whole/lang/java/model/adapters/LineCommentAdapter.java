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
public class LineCommentAdapter extends AbstractEntityAdapter implements
		LineComment {
	private static final long serialVersionUID = 1;

	public LineCommentAdapter(IEntity implementor) {
		super(implementor);
	}

	public LineCommentAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LineComment> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LineComment;
	}

	public TextElement getText() {
		return wGet(JavaFeatureDescriptorEnum.text).wGetAdapter(
				JavaEntityDescriptorEnum.TextElement);
	}

	public void setText(TextElement text) {
		wSet(JavaFeatureDescriptorEnum.text, text);
	}
}
