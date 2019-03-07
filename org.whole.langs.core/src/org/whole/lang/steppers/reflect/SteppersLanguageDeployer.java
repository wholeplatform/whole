/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.steppers.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.steppers.builders.ISteppersBuilder;
import org.whole.lang.steppers.builders.SteppersGenericBuilderAdapter;
import org.whole.lang.steppers.builders.SteppersSpecificBuilderAdapter;
import org.whole.lang.steppers.visitors.SteppersInterpreterVisitor;
import org.whole.lang.steppers.visitors.SteppersDynamicCompilerVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 *  @generator Whole
 */
public class SteppersLanguageDeployer extends AbstractLanguageDeployer {

    public void deploy(ReflectionFactory platform) {
        platform.addLanguageKit(new SteppersLanguageKit());
        platform.addOperationFactory(SteppersLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new SteppersGenericBuilderAdapter((ISteppersBuilder) strategy, entityContext);
            }
        });
        platform.addOperationFactory(SteppersLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new SteppersSpecificBuilderAdapter(strategy, entityContext);
            }
        });
		platform.addOperationFactory(SteppersLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new SteppersInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(SteppersLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new SteppersDynamicCompilerVisitor();
				else
					return null;
			}
		});
    }

    public void undeploy(ReflectionFactory platform) {
        platform.removeLanguageKit(SteppersLanguageKit.URI);
    }
}
