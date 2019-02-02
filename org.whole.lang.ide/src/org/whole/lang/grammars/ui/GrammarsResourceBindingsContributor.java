/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.grammars.ui;

import java.util.Collection;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.codebase.IGrammarProvider;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.ui.util.IResourceBindingsContributor;

/**
 * @author Enrico Persiani
 */
public class GrammarsResourceBindingsContributor implements IResourceBindingsContributor {
	public void addResourceBindings(IBindingManager bm) {
		if (!bm.wIsSet("grammarProvider")) {
			Collection<Grammar> grammars = GrammarsRegistry.instance().grammars();
			if (!grammars.isEmpty()) {
				IGrammarProvider provider = new DialogGrammarProvider(bm);
				bm.wDefValue("grammarProvider", provider);
			}
		}
	}
}
