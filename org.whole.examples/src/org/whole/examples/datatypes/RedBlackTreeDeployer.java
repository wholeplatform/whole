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
package org.whole.examples.datatypes;

import org.whole.examples.datatypes.redblacktree.reflect.RedBlackTreeLanguageDeployer;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractSuiteDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class RedBlackTreeDeployer extends AbstractSuiteDeployer {
	public int getDeployLevel() {
		return IDeployer.LEVEL_CONTRIB;
	}

	@SuppressWarnings("unchecked")
	public RedBlackTreeDeployer() {
		super(
			RedBlackTreeLanguageDeployer.class,
			RedBlackTreeUIDeployer.class
		);
	}

	public void deploy(ReflectionFactory platform) {
		super.deploy(platform);
		InterpreterOperation.interpret(new RedBlackTreeActions().create());
	}
}
