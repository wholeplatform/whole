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
import org.whole.lang.swiftsyntax.model.PrecedenceGroupDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ModifierList;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.PrecedenceGroupAttributeList;

/**
 *  @generator Whole
 */
public class PrecedenceGroupDeclImpl extends AbstractSimpleEntity implements PrecedenceGroupDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PrecedenceGroupDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupDecl_ord;
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
    private Token precedencegroupKeyword;

    public Token getPrecedencegroupKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword, precedencegroupKeyword);
    }

    public void setPrecedencegroupKeyword(Token precedencegroupKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.precedencegroupKeyword, this.precedencegroupKeyword, this.precedencegroupKeyword = precedencegroupKeyword);
    }
    private Token identifier;

    public Token getIdentifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(Token identifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.identifier, this.identifier, this.identifier = identifier);
    }
    private Token leftBrace;

    public Token getLeftBrace() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftBrace, leftBrace);
    }

    public void setLeftBrace(Token leftBrace) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftBrace, this.leftBrace, this.leftBrace = leftBrace);
    }
    private PrecedenceGroupAttributeList groupAttributes;

    public PrecedenceGroupAttributeList getGroupAttributes() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.groupAttributes, groupAttributes);
    }

    public void setGroupAttributes(PrecedenceGroupAttributeList groupAttributes) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.groupAttributes, this.groupAttributes, this.groupAttributes = groupAttributes);
    }
    private Token rightBrace;

    public Token getRightBrace() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightBrace, rightBrace);
    }

    public void setRightBrace(Token rightBrace) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightBrace, this.rightBrace, this.rightBrace = rightBrace);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getPrecedencegroupKeyword().wGetAdaptee(false);
            case 3 :
            return getIdentifier().wGetAdaptee(false);
            case 4 :
            return getLeftBrace().wGetAdaptee(false);
            case 5 :
            return getGroupAttributes().wGetAdaptee(false);
            case 6 :
            return getRightBrace().wGetAdaptee(false);
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
            setPrecedencegroupKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setIdentifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setLeftBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 5 :
            setGroupAttributes(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.PrecedenceGroupAttributeList));
            break;
            case 6 :
            setRightBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
