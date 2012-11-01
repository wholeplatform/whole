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
public class FilterFamilyAdapter extends AbstractEntityAdapter implements
		FilterFamily {
	private static final long serialVersionUID = 1;

	public FilterFamilyAdapter(IEntity implementor) {
		super(implementor);
	}

	public FilterFamilyAdapter() {
	}

	public void accept(ITestsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FilterFamily> wGetEntityDescriptor() {
		return TestsEntityDescriptorEnum.FilterFamily;
	}

	public PackageName getPackageName() {
		return wGet(TestsFeatureDescriptorEnum.packageName).wGetAdapter(
				TestsEntityDescriptorEnum.PackageName);
	}

	public void setPackageName(PackageName packageName) {
		wSet(TestsFeatureDescriptorEnum.packageName, packageName);
	}

	public Description getDescription() {
		return wGet(TestsFeatureDescriptorEnum.description).wGetAdapter(
				TestsEntityDescriptorEnum.Description);
	}

	public void setDescription(Description description) {
		wSet(TestsFeatureDescriptorEnum.description, description);
	}

	public Name getName() {
		return wGet(TestsFeatureDescriptorEnum.name).wGetAdapter(
				TestsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(TestsFeatureDescriptorEnum.name, name);
	}

	public FilterRules getFilterRules() {
		return wGet(TestsFeatureDescriptorEnum.filterRules).wGetAdapter(
				TestsEntityDescriptorEnum.FilterRules);
	}

	public void setFilterRules(FilterRules filterRules) {
		wSet(TestsFeatureDescriptorEnum.filterRules, filterRules);
	}
}
