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
import org.whole.lang.swift.model.PoundAssertStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.StringLiteral;

/**
 *  @generator Whole
 */
public class PoundAssertStmtImpl extends AbstractSimpleEntity implements PoundAssertStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PoundAssertStmt> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.PoundAssertStmt;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.PoundAssertStmt_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr condition;

    public Expr getCondition() {
        return notifyRequested(SwiftFeatureDescriptorEnum.condition, condition);
    }

    public void setCondition(Expr condition) {
        notifyChanged(SwiftFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
    }
    private StringLiteral message;

    public StringLiteral getMessage() {
        return notifyRequested(SwiftFeatureDescriptorEnum.message, message);
    }

    public void setMessage(StringLiteral message) {
        notifyChanged(SwiftFeatureDescriptorEnum.message, this.message, this.message = message);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCondition().wGetAdaptee(false);
            case 1 :
            return getMessage().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCondition(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setMessage(value.wGetAdapter(SwiftEntityDescriptorEnum.StringLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
