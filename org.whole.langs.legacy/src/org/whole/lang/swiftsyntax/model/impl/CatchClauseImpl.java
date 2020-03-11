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
package org.whole.lang.swiftsyntax.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swiftsyntax.model.CatchClause;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Pattern;
import org.whole.lang.swiftsyntax.model.WhereClause;
import org.whole.lang.swiftsyntax.model.CodeBlock;

/**
 *  @generator Whole
 */
public class CatchClauseImpl extends AbstractSimpleEntity implements CatchClause {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<CatchClause> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.CatchClause;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.CatchClause_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token catchKeyword;

    public Token getCatchKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.catchKeyword, catchKeyword);
    }

    public void setCatchKeyword(Token catchKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.catchKeyword, this.catchKeyword, this.catchKeyword = catchKeyword);
    }
    private Pattern pattern;

    public Pattern getPattern() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.pattern, pattern);
    }

    public void setPattern(Pattern pattern) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.pattern, this.pattern, this.pattern = pattern);
    }
    private WhereClause whereClause;

    public WhereClause getWhereClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.whereClause, whereClause);
    }

    public void setWhereClause(WhereClause whereClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.whereClause, this.whereClause, this.whereClause = whereClause);
    }
    private CodeBlock body;

    public CodeBlock getBody() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlock body) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCatchKeyword().wGetAdaptee(false);
            case 1 :
            return getPattern().wGetAdaptee(false);
            case 2 :
            return getWhereClause().wGetAdaptee(false);
            case 3 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCatchKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setPattern(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Pattern));
            break;
            case 2 :
            setWhereClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.WhereClause));
            break;
            case 3 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
