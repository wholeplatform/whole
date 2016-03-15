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
package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SlotAdapter extends AbstractEntityAdapter implements Slot {
    private static final long serialVersionUID = 1;

    public SlotAdapter(IEntity implementor) {
        super(implementor);
    }

    public SlotAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Slot> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.Slot;
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public BooleanValue getOptional() {
        return wGet(PatternsFeatureDescriptorEnum.optional).wGetAdapter(PatternsEntityDescriptorEnum.BooleanValue);
    }

    public void setOptional(BooleanValue optional) {
        wSet(PatternsFeatureDescriptorEnum.optional, optional);
    }

    public PathExpression getAdapter() {
        return wGet(PatternsFeatureDescriptorEnum.adapter).wGetAdapter(PatternsEntityDescriptorEnum.PathExpression);
    }

    public void setAdapter(PathExpression adapter) {
        wSet(PatternsFeatureDescriptorEnum.adapter, adapter);
    }

    public Type getType() {
        return wGet(PatternsFeatureDescriptorEnum.type).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setType(Type type) {
        wSet(PatternsFeatureDescriptorEnum.type, type);
    }

    public Type getResultType() {
        return wGet(PatternsFeatureDescriptorEnum.resultType).wGetAdapter(PatternsEntityDescriptorEnum.Type);
    }

    public void setResultType(Type resultType) {
        wSet(PatternsFeatureDescriptorEnum.resultType, resultType);
    }
}
