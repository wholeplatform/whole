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
import org.whole.lang.swift.model.ForInStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Case;
import org.whole.lang.swift.model.Pattern;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.model.CodeBlockItemList;

/**
 *  @generator Whole
 */
public class ForInStmtImpl extends AbstractSimpleEntity implements ForInStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ForInStmt> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ForInStmt;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ForInStmt_ord;
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
    private Case caseKeyword;

    public Case getCaseKeyword() {
        return notifyRequested(SwiftFeatureDescriptorEnum.caseKeyword, caseKeyword);
    }

    public void setCaseKeyword(Case caseKeyword) {
        notifyChanged(SwiftFeatureDescriptorEnum.caseKeyword, this.caseKeyword, this.caseKeyword = caseKeyword);
    }
    private Pattern pattern;

    public Pattern getPattern() {
        return notifyRequested(SwiftFeatureDescriptorEnum.pattern, pattern);
    }

    public void setPattern(Pattern pattern) {
        notifyChanged(SwiftFeatureDescriptorEnum.pattern, this.pattern, this.pattern = pattern);
    }
    private Type typeAnnotation;

    public Type getTypeAnnotation() {
        return notifyRequested(SwiftFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public void setTypeAnnotation(Type typeAnnotation) {
        notifyChanged(SwiftFeatureDescriptorEnum.typeAnnotation, this.typeAnnotation, this.typeAnnotation = typeAnnotation);
    }
    private Expr sequenceExpr;

    public Expr getSequenceExpr() {
        return notifyRequested(SwiftFeatureDescriptorEnum.sequenceExpr, sequenceExpr);
    }

    public void setSequenceExpr(Expr sequenceExpr) {
        notifyChanged(SwiftFeatureDescriptorEnum.sequenceExpr, this.sequenceExpr, this.sequenceExpr = sequenceExpr);
    }
    private Expr whereClause;

    public Expr getWhereClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.whereClause, whereClause);
    }

    public void setWhereClause(Expr whereClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.whereClause, this.whereClause, this.whereClause = whereClause);
    }
    private CodeBlockItemList body;

    public CodeBlockItemList getBody() {
        return notifyRequested(SwiftFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlockItemList body) {
        notifyChanged(SwiftFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getCaseKeyword().wGetAdaptee(false);
            case 2 :
            return getPattern().wGetAdaptee(false);
            case 3 :
            return getTypeAnnotation().wGetAdaptee(false);
            case 4 :
            return getSequenceExpr().wGetAdaptee(false);
            case 5 :
            return getWhereClause().wGetAdaptee(false);
            case 6 :
            return getBody().wGetAdaptee(false);
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
            setCaseKeyword(value.wGetAdapter(SwiftEntityDescriptorEnum.Case));
            break;
            case 2 :
            setPattern(value.wGetAdapter(SwiftEntityDescriptorEnum.Pattern));
            break;
            case 3 :
            setTypeAnnotation(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 4 :
            setSequenceExpr(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 5 :
            setWhereClause(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 6 :
            setBody(value.wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
