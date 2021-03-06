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
package org.whole.lang.patterns.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.patterns.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class FunctionDeclarationAdapter extends AbstractEntityAdapter implements FunctionDeclaration {
    private static final long serialVersionUID = 1;

    public FunctionDeclarationAdapter(IEntity implementor) {
        super(implementor);
    }

    public FunctionDeclarationAdapter() {
    }

    public void accept(IPatternsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<FunctionDeclaration> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.FunctionDeclaration;
    }

    public ResultTypes getApplicationTypes() {
        return wGet(PatternsFeatureDescriptorEnum.applicationTypes).wGetAdapter(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public void setApplicationTypes(ResultTypes applicationTypes) {
        wSet(PatternsFeatureDescriptorEnum.applicationTypes, applicationTypes);
    }

    public Name getName() {
        return wGet(PatternsFeatureDescriptorEnum.name).wGetAdapter(PatternsEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(PatternsFeatureDescriptorEnum.name, name);
    }

    public Expression getBody() {
        return wGet(PatternsFeatureDescriptorEnum.body).wGetAdapter(PatternsEntityDescriptorEnum.Expression);
    }

    public void setBody(Expression body) {
        wSet(PatternsFeatureDescriptorEnum.body, body);
    }
}
