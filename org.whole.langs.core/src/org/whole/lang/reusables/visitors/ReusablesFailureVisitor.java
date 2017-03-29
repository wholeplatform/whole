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

import org.whole.lang.reusables.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class ReusablesFailureVisitor extends ReusablesIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Adapt entity) {
        throw new VisitException();
    }

    public void visit(Reuse entity) {
        throw new VisitException();
    }

    public void visit(Sync entity) {
        throw new VisitException();
    }

    public void visit(Include entity) {
        throw new VisitException();
    }

    public void visit(Reusables entity) {
        throw new VisitException();
    }

    public void visit(Workspace entity) {
        throw new VisitException();
    }

    public void visit(FileSystem entity) {
        throw new VisitException();
    }

    public void visit(Classpath entity) {
        throw new VisitException();
    }

    public void visit(Model entity) {
        throw new VisitException();
    }

    public void visit(Registry entity) {
        throw new VisitException();
    }

    public void visit(Load entity) {
        throw new VisitException();
    }

    public void visit(Save entity) {
        throw new VisitException();
    }

    public void visit(Contents entity) {
        throw new VisitException();
    }

    public void visit(Folder entity) {
        throw new VisitException();
    }

    public void visit(File entity) {
        throw new VisitException();
    }

    public void visit(PathName entity) {
        throw new VisitException();
    }

    public void visit(PathWithExtension entity) {
        throw new VisitException();
    }

    public void visit(PathSegments entity) {
        throw new VisitException();
    }

    public void visit(URI entity) {
        throw new VisitException();
    }

    public void visit(PersistenceId entity) {
        throw new VisitException();
    }
}
