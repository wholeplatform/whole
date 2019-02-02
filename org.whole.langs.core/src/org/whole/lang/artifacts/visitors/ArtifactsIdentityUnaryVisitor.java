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

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ArtifactsIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IArtifactsVisitor {

    public ArtifactsIdentityUnaryVisitor() {
        super(null);
    }

    public ArtifactsIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IArtifactsEntity) entity).accept(this);
    }

    public void visit(Workspace entity) {
    }

    public void visit(Projects entity) {
    }

    public void visit(Project entity) {
    }

    public void visit(Artifacts entity) {
    }

    public void visit(PackageArtifact entity) {
    }

    public void visit(FolderArtifact entity) {
    }

    public void visit(FileArtifact entity) {
    }

    public void visit(Natures entity) {
    }

    public void visit(Nature entity) {
    }

    public void visit(LocationURI entity) {
    }

    public void visit(Metadata entity) {
    }

    public void visit(Name entity) {
    }

    public void visit(NameWithExtension entity) {
    }

    public void visit(Copyright entity) {
    }

    public void visit(License entity) {
    }

    public void visit(Author entity) {
    }

    public void visit(Extension entity) {
    }

    public void visit(Attributes entity) {
    }

    public void visit(Attribute entity) {
    }

    public void visit(PersistenceKitId entity) {
    }
}
