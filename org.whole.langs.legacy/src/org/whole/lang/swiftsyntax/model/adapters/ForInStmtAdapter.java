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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ForInStmtAdapter extends AbstractEntityAdapter implements ForInStmt {
    private static final long serialVersionUID = 1;

    public ForInStmtAdapter(IEntity implementor) {
        super(implementor);
    }

    public ForInStmtAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ForInStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ForInStmt;
    }

    public Token getLabelName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.labelName).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLabelName(Token labelName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.labelName, labelName);
    }

    public Token getLabelColon() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.labelColon).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLabelColon(Token labelColon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.labelColon, labelColon);
    }

    public Token getForKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.forKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setForKeyword(Token forKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.forKeyword, forKeyword);
    }

    public Token getCaseKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.caseKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setCaseKeyword(Token caseKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.caseKeyword, caseKeyword);
    }

    public Pattern getPattern() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.pattern).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Pattern);
    }

    public void setPattern(Pattern pattern) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.pattern, pattern);
    }

    public TypeAnnotation getTypeAnnotation() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation);
    }

    public void setTypeAnnotation(TypeAnnotation typeAnnotation) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public Token getInKeyword() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.inKeyword).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setInKeyword(Token inKeyword) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.inKeyword, inKeyword);
    }

    public Expr getSequenceExpr() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.sequenceExpr).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr);
    }

    public void setSequenceExpr(Expr sequenceExpr) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.sequenceExpr, sequenceExpr);
    }

    public WhereClause getWhereClause() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.whereClause).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.WhereClause);
    }

    public void setWhereClause(WhereClause whereClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.whereClause, whereClause);
    }

    public CodeBlock getBody() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.body).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock);
    }

    public void setBody(CodeBlock body) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }
}
