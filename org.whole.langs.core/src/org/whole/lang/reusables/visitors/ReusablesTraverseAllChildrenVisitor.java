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

import org.whole.lang.reusables.visitors.ReusablesIdentityUnaryVisitor;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class ReusablesTraverseAllChildrenVisitor extends ReusablesIdentityUnaryVisitor<IReusablesVisitor> {

    public ReusablesTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public ReusablesTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Adapt entity) {
        entity.getOriginal().accept(wGetVisitor1());
        entity.getAdapter().accept(wGetVisitor1());
        entity.getAdapted().accept(wGetVisitor1());
        entity.getAdaptedRevision().accept(wGetVisitor1());
    }

    public void visit(Reuse entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getOriginal().accept(wGetVisitor1());
        entity.getAdapter().accept(wGetVisitor1());
        entity.getAdapted().accept(wGetVisitor1());
        entity.getAdaptedRevision().accept(wGetVisitor1());
    }

    public void visit(Synch entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getOriginal().accept(wGetVisitor1());
        entity.getAdapter().accept(wGetVisitor1());
        entity.getAdapted().accept(wGetVisitor1());
        entity.getAdaptedRevision().accept(wGetVisitor1());
        entity.getVariant().accept(wGetVisitor1());
        entity.getVariantRevision().accept(wGetVisitor1());
    }

    public void visit(Include entity) {
        entity.getSource().accept(wGetVisitor1());
    }

    public void visit(Reusables entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ReferenceStep entity) {
        entity.getSource().accept(wGetVisitor1());
    }

    public void visit(Resource entity) {
        entity.getLocator().accept(wGetVisitor1());
        entity.getPersistence().accept(wGetVisitor1());
    }

    public void visit(Registry entity) {
        entity.getLocator().accept(wGetVisitor1());
        entity.getUri().accept(wGetVisitor1());
    }
}
