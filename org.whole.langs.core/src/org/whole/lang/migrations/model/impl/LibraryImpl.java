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
import org.whole.lang.migrations.model.Library;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.migrations.model.URI;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.model.Namespace;
import org.whole.lang.migrations.model.Name;
import org.whole.lang.migrations.model.MigrationFunctions;

/**
 *  @generator Whole
 */
public class LibraryImpl extends AbstractSimpleEntity implements Library {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Library> wGetEntityDescriptor() {
        return MigrationsEntityDescriptorEnum.Library;
    }

    public int wGetEntityOrd() {
        return MigrationsEntityDescriptorEnum.Library_ord;
    }

    public void accept(IMigrationsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private URI uri;

    public URI getUri() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.uri, uri);
    }

    public void setUri(URI uri) {
        notifyChanged(MigrationsFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
    }
    private Namespace namespace;

    public Namespace getNamespace() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.namespace, namespace);
    }

    public void setNamespace(Namespace namespace) {
        notifyChanged(MigrationsFeatureDescriptorEnum.namespace, this.namespace, this.namespace = namespace);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(MigrationsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private MigrationFunctions functions;

    public MigrationFunctions getFunctions() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.functions, functions);
    }

    public void setFunctions(MigrationFunctions functions) {
        notifyChanged(MigrationsFeatureDescriptorEnum.functions, this.functions, this.functions = functions);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getUri().wGetAdaptee(false);
            case 1 :
            return getNamespace().wGetAdaptee(false);
            case 2 :
            return getName().wGetAdaptee(false);
            case 3 :
            return getFunctions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setUri(value.wGetAdapter(MigrationsEntityDescriptorEnum.URI));
            break;
            case 1 :
            setNamespace(value.wGetAdapter(MigrationsEntityDescriptorEnum.Namespace));
            break;
            case 2 :
            setName(value.wGetAdapter(MigrationsEntityDescriptorEnum.Name));
            break;
            case 3 :
            setFunctions(value.wGetAdapter(MigrationsEntityDescriptorEnum.MigrationFunctions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
