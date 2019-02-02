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
package org.whole.lang.tests.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class TestsIdentitySwitchVisitor extends AbstractVisitor implements ITestsVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case TestsEntityDescriptorEnum.TestSuite_ord :
            visit((TestSuite) entity);
            break;
            case TestsEntityDescriptorEnum.FilterFamilies_ord :
            visit((FilterFamilies) entity);
            break;
            case TestsEntityDescriptorEnum.FilterFamily_ord :
            visit((FilterFamily) entity);
            break;
            case TestsEntityDescriptorEnum.FilterRules_ord :
            visit((FilterRules) entity);
            break;
            case TestsEntityDescriptorEnum.FilterRule_ord :
            visit((FilterRule) entity);
            break;
            case TestsEntityDescriptorEnum.TestCases_ord :
            visit((TestCases) entity);
            break;
            case TestsEntityDescriptorEnum.TestCase_ord :
            visit((TestCase) entity);
            break;
            case TestsEntityDescriptorEnum.Aspects_ord :
            visit((Aspects) entity);
            break;
            case TestsEntityDescriptorEnum.BeforeTestCase_ord :
            visit((BeforeTestCase) entity);
            break;
            case TestsEntityDescriptorEnum.AfterTestCase_ord :
            visit((AfterTestCase) entity);
            break;
            case TestsEntityDescriptorEnum.BeforeTest_ord :
            visit((BeforeTest) entity);
            break;
            case TestsEntityDescriptorEnum.AfterTest_ord :
            visit((AfterTest) entity);
            break;
            case TestsEntityDescriptorEnum.Tests_ord :
            visit((Tests) entity);
            break;
            case TestsEntityDescriptorEnum.Test_ord :
            visit((Test) entity);
            break;
            case TestsEntityDescriptorEnum.TestStatements_ord :
            visit((TestStatements) entity);
            break;
            case TestsEntityDescriptorEnum.Comment_ord :
            visit((Comment) entity);
            break;
            case TestsEntityDescriptorEnum.CommentKind_ord :
            visit((CommentKind) entity);
            break;
            case TestsEntityDescriptorEnum.UsingFilter_ord :
            visit((UsingFilter) entity);
            break;
            case TestsEntityDescriptorEnum.AssertThat_ord :
            visit((AssertThat) entity);
            break;
            case TestsEntityDescriptorEnum.AssumeThat_ord :
            visit((AssumeThat) entity);
            break;
            case TestsEntityDescriptorEnum.Filter_ord :
            visit((Filter) entity);
            break;
            case TestsEntityDescriptorEnum.IsNull_ord :
            visit((IsNull) entity);
            break;
            case TestsEntityDescriptorEnum.IsTrue_ord :
            visit((IsTrue) entity);
            break;
            case TestsEntityDescriptorEnum.IsFalse_ord :
            visit((IsFalse) entity);
            break;
            case TestsEntityDescriptorEnum.IsDef_ord :
            visit((IsDef) entity);
            break;
            case TestsEntityDescriptorEnum.IsUndef_ord :
            visit((IsUndef) entity);
            break;
            case TestsEntityDescriptorEnum.HasKind_ord :
            visit((HasKind) entity);
            break;
            case TestsEntityDescriptorEnum.Kind_ord :
            visit((Kind) entity);
            break;
            case TestsEntityDescriptorEnum.IsAssignableTo_ord :
            visit((IsAssignableTo) entity);
            break;
            case TestsEntityDescriptorEnum.HasType_ord :
            visit((HasType) entity);
            break;
            case TestsEntityDescriptorEnum.Throws_ord :
            visit((Throws) entity);
            break;
            case TestsEntityDescriptorEnum.ThrowableType_ord :
            visit((ThrowableType) entity);
            break;
            case TestsEntityDescriptorEnum.Same_ord :
            visit((Same) entity);
            break;
            case TestsEntityDescriptorEnum.Equals_ord :
            visit((Equals) entity);
            break;
            case TestsEntityDescriptorEnum.Matches_ord :
            visit((Matches) entity);
            break;
            case TestsEntityDescriptorEnum.Not_ord :
            visit((Not) entity);
            break;
            case TestsEntityDescriptorEnum.AllOf_ord :
            visit((AllOf) entity);
            break;
            case TestsEntityDescriptorEnum.AnyOf_ord :
            visit((AnyOf) entity);
            break;
            case TestsEntityDescriptorEnum.Results_ord :
            visit((Results) entity);
            break;
            case TestsEntityDescriptorEnum.Result_ord :
            visit((Result) entity);
            break;
            case TestsEntityDescriptorEnum.Outcome_ord :
            visit((Outcome) entity);
            break;
            case TestsEntityDescriptorEnum.BooleanLiteral_ord :
            visit((BooleanLiteral) entity);
            break;
            case TestsEntityDescriptorEnum.IntLiteral_ord :
            visit((IntLiteral) entity);
            break;
            case TestsEntityDescriptorEnum.StringLiteral_ord :
            visit((StringLiteral) entity);
            break;
            case TestsEntityDescriptorEnum.DataName_ord :
            visit((DataName) entity);
            break;
            case TestsEntityDescriptorEnum.Sequence_ord :
            visit((Sequence) entity);
            break;
            case TestsEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case TestsEntityDescriptorEnum.PackageName_ord :
            visit((PackageName) entity);
            break;
            case TestsEntityDescriptorEnum.Description_ord :
            visit((Description) entity);
            break;
        }
    }
}
