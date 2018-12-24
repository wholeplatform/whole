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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Riccardo Solmi
 */
public class CloneContext implements ICloneContext {
	protected List<ICloneContext> contextHistory;
	protected int contextIndex;
	private ICloneContext prototypeCloneContext;
	protected Map<ICloneable, ICloneable> cloneMap = new HashMap<>(1024);

	public CloneContext() {	
	}
	protected CloneContext(List<ICloneContext> contextHistory, int contextIndex) {
		this.contextHistory = contextHistory;
		this.contextIndex = contextIndex;
	}

	public List<ICloneContext> getCloneHistory() {
		if (contextHistory == null) {
			contextHistory = new ArrayList<ICloneContext>();
			contextHistory.add(this);
			contextIndex = 0;
		}
		return contextHistory;
	}

	public ICloneContext getNextCloneContext() {
		List<ICloneContext> history = getCloneHistory();
		int nextIndex = contextIndex+1;
		if (nextIndex == history.size())
			history.add(new CloneContext(history, nextIndex));
		return history.get(nextIndex);
	}
	public ICloneContext getLastCloneContext() {
		List<ICloneContext> history = getCloneHistory();
		return history.get(history.size()-1);
	}

	public ICloneContext getPrototypeCloneContext() {
		if (this.prototypeCloneContext == null)
			this.prototypeCloneContext = new CloneContext();//FIXME init
		return this.prototypeCloneContext;
	}

	@SuppressWarnings("unchecked")
	public <T extends ICloneable> T clone(T prototype) {
		T clone = null;
		if (prototype != null) {
			clone = getClone(prototype);
			if (clone == null)
				/*putClone(prototype,*/ clone = (T) prototype.clone(this);//);
		}
		return clone;
	}

	@SuppressWarnings("unchecked")
	public <T extends ICloneable> T getClone(T prototype) {
		return (T) cloneMap.get(prototype);
	}

	public void putClone(ICloneable prototype, ICloneable clone) {
		cloneMap.put(prototype, clone);
	}
}
