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
package org.whole.lang.swiftsyntax.model;


/**
 *  @generator Whole
 */
public interface RepeatWhileStmt extends ISwiftSyntaxEntity, Stmt {


    public Token getLabelName();

    public void setLabelName(Token labelName);

    public Token getLabelColon();

    public void setLabelColon(Token labelColon);

    public Token getRepeatKeyword();

    public void setRepeatKeyword(Token repeatKeyword);

    public CodeBlock getBody();

    public void setBody(CodeBlock body);

    public Token getWhileKeyword();

    public void setWhileKeyword(Token whileKeyword);

    public Expr getCondition();

    public void setCondition(Expr condition);
}
