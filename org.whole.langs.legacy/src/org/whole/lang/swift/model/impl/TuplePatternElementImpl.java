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
import org.whole.lang.swift.model.TuplePatternElement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Pattern;

/**
 *  @generator Whole
 */
public class TuplePatternElementImpl extends AbstractSimpleEntity implements TuplePatternElement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TuplePatternElement> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.TuplePatternElement;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.TuplePatternElement_ord;
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
    private Pattern pattern;

    public Pattern getPattern() {
        return notifyRequested(SwiftFeatureDescriptorEnum.pattern, pattern);
    }

    public void setPattern(Pattern pattern) {
        notifyChanged(SwiftFeatureDescriptorEnum.pattern, this.pattern, this.pattern = pattern);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getPattern().wGetAdaptee(false);
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
            setPattern(value.wGetAdapter(SwiftEntityDescriptorEnum.Pattern));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
