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

import org.whole.lang.actions.reflect.ActionsLanguageKit;
import org.whole.lang.artifacts.reflect.ArtifactsLanguageKit;
import org.whole.lang.changes.reflect.ChangesLanguageKit;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.editors.reflect.EditorsLanguageKit;
import org.whole.lang.environment.reflect.EnvironmentLanguageKit;
import org.whole.lang.frames.reflect.FramesLanguageKit;
import org.whole.lang.grammars.reflect.GrammarsLanguageKit;
import org.whole.lang.math.reflect.MathLanguageKit;
import org.whole.lang.misc.reflect.MiscLanguageKit;
import org.whole.lang.models.codebase.ActionsModel;
import org.whole.lang.models.codebase.ArtifactsModel;
import org.whole.lang.models.codebase.EditorsModel;
import org.whole.lang.models.codebase.FramesModel;
import org.whole.lang.models.codebase.GrammarBasedModel;
import org.whole.lang.models.codebase.GrammarsModel;
import org.whole.lang.models.codebase.MathModel;
import org.whole.lang.models.codebase.MiscModel;
import org.whole.lang.models.codebase.ModelsModel;
import org.whole.lang.models.codebase.PojoModel;
import org.whole.lang.models.codebase.StatusModel;
import org.whole.lang.models.codebase.TemplatesModel;
import org.whole.lang.models.codebase.TestsModel;
import org.whole.lang.models.codebase.TypesModel;
import org.whole.lang.models.codebase.WorkflowModel;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.patterns.reflect.PatternsLanguageKit;
import org.whole.lang.pojo.reflect.PojoLanguageKit;
import org.whole.lang.queries.reflect.QueriesLanguageKit;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.reusables.reflect.ReusablesLanguageKit;
import org.whole.lang.semantics.reflect.SemanticsLanguageKit;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesLanguageKit;
import org.whole.lang.templates.reflect.TemplatesLanguageKit;
import org.whole.lang.tests.reflect.TestsLanguageKit;
import org.whole.lang.types.reflect.TypesLanguageKit;
import org.whole.lang.workflows.reflect.WorkflowsLanguageKit;

/**
 * @author Riccardo Solmi
 */
public class CoreMetaModelsDeployer extends AbstractLanguageExtensionDeployer {
	public static final String GRAMMAR_BASED_URI = "http://lang.whole.org/GrammarBased";
	public static final String STATUS_URI = "whole:org.whole.lang.status:Status";

	@Override
	public int getDeployLevel() {
		return super.getDeployLevel()+1;
	}

	public void deploy(ReflectionFactory platform) {
		platform.setMetaModelTemplate(CommonsLanguageKit.URI, "Commons model", "org/whole/lang/commons/CommonsModel.xwl");
		platform.setMetaModelTemplate(ActionsLanguageKit.URI, new ActionsModel());
		platform.setMetaModelTemplate(ArtifactsLanguageKit.URI, new ArtifactsModel());
		platform.setMetaModelTemplate(ChangesLanguageKit.URI, "Changes model", "org/whole/lang/changes/ChangesModel.xwl");
		platform.setMetaModelTemplate(EditorsLanguageKit.URI, new EditorsModel());
		platform.setMetaModelTemplate(EnvironmentLanguageKit.URI, "Environment model", "org/whole/lang/environment/EnvironmentModel.xwl");
		platform.setMetaModelTemplate(FramesLanguageKit.URI, new FramesModel());
		platform.setMetaModelTemplate(GrammarsLanguageKit.URI, new GrammarsModel());
		platform.setMetaModelTemplate(GRAMMAR_BASED_URI, new GrammarBasedModel());
		platform.setMetaModelTemplate(MathLanguageKit.URI, new MathModel());
		platform.setMetaModelTemplate(MiscLanguageKit.URI, new MiscModel());
		platform.setMetaModelTemplate(ModelsLanguageKit.URI, new ModelsModel());
		platform.setMetaModelTemplate(PatternsLanguageKit.URI, "Patterns model", "org/whole/lang/patterns/PatternsModel.xwl");
		platform.setMetaModelTemplate(PojoLanguageKit.URI, new PojoModel());
		platform.setMetaModelTemplate(QueriesLanguageKit.URI, "Queries Model", "org/whole/lang/queries/QueriesModel.xwl");
		platform.setMetaModelTemplate(ReusablesLanguageKit.URI, "Reusables model", "org/whole/lang/reusables/ReusablesModel.xwl");
		platform.setMetaModelTemplate(SemanticsLanguageKit.URI, "Semantics model", "org/whole/lang/semantics/SemanticsModel.xwl");
		platform.setMetaModelTemplate(STATUS_URI, new StatusModel());
		platform.setMetaModelTemplate(SyntaxTreesLanguageKit.URI, "Syntax Trees Model", "org/whole/lang/syntaxtrees/SyntaxTreesModel.xwl");
		platform.setMetaModelTemplate(TestsLanguageKit.URI, new TestsModel());
		platform.setMetaModelTemplate(TemplatesLanguageKit.URI, new TemplatesModel());
		platform.setMetaModelTemplate(TypesLanguageKit.URI, new TypesModel());
		platform.setMetaModelTemplate(WorkflowsLanguageKit.URI, new WorkflowModel());
	}

	public void undeploy(ReflectionFactory platform) {
		platform.unsetMetaModelTemplate(CommonsLanguageKit.URI);
		platform.unsetMetaModelTemplate(ActionsLanguageKit.URI);
		platform.unsetMetaModelTemplate(ArtifactsLanguageKit.URI);
		platform.unsetMetaModelTemplate(ChangesLanguageKit.URI);
		platform.unsetMetaModelTemplate(EditorsLanguageKit.URI);
		platform.unsetMetaModelTemplate(EnvironmentLanguageKit.URI);
		platform.unsetMetaModelTemplate(FramesLanguageKit.URI);
		platform.unsetMetaModelTemplate(GrammarsLanguageKit.URI);
		platform.unsetMetaModelTemplate(GRAMMAR_BASED_URI);
		platform.unsetMetaModelTemplate(MathLanguageKit.URI);
		platform.unsetMetaModelTemplate(MiscLanguageKit.URI);
		platform.unsetMetaModelTemplate(ModelsLanguageKit.URI);
		platform.unsetMetaModelTemplate(PatternsLanguageKit.URI);
		platform.unsetMetaModelTemplate(PojoLanguageKit.URI);
		platform.unsetMetaModelTemplate(QueriesLanguageKit.URI);
		platform.unsetMetaModelTemplate(ReusablesLanguageKit.URI);
		platform.unsetMetaModelTemplate(SemanticsLanguageKit.URI);
		platform.unsetMetaModelTemplate(STATUS_URI);
		platform.unsetMetaModelTemplate(SyntaxTreesLanguageKit.URI);
		platform.unsetMetaModelTemplate(TestsLanguageKit.URI);
		platform.unsetMetaModelTemplate(TemplatesLanguageKit.URI);
		platform.unsetMetaModelTemplate(TypesLanguageKit.URI);
		platform.unsetMetaModelTemplate(WorkflowsLanguageKit.URI);
	}
}
