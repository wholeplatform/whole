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
public class IfConfigClauseAdapter extends AbstractEntityAdapter implements IfConfigClause {
    private static final long serialVersionUID = 1;

    public IfConfigClauseAdapter(IEntity implementor) {
        super(implementor);
    }

    public IfConfigClauseAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<IfConfigClause> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.IfConfigClause;
    }

    public Token getPoundKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.poundKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setPoundKeyword(Token poundKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.poundKeyword, poundKeyword);
    }

    public Expr getCondition() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.condition).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr);
    }

    public void setCondition(Expr condition) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.condition, condition);
    }

    public Syntax getElements() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.elements).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax);
    }

    public void setElements(Syntax elements) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.elements, elements);
    }
}
