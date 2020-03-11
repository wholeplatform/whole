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
import org.whole.lang.swiftsyntax.model.PrecedenceGroupRelation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.PrecedenceGroupNameList;

/**
 *  @generator Whole
 */
public class PrecedenceGroupRelationImpl extends AbstractSimpleEntity implements PrecedenceGroupRelation {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PrecedenceGroupRelation> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupRelation_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token higherThanOrLowerThan;

    public Token getHigherThanOrLowerThan() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.higherThanOrLowerThan, higherThanOrLowerThan);
    }

    public void setHigherThanOrLowerThan(Token higherThanOrLowerThan) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.higherThanOrLowerThan, this.higherThanOrLowerThan, this.higherThanOrLowerThan = higherThanOrLowerThan);
    }
    private Token colon;

    public Token getColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public void setColon(Token colon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.colon, this.colon, this.colon = colon);
    }
    private PrecedenceGroupNameList otherNames;

    public PrecedenceGroupNameList getOtherNames() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.otherNames, otherNames);
    }

    public void setOtherNames(PrecedenceGroupNameList otherNames) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.otherNames, this.otherNames, this.otherNames = otherNames);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getHigherThanOrLowerThan().wGetAdaptee(false);
            case 1 :
            return getColon().wGetAdaptee(false);
            case 2 :
            return getOtherNames().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setHigherThanOrLowerThan(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setOtherNames(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupNameList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
