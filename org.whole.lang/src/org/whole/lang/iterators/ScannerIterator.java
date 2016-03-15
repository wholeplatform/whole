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

import java.util.Date;
import java.util.NoSuchElementException;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Riccardo Solmi
 */
public class ScannerIterator<E extends IEntity> extends AbstractPatternFilterIterator<E> {
	protected ScannerIterator(IEntityIterator<E> iterator) {
		super(iterator);
	}

	protected IVisitor defaultPattern() {
		return GenericMatcherFactory.instance.isResolverMatcher();
	}

	protected E patternFilteredLookahead() {
		boolean found = false;
		E lookahead = null;
		while (iterator.hasNext() && !(found = !Matcher.match(pattern(), lookahead = iterator.lookahead()))) {
			lookaheadScope().wClear();
			iterator.next();
		}
		if (!found)
			lookahead = null;
		return lookahead;
	}

	public boolean hasNext(EntityDescriptor<?> descriptor) {
		return hasNext() && lookahead().wGetEntityDescriptor().equals(descriptor);
	}
	@SuppressWarnings("unchecked")
	public <T extends IEntity> T next(EntityDescriptor<T> descriptor) {
		IEntity entity = next();
		if (!Matcher.isAssignableAsIsFrom(descriptor, entity))
			throw new NoSuchElementException(descriptor.toString());

		return (T) entity;
	}
	public boolean hasNext(EntityKinds kind) {
		return hasNext() && lookahead().wGetEntityKind().equals(kind);
	}
	public IEntity next(EntityKinds kind) {
		IEntity entity = next();
		if (!Matcher.match(kind, entity))
			throw new NoSuchElementException(kind.toString());

		return entity;
	}
	public boolean hasNext(IEntity pattern) {
		return hasNext() && Matcher.match(pattern, lookahead());
	}
	public <T extends IEntity> T next(T pattern) {
		return next(pattern, getBindings()); //FIXME previous bindings interference
	}
	@SuppressWarnings("unchecked")
	public <T extends IEntity> T next(T pattern, IBindingManager bindings) {
		IEntity entity = next();
		if (!Matcher.match(pattern, entity, bindings))
			throw new NoSuchElementException(pattern.toString());

		return (T) entity;
	}
	
	public boolean hasNext(IVisitor matcherVisitor) {
		return hasNext() && Matcher.match(matcherVisitor, lookahead());
	}
	public IEntity next(IVisitor matcherVisitor) {
		IEntity entity = next();
		if (!Matcher.match(matcherVisitor, entity))
			throw new NoSuchElementException();

		return entity;
	}
	

	private boolean hasNext(DataKinds dataKind) {
		return hasNext() && dataKind.equals(DataTypeUtils.getDataKind(lookahead()));
	}

	public boolean hasNextBoolean() {
		return hasNext(DataKinds.BOOLEAN);
	}
	public boolean nextBoolean() {
		return next().wBooleanValue();
	}
	public boolean hasNextByte() {
		return hasNext(DataKinds.BYTE);
	}
	public byte nextByte() {
		return next().wByteValue();
	}
	public boolean hasNextChar() {
		return hasNext(DataKinds.CHAR);
	}
	public char nextChar() {
		return next().wCharValue();
	}
	public boolean hasNextDouble() {
		return hasNext(DataKinds.DOUBLE);
	}
	public double nextDouble() {
		return next().wDoubleValue();
	}
	public boolean hasNextFloat() {
		return hasNext(DataKinds.FLOAT);
	}
	public float nextFloat() {
		return next().wFloatValue();
	}
	public boolean hasNextInt() {
		return hasNext(DataKinds.INT);
	}
	public int nextInt() {
		return next().wIntValue();
	}
	public boolean hasNextLong() {
		return hasNext(DataKinds.LONG);
	}
	public long nextLong() {
		return next().wLongValue();
	}
	public boolean hasNextShort() {
		return hasNext(DataKinds.SHORT);
	}
	public short nextShort() {
		return next().wShortValue();
	}
	public boolean hasNextString() {
		return hasNext(DataKinds.STRING);
	}
	public String nextString() {
		return next().wStringValue();
	}
	public boolean hasNextDate() {
		return hasNext(DataKinds.DATE);
	}
	public Date nextDate() {
		return next().wDateValue();
	}
	public boolean hasNextEnumValue() {
		return hasNext(DataKinds.ENUM_VALUE);
	}
	public EnumValue nextEnumValue() {
		return next().wEnumValue();
	}
	public boolean hasNextValue() {
		return hasNext() && EntityUtils.isData(lookahead());
	}
	public Object nextValue() {
		return next().wGetValue();
	}

	public boolean skipTo(EntityDescriptor<?> descriptor) {
		boolean found = false;
		while (hasNext() && !(found = Matcher.isAssignableAsIsFrom(descriptor, lookahead())))
			next();
		return found;
	}
	public boolean skipTo(EntityKinds kind) {
		boolean found = false;
		while (hasNext() && !(found = Matcher.match(kind, lookahead())))
			next();
		return found;
	}
	public boolean skipTo(IEntity pattern) {
		return skipTo(pattern, getBindings()); //FIXME previous bindings interference
	}
	public boolean skipToSame(IEntity entity) {
		boolean found = false;
		while (hasNext() && !(found = (entity == lookahead())))
			next();
		return found;
	}
	public boolean skipTo(IEntity pattern, IBindingManager bindings) {
		boolean found = false;
		while (hasNext() && !(found = Matcher.match(pattern, lookahead(), bindings)))
			next();
		return found;
	}
	public boolean skipTo(IVisitor matcherVisitor) {
		boolean found = false;
		while (hasNext() && !(found = Matcher.match(matcherVisitor, lookahead())))
			next();
		return found;
	}

    @Override
	public void toString(StringBuilder sb) {
    	sb.append("scanner(");
    	sb.append(iterator.toString());
    	sb.append(", ");
    	sb.append(pattern().toString());
    	sb.append(")");
    }
}
