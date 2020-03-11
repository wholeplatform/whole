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

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.migrations.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class MigrationsIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IMigrationsVisitor {

    public MigrationsIdentityUnaryVisitor() {
        super(null);
    }

    public MigrationsIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IMigrationsEntity) entity).accept(this);
    }

    public void visit(MigrationFrame entity) {
    }

    public void visit(Library entity) {
    }

    public void visit(MigrationFunctions entity) {
    }

    public void visit(MigrationFunction entity) {
    }

    public void visit(MigrationRules entity) {
    }

    public void visit(MigratePatternLanguage entity) {
    }

    public void visit(MigrateLanguage entity) {
    }

    public void visit(LanguageMigrationRules entity) {
    }

    public void visit(MigrateEntityPattern entity) {
    }

    public void visit(MigrateEntity entity) {
    }

    public void visit(MigrateFeatures entity) {
    }

    public void visit(MigrateFeature entity) {
    }

    public void visit(MigratePath entity) {
    }

    public void visit(Source entity) {
    }

    public void visit(Target entity) {
    }

    public void visit(FeatureReference entity) {
    }
}
