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
package org.whole.lang.tests.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.tests.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TestsEntityFactory extends GenericEntityFactory {
    public static final TestsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static TestsEntityFactory instance(IEntityRegistryProvider provider) {
        return new TestsEntityFactory(provider);
    }

    protected TestsEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public TestSuite createTestSuite() {
        return create(TestsEntityDescriptorEnum.TestSuite);
    }

    public TestSuite createTestSuite(PackageName packageName, Description description, Name name, Statement deployer, FilterFamilies filterFamilies, TestCases testCases, Results actualResults, Results expectedResults) {
        return create(TestsEntityDescriptorEnum.TestSuite, packageName, description, name, deployer, filterFamilies, testCases, actualResults, expectedResults);
    }

    public IEntityBuilder<TestSuite> buildTestSuite() {
        return new EntityBuilder<TestSuite>(create(TestsEntityDescriptorEnum.TestSuite));
    }

    public FilterFamilies createFilterFamilies() {
        return create(TestsEntityDescriptorEnum.FilterFamilies);
    }

    public FilterFamilies createFilterFamilies(FilterFamily... entities) {
        return create(TestsEntityDescriptorEnum.FilterFamilies, (IEntity[]) entities);
    }

    public FilterFamilies createFilterFamilies(int initialSize) {
        return clone(TestsEntityDescriptorEnum.FilterFamilies, initialSize);
    }

    public FilterFamily createFilterFamily() {
        return create(TestsEntityDescriptorEnum.FilterFamily);
    }

    public FilterFamily createFilterFamily(PackageName packageName, Description description, Name name, FilterRules filterRules) {
        return create(TestsEntityDescriptorEnum.FilterFamily, packageName, description, name, filterRules);
    }

    public IEntityBuilder<FilterFamily> buildFilterFamily() {
        return new EntityBuilder<FilterFamily>(create(TestsEntityDescriptorEnum.FilterFamily));
    }

    public FilterRules createFilterRules() {
        return create(TestsEntityDescriptorEnum.FilterRules);
    }

    public FilterRules createFilterRules(FilterRule... entities) {
        return create(TestsEntityDescriptorEnum.FilterRules, (IEntity[]) entities);
    }

    public FilterRules createFilterRules(int initialSize) {
        return clone(TestsEntityDescriptorEnum.FilterRules, initialSize);
    }

    public FilterRule createFilterRule() {
        return create(TestsEntityDescriptorEnum.FilterRule);
    }

    public FilterRule createFilterRule(Description description, Name name, Statement body) {
        return create(TestsEntityDescriptorEnum.FilterRule, description, name, body);
    }

    public IEntityBuilder<FilterRule> buildFilterRule() {
        return new EntityBuilder<FilterRule>(create(TestsEntityDescriptorEnum.FilterRule));
    }

    public TestCases createTestCases() {
        return create(TestsEntityDescriptorEnum.TestCases);
    }

    public TestCases createTestCases(TestCase... entities) {
        return create(TestsEntityDescriptorEnum.TestCases, (IEntity[]) entities);
    }

    public TestCases createTestCases(int initialSize) {
        return clone(TestsEntityDescriptorEnum.TestCases, initialSize);
    }

    public TestCase createTestCase() {
        return create(TestsEntityDescriptorEnum.TestCase);
    }

    public TestCase createTestCase(PackageName packageName, Description description, Name name, Statement deployer, Aspects aspects, Tests tests, Results actualResults, Results expectedResults) {
        return create(TestsEntityDescriptorEnum.TestCase, packageName, description, name, deployer, aspects, tests, actualResults, expectedResults);
    }

    public IEntityBuilder<TestCase> buildTestCase() {
        return new EntityBuilder<TestCase>(create(TestsEntityDescriptorEnum.TestCase));
    }

    public Aspects createAspects() {
        return create(TestsEntityDescriptorEnum.Aspects);
    }

    public Aspects createAspects(Aspect... entities) {
        return create(TestsEntityDescriptorEnum.Aspects, (IEntity[]) entities);
    }

    public Aspects createAspects(int initialSize) {
        return clone(TestsEntityDescriptorEnum.Aspects, initialSize);
    }

    public BeforeTestCase createBeforeTestCase() {
        return create(TestsEntityDescriptorEnum.BeforeTestCase);
    }

    public BeforeTestCase createBeforeTestCase(Description description, Name name, Statement body) {
        return create(TestsEntityDescriptorEnum.BeforeTestCase, description, name, body);
    }

    public IEntityBuilder<BeforeTestCase> buildBeforeTestCase() {
        return new EntityBuilder<BeforeTestCase>(create(TestsEntityDescriptorEnum.BeforeTestCase));
    }

    public AfterTestCase createAfterTestCase() {
        return create(TestsEntityDescriptorEnum.AfterTestCase);
    }

    public AfterTestCase createAfterTestCase(Description description, Name name, Statement body) {
        return create(TestsEntityDescriptorEnum.AfterTestCase, description, name, body);
    }

    public IEntityBuilder<AfterTestCase> buildAfterTestCase() {
        return new EntityBuilder<AfterTestCase>(create(TestsEntityDescriptorEnum.AfterTestCase));
    }

    public BeforeTest createBeforeTest() {
        return create(TestsEntityDescriptorEnum.BeforeTest);
    }

    public BeforeTest createBeforeTest(Description description, Name name, Statement body) {
        return create(TestsEntityDescriptorEnum.BeforeTest, description, name, body);
    }

    public IEntityBuilder<BeforeTest> buildBeforeTest() {
        return new EntityBuilder<BeforeTest>(create(TestsEntityDescriptorEnum.BeforeTest));
    }

    public AfterTest createAfterTest() {
        return create(TestsEntityDescriptorEnum.AfterTest);
    }

    public AfterTest createAfterTest(Description description, Name name, Statement body) {
        return create(TestsEntityDescriptorEnum.AfterTest, description, name, body);
    }

    public IEntityBuilder<AfterTest> buildAfterTest() {
        return new EntityBuilder<AfterTest>(create(TestsEntityDescriptorEnum.AfterTest));
    }

    public Tests createTests() {
        return create(TestsEntityDescriptorEnum.Tests);
    }

    public Tests createTests(Test... entities) {
        return create(TestsEntityDescriptorEnum.Tests, (IEntity[]) entities);
    }

    public Tests createTests(int initialSize) {
        return clone(TestsEntityDescriptorEnum.Tests, initialSize);
    }

    public Test createTest() {
        return create(TestsEntityDescriptorEnum.Test);
    }

    public Test createTest(Description description, Name name, TestStatements body, Result actualResult, Result expectedResult) {
        return create(TestsEntityDescriptorEnum.Test, description, name, body, actualResult, expectedResult);
    }

    public IEntityBuilder<Test> buildTest() {
        return new EntityBuilder<Test>(create(TestsEntityDescriptorEnum.Test));
    }

    public TestStatements createTestStatements() {
        return create(TestsEntityDescriptorEnum.TestStatements);
    }

    public TestStatements createTestStatements(TestStatement... entities) {
        return create(TestsEntityDescriptorEnum.TestStatements, (IEntity[]) entities);
    }

    public TestStatements createTestStatements(int initialSize) {
        return clone(TestsEntityDescriptorEnum.TestStatements, initialSize);
    }

    public Comment createComment() {
        return create(TestsEntityDescriptorEnum.Comment);
    }

    public Comment createComment(CommentKind kind, Description description) {
        return create(TestsEntityDescriptorEnum.Comment, kind, description);
    }

    public IEntityBuilder<Comment> buildComment() {
        return new EntityBuilder<Comment>(create(TestsEntityDescriptorEnum.Comment));
    }

    public CommentKind createCommentKind() {
        return create(TestsEntityDescriptorEnum.CommentKind);
    }

    public CommentKind createCommentKind(CommentKindEnum.Value value) {
        return create(TestsEntityDescriptorEnum.CommentKind, value);
    }

    public UsingFilter createUsingFilter() {
        return create(TestsEntityDescriptorEnum.UsingFilter);
    }

    public UsingFilter createUsingFilter(Filter filter, SubjectStatement subjectStatement) {
        return create(TestsEntityDescriptorEnum.UsingFilter, filter, subjectStatement);
    }

    public IEntityBuilder<UsingFilter> buildUsingFilter() {
        return new EntityBuilder<UsingFilter>(create(TestsEntityDescriptorEnum.UsingFilter));
    }

    public AssertThat createAssertThat() {
        return create(TestsEntityDescriptorEnum.AssertThat);
    }

    public AssertThat createAssertThat(Expression subject, Constraint constraint) {
        return create(TestsEntityDescriptorEnum.AssertThat, subject, constraint);
    }

    public IEntityBuilder<AssertThat> buildAssertThat() {
        return new EntityBuilder<AssertThat>(create(TestsEntityDescriptorEnum.AssertThat));
    }

    public AssumeThat createAssumeThat() {
        return create(TestsEntityDescriptorEnum.AssumeThat);
    }

    public AssumeThat createAssumeThat(Expression subject, Constraint constraint) {
        return create(TestsEntityDescriptorEnum.AssumeThat, subject, constraint);
    }

    public IEntityBuilder<AssumeThat> buildAssumeThat() {
        return new EntityBuilder<AssumeThat>(create(TestsEntityDescriptorEnum.AssumeThat));
    }

    public Filter createFilter() {
        return create(TestsEntityDescriptorEnum.Filter);
    }

    public Filter createFilter(Name name) {
        return create(TestsEntityDescriptorEnum.Filter, name);
    }

    public IsNull createIsNull() {
        return create(TestsEntityDescriptorEnum.IsNull);
    }

    public IsTrue createIsTrue() {
        return create(TestsEntityDescriptorEnum.IsTrue);
    }

    public IsFalse createIsFalse() {
        return create(TestsEntityDescriptorEnum.IsFalse);
    }

    public IsDef createIsDef() {
        return create(TestsEntityDescriptorEnum.IsDef);
    }

    public IsUndef createIsUndef() {
        return create(TestsEntityDescriptorEnum.IsUndef);
    }

    public HasKind createHasKind() {
        return create(TestsEntityDescriptorEnum.HasKind);
    }

    public HasKind createHasKind(Kind kind) {
        return create(TestsEntityDescriptorEnum.HasKind, kind);
    }

    public Kind createKind() {
        return create(TestsEntityDescriptorEnum.Kind);
    }

    public Kind createKind(KindEnum.Value value) {
        return create(TestsEntityDescriptorEnum.Kind, value);
    }

    public IsAssignableTo createIsAssignableTo() {
        return create(TestsEntityDescriptorEnum.IsAssignableTo);
    }

    public IsAssignableTo createIsAssignableTo(Name descriptorName) {
        return create(TestsEntityDescriptorEnum.IsAssignableTo, descriptorName);
    }

    public HasType createHasType() {
        return create(TestsEntityDescriptorEnum.HasType);
    }

    public HasType createHasType(Name descriptorName) {
        return create(TestsEntityDescriptorEnum.HasType, descriptorName);
    }

    public Throws createThrows() {
        return create(TestsEntityDescriptorEnum.Throws);
    }

    public Throws createThrows(ThrowableType throwableType) {
        return create(TestsEntityDescriptorEnum.Throws, throwableType);
    }

    public ThrowableType createThrowableType() {
        return create(TestsEntityDescriptorEnum.ThrowableType);
    }

    public ThrowableType createThrowableType(String value) {
        return create(TestsEntityDescriptorEnum.ThrowableType, value);
    }

    public Same createSame() {
        return create(TestsEntityDescriptorEnum.Same);
    }

    public Same createSame(Expression object) {
        return create(TestsEntityDescriptorEnum.Same, object);
    }

    public Equals createEquals() {
        return create(TestsEntityDescriptorEnum.Equals);
    }

    public Equals createEquals(Expression object) {
        return create(TestsEntityDescriptorEnum.Equals, object);
    }

    public Matches createMatches() {
        return create(TestsEntityDescriptorEnum.Matches);
    }

    public Matches createMatches(Expression object) {
        return create(TestsEntityDescriptorEnum.Matches, object);
    }

    public Not createNot() {
        return create(TestsEntityDescriptorEnum.Not);
    }

    public Not createNot(Constraint constraint) {
        return create(TestsEntityDescriptorEnum.Not, constraint);
    }

    public AllOf createAllOf() {
        return create(TestsEntityDescriptorEnum.AllOf);
    }

    public AllOf createAllOf(Constraint... entities) {
        return create(TestsEntityDescriptorEnum.AllOf, (IEntity[]) entities);
    }

    public AllOf createAllOf(int initialSize) {
        return clone(TestsEntityDescriptorEnum.AllOf, initialSize);
    }

    public AnyOf createAnyOf() {
        return create(TestsEntityDescriptorEnum.AnyOf);
    }

    public AnyOf createAnyOf(Constraint... entities) {
        return create(TestsEntityDescriptorEnum.AnyOf, (IEntity[]) entities);
    }

    public AnyOf createAnyOf(int initialSize) {
        return clone(TestsEntityDescriptorEnum.AnyOf, initialSize);
    }

    public Results createResults() {
        return create(TestsEntityDescriptorEnum.Results);
    }

    public Results createResults(IntLiteral successes, IntLiteral failures, IntLiteral errors) {
        return create(TestsEntityDescriptorEnum.Results, successes, failures, errors);
    }

    public IEntityBuilder<Results> buildResults() {
        return new EntityBuilder<Results>(create(TestsEntityDescriptorEnum.Results));
    }

    public Result createResult() {
        return create(TestsEntityDescriptorEnum.Result);
    }

    public Result createResult(Outcome outcome, StringLiteral location, StringLiteral cause) {
        return create(TestsEntityDescriptorEnum.Result, outcome, location, cause);
    }

    public IEntityBuilder<Result> buildResult() {
        return new EntityBuilder<Result>(create(TestsEntityDescriptorEnum.Result));
    }

    public Outcome createOutcome() {
        return create(TestsEntityDescriptorEnum.Outcome);
    }

    public Outcome createOutcome(OutcomeEnum.Value value) {
        return create(TestsEntityDescriptorEnum.Outcome, value);
    }

    public BooleanLiteral createBooleanLiteral() {
        return create(TestsEntityDescriptorEnum.BooleanLiteral);
    }

    public BooleanLiteral createBooleanLiteral(boolean value) {
        return create(TestsEntityDescriptorEnum.BooleanLiteral, value);
    }

    public IntLiteral createIntLiteral() {
        return create(TestsEntityDescriptorEnum.IntLiteral);
    }

    public IntLiteral createIntLiteral(int value) {
        return create(TestsEntityDescriptorEnum.IntLiteral, value);
    }

    public StringLiteral createStringLiteral() {
        return create(TestsEntityDescriptorEnum.StringLiteral);
    }

    public StringLiteral createStringLiteral(String value) {
        return create(TestsEntityDescriptorEnum.StringLiteral, value);
    }

    public DataName createDataName() {
        return create(TestsEntityDescriptorEnum.DataName);
    }

    public DataName createDataName(String value) {
        return create(TestsEntityDescriptorEnum.DataName, value);
    }

    public Sequence createSequence() {
        return create(TestsEntityDescriptorEnum.Sequence);
    }

    public Sequence createSequence(Expression... entities) {
        return create(TestsEntityDescriptorEnum.Sequence, (IEntity[]) entities);
    }

    public Sequence createSequence(int initialSize) {
        return clone(TestsEntityDescriptorEnum.Sequence, initialSize);
    }

    public Name createName() {
        return create(TestsEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(TestsEntityDescriptorEnum.Name, value);
    }

    public PackageName createPackageName() {
        return create(TestsEntityDescriptorEnum.PackageName);
    }

    public PackageName createPackageName(String value) {
        return create(TestsEntityDescriptorEnum.PackageName, value);
    }

    public Description createDescription() {
        return create(TestsEntityDescriptorEnum.Description);
    }

    public Description createDescription(String value) {
        return create(TestsEntityDescriptorEnum.Description, value);
    }
}
