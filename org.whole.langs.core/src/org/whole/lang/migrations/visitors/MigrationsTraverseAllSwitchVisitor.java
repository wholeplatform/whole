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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.migrations.model.*;

/**
 *  @generator Whole
 */
public class MigrationsTraverseAllSwitchVisitor extends MigrationsIdentityUnaryVisitor<IVisitor> {

    public MigrationsTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(MigrationFrame entity) {
        wGetVisitor1().visit(entity.getUri());
        wGetVisitor1().visit(entity.getNamespace());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArtifacts());
        wGetVisitor1().visit(entity.getRules());
    }

    public void visit(Library entity) {
        wGetVisitor1().visit(entity.getUri());
        wGetVisitor1().visit(entity.getNamespace());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getFunctions());
    }

    public void visit(MigrationFunctions entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MigrationFunction entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getRules());
    }

    public void visit(MigrationRules entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MigratePatternLanguage entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getTarget());
        wGetVisitor1().visit(entity.getRules());
    }

    public void visit(MigrateLanguage entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getTarget());
        wGetVisitor1().visit(entity.getRules());
        wGetVisitor1().visit(entity.getRegistry());
    }

    public void visit(LanguageMigrationRules entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MigrateEntityPattern entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getTarget());
    }

    public void visit(MigrateEntity entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getTarget());
        wGetVisitor1().visit(entity.getRules());
        wGetVisitor1().visit(entity.getWhen());
    }

    public void visit(MigrateFeatures entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MigrateFeature entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getTarget());
    }

    public void visit(MigratePath entity) {
        wGetVisitor1().visit(entity.getPath());
    }

    public void visit(FeatureReference entity) {
        wGetVisitor1().visit(entity.getFeature());
    }
}
