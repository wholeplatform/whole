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
import org.whole.lang.swiftsyntax.model.AsTypePattern;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Pattern;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.Type;

/**
 *  @generator Whole
 */
public class AsTypePatternImpl extends AbstractSimpleEntity implements AsTypePattern {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AsTypePattern> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.AsTypePattern;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.AsTypePattern_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Pattern pattern;

    public Pattern getPattern() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.pattern, pattern);
    }

    public void setPattern(Pattern pattern) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.pattern, this.pattern, this.pattern = pattern);
    }
    private Token asKeyword;

    public Token getAsKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.asKeyword, asKeyword);
    }

    public void setAsKeyword(Token asKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.asKeyword, this.asKeyword, this.asKeyword = asKeyword);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.type, this.type, this.type = type);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPattern().wGetAdaptee(false);
            case 1 :
            return getAsKeyword().wGetAdaptee(false);
            case 2 :
            return getType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPattern(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Pattern));
            break;
            case 1 :
            setAsKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
