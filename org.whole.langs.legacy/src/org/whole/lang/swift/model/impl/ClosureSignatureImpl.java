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
import org.whole.lang.swift.model.ClosureSignature;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.ClosureCaptureItemList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.AbstractInput;
import org.whole.lang.swift.model.Throws;
import org.whole.lang.swift.model.Type;

/**
 *  @generator Whole
 */
public class ClosureSignatureImpl extends AbstractSimpleEntity implements ClosureSignature {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ClosureSignature> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ClosureSignature;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ClosureSignature_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ClosureCaptureItemList capture;

    public ClosureCaptureItemList getCapture() {
        return notifyRequested(SwiftFeatureDescriptorEnum.capture, capture);
    }

    public void setCapture(ClosureCaptureItemList capture) {
        notifyChanged(SwiftFeatureDescriptorEnum.capture, this.capture, this.capture = capture);
    }
    private AbstractInput input;

    public AbstractInput getInput() {
        return notifyRequested(SwiftFeatureDescriptorEnum.input, input);
    }

    public void setInput(AbstractInput input) {
        notifyChanged(SwiftFeatureDescriptorEnum.input, this.input, this.input = input);
    }
    private Throws throwsTok;

    public Throws getThrowsTok() {
        return notifyRequested(SwiftFeatureDescriptorEnum.throwsTok, throwsTok);
    }

    public void setThrowsTok(Throws throwsTok) {
        notifyChanged(SwiftFeatureDescriptorEnum.throwsTok, this.throwsTok, this.throwsTok = throwsTok);
    }
    private Type output;

    public Type getOutput() {
        return notifyRequested(SwiftFeatureDescriptorEnum.output, output);
    }

    public void setOutput(Type output) {
        notifyChanged(SwiftFeatureDescriptorEnum.output, this.output, this.output = output);
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
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCapture(value.wGetAdapter(SwiftEntityDescriptorEnum.ClosureCaptureItemList));
            break;
            case 1 :
            setInput(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractInput));
            break;
            case 2 :
            setThrowsTok(value.wGetAdapter(SwiftEntityDescriptorEnum.Throws));
            break;
            case 3 :
            setOutput(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
