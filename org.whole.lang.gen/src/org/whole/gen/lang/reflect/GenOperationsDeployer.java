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
package org.whole.gen.lang.reflect;

import org.whole.lang.artifacts.reflect.ArtifactsLanguageKit;
import org.whole.lang.artifacts.visitors.ResourceArtifactsGeneratorVisitor;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.reflect.GrammarsLanguageKit;
import org.whole.lang.java.reflect.JavaLanguageKit;
import org.whole.lang.misc.reflect.MiscLanguageKit;
import org.whole.lang.misc.visitors.MiscTraverseAllVisitor;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.pojo.reflect.PojoLanguageKit;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.ArtifactsJavaModelGeneratorVisitor;
import org.whole.lang.visitors.ArtifactsJavaStoreGeneratorVisitor;
import org.whole.lang.visitors.GrammarsJavaModelGeneratorVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.visitors.JavaJavaModelGeneratorVisitor;
import org.whole.lang.visitors.JavaJavaStoreGeneratorVisitor;
import org.whole.lang.visitors.MiscJavaStoreGeneratorVisitor;
import org.whole.lang.visitors.ModelsJavaModelGeneratorVisitor;
import org.whole.lang.visitors.ModelsJavaStoreGeneratorVisitor;
import org.whole.lang.visitors.PojoJavaModelGeneratorVisitor;
import org.whole.lang.visitors.PojoJavaStoreGeneratorVisitor;
import org.whole.lang.visitors.WorkspaceArtifactsGeneratorVisitor;
import org.whole.lang.workflows.model.ResourceKind;
import org.whole.lang.workflows.model.ResourceKindEnum;

public class GenOperationsDeployer extends AbstractLanguageExtensionDeployer {
	public void deploy(ReflectionFactory platform) {
		// from java (legacy)
		platform.addOperationFactory(JavaLanguageKit.URI, JavaCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new JavaJavaModelGeneratorVisitor();
				else
					return new JavaJavaStoreGeneratorVisitor(((JavaCompilerOperation) operation).getGenerator().javaStoreBuilder(), true);
			}
		}
		);

		// from artifacts (core)
		platform.addOperationFactory(ArtifactsLanguageKit.URI, JavaCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ArtifactsJavaModelGeneratorVisitor();
				else
					return new ArtifactsJavaStoreGeneratorVisitor(((JavaCompilerOperation) operation).getGenerator().javaStoreBuilder(), true);
			}
		});

		platform.addOperationFactory(ArtifactsLanguageKit.URI, ArtifactsGeneratorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
//				if (stage == 0)
				IBindingManager args = operation.getOperationEnvironment();
				if (args.wIsSet("resourceKind") &&
						ResourceKindEnum.FILE_SYSTEM.equals(((ResourceKind) args.wGet("resourceKind")).getValue()))
						return new ResourceArtifactsGeneratorVisitor();
				else
					return new WorkspaceArtifactsGeneratorVisitor();
			}
		});

		// from editors (core)
//		platform.addOperationFactory(EditorsLanguageKit.URI, JavaCompilerOperation.ID,
//				new IVisitorFactory() {
//			public IVisitor create(IOperation operation, int stage) {
//				if (stage == 0)
//					return new EditorsJavaModelGeneratorVisitor();
//				else
//					return new EditorsJavaStoreGeneratorVisitor(((JavaCompilerOperation) operation).getGenerator().javaStoreBuilder(), true);
//			}
//		});

		// misc (core)
		platform.addOperationFactory(MiscLanguageKit.URI, JavaCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new MiscTraverseAllVisitor();
				else
					return new MiscJavaStoreGeneratorVisitor(((JavaCompilerOperation) operation).getGenerator().javaStoreBuilder(), true);
			}
		});

		// from models (core)
		platform.addOperationFactory(ModelsLanguageKit.URI, JavaCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ModelsJavaModelGeneratorVisitor();
				else
					return new ModelsJavaStoreGeneratorVisitor(((JavaCompilerOperation) operation).getGenerator().javaStoreBuilder(), true);
			}
		});

		platform.addOperationFactory(GrammarsLanguageKit.URI, JavaCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new GrammarsJavaModelGeneratorVisitor();
			}
		});

		// from pojo (core.op)
		platform.addOperationFactory(PojoLanguageKit.URI, JavaCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new PojoJavaModelGeneratorVisitor();
				else
					return new PojoJavaStoreGeneratorVisitor(((JavaCompilerOperation) operation).getGenerator().javaStoreBuilder(), true);
			}
		});

	}
}
