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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ImportDeclAdapter extends AbstractEntityAdapter implements ImportDecl {
    private static final long serialVersionUID = 1;

    public ImportDeclAdapter(IEntity implementor) {
        super(implementor);
    }

    public ImportDeclAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ImportDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ImportDecl;
    }

    public AttributeList getAttributes() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.attributes).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AttributeList);
    }

    public void setAttributes(AttributeList attributes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.attributes, attributes);
    }

    public ModifierList getModifiers() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.modifiers).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ModifierList);
    }

    public void setModifiers(ModifierList modifiers) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.modifiers, modifiers);
    }

    public Token getImportTok() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.importTok).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setImportTok(Token importTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.importTok, importTok);
    }

    public Token getImportKind() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.importKind).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setImportKind(Token importKind) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.importKind, importKind);
    }

    public AccessPath getPath() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.path).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AccessPath);
    }

    public void setPath(AccessPath path) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.path, path);
    }
}
