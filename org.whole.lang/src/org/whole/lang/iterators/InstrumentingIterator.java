package org.whole.lang.iterators;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.instrumentation.IEntityIteratorInstrumentation;
import org.whole.lang.iterators.instrumentation.IdentityInstrumentation;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;

public class InstrumentingIterator<E extends IEntity> extends AbstractDelegatingIterator<E> {
	public static IEntityIteratorInstrumentation instrumentation =
//			CompositeInstrumentation.instance;
			IdentityInstrumentation.instance;

	public InstrumentingIterator(IEntityIterator<E> iterator) {
		super(iterator);
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		instrumentation.beforeClone(this);
		IEntityIterator<E> result = super.clone(cc);
		instrumentation.afterClone(this, result);
		return result;
	}

	@Override
	protected void setArgumentsBindings(IBindingManager bindings) {
		instrumentation.beforeSetBindings(this);
		super.setArgumentsBindings(bindings);
		instrumentation.afterSetBindings(this);
	}
	
	@Override
	public void reset(IEntity entity) {
		instrumentation.beforeReset(this);
		super.reset(entity);
		instrumentation.afterReset(this);
	}

	@Override
	public boolean hasNext() {
		instrumentation.beforeHasNext(this);
		boolean result = super.hasNext();
		instrumentation.afterHasNext(this, result);
		return result;
	}

	@Override
	public E lookahead() {
		instrumentation.beforeLookahead(this);
		E result = super.lookahead();
		instrumentation.afterLookahead(this, result);
		return result;
	}

	@Override
	public E next() {
		instrumentation.beforeNext(this);
		E result = super.next();
		instrumentation.afterNext(this, result);
		return result;
	}

	@Override
	public IEntityIterator<E> withSourceEntity(IEntity entity) {
		getIterator().withSourceEntity(entity);
		return super.withSourceEntity(entity);
	}
}
