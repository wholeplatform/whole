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
package org.whole.langs.core;

import org.whole.lang.actions.reflect.ActionsLanguageDeployer;
import org.whole.lang.artifacts.reflect.ArtifactsLanguageDeployer;
import org.whole.lang.changes.reflect.ChangesLanguageDeployer;
import org.whole.lang.editors.reflect.EditorsLanguageDeployer;
import org.whole.lang.environment.reflect.EnvironmentLanguageDeployer;
import org.whole.lang.frames.reflect.FramesLanguageDeployer;
import org.whole.lang.grammars.reflect.GrammarsLanguageDeployer;
import org.whole.lang.math.reflect.MathLanguageDeployer;
import org.whole.lang.misc.reflect.MiscLanguageDeployer;
import org.whole.lang.models.reflect.ModelsLanguageDeployer;
import org.whole.lang.patterns.reflect.PatternsLanguageDeployer;
import org.whole.lang.pojo.reflect.PojoLanguageDeployer;
import org.whole.lang.queries.reflect.QueriesLanguageDeployer;
import org.whole.lang.reflect.AbstractSuiteDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reusables.reflect.ReusablesLanguageDeployer;
import org.whole.lang.semantics.reflect.SemanticsLanguageDeployer;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesLanguageDeployer;
import org.whole.lang.templates.reflect.TemplatesLanguageDeployer;
import org.whole.lang.tests.reflect.TestsLanguageDeployer;
import org.whole.lang.types.reflect.TypesLanguageDeployer;
import org.whole.lang.versions.reflect.VersionsLanguageDeployer;
import org.whole.lang.workflows.reflect.WorkflowsLanguageDeployer;

/**
 * @author Riccardo Solmi
 */
public class CoreLanguagesDeployer extends AbstractSuiteDeployer {
	public int getDeployLevel() {
		return IDeployer.LEVEL_LANGUAGE;
	}

	@SuppressWarnings("unchecked")
	public CoreLanguagesDeployer() {
		super(
			ActionsLanguageDeployer.class,
			ArtifactsLanguageDeployer.class,
			ChangesLanguageDeployer.class,
			EditorsLanguageDeployer.class,
			EnvironmentLanguageDeployer.class,
			FramesLanguageDeployer.class,
			GrammarsLanguageDeployer.class,
			MathLanguageDeployer.class,
			MiscLanguageDeployer.class,
			ModelsLanguageDeployer.class,
			PatternsLanguageDeployer.class,
			PojoLanguageDeployer.class,
			QueriesLanguageDeployer.class,
			ReusablesLanguageDeployer.class,
			SemanticsLanguageDeployer.class,
			SyntaxTreesLanguageDeployer.class,
			TemplatesLanguageDeployer.class,
			TestsLanguageDeployer.class,
			TypesLanguageDeployer.class,
			VersionsLanguageDeployer.class,
			WorkflowsLanguageDeployer.class
		);
	}
}
