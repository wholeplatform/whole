package org.whole.lang.iterators.instrumentation;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

public class ProfilerInstrumentation implements IEntityIteratorInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new ProfilerInstrumentation();

	public static ProfilingData globalProfilingData = new ProfilingData();
	public static Map<IEntityIterator<?>, ProfilingData> iteratorProfilingDataMap = new HashMap<>();
	public static ProfilingData profilingData(InstrumentingIterator<?> ii) {
		iteratorProfilingDataMap.computeIfAbsent(ii, i -> new ProfilingData());
		return iteratorProfilingDataMap.get(ii);
	}

	public static enum InstrumentedMethod {
		NONE, create, clone, setBindings, reset, hasNext, lookahead, next 
	}

	public static class ProfilingData {
		public int cloneCalls;
		public int setBindingsCalls;
		public int resetCalls;
		public int hasNextCalls;
		public int lookaheadCalls;
		public int nextCalls;

		public InstrumentedMethod calling = InstrumentedMethod.NONE;
		public InstrumentedMethod lastCalled = InstrumentedMethod.create;

		public Duration cloneDuration = Duration.ZERO;
		public Duration setBindingsDuration = Duration.ZERO;
		public Duration resetDuration = Duration.ZERO;
		public Duration hasNextDuration = Duration.ZERO;
		public Duration lookaheadDuration = Duration.ZERO;
		public Duration nextDuration = Duration.ZERO;

		protected Instant outerCallStartInstant;
		protected int pendingOuterCalls = 0;
		public boolean startTimer() {
			if (pendingOuterCalls++ == 0) {
				outerCallStartInstant = Instant.now();
				return true;
			} else {
				return false;
			}
		}
		public Duration elapsedTime() {
			return Duration.between(outerCallStartInstant, Instant.now());
		}
		public Duration endTimer() {
			return (--pendingOuterCalls == 0) ? elapsedTime() : Duration.ZERO;
		}
		public boolean isNestedCall() {
			return pendingOuterCalls > 1;
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
	public void afterClone(InstrumentingIterator<?> ii, IEntityIterator<?> result) {
		ProfilingData pd = profilingData(ii);
		pd.cloneDuration = pd.cloneDuration.plus(pd.endTimer());
		pd.lastCalled = InstrumentedMethod.clone;
	}

	@Override
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
		globalProfilingData.setBindingsCalls++;
		ProfilingData pd = profilingData(ii);
		pd.setBindingsCalls++;
		pd.startTimer();
		pd.lastCalled = InstrumentedMethod.setBindings;
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
		pd.lastCalled = InstrumentedMethod.reset;
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
		pd.lastCalled = InstrumentedMethod.hasNext;
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
		pd.lastCalled = InstrumentedMethod.lookahead;
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
		pd.lastCalled = InstrumentedMethod.next;
	}
}
