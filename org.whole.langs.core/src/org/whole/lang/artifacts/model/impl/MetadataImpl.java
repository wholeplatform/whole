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
import org.whole.lang.artifacts.model.Metadata;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.artifacts.model.Copyright;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.model.License;
import org.whole.lang.artifacts.model.Author;
import org.whole.lang.artifacts.model.Attributes;
import org.whole.lang.artifacts.model.PersistenceKitId;

/**
 *  @generator Whole
 */
public class MetadataImpl extends AbstractSimpleEntity implements Metadata {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Metadata> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.Metadata;
    }

    public int wGetEntityOrd() {
        return ArtifactsEntityDescriptorEnum.Metadata_ord;
    }

    public void accept(IArtifactsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Copyright copyright;

    public Copyright getCopyright() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.copyright, copyright);
    }

    public void setCopyright(Copyright copyright) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.copyright, this.copyright, this.copyright = copyright);
    }
    private License license;

    public License getLicense() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.license, license);
    }

    public void setLicense(License license) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.license, this.license, this.license = license);
    }
    private Author author;

    public Author getAuthor() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.author, author);
    }

    public void setAuthor(Author author) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.author, this.author, this.author = author);
    }
    private Attributes attributes;

    public Attributes getAttributes() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.attributes, attributes);
    }

    public void setAttributes(Attributes attributes) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.attributes, this.attributes, this.attributes = attributes);
    }
    private PersistenceKitId persistenceKitId;

    public PersistenceKitId getPersistenceKitId() {
        return notifyRequested(ArtifactsFeatureDescriptorEnum.persistenceKitId, persistenceKitId);
    }

    public void setPersistenceKitId(PersistenceKitId persistenceKitId) {
        notifyChanged(ArtifactsFeatureDescriptorEnum.persistenceKitId, this.persistenceKitId, this.persistenceKitId = persistenceKitId);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCopyright().wGetAdaptee(false);
            case 1 :
            return getLicense().wGetAdaptee(false);
            case 2 :
            return getAuthor().wGetAdaptee(false);
            case 3 :
            return getAttributes().wGetAdaptee(false);
            case 4 :
            return getPersistenceKitId().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCopyright(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Copyright));
            break;
            case 1 :
            setLicense(value.wGetAdapter(ArtifactsEntityDescriptorEnum.License));
            break;
            case 2 :
            setAuthor(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Author));
            break;
            case 3 :
            setAttributes(value.wGetAdapter(ArtifactsEntityDescriptorEnum.Attributes));
            break;
            case 4 :
            setPersistenceKitId(value.wGetAdapter(ArtifactsEntityDescriptorEnum.PersistenceKitId));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
