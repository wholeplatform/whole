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
import org.whole.lang.swiftsyntax.model.AssociatedtypeDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.AttributeList;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ModifierList;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.TypeInheritanceClause;
import org.whole.lang.swiftsyntax.model.TypeInitializerClause;
import org.whole.lang.swiftsyntax.model.GenericWhereClause;

/**
 *  @generator Whole
 */
public class AssociatedtypeDeclImpl extends AbstractSimpleEntity implements AssociatedtypeDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AssociatedtypeDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.AssociatedtypeDecl_ord;
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
    private Token associatedtypeKeyword;

    public Token getAssociatedtypeKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.associatedtypeKeyword, associatedtypeKeyword);
    }

    public void setAssociatedtypeKeyword(Token associatedtypeKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.associatedtypeKeyword, this.associatedtypeKeyword, this.associatedtypeKeyword = associatedtypeKeyword);
    }
    private Token identifier;

    public Token getIdentifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(Token identifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.identifier, this.identifier, this.identifier = identifier);
    }
    private TypeInheritanceClause inheritanceClause;

    public TypeInheritanceClause getInheritanceClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.inheritanceClause, inheritanceClause);
    }

    public void setInheritanceClause(TypeInheritanceClause inheritanceClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.inheritanceClause, this.inheritanceClause, this.inheritanceClause = inheritanceClause);
    }
    private TypeInitializerClause initializer;

    public TypeInitializerClause getInitializer() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(TypeInitializerClause initializer) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
    }
    private GenericWhereClause genericWhereClause;

    public GenericWhereClause getGenericWhereClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericWhereClause genericWhereClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getAssociatedtypeKeyword().wGetAdaptee(false);
            case 3 :
            return getIdentifier().wGetAdaptee(false);
            case 4 :
            return getInheritanceClause().wGetAdaptee(false);
            case 5 :
            return getInitializer().wGetAdaptee(false);
            case 6 :
            return getGenericWhereClause().wGetAdaptee(false);
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
            setAssociatedtypeKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setIdentifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setInheritanceClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TypeInheritanceClause));
            break;
            case 5 :
            setInitializer(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TypeInitializerClause));
            break;
            case 6 :
            setGenericWhereClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
