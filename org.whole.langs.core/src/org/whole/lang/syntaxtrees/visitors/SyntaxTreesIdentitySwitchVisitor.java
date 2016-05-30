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
package org.whole.lang.syntaxtrees.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.syntaxtrees.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesEntityDescriptorEnum;
import org.whole.lang.syntaxtrees.model.Error;

/**
 *  @generator Whole
 */
public abstract class SyntaxTreesIdentitySwitchVisitor extends AbstractVisitor implements ISyntaxTreesVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case SyntaxTreesEntityDescriptorEnum.Rule_ord :
            visit((Rule) entity);
            break;
            case SyntaxTreesEntityDescriptorEnum.Nodes_ord :
            visit((Nodes) entity);
            break;
            case SyntaxTreesEntityDescriptorEnum.Terminal_ord :
            visit((Terminal) entity);
            break;
            case SyntaxTreesEntityDescriptorEnum.Literal_ord :
            visit((Literal) entity);
            break;
            case SyntaxTreesEntityDescriptorEnum.Data_ord :
            visit((Data) entity);
            break;
            case SyntaxTreesEntityDescriptorEnum.Error_ord :
            visit((Error) entity);
            break;
            case SyntaxTreesEntityDescriptorEnum.Text_ord :
            visit((Text) entity);
            break;
            case SyntaxTreesEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
        }
    }
}
