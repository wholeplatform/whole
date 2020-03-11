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

import org.whole.lang.migrations.model.*;

/**
 *  @generator Whole
 */
public class MigrationsIdentityDefaultVisitor extends MigrationsIdentityVisitor {

    public void visit(IMigrationsEntity entity) {
    }

    public void visit(MigrationFrame entity) {
        visit((IMigrationsEntity) entity);
    }

    public void visit(Library entity) {
        visit((IMigrationsEntity) entity);
    }

    public void visit(MigrationFunctions entity) {
        visit((IMigrationsEntity) entity);
    }

    public void visit(MigrationFunction entity) {
        visit((IMigrationsEntity) entity);
    }

    public void visit(MigrationRules entity) {
        visit((IMigrationsEntity) entity);
    }

    public void visit(MigrationRule entity) {
    }

    public void visit(MigratePatternLanguage entity) {
        visit((IMigrationsEntity) entity);
        visit((MigrationRule) entity);
    }

    public void visit(MigrateLanguage entity) {
        visit((IMigrationsEntity) entity);
        visit((MigrationRule) entity);
    }

    public void visit(LanguageMigrationRules entity) {
        visit((IMigrationsEntity) entity);
    }

    public void visit(LanguageMigrationRule entity) {
        visit((MigrationRule) entity);
    }

    public void visit(MigrateEntityPattern entity) {
        visit((IMigrationsEntity) entity);
        visit((LanguageMigrationRule) entity);
    }

    public void visit(MigrateEntity entity) {
        visit((IMigrationsEntity) entity);
        visit((LanguageMigrationRule) entity);
    }

    public void visit(EntityMigrationRules entity) {
    }

    public void visit(MigrateFeatures entity) {
        visit((IMigrationsEntity) entity);
        visit((EntityMigrationRules) entity);
    }

    public void visit(MigrateFeature entity) {
        visit((IMigrationsEntity) entity);
    }

    public void visit(Expression entity) {
    }

    public void visit(MigratePath entity) {
        visit((IMigrationsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Source entity) {
        visit((IMigrationsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Target entity) {
        visit((IMigrationsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(FeatureReference entity) {
        visit((IMigrationsEntity) entity);
        visit((Expression) entity);
    }
}
