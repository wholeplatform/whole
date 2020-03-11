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
package org.whole.lang.swiftsyntax.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swiftsyntax.model.ForInStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Pattern;
import org.whole.lang.swiftsyntax.model.TypeAnnotation;
import org.whole.lang.swiftsyntax.model.Expr;
import org.whole.lang.swiftsyntax.model.WhereClause;
import org.whole.lang.swiftsyntax.model.CodeBlock;

/**
 *  @generator Whole
 */
public class ForInStmtImpl extends AbstractSimpleEntity implements ForInStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ForInStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ForInStmt;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.ForInStmt_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token labelName;

    public Token getLabelName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.labelName, labelName);
    }

    public void setLabelName(Token labelName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.labelName, this.labelName, this.labelName = labelName);
    }
    private Token labelColon;

    public Token getLabelColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.labelColon, labelColon);
    }

    public void setLabelColon(Token labelColon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.labelColon, this.labelColon, this.labelColon = labelColon);
    }
    private Token forKeyword;

    public Token getForKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.forKeyword, forKeyword);
    }

    public void setForKeyword(Token forKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.forKeyword, this.forKeyword, this.forKeyword = forKeyword);
    }
    private Token caseKeyword;

    public Token getCaseKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.caseKeyword, caseKeyword);
    }

    public void setCaseKeyword(Token caseKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.caseKeyword, this.caseKeyword, this.caseKeyword = caseKeyword);
    }
    private Pattern pattern;

    public Pattern getPattern() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.pattern, pattern);
    }

    public void setPattern(Pattern pattern) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.pattern, this.pattern, this.pattern = pattern);
    }
    private TypeAnnotation typeAnnotation;

    public TypeAnnotation getTypeAnnotation() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public void setTypeAnnotation(TypeAnnotation typeAnnotation) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, this.typeAnnotation, this.typeAnnotation = typeAnnotation);
    }
    private Token inKeyword;

    public Token getInKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.inKeyword, inKeyword);
    }

    public void setInKeyword(Token inKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.inKeyword, this.inKeyword, this.inKeyword = inKeyword);
    }
    private Expr sequenceExpr;

    public Expr getSequenceExpr() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.sequenceExpr, sequenceExpr);
    }

    public void setSequenceExpr(Expr sequenceExpr) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.sequenceExpr, this.sequenceExpr, this.sequenceExpr = sequenceExpr);
    }
    private WhereClause whereClause;

    public WhereClause getWhereClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.whereClause, whereClause);
    }

    public void setWhereClause(WhereClause whereClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.whereClause, this.whereClause, this.whereClause = whereClause);
    }
    private CodeBlock body;

    public CodeBlock getBody() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlock body) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getLabelColon().wGetAdaptee(false);
            case 2 :
            return getForKeyword().wGetAdaptee(false);
            case 3 :
            return getCaseKeyword().wGetAdaptee(false);
            case 4 :
            return getPattern().wGetAdaptee(false);
            case 5 :
            return getTypeAnnotation().wGetAdaptee(false);
            case 6 :
            return getInKeyword().wGetAdaptee(false);
            case 7 :
            return getSequenceExpr().wGetAdaptee(false);
            case 8 :
            return getWhereClause().wGetAdaptee(false);
            case 9 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLabelName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setLabelColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setForKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setCaseKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setPattern(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Pattern));
            break;
            case 5 :
            setTypeAnnotation(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation));
            break;
            case 6 :
            setInKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 7 :
            setSequenceExpr(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 8 :
            setWhereClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.WhereClause));
            break;
            case 9 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 10;
    }
}
