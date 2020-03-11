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
public class ClosureSignatureAdapter extends AbstractEntityAdapter implements ClosureSignature {
    private static final long serialVersionUID = 1;

    public ClosureSignatureAdapter(IEntity implementor) {
        super(implementor);
    }

    public ClosureSignatureAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ClosureSignature> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ClosureSignature;
    }

    public ClosureCaptureSignature getCapture() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.capture).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ClosureCaptureSignature);
    }

    public void setCapture(ClosureCaptureSignature capture) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.capture, capture);
    }

    public Syntax getInput() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.input).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax);
    }

    public void setInput(Syntax input) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.input, input);
    }

    public Token getThrowsTok() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.throwsTok).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setThrowsTok(Token throwsTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.throwsTok, throwsTok);
    }

    public ReturnClause getOutput() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.output).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ReturnClause);
    }

    public void setOutput(ReturnClause output) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.output, output);
    }

    public Token getInTok() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.inTok).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setInTok(Token inTok) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inTok, inTok);
    }
}
