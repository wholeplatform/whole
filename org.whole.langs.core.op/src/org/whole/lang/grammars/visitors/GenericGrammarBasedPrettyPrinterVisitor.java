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
package org.whole.lang.grammars.visitors;

import java.util.Collection;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.visitors.GenericIdentityVisitor;

/**
 * @author Enrico Persiani
 */
public class GenericGrammarBasedPrettyPrinterVisitor extends GenericIdentityVisitor {
	private IPrettyPrintWriter out;

	public GenericGrammarBasedPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		return false;
	}

	@Override
	public void visit(IEntity entity) {
		IBindingManager bm = getBindings();

		Grammar grammar = null;
		String grammarUri = GrammarsUtils.getGrammarUri(bm);
		if (grammarUri != null)
			grammar = GrammarsRegistry.instance().getGrammar(grammarUri);
		
		if (grammar == null) {
			Collection<Grammar> grammars = GrammarsRegistry.instance().getGrammarsFor(entity);
			if (grammars.isEmpty())
				throw new IllegalArgumentException("cannot find a suitable grammar to unparse the entity");
			grammar = grammars.iterator().next();
		}
		new GrammarBasedPrettyPrinterVisitor(entity, out, bm).visit(grammar);
	}
}
