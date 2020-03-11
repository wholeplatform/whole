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
public class TupleTypeElementAdapter extends AbstractEntityAdapter implements TupleTypeElement {
    private static final long serialVersionUID = 1;

    public TupleTypeElementAdapter(IEntity implementor) {
        super(implementor);
    }

    public TupleTypeElementAdapter() {
    }

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<TupleTypeElement> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.TupleTypeElement;
    }

    public Inout getInOut() {
        return wGet(SwiftFeatureDescriptorEnum.inOut).wGetAdapter(SwiftEntityDescriptorEnum.Inout);
    }

    public void setInOut(Inout inOut) {
        wSet(SwiftFeatureDescriptorEnum.inOut, inOut);
    }

    public AbstractName getName() {
        return wGet(SwiftFeatureDescriptorEnum.name).wGetAdapter(SwiftEntityDescriptorEnum.AbstractName);
    }

    public void setName(AbstractName name) {
        wSet(SwiftFeatureDescriptorEnum.name, name);
    }

    public AbstractSecondName getSecondName() {
        return wGet(SwiftFeatureDescriptorEnum.secondName).wGetAdapter(SwiftEntityDescriptorEnum.AbstractSecondName);
    }

    public void setSecondName(AbstractSecondName secondName) {
        wSet(SwiftFeatureDescriptorEnum.secondName, secondName);
    }

    public Type getType() {
        return wGet(SwiftFeatureDescriptorEnum.type).wGetAdapter(SwiftEntityDescriptorEnum.Type);
    }

    public void setType(Type type) {
        wSet(SwiftFeatureDescriptorEnum.type, type);
    }

    public Ellipsis getEllipsis() {
        return wGet(SwiftFeatureDescriptorEnum.ellipsis).wGetAdapter(SwiftEntityDescriptorEnum.Ellipsis);
    }

    public void setEllipsis(Ellipsis ellipsis) {
        wSet(SwiftFeatureDescriptorEnum.ellipsis, ellipsis);
    }

    public Expr getInitializer() {
        return wGet(SwiftFeatureDescriptorEnum.initializer).wGetAdapter(SwiftEntityDescriptorEnum.Expr);
    }

    public void setInitializer(Expr initializer) {
        wSet(SwiftFeatureDescriptorEnum.initializer, initializer);
    }
}
