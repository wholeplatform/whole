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
package org.whole.lang.grammars;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.grammars.factories.GrammarsEntityFactory;
import org.whole.lang.grammars.model.DataTypeEnum;
import org.whole.lang.grammars.model.Format;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Template;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class GrammarsActionsHelpers {
	public static IEntity createTuple() {
		return BindingManagerFactory.instance.createTuple();
	}
	public static void addTokenName(IEntity tokens, IEntity tokenName) {
		tokens.wAdd(tokenName);
	}
	public static IEntity nextTokenFreshName(FreshNameGenerator featureNameGenerator) {
		return GrammarsEntityFactory.instance.createNonTerminal(featureNameGenerator.nextFreshName("TOKEN"));
	}
	public static void addBoundName(FreshNameGenerator featureNameGenerator, String name) {
		try {
			featureNameGenerator.addBoundName(name);
		} catch (Exception e) {
			// ignore failures
		}
	}
	public static void addBoundNames(FreshNameGenerator featureNameGenerator, AlphaRenameMap aplphaRenameMap) {
		for (String name : aplphaRenameMap.nameSet())
			featureNameGenerator.addBoundName(name);
	}
	public static String nextFeatureFreshName(FreshNameGenerator featureNameGenerator, String name) {
		return featureNameGenerator.nextFreshName(StringUtils.toLowerPrefix(name));
	}

	public static class TokenSet extends HashSet<String> {
		private static final long serialVersionUID = 1L;

		public TokenSet() {
		}
		public TokenSet(Collection<? extends String> c) {
			super(c);
		}
		public TokenSet(int initialCapacity, float loadFactor) {
			super(initialCapacity, loadFactor);
		}
		public TokenSet(int initialCapacity) {
			super(initialCapacity);
		}
		public TokenSet(IEntity tuple) {
			this(tuple.wSize()*2);
			IEntityIterator<NonTerminal> i = IteratorFactory.<NonTerminal>childIterator();
			i.reset(tuple);
			for (NonTerminal nt : i)
				add(nt.getValue());
		}

		@Override
		public boolean add(String o) {
			return super.add(o);
		}
		public boolean contains(String s) {
			return super.contains(s);
		}
		public boolean remove(String s) {
			return super.remove(s);
		}

		public boolean add(NonTerminal nt) {
			return super.add(DataTypeUtils.getAsPresentationString(nt));
		}
		public boolean contains(NonTerminal nt) {
			return super.contains(DataTypeUtils.getAsPresentationString(nt));
		}
		public boolean remove(NonTerminal nt) {
			return super.remove(DataTypeUtils.getAsPresentationString(nt));
		}
	}

	public static class AlphaRenameMap {
		private Map<String, Set<NonTerminal>> occurenceMap;
		
		public AlphaRenameMap() {
			occurenceMap = new HashMap<String, Set<NonTerminal>>();
		}
		public IEntity names() {
			IEntity tuple = BindingManagerFactory.instance.createTuple();
			for (String name : nameSet())
				tuple.wAdd(BindingManagerFactory.instance.createValue(name));
			return tuple;
		}
		public Set<String> nameSet() {
			return Collections.unmodifiableSet(occurenceMap.keySet());
		}
		public void add(NonTerminal nt) {
			String name = DataTypeUtils.getAsPresentationString(nt);
			getOccurrences(name).add(nt);
		}
		public Set<NonTerminal> getOccurrences(String name) {
			Set<NonTerminal> occurences = occurenceMap.get(name);
			if (occurences == null) {
				occurences = new HashSet<NonTerminal>();
				occurenceMap.put(name, occurences);
			}
			return occurences;
		}
		public void rename(String oldName, String newName) {
			Set<NonTerminal> occurrences = occurenceMap.remove(oldName);
			if (occurrences == null)
				return;
			for (NonTerminal nt : occurrences)
				DataTypeUtils.setFromPresentationString(nt, newName);
			occurenceMap.put(newName, occurrences);
		}
	}

	private static final Pattern formatPattern = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?" +
			"(([bBhHsScCdoxXeEfgGaAn%])|([tT](?:[a-zA-Z])?))");

	public static Template calculateDataType(Format format) {
		GrammarsEntityFactory gef = GrammarsEntityFactory.instance;
		Matcher matcher = formatPattern.matcher(format.getValue());
		while (matcher.find()) {

			String conversion = null;
			int groupCount = matcher.groupCount();
			while ((conversion = matcher.group(groupCount--)) == null)
				;

			switch (conversion.charAt(0)) {
			case 'b': case 'B':
				return gef.createDataType(DataTypeEnum.BOOLEAN);
			case 'h': case 'H':
				return gef.createCustomDataType("java.lang.Object");
			case 's': case 'S':
				return gef.createDataType(DataTypeEnum.STRING);
			case 'c': case 'C':
				return gef.createDataType(DataTypeEnum.CHAR);
			case 'd': case 'o': case 'x': case 'X':
				return gef.createDataType(DataTypeEnum.INT);
			case 'e': case 'E': case 'f': case 'g': case 'G': case 'a': case 'A':
				return gef.createDataType(DataTypeEnum.FLOAT);
			case 't': case 'T':
				return gef.createDataType(DataTypeEnum.DATE);
			}
		}
		return gef.createDataType(DataTypeEnum.STRING);
	}
}
