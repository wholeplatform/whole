/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.search;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractWholeResourceVisitor implements IResourceVisitor {
	private boolean endVisit;
	private IWholeSearchScope scope;
	
	public AbstractWholeResourceVisitor(IWholeSearchScope scope) {
		endVisit = false;
		this.scope = scope;
	}

	public abstract boolean visit(IFile file, IPersistenceKit persistenceKit);
	
	public boolean visit(IResource resource) throws CoreException {
		if (!scope.encloses(resource))
			return false;

		if (resource instanceof IFile) {
			IFile file = ((IFile) resource);
			IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
			IEditorDescriptor[] editorDescriptors = registry.getEditors(file.getName());
			boolean foundPersistenceKit = false;
			for (IEditorDescriptor editorDescriptor : editorDescriptors) {
				if (ReflectionFactory.hasAssociatedPersistenceKit(editorDescriptor.getId())) {
					IPersistenceKit persistenceKit = 
						ReflectionFactory.getPersistenceKitFromEditorId(editorDescriptor.getId());
					endVisit = !visit(file, persistenceKit);
					foundPersistenceKit = true;
				}
			}
			if (!foundPersistenceKit) {
				IPersistenceKit persistenceKit = ReflectionFactory.getDefaultPersistenceKit();
				endVisit = !visit(file, persistenceKit);
			}
		}
		return !endVisit;
	}

	public void searchScope() throws CoreException {
		for (IResource root : scope.getRoots())
			root.accept(this);
	}
}
