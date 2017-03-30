/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class TestSuiteAdapter extends AbstractEntityAdapter implements TestSuite {
    private static final long serialVersionUID = 1;

    public TestSuiteAdapter(IEntity implementor) {
        super(implementor);
    }

    public TestSuiteAdapter() {
    }

    public void accept(ITestsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<TestSuite> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.TestSuite;
    }

    public PackageName getPackageName() {
        return wGet(TestsFeatureDescriptorEnum.packageName).wGetAdapter(TestsEntityDescriptorEnum.PackageName);
    }

    public void setPackageName(PackageName packageName) {
        wSet(TestsFeatureDescriptorEnum.packageName, packageName);
    }

    public Description getDescription() {
        return wGet(TestsFeatureDescriptorEnum.description).wGetAdapter(TestsEntityDescriptorEnum.Description);
    }

    public void setDescription(Description description) {
        wSet(TestsFeatureDescriptorEnum.description, description);
    }

    public Name getName() {
        return wGet(TestsFeatureDescriptorEnum.name).wGetAdapter(TestsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(TestsFeatureDescriptorEnum.name, name);
    }

    public Statement getDeployer() {
        return wGet(TestsFeatureDescriptorEnum.deployer).wGetAdapter(TestsEntityDescriptorEnum.Statement);
    }

    public void setDeployer(Statement deployer) {
        wSet(TestsFeatureDescriptorEnum.deployer, deployer);
    }

    public FilterFamilies getFilterFamilies() {
        return wGet(TestsFeatureDescriptorEnum.filterFamilies).wGetAdapter(TestsEntityDescriptorEnum.FilterFamilies);
    }

    public void setFilterFamilies(FilterFamilies filterFamilies) {
        wSet(TestsFeatureDescriptorEnum.filterFamilies, filterFamilies);
    }

    public TestCases getTestCases() {
        return wGet(TestsFeatureDescriptorEnum.testCases).wGetAdapter(TestsEntityDescriptorEnum.TestCases);
    }

    public void setTestCases(TestCases testCases) {
        wSet(TestsFeatureDescriptorEnum.testCases, testCases);
    }

    public Results getActualResults() {
        return wGet(TestsFeatureDescriptorEnum.actualResults).wGetAdapter(TestsEntityDescriptorEnum.Results);
    }

    public void setActualResults(Results actualResults) {
        wSet(TestsFeatureDescriptorEnum.actualResults, actualResults);
    }

    public Results getExpectedResults() {
        return wGet(TestsFeatureDescriptorEnum.expectedResults).wGetAdapter(TestsEntityDescriptorEnum.Results);
    }

    public void setExpectedResults(Results expectedResults) {
        wSet(TestsFeatureDescriptorEnum.expectedResults, expectedResults);
    }
}
