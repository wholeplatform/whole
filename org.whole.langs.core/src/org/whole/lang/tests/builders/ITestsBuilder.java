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

import org.whole.lang.builders.IBuilder;
import org.whole.lang.tests.model.CommentKindEnum;
import org.whole.lang.tests.model.KindEnum;
import org.whole.lang.tests.model.OutcomeEnum;

/**
 *  @generator Whole
 */
public interface ITestsBuilder extends IBuilder {


    public void visit();

    public void cause();

    public void location();

    public void outcome();

    public void errors();

    public void failures();

    public void successes();

    public void object();

    public void throwableType();

    public void descriptorName();

    public void constraint();

    public void subject();

    public void subjectStatement();

    public void filter();

    public void kind();

    public void expectedResult();

    public void actualResult();

    public void tests();

    public void aspects();

    public void body();

    public void filterRules();

    public void expectedResults();

    public void actualResults();

    public void testCases();

    public void filterFamilies();

    public void deployer();

    public void name();

    public void description();

    public void packageName();

    public void TestSuite();

    public void TestSuite_();

    public void _TestSuite();

    public void FilterFamilies();

    public void FilterFamilies_();

    public void FilterFamilies_(int initialCapacity);

    public void _FilterFamilies();

    public void FilterFamily();

    public void FilterFamily_();

    public void _FilterFamily();

    public void FilterRules();

    public void FilterRules_();

    public void FilterRules_(int initialCapacity);

    public void _FilterRules();

    public void FilterRule();

    public void FilterRule_();

    public void _FilterRule();

    public void TestCases();

    public void TestCases_();

    public void TestCases_(int initialCapacity);

    public void _TestCases();

    public void TestCase();

    public void TestCase_();

    public void _TestCase();

    public void Aspects();

    public void Aspects_();

    public void Aspects_(int initialCapacity);

    public void _Aspects();

    public void BeforeTestCase();

    public void BeforeTestCase_();

    public void _BeforeTestCase();

    public void AfterTestCase();

    public void AfterTestCase_();

    public void _AfterTestCase();

    public void BeforeTest();

    public void BeforeTest_();

    public void _BeforeTest();

    public void AfterTest();

    public void AfterTest_();

    public void _AfterTest();

    public void Tests();

    public void Tests_();

    public void Tests_(int initialCapacity);

    public void _Tests();

    public void Test();

    public void Test_();

    public void _Test();

    public void TestStatements();

    public void TestStatements_();

    public void TestStatements_(int initialCapacity);

    public void _TestStatements();

    public void Comment();

    public void Comment_();

    public void _Comment();

    public void CommentKind();

    public void CommentKind(CommentKindEnum.Value value);

    public void CommentKind(String value);

    public void UsingFilter();

    public void UsingFilter_();

    public void _UsingFilter();

    public void AssertThat();

    public void AssertThat_();

    public void _AssertThat();

    public void AssumeThat();

    public void AssumeThat_();

    public void _AssumeThat();

    public void Filter();

    public void Filter_();

    public void _Filter();

    public void IsNull();

    public void IsNull_();

    public void _IsNull();

    public void IsTrue();

    public void IsTrue_();

    public void _IsTrue();

    public void IsFalse();

    public void IsFalse_();

    public void _IsFalse();

    public void IsDef();

    public void IsDef_();

    public void _IsDef();

    public void IsUndef();

    public void IsUndef_();

    public void _IsUndef();

    public void HasKind();

    public void HasKind_();

    public void _HasKind();

    public void Kind();

    public void Kind(KindEnum.Value value);

    public void Kind(String value);

    public void IsAssignableTo();

    public void IsAssignableTo_();

    public void _IsAssignableTo();

    public void HasType();

    public void HasType_();

    public void _HasType();

    public void Throws();

    public void Throws_();

    public void _Throws();

    public void ThrowableType();

    public void ThrowableType(String value);

    public void Same();

    public void Same_();

    public void _Same();

    public void Equals();

    public void Equals_();

    public void _Equals();

    public void Matches();

    public void Matches_();

    public void _Matches();

    public void Not();

    public void Not_();

    public void _Not();

    public void AllOf();

    public void AllOf_();

    public void AllOf_(int initialCapacity);

    public void _AllOf();

    public void AnyOf();

    public void AnyOf_();

    public void AnyOf_(int initialCapacity);

    public void _AnyOf();

    public void Results();

    public void Results_();

    public void _Results();

    public void Result();

    public void Result_();

    public void _Result();

    public void Outcome();

    public void Outcome(OutcomeEnum.Value value);

    public void Outcome(String value);

    public void BooleanLiteral();

    public void BooleanLiteral(boolean value);

    public void IntLiteral();

    public void IntLiteral(int value);

    public void StringLiteral();

    public void StringLiteral(String value);

    public void DataName();

    public void DataName(String value);

    public void Sequence();

    public void Sequence_();

    public void Sequence_(int initialCapacity);

    public void _Sequence();

    public void Name();

    public void Name(String value);

    public void PackageName();

    public void PackageName(String value);

    public void Description();

    public void Description(String value);
}
