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

/**
 *  @generator Whole
 */
public class ReusablesForwardStagedVisitor extends ReusablesIdentityVisitor {

    public void visit(Adapt entity) {
        stagedVisit(entity);
    }

    public void visit(Reuse entity) {
        stagedVisit(entity);
    }

    public void visit(Sync entity) {
        stagedVisit(entity);
    }

    public void visit(Include entity) {
        stagedVisit(entity);
    }

    public void visit(Reusables entity) {
        stagedVisit(entity);
    }

    public void visit(Workspace entity) {
        stagedVisit(entity);
    }

    public void visit(FileSystem entity) {
        stagedVisit(entity);
    }

    public void visit(Classpath entity) {
        stagedVisit(entity);
    }

    public void visit(URL entity) {
        stagedVisit(entity);
    }

    public void visit(Model entity) {
        stagedVisit(entity);
    }

    public void visit(Registry entity) {
        stagedVisit(entity);
    }

    public void visit(Contents entity) {
        stagedVisit(entity);
    }

    public void visit(Folder entity) {
        stagedVisit(entity);
    }

    public void visit(File entity) {
        stagedVisit(entity);
    }

    public void visit(Load entity) {
        stagedVisit(entity);
    }

    public void visit(Save entity) {
        stagedVisit(entity);
    }

    public void visit(PathName entity) {
        stagedVisit(entity);
    }

    public void visit(PathWithExtension entity) {
        stagedVisit(entity);
    }

    public void visit(PathSegments entity) {
        stagedVisit(entity);
    }

    public void visit(URI entity) {
        stagedVisit(entity);
    }

    public void visit(PersistenceId entity) {
        stagedVisit(entity);
    }
}
