package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CommentImpl extends AbstractSimpleEntity implements Comment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Comment> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Comment;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.Comment_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private CommentKind kind;

	public CommentKind getKind() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.kind, kind);
	}

	public void setKind(CommentKind kind) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.kind, this.kind,
				this.kind = kind);
	}

	private StringData contents;

	public StringData getContents() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.contents,
				contents);
	}

	public void setContents(StringData contents) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.contents, this.contents,
				this.contents = contents);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getKind().wGetAdaptee(false);
		case 1:
			return getContents().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setKind(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.CommentKind));
			break;
		case 1:
			setContents(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.StringData));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
