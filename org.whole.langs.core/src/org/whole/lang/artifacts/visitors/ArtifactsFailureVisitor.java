/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class ArtifactsFailureVisitor extends ArtifactsIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Workspace entity) {
        throw new VisitException();
    }

    public void visit(Projects entity) {
        throw new VisitException();
    }

    public void visit(Project entity) {
        throw new VisitException();
    }

    public void visit(Artifacts entity) {
        throw new VisitException();
    }

    public void visit(PackageArtifact entity) {
        throw new VisitException();
    }

    public void visit(FolderArtifact entity) {
        throw new VisitException();
    }

    public void visit(FileArtifact entity) {
        throw new VisitException();
    }

    public void visit(Natures entity) {
        throw new VisitException();
    }

    public void visit(Nature entity) {
        throw new VisitException();
    }

    public void visit(LocationURI entity) {
        throw new VisitException();
    }

    public void visit(Metadata entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(NameWithExtension entity) {
        throw new VisitException();
    }

    public void visit(Copyright entity) {
        throw new VisitException();
    }

    public void visit(License entity) {
        throw new VisitException();
    }

    public void visit(Author entity) {
        throw new VisitException();
    }

    public void visit(Extension entity) {
        throw new VisitException();
    }

    public void visit(Attributes entity) {
        throw new VisitException();
    }

    public void visit(Attribute entity) {
        throw new VisitException();
    }

    public void visit(PersistenceKitId entity) {
        throw new VisitException();
    }
}
