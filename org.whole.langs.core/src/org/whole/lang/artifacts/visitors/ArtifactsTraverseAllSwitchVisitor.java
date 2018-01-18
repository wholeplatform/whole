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

import org.whole.lang.artifacts.visitors.ArtifactsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.artifacts.model.*;

/**
 *  @generator Whole
 */
public class ArtifactsTraverseAllSwitchVisitor extends ArtifactsIdentityUnaryVisitor<IVisitor> {

    public ArtifactsTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Workspace entity) {
        wGetVisitor1().visit(entity.getMetadata());
        wGetVisitor1().visit(entity.getProjects());
    }

    public void visit(Projects entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Project entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getNatures());
        wGetVisitor1().visit(entity.getMetadata());
        wGetVisitor1().visit(entity.getArtifacts());
        wGetVisitor1().visit(entity.getLocationURI());
    }

    public void visit(Artifacts entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PackageArtifact entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getMetadata());
        wGetVisitor1().visit(entity.getArtifacts());
    }

    public void visit(FolderArtifact entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getMetadata());
        wGetVisitor1().visit(entity.getArtifacts());
    }

    public void visit(FileArtifact entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getMetadata());
        wGetVisitor1().visit(entity.getContent());
    }

    public void visit(Natures entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Metadata entity) {
        wGetVisitor1().visit(entity.getCopyright());
        wGetVisitor1().visit(entity.getLicense());
        wGetVisitor1().visit(entity.getAuthor());
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getPersistenceKitId());
    }

    public void visit(NameWithExtension entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExtension());
    }

    public void visit(Attributes entity) {
        for (Attribute child : entity)
            wGetVisitor1().visit(child);
    }
}
