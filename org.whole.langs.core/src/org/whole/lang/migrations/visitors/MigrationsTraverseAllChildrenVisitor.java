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
package org.whole.lang.migrations.visitors;

import org.whole.lang.migrations.visitors.MigrationsIdentityUnaryVisitor;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.migrations.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class MigrationsTraverseAllChildrenVisitor extends MigrationsIdentityUnaryVisitor<IMigrationsVisitor> {

    public MigrationsTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public MigrationsTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(MigrationFrame entity) {
        entity.getUri().accept(wGetVisitor1());
        entity.getNamespace().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getArtifacts().accept(wGetVisitor1());
        entity.getRules().accept(wGetVisitor1());
    }

    public void visit(Library entity) {
        entity.getUri().accept(wGetVisitor1());
        entity.getNamespace().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getFunctions().accept(wGetVisitor1());
    }

    public void visit(MigrationFunctions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MigrationFunction entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getRules().accept(wGetVisitor1());
    }

    public void visit(MigrationRules entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MigratePatternLanguage entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getTarget().accept(wGetVisitor1());
        entity.getRules().accept(wGetVisitor1());
    }

    public void visit(MigrateLanguage entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getTarget().accept(wGetVisitor1());
        entity.getRules().accept(wGetVisitor1());
        entity.getRegistry().accept(wGetVisitor1());
    }

    public void visit(LanguageMigrationRules entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MigrateEntityPattern entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getTarget().accept(wGetVisitor1());
    }

    public void visit(MigrateEntity entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getTarget().accept(wGetVisitor1());
        entity.getRules().accept(wGetVisitor1());
        entity.getWhen().accept(wGetVisitor1());
    }

    public void visit(MigrateFeatures entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MigrateFeature entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getTarget().accept(wGetVisitor1());
    }

    public void visit(MigratePath entity) {
        entity.getPath().accept(wGetVisitor1());
    }

    public void visit(FeatureReference entity) {
        entity.getFeature().accept(wGetVisitor1());
    }
}
