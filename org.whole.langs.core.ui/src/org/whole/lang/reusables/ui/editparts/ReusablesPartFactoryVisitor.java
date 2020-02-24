/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.reusables.model.Classpath;
import org.whole.lang.reusables.model.Contents;
import org.whole.lang.reusables.model.File;
import org.whole.lang.reusables.model.FileSystem;
import org.whole.lang.reusables.model.Folder;
import org.whole.lang.reusables.model.IReusablesEntity;
import org.whole.lang.reusables.model.Include;
import org.whole.lang.reusables.model.Load;
import org.whole.lang.reusables.model.Model;
import org.whole.lang.reusables.model.PathName;
import org.whole.lang.reusables.model.PathSegments;
import org.whole.lang.reusables.model.PathWithExtension;
import org.whole.lang.reusables.model.PersistenceId;
import org.whole.lang.reusables.model.Registry;
import org.whole.lang.reusables.model.Reusables;
import org.whole.lang.reusables.model.Reuse;
import org.whole.lang.reusables.model.Sync;
import org.whole.lang.reusables.model.URI;
import org.whole.lang.reusables.model.URL;
import org.whole.lang.reusables.model.Workspace;
import org.whole.lang.reusables.visitors.ReusablesIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
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
    public void visit(Sync entity) {
        part = new SyncPart();
    }

    @Override
    public void visit(Include entity) {
        part = new IncludePart();
    }

    @Override
    public void visit(Load entity) {
        part = new LoadPart();
    }

    @Override
    public void visit(Reusables entity) {
        part = new ReusablesPart();
    }

    @Override
    public void visit(Workspace entity) {
    	part = new WorkspacePart();
    }

    @Override
    public void visit(FileSystem entity) {
    	part = new FileSystemPart();
    }

    @Override
    public void visit(Classpath entity) {
    	part = new ClasspathPart();
    }

    @Override
    public void visit(URL entity) {
    	part = new URLPart();
    }

    @Override
    public void visit(Model entity) {
    	part = new ModelPart();
    }

    @Override
    public void visit(Registry entity) {
    	// TODO Auto-generated method stub
    	super.visit(entity);
    }

    @Override
    public void visit(Contents entity) {
    	part = new ContentsPart();
    }

    @Override
    public void visit(Folder entity) {
    	part = new FolderPart();
    }

    @Override
    public void visit(File entity) {
    	part = new FilePart();
    }

    @Override
    public void visit(PathName entity) {
        part = new LiteralTextualEntityPart();
    }

    @Override
    public void visit(PathWithExtension entity) {
    	part = new PathWithExtensionPart();
    }

    @Override
    public void visit(PathSegments entity) {
    	part = new PathSegmentsPart();
    }

    @Override
    public void visit(URI entity) {
        part = new ContentTextualEntityPart();
    }

    @Override
    public void visit(PersistenceId entity) {
        part = new PersistenceIdPart();
    }
}
