/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.syntaxtrees.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.syntaxtrees.model.Error;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesEntityDescriptorEnum;
import org.whole.lang.syntaxtrees.visitors.ISyntaxTreesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.syntaxtrees.model.Name;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.syntaxtrees.model.Text;

/**
 *  @generator Whole
 */
public class ErrorImpl extends AbstractSimpleEntity implements Error {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Error> wGetEntityDescriptor() {
        return SyntaxTreesEntityDescriptorEnum.Error;
    }

    public int wGetEntityOrd() {
        return SyntaxTreesEntityDescriptorEnum.Error_ord;
    }

    public void accept(ISyntaxTreesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name name;

    public Name getName() {
        return notifyRequested(SyntaxTreesFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(SyntaxTreesFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Text text;

    public Text getText() {
        return notifyRequested(SyntaxTreesFeatureDescriptorEnum.text, text);
    }

    public void setText(Text text) {
        notifyChanged(SyntaxTreesFeatureDescriptorEnum.text, this.text, this.text = text);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getText().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(SyntaxTreesEntityDescriptorEnum.Name));
            break;
            case 1 :
            setText(value.wGetAdapter(SyntaxTreesEntityDescriptorEnum.Text));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
