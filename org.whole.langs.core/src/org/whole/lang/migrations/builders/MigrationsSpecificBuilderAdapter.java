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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class MigrationsSpecificBuilderAdapter extends GenericBuilderContext implements IMigrationsBuilder {

    public MigrationsSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public MigrationsSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void feature() {
        wFeature(MigrationsFeatureDescriptorEnum.feature);
    }

    public void path() {
        wFeature(MigrationsFeatureDescriptorEnum.path);
    }

    public void when() {
        wFeature(MigrationsFeatureDescriptorEnum.when);
    }

    public void registry() {
        wFeature(MigrationsFeatureDescriptorEnum.registry);
    }

    public void target() {
        wFeature(MigrationsFeatureDescriptorEnum.target);
    }

    public void source() {
        wFeature(MigrationsFeatureDescriptorEnum.source);
    }

    public void label() {
        wFeature(MigrationsFeatureDescriptorEnum.label);
    }

    public void functions() {
        wFeature(MigrationsFeatureDescriptorEnum.functions);
    }

    public void rules() {
        wFeature(MigrationsFeatureDescriptorEnum.rules);
    }

    public void artifacts() {
        wFeature(MigrationsFeatureDescriptorEnum.artifacts);
    }

    public void name() {
        wFeature(MigrationsFeatureDescriptorEnum.name);
    }

    public void namespace() {
        wFeature(MigrationsFeatureDescriptorEnum.namespace);
    }

    public void uri() {
        wFeature(MigrationsFeatureDescriptorEnum.uri);
    }

    public void visit() {
    }

    public void MigrationFrame() {
        wEntity(MigrationsEntityDescriptorEnum.MigrationFrame);
    }

    public void MigrationFrame_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrationFrame);
    }

    public void _MigrationFrame() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrationFrame);
    }

    public void Library() {
        wEntity(MigrationsEntityDescriptorEnum.Library);
    }

    public void Library_() {
        wEntity_(MigrationsEntityDescriptorEnum.Library);
    }

    public void _Library() {
        _wEntity(MigrationsEntityDescriptorEnum.Library);
    }

    public void MigrationFunctions() {
        wEntity(MigrationsEntityDescriptorEnum.MigrationFunctions);
    }

    public void MigrationFunctions_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrationFunctions);
    }

    public void MigrationFunctions_(int initialCapacity) {
        wEntity_(MigrationsEntityDescriptorEnum.MigrationFunctions, initialCapacity);
    }

    public void _MigrationFunctions() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrationFunctions);
    }

    public void MigrationFunction() {
        wEntity(MigrationsEntityDescriptorEnum.MigrationFunction);
    }

    public void MigrationFunction_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrationFunction);
    }

    public void _MigrationFunction() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrationFunction);
    }

    public void MigrationRules() {
        wEntity(MigrationsEntityDescriptorEnum.MigrationRules);
    }

    public void MigrationRules_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrationRules);
    }

    public void MigrationRules_(int initialCapacity) {
        wEntity_(MigrationsEntityDescriptorEnum.MigrationRules, initialCapacity);
    }

    public void _MigrationRules() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrationRules);
    }

    public void MigratePatternLanguage() {
        wEntity(MigrationsEntityDescriptorEnum.MigratePatternLanguage);
    }

    public void MigratePatternLanguage_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigratePatternLanguage);
    }

    public void _MigratePatternLanguage() {
        _wEntity(MigrationsEntityDescriptorEnum.MigratePatternLanguage);
    }

    public void MigrateLanguage() {
        wEntity(MigrationsEntityDescriptorEnum.MigrateLanguage);
    }

    public void MigrateLanguage_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrateLanguage);
    }

    public void _MigrateLanguage() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrateLanguage);
    }

    public void LanguageMigrationRules() {
        wEntity(MigrationsEntityDescriptorEnum.LanguageMigrationRules);
    }

    public void LanguageMigrationRules_() {
        wEntity_(MigrationsEntityDescriptorEnum.LanguageMigrationRules);
    }

    public void LanguageMigrationRules_(int initialCapacity) {
        wEntity_(MigrationsEntityDescriptorEnum.LanguageMigrationRules, initialCapacity);
    }

    public void _LanguageMigrationRules() {
        _wEntity(MigrationsEntityDescriptorEnum.LanguageMigrationRules);
    }

    public void MigrateEntityPattern() {
        wEntity(MigrationsEntityDescriptorEnum.MigrateEntityPattern);
    }

    public void MigrateEntityPattern_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrateEntityPattern);
    }

    public void _MigrateEntityPattern() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrateEntityPattern);
    }

    public void MigrateEntity() {
        wEntity(MigrationsEntityDescriptorEnum.MigrateEntity);
    }

    public void MigrateEntity_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrateEntity);
    }

    public void _MigrateEntity() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrateEntity);
    }

    public void MigrateFeatures() {
        wEntity(MigrationsEntityDescriptorEnum.MigrateFeatures);
    }

    public void MigrateFeatures_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrateFeatures);
    }

    public void MigrateFeatures_(int initialCapacity) {
        wEntity_(MigrationsEntityDescriptorEnum.MigrateFeatures, initialCapacity);
    }

    public void _MigrateFeatures() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrateFeatures);
    }

    public void MigrateFeature() {
        wEntity(MigrationsEntityDescriptorEnum.MigrateFeature);
    }

    public void MigrateFeature_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigrateFeature);
    }

    public void _MigrateFeature() {
        _wEntity(MigrationsEntityDescriptorEnum.MigrateFeature);
    }

    public void MigratePath() {
        wEntity(MigrationsEntityDescriptorEnum.MigratePath);
    }

    public void MigratePath_() {
        wEntity_(MigrationsEntityDescriptorEnum.MigratePath);
    }

    public void _MigratePath() {
        _wEntity(MigrationsEntityDescriptorEnum.MigratePath);
    }

    public void Source() {
        wEntity(MigrationsEntityDescriptorEnum.Source);
    }

    public void Source_() {
        wEntity_(MigrationsEntityDescriptorEnum.Source);
    }

    public void _Source() {
        _wEntity(MigrationsEntityDescriptorEnum.Source);
    }

    public void Target() {
        wEntity(MigrationsEntityDescriptorEnum.Target);
    }

    public void Target_() {
        wEntity_(MigrationsEntityDescriptorEnum.Target);
    }

    public void _Target() {
        _wEntity(MigrationsEntityDescriptorEnum.Target);
    }

    public void FeatureReference() {
        wEntity(MigrationsEntityDescriptorEnum.FeatureReference);
    }

    public void FeatureReference_() {
        wEntity_(MigrationsEntityDescriptorEnum.FeatureReference);
    }

    public void _FeatureReference() {
        _wEntity(MigrationsEntityDescriptorEnum.FeatureReference);
    }
}
