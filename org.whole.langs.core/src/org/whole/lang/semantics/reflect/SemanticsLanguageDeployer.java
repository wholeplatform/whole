/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.semantics.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.semantics.builders.ISemanticsBuilder;
import org.whole.lang.semantics.builders.SemanticsGenericBuilderAdapter;
import org.whole.lang.semantics.builders.SemanticsSpecificBuilderAdapter;
import org.whole.lang.semantics.visitors.SemanticsDynamicCompilerVisitor;
import org.whole.lang.semantics.visitors.SemanticsInterpreterVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/** 
 * @generator Whole
 */
public class SemanticsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new SemanticsLanguageKit());
		platform.addOperationFactory(SemanticsLanguageKit.URI,
				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new SemanticsGenericBuilderAdapter(
								(ISemanticsBuilder) strategy, entityContext);
					}
				});
		platform.addOperationFactory(SemanticsLanguageKit.URI,
				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
					public IBuilder create(IBuilder strategy,
							IEntityContext entityContext) {
						return new SemanticsSpecificBuilderAdapter(strategy,
								entityContext);
					}
				});

		platform.addOperationFactory(SemanticsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new SemanticsInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(SemanticsLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new SemanticsDynamicCompilerVisitor();
				else
					return null;
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(SemanticsLanguageKit.URI);
	}
}
