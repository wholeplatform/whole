package org.whole.lang.iterators.instrumentation;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

public class IdentityInstrumentation implements IEntityIteratorInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new IdentityInstrumentation();

	@Override
	public void beforeClone(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterClone(InstrumentingIterator<?> ii, IEntityIterator<?> result) {
	}

	@Override
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterSetBindings(InstrumentingIterator<?> ii) {
	}

	@Override
	public void beforeReset(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterReset(InstrumentingIterator<?> ii) {
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result) {
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result) {
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
	}
	@Override
	public void afterNext(InstrumentingIterator<?> ii, IEntity result) {
	}
}
