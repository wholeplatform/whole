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

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.migrations.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class MigrationsIdentitySwitchVisitor extends AbstractVisitor implements IMigrationsVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case MigrationsEntityDescriptorEnum.MigrationFrame_ord :
            visit((MigrationFrame) entity);
            break;
            case MigrationsEntityDescriptorEnum.Library_ord :
            visit((Library) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunctions_ord :
            visit((MigrationFunctions) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunction_ord :
            visit((MigrationFunction) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrationRules_ord :
            visit((MigrationRules) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigratePatternLanguage_ord :
            visit((MigratePatternLanguage) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrateLanguage_ord :
            visit((MigrateLanguage) entity);
            break;
            case MigrationsEntityDescriptorEnum.LanguageMigrationRules_ord :
            visit((LanguageMigrationRules) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntityPattern_ord :
            visit((MigrateEntityPattern) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntity_ord :
            visit((MigrateEntity) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeatures_ord :
            visit((MigrateFeatures) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeature_ord :
            visit((MigrateFeature) entity);
            break;
            case MigrationsEntityDescriptorEnum.MigratePath_ord :
            visit((MigratePath) entity);
            break;
            case MigrationsEntityDescriptorEnum.Source_ord :
            visit((Source) entity);
            break;
            case MigrationsEntityDescriptorEnum.Target_ord :
            visit((Target) entity);
            break;
            case MigrationsEntityDescriptorEnum.FeatureReference_ord :
            visit((FeatureReference) entity);
            break;
        }
    }
}
