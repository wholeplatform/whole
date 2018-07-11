package org.whole.lang.iterators.instrumentation;

import java.util.function.Consumer;
import java.util.function.Predicate;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.InstrumentingIterator;
import org.whole.lang.model.IEntity;

public class LoggerInstrumentation extends IdentityInstrumentation {
	public static Predicate<InstrumentingIterator<?>> loggerPredicate = (ii) -> {
		//TODO framework level logger enabler
		return false;
	};
	public static Consumer<InstrumentingIterator<?>> loggerConsumer = (ii) -> {
		//TODO framework level logger
		return;
	};

	@Override
	public void beforeClone(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterClone(InstrumentingIterator<?> ii, IEntityIterator<?> result) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeSetBindings(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterSetBindings(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeReset(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterReset(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeHasNext(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterHasNext(InstrumentingIterator<?> ii, boolean result) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeLookahead(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterLookahead(InstrumentingIterator<?> ii, IEntity result) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}

	@Override
	public void beforeNext(InstrumentingIterator<?> ii) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
	@Override
	public void afterNext(InstrumentingIterator<?> ii, IEntity result) {
		if (loggerPredicate.test(ii))
			loggerConsumer.accept(ii);
	}
}
