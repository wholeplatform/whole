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
package org.whole.lang.artifacts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class PersistenceKitIdAdapter extends AbstractEntityAdapter implements PersistenceKitId {
    private static final long serialVersionUID = 1;

    public PersistenceKitIdAdapter(IEntity implementor) {
        super(implementor);
    }

    public PersistenceKitIdAdapter() {
    }

    public void accept(IArtifactsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PersistenceKitId> wGetEntityDescriptor() {
        return ArtifactsEntityDescriptorEnum.PersistenceKitId;
    }

    public String getValue() {
        return wStringValue();
    }

    public void setValue(String value) {
        wSetValue(value);
    }
}
