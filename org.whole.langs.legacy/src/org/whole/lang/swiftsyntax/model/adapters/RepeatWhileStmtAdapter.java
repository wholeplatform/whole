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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class RepeatWhileStmtAdapter extends AbstractEntityAdapter implements RepeatWhileStmt {
    private static final long serialVersionUID = 1;

    public RepeatWhileStmtAdapter(IEntity implementor) {
        super(implementor);
    }

    public RepeatWhileStmtAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<RepeatWhileStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.RepeatWhileStmt;
    }

    public Token getLabelName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.labelName).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLabelName(Token labelName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.labelName, labelName);
    }

    public Token getLabelColon() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.labelColon).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLabelColon(Token labelColon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.labelColon, labelColon);
    }

    public Token getRepeatKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.repeatKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setRepeatKeyword(Token repeatKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.repeatKeyword, repeatKeyword);
    }

    public CodeBlock getBody() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.body).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock);
    }

    public void setBody(CodeBlock body) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public Token getWhileKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.whileKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setWhileKeyword(Token whileKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.whileKeyword, whileKeyword);
    }

    public Expr getCondition() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.condition).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr);
    }

    public void setCondition(Expr condition) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.condition, condition);
    }
}
