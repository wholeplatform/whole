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
package org.whole.lang.reusables.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.reusables.model.Adapt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.reusables.model.Reusable;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.model.Expression;
import org.whole.lang.reusables.model.Revision;

/**
 *  @generator Whole
 */
public class AdaptImpl extends AbstractSimpleEntity implements Adapt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Adapt> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Adapt;
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.Adapt_ord;
    }

    public void accept(IReusablesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Reusable original;

    public Reusable getOriginal() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.original, original);
    }

    public void setOriginal(Reusable original) {
        notifyChanged(ReusablesFeatureDescriptorEnum.original, this.original, this.original = original);
    }
    private Expression adapter;

    public Expression getAdapter() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.adapter, adapter);
    }

    public void setAdapter(Expression adapter) {
        notifyChanged(ReusablesFeatureDescriptorEnum.adapter, this.adapter, this.adapter = adapter);
    }
    private Reusable adapted;

    public Reusable getAdapted() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.adapted, adapted);
    }

    public void setAdapted(Reusable adapted) {
        notifyChanged(ReusablesFeatureDescriptorEnum.adapted, this.adapted, this.adapted = adapted);
    }
    private Revision adaptedRevision;

    public Revision getAdaptedRevision() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.adaptedRevision, adaptedRevision);
    }

    public void setAdaptedRevision(Revision adaptedRevision) {
        notifyChanged(ReusablesFeatureDescriptorEnum.adaptedRevision, this.adaptedRevision, this.adaptedRevision = adaptedRevision);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getOriginal().wGetAdaptee(false);
            case 1 :
            return getAdapter().wGetAdaptee(false);
            case 2 :
            return getAdapted().wGetAdaptee(false);
            case 3 :
            return getAdaptedRevision().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setOriginal(value.wGetAdapter(ReusablesEntityDescriptorEnum.Reusable));
            break;
            case 1 :
            setAdapter(value.wGetAdapter(ReusablesEntityDescriptorEnum.Expression));
            break;
            case 2 :
            setAdapted(value.wGetAdapter(ReusablesEntityDescriptorEnum.Reusable));
            break;
            case 3 :
            setAdaptedRevision(value.wGetAdapter(ReusablesEntityDescriptorEnum.Revision));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
