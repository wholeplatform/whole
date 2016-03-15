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
package org.whole.lang.jdt;


import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author Enrico Persiani
 */
public class PlatformLibraryContainerInitializer extends ClasspathContainerInitializer {
	public PlatformLibraryContainerInitializer() {
	}

	public void initialize(IPath path, IJavaProject project) throws CoreException {
		if (!PlatformLibraryClasspathContainer.sameKind(path))
			return;

		PlatformLibraryClasspathContainer container = new PlatformLibraryClasspathContainer(getExclusions(path));
		JavaCore.setClasspathContainer(path, new IJavaProject[] { project }, new IClasspathContainer[] { container }, null);
	}

	public static Set<String> getExclusions(String hint) {
		Set<String> bundles = new HashSet<String>();
		for (String bundleID : hint.split(","))
			bundles.add(bundleID);
		return bundles;
	}
	public static Set<String> getExclusions(IPath path) {
		return path.segmentCount()>1 ? getExclusions(path.segment(1)) : Collections.<String>emptySet();
	}
	public static String calculateExclusionsHint(Set<String> bundles) {
		if (bundles.isEmpty())
			return null;
	
		StringBuilder sb = new StringBuilder();
		Iterator<String> iterator = bundles.iterator();
		if (iterator.hasNext())
			sb.append(iterator.next());
		while (iterator.hasNext()) {
			sb.append(',');
			sb.append(iterator.next());
		}
		return sb.toString();
	}

	public static IPath calculatePath(Set<String> bundles) {
		IPath path = PlatformLibraryClasspathContainer.getBasePath();
		String excludeHint = calculateExclusionsHint(bundles);
		return excludeHint != null ? path.append(excludeHint) : path;
	}
}
