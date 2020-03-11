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
import org.whole.lang.swiftsyntax.model.EnumDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ModifierList;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.GenericParameterClause;
import org.whole.lang.swiftsyntax.model.TypeInheritanceClause;
import org.whole.lang.swiftsyntax.model.GenericWhereClause;
import org.whole.lang.swiftsyntax.model.MemberDeclBlock;

/**
 *  @generator Whole
 */
public class EnumDeclImpl extends AbstractSimpleEntity implements EnumDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EnumDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.EnumDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.EnumDecl_ord;
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
    private Token enumKeyword;

    public Token getEnumKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.enumKeyword, enumKeyword);
    }

    public void setEnumKeyword(Token enumKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.enumKeyword, this.enumKeyword, this.enumKeyword = enumKeyword);
    }
    private Token identifier;

    public Token getIdentifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(Token identifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.identifier, this.identifier, this.identifier = identifier);
    }
    private GenericParameterClause genericParameters;

    public GenericParameterClause getGenericParameters() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericParameters, genericParameters);
    }

    public void setGenericParameters(GenericParameterClause genericParameters) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericParameters, this.genericParameters, this.genericParameters = genericParameters);
    }
    private TypeInheritanceClause inheritanceClause;

    public TypeInheritanceClause getInheritanceClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.inheritanceClause, inheritanceClause);
    }

    public void setInheritanceClause(TypeInheritanceClause inheritanceClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.inheritanceClause, this.inheritanceClause, this.inheritanceClause = inheritanceClause);
    }
    private GenericWhereClause genericWhereClause;

    public GenericWhereClause getGenericWhereClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericWhereClause genericWhereClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
    }
    private MemberDeclBlock members;

    public MemberDeclBlock getMembers() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.members, members);
    }

    public void setMembers(MemberDeclBlock members) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.members, this.members, this.members = members);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getEnumKeyword().wGetAdaptee(false);
            case 3 :
            return getIdentifier().wGetAdaptee(false);
            case 4 :
            return getGenericParameters().wGetAdaptee(false);
            case 5 :
            return getInheritanceClause().wGetAdaptee(false);
            case 6 :
            return getGenericWhereClause().wGetAdaptee(false);
            case 7 :
            return getMembers().wGetAdaptee(false);
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
            setEnumKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setIdentifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setGenericParameters(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause));
            break;
            case 5 :
            setInheritanceClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause));
            break;
            case 6 :
            setGenericWhereClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause));
            break;
            case 7 :
            setMembers(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.MemberDeclBlock));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
