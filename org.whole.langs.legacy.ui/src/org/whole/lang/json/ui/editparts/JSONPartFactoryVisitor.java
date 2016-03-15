/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.json.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.json.model.Array;
import org.whole.lang.json.model.IJSONEntity;
import org.whole.lang.json.model.Name;
import org.whole.lang.json.model.Null;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.Pair;
import org.whole.lang.json.visitors.JSONIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 *  @author  Riccardo Solmi
 */
public class JSONPartFactoryVisitor extends JSONIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, java.lang.Object modelEntity) {
        this.context = context;
        ((IJSONEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(IJSONEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(Object entity) {
        part = new ObjectPart();
    }

    @Override
    public void visit(Pair entity) {
        part = new PairPart();
    }

    @Override
    public void visit(Array entity) {
        part = new ArrayPart();
    }

    @Override
    public void visit(Name entity) {
        part = new ContentTextualEntityPart();
    }

    @Override
    public void visit(Null entity) {
        part = new NullPart();
    }
}
