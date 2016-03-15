/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.TypedVariable;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.Variable;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.model.Num;
import org.whole.lang.semantics.model.Signature;

/**
 *  @generator Whole
 */
public class TypedVariableImpl extends AbstractSimpleEntity implements TypedVariable {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TypedVariable> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.TypedVariable;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.TypedVariable_ord;
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Variable variable;

    public Variable getVariable() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.variable, variable);
    }

    public void setVariable(Variable variable) {
        notifyChanged(SemanticsFeatureDescriptorEnum.variable, this.variable, this.variable = variable);
    }
    private Num index;

    public Num getIndex() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.index, index);
    }

    public void setIndex(Num index) {
        notifyChanged(SemanticsFeatureDescriptorEnum.index, this.index, this.index = index);
    }
    private Num time;

    public Num getTime() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.time, time);
    }

    public void setTime(Num time) {
        notifyChanged(SemanticsFeatureDescriptorEnum.time, this.time, this.time = time);
    }
    private Signature signature;

    public Signature getSignature() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.signature, signature);
    }

    public void setSignature(Signature signature) {
        notifyChanged(SemanticsFeatureDescriptorEnum.signature, this.signature, this.signature = signature);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getVariable().wGetAdaptee(false);
            case 1 :
            return getIndex().wGetAdaptee(false);
            case 2 :
            return getTime().wGetAdaptee(false);
            case 3 :
            return getSignature().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setVariable(value.wGetAdapter(SemanticsEntityDescriptorEnum.Variable));
            break;
            case 1 :
            setIndex(value.wGetAdapter(SemanticsEntityDescriptorEnum.Num));
            break;
            case 2 :
            setTime(value.wGetAdapter(SemanticsEntityDescriptorEnum.Num));
            break;
            case 3 :
            setSignature(value.wGetAdapter(SemanticsEntityDescriptorEnum.Signature));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
