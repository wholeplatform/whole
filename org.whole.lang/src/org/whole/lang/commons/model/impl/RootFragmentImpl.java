/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.commons.model.impl;

import org.whole.lang.commons.model.AbstractFragment;
import org.whole.lang.commons.model.Any;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.StageDownFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.FragmentModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.ReflectionFactory;


/**
 * @author Riccardo Solmi
 */
public class RootFragmentImpl extends AbstractFragment implements RootFragment
		, StageDownFragment {
	private static final long serialVersionUID = 1L;

	public RootFragmentImpl() {}
	public RootFragmentImpl(IEntity fragment) {
		wSet(0, fragment);

        if (isContainment()) {
	        FragmentModel model = new FragmentModel(this);
	        model.setCompoundModel(fragment.wGetModel().getCompoundModel());
	        wSetModel(model);
        }
    }

    public EntityDescriptor<RootFragment> wGetEntityDescriptor() {
    	return CommonsEntityDescriptorEnum.RootFragment;
    }
	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.RootFragment_ord;
	}
    public EntityKinds wGetEntityKind() {
    	return EntityKinds.SIMPLE;//WAS STAGE_DOWN_FRAGMENT;
    }

	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit((RootFragment) this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public void setRootEntity(Any rootEntity) {
		if (isContainment())
			ReflectionFactory.makeRootEntity(rootEntity, wGetActualModel());
		notifyChanged(CommonsFeatureDescriptorEnum.rootEntity, this.rootEntity,
				this.rootEntity = rootEntity, isContainment());
	}
	public boolean isContainment() {
		return true;
	}

	public String toString() {
		return toDebugString();
	}
}
