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
import org.whole.lang.swiftsyntax.model.ClosureSignature;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.ClosureCaptureSignature;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Syntax;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.ReturnClause;

/**
 *  @generator Whole
 */
public class ClosureSignatureImpl extends AbstractSimpleEntity implements ClosureSignature {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ClosureSignature> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ClosureSignature;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.ClosureSignature_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ClosureCaptureSignature capture;

    public ClosureCaptureSignature getCapture() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.capture, capture);
    }

    public void setCapture(ClosureCaptureSignature capture) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.capture, this.capture, this.capture = capture);
    }
    private Syntax input;

    public Syntax getInput() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.input, input);
    }

    public void setInput(Syntax input) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.input, this.input, this.input = input);
    }
    private Token throwsTok;

    public Token getThrowsTok() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.throwsTok, throwsTok);
    }

    public void setThrowsTok(Token throwsTok) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.throwsTok, this.throwsTok, this.throwsTok = throwsTok);
    }
    private ReturnClause output;

    public ReturnClause getOutput() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.output, output);
    }

    public void setOutput(ReturnClause output) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.output, this.output, this.output = output);
    }
    private Token inTok;

    public Token getInTok() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.inTok, inTok);
    }

    public void setInTok(Token inTok) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.inTok, this.inTok, this.inTok = inTok);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCapture().wGetAdaptee(false);
            case 1 :
            return getInput().wGetAdaptee(false);
            case 2 :
            return getThrowsTok().wGetAdaptee(false);
            case 3 :
            return getOutput().wGetAdaptee(false);
            case 4 :
            return getInTok().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCapture(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature));
            break;
            case 1 :
            setInput(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            case 2 :
            setThrowsTok(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setOutput(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ReturnClause));
            break;
            case 4 :
            setInTok(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
