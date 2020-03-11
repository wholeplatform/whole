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

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.migrations.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class MigrateLanguageAdapter extends AbstractEntityAdapter implements MigrateLanguage {
    private static final long serialVersionUID = 1;

    public MigrateLanguageAdapter(IEntity implementor) {
        super(implementor);
    }

    public MigrateLanguageAdapter() {
    }

    public void accept(IMigrationsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<MigrateLanguage> wGetEntityDescriptor() {
        return MigrationsEntityDescriptorEnum.MigrateLanguage;
    }

    public LanguageTest getSource() {
        return wGet(MigrationsFeatureDescriptorEnum.source).wGetAdapter(MigrationsEntityDescriptorEnum.LanguageTest);
    }

    public void setSource(LanguageTest source) {
        wSet(MigrationsFeatureDescriptorEnum.source, source);
    }

    public LanguageTest getTarget() {
        return wGet(MigrationsFeatureDescriptorEnum.target).wGetAdapter(MigrationsEntityDescriptorEnum.LanguageTest);
    }

    public void setTarget(LanguageTest target) {
        wSet(MigrationsFeatureDescriptorEnum.target, target);
    }

    public LanguageMigrationRules getRules() {
        return wGet(MigrationsFeatureDescriptorEnum.rules).wGetAdapter(MigrationsEntityDescriptorEnum.LanguageMigrationRules);
    }

    public void setRules(LanguageMigrationRules rules) {
        wSet(MigrationsFeatureDescriptorEnum.rules, rules);
    }

    public Registry getRegistry() {
        return wGet(MigrationsFeatureDescriptorEnum.registry).wGetAdapter(MigrationsEntityDescriptorEnum.Registry);
    }

    public void setRegistry(Registry registry) {
        wSet(MigrationsFeatureDescriptorEnum.registry, registry);
    }
}
