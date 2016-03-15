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
package org.whole.lang.builders;

import java.util.Date;
import java.util.Stack;

import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.ITemplate;

/**
 * @author Enrico Persiani
 */
public class GenericEventTrackingBuilder extends GenericForwardStrategyBuilder {
	protected Stack<State> stateStack;

	public GenericEventTrackingBuilder(IBuilder builderStrategy) {
		this(builderStrategy, UNKNOWN);
	}
	public GenericEventTrackingBuilder(IBuilder builderStrategy, EntityDescriptor<?> ed) {
		this(builderStrategy, new State(ed, 0));
	}
	public GenericEventTrackingBuilder(IBuilder builderStrategy, EntityDescriptor<?> ed, FeatureDescriptor fd) {
		this(builderStrategy, ed, ed.indexOf(fd));
	}
	public GenericEventTrackingBuilder(IBuilder builderStrategy, EntityDescriptor<?> ed, int index) {
		this(builderStrategy, new State(ed, index));
	}
	protected GenericEventTrackingBuilder(IBuilder builderStrategy, State initialState) {
		super(builderStrategy);
		this.stateStack = new Stack<State>();
		this.stateStack.push(initialState);
	}

	protected void nextIndex() {
		stateStack.peek().nextIndex();
	}
	protected void pushState(EntityDescriptor<?> ed) {
		stateStack.push(new State(ed, 0));
	}
	protected void pushUnknownState() {
		stateStack.push(UNKNOWN);
	}
	protected void popState() {
		stateStack.pop();
	}
	protected void setIndex(int index) {
		stateStack.peek().setIndex(index);
	}
	public EntityDescriptor<?> wGetEntityDescriptor() {
		return stateStack.peek().getEntityDescriptor(); 
	}
	public int wCurrentIndexOf() {
		return stateStack.peek().getIndex(); 
	}
	public FeatureDescriptor wCurrentGetFeatureDescriptor() {
		State state = stateStack.peek();
		int index = state.getIndex();
		return index == -1 ? null : state.getEntityDescriptor().getEntityFeatureDescriptor(index); 
	}

	public void wEntity(EntityDescriptor<?> ed) {
		nextIndex();
		super.wEntity(ed);
	}
	public void wEntity_(EntityDescriptor<?> ed) {
		pushState(ed);
		super.wEntity_(ed);
	}
	public void wEntity_(EntityDescriptor<?> ed, int initialCapacity) {
		pushState(ed);
		super.wEntity_(ed, initialCapacity);
	}
	public void _wEntity(EntityDescriptor<?> ed) {
		popState();
		nextIndex();
		super._wEntity(ed);
	}

	public void wEntity(EntityDescriptor<?> ed, boolean value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, byte value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, char value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, double value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, float value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, int value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, long value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, short value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, String value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, Date value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, EnumValue value) {
		nextIndex();
		super.wEntity(ed, value);
    }
	public void wEntity(EntityDescriptor<?> ed, Object value) {
		nextIndex();
		super.wEntity(ed, value);
    }

    public void wEntity() {
    	nextIndex();
    	super.wEntity();
    }
    public void wEntity_() {
    	pushUnknownState();
    	super.wEntity_();
    }
    public void _wEntity() {
		popState();
		nextIndex();
		super._wEntity();
    }
	public void wDefault() {
    	nextIndex();
    	super.wDefault();
    }

	public void wFeature(int index) {
		setIndex(index);
		super.wFeature(index);
	}
	public void wFeature(FeatureDescriptor fd) {
		EntityDescriptor<?> ed = wGetEntityDescriptor();
		if (ed != null) // state == UNKNOWN => ed == null
			setIndex(ed.indexOf(fd));
		super.wFeature(fd);
	}
	public void wFeature(ITemplate pattern) {
		//TODO
		super.wFeature(pattern);
	}

	protected static final State UNKNOWN = new State(null, -1) {
		public void setIndex(int index) {
		}
		public void nextIndex() {
		}
	};
	protected static class State {
		private final EntityDescriptor<?> ed;
		private int index;
		public State(EntityDescriptor<?> ed) {
			this(ed, 0);
		}
		public State(EntityDescriptor<?> ed, int index) {
			this.ed = ed;
			this.index = index;
		}
		public EntityDescriptor<?> getEntityDescriptor() {
			return ed;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public void nextIndex() {
			this.index++;
		}
		@Override
		public String toString() {
			return this == UNKNOWN ? "UNKNOWN" : ed.getName()+"@"+ 
					(ed.getEntityKind().isComposite() ? Integer.toString(index) :
							ed.featureSize() > index ? ed.getEntityFeatureDescriptor(index).getName() : "???");
		}
	}
}
