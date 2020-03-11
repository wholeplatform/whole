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
import org.whole.lang.swift.model.VariableDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ModifierList;
import org.whole.lang.swift.model.LetOrVarKeywordEnum;
import org.whole.lang.swift.model.PatternBindingList;

/**
 *  @generator Whole
 */
public class VariableDeclImpl extends AbstractSimpleEntity implements VariableDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariableDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.VariableDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.VariableDecl_ord;
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
    private LetOrVarKeywordEnum letOrVarKeyword;

    public LetOrVarKeywordEnum getLetOrVarKeyword() {
        return notifyRequested(SwiftFeatureDescriptorEnum.letOrVarKeyword, letOrVarKeyword);
    }

    public void setLetOrVarKeyword(LetOrVarKeywordEnum letOrVarKeyword) {
        notifyChanged(SwiftFeatureDescriptorEnum.letOrVarKeyword, this.letOrVarKeyword, this.letOrVarKeyword = letOrVarKeyword);
    }
    private PatternBindingList bindings;

    public PatternBindingList getBindings() {
        return notifyRequested(SwiftFeatureDescriptorEnum.bindings, bindings);
    }

    public void setBindings(PatternBindingList bindings) {
        notifyChanged(SwiftFeatureDescriptorEnum.bindings, this.bindings, this.bindings = bindings);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getLetOrVarKeyword().wGetAdaptee(false);
            case 3 :
            return getBindings().wGetAdaptee(false);
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
            setLetOrVarKeyword(value.wGetAdapter(SwiftEntityDescriptorEnum.LetOrVarKeywordEnum));
            break;
            case 3 :
            setBindings(value.wGetAdapter(SwiftEntityDescriptorEnum.PatternBindingList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
