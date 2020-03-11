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
import org.whole.lang.swift.model.StringLiteralExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.RawStringDelimiter;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.OpenQuoteEnum;
import org.whole.lang.swift.model.StringLiteralSegments;

/**
 *  @generator Whole
 */
public class StringLiteralExprImpl extends AbstractSimpleEntity implements StringLiteralExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<StringLiteralExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.StringLiteralExpr;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.StringLiteralExpr_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private RawStringDelimiter openDelimiter;

    public RawStringDelimiter getOpenDelimiter() {
        return notifyRequested(SwiftFeatureDescriptorEnum.openDelimiter, openDelimiter);
    }

    public void setOpenDelimiter(RawStringDelimiter openDelimiter) {
        notifyChanged(SwiftFeatureDescriptorEnum.openDelimiter, this.openDelimiter, this.openDelimiter = openDelimiter);
    }
    private OpenQuoteEnum openQuote;

    public OpenQuoteEnum getOpenQuote() {
        return notifyRequested(SwiftFeatureDescriptorEnum.openQuote, openQuote);
    }

    public void setOpenQuote(OpenQuoteEnum openQuote) {
        notifyChanged(SwiftFeatureDescriptorEnum.openQuote, this.openQuote, this.openQuote = openQuote);
    }
    private StringLiteralSegments segments;

    public StringLiteralSegments getSegments() {
        return notifyRequested(SwiftFeatureDescriptorEnum.segments, segments);
    }

    public void setSegments(StringLiteralSegments segments) {
        notifyChanged(SwiftFeatureDescriptorEnum.segments, this.segments, this.segments = segments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getOpenDelimiter().wGetAdaptee(false);
            case 1 :
            return getOpenQuote().wGetAdaptee(false);
            case 2 :
            return getSegments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setOpenDelimiter(value.wGetAdapter(SwiftEntityDescriptorEnum.RawStringDelimiter));
            break;
            case 1 :
            setOpenQuote(value.wGetAdapter(SwiftEntityDescriptorEnum.OpenQuoteEnum));
            break;
            case 2 :
            setSegments(value.wGetAdapter(SwiftEntityDescriptorEnum.StringLiteralSegments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
