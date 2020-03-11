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
package org.whole.lang.swiftsyntax.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swiftsyntax.model.ImportDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ModifierList;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.AccessPath;

/**
 *  @generator Whole
 */
public class ImportDeclImpl extends AbstractSimpleEntity implements ImportDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ImportDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ImportDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.ImportDecl_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private AttributeList attributes;

    public AttributeList getAttributes() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.attributes, attributes);
    }

    public void setAttributes(AttributeList attributes) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.attributes, this.attributes, this.attributes = attributes);
    }
    private ModifierList modifiers;

    public ModifierList getModifiers() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.modifiers, modifiers);
    }

    public void setModifiers(ModifierList modifiers) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.modifiers, this.modifiers, this.modifiers = modifiers);
    }
    private Token importTok;

    public Token getImportTok() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.importTok, importTok);
    }

    public void setImportTok(Token importTok) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.importTok, this.importTok, this.importTok = importTok);
    }
    private Token importKind;

    public Token getImportKind() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.importKind, importKind);
    }

    public void setImportKind(Token importKind) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.importKind, this.importKind, this.importKind = importKind);
    }
    private AccessPath path;

    public AccessPath getPath() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.path, path);
    }

    public void setPath(AccessPath path) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.path, this.path, this.path = path);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getImportTok().wGetAdaptee(false);
            case 3 :
            return getImportKind().wGetAdaptee(false);
            case 4 :
            return getPath().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setAttributes(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AttributeList));
            break;
            case 1 :
            setModifiers(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ModifierList));
            break;
            case 2 :
            setImportTok(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setImportKind(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setPath(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AccessPath));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
