package org.whole.lang.tests.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

/** 
 * @generator Whole
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
}
