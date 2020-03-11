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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.ImportDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ModifierList;
import org.whole.lang.swift.model.ImportKindEnum;
import org.whole.lang.swift.model.AccessPath;

/**
 *  @generator Whole
 */
public class ImportDeclImpl extends AbstractSimpleEntity implements ImportDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ImportDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ImportDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ImportDecl_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private AttributeList attributes;

    public AttributeList getAttributes() {
        return notifyRequested(SwiftFeatureDescriptorEnum.attributes, attributes);
    }

    public void setAttributes(AttributeList attributes) {
        notifyChanged(SwiftFeatureDescriptorEnum.attributes, this.attributes, this.attributes = attributes);
    }
    private ModifierList modifiers;

    public ModifierList getModifiers() {
        return notifyRequested(SwiftFeatureDescriptorEnum.modifiers, modifiers);
    }

    public void setModifiers(ModifierList modifiers) {
        notifyChanged(SwiftFeatureDescriptorEnum.modifiers, this.modifiers, this.modifiers = modifiers);
    }
    private ImportKindEnum importKind;

    public ImportKindEnum getImportKind() {
        return notifyRequested(SwiftFeatureDescriptorEnum.importKind, importKind);
    }

    public void setImportKind(ImportKindEnum importKind) {
        notifyChanged(SwiftFeatureDescriptorEnum.importKind, this.importKind, this.importKind = importKind);
    }
    private AccessPath path;

    public AccessPath getPath() {
        return notifyRequested(SwiftFeatureDescriptorEnum.path, path);
    }

    public void setPath(AccessPath path) {
        notifyChanged(SwiftFeatureDescriptorEnum.path, this.path, this.path = path);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getImportKind().wGetAdaptee(false);
            case 3 :
            return getPath().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setAttributes(value.wGetAdapter(SwiftEntityDescriptorEnum.AttributeList));
            break;
            case 1 :
            setModifiers(value.wGetAdapter(SwiftEntityDescriptorEnum.ModifierList));
            break;
            case 2 :
            setImportKind(value.wGetAdapter(SwiftEntityDescriptorEnum.ImportKindEnum));
            break;
            case 3 :
            setPath(value.wGetAdapter(SwiftEntityDescriptorEnum.AccessPath));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
