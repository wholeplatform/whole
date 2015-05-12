/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.semantics.model.ExecutionRule;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.model.Predicate;
import org.whole.lang.semantics.model.Expression;

/**
 *  @generator Whole
 */
public class ExecutionRuleImpl extends AbstractSimpleEntity implements ExecutionRule {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ExecutionRule> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.ExecutionRule;
    }

    public int wGetEntityOrd() {
        return SemanticsEntityDescriptorEnum.ExecutionRule_ord;
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
    private Predicate condition;

    public Predicate getCondition() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.condition, condition);
    }

    public void setCondition(Predicate condition) {
        notifyChanged(SemanticsFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
    }
    private Expression meaning;

    public Expression getMeaning() {
        return notifyRequested(SemanticsFeatureDescriptorEnum.meaning, meaning);
    }

    public void setMeaning(Expression meaning) {
        notifyChanged(SemanticsFeatureDescriptorEnum.meaning, this.meaning, this.meaning = meaning);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getCondition().wGetAdaptee(false);
            case 2 :
            return getMeaning().wGetAdaptee(false);
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
            setCondition(value.wGetAdapter(SemanticsEntityDescriptorEnum.Predicate));
            break;
            case 2 :
            setMeaning(value.wGetAdapter(SemanticsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
