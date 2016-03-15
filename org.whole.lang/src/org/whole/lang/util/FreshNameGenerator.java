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
package org.whole.lang.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Riccardo Solmi
 */
public class FreshNameGenerator {
	private Map<String, UniqueIdGenerator> generators = new HashMap<String, UniqueIdGenerator>();
	private Set<String> boundNames;
	private Set<String> boundFreshNames;

	public FreshNameGenerator(Collection<String> boundNames) {
		this.boundNames = new HashSet<String>(boundNames);
		this.boundFreshNames = new HashSet<String>();
	}
	public FreshNameGenerator() {
		this(Collections.<String>emptySet());
	}

	public UniqueIdGenerator newUniqueIdGenerator(String prefix) {
		UniqueIdGenerator generator = UniqueIdGenerator.newUniqueIdGenerator(prefix);
		generators.put(prefix, generator);
		return generator;
	}
	public UniqueIdGenerator newUniqueIdGenerator(String prefix, long counter) {
		UniqueIdGenerator generator = UniqueIdGenerator.newUniqueIdGenerator(prefix, counter);
		generators.put(prefix, generator);
		return generator;
	}

	public UniqueIdGenerator getUniqueIdGenerator(String prefix) {
		UniqueIdGenerator generator = generators.get(prefix);
		return generator != null ? generator : newUniqueIdGenerator(prefix);
	}

	public String next(String prefix) {
		UniqueIdGenerator generator = getUniqueIdGenerator(prefix);
		String uid;
		do {
			uid = generator.next();
		} while (!boundNames.add(uid));
		boundFreshNames.add(uid);
		return uid;
	}

	public String nextFreshName(String name) {
		if (boundNames.add(name)) {
			boundFreshNames.add(name);			
			return name;
		} else
			return next(name);
	}

//	public String nextBoundOnlyOrFreshName(String name, String normalizedName) {
//		return isBoundOnlyName(name) ? name : nextFreshName(normalizedName);
//	}

	public boolean isFreshName(String name) {
		return !boundNames.contains(name);
	}
	public boolean isBoundFreshName(String name) {
		return boundFreshNames.contains(name);
	}
	public boolean isBoundOnlyName(String name) {
		return !isFreshName(name) && !isBoundFreshName(name);
	}

	public void addBoundName(String name) {
		if (!boundNames.add(name))
			throw new IllegalArgumentException(name + "is already bound.");
	}

	public boolean putBoundName(String name) {
		return boundNames.add(name);
	}

	public Set<String> getBoundNames() {
		return Collections.unmodifiableSet(boundNames);
	}

	public void clearBoundNames() {
		boundNames.clear();
	}
}
