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
package org.whole.lang.syntaxtrees.visitors;

import org.whole.lang.syntaxtrees.visitors.SyntaxTreesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.syntaxtrees.model.*;
import org.whole.lang.syntaxtrees.model.Error;

/**
 *  @generator Whole
 */
public class SyntaxTreesTraverseAllSwitchVisitor extends SyntaxTreesIdentityUnaryVisitor<IVisitor> {

    public SyntaxTreesTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Node entity) {
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(Rule entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getChildren());
    }

    public void visit(Nodes entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Terminal entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getText());
    }

    public void visit(Literal entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getText());
    }

    public void visit(Data entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getText());
    }

    public void visit(Error entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getText());
    }
}
