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
import org.whole.lang.swiftsyntax.model.FunctionSignature;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.ParameterClause;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.ReturnClause;

/**
 *  @generator Whole
 */
public class FunctionSignatureImpl extends AbstractSimpleEntity implements FunctionSignature {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FunctionSignature> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.FunctionSignature;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.FunctionSignature_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ParameterClause input;

    public ParameterClause getInput() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.input, input);
    }

    public void setInput(ParameterClause input) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.input, this.input, this.input = input);
    }
    private Token throwsOrRethrowsKeyword;

    public Token getThrowsOrRethrowsKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword, throwsOrRethrowsKeyword);
    }

    public void setThrowsOrRethrowsKeyword(Token throwsOrRethrowsKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword = throwsOrRethrowsKeyword);
    }
    private ReturnClause output;

    public ReturnClause getOutput() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.output, output);
    }

    public void setOutput(ReturnClause output) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.output, this.output, this.output = output);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getInput().wGetAdaptee(false);
            case 1 :
            return getThrowsOrRethrowsKeyword().wGetAdaptee(false);
            case 2 :
            return getOutput().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setInput(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ParameterClause));
            break;
            case 1 :
            setThrowsOrRethrowsKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setOutput(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ReturnClause));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
