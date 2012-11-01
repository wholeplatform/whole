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
public class HasKindAdapter extends AbstractEntityAdapter implements HasKind {
	private static final long serialVersionUID = 1;

	public HasKindAdapter(IEntity implementor) {
		super(implementor);
	}

	public HasKindAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<HasKind> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.HasKind;
	}

	public Kind getKind() {
		return wGet(TestsFeatureDescriptorEnum.kind).wGetAdapter(
				TestsEntityDescriptorEnum.Kind);
	}

	public void setKind(Kind kind) {
		wSet(TestsFeatureDescriptorEnum.kind, kind);
	}
}
