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

import org.whole.lang.artifacts.visitors.ArtifactsIdentityUnaryVisitor;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class ArtifactsTraverseAllVisitor extends ArtifactsIdentityUnaryVisitor<IArtifactsVisitor> {

    public ArtifactsTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public ArtifactsTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Workspace entity) {
        entity.getMetadata().accept(wGetVisitor1());
        entity.getProjects().accept(wGetVisitor1());
    }

    public void visit(Projects entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Project entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getNatures().accept(wGetVisitor1());
        entity.getMetadata().accept(wGetVisitor1());
        entity.getArtifacts().accept(wGetVisitor1());
        entity.getLocationURI().accept(wGetVisitor1());
    }

    public void visit(Artifacts entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PackageArtifact entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getMetadata().accept(wGetVisitor1());
        entity.getArtifacts().accept(wGetVisitor1());
    }

    public void visit(FolderArtifact entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getMetadata().accept(wGetVisitor1());
        entity.getArtifacts().accept(wGetVisitor1());
    }

    public void visit(FileArtifact entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getMetadata().accept(wGetVisitor1());
        entity.getContent().accept(wGetVisitor1());
    }

    public void visit(Natures entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Metadata entity) {
        entity.getCopyright().accept(wGetVisitor1());
        entity.getLicense().accept(wGetVisitor1());
        entity.getAuthor().accept(wGetVisitor1());
        entity.getAttributes().accept(wGetVisitor1());
        entity.getPersistenceKitId().accept(wGetVisitor1());
    }

    public void visit(NameWithExtension entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getExtension().accept(wGetVisitor1());
    }

    public void visit(Attributes entity) {
        for (Attribute child : entity)
            child.accept(wGetVisitor1());
    }
}
