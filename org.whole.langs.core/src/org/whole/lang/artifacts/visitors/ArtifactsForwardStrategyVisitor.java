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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ArtifactsForwardStrategyVisitor extends GenericForwardStrategyVisitor<IArtifactsVisitor> implements IArtifactsVisitor {

    public ArtifactsForwardStrategyVisitor() {
        this(new ArtifactsIdentityVisitor());
    }

    public ArtifactsForwardStrategyVisitor(IArtifactsVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IArtifactsEntity) entity).accept(this);
    }

    public void visit(Workspace entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Projects entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Project entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Artifacts entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PackageArtifact entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FolderArtifact entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FileArtifact entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Natures entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Nature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LocationURI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Metadata entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NameWithExtension entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Copyright entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(License entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Author entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Extension entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Attributes entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Attribute entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PersistenceKitId entity) {
        wGetStrategy().visit(entity);
    }
}
