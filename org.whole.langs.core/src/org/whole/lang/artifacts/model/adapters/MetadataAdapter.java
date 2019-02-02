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
public class MetadataAdapter extends AbstractEntityAdapter implements Metadata {
    private static final long serialVersionUID = 1;

    public MetadataAdapter(IEntity implementor) {
        super(implementor);
    }

    public MetadataAdapter() {
    }

    public void accept(IArtifactsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Metadata> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.Metadata;
    }

    public Copyright getCopyright() {
        return wGet(ArtifactsFeatureDescriptorEnum.copyright).wGetAdapter(ArtifactsEntityDescriptorEnum.Copyright);
    }

    public void setCopyright(Copyright copyright) {
        wSet(ArtifactsFeatureDescriptorEnum.copyright, copyright);
    }

    public License getLicense() {
        return wGet(ArtifactsFeatureDescriptorEnum.license).wGetAdapter(ArtifactsEntityDescriptorEnum.License);
    }

    public void setLicense(License license) {
        wSet(ArtifactsFeatureDescriptorEnum.license, license);
    }

    public Author getAuthor() {
        return wGet(ArtifactsFeatureDescriptorEnum.author).wGetAdapter(ArtifactsEntityDescriptorEnum.Author);
    }

    public void setAuthor(Author author) {
        wSet(ArtifactsFeatureDescriptorEnum.author, author);
    }

    public Attributes getAttributes() {
        return wGet(ArtifactsFeatureDescriptorEnum.attributes).wGetAdapter(ArtifactsEntityDescriptorEnum.Attributes);
    }

    public void setAttributes(Attributes attributes) {
        wSet(ArtifactsFeatureDescriptorEnum.attributes, attributes);
    }

    public PersistenceKitId getPersistenceKitId() {
        return wGet(ArtifactsFeatureDescriptorEnum.persistenceKitId).wGetAdapter(ArtifactsEntityDescriptorEnum.PersistenceKitId);
    }

    public void setPersistenceKitId(PersistenceKitId persistenceKitId) {
        wSet(ArtifactsFeatureDescriptorEnum.persistenceKitId, persistenceKitId);
    }
}
