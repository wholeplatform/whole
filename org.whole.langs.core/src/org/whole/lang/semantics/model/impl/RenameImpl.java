/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.Rename;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.LocalIdentifier;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class RenameImpl extends AbstractSimpleEntity implements Rename {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Rename> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.Rename;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.Rename_ord;
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private LocalIdentifier newIdentifier;

    public LocalIdentifier getNewIdentifier() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.newIdentifier, newIdentifier);
    }

    public void setNewIdentifier(LocalIdentifier newIdentifier) {
        notifyChanged(SemanticsFeatureDescriptorEnum.newIdentifier, this.newIdentifier, this.newIdentifier = newIdentifier);
    }
    private LocalIdentifier oldIdentifier;

    public LocalIdentifier getOldIdentifier() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.oldIdentifier, oldIdentifier);
    }

    public void setOldIdentifier(LocalIdentifier oldIdentifier) {
        notifyChanged(SemanticsFeatureDescriptorEnum.oldIdentifier, this.oldIdentifier, this.oldIdentifier = oldIdentifier);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getNewIdentifier().wGetAdaptee(false);
            case 1 :
            return getOldIdentifier().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setNewIdentifier(value.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
            break;
            case 1 :
            setOldIdentifier(value.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
