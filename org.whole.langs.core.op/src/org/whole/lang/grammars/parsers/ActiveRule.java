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

import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Rule;

/**
 * @author Riccardo Solmi
 */
public class ActiveRule {
	private boolean recursive;
	private NonTerminal nt;
	private Rule dotRule;

	public ActiveRule(NonTerminal nt, Rule dotRule) {
		this(false, nt, dotRule);
	}
	public ActiveRule(boolean recursive, NonTerminal nt, Rule dotRule) {
		this.recursive = recursive;
		this.nt = nt;
		this.dotRule = dotRule;
	}

	public boolean isRecursive() {
		return recursive;
	}
	public void setRecursive(boolean recursive) {
		this.recursive = recursive;
	}

	public NonTerminal getNt() {
		return nt;
	}
	public void setNt(NonTerminal nt) {
		this.nt = nt;
	}

	public Rule getDotRule() {
		return dotRule;
	}
	public void setDotRule(Rule dotRule) {
		this.dotRule = dotRule;
	}

	@Override
	public String toString() {
		return nt.toString()+(recursive ? "*":"")+": "+dotRule.toString();
	}
}
