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
import org.whole.lang.swiftsyntax.model.EnumCaseDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ModifierList;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.EnumCaseElementList;

/**
 *  @generator Whole
 */
public class EnumCaseDeclImpl extends AbstractSimpleEntity implements EnumCaseDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EnumCaseDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.EnumCaseDecl_ord;
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
    private Token caseKeyword;

    public Token getCaseKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.caseKeyword, caseKeyword);
    }

    public void setCaseKeyword(Token caseKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.caseKeyword, this.caseKeyword, this.caseKeyword = caseKeyword);
    }
    private EnumCaseElementList elements;

    public EnumCaseElementList getElements() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.elements, elements);
    }

    public void setElements(EnumCaseElementList elements) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.elements, this.elements, this.elements = elements);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getCaseKeyword().wGetAdaptee(false);
            case 3 :
            return getElements().wGetAdaptee(false);
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
            setCaseKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setElements(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.EnumCaseElementList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
