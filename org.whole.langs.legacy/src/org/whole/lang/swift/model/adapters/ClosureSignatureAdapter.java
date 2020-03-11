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
package org.whole.lang.swift.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ClosureSignatureAdapter extends AbstractEntityAdapter implements ClosureSignature {
    private static final long serialVersionUID = 1;

    public ClosureSignatureAdapter(IEntity implementor) {
        super(implementor);
    }

    public ClosureSignatureAdapter() {
    }

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ClosureSignature> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ClosureSignature;
    }

    public ClosureCaptureItemList getCapture() {
        return wGet(SwiftFeatureDescriptorEnum.capture).wGetAdapter(SwiftEntityDescriptorEnum.ClosureCaptureItemList);
    }

    public void setCapture(ClosureCaptureItemList capture) {
        wSet(SwiftFeatureDescriptorEnum.capture, capture);
    }

    public AbstractInput getInput() {
        return wGet(SwiftFeatureDescriptorEnum.input).wGetAdapter(SwiftEntityDescriptorEnum.AbstractInput);
    }

    public void setInput(AbstractInput input) {
        wSet(SwiftFeatureDescriptorEnum.input, input);
    }

    public Throws getThrowsTok() {
        return wGet(SwiftFeatureDescriptorEnum.throwsTok).wGetAdapter(SwiftEntityDescriptorEnum.Throws);
    }

    public void setThrowsTok(Throws throwsTok) {
        wSet(SwiftFeatureDescriptorEnum.throwsTok, throwsTok);
    }

    public Type getOutput() {
        return wGet(SwiftFeatureDescriptorEnum.output).wGetAdapter(SwiftEntityDescriptorEnum.Type);
    }

    public void setOutput(Type output) {
        wSet(SwiftFeatureDescriptorEnum.output, output);
    }
}
