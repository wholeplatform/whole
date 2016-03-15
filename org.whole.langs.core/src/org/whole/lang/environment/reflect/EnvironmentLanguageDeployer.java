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
package org.whole.lang.environment.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.environment.builders.EnvironmentGenericBuilderAdapter;
import org.whole.lang.environment.builders.EnvironmentSpecificBuilderAdapter;
import org.whole.lang.environment.builders.IEnvironmentBuilder;
import org.whole.lang.environment.visitors.EnvironmentInterpreterVisitor;
import org.whole.lang.environment.visitors.EnvironmentPrettyPrinterVisitor;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 * @generator Whole
 */
public class EnvironmentLanguageDeployer extends AbstractLanguageDeployer {
	public void deploy(ReflectionFactory platform) {
        platform.addLanguageKit(new EnvironmentLanguageKit());
        platform.addOperationFactory(EnvironmentLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new EnvironmentGenericBuilderAdapter((IEnvironmentBuilder) strategy, entityContext);
            }
        });
        platform.addOperationFactory(EnvironmentLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new EnvironmentSpecificBuilderAdapter(strategy, entityContext);
				}
			});

		platform.addOperationFactory(EnvironmentLanguageKit.URI, InterpreterOperation.ID, new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return stage == 0 ? new EnvironmentInterpreterVisitor() : null;
			}
		});

		platform.addOperationFactory(EnvironmentLanguageKit.URI,
				ArtifactsGeneratorOperation.ID, new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return stage == 0 ? new EnvironmentInterpreterVisitor() : null;
			}
		});
	
		platform.addOperationFactory(EnvironmentLanguageKit.URI, PrettyPrinterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new EnvironmentPrettyPrinterVisitor((PrettyPrinterOperation) operation);
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeLanguageKit(EnvironmentLanguageKit.URI);
	}
}