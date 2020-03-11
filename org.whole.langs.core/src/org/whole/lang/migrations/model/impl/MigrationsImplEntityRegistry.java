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
package org.whole.lang.migrations.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class MigrationsImplEntityRegistry extends AbstractEntityRegistry {

    public MigrationsImplEntityRegistry() {
        super(MigrationsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new MigrationFrameImpl());
        put(new LibraryImpl());
        put(new MigrationFunctionsImpl());
        put(new MigrationFunctionImpl());
        put(new MigrationRulesImpl());
        put(new MigratePatternLanguageImpl());
        put(new MigrateLanguageImpl());
        put(new LanguageMigrationRulesImpl());
        put(new MigrateEntityPatternImpl());
        put(new MigrateEntityImpl());
        put(new MigrateFeaturesImpl());
        put(new MigrateFeatureImpl());
        put(new MigratePathImpl());
        put(new SourceImpl());
        put(new TargetImpl());
        put(new FeatureReferenceImpl());
    }
}
