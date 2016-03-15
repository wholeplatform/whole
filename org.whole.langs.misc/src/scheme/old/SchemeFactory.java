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

interface SchemeFactory {
    public SchemeDefinition createDefinition(String name, SchemeExpression expr);
    public SchemeBranch createBranch(SchemeExpression test, SchemeExpression e);
    public SchemeExpression createApplyExpression(List exprs);
    public SchemeExpression createLambdaExpression(List params, SchemeExpression expr);
    public SchemeExpression createAndExpression(List exprs);
    public SchemeExpression createOrExpression(List exprs);
    public SchemeExpression createCondExpression(List branches, SchemeExpression e);
    public SchemeExpression createLocalExpression(List bindings, SchemeExpression e);
    public SchemeExpression createBeginExpression(List exprs);
    public SchemeExpression createIdExpression(String id);
    public SchemeExpression createBoolExpression(boolean v);
    public SchemeExpression createIntExpression(int v);
    public SchemeExpression createStringExpression(String v);
}
