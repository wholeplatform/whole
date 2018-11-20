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
package org.whole.lang.evaluators;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

/**
 * @author Riccardo Solmi
 */
public class FilterByIndexRangeEvaluator extends AbstractDelegatingNestedEvaluator {
	protected Map<Object, IndexPair> indexMap;
	protected int startIndex;
	protected int endIndex;
	protected int lookaheadIndex;

	protected static class IndexPair {
		public int lookaheadIndex;
		public int predicateIndex;

		public IndexPair(int lookaheadIndex, int predicateIndex) {
			this.lookaheadIndex = lookaheadIndex;
			this.predicateIndex = predicateIndex;
		}
	}

	public FilterByIndexRangeEvaluator() {
		this((IExecutable) null);
	}
	public FilterByIndexRangeEvaluator(IExecutable executable) {
		this(executable, 0, Integer.MAX_VALUE);
	}
	public FilterByIndexRangeEvaluator(int startIndex, int endIndex) {
		this(null, startIndex, endIndex);
	}
	public FilterByIndexRangeEvaluator(IExecutable executable, int startIndex, int endIndex) {
		super(executable);
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	@Override
	public IExecutable clone(ICloneContext cc) {
		FilterByIndexRangeEvaluator executable = (FilterByIndexRangeEvaluator) super.clone(cc);
		if (indexMap != null)
			executable.indexMap = new HashMap<Object, IndexPair>(indexMap);
		return executable;
	}

	public FilterByIndexRangeEvaluator withExecutable(IExecutable executable) {
		producers[0] = executable;
		return this;
	}

	public FilterByIndexRangeEvaluator withStartIndex(int startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	public FilterByIndexRangeEvaluator withEndIndex(int endIndex) {
		this.endIndex = endIndex;
		return this;
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		indexMap = null;
		lookaheadIndex = 0;
	}

	public int lookaheadIndex() {
		return lookaheadIndex;
	}

	public int predicateIndex(Object predicateKey) {
		if (indexMap == null)
			indexMap = new HashMap<Object, IndexPair>();

		IndexPair ordinal = indexMap.get(predicateKey);

		if (ordinal == null)
			indexMap.put(predicateKey, ordinal = new IndexPair(lookaheadIndex, 0));
		else if (lookaheadIndex > ordinal.lookaheadIndex) {
			ordinal.lookaheadIndex = lookaheadIndex;
			ordinal.predicateIndex = ordinal.predicateIndex+1;
		}

		return ordinal.predicateIndex;
	}

	protected boolean inRange() {
		while (lookaheadIndex < startIndex && super.hasNext()) {
			super.next();
        	lookaheadIndex++;
		}

		return startIndex <= lookaheadIndex && lookaheadIndex <= endIndex;
	}

	public IEntity evaluateNext() {
		getBindings().wEnterScope(executorScope(), true);

		while (lookaheadIndex < startIndex && getProducer(0).evaluateNext() != null) {
			lookaheadIndex++;
			executorScope().wClear();
		}
		if (lookaheadIndex <= endIndex) {
			lookaheadIndex++;
			lastEntity = getProducer(0).evaluateNext();
		} else
			lastEntity = null;

		getBindings().wExitScope(lastEntity != null);

		return lastEntity;
	}

	@Override
	public void toString(StringBuilder sb) {
    	sb.append("(");
    	super.toString(sb);
    	sb.append(" iteration ");
    	sb.append(lookaheadIndex);
    	sb.append(" of [");
    	sb.append(startIndex);
    	sb.append("..");
    	sb.append((endIndex == Integer.MAX_VALUE) ? "*" : String.valueOf(endIndex));
		sb.append("])");
	}
}
