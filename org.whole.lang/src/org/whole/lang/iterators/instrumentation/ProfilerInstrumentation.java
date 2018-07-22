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

import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ProfilerInstrumentation implements IEntityIteratorInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new ProfilerInstrumentation();

	public static String ID = ProfilerInstrumentation.class.getName();
	public static ProfilerData profilerData(InstrumentingIterator<?> ii) {
		return ii.instrumentationData(ID, i -> new ProfilerData());
	}

	public static ProfilerData globalProfilerData = new ProfilerData();

	@Override
	public void beforeClone(InstrumentingIterator<?> ii) {
		globalProfilerData.cloneCalls++;
		ProfilerData pd = profilerData(ii);
		pd.cloneCalls++;
		pd.startTimer();
	}
	@Override
	public void afterClone(InstrumentingIterator<?> ii, InstrumentingIterator<?> result) {
		ProfilerData pd = profilerData(ii);
		pd.cloneDuration = pd.cloneDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
		globalProfilerData.setBindingsCalls++;
		ProfilerData pd = profilerData(ii);
		pd.setBindingsCalls++;
		pd.startTimer();
	}
	@Override
	public void afterSetBindings(InstrumentingIterator<?> ii) {
		ProfilerData pd = profilerData(ii);
		pd.setBindingsDuration = pd.setBindingsDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeReset(InstrumentingIterator<?> ii) {
		globalProfilerData.resetCalls++;
		ProfilerData pd = profilerData(ii);
		pd.resetCalls++;
		pd.startTimer();
	}
	@Override
	public void afterReset(InstrumentingIterator<?> ii) {
		ProfilerData pd = profilerData(ii);
		pd.resetDuration = pd.resetDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
		globalProfilerData.hasNextCalls++;
		ProfilerData pd = profilerData(ii);
		pd.hasNextCalls++;
		pd.startTimer();
	}
	@Override
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result) {
		ProfilerData pd = profilerData(ii);
		pd.hasNextDuration = pd.hasNextDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
		globalProfilerData.lookaheadCalls++;
		ProfilerData pd = profilerData(ii);
		pd.lookaheadCalls++;
		pd.startTimer();
	}
	@Override
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result) {
		ProfilerData pd = profilerData(ii);
		pd.lookaheadDuration = pd.lookaheadDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
		globalProfilerData.nextCalls++;
		ProfilerData pd = profilerData(ii);
		pd.nextCalls++;
		pd.startTimer();
	}
	@Override
	public void afterNext(InstrumentingIterator<?> ii, IEntity result) {
		ProfilerData pd = profilerData(ii);
		pd.nextDuration = pd.nextDuration.plus(pd.endTimer());
	}
}
