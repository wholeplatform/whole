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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.IGrammarsEntity;
import org.whole.lang.grammars.model.LanguageDescriptor;
import org.whole.lang.grammars.model.TargetLanguage;
import org.whole.lang.grammars.parsers.GrammarBasedDataTypeParser;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.DynamicLanguageKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class GrammarsInterpreterVisitor extends GrammarsIdentityDefaultVisitor {
	@Override
	public void visit(IGrammarsEntity entity) {
		Grammar g = Matcher.findAncestor(GrammarsEntityDescriptorEnum.Grammar, entity);
		if (g != null)
			visit(g);

		throw new VisitException();
	}

	protected Grammar normalize(Grammar grammar) {
		grammar = EntityUtils.clone(grammar);
		NormalizerOperation.normalize(grammar);
		GrammarsUtils.ensureCompiledPatterns(grammar);
		return grammar;
	}

	@Override
	public void visit(Grammar grammar) {
		grammar = normalize(grammar);

		GrammarsRegistry.instance().putGrammar(grammar);

		TargetLanguage targetLanguage = grammar.getTargetLanguage();
		ILanguageKit languageKit = null;
		final String languageUri;
		IBindingManager bm = getBindings();
		if (Matcher.match(GrammarsEntityDescriptorEnum.URI, targetLanguage)) {
			String contextUri = bm.wIsSet("contextURI") ? bm.wStringValue("contextURI") : null;
			languageUri = targetLanguage.wStringValue();
			languageKit = ReflectionFactory.getLanguageKit(languageUri, true, contextUri);
		} else {
			languageUri = ((LanguageDescriptor) targetLanguage).getUri().getValue();
			stagedVisit(GrammarsUtils.deriveModel(grammar, false));
			languageKit = (ILanguageKit) bm.getResult().wGetValue();
		}

		if (languageKit.isDynamic()) {
			DynamicLanguageKit dynamicLanguageKit = (DynamicLanguageKit) languageKit;
			GrammarBasedDataTypeParser dataTypeParser = new GrammarBasedDataTypeParser(grammar.getUri().getValue());
			dynamicLanguageKit.setDataTypeParser(DataTypeParsers.PERSISTENCE, dataTypeParser);
			dynamicLanguageKit.setDataTypeParser(DataTypeParsers.PRESENTATION, dataTypeParser);
		}

		ReflectionFactory.updatePersistenceAndEditorKits(languageKit);

		ReflectionFactory.deploy(new AbstractLanguageExtensionDeployer() {
			public void deploy(ReflectionFactory platform) {
				platform.addOperationFactory(languageUri, PrettyPrinterOperation.ID, new IVisitorFactory() {
					public IVisitor create(IOperation operation, int stage) {
						return new GenericGrammarBasedPrettyPrinterVisitor((PrettyPrinterOperation) operation);
					}
				});
				platform.addOperationFactory(languageUri, ValidatorOperation.ID, new IVisitorFactory() {
					public IVisitor create(IOperation operation, int stage) {
						return new GenericGrammarBasedValidatorVisitor();
					}
				});
			}
		});
	}
}
