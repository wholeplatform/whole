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

import static org.whole.lang.jdt.PlatformLibraryContainerInitializer.calculatePath;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.osgi.framework.Bundle;

/**
 * @author Enrico Persiani
 */
public class PlatformLibraryClasspathContainer implements IClasspathContainer {
	public static final String WHOLERT_CONTAINER = "org.whole.lang.ide.WHOLERT_CONTAINER";

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
		bundles.add("com.fasterxml.jackson");
		bundles.add("net.sourceforge.jodatime");
		bundles.add("nu.validator.htmlparser");
		bundles.add("org.beanshell.bsh");
		bundles.add("org.gradle");
		bundles.add("org.h2");
		bundles.add("org.mozilla.rhino");
		bundles.add("org.objectweb.asm");
		bundles.add("org.antlr.antlr4");
		bundles.add("net.java.dev.jna");
		bundles.add("ca.weblite.java-objc-bridge");
		bundles.add("com.github.jai.imageio.core");

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

	protected void addBundle(String bundleId, List<IClasspathEntry> classpathEntryList) {
		try {
			Bundle bundle = Platform.getBundle(bundleId);
			String classPath = bundle.getHeaders().get("Bundle-ClassPath");
			if (classPath == null)
				classPath = ".";
			File bundleFile = FileLocator.getBundleFile(bundle);
			if (".".equals(classPath)) { // standard bundle
				Path bundlePath, sourcePath;
				if (bundleFile.isDirectory()) {
					bundlePath = new Path(bundleFile.getAbsolutePath() + File.separator + "bin");
					sourcePath = new Path(bundleFile.getAbsolutePath() + File.separator + "src");
				} else {
					bundlePath = new Path(bundleFile.getAbsolutePath());
					String name = bundleFile.getName();
					String container = bundleFile.getParent();
					String sourceBundleName = bundleId + ".source" + name.substring(bundleId.length());
					sourcePath = new Path(container + File.separator + sourceBundleName);
				}
				classpathEntryList.add(JavaCore.newLibraryEntry(bundlePath, sourcePath, null));
			} else { // bundle containing jar libraries
				Path bundlePath = new Path(bundleFile.getAbsolutePath() + File.separator + classPath);
				Path sourcePath = new Path(bundleFile.getAbsolutePath() + File.separator + classPath.replaceFirst("\\.jar$", "src.zip"));
				classpathEntryList.add(JavaCore.newLibraryEntry(bundlePath, sourcePath, null));
			}
		} catch (Exception e) {
		}
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

//
//	private void addExtraLibrary(IPath path, IPluginModelBase model, ArrayList<IClasspathEntry> entries) {
//		if (path.segmentCount() > 1) {
//			IPath srcPath = null;
//			if (model != null) {
//				IPath shortPath = path.removeFirstSegments(path.matchingFirstSegments(new Path(model.getInstallLocation())));
//				srcPath = getSourceAnnotation(model, shortPath.toString());
//			} else {
//				String filename = getSourceZipName(path.lastSegment());
//				IPath candidate = path.removeLastSegments(1).append(filename);
//				if (ResourcesPlugin.getWorkspace().getRoot().getFile(candidate).exists())
//					srcPath = candidate;
//			}
//			IClasspathEntry clsEntry = JavaCore.newLibraryEntry(path, srcPath, null);
//			if (!entries.contains(clsEntry))
//				entries.add(clsEntry);
//		}
//	}
//
//	public static IPath getSourceAnnotation(IPluginModelBase model, String libraryName) {
//		String newlibraryName = TargetWeaver.getWeavedSourceLibraryName(model, libraryName);
//		String zipName = getSourceZipName(newlibraryName);
//		IPath path = getPath(model, zipName);
//		if (path == null) {
//			SourceLocationManager manager = PDECore.getDefault().getSourceLocationManager();
//			path = manager.findSourcePath(model.getPluginBase(), new Path(zipName));
//		}
//		return path;
//	}
//
//	public static String getSourceZipName(String libraryName) {
//		int dot = libraryName.lastIndexOf('.');
//		return (dot != -1) ? libraryName.substring(0, dot) + "src.zip" : libraryName; //$NON-NLS-1$
//	}
//
//	private static IPluginModelBase resolveLibraryInFragments(IPluginLibrary library, String libraryName) {
//		IFragmentModel[] fragments = PDEManager.findFragmentsFor(library.getPluginModel());
//
//		for (int i = 0; i < fragments.length; i++) {
//			IPath path = getPath(fragments[i], libraryName);
//			if (path != null)
//				return fragments[i];
//		}
//		return null;
//	}
//
//	public static IPath getPath(IPluginModelBase model, String libraryName) {
//		IResource resource = model.getUnderlyingResource();
//		if (resource != null) {
//			IResource jarFile = resource.getProject().findMember(libraryName);
//			if (jarFile != null)
//				return jarFile.getFullPath();
//		} else {
//			File file = new File(model.getInstallLocation(), libraryName);
//			if (file.exists())
//				return new Path(file.getAbsolutePath());
//			file = new File(libraryName);
//			if (file.exists() && file.isAbsolute()) {
//				return new Path(libraryName);
//			}
//		}
//		return null;
//	}
}
