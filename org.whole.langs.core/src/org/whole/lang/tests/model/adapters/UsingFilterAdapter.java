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
public class UsingFilterAdapter extends AbstractEntityAdapter implements
		UsingFilter {
	private static final long serialVersionUID = 1;

	public UsingFilterAdapter(IEntity implementor) {
		super(implementor);
	}

	public UsingFilterAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UsingFilter> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.UsingFilter;
	}

	public Filter getFilter() {
		return wGet(TestsFeatureDescriptorEnum.filter).wGetAdapter(
				TestsEntityDescriptorEnum.Filter);
	}

	public void setFilter(Filter filter) {
		wSet(TestsFeatureDescriptorEnum.filter, filter);
	}

	public SubjectStatement getSubjectStatement() {
		return wGet(TestsFeatureDescriptorEnum.subjectStatement).wGetAdapter(
				TestsEntityDescriptorEnum.SubjectStatement);
	}

	public void setSubjectStatement(SubjectStatement subjectStatement) {
		wSet(TestsFeatureDescriptorEnum.subjectStatement, subjectStatement);
	}
}
