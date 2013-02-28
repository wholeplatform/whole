/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.util;

import static org.whole.lang.ui.util.PlatformLibraryContainerInitializer.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.PDEClasspathContainer;
import org.whole.lang.ide.WholeIDEPlugin;

/**
 * @author Enrico Persiani
 */
public class PlatformLibraryClasspathContainer extends PDEClasspathContainer implements IClasspathContainer {
	public static final String WHOLERT_CONTAINER = WholeIDEPlugin.PLUGIN_ID + ".WHOLERT_CONTAINER";

	public static final Set<String> BUNDLE_IDS;
	static {
		Set<String> bundles = new HashSet<String>();
		bundles.add("org.whole.lang");
		bundles.add("org.whole.langs.core");
		bundles.add("org.whole.langs.core.op");
		bundles.add("org.whole.langs.legacy");
		bundles.add("org.whole.langs.legacy.op");
		bundles.add("org.whole.langs.db");
		bundles.add("org.whole.langs.db.op");
		
		// enabling features
		bundles.add("net.sourceforge.jodatime");
		bundles.add("org.objectweb.asm");
		bundles.add("org.beanshell.bsh");
		bundles.add("org.h2");
		bundles.add("org.mozilla.rhino");

		BUNDLE_IDS = Collections.unmodifiableSet(bundles);
	};

	protected Set<String> excludedBundleIDs;

	public PlatformLibraryClasspathContainer() {
		this(Collections.<String>emptySet());
	}
	public PlatformLibraryClasspathContainer(Set<String> excludedBundleIDs) {
		setExcludedBundleIDs(excludedBundleIDs);
	}

	public Set<String> getExcludedBundleIDs() {
		return excludedBundleIDs;
	}
	public void setExcludedBundleIDs(Set<String> exludefBundleIDs) {
		this.excludedBundleIDs = exludefBundleIDs;
	}

	protected boolean addBundle(String bundleId, List<IClasspathEntry> classpathEntryList) {
		IPluginModelBase pluginModelBase = PluginRegistry.findModel(bundleId);
		if (pluginModelBase == null || !pluginModelBase.isEnabled())
			return false;

		IResource underlyingResource = pluginModelBase.getUnderlyingResource();
		if (underlyingResource != null) {
			ArrayList<IClasspathEntry> list = new ArrayList<IClasspathEntry>();
			try {
				addProjectEntry(underlyingResource.getProject(), null, list);
			} catch (CoreException e) {
				throw new IllegalArgumentException(e);
			}
			classpathEntryList.addAll(list);
		} else {
			ArrayList<IClasspathEntry> list = new ArrayList<IClasspathEntry>();
			addExternalPlugin(pluginModelBase, null, list);
			classpathEntryList.addAll(list);
		}
		return true;
	}
	protected List<IClasspathEntry> calculateClasspathEntries() {
		List<IClasspathEntry> classpathEntryList = new ArrayList<IClasspathEntry>(BUNDLE_IDS.size() - excludedBundleIDs.size());
		for (String bundleId : BUNDLE_IDS)
			if (!excludedBundleIDs.contains(bundleId))
				addBundle(bundleId, classpathEntryList);
		return classpathEntryList;
	}

	private IClasspathEntry[] classpathEntries;

	public IClasspathEntry[] getClasspathEntries() {
		if (classpathEntries == null)
			classpathEntries = calculateClasspathEntries().toArray(new IClasspathEntry[0]);
		return classpathEntries;
	}

	public String getDescription() {
		return "Whole Platform Library";
	}

	public int getKind() {
		return IClasspathContainer.K_APPLICATION;
	}

	public IPath getPath() {
		return calculatePath(excludedBundleIDs);
	}

	private static final IPath BASE_PATH =  new Path(WHOLERT_CONTAINER);
	public static IPath getBasePath() {
		return BASE_PATH;
	}
	public static boolean sameKind(IClasspathEntry entry) {
		return sameKind(entry.getPath());
	}
	public static boolean sameKind(IPath entry) {
		return entry.segmentCount() > 0 && WHOLERT_CONTAINER.equals(entry.segment(0));
	}
}
