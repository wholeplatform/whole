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
package org.whole.examples.dataintegration.xsd;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractContributionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;

/**
 * @author Enrico Persiani
 */
public class DTAUSDeployer extends AbstractContributionDeployer {
	public void deploy(ReflectionFactory platform) {
		try {
			IBindingManager bm = BindingManagerFactory.instance.createArguments();
			IEntity model = XsdPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/examples/dataintegration/xsd/pain.001.001.02.xsd", bm));
			InterpreterOperation.interpret(model, bm);

			InterpreterOperation.interpret(new DTAUSGrammar().create());

			model = XmlBuilderPersistenceKit.instance().readModel(
					new ClasspathPersistenceProvider("org/whole/examples/dataintegration/xsd/DTAUSActions.xwl"));
			InterpreterOperation.interpret(model);
		} catch (Exception e) {
			E4CompatibilityPlugin.log(e);
		}
	}
}
