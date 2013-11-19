/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.e4.ui.compatibility;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.IEnvironmentManager;
import org.whole.lang.bindings.INestableScope;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Enrico Persiani
 */
public class BindingManagerAdapter implements IStructuredSelection, IBindingManager {
	private final IBindingManager bm;
	private final IStructuredSelection selection;

	public BindingManagerAdapter(IBindingManager bm, IStructuredSelection selection) {
		this.bm = bm;
		this.selection = selection;
	}

	public IBindingManager clone() {
		return clone(new CloneContext());
	}
	public IBindingManager clone(ICloneContext cc) {
		return new BindingManagerAdapter(cc.clone(bm), selection);
	}


	public IEnvironmentManager wGetEnvironmentManager() {
		return bm.wGetEnvironmentManager();
	}

	public void wEnterScope() {
		bm.wEnterScope();
	}

	public void wEnterScope(INestableScope scope) {
		bm.wEnterScope(scope);
	}

	public void wEnterScope(IBindingScope scope, boolean dynamic) {
		bm.wEnterScope(scope, dynamic);
	}

	public void wExitScope() {
		bm.wExitScope();
	}

	public Kind getKind() {
		return bm.getKind();
	}

	public void wExitScope(boolean merge) {
		bm.wExitScope(merge);
	}

	public IBindingScope wTargetScope() {
		return bm.wTargetScope();
	}

	public IBindingScope wEnclosingScope() {
		return bm.wEnclosingScope();
	}

	public void wClear() {
		bm.wClear();
	}

	public Set<String> wLocalNames() {
		return bm.wLocalNames();
	}

	public Set<String> wNames() {
		return bm.wNames();
	}

	public void wAddAll(IBindingScope scope) {
		bm.wAddAll(scope);
	}

	public IEntity wGet(String name) {
		return bm.wGet(name);
	}

	public void wSet(String name, IEntity value) {
		bm.wSet(name, value);
	}

	public void wDef(String name, IEntity value) {
		bm.wDef(name, value);
	}

	public boolean wIsSet(String name) {
		return bm.wIsSet(name);
	}

	public void wUnset(String name) {
		bm.wUnset(name);
	}

	public IBindingScope wFindScope(String name) {
		return bm.wFindScope(name);
	}

	public boolean wBooleanValue(String name) {
		return bm.wBooleanValue(name);
	}

	public byte wByteValue(String name) {
		return bm.wByteValue(name);
	}

	public char wCharValue(String name) {
		return bm.wCharValue(name);
	}

	public double wDoubleValue(String name) {
		return bm.wDoubleValue(name);
	}

	public float wFloatValue(String name) {
		return bm.wFloatValue(name);
	}

	public int wIntValue(String name) {
		return bm.wIntValue(name);
	}

	public long wLongValue(String name) {
		return bm.wLongValue(name);
	}

	public short wShortValue(String name) {
		return bm.wShortValue(name);
	}

	public String wStringValue(String name) {
		return bm.wStringValue(name);
	}

	public Date wDateValue(String name) {
		return bm.wDateValue(name);
	}

	public EnumValue wEnumValue(String name) {
		return bm.wEnumValue(name);
	}

	public Object wGetValue(String name) {
		return bm.wGetValue(name);
	}

	public void wSetValue(String name, boolean value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, byte value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, char value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, double value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, float value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, int value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, long value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, short value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, String value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, Date value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, EnumValue value) {
		bm.wSetValue(name, value);
	}

	public void wSetValue(String name, Object value) {
		bm.wSetValue(name, value);
	}

	public void wDefValue(String name, boolean value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, byte value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, char value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, double value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, float value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, int value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, long value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, short value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, String value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, Date value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, EnumValue value) {
		bm.wDefValue(name, value);
	}

	public void wDefValue(String name, Object value) {
		bm.wDefValue(name, value);
	}

	public IBindingScope wResultScope() {
		return bm.wResultScope();
	}

	public void wSetResultScope(IBindingScope scope) {
		bm.wSetResultScope(scope);
	}

	public boolean hasResultIterator() {
		return bm.hasResultIterator();
	}

	public <E extends IEntity> IEntityIterator<E> getResultIterator() {
		return bm.getResultIterator();
	}

	public void setResultIterator(IEntityIterator<?> resultIterator) {
		bm.setResultIterator(resultIterator);
	}

	public IEntity getResult() {
		return bm.getResult();
	}

	public void setResult(IEntity value) {
		bm.setResult(value);
	}

	public boolean isEmpty() {
		return wNames().isEmpty();
	}
	public Object getFirstElement() {
		return selection.getFirstElement();
	}
	@SuppressWarnings("rawtypes")
	public Iterator iterator() {
		return selection.iterator();
	}
	public int size() {
		return selection.size();
	}
	public Object[] toArray() {
		return selection.toArray();
	}
	@SuppressWarnings("rawtypes")
	public List toList() {
		return selection.toList();
	}
}
