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
package org.whole.lang.migrations.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.model.*;
import org.whole.lang.migrations.visitors.MigrationsIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;

/**
 *  @generator Whole
 */
public class MigrationsNotationsPartFactoryVisitor extends MigrationsIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((IMigrationsEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(IMigrationsEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(Library entity) {
        part = new LibraryPart();
    }

    @Override
    public void visit(MigrationFunctions entity) {
        part = new MigrationFunctionsPart();
    }

    @Override
    public void visit(MigrationFunction entity) {
        part = new MigrationFunctionPart();
    }

    @Override
    public void visit(MigrationRules entity) {
        part = new MigrationRulesPart();
    }

    @Override
    public void visit(MigratePatternLanguage entity) {
        part = new MigratePatternLanguagePart();
    }

    @Override
    public void visit(MigrateLanguage entity) {
        part = new MigrateLanguagePart();
    }

    @Override
    public void visit(LanguageMigrationRules entity) {
        part = new LanguageMigrationRulesPart();
    }

    @Override
    public void visit(MigrateEntityPattern entity) {
        part = new MigrateEntityPatternPart();
    }

    @Override
    public void visit(MigrateEntity entity) {
        part = new MigrateEntityPart();
    }

    @Override
    public void visit(MigrateFeatures entity) {
        part = new MigrateFeaturesPart();
    }

    @Override
    public void visit(MigrateFeature entity) {
        part = new MigrateFeaturePart();
    }

    @Override
    public void visit(MigratePath entity) {
        part = new MigratePathPart();
    }

    @Override
    public void visit(Source entity) {
        part = new SourcePart();
    }

    @Override
    public void visit(Target entity) {
        part = new TargetPart();
    }

    @Override
    public void visit(FeatureReference entity) {
        part = new FeatureReferencePart();
    }
}
