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
import org.whole.lang.swift.model.IfStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ConditionElementList;
import org.whole.lang.swift.model.CodeBlockItemList;
import org.whole.lang.swift.model.AbstractElseBody;

/**
 *  @generator Whole
 */
public class IfStmtImpl extends AbstractSimpleEntity implements IfStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<IfStmt> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.IfStmt;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.IfStmt_ord;
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
    private ConditionElementList conditions;

    public ConditionElementList getConditions() {
        return notifyRequested(SwiftFeatureDescriptorEnum.conditions, conditions);
    }

    public void setConditions(ConditionElementList conditions) {
        notifyChanged(SwiftFeatureDescriptorEnum.conditions, this.conditions, this.conditions = conditions);
    }
    private CodeBlockItemList body;

    public CodeBlockItemList getBody() {
        return notifyRequested(SwiftFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlockItemList body) {
        notifyChanged(SwiftFeatureDescriptorEnum.body, this.body, this.body = body);
    }
    private AbstractElseBody elseBody;

    public AbstractElseBody getElseBody() {
        return notifyRequested(SwiftFeatureDescriptorEnum.elseBody, elseBody);
    }

    public void setElseBody(AbstractElseBody elseBody) {
        notifyChanged(SwiftFeatureDescriptorEnum.elseBody, this.elseBody, this.elseBody = elseBody);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getConditions().wGetAdaptee(false);
            case 2 :
            return getBody().wGetAdaptee(false);
            case 3 :
            return getElseBody().wGetAdaptee(false);
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
            setConditions(value.wGetAdapter(SwiftEntityDescriptorEnum.ConditionElementList));
            break;
            case 2 :
            setBody(value.wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList));
            break;
            case 3 :
            setElseBody(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractElseBody));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
