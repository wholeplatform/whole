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

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class NullScope implements IBindingScope {
	public IBindingScope withSourceEntity(IEntity entity) {
		return this;
	}
	public IEntity getSourceEntity() {
		return null;
	}

	public static final NullScope instance = new NullScope();
	protected NullScope() {
	}

	public IBindingScope clone() {
		return instance;
	}
	public IBindingScope clone(ICloneContext cc) {
		return instance;
	}

	public Kind getKind() {
		return Kind.SCOPE;
	}

	public IBindingScope wTargetScope() {
		return this;
	}
	public IBindingScope wEnclosingScope() {
		throw new IllegalStateException("NullBindingManager");
	}

	public void wClear() {
	}

	public Set<String> wNames() {
		return new HashSet<String>();
	}

	public Set<String> wLocalNames() {
		return Collections.<String>emptySet();
	}

	public void wAddAll(IBindingScope scope) {
		throw new IllegalStateException("NullBindingManager");		
	}

	public IEntity wGet(String name) {
		return null;
	}
	public void wSet(String name, IEntity value) {
		throw BindingManagerFactory.instance.createNoBindingException(name);		
	}		
	public void wDef(String name, IEntity value) {
		throw new IllegalStateException("NullBindingManager");		
	}		
	public boolean wIsSet(String name) {
		return false;		
	}
	public void wUnset(String name) {
	}

	public IBindingScope wFindScope(String name) {
		return VoidScope.instance;
	}

	public boolean wBooleanValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public byte wByteValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public char wCharValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public Date wDateValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public double wDoubleValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public EnumValue wEnumValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public float wFloatValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public Object wGetValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public int wIntValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public long wLongValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public short wShortValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public String wStringValue(String name) {
		throw new IllegalStateException("NullBindingManager");		
	}

	public void wSetValue(String name, boolean value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, byte value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, char value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, Date value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, double value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, EnumValue value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, float value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, int value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, long value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, Object value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, short value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wSetValue(String name, String value) {
		throw new IllegalStateException("NullBindingManager");		
	}

	public void wDefValue(String name, boolean value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, byte value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, char value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, Date value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, double value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, EnumValue value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, float value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, int value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, long value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, Object value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, short value) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void wDefValue(String name, String value) {
		throw new IllegalStateException("NullBindingManager");		
	}

	public IBindingScope wResultScope() {
		return null;
	}
	public void wSetResultScope(IBindingScope scope) {
	}

	public boolean hasResultIterator() {
		return false;
	}
	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void setResultIterator(IEntityIterator<?> resultIterator) {
		throw new IllegalStateException("NullBindingManager");		
	}
	public IEntity getResult() {
		throw new IllegalStateException("NullBindingManager");		
	}
	public void setResult(IEntity value) {
		throw new IllegalStateException("NullBindingManager");		
	}

	public String toString() {
		return "--- null scope ---\n";
	}
}
