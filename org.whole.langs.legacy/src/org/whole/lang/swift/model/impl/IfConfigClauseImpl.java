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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.IfConfigClause;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.PoundKeywordEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.model.AbstractElements;

/**
 *  @generator Whole
 */
public class IfConfigClauseImpl extends AbstractSimpleEntity implements IfConfigClause {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<IfConfigClause> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.IfConfigClause;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.IfConfigClause_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PoundKeywordEnum poundKeyword;

    public PoundKeywordEnum getPoundKeyword() {
        return notifyRequested(SwiftFeatureDescriptorEnum.poundKeyword, poundKeyword);
    }

    public void setPoundKeyword(PoundKeywordEnum poundKeyword) {
        notifyChanged(SwiftFeatureDescriptorEnum.poundKeyword, this.poundKeyword, this.poundKeyword = poundKeyword);
    }
    private Expr condition;

    public Expr getCondition() {
        return notifyRequested(SwiftFeatureDescriptorEnum.condition, condition);
    }

    public void setCondition(Expr condition) {
        notifyChanged(SwiftFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
    }
    private AbstractElements elements;

    public AbstractElements getElements() {
        return notifyRequested(SwiftFeatureDescriptorEnum.elements, elements);
    }

    public void setElements(AbstractElements elements) {
        notifyChanged(SwiftFeatureDescriptorEnum.elements, this.elements, this.elements = elements);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPoundKeyword().wGetAdaptee(false);
            case 1 :
            return getCondition().wGetAdaptee(false);
            case 2 :
            return getElements().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPoundKeyword(value.wGetAdapter(SwiftEntityDescriptorEnum.PoundKeywordEnum));
            break;
            case 1 :
            setCondition(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 2 :
            setElements(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractElements));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
