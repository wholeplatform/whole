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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.migrations.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class MigrationsForwardStrategyVisitor extends GenericForwardStrategyVisitor<IMigrationsVisitor> implements IMigrationsVisitor {

    public MigrationsForwardStrategyVisitor() {
        this(new MigrationsIdentityVisitor());
    }

    public MigrationsForwardStrategyVisitor(IMigrationsVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IMigrationsEntity) entity).accept(this);
    }

    public void visit(MigrationFrame entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Library entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrationFunctions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrationFunction entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrationRules entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigratePatternLanguage entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrateLanguage entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LanguageMigrationRules entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrateEntityPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrateEntity entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrateFeatures entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigrateFeature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MigratePath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Source entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Target entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FeatureReference entity) {
        wGetStrategy().visit(entity);
    }
}
