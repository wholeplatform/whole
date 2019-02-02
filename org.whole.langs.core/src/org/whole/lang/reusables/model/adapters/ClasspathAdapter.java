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
package org.whole.lang.reusables.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ClasspathAdapter extends AbstractEntityAdapter implements Classpath {
    private static final long serialVersionUID = 1;

    public ClasspathAdapter(IEntity implementor) {
        super(implementor);
    }

    public ClasspathAdapter() {
    }

    public void accept(IReusablesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Classpath> wGetEntityDescriptor() {
        return ReusablesEntityDescriptorEnum.Classpath;
    }

    public Content getContent() {
        return wGet(ReusablesFeatureDescriptorEnum.content).wGetAdapter(ReusablesEntityDescriptorEnum.Content);
    }

    public void setContent(Content content) {
        wSet(ReusablesFeatureDescriptorEnum.content, content);
    }

    public Persistence getPersistence() {
        return wGet(ReusablesFeatureDescriptorEnum.persistence).wGetAdapter(ReusablesEntityDescriptorEnum.Persistence);
    }

    public void setPersistence(Persistence persistence) {
        wSet(ReusablesFeatureDescriptorEnum.persistence, persistence);
    }
}
