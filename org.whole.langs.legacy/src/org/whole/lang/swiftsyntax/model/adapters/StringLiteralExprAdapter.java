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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class StringLiteralExprAdapter extends AbstractEntityAdapter implements StringLiteralExpr {
    private static final long serialVersionUID = 1;

    public StringLiteralExprAdapter(IEntity implementor) {
        super(implementor);
    }

    public StringLiteralExprAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<StringLiteralExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.StringLiteralExpr;
    }

    public Token getOpenDelimiter() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.openDelimiter).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setOpenDelimiter(Token openDelimiter) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.openDelimiter, openDelimiter);
    }

    public Token getOpenQuote() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.openQuote).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setOpenQuote(Token openQuote) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.openQuote, openQuote);
    }

    public StringLiteralSegments getSegments() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.segments).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.StringLiteralSegments);
    }

    public void setSegments(StringLiteralSegments segments) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.segments, segments);
    }

    public Token getCloseQuote() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.closeQuote).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setCloseQuote(Token closeQuote) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.closeQuote, closeQuote);
    }

    public Token getCloseDelimiter() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.closeDelimiter).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setCloseDelimiter(Token closeDelimiter) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.closeDelimiter, closeDelimiter);
    }
}
