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
package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ProjectAdapter extends AbstractEntityAdapter implements Project {
    private static final long serialVersionUID = 1;

    public ProjectAdapter(IEntity implementor) {
        super(implementor);
    }

    public ProjectAdapter() {
    }

    public void accept(IArtifactsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Project> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.Project;
    }

    public ProjectName getName() {
        return wGet(ArtifactsFeatureDescriptorEnum.name).wGetAdapter(ArtifactsEntityDescriptorEnum.ProjectName);
    }

    public void setName(ProjectName name) {
        wSet(ArtifactsFeatureDescriptorEnum.name, name);
    }

    public Natures getNatures() {
        return wGet(ArtifactsFeatureDescriptorEnum.natures).wGetAdapter(ArtifactsEntityDescriptorEnum.Natures);
    }

    public void setNatures(Natures natures) {
        wSet(ArtifactsFeatureDescriptorEnum.natures, natures);
    }

    public Metadata getMetadata() {
        return wGet(ArtifactsFeatureDescriptorEnum.metadata).wGetAdapter(ArtifactsEntityDescriptorEnum.Metadata);
    }

    public void setMetadata(Metadata metadata) {
        wSet(ArtifactsFeatureDescriptorEnum.metadata, metadata);
    }

    public Artifacts getArtifacts() {
        return wGet(ArtifactsFeatureDescriptorEnum.artifacts).wGetAdapter(ArtifactsEntityDescriptorEnum.Artifacts);
    }

    public void setArtifacts(Artifacts artifacts) {
        wSet(ArtifactsFeatureDescriptorEnum.artifacts, artifacts);
    }

    public LocationURI getLocationURI() {
        return wGet(ArtifactsFeatureDescriptorEnum.locationURI).wGetAdapter(ArtifactsEntityDescriptorEnum.LocationURI);
    }

    public void setLocationURI(LocationURI locationURI) {
        wSet(ArtifactsFeatureDescriptorEnum.locationURI, locationURI);
    }
}
