/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.evaluators;

/**
 * @author Riccardo Solmi
 */
public class ChildRangeEvaluator extends AbstractByIndexEvaluator {
    private int relativeStartIndex;
    private int relativeEndIndex;

    public ChildRangeEvaluator(boolean forward, int relativeStartIndex, int relativeEndIndex) {
        super(forward, 0);
        this.relativeStartIndex = relativeStartIndex;
        this.relativeEndIndex = relativeEndIndex;
    }

    protected final int startIndex() {
    	return relativeStartIndex >= 0 ? relativeStartIndex : selfEntity.wSize()-1 + relativeStartIndex+1;
    }
    protected final int endIndex() {
    	return relativeEndIndex >= 0 ? relativeEndIndex : selfEntity.wSize()-1 + relativeEndIndex+1;
    }

    @Override
	public boolean hasNext() {
		return super.hasNext() && selfEntity.wContains(startIndex() + nextIndex);
	}

    @Override
	public void toString(StringBuilder sb) {
    	sb.append("child");
		sb.append(forward ? "()" : "-reverse()");
    }
}
