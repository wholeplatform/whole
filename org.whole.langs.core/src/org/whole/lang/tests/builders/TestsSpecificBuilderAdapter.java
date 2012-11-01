package org.whole.lang.tests.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.model.CommentKindEnum;
import org.whole.lang.tests.model.KindEnum;

/** 
 * @generator Whole
 */
public class TestsSpecificBuilderAdapter extends GenericBuilderContext
		implements ITestsBuilder {
	public TestsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public TestsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void object() {
		wFeature(TestsFeatureDescriptorEnum.object);
	}

	public void throwableType() {
		wFeature(TestsFeatureDescriptorEnum.throwableType);
	}

	public void descriptorName() {
		wFeature(TestsFeatureDescriptorEnum.descriptorName);
	}

	public void constraint() {
		wFeature(TestsFeatureDescriptorEnum.constraint);
	}

	public void subject() {
		wFeature(TestsFeatureDescriptorEnum.subject);
	}

	public void subjectStatement() {
		wFeature(TestsFeatureDescriptorEnum.subjectStatement);
	}

	public void filter() {
		wFeature(TestsFeatureDescriptorEnum.filter);
	}

	public void kind() {
		wFeature(TestsFeatureDescriptorEnum.kind);
	}

	public void tests() {
		wFeature(TestsFeatureDescriptorEnum.tests);
	}

	public void aspects() {
		wFeature(TestsFeatureDescriptorEnum.aspects);
	}

	public void body() {
		wFeature(TestsFeatureDescriptorEnum.body);
	}

	public void filterRules() {
		wFeature(TestsFeatureDescriptorEnum.filterRules);
	}

	public void testCases() {
		wFeature(TestsFeatureDescriptorEnum.testCases);
	}

	public void filterFamilies() {
		wFeature(TestsFeatureDescriptorEnum.filterFamilies);
	}

	public void deployer() {
		wFeature(TestsFeatureDescriptorEnum.deployer);
	}

	public void name() {
		wFeature(TestsFeatureDescriptorEnum.name);
	}

	public void description() {
		wFeature(TestsFeatureDescriptorEnum.description);
	}

	public void packageName() {
		wFeature(TestsFeatureDescriptorEnum.packageName);
	}

	public void visit() {
	}

	public void TestSuite() {
		wEntity(TestsEntityDescriptorEnum.TestSuite);
	}

	public void TestSuite_() {
		wEntity_(TestsEntityDescriptorEnum.TestSuite);
	}

	public void _TestSuite() {
		_wEntity(TestsEntityDescriptorEnum.TestSuite);
	}

	public void FilterFamilies() {
		wEntity(TestsEntityDescriptorEnum.FilterFamilies);
	}

	public void FilterFamilies_() {
		wEntity_(TestsEntityDescriptorEnum.FilterFamilies);
	}

	public void FilterFamilies_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.FilterFamilies, initialCapacity);
	}

	public void _FilterFamilies() {
		_wEntity(TestsEntityDescriptorEnum.FilterFamilies);
	}

	public void FilterFamily() {
		wEntity(TestsEntityDescriptorEnum.FilterFamily);
	}

	public void FilterFamily_() {
		wEntity_(TestsEntityDescriptorEnum.FilterFamily);
	}

	public void _FilterFamily() {
		_wEntity(TestsEntityDescriptorEnum.FilterFamily);
	}

	public void FilterRules() {
		wEntity(TestsEntityDescriptorEnum.FilterRules);
	}

	public void FilterRules_() {
		wEntity_(TestsEntityDescriptorEnum.FilterRules);
	}

	public void FilterRules_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.FilterRules, initialCapacity);
	}

	public void _FilterRules() {
		_wEntity(TestsEntityDescriptorEnum.FilterRules);
	}

	public void FilterRule() {
		wEntity(TestsEntityDescriptorEnum.FilterRule);
	}

	public void FilterRule_() {
		wEntity_(TestsEntityDescriptorEnum.FilterRule);
	}

	public void _FilterRule() {
		_wEntity(TestsEntityDescriptorEnum.FilterRule);
	}

	public void TestCases() {
		wEntity(TestsEntityDescriptorEnum.TestCases);
	}

	public void TestCases_() {
		wEntity_(TestsEntityDescriptorEnum.TestCases);
	}

	public void TestCases_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.TestCases, initialCapacity);
	}

	public void _TestCases() {
		_wEntity(TestsEntityDescriptorEnum.TestCases);
	}

	public void TestCase() {
		wEntity(TestsEntityDescriptorEnum.TestCase);
	}

	public void TestCase_() {
		wEntity_(TestsEntityDescriptorEnum.TestCase);
	}

	public void _TestCase() {
		_wEntity(TestsEntityDescriptorEnum.TestCase);
	}

	public void Aspects() {
		wEntity(TestsEntityDescriptorEnum.Aspects);
	}

	public void Aspects_() {
		wEntity_(TestsEntityDescriptorEnum.Aspects);
	}

	public void Aspects_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.Aspects, initialCapacity);
	}

	public void _Aspects() {
		_wEntity(TestsEntityDescriptorEnum.Aspects);
	}

	public void BeforeTestCase() {
		wEntity(TestsEntityDescriptorEnum.BeforeTestCase);
	}

	public void BeforeTestCase_() {
		wEntity_(TestsEntityDescriptorEnum.BeforeTestCase);
	}

	public void _BeforeTestCase() {
		_wEntity(TestsEntityDescriptorEnum.BeforeTestCase);
	}

	public void AfterTestCase() {
		wEntity(TestsEntityDescriptorEnum.AfterTestCase);
	}

	public void AfterTestCase_() {
		wEntity_(TestsEntityDescriptorEnum.AfterTestCase);
	}

	public void _AfterTestCase() {
		_wEntity(TestsEntityDescriptorEnum.AfterTestCase);
	}

	public void BeforeTest() {
		wEntity(TestsEntityDescriptorEnum.BeforeTest);
	}

	public void BeforeTest_() {
		wEntity_(TestsEntityDescriptorEnum.BeforeTest);
	}

	public void _BeforeTest() {
		_wEntity(TestsEntityDescriptorEnum.BeforeTest);
	}

	public void AfterTest() {
		wEntity(TestsEntityDescriptorEnum.AfterTest);
	}

	public void AfterTest_() {
		wEntity_(TestsEntityDescriptorEnum.AfterTest);
	}

	public void _AfterTest() {
		_wEntity(TestsEntityDescriptorEnum.AfterTest);
	}

	public void Tests() {
		wEntity(TestsEntityDescriptorEnum.Tests);
	}

	public void Tests_() {
		wEntity_(TestsEntityDescriptorEnum.Tests);
	}

	public void Tests_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.Tests, initialCapacity);
	}

	public void _Tests() {
		_wEntity(TestsEntityDescriptorEnum.Tests);
	}

	public void Test() {
		wEntity(TestsEntityDescriptorEnum.Test);
	}

	public void Test_() {
		wEntity_(TestsEntityDescriptorEnum.Test);
	}

	public void _Test() {
		_wEntity(TestsEntityDescriptorEnum.Test);
	}

	public void TestStatements() {
		wEntity(TestsEntityDescriptorEnum.TestStatements);
	}

	public void TestStatements_() {
		wEntity_(TestsEntityDescriptorEnum.TestStatements);
	}

	public void TestStatements_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.TestStatements, initialCapacity);
	}

	public void _TestStatements() {
		_wEntity(TestsEntityDescriptorEnum.TestStatements);
	}

	public void Comment() {
		wEntity(TestsEntityDescriptorEnum.Comment);
	}

	public void Comment_() {
		wEntity_(TestsEntityDescriptorEnum.Comment);
	}

	public void _Comment() {
		_wEntity(TestsEntityDescriptorEnum.Comment);
	}

	public void CommentKind() {
		wEntity(TestsEntityDescriptorEnum.CommentKind);
	}

	public void CommentKind(CommentKindEnum.Value value) {
		wEntity(TestsEntityDescriptorEnum.CommentKind, value);
	}

	public void CommentKind(String value) {
		wEntity(TestsEntityDescriptorEnum.CommentKind, value);
	}

	public void UsingFilter() {
		wEntity(TestsEntityDescriptorEnum.UsingFilter);
	}

	public void UsingFilter_() {
		wEntity_(TestsEntityDescriptorEnum.UsingFilter);
	}

	public void _UsingFilter() {
		_wEntity(TestsEntityDescriptorEnum.UsingFilter);
	}

	public void AssertThat() {
		wEntity(TestsEntityDescriptorEnum.AssertThat);
	}

	public void AssertThat_() {
		wEntity_(TestsEntityDescriptorEnum.AssertThat);
	}

	public void _AssertThat() {
		_wEntity(TestsEntityDescriptorEnum.AssertThat);
	}

	public void AssumeThat() {
		wEntity(TestsEntityDescriptorEnum.AssumeThat);
	}

	public void AssumeThat_() {
		wEntity_(TestsEntityDescriptorEnum.AssumeThat);
	}

	public void _AssumeThat() {
		_wEntity(TestsEntityDescriptorEnum.AssumeThat);
	}

	public void Filter() {
		wEntity(TestsEntityDescriptorEnum.Filter);
	}

	public void Filter_() {
		wEntity_(TestsEntityDescriptorEnum.Filter);
	}

	public void _Filter() {
		_wEntity(TestsEntityDescriptorEnum.Filter);
	}

	public void IsNull() {
		wEntity(TestsEntityDescriptorEnum.IsNull);
	}

	public void IsNull_() {
		wEntity_(TestsEntityDescriptorEnum.IsNull);
	}

	public void _IsNull() {
		_wEntity(TestsEntityDescriptorEnum.IsNull);
	}

	public void IsTrue() {
		wEntity(TestsEntityDescriptorEnum.IsTrue);
	}

	public void IsTrue_() {
		wEntity_(TestsEntityDescriptorEnum.IsTrue);
	}

	public void _IsTrue() {
		_wEntity(TestsEntityDescriptorEnum.IsTrue);
	}

	public void IsFalse() {
		wEntity(TestsEntityDescriptorEnum.IsFalse);
	}

	public void IsFalse_() {
		wEntity_(TestsEntityDescriptorEnum.IsFalse);
	}

	public void _IsFalse() {
		_wEntity(TestsEntityDescriptorEnum.IsFalse);
	}

	public void IsDef() {
		wEntity(TestsEntityDescriptorEnum.IsDef);
	}

	public void IsDef_() {
		wEntity_(TestsEntityDescriptorEnum.IsDef);
	}

	public void _IsDef() {
		_wEntity(TestsEntityDescriptorEnum.IsDef);
	}

	public void IsUndef() {
		wEntity(TestsEntityDescriptorEnum.IsUndef);
	}

	public void IsUndef_() {
		wEntity_(TestsEntityDescriptorEnum.IsUndef);
	}

	public void _IsUndef() {
		_wEntity(TestsEntityDescriptorEnum.IsUndef);
	}

	public void HasKind() {
		wEntity(TestsEntityDescriptorEnum.HasKind);
	}

	public void HasKind_() {
		wEntity_(TestsEntityDescriptorEnum.HasKind);
	}

	public void _HasKind() {
		_wEntity(TestsEntityDescriptorEnum.HasKind);
	}

	public void Kind() {
		wEntity(TestsEntityDescriptorEnum.Kind);
	}

	public void Kind(KindEnum.Value value) {
		wEntity(TestsEntityDescriptorEnum.Kind, value);
	}

	public void Kind(String value) {
		wEntity(TestsEntityDescriptorEnum.Kind, value);
	}

	public void IsAssignableTo() {
		wEntity(TestsEntityDescriptorEnum.IsAssignableTo);
	}

	public void IsAssignableTo_() {
		wEntity_(TestsEntityDescriptorEnum.IsAssignableTo);
	}

	public void _IsAssignableTo() {
		_wEntity(TestsEntityDescriptorEnum.IsAssignableTo);
	}

	public void HasType() {
		wEntity(TestsEntityDescriptorEnum.HasType);
	}

	public void HasType_() {
		wEntity_(TestsEntityDescriptorEnum.HasType);
	}

	public void _HasType() {
		_wEntity(TestsEntityDescriptorEnum.HasType);
	}

	public void Throws() {
		wEntity(TestsEntityDescriptorEnum.Throws);
	}

	public void Throws_() {
		wEntity_(TestsEntityDescriptorEnum.Throws);
	}

	public void _Throws() {
		_wEntity(TestsEntityDescriptorEnum.Throws);
	}

	public void ThrowableType() {
		wEntity(TestsEntityDescriptorEnum.ThrowableType);
	}

	public void ThrowableType(String value) {
		wEntity(TestsEntityDescriptorEnum.ThrowableType, value);
	}

	public void Same() {
		wEntity(TestsEntityDescriptorEnum.Same);
	}

	public void Same_() {
		wEntity_(TestsEntityDescriptorEnum.Same);
	}

	public void _Same() {
		_wEntity(TestsEntityDescriptorEnum.Same);
	}

	public void Equals() {
		wEntity(TestsEntityDescriptorEnum.Equals);
	}

	public void Equals_() {
		wEntity_(TestsEntityDescriptorEnum.Equals);
	}

	public void _Equals() {
		_wEntity(TestsEntityDescriptorEnum.Equals);
	}

	public void Matches() {
		wEntity(TestsEntityDescriptorEnum.Matches);
	}

	public void Matches_() {
		wEntity_(TestsEntityDescriptorEnum.Matches);
	}

	public void _Matches() {
		_wEntity(TestsEntityDescriptorEnum.Matches);
	}

	public void Not() {
		wEntity(TestsEntityDescriptorEnum.Not);
	}

	public void Not_() {
		wEntity_(TestsEntityDescriptorEnum.Not);
	}

	public void _Not() {
		_wEntity(TestsEntityDescriptorEnum.Not);
	}

	public void AllOf() {
		wEntity(TestsEntityDescriptorEnum.AllOf);
	}

	public void AllOf_() {
		wEntity_(TestsEntityDescriptorEnum.AllOf);
	}

	public void AllOf_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.AllOf, initialCapacity);
	}

	public void _AllOf() {
		_wEntity(TestsEntityDescriptorEnum.AllOf);
	}

	public void AnyOf() {
		wEntity(TestsEntityDescriptorEnum.AnyOf);
	}

	public void AnyOf_() {
		wEntity_(TestsEntityDescriptorEnum.AnyOf);
	}

	public void AnyOf_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.AnyOf, initialCapacity);
	}

	public void _AnyOf() {
		_wEntity(TestsEntityDescriptorEnum.AnyOf);
	}

	public void BooleanLiteral() {
		wEntity(TestsEntityDescriptorEnum.BooleanLiteral);
	}

	public void BooleanLiteral(boolean value) {
		wEntity(TestsEntityDescriptorEnum.BooleanLiteral, value);
	}

	public void IntLiteral() {
		wEntity(TestsEntityDescriptorEnum.IntLiteral);
	}

	public void IntLiteral(int value) {
		wEntity(TestsEntityDescriptorEnum.IntLiteral, value);
	}

	public void StringLiteral() {
		wEntity(TestsEntityDescriptorEnum.StringLiteral);
	}

	public void StringLiteral(String value) {
		wEntity(TestsEntityDescriptorEnum.StringLiteral, value);
	}

	public void DataName() {
		wEntity(TestsEntityDescriptorEnum.DataName);
	}

	public void DataName(String value) {
		wEntity(TestsEntityDescriptorEnum.DataName, value);
	}

	public void Sequence() {
		wEntity(TestsEntityDescriptorEnum.Sequence);
	}

	public void Sequence_() {
		wEntity_(TestsEntityDescriptorEnum.Sequence);
	}

	public void Sequence_(int initialCapacity) {
		wEntity_(TestsEntityDescriptorEnum.Sequence, initialCapacity);
	}

	public void _Sequence() {
		_wEntity(TestsEntityDescriptorEnum.Sequence);
	}

	public void Name() {
		wEntity(TestsEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(TestsEntityDescriptorEnum.Name, value);
	}

	public void PackageName() {
		wEntity(TestsEntityDescriptorEnum.PackageName);
	}

	public void PackageName(String value) {
		wEntity(TestsEntityDescriptorEnum.PackageName, value);
	}

	public void Description() {
		wEntity(TestsEntityDescriptorEnum.Description);
	}

	public void Description(String value) {
		wEntity(TestsEntityDescriptorEnum.Description, value);
	}
}
