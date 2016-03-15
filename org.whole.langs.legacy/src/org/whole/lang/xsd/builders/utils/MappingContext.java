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
/**
 * 
 */
package org.whole.lang.xsd.builders.utils;

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Enrico Persiani
 */
public class MappingContext {
	public final FeatureDescriptor fd;
	public final EntityDescriptor<?> ed;
	public final boolean structural;
	public final boolean mixed;
	protected int lastChildIndex;
	
	protected MappingContext(FeatureDescriptor fd, EntityDescriptor<?> ed, boolean structural, boolean mixed) {
		this.fd = fd;
		this.ed = ed;
		this.structural = structural;
		this.mixed = mixed;
		this.lastChildIndex = 0;
	}

	public int getLastChildIndex() {
		return lastChildIndex;
	}
	public void updateLastChildIndex(FeatureDescriptor fd) {
		this.lastChildIndex = ed.indexOf(fd);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(fd == null ? "any" : CommonsDataTypePersistenceParser.unparseFeatureDescriptor(fd));//FIXME
		sb.append(" : ");
		sb.append(CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed));
		return sb.toString();
	}

	public static MappingContext create(EntityDescriptor<?> ed, FeatureDescriptor fd, boolean structural, boolean mixed) {
		return new MappingContext(fd, ed, structural, mixed);
	}
	public static MappingContext create(EntityDescriptor<?> ed, FeatureDescriptor fd, boolean structural) {
		return create(ed, fd, structural, false);
	}
}
