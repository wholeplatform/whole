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
package org.whole.lang.grammars.codebase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class GrammarsRegistry {
	private static class SingletonHolder {
		private static final GrammarsRegistry instance = new GrammarsRegistry();
	}
	public static final GrammarsRegistry instance() {
		return SingletonHolder.instance;
	}
	private final Map<String, Grammar> grammarsMap;
//	private IResourceRegistry<EntityResource> grammarsRegistry = ResourceRegistry.getRegistry(
//			GrammarsLanguageKit.URI);

	private GrammarsRegistry() {
		grammarsMap = new HashMap<String, Grammar>();
	}

	public boolean putGrammar(Grammar grammar) {
		grammarsMap.put(grammar.getName().getValue(), grammar);
//		grammarsRegistry.addResource(new GrammarResource(grammar), false);
		return grammarsMap.put(grammar.getUri().getValue(), grammar) != null;
	}
	public boolean removeGrammar(Grammar grammar) {
		grammarsMap.remove(grammar.getName().getValue());
		return grammarsMap.remove(grammar.getUri().getValue()) != null;
	}
	public Collection<Grammar> grammars() {
		List<Grammar> grammars = new ArrayList<Grammar>(grammarsMap.values());
		Collections.sort(grammars, new Comparator<Grammar>() {
			public int compare(Grammar g1, Grammar g2) {
				return g1.getName().getValue().compareTo(g2.getName().getValue());
			}
		});
		return Collections.unmodifiableList(grammars);
	}

	public Grammar getGrammar(String grammarURI) {
		return grammarsMap.get(grammarURI);
	}
	public Collection<Grammar> getGrammarsFor(IEntity entity) {
		return getGrammarsFor(entity.wGetLanguageKit().getURI());
	}
	public Collection<Grammar> getGrammarsFor(String languageURI) {
		if (grammarsMap.isEmpty())
			return Collections.emptySet();

		Set<Grammar> subSet = new HashSet<Grammar>();
		for (Grammar g : grammarsMap.values())
			if (languageURI.equals(GrammarsUtils.getLanguageURI(g)))
				subSet.add(g);
		return subSet;
	}

	public boolean containsGrammar(String grammarURI) {
		return grammarsMap.containsKey(grammarURI);
	}
	public boolean containsGrammarFor(IEntity entity) {
		return containsGrammarFor(entity.wGetLanguageKit().getURI());
	}
	public boolean containsGrammarFor(String languageURI) {
		return !getGrammarsFor(languageURI).isEmpty();
	}
}
