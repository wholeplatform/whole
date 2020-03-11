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
import org.whole.lang.swift.model.AsExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.QuestionOrExclamationMarkEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Type;

/**
 *  @generator Whole
 */
public class AsExprImpl extends AbstractSimpleEntity implements AsExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AsExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.AsExpr;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.AsExpr_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private QuestionOrExclamationMarkEnum questionOrExclamationMark;

    public QuestionOrExclamationMarkEnum getQuestionOrExclamationMark() {
        return notifyRequested(SwiftFeatureDescriptorEnum.questionOrExclamationMark, questionOrExclamationMark);
    }

    public void setQuestionOrExclamationMark(QuestionOrExclamationMarkEnum questionOrExclamationMark) {
        notifyChanged(SwiftFeatureDescriptorEnum.questionOrExclamationMark, this.questionOrExclamationMark, this.questionOrExclamationMark = questionOrExclamationMark);
    }
    private Type typeName;

    public Type getTypeName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.typeName, typeName);
    }

    public void setTypeName(Type typeName) {
        notifyChanged(SwiftFeatureDescriptorEnum.typeName, this.typeName, this.typeName = typeName);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getQuestionOrExclamationMark().wGetAdaptee(false);
            case 1 :
            return getTypeName().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setQuestionOrExclamationMark(value.wGetAdapter(SwiftEntityDescriptorEnum.QuestionOrExclamationMarkEnum));
            break;
            case 1 :
            setTypeName(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
