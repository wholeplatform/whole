package org.whole.lang.iterators.instrumentation;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

public interface IEntityIteratorInstrumentation {
	public void beforeClone(InstrumentingIterator<?> ii);
	public void afterClone(InstrumentingIterator<?> ii, IEntityIterator<?> result);

	public void beforeSetBindings(InstrumentingIterator<?> ii);
	public void afterSetBindings(InstrumentingIterator<?> ii);

	public void beforeReset(InstrumentingIterator<?> ii);
	public void afterReset(InstrumentingIterator<?> ii);
	
	public void beforeHasNext(InstrumentingIterator<?> ii);
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result);

	public void beforeLookahead(InstrumentingIterator<?> ii);
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result);

	public void beforeNext(InstrumentingIterator<?> ii);
	public void afterNext(InstrumentingIterator<?> ii, IEntity result);
}
