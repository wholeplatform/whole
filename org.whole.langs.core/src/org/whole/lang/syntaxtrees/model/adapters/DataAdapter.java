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
package org.whole.lang.syntaxtrees.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.syntaxtrees.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.syntaxtrees.visitors.ISyntaxTreesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesEntityDescriptorEnum;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class DataAdapter extends AbstractEntityAdapter implements Data {
    private static final long serialVersionUID = 1;

    public DataAdapter(IEntity implementor) {
        super(implementor);
    }

    public DataAdapter() {
    }

    public void accept(ISyntaxTreesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Data> wGetEntityDescriptor() {
        return SyntaxTreesEntityDescriptorEnum.Data;
    }

    public Name getName() {
        return wGet(SyntaxTreesFeatureDescriptorEnum.name).wGetAdapter(SyntaxTreesEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(SyntaxTreesFeatureDescriptorEnum.name, name);
    }

    public Text getText() {
        return wGet(SyntaxTreesFeatureDescriptorEnum.text).wGetAdapter(SyntaxTreesEntityDescriptorEnum.Text);
    }

    public void setText(Text text) {
        wSet(SyntaxTreesFeatureDescriptorEnum.text, text);
    }
}
