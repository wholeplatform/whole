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
package org.whole.lang.reusables.reflect;

import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractLanguageDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.reusables.builders.IReusablesBuilder;
import org.whole.lang.reusables.builders.ReusablesGenericBuilderAdapter;
import org.whole.lang.reusables.builders.ReusablesSpecificBuilderAdapter;
import org.whole.lang.reusables.visitors.ReusablesArtifactsGeneratorVisitor;
import org.whole.lang.reusables.visitors.ReusablesInterpreterVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

/**
 *  @generator  Whole
 */
public class ReusablesLanguageDeployer extends AbstractLanguageDeployer {

    public void deploy(ReflectionFactory platform) {
        platform.addLanguageKit(new ReusablesLanguageKit());
        platform.addOperationFactory(ReusablesLanguageKit.URI, GenericBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ReusablesGenericBuilderAdapter((IReusablesBuilder) strategy, entityContext);
            }
        });
        platform.addOperationFactory(ReusablesLanguageKit.URI, SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {

            public IBuilder create(IBuilder strategy, IEntityContext entityContext) {
                return new ReusablesSpecificBuilderAdapter(strategy, entityContext);
            }
        });
        platform.addOperationFactory(ReusablesLanguageKit.URI, InterpreterOperation.ID,
        		new IVisitorFactory() {
        	public IVisitor create(IOperation operation, int stage) {
        		if (stage == 0)
        			return new ReusablesInterpreterVisitor();
        		else
        			return null;
        	}
        });
		platform.addOperationFactory(ReusablesLanguageKit.URI, ArtifactsGeneratorOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				return new ReusablesArtifactsGeneratorVisitor();
			}
		});
    }

    public void undeploy(ReflectionFactory platform) {
        platform.removeLanguageKit(ReusablesLanguageKit.URI);
    }
}
