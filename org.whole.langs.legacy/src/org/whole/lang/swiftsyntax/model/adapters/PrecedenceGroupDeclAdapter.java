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
public class PrecedenceGroupDeclAdapter extends AbstractEntityAdapter implements PrecedenceGroupDecl {
    private static final long serialVersionUID = 1;

    public PrecedenceGroupDeclAdapter(IEntity implementor) {
        super(implementor);
    }

    public PrecedenceGroupDeclAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PrecedenceGroupDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl;
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

    public Token getPrecedencegroupKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setPrecedencegroupKeyword(Token precedencegroupKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword, precedencegroupKeyword);
    }

    public Token getIdentifier() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.identifier).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setIdentifier(Token identifier) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.identifier, identifier);
    }

    public Token getLeftBrace() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.leftBrace).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLeftBrace(Token leftBrace) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.leftBrace, leftBrace);
    }

    public PrecedenceGroupAttributeList getGroupAttributes() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.groupAttributes).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList);
    }

    public void setGroupAttributes(PrecedenceGroupAttributeList groupAttributes) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.groupAttributes, groupAttributes);
    }

    public Token getRightBrace() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.rightBrace).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setRightBrace(Token rightBrace) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.rightBrace, rightBrace);
    }
}
