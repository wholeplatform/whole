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
import org.whole.lang.migrations.model.MigratePatternLanguage;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;
import org.whole.lang.migrations.visitors.IMigrationsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.migrations.model.URI;
import org.whole.lang.migrations.reflect.MigrationsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.migrations.model.LanguageMigrationRules;

/**
 *  @generator Whole
 */
public class MigratePatternLanguageImpl extends AbstractSimpleEntity implements MigratePatternLanguage {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<MigratePatternLanguage> wGetEntityDescriptor() {
        return MigrationsEntityDescriptorEnum.MigratePatternLanguage;
    }

    public int wGetEntityOrd() {
        return MigrationsEntityDescriptorEnum.MigratePatternLanguage_ord;
    }

    public void accept(IMigrationsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private URI source;

    public URI getSource() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.source, source);
    }

    public void setSource(URI source) {
        notifyChanged(MigrationsFeatureDescriptorEnum.source, this.source, this.source = source);
    }
    private URI target;

    public URI getTarget() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.target, target);
    }

    public void setTarget(URI target) {
        notifyChanged(MigrationsFeatureDescriptorEnum.target, this.target, this.target = target);
    }
    private LanguageMigrationRules rules;

    public LanguageMigrationRules getRules() {
        return notifyRequested(MigrationsFeatureDescriptorEnum.rules, rules);
    }

    public void setRules(LanguageMigrationRules rules) {
        notifyChanged(MigrationsFeatureDescriptorEnum.rules, this.rules, this.rules = rules);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSource().wGetAdaptee(false);
            case 1 :
            return getTarget().wGetAdaptee(false);
            case 2 :
            return getRules().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSource(value.wGetAdapter(MigrationsEntityDescriptorEnum.URI));
            break;
            case 1 :
            setTarget(value.wGetAdapter(MigrationsEntityDescriptorEnum.URI));
            break;
            case 2 :
            setRules(value.wGetAdapter(MigrationsEntityDescriptorEnum.LanguageMigrationRules));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
