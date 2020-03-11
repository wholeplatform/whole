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

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.migrations.model.MigrateLanguage;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.migrations.model.LanguageTest;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.model.LanguageMigrationRules;
import org.whole.lang.migrations.model.Registry;

/**
 *  @generator Whole
 */
public class MigrateLanguageImpl extends AbstractSimpleEntity implements MigrateLanguage {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<MigrateLanguage> wGetEntityDescriptor() {
        return MigrationsEntityDescriptorEnum.MigrateLanguage;
    }

    public int wGetEntityOrd() {
        return MigrationsEntityDescriptorEnum.MigrateLanguage_ord;
    }

    public void accept(IMigrationsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private LanguageTest source;

    public LanguageTest getSource() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.source, source);
    }

    public void setSource(LanguageTest source) {
        notifyChanged(MigrationsFeatureDescriptorEnum.source, this.source, this.source = source);
    }
    private LanguageTest target;

    public LanguageTest getTarget() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.target, target);
    }

    public void setTarget(LanguageTest target) {
        notifyChanged(MigrationsFeatureDescriptorEnum.target, this.target, this.target = target);
    }
    private LanguageMigrationRules rules;

    public LanguageMigrationRules getRules() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.rules, rules);
    }

    public void setRules(LanguageMigrationRules rules) {
        notifyChanged(MigrationsFeatureDescriptorEnum.rules, this.rules, this.rules = rules);
    }
    private Registry registry;

    public Registry getRegistry() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.registry, registry);
    }

    public void setRegistry(Registry registry) {
        notifyChanged(MigrationsFeatureDescriptorEnum.registry, this.registry, this.registry = registry);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSource().wGetAdaptee(false);
            case 1 :
            return getTarget().wGetAdaptee(false);
            case 2 :
            return getRules().wGetAdaptee(false);
            case 3 :
            return getRegistry().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSource(value.wGetAdapter(MigrationsEntityDescriptorEnum.LanguageTest));
            break;
            case 1 :
            setTarget(value.wGetAdapter(MigrationsEntityDescriptorEnum.LanguageTest));
            break;
            case 2 :
            setRules(value.wGetAdapter(MigrationsEntityDescriptorEnum.LanguageMigrationRules));
            break;
            case 3 :
            setRegistry(value.wGetAdapter(MigrationsEntityDescriptorEnum.Registry));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
