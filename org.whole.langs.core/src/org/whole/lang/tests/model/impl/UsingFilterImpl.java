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
public class UsingFilterImpl extends AbstractSimpleEntity implements
		UsingFilter {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<UsingFilter> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.UsingFilter;
	}

	public int wGetEntityOrd() {
		return TestsEntityDescriptorEnum.UsingFilter_ord;
	}

	public void accept(ITestsVisitor visitor) {
		visitor.visit(this);
	}

	private Filter filter;

	public Filter getFilter() {
		return notifyRequested(TestsFeatureDescriptorEnum.filter, filter);
	}

	public void setFilter(Filter filter) {
		notifyChanged(TestsFeatureDescriptorEnum.filter, this.filter,
				this.filter = filter);
	}

	private SubjectStatement subjectStatement;

	public SubjectStatement getSubjectStatement() {
		return notifyRequested(TestsFeatureDescriptorEnum.subjectStatement,
				subjectStatement);
	}

	public void setSubjectStatement(SubjectStatement subjectStatement) {
		notifyChanged(TestsFeatureDescriptorEnum.subjectStatement,
				this.subjectStatement, this.subjectStatement = subjectStatement);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getFilter().wGetAdaptee(false);
		case 1:
			return getSubjectStatement().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setFilter(value.wGetAdapter(TestsEntityDescriptorEnum.Filter));
			break;
		case 1:
			setSubjectStatement(value
					.wGetAdapter(TestsEntityDescriptorEnum.SubjectStatement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
