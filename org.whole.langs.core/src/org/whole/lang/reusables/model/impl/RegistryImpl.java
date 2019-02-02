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
package org.whole.lang.reusables.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.reusables.model.Registry;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.reusables.model.URI;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class RegistryImpl extends AbstractSimpleEntity implements Registry {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Registry> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Registry;
    }

    public int wGetEntityOrd() {
        return ReusablesEntityDescriptorEnum.Registry_ord;
    }

    public void accept(IReusablesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private URI registryUri;

    public URI getRegistryUri() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.registryUri, registryUri);
    }

    public void setRegistryUri(URI registryUri) {
        notifyChanged(ReusablesFeatureDescriptorEnum.registryUri, this.registryUri, this.registryUri = registryUri);
    }
    private URI uri;

    public URI getUri() {
        return notifyRequested(ReusablesFeatureDescriptorEnum.uri, uri);
    }

    public void setUri(URI uri) {
        notifyChanged(ReusablesFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getRegistryUri().wGetAdaptee(false);
            case 1 :
            return getUri().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setRegistryUri(value.wGetAdapter(ReusablesEntityDescriptorEnum.URI));
            break;
            case 1 :
            setUri(value.wGetAdapter(ReusablesEntityDescriptorEnum.URI));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
