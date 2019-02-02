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
package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.artifacts.model.FileName;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.model.Metadata;
import org.whole.lang.artifacts.model.Content;

/**
 *  @generator Whole
 */
public class FileArtifactImpl extends AbstractSimpleEntity implements FileArtifact {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FileArtifact> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.FileArtifact;
    }

    public int wGetEntityOrd() {
        return ArtifactsEntityDescriptorEnum.FileArtifact_ord;
    }

    public void accept(IArtifactsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private FileName name;

    public FileName getName() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.name, name);
    }

    public void setName(FileName name) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Metadata metadata;

    public Metadata getMetadata() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.metadata, metadata);
    }

    public void setMetadata(Metadata metadata) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.metadata, this.metadata, this.metadata = metadata);
    }
    private Content content;

    public Content getContent() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.content, content);
    }

    public void setContent(Content content) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.content, this.content, this.content = content);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getMetadata().wGetAdaptee(false);
            case 2 :
            return getContent().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(ArtifactsEntityDescriptorEnum.FileName));
            break;
            case 1 :
            setMetadata(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata));
            break;
            case 2 :
            setContent(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Content));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
