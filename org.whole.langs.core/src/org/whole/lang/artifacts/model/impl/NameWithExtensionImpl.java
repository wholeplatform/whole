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
package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.artifacts.model.NameWithExtension;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.artifacts.model.Name;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.model.Extension;

/**
 *  @generator Whole
 */
public class NameWithExtensionImpl extends AbstractSimpleEntity implements NameWithExtension {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<NameWithExtension> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.NameWithExtension;
    }

    public int wGetEntityOrd() {
        return ArtifactsEntityDescriptorEnum.NameWithExtension_ord;
    }

    public void accept(IArtifactsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Extension extension;

    public Extension getExtension() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.extension, extension);
    }

    public void setExtension(Extension extension) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.extension, this.extension, this.extension = extension);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getExtension().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setExtension(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Extension));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
