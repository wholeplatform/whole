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
package org.whole.langs.core.op;

import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.queries.GenericQueriesActions;
import org.whole.lang.reflect.AbstractContributionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Riccardo Solmi
 */
public class CoreContributionsDeployer extends AbstractContributionDeployer {
	public void deploy(ReflectionFactory platform) {
		InterpreterOperation.interpret(new GenericQueriesActions().create());

		try {
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/actions/ActionsActions.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/artifacts/ArtifactsActions.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/grammars/GrammarsActions.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/models/ModelsActions.xwl")));


			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/semantics/SemanticsActions.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/tests/TestsActions.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/tests/GenericTestsActions.xwl")));

			//Require SemanticsActions
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/frames/FramesSemantics.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/templates/TemplatesSemantics.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/reusables/ReusablesActions.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/reusables/ReusablesGuestActions.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/patterns/PatternsSemantics.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/patterns/PatternsActions.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/patterns/PatternsGuestActions.xwl")));

			//Require Patterns Semantics and Actions
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/math/MathLibrary.xwl")));

			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/comparisons/ComparisonsPatterns.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/comparisons/DefaultComparisons.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/changes/ChangesActions.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/changes/RevisionsLibrary.xwl")));
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/lang/changes/RevisionsActions.xwl")));			

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit("whole:org.whole.lang.comparisons:ComparisonsPatternsModel");
	}
}
