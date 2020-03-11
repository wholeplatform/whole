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

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.migrations.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class MigrationsSequenceVisitor extends AbstractBinaryVisitor<IMigrationsVisitor> implements IMigrationsVisitor {

    public MigrationsSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
        super(visitor1, visitor2);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrationFrame entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Library entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrationFunctions entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrationFunction entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrationRules entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigratePatternLanguage entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrateLanguage entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(LanguageMigrationRules entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrateEntityPattern entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrateEntity entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrateFeatures entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigrateFeature entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(MigratePath entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Source entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Target entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(FeatureReference entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }
}
