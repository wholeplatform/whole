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
package org.whole.lang.commons.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.commons.builders.CommonsGenericBuilderAdapter;
import org.whole.lang.commons.builders.CommonsSpecificBuilderAdapter;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.visitors.CommonsContentAssistVisitor;
import org.whole.lang.commons.visitors.CommonsDynamicCompilerVisitor;
import org.whole.lang.commons.visitors.CommonsInterpreterVisitor;
import org.whole.lang.commons.visitors.CommonsPrettyPrinterVisitor;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @author Riccardo Solmi
 */
public class CommonsLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.addLanguageKit(new CommonsLanguageKit());
		platform.addOperationFactory(CommonsLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
			public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
				return new CommonsGenericBuilderAdapter((ICommonsBuilder) strategy, entityContext);
			}
		});
		platform.addOperationFactory(CommonsLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
			public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
				return new CommonsSpecificBuilderAdapter(strategy, entityContext);
			}
		});
		platform.addOperationFactory(CommonsLanguageKit.URI, ContentAssistOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new CommonsContentAssistVisitor();
			}
		});
		platform.addOperationFactory(CommonsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new CommonsInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(CommonsLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new CommonsDynamicCompilerVisitor();
				else
					return null;
			}
		});

		platform.addOperationFactory(CommonsLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new CommonsPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(CommonsLanguageKit.URI);
	}
}
