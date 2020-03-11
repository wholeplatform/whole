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
import org.whole.lang.swiftsyntax.model.VersionTuple;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Syntax;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;

/**
 *  @generator Whole
 */
public class VersionTupleImpl extends AbstractSimpleEntity implements VersionTuple {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VersionTuple> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.VersionTuple;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.VersionTuple_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Syntax majorMinor;

    public Syntax getMajorMinor() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.majorMinor, majorMinor);
    }

    public void setMajorMinor(Syntax majorMinor) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.majorMinor, this.majorMinor, this.majorMinor = majorMinor);
    }
    private Token patchPeriod;

    public Token getPatchPeriod() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.patchPeriod, patchPeriod);
    }

    public void setPatchPeriod(Token patchPeriod) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.patchPeriod, this.patchPeriod, this.patchPeriod = patchPeriod);
    }
    private Token patchVersion;

    public Token getPatchVersion() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.patchVersion, patchVersion);
    }

    public void setPatchVersion(Token patchVersion) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.patchVersion, this.patchVersion, this.patchVersion = patchVersion);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getMajorMinor().wGetAdaptee(false);
            case 1 :
            return getPatchPeriod().wGetAdaptee(false);
            case 2 :
            return getPatchVersion().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setMajorMinor(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            case 1 :
            setPatchPeriod(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setPatchVersion(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
