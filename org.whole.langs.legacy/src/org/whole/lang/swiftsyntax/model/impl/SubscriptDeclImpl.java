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
import org.whole.lang.swiftsyntax.model.SubscriptDecl;
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
import org.whole.lang.swiftsyntax.model.ParameterClause;
import org.whole.lang.swiftsyntax.model.ReturnClause;
import org.whole.lang.swiftsyntax.model.GenericWhereClause;
import org.whole.lang.swiftsyntax.model.Syntax;

/**
 *  @generator Whole
 */
public class SubscriptDeclImpl extends AbstractSimpleEntity implements SubscriptDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SubscriptDecl> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.SubscriptDecl;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.SubscriptDecl_ord;
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
    private Token subscriptKeyword;

    public Token getSubscriptKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.subscriptKeyword, subscriptKeyword);
    }

    public void setSubscriptKeyword(Token subscriptKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.subscriptKeyword, this.subscriptKeyword, this.subscriptKeyword = subscriptKeyword);
    }
    private GenericParameterClause genericParameterClause;

    public GenericParameterClause getGenericParameterClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause, genericParameterClause);
    }

    public void setGenericParameterClause(GenericParameterClause genericParameterClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericParameterClause, this.genericParameterClause, this.genericParameterClause = genericParameterClause);
    }
    private ParameterClause indices;

    public ParameterClause getIndices() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.indices, indices);
    }

    public void setIndices(ParameterClause indices) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.indices, this.indices, this.indices = indices);
    }
    private ReturnClause result;

    public ReturnClause getResult() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.result, result);
    }

    public void setResult(ReturnClause result) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.result, this.result, this.result = result);
    }
    private GenericWhereClause genericWhereClause;

    public GenericWhereClause getGenericWhereClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, genericWhereClause);
    }

    public void setGenericWhereClause(GenericWhereClause genericWhereClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericWhereClause, this.genericWhereClause, this.genericWhereClause = genericWhereClause);
    }
    private Syntax accessor;

    public Syntax getAccessor() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.accessor, accessor);
    }

    public void setAccessor(Syntax accessor) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.accessor, this.accessor, this.accessor = accessor);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getSubscriptKeyword().wGetAdaptee(false);
            case 3 :
            return getGenericParameterClause().wGetAdaptee(false);
            case 4 :
            return getIndices().wGetAdaptee(false);
            case 5 :
            return getResult().wGetAdaptee(false);
            case 6 :
            return getGenericWhereClause().wGetAdaptee(false);
            case 7 :
            return getAccessor().wGetAdaptee(false);
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
            setSubscriptKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setGenericParameterClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericParameterClause));
            break;
            case 4 :
            setIndices(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ParameterClause));
            break;
            case 5 :
            setResult(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ReturnClause));
            break;
            case 6 :
            setGenericWhereClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericWhereClause));
            break;
            case 7 :
            setAccessor(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
