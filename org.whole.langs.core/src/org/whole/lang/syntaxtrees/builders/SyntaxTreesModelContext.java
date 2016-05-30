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
package org.whole.lang.syntaxtrees.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SyntaxTreesModelContext extends EntityContext {

    public SyntaxTreesModelContext(IEntity root) {
        super(root);
    }

    public SyntaxTreesModelContext getName() {
        return (SyntaxTreesModelContext) wGet(SyntaxTreesFeatureDescriptorEnum.name);
    }

    public void setName(SyntaxTreesModelContext name) {
        wSet(SyntaxTreesFeatureDescriptorEnum.name, name);
    }

    public SyntaxTreesModelContext getChildren() {
        return (SyntaxTreesModelContext) wGet(SyntaxTreesFeatureDescriptorEnum.children);
    }

    public void setChildren(SyntaxTreesModelContext children) {
        wSet(SyntaxTreesFeatureDescriptorEnum.children, children);
    }

    public SyntaxTreesModelContext getText() {
        return (SyntaxTreesModelContext) wGet(SyntaxTreesFeatureDescriptorEnum.text);
    }

    public void setText(SyntaxTreesModelContext text) {
        wSet(SyntaxTreesFeatureDescriptorEnum.text, text);
    }
}
