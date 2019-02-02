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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.Insert;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.Placement;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Expression;

/**
 *  @generator Whole
 */
public class InsertImpl extends AbstractSimpleEntity implements Insert {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Insert> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Insert;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.Insert_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Placement placement;

    public Placement getPlacement() {
        return notifyRequested(PatternsFeatureDescriptorEnum.placement, placement);
    }

    public void setPlacement(Placement placement) {
        notifyChanged(PatternsFeatureDescriptorEnum.placement, this.placement, this.placement = placement);
    }
    private Expression path;

    public Expression getPath() {
        return notifyRequested(PatternsFeatureDescriptorEnum.path, path);
    }

    public void setPath(Expression path) {
        notifyChanged(PatternsFeatureDescriptorEnum.path, this.path, this.path = path);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPlacement().wGetAdaptee(false);
            case 1 :
            return getPath().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPlacement(value.wGetAdapter(PatternsEntityDescriptorEnum.Placement));
            break;
            case 1 :
            setPath(value.wGetAdapter(PatternsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
