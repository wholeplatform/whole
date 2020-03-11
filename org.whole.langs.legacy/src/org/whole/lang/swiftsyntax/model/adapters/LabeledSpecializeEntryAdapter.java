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
public class LabeledSpecializeEntryAdapter extends AbstractEntityAdapter implements LabeledSpecializeEntry {
    private static final long serialVersionUID = 1;

    public LabeledSpecializeEntryAdapter(IEntity implementor) {
        super(implementor);
    }

    public LabeledSpecializeEntryAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<LabeledSpecializeEntry> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.LabeledSpecializeEntry;
    }

    public Token getLabel() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.label).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setLabel(Token label) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.label, label);
    }

    public Token getColon() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.colon).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setColon(Token colon) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.colon, colon);
    }

    public Token getValue() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.value).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setValue(Token value) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.value, value);
    }

    public Token getTrailingComma() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.trailingComma).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setTrailingComma(Token trailingComma) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.trailingComma, trailingComma);
    }
}
