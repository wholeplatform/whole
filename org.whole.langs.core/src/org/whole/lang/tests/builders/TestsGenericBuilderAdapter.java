package org.whole.lang.tests.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.tests.model.CommentKindEnum.Value;

/** 
 * @generator Whole
 */
public class TestsGenericBuilderAdapter extends GenericIdentityBuilder {
	private ITestsBuilder specificBuilder;

	public TestsGenericBuilderAdapter(ITestsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public TestsGenericBuilderAdapter(ITestsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case TestsFeatureDescriptorEnum.packageName_ord:
			specificBuilder.packageName();
			break;
		case TestsFeatureDescriptorEnum.description_ord:
			specificBuilder.description();
			break;
		case TestsFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case TestsFeatureDescriptorEnum.deployer_ord:
			specificBuilder.deployer();
			break;
		case TestsFeatureDescriptorEnum.filterFamilies_ord:
			specificBuilder.filterFamilies();
			break;
		case TestsFeatureDescriptorEnum.testCases_ord:
			specificBuilder.testCases();
			break;
		case TestsFeatureDescriptorEnum.filterRules_ord:
			specificBuilder.filterRules();
			break;
		case TestsFeatureDescriptorEnum.body_ord:
			specificBuilder.body();
			break;
		case TestsFeatureDescriptorEnum.aspects_ord:
			specificBuilder.aspects();
			break;
		case TestsFeatureDescriptorEnum.tests_ord:
			specificBuilder.tests();
			break;
		case TestsFeatureDescriptorEnum.kind_ord:
			specificBuilder.kind();
			break;
		case TestsFeatureDescriptorEnum.filter_ord:
			specificBuilder.filter();
			break;
		case TestsFeatureDescriptorEnum.subjectStatement_ord:
			specificBuilder.subjectStatement();
			break;
		case TestsFeatureDescriptorEnum.subject_ord:
			specificBuilder.subject();
			break;
		case TestsFeatureDescriptorEnum.constraint_ord:
			specificBuilder.constraint();
			break;
		case TestsFeatureDescriptorEnum.descriptorName_ord:
			specificBuilder.descriptorName();
			break;
		case TestsFeatureDescriptorEnum.throwableType_ord:
			specificBuilder.throwableType();
			break;
		case TestsFeatureDescriptorEnum.object_ord:
			specificBuilder.object();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.TestSuite_ord:
			specificBuilder.TestSuite();
			break;
		case TestsEntityDescriptorEnum.FilterFamilies_ord:
			specificBuilder.FilterFamilies();
			break;
		case TestsEntityDescriptorEnum.FilterFamily_ord:
			specificBuilder.FilterFamily();
			break;
		case TestsEntityDescriptorEnum.FilterRules_ord:
			specificBuilder.FilterRules();
			break;
		case TestsEntityDescriptorEnum.FilterRule_ord:
			specificBuilder.FilterRule();
			break;
		case TestsEntityDescriptorEnum.TestCases_ord:
			specificBuilder.TestCases();
			break;
		case TestsEntityDescriptorEnum.TestCase_ord:
			specificBuilder.TestCase();
			break;
		case TestsEntityDescriptorEnum.Aspects_ord:
			specificBuilder.Aspects();
			break;
		case TestsEntityDescriptorEnum.BeforeTestCase_ord:
			specificBuilder.BeforeTestCase();
			break;
		case TestsEntityDescriptorEnum.AfterTestCase_ord:
			specificBuilder.AfterTestCase();
			break;
		case TestsEntityDescriptorEnum.BeforeTest_ord:
			specificBuilder.BeforeTest();
			break;
		case TestsEntityDescriptorEnum.AfterTest_ord:
			specificBuilder.AfterTest();
			break;
		case TestsEntityDescriptorEnum.Tests_ord:
			specificBuilder.Tests();
			break;
		case TestsEntityDescriptorEnum.Test_ord:
			specificBuilder.Test();
			break;
		case TestsEntityDescriptorEnum.TestStatements_ord:
			specificBuilder.TestStatements();
			break;
		case TestsEntityDescriptorEnum.Comment_ord:
			specificBuilder.Comment();
			break;
		case TestsEntityDescriptorEnum.UsingFilter_ord:
			specificBuilder.UsingFilter();
			break;
		case TestsEntityDescriptorEnum.AssertThat_ord:
			specificBuilder.AssertThat();
			break;
		case TestsEntityDescriptorEnum.AssumeThat_ord:
			specificBuilder.AssumeThat();
			break;
		case TestsEntityDescriptorEnum.Filter_ord:
			specificBuilder.Filter();
			break;
		case TestsEntityDescriptorEnum.IsNull_ord:
			specificBuilder.IsNull();
			break;
		case TestsEntityDescriptorEnum.IsTrue_ord:
			specificBuilder.IsTrue();
			break;
		case TestsEntityDescriptorEnum.IsFalse_ord:
			specificBuilder.IsFalse();
			break;
		case TestsEntityDescriptorEnum.IsDef_ord:
			specificBuilder.IsDef();
			break;
		case TestsEntityDescriptorEnum.IsUndef_ord:
			specificBuilder.IsUndef();
			break;
		case TestsEntityDescriptorEnum.HasKind_ord:
			specificBuilder.HasKind();
			break;
		case TestsEntityDescriptorEnum.IsAssignableTo_ord:
			specificBuilder.IsAssignableTo();
			break;
		case TestsEntityDescriptorEnum.HasType_ord:
			specificBuilder.HasType();
			break;
		case TestsEntityDescriptorEnum.Throws_ord:
			specificBuilder.Throws();
			break;
		case TestsEntityDescriptorEnum.Same_ord:
			specificBuilder.Same();
			break;
		case TestsEntityDescriptorEnum.Equals_ord:
			specificBuilder.Equals();
			break;
		case TestsEntityDescriptorEnum.Matches_ord:
			specificBuilder.Matches();
			break;
		case TestsEntityDescriptorEnum.Not_ord:
			specificBuilder.Not();
			break;
		case TestsEntityDescriptorEnum.AllOf_ord:
			specificBuilder.AllOf();
			break;
		case TestsEntityDescriptorEnum.AnyOf_ord:
			specificBuilder.AnyOf();
			break;
		case TestsEntityDescriptorEnum.Sequence_ord:
			specificBuilder.Sequence();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.TestSuite_ord:
			specificBuilder.TestSuite_();
			break;
		case TestsEntityDescriptorEnum.FilterFamilies_ord:
			specificBuilder.FilterFamilies_();
			break;
		case TestsEntityDescriptorEnum.FilterFamily_ord:
			specificBuilder.FilterFamily_();
			break;
		case TestsEntityDescriptorEnum.FilterRules_ord:
			specificBuilder.FilterRules_();
			break;
		case TestsEntityDescriptorEnum.FilterRule_ord:
			specificBuilder.FilterRule_();
			break;
		case TestsEntityDescriptorEnum.TestCases_ord:
			specificBuilder.TestCases_();
			break;
		case TestsEntityDescriptorEnum.TestCase_ord:
			specificBuilder.TestCase_();
			break;
		case TestsEntityDescriptorEnum.Aspects_ord:
			specificBuilder.Aspects_();
			break;
		case TestsEntityDescriptorEnum.BeforeTestCase_ord:
			specificBuilder.BeforeTestCase_();
			break;
		case TestsEntityDescriptorEnum.AfterTestCase_ord:
			specificBuilder.AfterTestCase_();
			break;
		case TestsEntityDescriptorEnum.BeforeTest_ord:
			specificBuilder.BeforeTest_();
			break;
		case TestsEntityDescriptorEnum.AfterTest_ord:
			specificBuilder.AfterTest_();
			break;
		case TestsEntityDescriptorEnum.Tests_ord:
			specificBuilder.Tests_();
			break;
		case TestsEntityDescriptorEnum.Test_ord:
			specificBuilder.Test_();
			break;
		case TestsEntityDescriptorEnum.TestStatements_ord:
			specificBuilder.TestStatements_();
			break;
		case TestsEntityDescriptorEnum.Comment_ord:
			specificBuilder.Comment_();
			break;
		case TestsEntityDescriptorEnum.UsingFilter_ord:
			specificBuilder.UsingFilter_();
			break;
		case TestsEntityDescriptorEnum.AssertThat_ord:
			specificBuilder.AssertThat_();
			break;
		case TestsEntityDescriptorEnum.AssumeThat_ord:
			specificBuilder.AssumeThat_();
			break;
		case TestsEntityDescriptorEnum.Filter_ord:
			specificBuilder.Filter_();
			break;
		case TestsEntityDescriptorEnum.IsNull_ord:
			specificBuilder.IsNull_();
			break;
		case TestsEntityDescriptorEnum.IsTrue_ord:
			specificBuilder.IsTrue_();
			break;
		case TestsEntityDescriptorEnum.IsFalse_ord:
			specificBuilder.IsFalse_();
			break;
		case TestsEntityDescriptorEnum.IsDef_ord:
			specificBuilder.IsDef_();
			break;
		case TestsEntityDescriptorEnum.IsUndef_ord:
			specificBuilder.IsUndef_();
			break;
		case TestsEntityDescriptorEnum.HasKind_ord:
			specificBuilder.HasKind_();
			break;
		case TestsEntityDescriptorEnum.IsAssignableTo_ord:
			specificBuilder.IsAssignableTo_();
			break;
		case TestsEntityDescriptorEnum.HasType_ord:
			specificBuilder.HasType_();
			break;
		case TestsEntityDescriptorEnum.Throws_ord:
			specificBuilder.Throws_();
			break;
		case TestsEntityDescriptorEnum.Same_ord:
			specificBuilder.Same_();
			break;
		case TestsEntityDescriptorEnum.Equals_ord:
			specificBuilder.Equals_();
			break;
		case TestsEntityDescriptorEnum.Matches_ord:
			specificBuilder.Matches_();
			break;
		case TestsEntityDescriptorEnum.Not_ord:
			specificBuilder.Not_();
			break;
		case TestsEntityDescriptorEnum.AllOf_ord:
			specificBuilder.AllOf_();
			break;
		case TestsEntityDescriptorEnum.AnyOf_ord:
			specificBuilder.AnyOf_();
			break;
		case TestsEntityDescriptorEnum.Sequence_ord:
			specificBuilder.Sequence_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.TestSuite_ord:
			specificBuilder._TestSuite();
			break;
		case TestsEntityDescriptorEnum.FilterFamilies_ord:
			specificBuilder._FilterFamilies();
			break;
		case TestsEntityDescriptorEnum.FilterFamily_ord:
			specificBuilder._FilterFamily();
			break;
		case TestsEntityDescriptorEnum.FilterRules_ord:
			specificBuilder._FilterRules();
			break;
		case TestsEntityDescriptorEnum.FilterRule_ord:
			specificBuilder._FilterRule();
			break;
		case TestsEntityDescriptorEnum.TestCases_ord:
			specificBuilder._TestCases();
			break;
		case TestsEntityDescriptorEnum.TestCase_ord:
			specificBuilder._TestCase();
			break;
		case TestsEntityDescriptorEnum.Aspects_ord:
			specificBuilder._Aspects();
			break;
		case TestsEntityDescriptorEnum.BeforeTestCase_ord:
			specificBuilder._BeforeTestCase();
			break;
		case TestsEntityDescriptorEnum.AfterTestCase_ord:
			specificBuilder._AfterTestCase();
			break;
		case TestsEntityDescriptorEnum.BeforeTest_ord:
			specificBuilder._BeforeTest();
			break;
		case TestsEntityDescriptorEnum.AfterTest_ord:
			specificBuilder._AfterTest();
			break;
		case TestsEntityDescriptorEnum.Tests_ord:
			specificBuilder._Tests();
			break;
		case TestsEntityDescriptorEnum.Test_ord:
			specificBuilder._Test();
			break;
		case TestsEntityDescriptorEnum.TestStatements_ord:
			specificBuilder._TestStatements();
			break;
		case TestsEntityDescriptorEnum.Comment_ord:
			specificBuilder._Comment();
			break;
		case TestsEntityDescriptorEnum.UsingFilter_ord:
			specificBuilder._UsingFilter();
			break;
		case TestsEntityDescriptorEnum.AssertThat_ord:
			specificBuilder._AssertThat();
			break;
		case TestsEntityDescriptorEnum.AssumeThat_ord:
			specificBuilder._AssumeThat();
			break;
		case TestsEntityDescriptorEnum.Filter_ord:
			specificBuilder._Filter();
			break;
		case TestsEntityDescriptorEnum.IsNull_ord:
			specificBuilder._IsNull();
			break;
		case TestsEntityDescriptorEnum.IsTrue_ord:
			specificBuilder._IsTrue();
			break;
		case TestsEntityDescriptorEnum.IsFalse_ord:
			specificBuilder._IsFalse();
			break;
		case TestsEntityDescriptorEnum.IsDef_ord:
			specificBuilder._IsDef();
			break;
		case TestsEntityDescriptorEnum.IsUndef_ord:
			specificBuilder._IsUndef();
			break;
		case TestsEntityDescriptorEnum.HasKind_ord:
			specificBuilder._HasKind();
			break;
		case TestsEntityDescriptorEnum.IsAssignableTo_ord:
			specificBuilder._IsAssignableTo();
			break;
		case TestsEntityDescriptorEnum.HasType_ord:
			specificBuilder._HasType();
			break;
		case TestsEntityDescriptorEnum.Throws_ord:
			specificBuilder._Throws();
			break;
		case TestsEntityDescriptorEnum.Same_ord:
			specificBuilder._Same();
			break;
		case TestsEntityDescriptorEnum.Equals_ord:
			specificBuilder._Equals();
			break;
		case TestsEntityDescriptorEnum.Matches_ord:
			specificBuilder._Matches();
			break;
		case TestsEntityDescriptorEnum.Not_ord:
			specificBuilder._Not();
			break;
		case TestsEntityDescriptorEnum.AllOf_ord:
			specificBuilder._AllOf();
			break;
		case TestsEntityDescriptorEnum.AnyOf_ord:
			specificBuilder._AnyOf();
			break;
		case TestsEntityDescriptorEnum.Sequence_ord:
			specificBuilder._Sequence();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.FilterFamilies_ord:
			specificBuilder.FilterFamilies_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.FilterRules_ord:
			specificBuilder.FilterRules_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.TestCases_ord:
			specificBuilder.TestCases_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.Aspects_ord:
			specificBuilder.Aspects_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.Tests_ord:
			specificBuilder.Tests_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.TestStatements_ord:
			specificBuilder.TestStatements_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.AllOf_ord:
			specificBuilder.AllOf_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.AnyOf_ord:
			specificBuilder.AnyOf_(initialCapacity);
			break;
		case TestsEntityDescriptorEnum.Sequence_ord:
			specificBuilder.Sequence_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.CommentKind_ord:
			specificBuilder.CommentKind((Value) value);
			break;
		case TestsEntityDescriptorEnum.Kind_ord:
			specificBuilder
					.Kind((org.whole.lang.tests.model.KindEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.ThrowableType_ord:
			specificBuilder.ThrowableType(value);
			break;
		case TestsEntityDescriptorEnum.StringLiteral_ord:
			specificBuilder.StringLiteral(value);
			break;
		case TestsEntityDescriptorEnum.DataName_ord:
			specificBuilder.DataName(value);
			break;
		case TestsEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case TestsEntityDescriptorEnum.PackageName_ord:
			specificBuilder.PackageName(value);
			break;
		case TestsEntityDescriptorEnum.Description_ord:
			specificBuilder.Description(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.BooleanLiteral_ord:
			specificBuilder.BooleanLiteral(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case TestsEntityDescriptorEnum.IntLiteral_ord:
			specificBuilder.IntLiteral(value);
			break;
		}
	}
}
