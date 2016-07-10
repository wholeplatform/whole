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
package org.whole.langs.core.ui;

import org.whole.lang.actions.ui.ActionsUIDeployer;
import org.whole.lang.artifacts.ui.ArtifactsUIDeployer;
import org.whole.lang.changes.ui.ChangesUIDeployer;
import org.whole.lang.commons.ui.CommonsUIDeployer;
import org.whole.lang.editors.ui.EditorsUIDeployer;
import org.whole.lang.editors.visitors.EditorsOperationsDeployer;
import org.whole.lang.environment.ui.EnvironmentUIDeployer;
import org.whole.lang.frames.ui.FramesUIDeployer;
import org.whole.lang.grammarbased.GrammarBasedActions;
import org.whole.lang.grammarbased.ui.GrammarBasedUIDeployer;
import org.whole.lang.grammars.ui.GrammarsUIDeployer;
import org.whole.lang.math.ui.MathUIDeployer;
import org.whole.lang.misc.ui.MiscUIDeployer;
import org.whole.lang.models.ui.ModelsUIDeployer;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.patterns.ui.PatternsUIDeployer;
import org.whole.lang.pojo.ui.PojoUIDeployer;
import org.whole.lang.queries.ui.QueriesUIDeployer;
import org.whole.lang.reflect.AbstractSuiteDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.reusables.ui.ReusablesUIDeployer;
import org.whole.lang.semantics.ui.SemanticsUIDeployer;
import org.whole.lang.status.ui.StatusUIDeployer;
import org.whole.lang.syntaxtrees.ui.SyntaxTreesEditorKit;
import org.whole.lang.templates.ui.TemplatesUIDeployer;
import org.whole.lang.tests.ui.TestsEditorDeployer;
import org.whole.lang.types.ui.TypesUIDeployer;
import org.whole.lang.versions.ui.VersionsUIDeployer;
import org.whole.lang.workflows.reflect.WorkflowsLanguageKit;
import org.whole.lang.workflows.ui.WorkflowsUIDeployer;

/**
 * @author Riccardo Solmi
 */
public class CoreUIDeployer extends AbstractSuiteDeployer {
	public int getDeployLevel() {
		return IDeployer.LEVEL_LANGUAGE_EXTENSION;
	}

	@SuppressWarnings("unchecked")
	public CoreUIDeployer() {
		super(
			ActionsUIDeployer.class,
			ArtifactsUIDeployer.class,
			ChangesUIDeployer.class,
			CommonsUIDeployer.class,
			EditorsOperationsDeployer.class,
			EditorsUIDeployer.class,
			EnvironmentUIDeployer.class,
			FramesUIDeployer.class,
			GrammarsUIDeployer.class,
			GrammarBasedUIDeployer.class,
			MathUIDeployer.class,
			MiscUIDeployer.class,
			ModelsUIDeployer.class,
			PatternsUIDeployer.class,
			PojoUIDeployer.class,
			QueriesUIDeployer.class,
			ReusablesUIDeployer.class,
			SemanticsUIDeployer.class,
			StatusUIDeployer.class,
			TemplatesUIDeployer.class,
			TestsEditorDeployer.class,
			TypesUIDeployer.class,
			VersionsUIDeployer.class,
			WorkflowsUIDeployer.class
		);
	}

	@Override
	public void deploy(ReflectionFactory platform) {
		super.deploy(platform);

		new SyntaxTreesEditorKit().getDeployer().deploy(platform);

		if (!ReflectionFactory.getLanguageKit(WorkflowsLanguageKit.URI).hasVisitor(ContentAssistOperation.ID))
			ReflectionFactory.deploy(WorkflowsUIContentAssistDeployer.class);

		InterpreterOperation.interpret(new GrammarBasedActions().create());
	}
}
