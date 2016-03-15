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
package org.whole.lang.java.codebase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.util.ResourceUtils;

/**
 * @author Enrico Persiani
 */
public class JDTJavaBuilderPersistenceKit extends JavaBuilderPersistenceKit {
	private static class SingletonHolder {
		private static final JDTJavaBuilderPersistenceKit instance = new JDTJavaBuilderPersistenceKit();
	}
	public static final JDTJavaBuilderPersistenceKit instance() {
		return SingletonHolder.instance;
	}

	@Override
	public String getId() {
		return JavaBuilderPersistenceKit.class.getName();
	}

	@Override
	protected void doBeforeReading(IPersistenceProvider pp) throws Exception {
		ensureBuiltProject(pp);
	}

	@Override
	protected void doAfterWriting(IEntity model, IPersistenceProvider pp) throws Exception {
		ensureBuiltProject(pp);
	}

	protected void ensureBuiltProject(IPersistenceProvider pp) throws CoreException {
		IBindingManager bm = pp.getBindings();
		IProject project = (IProject) bm.wGetValue("project");
		// perform an incremental build to ensure class files are generated
		if (project.hasNature(JavaCore.NATURE_ID))
			project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, ResourceUtils.getProgressMonitor(bm));
	}
}
