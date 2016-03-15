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

    public void visit(Synch entity) {
        stagedVisit(entity);
    }

    public void visit(Include entity) {
        stagedVisit(entity);
    }

    public void visit(Reusables entity) {
        stagedVisit(entity);
    }

    public void visit(ReferenceStep entity) {
        stagedVisit(entity);
    }

    public void visit(Resource entity) {
        stagedVisit(entity);
    }

    public void visit(Registry entity) {
        stagedVisit(entity);
    }

    public void visit(WorkspacePath entity) {
        stagedVisit(entity);
    }

    public void visit(FileSystemPath entity) {
        stagedVisit(entity);
    }

    public void visit(ClassPathURI entity) {
        stagedVisit(entity);
    }

    public void visit(URI entity) {
        stagedVisit(entity);
    }

    public void visit(Persistence entity) {
        stagedVisit(entity);
    }
}
