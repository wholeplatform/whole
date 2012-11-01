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
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Enrico Persiani
 */
public class WholeSearchResultUpdater implements IResourceChangeListener,
		IQueryListener {

	private final class ResourceDeltaVisitor implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource res = delta.getResource();
			if (res instanceof IFile) {
				switch (delta.getKind()) {
					case IResourceDelta.ADDED :
						// TODO not implemented yet
						break;
					case IResourceDelta.REMOVED :
						result.removeMatches((IFile) res);
						break;
					case IResourceDelta.CHANGED :
						// TODO not implemented yet
						break;
				}
			}
			return true;
		}
	}
	private WholeSearchResult result;

	public WholeSearchResultUpdater(WholeSearchResult result) {
		this.result = result;
		NewSearchUI.addQueryListener(this);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	public void resourceChanged(IResourceChangeEvent event) {
		IResourceDelta delta = event.getDelta();
		if (delta != null)
			try {
				delta.accept(new ResourceDeltaVisitor());
			} catch (CoreException e) {
				WholeUIPlugin.log(e);
			}
	}

	public void queryRemoved(ISearchQuery query) {
		if (result.equals(query.getSearchResult())) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
			NewSearchUI.removeQueryListener(this);
		}
	}

	public void queryAdded(ISearchQuery query) { }
	public void queryFinished(ISearchQuery query) { }
	public void queryStarting(ISearchQuery query) { }
}
