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
package org.whole.lang.bindings;

import java.util.Date;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class VoidScope extends NullScope {
	public static final VoidScope instance = new VoidScope();
	protected VoidScope() {
	}

	public IBindingScope clone() {
		return instance;
	}
	public IBindingScope clone(ICloneContext cc) {
		return instance;
	}

	public IEnvironmentManager wGetEnvironmentManager() {
		throw new IllegalStateException("VoidScope");		
	}

	public void wAddAll(IBindingScope scope) {
	}

	public void wSet(String name, IEntity value) {
	}

	public void wDef(String name, IEntity value) {
	}

	public boolean wIsSet(String name) {
		return false;
	}

	public void wUnset(String name) {
	}

	public void wSetValue(String name, boolean value) {
	}

	public void wSetValue(String name, byte value) {
	}

	public void wSetValue(String name, char value) {
	}

	public void wSetValue(String name, double value) {
	}

	public void wSetValue(String name, float value) {
	}

	public void wSetValue(String name, int value) {
	}

	public void wSetValue(String name, long value) {
	}

	public void wSetValue(String name, short value) {
	}

	public void wSetValue(String name, String value) {
	}

	public void wSetValue(String name, Date value) {
	}

	public void wSetValue(String name, EnumValue value) {
	}

	public void wSetValue(String name, Object value) {
	}

	public void wDefValue(String name, boolean value) {
	}

	public void wDefValue(String name, byte value) {
	}

	public void wDefValue(String name, char value) {		
	}

	public void wDefValue(String name, double value) {
	}

	public void wDefValue(String name, float value) {
	}

	public void wDefValue(String name, int value) {
	}

	public void wDefValue(String name, long value) {
	}

	public void wDefValue(String name, short value) {
	}

	public void wDefValue(String name, String value) {
	}

	public void wDefValue(String name, Date value) {
	}

	public void wDefValue(String name, EnumValue value) {
	}

	public void wDefValue(String name, Object value) {
	}

	public boolean hasResultIterator() {
		return false;		
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return IteratorFactory.emptyIterator();
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
	}
	public IEntity getResult() {
		return null;
	}
	public void setResult(IEntity value) {
	}
}
