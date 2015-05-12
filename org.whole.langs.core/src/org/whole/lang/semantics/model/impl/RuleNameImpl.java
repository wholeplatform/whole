/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.semantics.model.RuleName;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class RuleNameImpl extends AbstractSimpleEntity implements RuleName {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<RuleName> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.RuleName;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.RuleName_ord;
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(SemanticsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Name sub;

    public Name getSub() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.sub, sub);
    }

    public void setSub(Name sub) {
        notifyChanged(SemanticsFeatureDescriptorEnum.sub, this.sub, this.sub = sub);
    }
    private Name sup;

    public Name getSup() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.sup, sup);
    }

    public void setSup(Name sup) {
        notifyChanged(SemanticsFeatureDescriptorEnum.sup, this.sup, this.sup = sup);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getSub().wGetAdaptee(false);
            case 2 :
            return getSup().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(SemanticsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setSub(value.wGetAdapter(SemanticsEntityDescriptorEnum.Name));
            break;
            case 2 :
            setSup(value.wGetAdapter(SemanticsEntityDescriptorEnum.Name));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
