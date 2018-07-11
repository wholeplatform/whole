package org.whole.lang.iterators.instrumentation;

import java.util.Arrays;
import java.util.List;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

public class CompositeInstrumentation implements IEntityIteratorInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new CompositeInstrumentation(
			ProfilerInstrumentation.instance,
			LoggerInstrumentation.instance,
			DebuggerInstrumentation.instance
	);

	public final List<IEntityIteratorInstrumentation> instrumentations;

	public CompositeInstrumentation(IEntityIteratorInstrumentation... instrumentations) {
		this.instrumentations = Arrays.asList(instrumentations);
	}

	@Override
	public void beforeClone(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.beforeClone(ii));
	}
	@Override
	public void afterClone(InstrumentingIterator<?> ii, IEntityIterator<?> result) {
		instrumentations.forEach((i) -> i.afterClone(ii, result));
	}

	@Override
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.beforeSetBindings(ii));
	}
	@Override
	public void afterSetBindings(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.afterSetBindings(ii));
	}

	@Override
	public void beforeReset(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.beforeReset(ii));
	}
	@Override
	public void afterReset(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.afterReset(ii));
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.beforeHasNext(ii));
	}
	@Override
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result) {
		instrumentations.forEach((i) -> i.afterHasNext(ii, result));
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.beforeLookahead(ii));
	}
	@Override
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result) {
		instrumentations.forEach((i) -> i.afterLookahead(ii, result));
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
		instrumentations.forEach((i) -> i.beforeNext(ii));
	}
	@Override
	public void afterNext(InstrumentingIterator<?> ii, IEntity result) {
		instrumentations.forEach((i) -> i.afterNext(ii, result));
	}
}
