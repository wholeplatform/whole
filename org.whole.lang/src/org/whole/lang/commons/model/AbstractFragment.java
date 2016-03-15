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
package org.whole.lang.commons.model;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.model.AbstractEntity;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.IFragmentModel;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.ReflectionFactory;






/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractFragment extends AbstractEntity implements Fragment {
	protected void wSetChildrenModel(IFragmentModel model) {
	    IFragmentModel newModel = (IFragmentModel) model.clone();
	    newModel.setFragment(this);
	    ((InternalIEntity) rootEntity).wSetModel(newModel);
    }

	public IEntity wGetRoot() {
		return wGet(0);
	}

	protected Any rootEntity;

	public Any getRootEntity() {
		return notifyRequested(CommonsFeatureDescriptorEnum.rootEntity,
				rootEntity);
	}
	public void setRootEntity(Any rootEntity) {
		ReflectionFactory.makeRootEntity(rootEntity, wGetActualModel());
		notifyChanged(CommonsFeatureDescriptorEnum.rootEntity, this.rootEntity,
				this.rootEntity = rootEntity);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getRootEntity().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setRootEntity(value.wGetAdapter(CommonsEntityDescriptorEnum.Any));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
