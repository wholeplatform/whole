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
public class ClosureExprAdapter extends AbstractEntityAdapter implements ClosureExpr {
    private static final long serialVersionUID = 1;

    public ClosureExprAdapter(IEntity implementor) {
        super(implementor);
    }

    public ClosureExprAdapter() {
    }

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ClosureExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ClosureExpr;
    }

    public ClosureSignature getSignature() {
        return wGet(SwiftFeatureDescriptorEnum.signature).wGetAdapter(SwiftEntityDescriptorEnum.ClosureSignature);
    }

    public void setSignature(ClosureSignature signature) {
        wSet(SwiftFeatureDescriptorEnum.signature, signature);
    }

    public CodeBlockItemList getStatements() {
        return wGet(SwiftFeatureDescriptorEnum.statements).wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList);
    }

    public void setStatements(CodeBlockItemList statements) {
        wSet(SwiftFeatureDescriptorEnum.statements, statements);
    }
}
