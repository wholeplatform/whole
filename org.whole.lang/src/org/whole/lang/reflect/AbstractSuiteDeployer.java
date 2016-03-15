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
package org.whole.lang.reflect;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractSuiteDeployer extends AbstractDeployer {
	private final String[] deployerClassNames;

	public AbstractSuiteDeployer(String... deployerClassNames) {
		this.deployerClassNames = deployerClassNames;
	}
	public AbstractSuiteDeployer(Class<? extends IDeployer>... deployerClasses) {
		deployerClassNames = new String[deployerClasses.length];
		for (int i=0; i<deployerClassNames.length; i++)
			deployerClassNames[i] = deployerClasses[i].getName();
	}

	public void deploy(ReflectionFactory platform) {
		for (int i=0; i<deployerClassNames.length; i++)
			deploy(deployerClassNames[i]);
	}
	protected void deploy(String className) {
		ReflectionFactory.deploy(className);
	}
	public void undeploy(ReflectionFactory platform) {
		for (int i=deployerClassNames.length-1; i>=0; i--)
			undeploy(deployerClassNames[i]);		
	}
	protected void undeploy(String className) {
		ReflectionFactory.undeploy(className);
	}
}
