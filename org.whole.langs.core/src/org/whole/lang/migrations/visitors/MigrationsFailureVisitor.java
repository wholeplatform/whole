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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class MigrationsFailureVisitor extends MigrationsIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(MigrationFrame entity) {
        throw new VisitException();
    }

    public void visit(Library entity) {
        throw new VisitException();
    }

    public void visit(MigrationFunctions entity) {
        throw new VisitException();
    }

    public void visit(MigrationFunction entity) {
        throw new VisitException();
    }

    public void visit(MigrationRules entity) {
        throw new VisitException();
    }

    public void visit(MigratePatternLanguage entity) {
        throw new VisitException();
    }

    public void visit(MigrateLanguage entity) {
        throw new VisitException();
    }

    public void visit(LanguageMigrationRules entity) {
        throw new VisitException();
    }

    public void visit(MigrateEntityPattern entity) {
        throw new VisitException();
    }

    public void visit(MigrateEntity entity) {
        throw new VisitException();
    }

    public void visit(MigrateFeatures entity) {
        throw new VisitException();
    }

    public void visit(MigrateFeature entity) {
        throw new VisitException();
    }

    public void visit(MigratePath entity) {
        throw new VisitException();
    }

    public void visit(Source entity) {
        throw new VisitException();
    }

    public void visit(Target entity) {
        throw new VisitException();
    }

    public void visit(FeatureReference entity) {
        throw new VisitException();
    }
}
