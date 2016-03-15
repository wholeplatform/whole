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

import org.whole.lang.ReflectLibraryDeployer;
import org.whole.lang.ViewDerivationLibraryDeployer;
import org.whole.lang.editors.reflect.EditorsLanguageKit;
import org.whole.lang.editors.visitors.EditorsArtifactsGeneratorVisitor;
import org.whole.lang.frames.reflect.FramesLanguageKit;
import org.whole.lang.frames.visitors.FramesInterpreterVisitor;
import org.whole.lang.grammars.codebase.GrammarsPersistenceKit;
import org.whole.lang.grammars.codebase.MediaWikiPersistenceKit;
import org.whole.lang.grammars.codebase.ObjectiveCPersistenceKit;
import org.whole.lang.grammars.reflect.GrammarsLanguageKit;
import org.whole.lang.grammars.visitors.GrammarsContentAssistVisitor;
import org.whole.lang.grammars.visitors.GrammarsInterpreterVisitor;
import org.whole.lang.grammars.visitors.GrammarsValidatorVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.pojo.reflect.PojoLanguageKit;
import org.whole.lang.pojo.visitors.PojoArtifactsGeneratorVisitor;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.reflect.TemplatesLanguageKit;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @author Riccardo Solmi
 */
public class CoreOperationsDeployer extends AbstractLanguageExtensionDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addOperationFactory(EditorsLanguageKit.URI, ArtifactsGeneratorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new EditorsArtifactsGeneratorVisitor((ArtifactsGeneratorOperation) operation);
			}
		});

		platform.addOperationFactory(GrammarsLanguageKit.URI, ContentAssistOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new GrammarsContentAssistVisitor();
			}
		});
		platform.addOperationFactory(GrammarsLanguageKit.URI, ValidatorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new GrammarsValidatorVisitor();
			}
		});

		if (!ReflectionFactory.getLanguageKit(GrammarsLanguageKit.URI, false, null).hasVisitor(InterpreterOperation.ID))
			platform.addOperationFactory(GrammarsLanguageKit.URI, InterpreterOperation.ID,
					new IVisitorFactory() {
				public IVisitor create(IOperation operation, int stage) {
					if (stage == 0)
						return new GrammarsInterpreterVisitor();
					else
						return null;
				}
			});
		platform.addPersistenceKit("org.whole.lang.grammars.GrammarEditor", GrammarsPersistenceKit.instance());
		platform.addPersistenceKit("org.whole.lang.objectivec.ObjectiveCEditor", ObjectiveCPersistenceKit.instance());
		platform.addPersistenceKit("org.whole.lang.mediawiki.MediaWikiEditor", MediaWikiPersistenceKit.instance());

		platform.addOperationFactory(TemplatesLanguageKit.URI, ArtifactsGeneratorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new AbstractVisitor() {
					public void visit(IEntity entity) {
						BehaviorUtils.apply("whole:org.whole.lang.templates:TemplatesSemantics#toJava", entity, getBindings());
					}
				};
			}
		});

		platform.addOperationFactory(PojoLanguageKit.URI, ArtifactsGeneratorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new PojoArtifactsGeneratorVisitor((ArtifactsGeneratorOperation) operation);
			}
		});


		platform.addOperationFactory(FramesLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new FramesInterpreterVisitor();
				else
					return null;
			}
		});

		//TODO test
//		ReflectLibrary.deploy();
		new ReflectLibraryDeployer().deploy(platform);
		new ViewDerivationLibraryDeployer().deploy(platform);
	}
}
