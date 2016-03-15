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
package org.whole.lang.changes.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.changes.model.*;
import org.whole.lang.changes.visitors.ChangesIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;
import org.whole.lang.ui.editparts.ContentLightTextualEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;

/**
 *  @author  Riccardo Solmi
 */
public class ChangesPartFactoryVisitor extends ChangesIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((IChangesEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(IChangesEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(RevisionFrame entity) {
        part = new RevisionFramePart();
    }

    @Override
    public void visit(RevisionTrack entity) {
        part = new RevisionTrackPart();
    }

    @Override
    public void visit(Revisions entity) {
        part = new RevisionsPart();
    }

    @Override
    public void visit(Revision entity) {
        part = new RevisionPart();
    }

    @Override
    public void visit(UnifiedCompare entity) {
        part = new UnifiedComparePart();
    }

    @Override
    public void visit(SideBySideCompare entity) {
        part = new SideBySideComparePart();
    }

    @Override
    public void visit(Changes entity) {
        part = new ChangesPart();
    }

    @Override
    public void visit(Cut entity) {
        part = new CutPart();
    }

    @Override
    public void visit(Copy entity) {
        part = new CopyPart();
    }

    @Override
    public void visit(Paste entity) {
        part = new PastePart();
    }

    @Override
    public void visit(Delete entity) {
        part = new DeletePart();
    }

    @Override
    public void visit(Insert entity) {
        part = new InsertPart();
    }

    @Override
    public void visit(Replace entity) {
        part = new ReplacePart();
    }

    @Override
    public void visit(Wrap entity) {
        part = new WrapPart();
    }

    @Override
    public void visit(Comment entity) {
        part = new CommentPart();
    }

    @Override
    public void visit(Text entity) {
        part = new ContentLightTextualEntityPart();
    }

    @Override
    public void visit(Nothing entity) {
        part = new NothingPart();
    }

    @Override
    public void visit(Clipboard entity) {
        part = new ContentTextualEntityPart();
    }
}
