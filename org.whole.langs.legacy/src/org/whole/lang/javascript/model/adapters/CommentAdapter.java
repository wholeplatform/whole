package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

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

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Comment> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Comment;
	}

	public CommentKind getKind() {
		return wGet(JavaScriptFeatureDescriptorEnum.kind).wGetAdapter(
				JavaScriptEntityDescriptorEnum.CommentKind);
	}

	public void setKind(CommentKind kind) {
		wSet(JavaScriptFeatureDescriptorEnum.kind, kind);
	}

	public StringData getContents() {
		return wGet(JavaScriptFeatureDescriptorEnum.contents).wGetAdapter(
				JavaScriptEntityDescriptorEnum.StringData);
	}

	public void setContents(StringData contents) {
		wSet(JavaScriptFeatureDescriptorEnum.contents, contents);
	}
}
