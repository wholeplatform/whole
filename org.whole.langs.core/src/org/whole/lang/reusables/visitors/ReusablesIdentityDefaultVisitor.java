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
public class ReusablesIdentityDefaultVisitor extends ReusablesIdentityVisitor {

    public void visit(IReusablesEntity entity) {
    }

    public void visit(Reusable entity) {
    }

    public void visit(Adapt entity) {
        visit((IReusablesEntity) entity);
        visit((Reusable) entity);
    }

    public void visit(Reuse entity) {
        visit((IReusablesEntity) entity);
        visit((Reusable) entity);
    }

    public void visit(Synch entity) {
        visit((IReusablesEntity) entity);
        visit((Reuse) entity);
    }

    public void visit(Include entity) {
        visit((IReusablesEntity) entity);
    }

    public void visit(Reusables entity) {
        visit((IReusablesEntity) entity);
        visit((Reusable) entity);
    }

    public void visit(Source entity) {
    }

    public void visit(PathExpression entity) {
        visit((Source) entity);
        visit((Locator) entity);
    }

    public void visit(Locator entity) {
    }

    public void visit(StepExpression entity) {
        visit((PathExpression) entity);
    }

    public void visit(ReferenceStep entity) {
        visit((IReusablesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Resource entity) {
        visit((IReusablesEntity) entity);
        visit((Source) entity);
    }

    public void visit(Registry entity) {
        visit((IReusablesEntity) entity);
        visit((Source) entity);
    }

    public void visit(WorkspacePath entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(FileSystemPath entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(ClassPathURI entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(URI entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(Persistence entity) {
        visit((IReusablesEntity) entity);
    }
}
