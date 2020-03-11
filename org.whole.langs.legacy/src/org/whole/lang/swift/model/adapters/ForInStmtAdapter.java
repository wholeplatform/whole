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
public class ForInStmtAdapter extends AbstractEntityAdapter implements ForInStmt {
    private static final long serialVersionUID = 1;

    public ForInStmtAdapter(IEntity implementor) {
        super(implementor);
    }

    public ForInStmtAdapter() {
    }

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ForInStmt> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ForInStmt;
    }

    public Identifier getLabelName() {
        return wGet(SwiftFeatureDescriptorEnum.labelName).wGetAdapter(SwiftEntityDescriptorEnum.Identifier);
    }

    public void setLabelName(Identifier labelName) {
        wSet(SwiftFeatureDescriptorEnum.labelName, labelName);
    }

    public Case getCaseKeyword() {
        return wGet(SwiftFeatureDescriptorEnum.caseKeyword).wGetAdapter(SwiftEntityDescriptorEnum.Case);
    }

    public void setCaseKeyword(Case caseKeyword) {
        wSet(SwiftFeatureDescriptorEnum.caseKeyword, caseKeyword);
    }

    public Pattern getPattern() {
        return wGet(SwiftFeatureDescriptorEnum.pattern).wGetAdapter(SwiftEntityDescriptorEnum.Pattern);
    }

    public void setPattern(Pattern pattern) {
        wSet(SwiftFeatureDescriptorEnum.pattern, pattern);
    }

    public Type getTypeAnnotation() {
        return wGet(SwiftFeatureDescriptorEnum.typeAnnotation).wGetAdapter(SwiftEntityDescriptorEnum.Type);
    }

    public void setTypeAnnotation(Type typeAnnotation) {
        wSet(SwiftFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public Expr getSequenceExpr() {
        return wGet(SwiftFeatureDescriptorEnum.sequenceExpr).wGetAdapter(SwiftEntityDescriptorEnum.Expr);
    }

    public void setSequenceExpr(Expr sequenceExpr) {
        wSet(SwiftFeatureDescriptorEnum.sequenceExpr, sequenceExpr);
    }

    public Expr getWhereClause() {
        return wGet(SwiftFeatureDescriptorEnum.whereClause).wGetAdapter(SwiftEntityDescriptorEnum.Expr);
    }

    public void setWhereClause(Expr whereClause) {
        wSet(SwiftFeatureDescriptorEnum.whereClause, whereClause);
    }

    public CodeBlockItemList getBody() {
        return wGet(SwiftFeatureDescriptorEnum.body).wGetAdapter(SwiftEntityDescriptorEnum.CodeBlockItemList);
    }

    public void setBody(CodeBlockItemList body) {
        wSet(SwiftFeatureDescriptorEnum.body, body);
    }
}
