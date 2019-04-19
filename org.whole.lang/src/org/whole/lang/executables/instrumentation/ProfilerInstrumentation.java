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
package org.whole.lang.executables.instrumentation;

import org.whole.lang.executables.IExecutable;
import org.whole.lang.executables.InstrumentingExecutable;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class ProfilerInstrumentation implements IExecutableInstrumentation {
	public static final IExecutableInstrumentation instance = new ProfilerInstrumentation();

	public static String ID = ProfilerInstrumentation.class.getName();
	public static ProfilerData profilerData(InstrumentingExecutable ii) {
		return ii.instrumentationData(ID, i -> new ProfilerData());
	}

	public static ProfilerData globalProfilerData = new ProfilerData();

	@Override
	public void beforeClone(InstrumentingExecutable ii) {
		globalProfilerData.cloneCalls++;
		ProfilerData pd = profilerData(ii);
		pd.cloneCalls++;
		pd.startTimer();
	}
	@Override
	public void afterClone(InstrumentingExecutable ii, InstrumentingExecutable result) {
		ProfilerData pd = profilerData(ii);
		pd.cloneDuration = pd.cloneDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeSetBindings(InstrumentingExecutable ii) {
		globalProfilerData.setBindingsCalls++;
		ProfilerData pd = profilerData(ii);
		pd.setBindingsCalls++;
		pd.startTimer();
	}
	@Override
	public void afterSetBindings(InstrumentingExecutable ii) {
		ProfilerData pd = profilerData(ii);
		pd.setBindingsDuration = pd.setBindingsDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeReset(InstrumentingExecutable ii) {
		globalProfilerData.resetCalls++;
		ProfilerData pd = profilerData(ii);
		pd.resetCalls++;
		pd.startTimer();
	}
	@Override
	public void afterReset(InstrumentingExecutable ii) {
		ProfilerData pd = profilerData(ii);
		pd.resetDuration = pd.resetDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeEvaluateNext(InstrumentingExecutable ii) {
		globalProfilerData.evaluateNextCalls++;
		ProfilerData pd = profilerData(ii);
		pd.evaluateNextCalls++;
		pd.startTimer();
	}
	@Override
	public void afterEvaluateNext(InstrumentingExecutable ii, IEntity result) {
		ProfilerData pd = profilerData(ii);
		pd.evaluateNextDuration = pd.evaluateNextDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeEvaluateRemaining(InstrumentingExecutable ii) {
		globalProfilerData.evaluateRemainingCalls++;
		ProfilerData pd = profilerData(ii);
		pd.evaluateRemainingCalls++;
		pd.startTimer();
	}
	@Override
	public void afterEvaluateRemaining(InstrumentingExecutable ii, IEntity result) {
		ProfilerData pd = profilerData(ii);
		pd.evaluateRemainingDuration = pd.evaluateRemainingDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeCall(InstrumentingExecutable ii) {
		globalProfilerData.callCalls++;
		ProfilerData pd = profilerData(ii);
		pd.callCalls++;
		pd.startTimer();
	}
	@Override
	public void afterCall(InstrumentingExecutable ii) {
		ProfilerData pd = profilerData(ii);
		pd.callDuration = pd.callDuration.plus(pd.endTimer());
	}

	@Override
	public void beforeAccept(InstrumentingExecutable ii, IExecutable executable) {
		globalProfilerData.acceptCalls++;
		ProfilerData pd = profilerData(ii);
		pd.acceptCalls++;
		pd.startTimer();
	}
	@Override
	public void afterAccept(InstrumentingExecutable ii) {
		ProfilerData pd = profilerData(ii);
		pd.acceptDuration = pd.acceptDuration.plus(pd.endTimer());
	}
}
