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
package org.whole.lang.grammars.ui;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.codebase.IGrammarProvider;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.util.GrammarsUtils;

/**
 * @author Enrico Persiani
 */
public class DialogGrammarProvider extends ElementListSelectionDialog implements IGrammarProvider {
	protected IBindingManager bindings;

	public DialogGrammarProvider(IBindingManager bindings) {
		super(null, new GrammarLabelProvider());
		setTitle("Choose a grammar"); 
		setMessage("Available grammars:");
		this.bindings = bindings;
	}

	public String getGrammarUri(String languageURI) {
		Collection<Grammar> grammars = new HashSet<Grammar>(GrammarsRegistry.instance().grammars());

		if (languageURI != null) {
			Iterator<Grammar> iterator = grammars.iterator();
			while (iterator.hasNext())
				if (!languageURI.equals(GrammarsUtils.getLanguageURI(iterator.next())))
					iterator.remove();
		}

		if (grammars.isEmpty())
			return null;
		else if (grammars.size() == 1)
			return grammars.iterator().next().getUri().getValue();

		Grammar[] grammarsArray = grammars.toArray(new Grammar[grammars.size()]);
		setElements(grammarsArray);
		setInitialElementSelections(Collections.singletonList(grammarsArray[0]));

		E4Utils.syncExec(bindings, this::open);
		if (getReturnCode() == Window.OK) {
			Object[] selectedElements = getResult();
			return ((Grammar) selectedElements[0]).getUri().getValue();
		} else 
			return null;
	}

	private static final class GrammarLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			Grammar grammar = (Grammar) element;
			return grammar.getName().getValue();
		}
	}
}
