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
package org.whole.lang.reusables.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ReusablesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IReusablesVisitor {

    public ReusablesForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Adapt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Reuse entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Sync entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Include entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Reusables entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Workspace entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FileSystem entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Classpath entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(URL entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Model entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Registry entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Contents entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Folder entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(File entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Exists entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Delete entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Load entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Save entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PathName entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PathWithExtension entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PathSegments entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(URI entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PersistenceId entity) {
        wGetVisitor1().visit(entity);
    }
}
