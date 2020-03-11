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
import org.whole.lang.swift.model.SwitchStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.model.SwitchCaseList;

/**
 *  @generator Whole
 */
public class SwitchStmtImpl extends AbstractSimpleEntity implements SwitchStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SwitchStmt> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.SwitchStmt;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.SwitchStmt_ord;
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
    private Expr expression;

    public Expr getExpression() {
        return notifyRequested(SwiftFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expr expression) {
        notifyChanged(SwiftFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private SwitchCaseList cases;

    public SwitchCaseList getCases() {
        return notifyRequested(SwiftFeatureDescriptorEnum.cases, cases);
    }

    public void setCases(SwitchCaseList cases) {
        notifyChanged(SwiftFeatureDescriptorEnum.cases, this.cases, this.cases = cases);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getExpression().wGetAdaptee(false);
            case 2 :
            return getCases().wGetAdaptee(false);
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
            setExpression(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 2 :
            setCases(value.wGetAdapter(SwiftEntityDescriptorEnum.SwitchCaseList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
