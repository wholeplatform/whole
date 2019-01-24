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
package org.whole.lang.operations;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.steppers.IDifferentiationContext;

/**
 * @author Riccardo Solmi
 */
public class CloneContext implements IDifferentiationContext {
	protected IDifferentiationContext parentContext;
	protected IDifferentiationContext[] contextParts;
	
	@Deprecated
	private ICloneContext prototypeCloneContext;
	
	protected Map<ICloneable, ICloneable> cloneMap = new HashMap<>(1024);

	public CloneContext() {
		this(false);
	}
	public CloneContext(boolean identity) {
		if (identity)
			cloneMap = null;
	}
	public CloneContext(IDifferentiationContext parentContext) {	
		this.parentContext = parentContext;
	}

	public IDifferentiationContext getParentContext() {
		return parentContext == null ? this : parentContext;
	}

	public IDifferentiationContext getNextDifferentiationContext() {
		if (contextParts == null) {
			contextParts = new IDifferentiationContext[2];
			contextParts[0] = new CloneContext(this);
			contextParts[1] = new CloneContext(this);
		}
		return contextParts[contextParts.length-1];
	}

	public IDifferentiationContext getLastDifferentiationContext() {
		return contextParts == null ? this : contextParts[contextParts.length-1].getLastDifferentiationContext();
	}

	public ICloneContext getPrototypeCloneContext() {
		if (this.prototypeCloneContext == null)
			this.prototypeCloneContext = new CloneContext();//FIXME init
		return this.prototypeCloneContext;
	}

	@SuppressWarnings("unchecked")
	public <T extends ICloneable> T differentiate(T prototype) {
		T clone = null;
		if (prototype != null) {
			clone = getClone(prototype);
			if (clone == null)
				clone = (T) prototype.clone(this); //assume putClone(prototype, clone) is called
		}
		return clone;
	}

	@SuppressWarnings("unchecked")
	public <T extends ICloneable> T getClone(T prototype) {
		return cloneMap != null ? (T) cloneMap.get(prototype) : prototype;
	}

	public void setClone(ICloneable prototype, ICloneable clone) {
		if (cloneMap.put(prototype, clone) != null)
			throw new IllegalStateException();
	}
}
