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
import org.whole.lang.swiftsyntax.model.SwitchCase;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Attribute;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Syntax;
import org.whole.lang.swiftsyntax.model.CodeBlockItemList;

/**
 *  @generator Whole
 */
public class SwitchCaseImpl extends AbstractSimpleEntity implements SwitchCase {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SwitchCase> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.SwitchCase;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.SwitchCase_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Attribute unknownAttr;

    public Attribute getUnknownAttr() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.unknownAttr, unknownAttr);
    }

    public void setUnknownAttr(Attribute unknownAttr) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.unknownAttr, this.unknownAttr, this.unknownAttr = unknownAttr);
    }
    private Syntax label;

    public Syntax getLabel() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.label, label);
    }

    public void setLabel(Syntax label) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.label, this.label, this.label = label);
    }
    private CodeBlockItemList statements;

    public CodeBlockItemList getStatements() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.statements, statements);
    }

    public void setStatements(CodeBlockItemList statements) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.statements, this.statements, this.statements = statements);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getUnknownAttr().wGetAdaptee(false);
            case 1 :
            return getLabel().wGetAdaptee(false);
            case 2 :
            return getStatements().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setUnknownAttr(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Attribute));
            break;
            case 1 :
            setLabel(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            case 2 :
            setStatements(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
