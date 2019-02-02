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
package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.FilterFamily;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.PackageName;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.model.Description;
import org.whole.lang.tests.model.Name;
import org.whole.lang.tests.model.FilterRules;

/**
 *  @generator Whole
 */
public class FilterFamilyImpl extends AbstractSimpleEntity implements FilterFamily {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FilterFamily> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.FilterFamily;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.FilterFamily_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wHashCode() {
        return getPackageName().wHashCode() + 29 * getName().wHashCode();
    }

    public boolean wEquals(IEntity entity) {
        if (this == entity)
            return true;
        if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
            return false;
        try {
            return getPackageName().wEquals(entity.wGet(TestsFeatureDescriptorEnum.packageName)) && getName().wEquals(entity.wGet(TestsFeatureDescriptorEnum.name));
        } catch (Exception e) {
            return false;
        }
    }

    protected void toString(StringBuffer buffer) {
        buffer.append("packageName=");
        buffer.append(packageName);
        buffer.append("name=");
        buffer.append(name);
    }
    private PackageName packageName;

    public PackageName getPackageName() {
        return notifyRequested(TestsFeatureDescriptorEnum.packageName, packageName);
    }

    public void setPackageName(PackageName packageName) {
        notifyChanged(TestsFeatureDescriptorEnum.packageName, this.packageName, this.packageName = packageName);
    }
    private Description description;

    public Description getDescription() {
        return notifyRequested(TestsFeatureDescriptorEnum.description, description);
    }

    public void setDescription(Description description) {
        notifyChanged(TestsFeatureDescriptorEnum.description, this.description, this.description = description);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(TestsFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(TestsFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private FilterRules filterRules;

    public FilterRules getFilterRules() {
        return notifyRequested(TestsFeatureDescriptorEnum.filterRules, filterRules);
    }

    public void setFilterRules(FilterRules filterRules) {
        notifyChanged(TestsFeatureDescriptorEnum.filterRules, this.filterRules, this.filterRules = filterRules);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getPackageName().wGetAdaptee(false);
            case 1 :
            return getDescription().wGetAdaptee(false);
            case 2 :
            return getName().wGetAdaptee(false);
            case 3 :
            return getFilterRules().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPackageName(value.wGetAdapter(TestsEntityDescriptorEnum.PackageName));
            break;
            case 1 :
            setDescription(value.wGetAdapter(TestsEntityDescriptorEnum.Description));
            break;
            case 2 :
            setName(value.wGetAdapter(TestsEntityDescriptorEnum.Name));
            break;
            case 3 :
            setFilterRules(value.wGetAdapter(TestsEntityDescriptorEnum.FilterRules));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
