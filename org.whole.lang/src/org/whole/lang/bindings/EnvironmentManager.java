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
package org.whole.lang.bindings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.whole.lang.operations.CloneContext;
import org.whole.lang.operations.ICloneContext;
import org.whole.lang.operations.IOperation;
import org.whole.lang.util.FreshNameGenerator;


/**
 * @author Riccardo Solmi
 */
public class EnvironmentManager implements IEnvironmentManager {
	private IOperation currentOperation;
	private Map<String, IBindingManager> environments = new HashMap<String, IBindingManager>();
	protected FreshNameGenerator freshNameGenerator = new FreshNameGenerator();

	protected EnvironmentManager() {
		//FIXME test only
//		currentOperation = new AnonymousOperation(this);
	}

	public IEnvironmentManager clone() {
		return clone(new CloneContext());
	}
	public IEnvironmentManager clone(ICloneContext cc) {
		EnvironmentManager em = new EnvironmentManager();
		cc.putClone(this, em);
		for (String envName : getEnvironmentNames())
			em.environments.put(em.freshNameGenerator.nextFreshName(envName),
					cc.clone(getEnvironment(envName)));
		return em;
	}

	public IOperation getCurrentOperation() {
		return currentOperation;
	}
	public void enterOperation(IOperation operation) {
		currentOperation = operation;
	}
	public void exitOperation() {
		if (currentOperation == null)
			throw new IllegalStateException("exitOperation from top level");
		currentOperation = currentOperation.getEnclosingOperation();
	}

	public Set<String> getEnvironmentNames() {
		return environments.keySet();
	}
	public String getEnvironmentName(IBindingManager env) {
		for ( Entry<String, IBindingManager> e : environments.entrySet())
			if (e.getValue() == env)
				return e.getKey();
		return null;
	}

	public IBindingManager getEnvironment(String name) {
		IBindingManager env = environments.get(name);
		if (env == null)
			env = createEnvironment(name);
		return env;
	}

	public IBindingManager createEnvironment(String namePrefix) {
		return createEnvironment(namePrefix, BindingManagerFactory.instance.createSimpleScope());
	}
	public IBindingManager createEnvironment(String namePrefix, IBindingScope scope) {
		IBindingManager env;
		environments.put(freshNameGenerator.nextFreshName(namePrefix),
				env = BindingManagerFactory.instance.createBindingManager(scope, this));
		return env;
	}

	public IBindingManager removeEnvironment(String name) {
		return environments.remove(name);
	}
}
