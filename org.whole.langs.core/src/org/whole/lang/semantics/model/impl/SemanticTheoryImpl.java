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
package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.SemanticTheory;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.URI;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.model.Namespace;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.model.Version;
import org.whole.lang.semantics.model.SemanticFunctions;

/**
 *  @generator Whole
 */
public class SemanticTheoryImpl extends AbstractSimpleEntity implements SemanticTheory {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SemanticTheory> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.SemanticTheory;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.SemanticTheory_ord;
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private URI uri;

    public URI getUri() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.uri, uri);
    }

    public void setUri(URI uri) {
        notifyChanged(SemanticsFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
    }
    private Namespace namespace;

    public Namespace getNamespace() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.namespace, namespace);
    }

    public void setNamespace(Namespace namespace) {
        notifyChanged(SemanticsFeatureDescriptorEnum.namespace, this.namespace, this.namespace = namespace);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(SemanticsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Version version;

    public Version getVersion() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.version, version);
    }

    public void setVersion(Version version) {
        notifyChanged(SemanticsFeatureDescriptorEnum.version, this.version, this.version = version);
    }
    private SemanticFunctions functions;

    public SemanticFunctions getFunctions() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.functions, functions);
    }

    public void setFunctions(SemanticFunctions functions) {
        notifyChanged(SemanticsFeatureDescriptorEnum.functions, this.functions, this.functions = functions);
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
            return getVersion().wGetAdaptee(false);
            case 4 :
            return getFunctions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setUri(value.wGetAdapter(SemanticsEntityDescriptorEnum.URI));
            break;
            case 1 :
            setNamespace(value.wGetAdapter(SemanticsEntityDescriptorEnum.Namespace));
            break;
            case 2 :
            setName(value.wGetAdapter(SemanticsEntityDescriptorEnum.Name));
            break;
            case 3 :
            setVersion(value.wGetAdapter(SemanticsEntityDescriptorEnum.Version));
            break;
            case 4 :
            setFunctions(value.wGetAdapter(SemanticsEntityDescriptorEnum.SemanticFunctions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
