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
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractFilterScope extends AbstractDelegatingScope implements INestableScope {
	private Set<String> filterNames;
	private boolean filterEnabled = true;

	protected AbstractFilterScope(Set<String> filterNames) {
		super(NullScope.instance);

		this.filterNames = filterNames;
	}

	@Override
	public IBindingScope clone(ICloneContext cc) {
		AbstractFilterScope scope = (AbstractFilterScope) super.clone(cc);
		scope.filterNames = new HashSet<String>(filterNames);
		return scope;
	}

	public Kind getKind() {
		return Kind.INNER_SCOPE_ADAPTER;
	}

	public IBindingScope wTargetScope() {
		return this;
	}
	public final IBindingScope wEnclosingScope() {
		return wDelegateScope();
	}
	public final AbstractFilterScope wWithEnclosingScope(IBindingScope enclosingScope) {
		wSetDelegateScope(enclosingScope);
		return this;
	}

	public Set<String> getFilterNames() {
		return filterNames;
	}
	public void setFilterNames(Set<String> filterNames) {
		this.filterNames = filterNames;
	}

	public boolean isFilterEnabled() {
		return filterEnabled;
	}
	public void setFilterEnabled(boolean filterEnabled) {
		this.filterEnabled = filterEnabled;
	}

	protected final boolean isFiltered(String name, boolean forReading) {
		return isFilterEnabled() && isHidden(name, forReading);
	}
	protected abstract boolean isHidden(String name, boolean forReading);

	public void wClear() {
		for (String name : wNames())
			super.wUnset(name);
	}

	public boolean wBooleanValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wBooleanValue(name);
	}

	public byte wByteValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wByteValue(name);
	}

	public char wCharValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wCharValue(name);
	}

	public Date wDateValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wDateValue(name);
	}

	public double wDoubleValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wDoubleValue(name);
	}

	public EnumValue wEnumValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wEnumValue(name);
	}

	public float wFloatValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wFloatValue(name);
	}

	public IEntity wGet(String name) {
		if (isFiltered(name, true))
			return null;//throw new IllegalArgumentException("FilterBindingManager");
		return super.wGet(name);
	}

	public Object wGetValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wGetValue(name);
	}

	public int wIntValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wIntValue(name);
	}

	public boolean wIsSet(String name) {
		if (isFiltered(name, true))
			return false;
		return super.wIsSet(name);
	}

	public long wLongValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wLongValue(name);
	}

	public void wSet(String name, IEntity value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSet(name, value);
	}

	public void wDef(String name, IEntity value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDef(name, value);
	}

	public void wSetValue(String name, boolean value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, byte value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, char value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, Date value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, double value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, EnumValue value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, float value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, int value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, long value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, Object value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, short value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wSetValue(String name, String value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wSetValue(name, value);
	}

	public void wDefValue(String name, boolean value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, byte value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, char value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, Date value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, double value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, EnumValue value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, float value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, int value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, long value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, Object value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, short value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public void wDefValue(String name, String value) {
		if (isFiltered(name, false))
			throw new IllegalArgumentException("FilterBindingManager");
		super.wDefValue(name, value);
	}

	public short wShortValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wShortValue(name);
	}

	public String wStringValue(String name) {
		if (isFiltered(name, true))
			throw new IllegalArgumentException("FilterBindingManager");
		return super.wStringValue(name);
	}

	public void wUnset(String name) {
		if (isFiltered(name, false))
			return;
		super.wUnset(name);
	}

	@Override
	public void wSetResultScope(IBindingScope scope) {
		super.wSetResultScope(scope != this ? scope : scope.wEnclosingScope());
	}

	public String toString() {
		SortedSet<String> treeSet = new TreeSet<String>(getFilterNames());
		StringBuilder sb = new StringBuilder();
		sb.append("--- begin ");
		sb.append(filterName());
		sb.append(" scope ---\n");
		sb.append("--- filter names: ");
		sb.append(treeSet);
		sb.append('\n');
		sb.append(super.toString());
		sb.append("--- end filter scope -----\n");
		return sb.toString();
	}
	protected String filterName() {
		return "filter";
	}

}
