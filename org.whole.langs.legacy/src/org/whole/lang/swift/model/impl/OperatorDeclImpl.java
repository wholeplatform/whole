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
import org.whole.lang.swift.model.OperatorDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ModifierList;
import org.whole.lang.swift.model.AbstractOperatorIdentifier;
import org.whole.lang.swift.model.IdentifierList;

/**
 *  @generator Whole
 */
public class OperatorDeclImpl extends AbstractSimpleEntity implements OperatorDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<OperatorDecl> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.OperatorDecl;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.OperatorDecl_ord;
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
    private AbstractOperatorIdentifier operatorIdentifier;

    public AbstractOperatorIdentifier getOperatorIdentifier() {
        return notifyRequested(SwiftFeatureDescriptorEnum.operatorIdentifier, operatorIdentifier);
    }

    public void setOperatorIdentifier(AbstractOperatorIdentifier operatorIdentifier) {
        notifyChanged(SwiftFeatureDescriptorEnum.operatorIdentifier, this.operatorIdentifier, this.operatorIdentifier = operatorIdentifier);
    }
    private IdentifierList operatorPrecedenceAndTypes;

    public IdentifierList getOperatorPrecedenceAndTypes() {
        return notifyRequested(SwiftFeatureDescriptorEnum.operatorPrecedenceAndTypes, operatorPrecedenceAndTypes);
    }

    public void setOperatorPrecedenceAndTypes(IdentifierList operatorPrecedenceAndTypes) {
        notifyChanged(SwiftFeatureDescriptorEnum.operatorPrecedenceAndTypes, this.operatorPrecedenceAndTypes, this.operatorPrecedenceAndTypes = operatorPrecedenceAndTypes);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getOperatorIdentifier().wGetAdaptee(false);
            case 3 :
            return getOperatorPrecedenceAndTypes().wGetAdaptee(false);
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
            setOperatorIdentifier(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractOperatorIdentifier));
            break;
            case 3 :
            setOperatorPrecedenceAndTypes(value.wGetAdapter(SwiftEntityDescriptorEnum.IdentifierList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
