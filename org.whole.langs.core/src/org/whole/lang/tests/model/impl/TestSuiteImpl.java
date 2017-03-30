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
package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.PackageName;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.model.Description;
import org.whole.lang.tests.model.Name;
import org.whole.lang.tests.model.Statement;
import org.whole.lang.tests.model.FilterFamilies;
import org.whole.lang.tests.model.TestCases;
import org.whole.lang.tests.model.Results;

/**
 *  @generator Whole
 */
public class TestSuiteImpl extends AbstractSimpleEntity implements TestSuite {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TestSuite> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.TestSuite;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.TestSuite_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PackageName packageName;

    public PackageName getPackageName() {
        return notifyRequested(TestsFeatureDescriptorEnum.packageName, packageName);
    }

    public void setPackageName(PackageName packageName) {
        notifyChanged(TestsFeatureDescriptorEnum.packageName, this.packageName, this.packageName = packageName);
    }
    private Description description;

    public Description getDescription() {
        return notifyRequested(TestsFeatureDescriptorEnum.description, description);
    }

    public void setDescription(Description description) {
        notifyChanged(TestsFeatureDescriptorEnum.description, this.description, this.description = description);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(TestsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(TestsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Statement deployer;

    public Statement getDeployer() {
        return notifyRequested(TestsFeatureDescriptorEnum.deployer, deployer);
    }

    public void setDeployer(Statement deployer) {
        notifyChanged(TestsFeatureDescriptorEnum.deployer, this.deployer, this.deployer = deployer);
    }
    private FilterFamilies filterFamilies;

    public FilterFamilies getFilterFamilies() {
        return notifyRequested(TestsFeatureDescriptorEnum.filterFamilies, filterFamilies);
    }

    public void setFilterFamilies(FilterFamilies filterFamilies) {
        notifyChanged(TestsFeatureDescriptorEnum.filterFamilies, this.filterFamilies, this.filterFamilies = filterFamilies);
    }
    private TestCases testCases;

    public TestCases getTestCases() {
        return notifyRequested(TestsFeatureDescriptorEnum.testCases, testCases);
    }

    public void setTestCases(TestCases testCases) {
        notifyChanged(TestsFeatureDescriptorEnum.testCases, this.testCases, this.testCases = testCases);
    }
    private Results actualResults;

    public Results getActualResults() {
        return notifyRequested(TestsFeatureDescriptorEnum.actualResults, actualResults);
    }

    public void setActualResults(Results actualResults) {
        notifyChanged(TestsFeatureDescriptorEnum.actualResults, this.actualResults, this.actualResults = actualResults);
    }
    private Results expectedResults;

    public Results getExpectedResults() {
        return notifyRequested(TestsFeatureDescriptorEnum.expectedResults, expectedResults);
    }

    public void setExpectedResults(Results expectedResults) {
        notifyChanged(TestsFeatureDescriptorEnum.expectedResults, this.expectedResults, this.expectedResults = expectedResults);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPackageName().wGetAdaptee(false);
            case 1 :
            return getDescription().wGetAdaptee(false);
            case 2 :
            return getName().wGetAdaptee(false);
            case 3 :
            return getDeployer().wGetAdaptee(false);
            case 4 :
            return getFilterFamilies().wGetAdaptee(false);
            case 5 :
            return getTestCases().wGetAdaptee(false);
            case 6 :
            return getActualResults().wGetAdaptee(false);
            case 7 :
            return getExpectedResults().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPackageName(value.wGetAdapter(TestsEntityDescriptorEnum.PackageName));
            break;
            case 1 :
            setDescription(value.wGetAdapter(TestsEntityDescriptorEnum.Description));
            break;
            case 2 :
            setName(value.wGetAdapter(TestsEntityDescriptorEnum.Name));
            break;
            case 3 :
            setDeployer(value.wGetAdapter(TestsEntityDescriptorEnum.Statement));
            break;
            case 4 :
            setFilterFamilies(value.wGetAdapter(TestsEntityDescriptorEnum.FilterFamilies));
            break;
            case 5 :
            setTestCases(value.wGetAdapter(TestsEntityDescriptorEnum.TestCases));
            break;
            case 6 :
            setActualResults(value.wGetAdapter(TestsEntityDescriptorEnum.Results));
            break;
            case 7 :
            setExpectedResults(value.wGetAdapter(TestsEntityDescriptorEnum.Results));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
