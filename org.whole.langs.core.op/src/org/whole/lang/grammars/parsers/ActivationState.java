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
package org.whole.lang.grammars.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Riccardo Solmi
 */
public class ActivationState {
	private ActivationState prev;
	private List<ActiveRule> activeRules;

	public ActivationState(ActivationState prevState, ActiveRule... activeRules) {
		this(prevState, new ArrayList<ActiveRule>(Arrays.asList(activeRules)));
	}
	public ActivationState(ActivationState prevState, List<ActiveRule> activeRules) {
		this.prev = prevState;
		this.activeRules = activeRules;
	}

	public ActivationState getPrev() {
		return prev;
	}
	public void setPrev(ActivationState prev) {
		this.prev = prev;
	}

	public List<ActiveRule> getActiveRules() {
		return activeRules;
	}
	public void setActiveRules(List<ActiveRule> activeRules) {
		this.activeRules = activeRules;
	}
	public void addActiveRule(ActiveRule activeRule) {
		activeRules.add(activeRule);
	}
	
	@Override
	public String toString() {
		return activeRules.toString();
	}
}
