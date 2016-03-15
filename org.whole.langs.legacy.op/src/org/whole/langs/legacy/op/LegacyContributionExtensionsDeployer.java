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
package org.whole.langs.legacy.op;

import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.html.codebase.HtmlPersistenceKit;
import org.whole.lang.html.visitors.HtmlPrettyPrinterVisitor;
import org.whole.lang.javascript.reflect.JavaScriptLanguageKit;
import org.whole.lang.javascript.visitors.JavaScriptInterpreterVisitor;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractContributionExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;
import org.whole.langs.legacy.LegacyMetaModelsDeployer;

/**
 * @author Enrico Persiani
 */
public class LegacyContributionExtensionsDeployer extends AbstractContributionExtensionDeployer {
	public void deploy(ReflectionFactory platform) {
		try {
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/html/HTML5Semantics.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/html/HTML5Actions.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/javascript/JavaScriptSemantics.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/javascript/JavaScriptActions.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/ui/CaretActionsSemantics.xwl")));
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

		platform.addPersistenceKit("org.whole.lang.html.Html5Editor", HtmlPersistenceKit.instance());
		platform.addOperationFactory(LegacyMetaModelsDeployer.HTML5_URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new HtmlPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
		platform.addOperationFactory(JavaScriptLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new JavaScriptInterpreterVisitor();
				else
					return null;
			}
		});
	}
}
