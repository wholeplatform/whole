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
package org.whole.lang.events;

import java.util.Date;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractValidationRule<E extends IEntity> extends IdentityChangeEventHandler {
	protected FeatureDescriptor fd;
	
	protected AbstractValidationRule(FeatureDescriptor fd) {
		this.fd = fd;
	}

	protected void validateChanged(E entity, IEntity oldValue, IEntity newValue) {
		oldValue.wRemoveChangeEventHandler(this);
		newValue.wAddChangeEventHandler(this);
		validateChanged(entity, newValue);
	}
	protected void validateChanged(E entity, IEntity newValue) {
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			IEntity oldValue, IEntity newValue) {
		if (this.fd.equals(fd))
			validateChanged((E) entity, oldValue, newValue);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			int index, IEntity oldValue, IEntity newValue) {
		if (this.fd.equals(fd))
			validateChanged((E) entity, oldValue, newValue);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyAdded(IEntity entity, FeatureDescriptor fd,
			int index, IEntity newValue) {
		if (this.fd.equals(fd))
			validateChanged((E) entity, null, newValue);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyRemoved(IEntity entity, FeatureDescriptor fd,
			int index, IEntity oldValue) {
		if (this.fd.equals(fd))
			validateChanged((E) entity, oldValue, null);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			boolean oldValue, boolean newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			byte oldValue, byte newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			char oldValue, char newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			double oldValue, double newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			float oldValue, float newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			int oldValue, int newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			long oldValue, long newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			short oldValue, short newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			String oldValue, String newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			Date oldValue, Date newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			EnumValue oldValue, EnumValue newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void notifyChanged(IEntity entity, FeatureDescriptor fd,
			Object oldValue, Object newValue) {
		validateChanged((E) entity.wGetParent(), entity);
	}
}
