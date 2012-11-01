package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

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

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Comment> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.Comment;
	}

	public CommentKind getKind() {
		return wGet(TestsFeatureDescriptorEnum.kind).wGetAdapter(
				TestsEntityDescriptorEnum.CommentKind);
	}

	public void setKind(CommentKind kind) {
		wSet(TestsFeatureDescriptorEnum.kind, kind);
	}

	public Description getDescription() {
		return wGet(TestsFeatureDescriptorEnum.description).wGetAdapter(
				TestsEntityDescriptorEnum.Description);
	}

	public void setDescription(Description description) {
		wSet(TestsFeatureDescriptorEnum.description, description);
	}
}
