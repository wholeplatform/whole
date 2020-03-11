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
package org.whole.lang.migrations.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class MigrationsGenericBuilderAdapter extends GenericIdentityBuilder {
    private IMigrationsBuilder specificBuilder;

    public MigrationsGenericBuilderAdapter(IMigrationsBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public MigrationsGenericBuilderAdapter(IMigrationsBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case MigrationsFeatureDescriptorEnum.uri_ord :
            specificBuilder.uri();
            break;
            case MigrationsFeatureDescriptorEnum.namespace_ord :
            specificBuilder.namespace();
            break;
            case MigrationsFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case MigrationsFeatureDescriptorEnum.artifacts_ord :
            specificBuilder.artifacts();
            break;
            case MigrationsFeatureDescriptorEnum.rules_ord :
            specificBuilder.rules();
            break;
            case MigrationsFeatureDescriptorEnum.functions_ord :
            specificBuilder.functions();
            break;
            case MigrationsFeatureDescriptorEnum.label_ord :
            specificBuilder.label();
            break;
            case MigrationsFeatureDescriptorEnum.source_ord :
            specificBuilder.source();
            break;
            case MigrationsFeatureDescriptorEnum.target_ord :
            specificBuilder.target();
            break;
            case MigrationsFeatureDescriptorEnum.registry_ord :
            specificBuilder.registry();
            break;
            case MigrationsFeatureDescriptorEnum.when_ord :
            specificBuilder.when();
            break;
            case MigrationsFeatureDescriptorEnum.path_ord :
            specificBuilder.path();
            break;
            case MigrationsFeatureDescriptorEnum.feature_ord :
            specificBuilder.feature();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case MigrationsEntityDescriptorEnum.MigrationFrame_ord :
            specificBuilder.MigrationFrame();
            break;
            case MigrationsEntityDescriptorEnum.Library_ord :
            specificBuilder.Library();
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunctions_ord :
            specificBuilder.MigrationFunctions();
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunction_ord :
            specificBuilder.MigrationFunction();
            break;
            case MigrationsEntityDescriptorEnum.MigrationRules_ord :
            specificBuilder.MigrationRules();
            break;
            case MigrationsEntityDescriptorEnum.MigratePatternLanguage_ord :
            specificBuilder.MigratePatternLanguage();
            break;
            case MigrationsEntityDescriptorEnum.MigrateLanguage_ord :
            specificBuilder.MigrateLanguage();
            break;
            case MigrationsEntityDescriptorEnum.LanguageMigrationRules_ord :
            specificBuilder.LanguageMigrationRules();
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntityPattern_ord :
            specificBuilder.MigrateEntityPattern();
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntity_ord :
            specificBuilder.MigrateEntity();
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeatures_ord :
            specificBuilder.MigrateFeatures();
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeature_ord :
            specificBuilder.MigrateFeature();
            break;
            case MigrationsEntityDescriptorEnum.MigratePath_ord :
            specificBuilder.MigratePath();
            break;
            case MigrationsEntityDescriptorEnum.Source_ord :
            specificBuilder.Source();
            break;
            case MigrationsEntityDescriptorEnum.Target_ord :
            specificBuilder.Target();
            break;
            case MigrationsEntityDescriptorEnum.FeatureReference_ord :
            specificBuilder.FeatureReference();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case MigrationsEntityDescriptorEnum.MigrationFrame_ord :
            specificBuilder.MigrationFrame_();
            break;
            case MigrationsEntityDescriptorEnum.Library_ord :
            specificBuilder.Library_();
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunctions_ord :
            specificBuilder.MigrationFunctions_();
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunction_ord :
            specificBuilder.MigrationFunction_();
            break;
            case MigrationsEntityDescriptorEnum.MigrationRules_ord :
            specificBuilder.MigrationRules_();
            break;
            case MigrationsEntityDescriptorEnum.MigratePatternLanguage_ord :
            specificBuilder.MigratePatternLanguage_();
            break;
            case MigrationsEntityDescriptorEnum.MigrateLanguage_ord :
            specificBuilder.MigrateLanguage_();
            break;
            case MigrationsEntityDescriptorEnum.LanguageMigrationRules_ord :
            specificBuilder.LanguageMigrationRules_();
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntityPattern_ord :
            specificBuilder.MigrateEntityPattern_();
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntity_ord :
            specificBuilder.MigrateEntity_();
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeatures_ord :
            specificBuilder.MigrateFeatures_();
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeature_ord :
            specificBuilder.MigrateFeature_();
            break;
            case MigrationsEntityDescriptorEnum.MigratePath_ord :
            specificBuilder.MigratePath_();
            break;
            case MigrationsEntityDescriptorEnum.Source_ord :
            specificBuilder.Source_();
            break;
            case MigrationsEntityDescriptorEnum.Target_ord :
            specificBuilder.Target_();
            break;
            case MigrationsEntityDescriptorEnum.FeatureReference_ord :
            specificBuilder.FeatureReference_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case MigrationsEntityDescriptorEnum.MigrationFrame_ord :
            specificBuilder._MigrationFrame();
            break;
            case MigrationsEntityDescriptorEnum.Library_ord :
            specificBuilder._Library();
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunctions_ord :
            specificBuilder._MigrationFunctions();
            break;
            case MigrationsEntityDescriptorEnum.MigrationFunction_ord :
            specificBuilder._MigrationFunction();
            break;
            case MigrationsEntityDescriptorEnum.MigrationRules_ord :
            specificBuilder._MigrationRules();
            break;
            case MigrationsEntityDescriptorEnum.MigratePatternLanguage_ord :
            specificBuilder._MigratePatternLanguage();
            break;
            case MigrationsEntityDescriptorEnum.MigrateLanguage_ord :
            specificBuilder._MigrateLanguage();
            break;
            case MigrationsEntityDescriptorEnum.LanguageMigrationRules_ord :
            specificBuilder._LanguageMigrationRules();
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntityPattern_ord :
            specificBuilder._MigrateEntityPattern();
            break;
            case MigrationsEntityDescriptorEnum.MigrateEntity_ord :
            specificBuilder._MigrateEntity();
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeatures_ord :
            specificBuilder._MigrateFeatures();
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeature_ord :
            specificBuilder._MigrateFeature();
            break;
            case MigrationsEntityDescriptorEnum.MigratePath_ord :
            specificBuilder._MigratePath();
            break;
            case MigrationsEntityDescriptorEnum.Source_ord :
            specificBuilder._Source();
            break;
            case MigrationsEntityDescriptorEnum.Target_ord :
            specificBuilder._Target();
            break;
            case MigrationsEntityDescriptorEnum.FeatureReference_ord :
            specificBuilder._FeatureReference();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case MigrationsEntityDescriptorEnum.MigrationFunctions_ord :
            specificBuilder.MigrationFunctions_(initialCapacity);
            break;
            case MigrationsEntityDescriptorEnum.MigrationRules_ord :
            specificBuilder.MigrationRules_(initialCapacity);
            break;
            case MigrationsEntityDescriptorEnum.LanguageMigrationRules_ord :
            specificBuilder.LanguageMigrationRules_(initialCapacity);
            break;
            case MigrationsEntityDescriptorEnum.MigrateFeatures_ord :
            specificBuilder.MigrateFeatures_(initialCapacity);
            break;
        }
    }
}
