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
import org.whole.lang.artifacts.model.PackageArtifact;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.artifacts.model.PackageName;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.model.Metadata;
import org.whole.lang.artifacts.model.Artifacts;

/**
 *  @generator Whole
 */
public class PackageArtifactImpl extends AbstractSimpleEntity implements PackageArtifact {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PackageArtifact> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.PackageArtifact;
    }

    public int wGetEntityOrd() {
        return ArtifactsEntityDescriptorEnum.PackageArtifact_ord;
    }

    public void accept(IArtifactsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PackageName name;

    public PackageName getName() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.name, name);
    }

    public void setName(PackageName name) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Metadata metadata;

    public Metadata getMetadata() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.metadata, metadata);
    }

    public void setMetadata(Metadata metadata) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.metadata, this.metadata, this.metadata = metadata);
    }
    private Artifacts artifacts;

    public Artifacts getArtifacts() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.artifacts, artifacts);
    }

    public void setArtifacts(Artifacts artifacts) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.artifacts, this.artifacts, this.artifacts = artifacts);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getMetadata().wGetAdaptee(false);
            case 2 :
            return getArtifacts().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(ArtifactsEntityDescriptorEnum.PackageName));
            break;
            case 1 :
            setMetadata(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata));
            break;
            case 2 :
            setArtifacts(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Artifacts));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
