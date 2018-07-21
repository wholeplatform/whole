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
package org.whole.lang.iterators.instrumentation;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ProfilerInstrumentation implements IEntityIteratorInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new ProfilerInstrumentation();

	public static ProfilingData globalProfilingData = new ProfilingData();
	public static Map<IEntityIterator<?>, ProfilingData> iteratorProfilingDataMap = new HashMap<>();
	public static ProfilingData profilingData(InstrumentingIterator<?> ii) {
		iteratorProfilingDataMap.computeIfAbsent(ii, i -> new ProfilingData());
		return iteratorProfilingDataMap.get(ii);
	}

	public static class ProfilingData {
		public int cloneCalls;
		public int setBindingsCalls;
		public int resetCalls;
		public int hasNextCalls;
		public int lookaheadCalls;
		public int nextCalls;

		public Duration cloneDuration = Duration.ZERO;
		public Duration setBindingsDuration = Duration.ZERO;
		public Duration resetDuration = Duration.ZERO;
		public Duration hasNextDuration = Duration.ZERO;
		public Duration lookaheadDuration = Duration.ZERO;
		public Duration nextDuration = Duration.ZERO;

		protected Instant startInstant;
		public void startTimer() {
			startInstant = Instant.now();
		}
		public Duration endTimer() {
			return Duration.between(startInstant, Instant.now());
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("\nclone      :");
			sb.append(cloneCalls);
			sb.append("  ");
			sb.append(cloneDuration);

			sb.append("\nsetBindings:");
			sb.append(setBindingsCalls);
			sb.append("  ");
			sb.append(setBindingsDuration);

			sb.append("\nreset      :");
			sb.append(resetCalls);
			sb.append("  ");
			sb.append(resetDuration);

			sb.append("\nhasNext    :");
			sb.append(hasNextCalls);
			sb.append("  ");
			sb.append(hasNextDuration);

			sb.append("\nlookahead  :");
			sb.append(lookaheadCalls);
			sb.append("  ");
			sb.append(lookaheadDuration);

			sb.append("\nnext       :");
			sb.append(nextCalls);
			sb.append("  ");
			sb.append(nextDuration);
			return sb.toString();
		}
	}

	@Override
	public void beforeClone(InstrumentingIterator<?> ii) {
		globalProfilingData.cloneCalls++;
		ProfilingData pd = profilingData(ii);
		pd.cloneCalls++;
		pd.startTimer();
	}
	@Override
	public void afterClone(InstrumentingIterator<?> ii, InstrumentingIterator<?> result) {
		ProfilingData pd = profilingData(ii);
		pd.cloneDuration = pd.cloneDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
		globalProfilingData.setBindingsCalls++;
		ProfilingData pd = profilingData(ii);
		pd.setBindingsCalls++;
		pd.startTimer();
	}
	@Override
	public void afterSetBindings(InstrumentingIterator<?> ii) {
		ProfilingData pd = profilingData(ii);
		pd.setBindingsDuration = pd.setBindingsDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeReset(InstrumentingIterator<?> ii) {
		globalProfilingData.resetCalls++;
		ProfilingData pd = profilingData(ii);
		pd.resetCalls++;
		pd.startTimer();
	}
	@Override
	public void afterReset(InstrumentingIterator<?> ii) {
		ProfilingData pd = profilingData(ii);
		pd.resetDuration = pd.resetDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
		globalProfilingData.hasNextCalls++;
		ProfilingData pd = profilingData(ii);
		pd.hasNextCalls++;
		pd.startTimer();
	}
	@Override
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result) {
		ProfilingData pd = profilingData(ii);
		pd.hasNextDuration = pd.hasNextDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
		globalProfilingData.lookaheadCalls++;
		ProfilingData pd = profilingData(ii);
		pd.lookaheadCalls++;
		pd.startTimer();
	}
	@Override
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result) {
		ProfilingData pd = profilingData(ii);
		pd.lookaheadDuration = pd.lookaheadDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
		globalProfilingData.nextCalls++;
		ProfilingData pd = profilingData(ii);
		pd.nextCalls++;
		pd.startTimer();
	}
	@Override
	public void afterNext(InstrumentingIterator<?> ii, IEntity result) {
		ProfilingData pd = profilingData(ii);
		pd.nextDuration = pd.nextDuration.plus(pd.endTimer());
	}
}
