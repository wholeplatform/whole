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
import org.whole.lang.swift.model.PrecedenceGroupRelation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.HigherThanOrLowerThanValue;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.PrecedenceGroupNameList;

/**
 *  @generator Whole
 */
public class PrecedenceGroupRelationImpl extends AbstractSimpleEntity implements PrecedenceGroupRelation {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PrecedenceGroupRelation> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.PrecedenceGroupRelation;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.PrecedenceGroupRelation_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private HigherThanOrLowerThanValue higherThanOrLowerThan;

    public HigherThanOrLowerThanValue getHigherThanOrLowerThan() {
        return notifyRequested(SwiftFeatureDescriptorEnum.higherThanOrLowerThan, higherThanOrLowerThan);
    }

    public void setHigherThanOrLowerThan(HigherThanOrLowerThanValue higherThanOrLowerThan) {
        notifyChanged(SwiftFeatureDescriptorEnum.higherThanOrLowerThan, this.higherThanOrLowerThan, this.higherThanOrLowerThan = higherThanOrLowerThan);
    }
    private PrecedenceGroupNameList otherNames;

    public PrecedenceGroupNameList getOtherNames() {
        return notifyRequested(SwiftFeatureDescriptorEnum.otherNames, otherNames);
    }

    public void setOtherNames(PrecedenceGroupNameList otherNames) {
        notifyChanged(SwiftFeatureDescriptorEnum.otherNames, this.otherNames, this.otherNames = otherNames);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getHigherThanOrLowerThan().wGetAdaptee(false);
            case 1 :
            return getOtherNames().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setHigherThanOrLowerThan(value.wGetAdapter(SwiftEntityDescriptorEnum.HigherThanOrLowerThanValue));
            break;
            case 1 :
            setOtherNames(value.wGetAdapter(SwiftEntityDescriptorEnum.PrecedenceGroupNameList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
