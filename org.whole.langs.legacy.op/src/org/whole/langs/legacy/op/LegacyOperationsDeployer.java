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

import org.whole.lang.mediawiki.MediaWikiActions;
import org.whole.lang.models.codebase.MediaWikiModel;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.xsd.codebase.CommonsMappingStrategy;
import org.whole.lang.xsd.codebase.MappingActions;
import org.whole.lang.xsd.codebase.MappingStrategyRegistry;
import org.whole.lang.xsd.codebase.SchemaActions;
import org.whole.lang.xsd.codebase.SchemaModelsActions;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.codebase.XsiPersistenceKit;
import org.whole.lang.xsd.reflect.XsdLanguageKit;
import org.whole.lang.xsd.resources.XsdRegistry;
import org.whole.lang.xsd.visitors.XsdPrettyPrinterVisitor;
import org.whole.langs.legacy.LegacyMetaModelsDeployer;

/**
 * @author Riccardo Solmi
 */
public class LegacyOperationsDeployer extends AbstractLanguageExtensionDeployer {
	public void deploy(ReflectionFactory platform) {
		InterpreterOperation.interpret(new MediaWikiModel().create());
		InterpreterOperation.interpret(new MediaWikiActions().create());

		//TODO move to MappingStrategyRegistry?
		MappingStrategyRegistry.instance().putMappingStrategy(new CommonsMappingStrategy());

		InterpreterOperation.interpret(new SchemaActions().create());
		platform.addOperationFactory(XsdLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new XsdPrettyPrinterVisitor();
			}
		});

		//TODO rewrite using queries/actions in SchemaActions
//		platform.addOperationFactory(XsdLanguageKit.ID, ArtifactsGeneratorOperation.ID,
//				new IVisitorFactory() {
//			public IVisitor create(IOperation operation, int stage) {
//				return new Xsd2ModelsArtifactsGeneratorVisitor((ArtifactsGeneratorOperation) operation);
//			}
//		});
		InterpreterOperation.interpret(new MappingActions().create());

//FIXME requires WorkflowsInterpreter see WorkflowsInterpreterDeployer
		XsdRegistry.initialize(); 

		platform.addPersistenceKit("org.whole.lang.xsd.XsdSourceEditor", XsdPersistenceKit.instance());
		platform.addPersistenceKit("org.whole.lang.xsd.XsiSourceEditor", XsiPersistenceKit.instance());

		InterpreterOperation.interpret(new SchemaModelsActions().create());
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(LegacyMetaModelsDeployer.MEDIAWIKI_URI);
		XsdRegistry.deinitialize();
	}
}
