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
import org.whole.lang.swift.model.VersionTuple;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AbstractMajorMinor;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.IntegerLiteral;

/**
 *  @generator Whole
 */
public class VersionTupleImpl extends AbstractSimpleEntity implements VersionTuple {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VersionTuple> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.VersionTuple;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.VersionTuple_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private AbstractMajorMinor majorMinor;

    public AbstractMajorMinor getMajorMinor() {
        return notifyRequested(SwiftFeatureDescriptorEnum.majorMinor, majorMinor);
    }

    public void setMajorMinor(AbstractMajorMinor majorMinor) {
        notifyChanged(SwiftFeatureDescriptorEnum.majorMinor, this.majorMinor, this.majorMinor = majorMinor);
    }
    private IntegerLiteral patchVersion;

    public IntegerLiteral getPatchVersion() {
        return notifyRequested(SwiftFeatureDescriptorEnum.patchVersion, patchVersion);
    }

    public void setPatchVersion(IntegerLiteral patchVersion) {
        notifyChanged(SwiftFeatureDescriptorEnum.patchVersion, this.patchVersion, this.patchVersion = patchVersion);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getMajorMinor().wGetAdaptee(false);
            case 1 :
            return getPatchVersion().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setMajorMinor(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractMajorMinor));
            break;
            case 1 :
            setPatchVersion(value.wGetAdapter(SwiftEntityDescriptorEnum.IntegerLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
