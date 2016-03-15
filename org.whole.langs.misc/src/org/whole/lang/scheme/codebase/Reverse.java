/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.scheme.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class Reverse extends AbstractTemplateFactory {


    public void apply(IBuilderOperation op) {
        org.whole.lang.scheme.builders.ISchemeBuilder b0 = (org.whole.lang.scheme.builders.ISchemeBuilder) op.wGetBuilder(org.whole.lang.scheme.reflect.SchemeLanguageKit.URI);
        b0.Definitions_(2);
        b0.Definition_();
        b0.Name("main");
        b0.ApplyExpression_();
        b0.SchemeExpressions_(2);
        b0.IdExpression("reverse");
        b0.ApplyExpression_();
        b0.SchemeExpressions_(11);
        b0.BuiltinValue("list");
        b0.IntValue(1);
        b0.IntValue(2);
        b0.IntValue(3);
        b0.IntValue(4);
        b0.IntValue(5);
        b0.IntValue(6);
        b0.IntValue(7);
        b0.IntValue(8);
        b0.IntValue(9);
        b0.IntValue(10);
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0._Definition();
        b0.Definition_();
        b0.Name("reverse");
        b0.LambdaExpression_();
        b0.Names_(1);
        b0.Name("l");
        b0._Names();
        b0.LocalExpression_();
        b0.Definitions_(1);
        b0.Definition_();
        b0.Name("aux");
        b0.LambdaExpression_();
        b0.Names_(2);
        b0.Name("l1");
        b0.Name("l2");
        b0._Names();
        b0.CondExpression_();
        b0.Branches_(1);
        b0.Branch_();
        b0.ApplyExpression_();
        b0.SchemeExpressions_(2);
        b0.BuiltinValue("nullp");
        b0.IdExpression("l2");
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0.IdExpression("l1");
        b0._Branch();
        b0._Branches();
        b0.ApplyExpression_();
        b0.SchemeExpressions_(3);
        b0.IdExpression("aux");
        b0.ApplyExpression_();
        b0.SchemeExpressions_(3);
        b0.BuiltinValue("cons");
        b0.ApplyExpression_();
        b0.SchemeExpressions_(2);
        b0.BuiltinValue("car");
        b0.IdExpression("l2");
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0.IdExpression("l1");
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0.ApplyExpression_();
        b0.SchemeExpressions_(2);
        b0.BuiltinValue("cdr");
        b0.IdExpression("l2");
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0._CondExpression();
        b0._LambdaExpression();
        b0._Definition();
        b0._Definitions();
        b0.ApplyExpression_();
        b0.SchemeExpressions_(3);
        b0.IdExpression("aux");
        b0.ApplyExpression_();
        b0.SchemeExpressions_(1);
        b0.BuiltinValue("list");
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0.IdExpression("l");
        b0._SchemeExpressions();
        b0._ApplyExpression();
        b0._LocalExpression();
        b0._LambdaExpression();
        b0._Definition();
        b0._Definitions();
    }
}
