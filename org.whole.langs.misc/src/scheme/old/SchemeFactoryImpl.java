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
package scheme.old;

import java.util.List;


public class SchemeFactoryImpl implements SchemeFactory {
    public SchemeDefinition createDefinition(String name, SchemeExpression expr) {
	return new SchemeDefinitionImpl(name, expr);
    }

    public SchemeBranch createBranch(SchemeExpression test, SchemeExpression e) {
	return new SchemeBranchImpl(test, e);
    }

    public SchemeExpression createApplyExpression(List exprs) {
	return new SchemeApplyExpressionImpl(exprs);
    }

    public SchemeExpression createLambdaExpression(List params, SchemeExpression expr) {
	return new SchemeLambdaExpressionImpl(params, expr);
    }

    public SchemeExpression createAndExpression(List exprs) {
	return new SchemeAndExpressionImpl(exprs);
    }

    public SchemeExpression createOrExpression(List exprs) {
	return new SchemeOrExpressionImpl(exprs);
    }

    public SchemeExpression createCondExpression(List branches, SchemeExpression e) {
	return new SchemeCondExpressionImpl(branches, e);
    }

    public SchemeExpression createLocalExpression(List bindings, SchemeExpression e) {
	return new SchemeLocalExpressionImpl(bindings, e);
    }

    public SchemeExpression createBeginExpression(List exprs) {
	return null;
    }

    public SchemeExpression createIdExpression(String id) {
	return new SchemeIdExpressionImpl(id);
    }

    public SchemeExpression createBoolExpression(boolean v) {
	return new SchemeConstExpressionImpl(SchemeBoolValueImpl.valueOf(v));
    }

    public SchemeExpression createIntExpression(int v) {
	return new SchemeConstExpressionImpl(SchemeIntValueImpl.valueOf(v));
    }

    public SchemeExpression createStringExpression(String v) {
	return new SchemeConstExpressionImpl(SchemeStringValueImpl.valueOf(v));
    }
}
