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
import org.whole.lang.swift.model.DoStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.CodeBlockItemList;
import org.whole.lang.swift.model.CatchClauseList;

/**
 *  @generator Whole
 */
public class DoStmtImpl extends AbstractSimpleEntity implements DoStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DoStmt> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.DoStmt;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.DoStmt_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Identifier labelName;

    public Identifier getLabelName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.labelName, labelName);
    }

    public void setLabelName(Identifier labelName) {
        notifyChanged(SwiftFeatureDescriptorEnum.labelName, this.labelName, this.labelName = labelName);
    }
    private CodeBlockItemList body;

    public CodeBlockItemList getBody() {
        return notifyRequested(SwiftFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlockItemList body) {
        notifyChanged(SwiftFeatureDescriptorEnum.body, this.body, this.body = body);
    }
    private CatchClauseList catchClauses;

    public CatchClauseList getCatchClauses() {
        return notifyRequested(SwiftFeatureDescriptorEnum.catchClauses, catchClauses);
    }

    public void setCatchClauses(CatchClauseList catchClauses) {
        notifyChanged(SwiftFeatureDescriptorEnum.catchClauses, this.catchClauses, this.catchClauses = catchClauses);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getBody().wGetAdaptee(false);
            case 2 :
            return getCatchClauses().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLabelName(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 1 :
            setBody(value.wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList));
            break;
            case 2 :
            setCatchClauses(value.wGetAdapter(SwiftEntityDescriptorEnum.CatchClauseList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
