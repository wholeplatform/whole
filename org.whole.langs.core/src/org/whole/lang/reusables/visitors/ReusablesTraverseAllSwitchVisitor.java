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
package org.whole.lang.reusables.visitors;

import org.whole.lang.reusables.visitors.ReusablesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.reusables.model.*;

/**
 *  @generator Whole
 */
public class ReusablesTraverseAllSwitchVisitor extends ReusablesIdentityUnaryVisitor<IVisitor> {

    public ReusablesTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Adapt entity) {
        wGetVisitor1().visit(entity.getOriginal());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getAdapted());
        wGetVisitor1().visit(entity.getAdaptedRevision());
    }

    public void visit(Reuse entity) {
        wGetVisitor1().visit(entity.getResource());
        wGetVisitor1().visit(entity.getOriginal());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getAdapted());
        wGetVisitor1().visit(entity.getAdaptedRevision());
    }

    public void visit(Sync entity) {
        wGetVisitor1().visit(entity.getResource());
        wGetVisitor1().visit(entity.getOriginal());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getAdapted());
        wGetVisitor1().visit(entity.getAdaptedRevision());
        wGetVisitor1().visit(entity.getVariant());
        wGetVisitor1().visit(entity.getVariantRevision());
    }

    public void visit(Include entity) {
        wGetVisitor1().visit(entity.getResource());
    }

    public void visit(Reusables entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Workspace entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(FileSystem entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(Classpath entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(URL entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(Model entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(Registry entity) {
        wGetVisitor1().visit(entity.getRegistryUri());
        wGetVisitor1().visit(entity.getUri());
    }

    public void visit(Contents entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Folder entity) {
        wGetVisitor1().visit(entity.getPath());
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(File entity) {
        wGetVisitor1().visit(entity.getPath());
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(Exists entity) {
        wGetVisitor1().visit(entity.getResource());
    }

    public void visit(Delete entity) {
        wGetVisitor1().visit(entity.getResource());
    }

    public void visit(Load entity) {
        wGetVisitor1().visit(entity.getResource());
    }

    public void visit(Save entity) {
        wGetVisitor1().visit(entity.getResource());
    }

    public void visit(PathWithExtension entity) {
        wGetVisitor1().visit(entity.getPath());
        wGetVisitor1().visit(entity.getExtension());
    }

    public void visit(PathSegments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }
}
