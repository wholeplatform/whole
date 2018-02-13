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
package org.whole.examples;

import org.whole.examples.annotations.AnnotationsActions;
import org.whole.examples.dataintegration.motogp.MotoGP_TeamsActions;
import org.whole.examples.dataintegration.motogp.MotoGP_TeamsCSVGrammar;
import org.whole.examples.dataintegration.motogp.MotoGP_TeamsFLFGrammar;
import org.whole.examples.dataintegration.xsd.DTAUSDeployer;
import org.whole.examples.datatypes.RedBlackTreeActions;
import org.whole.examples.datatypes.RedBlackTreeUIDeployer;
import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeLanguageDeployer;
import org.whole.examples.javadocs.JavadocsActions;
import org.whole.examples.lang.imp.ImpActions;
import org.whole.examples.lang.imp.reflect.ImpLanguageDeployer;
import org.whole.examples.lang.imp.ui.ImpUIDeployer;
import org.whole.examples.patterns.JavaPatternsActions;
import org.whole.examples.xml.XmlActions;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractSuiteDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Riccardo Solmi
 */
public class ExamplesContributionsDeployer extends AbstractSuiteDeployer {
	public int getDeployLevel() {
		return IDeployer.LEVEL_CONTRIB;
	}

	@SuppressWarnings("unchecked")
	public ExamplesContributionsDeployer() {
		super(
			ImpLanguageDeployer.class,
			ImpUIDeployer.class,
			RedBlackTreeLanguageDeployer.class,
			RedBlackTreeUIDeployer.class,
			DTAUSDeployer.class
		);
	}

	public void deploy(ReflectionFactory platform) {
		super.deploy(platform);
		try {
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/examples/lang/imp/ImpSemantics.xwl")));
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		InterpreterOperation.interpret(new AnnotationsActions().create());
		InterpreterOperation.interpret(new ImpActions().create());
		InterpreterOperation.interpret(new JavadocsActions().create());
		InterpreterOperation.interpret(new JavaPatternsActions().create());
		InterpreterOperation.interpret(new MotoGP_TeamsCSVGrammar().create());
		InterpreterOperation.interpret(new MotoGP_TeamsFLFGrammar().create());
		InterpreterOperation.interpret(new MotoGP_TeamsActions().create());
		InterpreterOperation.interpret(new RedBlackTreeActions().create());
		InterpreterOperation.interpret(new XmlActions().create());
	}
}
