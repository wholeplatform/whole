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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.LanguageDescriptor;
import org.whole.lang.grammars.model.TargetLanguage;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public abstract class AbstractGrammarSpecificPersistenceKit extends AbstractSpecificPersistenceKit {
	protected final String grammarURI;
	protected Grammar grammar;

	public AbstractGrammarSpecificPersistenceKit(String name, String fileExtension, Grammar grammar) {
		super(name, fileExtension, GrammarsUtils.getLanguageURI(grammar));
		this.grammarURI = grammar.getUri().getValue();
		this.grammar = grammar;
	}

	protected void ensureGrammarDeployed(IBindingManager bm) {
		if (grammar != null) {
			if (!GrammarsRegistry.instance().containsGrammar(grammarURI)) {
				bm.wEnterScope();
				InterpreterOperation.interpret(grammar, bm);
				bm.wExitScope();
			}
			grammar = null;
		}
	}

	@Override
	public boolean isLossless() {
		return false;
	}

	@Override
	protected void doBeforeReading(IPersistenceProvider pp) throws Exception {
		ensureGrammarDeployed(pp.getBindings());
		super.doBeforeReading(pp);
	}

	@Override
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		return GrammarsUtils.parse(StringUtils.readAsString(pp.getInputStream(), pp.getEncoding()), grammarURI);
	}

	@Override
	protected IEntity doBeforeWriting(IEntity model, IPersistenceProvider pp) throws Exception {
		ensureGrammarDeployed(pp.getBindings());
		return super.doBeforeWriting(model, pp);
	}

	@Override
	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		PrintStream printStream = new PrintStream(pp.getOutputStream(), false, pp.getEncoding());
		GrammarsUtils.unparse(model, printStream, grammarURI);
		printStream.flush();
	}

	public static Grammar removeLanguageDescriptor(Grammar grammar) {
		TargetLanguage targetLanguage = grammar.getTargetLanguage();
		if (Matcher.match(GrammarsEntityDescriptorEnum.URI, targetLanguage))
			return grammar;

		grammar.setTargetLanguage(EntityUtils.remove(((LanguageDescriptor) targetLanguage).getUri()));
		return grammar;
	}
}
