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
import org.whole.lang.semantics.model.FunctionApplication;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.model.Expression;
import org.whole.lang.semantics.model.Environments;
import org.whole.lang.semantics.model.StageChange;

/**
 *  @generator Whole
 */
public class FunctionApplicationImpl extends AbstractSimpleEntity implements FunctionApplication {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FunctionApplication> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.FunctionApplication;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.FunctionApplication_ord;
    }

    public void accept(ISemanticsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(SemanticsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Expression arguments;

    public Expression getArguments() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(Expression arguments) {
        notifyChanged(SemanticsFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }
    private Environments environments;

    public Environments getEnvironments() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.environments, environments);
    }

    public void setEnvironments(Environments environments) {
        notifyChanged(SemanticsFeatureDescriptorEnum.environments, this.environments, this.environments = environments);
    }
    private StageChange stage;

    public StageChange getStage() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.stage, stage);
    }

    public void setStage(StageChange stage) {
        notifyChanged(SemanticsFeatureDescriptorEnum.stage, this.stage, this.stage = stage);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getArguments().wGetAdaptee(false);
            case 2 :
            return getEnvironments().wGetAdaptee(false);
            case 3 :
            return getStage().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(SemanticsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setArguments(value.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
            break;
            case 2 :
            setEnvironments(value.wGetAdapter(SemanticsEntityDescriptorEnum.Environments));
            break;
            case 3 :
            setStage(value.wGetAdapter(SemanticsEntityDescriptorEnum.StageChange));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
