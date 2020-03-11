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
import org.whole.lang.swift.model.OptionalBindingCondition;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.LetOrVarKeywordEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Pattern;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.model.Expr;

/**
 *  @generator Whole
 */
public class OptionalBindingConditionImpl extends AbstractSimpleEntity implements OptionalBindingCondition {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<OptionalBindingCondition> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.OptionalBindingCondition;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.OptionalBindingCondition_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private LetOrVarKeywordEnum letOrVarKeyword;

    public LetOrVarKeywordEnum getLetOrVarKeyword() {
        return notifyRequested(SwiftFeatureDescriptorEnum.letOrVarKeyword, letOrVarKeyword);
    }

    public void setLetOrVarKeyword(LetOrVarKeywordEnum letOrVarKeyword) {
        notifyChanged(SwiftFeatureDescriptorEnum.letOrVarKeyword, this.letOrVarKeyword, this.letOrVarKeyword = letOrVarKeyword);
    }
    private Pattern pattern;

    public Pattern getPattern() {
        return notifyRequested(SwiftFeatureDescriptorEnum.pattern, pattern);
    }

    public void setPattern(Pattern pattern) {
        notifyChanged(SwiftFeatureDescriptorEnum.pattern, this.pattern, this.pattern = pattern);
    }
    private Type typeAnnotation;

    public Type getTypeAnnotation() {
        return notifyRequested(SwiftFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public void setTypeAnnotation(Type typeAnnotation) {
        notifyChanged(SwiftFeatureDescriptorEnum.typeAnnotation, this.typeAnnotation, this.typeAnnotation = typeAnnotation);
    }
    private Expr initializer;

    public Expr getInitializer() {
        return notifyRequested(SwiftFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(Expr initializer) {
        notifyChanged(SwiftFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLetOrVarKeyword().wGetAdaptee(false);
            case 1 :
            return getPattern().wGetAdaptee(false);
            case 2 :
            return getTypeAnnotation().wGetAdaptee(false);
            case 3 :
            return getInitializer().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLetOrVarKeyword(value.wGetAdapter(SwiftEntityDescriptorEnum.LetOrVarKeywordEnum));
            break;
            case 1 :
            setPattern(value.wGetAdapter(SwiftEntityDescriptorEnum.Pattern));
            break;
            case 2 :
            setTypeAnnotation(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 3 :
            setInitializer(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
