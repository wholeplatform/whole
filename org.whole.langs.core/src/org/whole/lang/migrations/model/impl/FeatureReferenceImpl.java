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
package org.whole.lang.migrations.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.migrations.model.FeatureReference;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.migrations.model.FeatureStep;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class FeatureReferenceImpl extends AbstractSimpleEntity implements FeatureReference {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FeatureReference> wGetEntityDescriptor() {
        return MigrationsEntityDescriptorEnum.FeatureReference;
    }

    public int wGetEntityOrd() {
        return MigrationsEntityDescriptorEnum.FeatureReference_ord;
    }

    public void accept(IMigrationsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private FeatureStep feature;

    public FeatureStep getFeature() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.feature, feature);
    }

    public void setFeature(FeatureStep feature) {
        notifyChanged(MigrationsFeatureDescriptorEnum.feature, this.feature, this.feature = feature);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getFeature().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setFeature(value.wGetAdapter(MigrationsEntityDescriptorEnum.FeatureStep));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
