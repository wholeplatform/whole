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
package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class RuleNameAdapter extends AbstractEntityAdapter implements RuleName {
    private static final long serialVersionUID = 1;

    public RuleNameAdapter(IEntity implementor) {
        super(implementor);
    }

    public RuleNameAdapter() {
    }

    public void accept(ISemanticsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<RuleName> wGetEntityDescriptor() {
        return SemanticsEntityDescriptorEnum.RuleName;
    }

    public Name getName() {
        return wGet(SemanticsFeatureDescriptorEnum.name).wGetAdapter(SemanticsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(SemanticsFeatureDescriptorEnum.name, name);
    }

    public Name getSub() {
        return wGet(SemanticsFeatureDescriptorEnum.sub).wGetAdapter(SemanticsEntityDescriptorEnum.Name);
    }

    public void setSub(Name sub) {
        wSet(SemanticsFeatureDescriptorEnum.sub, sub);
    }

    public Name getSup() {
        return wGet(SemanticsFeatureDescriptorEnum.sup).wGetAdapter(SemanticsEntityDescriptorEnum.Name);
    }

    public void setSup(Name sup) {
        wSet(SemanticsFeatureDescriptorEnum.sup, sup);
    }
}
