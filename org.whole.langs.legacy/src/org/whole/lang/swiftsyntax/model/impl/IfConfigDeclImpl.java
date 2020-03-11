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
import org.whole.lang.swiftsyntax.model.IfConfigDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.IfConfigClauseList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;

/**
 *  @generator Whole
 */
public class IfConfigDeclImpl extends AbstractSimpleEntity implements IfConfigDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<IfConfigDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.IfConfigDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.IfConfigDecl_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private IfConfigClauseList clauses;

    public IfConfigClauseList getClauses() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.clauses, clauses);
    }

    public void setClauses(IfConfigClauseList clauses) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.clauses, this.clauses, this.clauses = clauses);
    }
    private Token poundEndif;

    public Token getPoundEndif() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.poundEndif, poundEndif);
    }

    public void setPoundEndif(Token poundEndif) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.poundEndif, this.poundEndif, this.poundEndif = poundEndif);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getClauses().wGetAdaptee(false);
            case 1 :
            return getPoundEndif().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setClauses(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.IfConfigClauseList));
            break;
            case 1 :
            setPoundEndif(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
