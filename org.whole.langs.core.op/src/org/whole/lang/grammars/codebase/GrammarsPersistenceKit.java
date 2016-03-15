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

import java.io.PrintStream;
import java.util.Collection;

import org.whole.lang.codebase.AbstractGenericPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class GrammarsPersistenceKit extends AbstractGenericPersistenceKit {
	private static class SingletonHolder {
		private static final GrammarsPersistenceKit instance = new GrammarsPersistenceKit();
	}
	public static final GrammarsPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private GrammarsPersistenceKit() {
		super("Grammars Persistence", "grammars");
	}

	public boolean isLossless() {
		return false;
	}
//	public boolean isLossless(IEntity entity) {
//FIXME		return GrammarsUtils.isLossless(GrammarsRegistry.instance().get(entity));
//	}

	public boolean canApply(ILanguageKit languageKit) {
		String languageURI = languageKit.getURI();
		return GrammarsRegistry.instance().containsGrammarFor(languageURI);
	}


	protected void doInitDefaultEncoding(IEntity model, IPersistenceProvider pp) throws Exception {
		String encoding = getDefaultEncoding();

		if (model == null)
			encoding = StringUtils.encodingFromBOM(pp.getInputStream(), encoding);

		pp.withDefaultEncoding(encoding);
	}

	@Override
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		return GrammarsUtils.parse(StringUtils.readAsString(pp.getInputStream(), pp.getEncoding()), getGrammarUri(pp));
	}

	@Override
	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		PrintStream printStream = new PrintStream(pp.getOutputStream(), false, pp.getEncoding());
		Collection<Grammar> grammars = GrammarsRegistry.instance().getGrammarsFor(model);
		GrammarsUtils.unparse(model, printStream, grammars.size() == 1 ?
				grammars.iterator().next().getUri().getValue() : getGrammarUri(pp));
		printStream.flush();
	}

	protected String getGrammarUri(IPersistenceProvider pp) {
		String grammarUri = GrammarsUtils.getGrammarUri(pp.getBindings());
		if (grammarUri == null)
			throw new IllegalArgumentException("No grammar selected");
		return grammarUri;
	}
}
