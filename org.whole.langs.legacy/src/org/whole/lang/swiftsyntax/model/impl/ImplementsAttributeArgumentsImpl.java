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
import org.whole.lang.swiftsyntax.model.ImplementsAttributeArguments;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.SimpleTypeIdentifier;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.Syntax;
import org.whole.lang.swiftsyntax.model.DeclNameArguments;

/**
 *  @generator Whole
 */
public class ImplementsAttributeArgumentsImpl extends AbstractSimpleEntity implements ImplementsAttributeArguments {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ImplementsAttributeArguments> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.ImplementsAttributeArguments_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private SimpleTypeIdentifier type;

    public SimpleTypeIdentifier getType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public void setType(SimpleTypeIdentifier type) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Token comma;

    public Token getComma() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.comma, comma);
    }

    public void setComma(Token comma) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.comma, this.comma, this.comma = comma);
    }
    private Syntax declBaseName;

    public Syntax getDeclBaseName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.declBaseName, declBaseName);
    }

    public void setDeclBaseName(Syntax declBaseName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.declBaseName, this.declBaseName, this.declBaseName = declBaseName);
    }
    private DeclNameArguments declNameArguments;

    public DeclNameArguments getDeclNameArguments() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.declNameArguments, declNameArguments);
    }

    public void setDeclNameArguments(DeclNameArguments declNameArguments) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.declNameArguments, this.declNameArguments, this.declNameArguments = declNameArguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getType().wGetAdaptee(false);
            case 1 :
            return getComma().wGetAdaptee(false);
            case 2 :
            return getDeclBaseName().wGetAdaptee(false);
            case 3 :
            return getDeclNameArguments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.SimpleTypeIdentifier));
            break;
            case 1 :
            setComma(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setDeclBaseName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            case 3 :
            setDeclNameArguments(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
