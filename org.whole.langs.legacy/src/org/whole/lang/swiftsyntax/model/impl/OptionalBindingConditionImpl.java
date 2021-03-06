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
import org.whole.lang.swiftsyntax.model.OptionalBindingCondition;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Pattern;
import org.whole.lang.swiftsyntax.model.TypeAnnotation;
import org.whole.lang.swiftsyntax.model.InitializerClause;

/**
 *  @generator Whole
 */
public class OptionalBindingConditionImpl extends AbstractSimpleEntity implements OptionalBindingCondition {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<OptionalBindingCondition> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.OptionalBindingCondition_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token letOrVarKeyword;

    public Token getLetOrVarKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.letOrVarKeyword, letOrVarKeyword);
    }

    public void setLetOrVarKeyword(Token letOrVarKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.letOrVarKeyword, this.letOrVarKeyword, this.letOrVarKeyword = letOrVarKeyword);
    }
    private Pattern pattern;

    public Pattern getPattern() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.pattern, pattern);
    }

    public void setPattern(Pattern pattern) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.pattern, this.pattern, this.pattern = pattern);
    }
    private TypeAnnotation typeAnnotation;

    public TypeAnnotation getTypeAnnotation() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public void setTypeAnnotation(TypeAnnotation typeAnnotation) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, this.typeAnnotation, this.typeAnnotation = typeAnnotation);
    }
    private InitializerClause initializer;

    public InitializerClause getInitializer() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(InitializerClause initializer) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
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
            setLetOrVarKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setPattern(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Pattern));
            break;
            case 2 :
            setTypeAnnotation(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation));
            break;
            case 3 :
            setInitializer(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.InitializerClause));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
