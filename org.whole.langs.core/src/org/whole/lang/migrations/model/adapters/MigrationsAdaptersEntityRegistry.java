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
package org.whole.lang.migrations.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class MigrationsAdaptersEntityRegistry extends AbstractEntityRegistry {

    public MigrationsAdaptersEntityRegistry() {
        super(MigrationsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new MigrationFrameAdapter());
        put(new LibraryAdapter());
        put(new MigrationFunctionsAdapter());
        put(new MigrationFunctionAdapter());
        put(new MigrationRulesAdapter());
        put(new MigratePatternLanguageAdapter());
        put(new MigrateLanguageAdapter());
        put(new LanguageMigrationRulesAdapter());
        put(new LanguageMigrationRuleAdapter());
        put(new MigrateEntityPatternAdapter());
        put(new MigrateEntityAdapter());
        put(new EntityMigrationRulesAdapter());
        put(new MigrateFeaturesAdapter());
        put(new MigrateFeatureAdapter());
        put(new MigratePathAdapter());
        put(new SourceAdapter());
        put(new TargetAdapter());
        put(new FeatureReferenceAdapter());
        put(new TypeTestAdapter());
        put(new LabelAdapter());
        put(new MigrationRuleAdapter());
        put(new RegistryAdapter());
        put(new URIAdapter());
        put(new NamespaceAdapter());
        put(new NameAdapter());
        put(new FeatureStepAdapter());
        put(new ExpressionAdapter());
        put(new LanguageTestAdapter());
        put(new WorkspaceAdapter());
    }
}
