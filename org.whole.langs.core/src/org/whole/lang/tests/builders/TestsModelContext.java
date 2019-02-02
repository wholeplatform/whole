/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.tests.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class TestsModelContext extends EntityContext {

    public TestsModelContext(IEntity root) {
        super(root);
    }

    public TestsModelContext getPackageName() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.packageName);
    }

    public void setPackageName(TestsModelContext packageName) {
        wSet(TestsFeatureDescriptorEnum.packageName, packageName);
    }

    public TestsModelContext getDescription() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.description);
    }

    public void setDescription(TestsModelContext description) {
        wSet(TestsFeatureDescriptorEnum.description, description);
    }

    public TestsModelContext getName() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.name);
    }

    public void setName(TestsModelContext name) {
        wSet(TestsFeatureDescriptorEnum.name, name);
    }

    public TestsModelContext getDeployer() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.deployer);
    }

    public void setDeployer(TestsModelContext deployer) {
        wSet(TestsFeatureDescriptorEnum.deployer, deployer);
    }

    public TestsModelContext getFilterFamilies() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.filterFamilies);
    }

    public void setFilterFamilies(TestsModelContext filterFamilies) {
        wSet(TestsFeatureDescriptorEnum.filterFamilies, filterFamilies);
    }

    public TestsModelContext getTestCases() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.testCases);
    }

    public void setTestCases(TestsModelContext testCases) {
        wSet(TestsFeatureDescriptorEnum.testCases, testCases);
    }

    public TestsModelContext getActualResults() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.actualResults);
    }

    public void setActualResults(TestsModelContext actualResults) {
        wSet(TestsFeatureDescriptorEnum.actualResults, actualResults);
    }

    public TestsModelContext getExpectedResults() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.expectedResults);
    }

    public void setExpectedResults(TestsModelContext expectedResults) {
        wSet(TestsFeatureDescriptorEnum.expectedResults, expectedResults);
    }

    public TestsModelContext getFilterRules() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.filterRules);
    }

    public void setFilterRules(TestsModelContext filterRules) {
        wSet(TestsFeatureDescriptorEnum.filterRules, filterRules);
    }

    public TestsModelContext getBody() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.body);
    }

    public void setBody(TestsModelContext body) {
        wSet(TestsFeatureDescriptorEnum.body, body);
    }

    public TestsModelContext getAspects() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.aspects);
    }

    public void setAspects(TestsModelContext aspects) {
        wSet(TestsFeatureDescriptorEnum.aspects, aspects);
    }

    public TestsModelContext getTests() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.tests);
    }

    public void setTests(TestsModelContext tests) {
        wSet(TestsFeatureDescriptorEnum.tests, tests);
    }

    public TestsModelContext getActualResult() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.actualResult);
    }

    public void setActualResult(TestsModelContext actualResult) {
        wSet(TestsFeatureDescriptorEnum.actualResult, actualResult);
    }

    public TestsModelContext getExpectedResult() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.expectedResult);
    }

    public void setExpectedResult(TestsModelContext expectedResult) {
        wSet(TestsFeatureDescriptorEnum.expectedResult, expectedResult);
    }

    public TestsModelContext getKind() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.kind);
    }

    public void setKind(TestsModelContext kind) {
        wSet(TestsFeatureDescriptorEnum.kind, kind);
    }

    public TestsModelContext getFilter() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.filter);
    }

    public void setFilter(TestsModelContext filter) {
        wSet(TestsFeatureDescriptorEnum.filter, filter);
    }

    public TestsModelContext getSubjectStatement() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.subjectStatement);
    }

    public void setSubjectStatement(TestsModelContext subjectStatement) {
        wSet(TestsFeatureDescriptorEnum.subjectStatement, subjectStatement);
    }

    public TestsModelContext getSubject() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.subject);
    }

    public void setSubject(TestsModelContext subject) {
        wSet(TestsFeatureDescriptorEnum.subject, subject);
    }

    public TestsModelContext getConstraint() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.constraint);
    }

    public void setConstraint(TestsModelContext constraint) {
        wSet(TestsFeatureDescriptorEnum.constraint, constraint);
    }

    public TestsModelContext getDescriptorName() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.descriptorName);
    }

    public void setDescriptorName(TestsModelContext descriptorName) {
        wSet(TestsFeatureDescriptorEnum.descriptorName, descriptorName);
    }

    public TestsModelContext getThrowableType() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.throwableType);
    }

    public void setThrowableType(TestsModelContext throwableType) {
        wSet(TestsFeatureDescriptorEnum.throwableType, throwableType);
    }

    public TestsModelContext getObject() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.object);
    }

    public void setObject(TestsModelContext object) {
        wSet(TestsFeatureDescriptorEnum.object, object);
    }

    public TestsModelContext getSuccesses() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.successes);
    }

    public void setSuccesses(TestsModelContext successes) {
        wSet(TestsFeatureDescriptorEnum.successes, successes);
    }

    public TestsModelContext getFailures() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.failures);
    }

    public void setFailures(TestsModelContext failures) {
        wSet(TestsFeatureDescriptorEnum.failures, failures);
    }

    public TestsModelContext getErrors() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.errors);
    }

    public void setErrors(TestsModelContext errors) {
        wSet(TestsFeatureDescriptorEnum.errors, errors);
    }

    public TestsModelContext getOutcome() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.outcome);
    }

    public void setOutcome(TestsModelContext outcome) {
        wSet(TestsFeatureDescriptorEnum.outcome, outcome);
    }

    public TestsModelContext getLocation() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.location);
    }

    public void setLocation(TestsModelContext location) {
        wSet(TestsFeatureDescriptorEnum.location, location);
    }

    public TestsModelContext getCause() {
        return (TestsModelContext) wGet(TestsFeatureDescriptorEnum.cause);
    }

    public void setCause(TestsModelContext cause) {
        wSet(TestsFeatureDescriptorEnum.cause, cause);
    }
}
