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
package org.whole.lang.reusables.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.reusables.model.Adapt;
import org.whole.lang.reusables.model.ClassPathURI;
import org.whole.lang.reusables.model.FileSystemPath;
import org.whole.lang.reusables.model.IReusablesEntity;
import org.whole.lang.reusables.model.Include;
import org.whole.lang.reusables.model.Persistence;
import org.whole.lang.reusables.model.ReferenceStep;
import org.whole.lang.reusables.model.Reusables;
import org.whole.lang.reusables.model.Reuse;
import org.whole.lang.reusables.model.Synch;
import org.whole.lang.reusables.model.URI;
import org.whole.lang.reusables.model.WorkspacePath;
import org.whole.lang.reusables.visitors.ReusablesIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 *  @generator Whole
 */
public class ReusablesPartFactoryVisitor extends ReusablesIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((IReusablesEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(IReusablesEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(Adapt entity) {
        part = new AdaptPart();
    }

    @Override
    public void visit(Reuse entity) {
        part = new ReusePart();
    }

    @Override
    public void visit(Synch entity) {
        part = new SynchPart();
    }

    @Override
    public void visit(Include entity) {
        part = new IncludePart();
    }

    @Override
    public void visit(ReferenceStep entity) {
        part = new ReferenceStepPart();
    }

    @Override
    public void visit(Reusables entity) {
        part = new ReusablesPart();
    }

    @Override
    public void visit(WorkspacePath entity) {
        part = new WorkspacePathPart();
    }

    @Override
    public void visit(FileSystemPath entity) {
        part = new ContentTextualEntityPart();
    }

    @Override
    public void visit(ClassPathURI entity) {
        part = new ContentTextualEntityPart();
    }

    @Override
    public void visit(URI entity) {
        part = new ContentTextualEntityPart();
    }

    @Override
    public void visit(Persistence entity) {
        part = new ContentTextualEntityPart();
    }
}
