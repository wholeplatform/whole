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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.ScopePoint;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.Declarations;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Template;

/**
 *  @generator Whole
 */
public class ScopePointImpl extends AbstractSimpleEntity implements ScopePoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ScopePoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.ScopePoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.ScopePoint_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Declarations context;

    public Declarations getContext() {
        return notifyRequested(PatternsFeatureDescriptorEnum.context, context);
    }

    public void setContext(Declarations context) {
        notifyChanged(PatternsFeatureDescriptorEnum.context, this.context, this.context = context);
    }
    private Template template;

    public Template getTemplate() {
        return notifyRequested(PatternsFeatureDescriptorEnum.template, template);
    }

    public void setTemplate(Template template) {
        notifyChanged(PatternsFeatureDescriptorEnum.template, this.template, this.template = template);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getContext().wGetAdaptee(false);
            case 1 :
            return getTemplate().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setContext(value.wGetAdapter(PatternsEntityDescriptorEnum.Declarations));
            break;
            case 1 :
            setTemplate(value.wGetAdapter(PatternsEntityDescriptorEnum.Template));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
