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
public class EnumCasePatternAdapter extends AbstractEntityAdapter implements EnumCasePattern {
    private static final long serialVersionUID = 1;

    public EnumCasePatternAdapter(IEntity implementor) {
        super(implementor);
    }

    public EnumCasePatternAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<EnumCasePattern> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.EnumCasePattern;
    }

    public Type getType() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.type).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type);
    }

    public void setType(Type type) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public Token getPeriod() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.period).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setPeriod(Token period) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.period, period);
    }

    public Token getCaseName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.caseName).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setCaseName(Token caseName) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.caseName, caseName);
    }

    public TuplePattern getAssociatedTuple() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.associatedTuple).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TuplePattern);
    }

    public void setAssociatedTuple(TuplePattern associatedTuple) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.associatedTuple, associatedTuple);
    }
}
