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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ReusablesForwardStrategyVisitor extends GenericForwardStrategyVisitor<IReusablesVisitor> implements IReusablesVisitor {

    public ReusablesForwardStrategyVisitor() {
        this(new ReusablesIdentityVisitor());
    }

    public ReusablesForwardStrategyVisitor(IReusablesVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IReusablesEntity) entity).accept(this);
    }

    public void visit(Adapt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Reuse entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Synch entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Include entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Reusables entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReferenceStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Resource entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Registry entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WorkspacePath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FileSystemPath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassPathURI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(URI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Persistence entity) {
        wGetStrategy().visit(entity);
    }
}
