package org.whole.lang.iterators.instrumentation;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;

public class DebuggerInstrumentation extends IdentityInstrumentation {
	public static final IEntityIteratorInstrumentation instance = new DebuggerInstrumentation();

	public static Predicate<InstrumentingIterator<?>> breakpointPredicate = (ii) -> {
		//TODO replace with a framework level predicate
		return false;
	};
	public static Consumer<InstrumentingIterator<?>> breakpointConsumer = (ii) -> {
		//TODO place a breakpoint here to stop at the framework level
		return;
	};

	@Override
	public void afterClone(InstrumentingIterator<?> ii, IEntityIterator<?> result) {
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
//		if (breakpointPredicate.test(ii))
//			breakpointConsumer.accept(ii);
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
//		if (breakpointPredicate.test(ii))
//			breakpointConsumer.accept(ii);
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
		if (breakpointPredicate.test(ii))
			breakpointConsumer.accept(ii);
	}
}
