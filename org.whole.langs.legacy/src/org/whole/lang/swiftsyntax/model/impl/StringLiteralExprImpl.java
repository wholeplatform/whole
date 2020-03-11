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
import org.whole.lang.swiftsyntax.model.StringLiteralExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.StringLiteralSegments;

/**
 *  @generator Whole
 */
public class StringLiteralExprImpl extends AbstractSimpleEntity implements StringLiteralExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<StringLiteralExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token openDelimiter;

    public Token getOpenDelimiter() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.openDelimiter, openDelimiter);
    }

    public void setOpenDelimiter(Token openDelimiter) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.openDelimiter, this.openDelimiter, this.openDelimiter = openDelimiter);
    }
    private Token openQuote;

    public Token getOpenQuote() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.openQuote, openQuote);
    }

    public void setOpenQuote(Token openQuote) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.openQuote, this.openQuote, this.openQuote = openQuote);
    }
    private StringLiteralSegments segments;

    public StringLiteralSegments getSegments() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.segments, segments);
    }

    public void setSegments(StringLiteralSegments segments) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.segments, this.segments, this.segments = segments);
    }
    private Token closeQuote;

    public Token getCloseQuote() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.closeQuote, closeQuote);
    }

    public void setCloseQuote(Token closeQuote) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.closeQuote, this.closeQuote, this.closeQuote = closeQuote);
    }
    private Token closeDelimiter;

    public Token getCloseDelimiter() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.closeDelimiter, closeDelimiter);
    }

    public void setCloseDelimiter(Token closeDelimiter) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.closeDelimiter, this.closeDelimiter, this.closeDelimiter = closeDelimiter);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getOpenDelimiter().wGetAdaptee(false);
            case 1 :
            return getOpenQuote().wGetAdaptee(false);
            case 2 :
            return getSegments().wGetAdaptee(false);
            case 3 :
            return getCloseQuote().wGetAdaptee(false);
            case 4 :
            return getCloseDelimiter().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setOpenDelimiter(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setOpenQuote(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setSegments(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments));
            break;
            case 3 :
            setCloseQuote(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setCloseDelimiter(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
