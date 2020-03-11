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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.SourceFile;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.CodeBlockItemList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SourceFileImpl extends AbstractSimpleEntity implements SourceFile {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SourceFile> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.SourceFile;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.SourceFile_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private CodeBlockItemList statements;

    public CodeBlockItemList getStatements() {
        return notifyRequested(SwiftFeatureDescriptorEnum.statements, statements);
    }

    public void setStatements(CodeBlockItemList statements) {
        notifyChanged(SwiftFeatureDescriptorEnum.statements, this.statements, this.statements = statements);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getStatements().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setStatements(value.wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
