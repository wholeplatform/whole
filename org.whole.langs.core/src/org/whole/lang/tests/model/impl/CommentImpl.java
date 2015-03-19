package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CommentImpl extends AbstractSimpleEntity implements Comment {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Comment> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Comment;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.Comment_ord;
	}

	public void accept(ITestsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private CommentKind kind;

	public CommentKind getKind() {
		return notifyRequested(TestsFeatureDescriptorEnum.kind, kind);
	}

	public void setKind(CommentKind kind) {
		notifyChanged(TestsFeatureDescriptorEnum.kind, this.kind,
				this.kind = kind);
	}

	private Description description;

	public Description getDescription() {
		return notifyRequested(TestsFeatureDescriptorEnum.description,
				description);
	}

	public void setDescription(Description description) {
		notifyChanged(TestsFeatureDescriptorEnum.description, this.description,
				this.description = description);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getKind().wGetAdaptee(false);
		case 1:
			return getDescription().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setKind(value.wGetAdapter(TestsEntityDescriptorEnum.CommentKind));
			break;
		case 1:
			setDescription(value
					.wGetAdapter(TestsEntityDescriptorEnum.Description));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
