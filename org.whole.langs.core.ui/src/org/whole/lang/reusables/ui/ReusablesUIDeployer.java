/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.reusables.ui;

import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.reusables.reflect.ReusablesLanguageKit;
import org.whole.lang.reusables.visitors.ReusablesUIDynamicCompilerVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;

public class ReusablesUIDeployer extends AbstractLanguageExtensionDeployer {

	public void deploy(ReflectionFactory platform) {
		platform.addEditorKit(ReusablesEditorKit.ID);

		platform.addOperationFactory(ReusablesLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new ReusablesUIDynamicCompilerVisitor();
				else
					return null;
			}
		});
	}

	public void undeploy(ReflectionFactory platform) {
		platform.removeEditorKit(ReusablesEditorKit.ID);
	}
}
