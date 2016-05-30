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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.syntaxtrees.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.syntaxtrees.model.Error;

/**
 *  @generator Whole
 */
public class SyntaxTreesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements ISyntaxTreesVisitor {

    public SyntaxTreesForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Rule entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Nodes entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Terminal entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Literal entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Data entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Error entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Text entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Name entity) {
        wGetVisitor1().visit(entity);
    }
}
