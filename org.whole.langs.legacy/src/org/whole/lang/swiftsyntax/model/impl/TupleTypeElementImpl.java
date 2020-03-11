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
import org.whole.lang.swiftsyntax.model.TupleTypeElement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Type;
import org.whole.lang.swiftsyntax.model.InitializerClause;

/**
 *  @generator Whole
 */
public class TupleTypeElementImpl extends AbstractSimpleEntity implements TupleTypeElement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TupleTypeElement> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.TupleTypeElement;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.TupleTypeElement_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token inOut;

    public Token getInOut() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.inOut, inOut);
    }

    public void setInOut(Token inOut) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.inOut, this.inOut, this.inOut = inOut);
    }
    private Token name;

    public Token getName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public void setName(Token name) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Token secondName;

    public Token getSecondName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.secondName, secondName);
    }

    public void setSecondName(Token secondName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.secondName, this.secondName, this.secondName = secondName);
    }
    private Token colon;

    public Token getColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public void setColon(Token colon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.colon, this.colon, this.colon = colon);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Token ellipsis;

    public Token getEllipsis() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.ellipsis, ellipsis);
    }

    public void setEllipsis(Token ellipsis) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.ellipsis, this.ellipsis, this.ellipsis = ellipsis);
    }
    private InitializerClause initializer;

    public InitializerClause getInitializer() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(InitializerClause initializer) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
    }
    private Token trailingComma;

    public Token getTrailingComma() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.trailingComma, trailingComma);
    }

    public void setTrailingComma(Token trailingComma) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.trailingComma, this.trailingComma, this.trailingComma = trailingComma);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getInOut().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getSecondName().wGetAdaptee(false);
            case 3 :
            return getColon().wGetAdaptee(false);
            case 4 :
            return getType().wGetAdaptee(false);
            case 5 :
            return getEllipsis().wGetAdaptee(false);
            case 6 :
            return getInitializer().wGetAdaptee(false);
            case 7 :
            return getTrailingComma().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setInOut(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setSecondName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 5 :
            setEllipsis(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 6 :
            setInitializer(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.InitializerClause));
            break;
            case 7 :
            setTrailingComma(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 8;
    }
}
