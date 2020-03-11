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

import org.whole.lang.builders.IBuilder;

/**
 *  @generator Whole
 */
public interface IMigrationsBuilder extends IBuilder {


    public void visit();

    public void feature();

    public void path();

    public void when();

    public void registry();

    public void target();

    public void source();

    public void label();

    public void functions();

    public void rules();

    public void artifacts();

    public void name();

    public void namespace();

    public void uri();

    public void MigrationFrame();

    public void MigrationFrame_();

    public void _MigrationFrame();

    public void Library();

    public void Library_();

    public void _Library();

    public void MigrationFunctions();

    public void MigrationFunctions_();

    public void MigrationFunctions_(int initialCapacity);

    public void _MigrationFunctions();

    public void MigrationFunction();

    public void MigrationFunction_();

    public void _MigrationFunction();

    public void MigrationRules();

    public void MigrationRules_();

    public void MigrationRules_(int initialCapacity);

    public void _MigrationRules();

    public void MigratePatternLanguage();

    public void MigratePatternLanguage_();

    public void _MigratePatternLanguage();

    public void MigrateLanguage();

    public void MigrateLanguage_();

    public void _MigrateLanguage();

    public void LanguageMigrationRules();

    public void LanguageMigrationRules_();

    public void LanguageMigrationRules_(int initialCapacity);

    public void _LanguageMigrationRules();

    public void MigrateEntityPattern();

    public void MigrateEntityPattern_();

    public void _MigrateEntityPattern();

    public void MigrateEntity();

    public void MigrateEntity_();

    public void _MigrateEntity();

    public void MigrateFeatures();

    public void MigrateFeatures_();

    public void MigrateFeatures_(int initialCapacity);

    public void _MigrateFeatures();

    public void MigrateFeature();

    public void MigrateFeature_();

    public void _MigrateFeature();

    public void MigratePath();

    public void MigratePath_();

    public void _MigratePath();

    public void Source();

    public void Source_();

    public void _Source();

    public void Target();

    public void Target_();

    public void _Target();

    public void FeatureReference();

    public void FeatureReference_();

    public void _FeatureReference();
}
