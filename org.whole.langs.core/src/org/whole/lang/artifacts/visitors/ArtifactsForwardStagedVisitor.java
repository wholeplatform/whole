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
package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.model.*;

/**
 *  @generator Whole
 */
public class ArtifactsForwardStagedVisitor extends ArtifactsIdentityVisitor {

    public void visit(Workspace entity) {
        stagedVisit(entity);
    }

    public void visit(Projects entity) {
        stagedVisit(entity);
    }

    public void visit(Project entity) {
        stagedVisit(entity);
    }

    public void visit(Artifacts entity) {
        stagedVisit(entity);
    }

    public void visit(PackageArtifact entity) {
        stagedVisit(entity);
    }

    public void visit(FolderArtifact entity) {
        stagedVisit(entity);
    }

    public void visit(FileArtifact entity) {
        stagedVisit(entity);
    }

    public void visit(Natures entity) {
        stagedVisit(entity);
    }

    public void visit(Nature entity) {
        stagedVisit(entity);
    }

    public void visit(LocationURI entity) {
        stagedVisit(entity);
    }

    public void visit(Metadata entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(NameWithExtension entity) {
        stagedVisit(entity);
    }

    public void visit(Copyright entity) {
        stagedVisit(entity);
    }

    public void visit(License entity) {
        stagedVisit(entity);
    }

    public void visit(Author entity) {
        stagedVisit(entity);
    }

    public void visit(Extension entity) {
        stagedVisit(entity);
    }

    public void visit(Attributes entity) {
        stagedVisit(entity);
    }

    public void visit(Attribute entity) {
        stagedVisit(entity);
    }

    public void visit(PersistenceKitId entity) {
        stagedVisit(entity);
    }
}
