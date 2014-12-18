/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.TryStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.model.Block;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.CatchClauses;

/**
 *  @generator Whole
 */
public class TryStatementImpl extends AbstractSimpleEntity implements TryStatement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TryStatement> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.TryStatement;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.TryStatement_ord;
    }

    public void accept(IJavaVisitor visitor) {
        visitor.visit(this);
    }
    private Block body;

    public Block getBody() {
        return notifyRequested(JavaFeatureDescriptorEnum.body, body);
    }

    public void setBody(Block body) {
        notifyChanged(JavaFeatureDescriptorEnum.body, this.body, this.body = body);
    }
    private CatchClauses catchClauses;

    public CatchClauses getCatchClauses() {
        return notifyRequested(JavaFeatureDescriptorEnum.catchClauses, catchClauses);
    }

    public void setCatchClauses(CatchClauses catchClauses) {
        notifyChanged(JavaFeatureDescriptorEnum.catchClauses, this.catchClauses, this.catchClauses = catchClauses);
    }
    private Block _finally;

    public Block getFinally() {
        return notifyRequested(JavaFeatureDescriptorEnum._finally, _finally);
    }

    public void setFinally(Block _finally) {
        notifyChanged(JavaFeatureDescriptorEnum._finally, this._finally, this._finally = _finally);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBody().wGetAdaptee(false);
            case 1 :
            return getCatchClauses().wGetAdaptee(false);
            case 2 :
            return getFinally().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
            break;
            case 1 :
            setCatchClauses(value.wGetAdapter(JavaEntityDescriptorEnum.CatchClauses));
            break;
            case 2 :
            setFinally(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
