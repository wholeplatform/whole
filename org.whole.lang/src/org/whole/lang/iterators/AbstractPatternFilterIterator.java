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
package org.whole.lang.iterators;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractPatternFilterIterator<E extends IEntity> extends AbstractFilterIterator<E> {
	private IBindingManager bindings;
	private IBindingScope lookaheadScope;
	private IVisitor patternVisitor;

	public AbstractPatternFilterIterator(IEntityIterator<E> iterator) {
		super(iterator);
	}

	@Override
	public IEntityIterator<E> clone(ICloneContext cc) {
		AbstractPatternFilterIterator<E> iterator = (AbstractPatternFilterIterator<E>) super.clone(cc);
		iterator.patternVisitor = cc.clone(patternVisitor);
		return iterator;
	}

	public void reset(IEntity entity) {
		super.reset(entity);
		clearLookaheadScope();
	}

    public void setBindings(IBindingManager bindings) {
		if (this.bindings != bindings) {
			this.bindings = bindings;
			super.setBindings(bindings);
		}//TODO test
			if (patternVisitor != null)
				patternVisitor.setBindings(bindings);
//TODO		}
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	public IBindingScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createSimpleScope();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : lookaheadScope.wLocalNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
		}
	}

	public IVisitor pattern() {
		if (patternVisitor == null)
			patternVisitor = defaultPattern();
		return patternVisitor;
	}
	protected abstract IVisitor defaultPattern();

	public AbstractPatternFilterIterator<E> withPattern(FeatureDescriptor descriptor) {
		return withPattern(GenericMatcherFactory.instance.atFeatureMatcher(descriptor));
	}
	public AbstractPatternFilterIterator<E> withPattern(EntityDescriptor<?> descriptor) {
		return withPattern(GenericMatcherFactory.instance.isLanguageSubtypeOfMatcher(descriptor));
	}
	public AbstractPatternFilterIterator<E> withPattern(EntityKinds kind) {
		return withPattern(GenericMatcherFactory.instance.hasKindMatcher(kind));
	}
	public AbstractPatternFilterIterator<E> withPattern(final IEntity pattern) {
		return withPattern(GenericMatcherFactory.instance.matchInScope(pattern));
	}
	public AbstractPatternFilterIterator<E> withPattern(IVisitor matcherVisitor) {
		this.patternVisitor = matcherVisitor;
		return this;
	}

	@Override
	protected E filteredLookahead() {
		clearLookaheadScope();
		getBindings().wEnterScope(lookaheadScope(), true);
		E result = patternFilteredLookahead();
		getBindings().wExitScope();
		return result;
	}
	protected abstract E patternFilteredLookahead();

	@Override
	public final E next() {
		E result = super.next();
		getBindings().wAddAll(lookaheadScope());
		return result;
	}

	public abstract <T extends IEntity> T next(EntityDescriptor<T> descriptor);

	public abstract boolean skipTo(EntityDescriptor<?> descriptor);
	public abstract boolean skipTo(EntityKinds kind);
	public abstract boolean skipTo(IEntity pattern);
	public abstract boolean skipToSame(IEntity entity);
	public abstract boolean skipTo(IEntity pattern, IBindingManager bindings);
	public abstract boolean skipTo(IVisitor matcherVisitor);
}