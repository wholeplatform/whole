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
import org.whole.lang.swift.model.ArrowExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Throws;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ArrowExprImpl extends AbstractSimpleEntity implements ArrowExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ArrowExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ArrowExpr;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ArrowExpr_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Throws throwsToken;

    public Throws getThrowsToken() {
        return notifyRequested(SwiftFeatureDescriptorEnum.throwsToken, throwsToken);
    }

    public void setThrowsToken(Throws throwsToken) {
        notifyChanged(SwiftFeatureDescriptorEnum.throwsToken, this.throwsToken, this.throwsToken = throwsToken);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getThrowsToken().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setThrowsToken(value.wGetAdapter(SwiftEntityDescriptorEnum.Throws));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
