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
package org.whole.lang.util;

import java.io.File;
import java.util.Comparator;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceNameProvider;
import org.whole.lang.resources.IResourceRegistry;

/**
 * @author Riccardo Solmi
 */
public class ResourceUtils {
	public static IResourceNameProvider SIMPLE_NAME_PROVIDER = new SmartNameProvider();
	public static IResourceNameProvider QUALIFIED_NAME_PROVIDER = new SmartQualifiedNameProvider();
	
	public static final Comparator<IResource> SIMPLE_COMPARATOR = new ByNameNamespaceVersionURIComparator();
	public static final Comparator<IResource> QUALIFIED_COMPARATOR = new ByNamespaceNameVersionURIComparator();

	public static String getSimpleName(IResource resource) {
		return SIMPLE_NAME_PROVIDER.toString(resource.getResourceRegistry(), resource);
	}
	public static String getQualifiedName(IResource resource) {
		return QUALIFIED_NAME_PROVIDER.toString(resource.getResourceRegistry(), resource);
	}

	public static abstract class AbstractResourceNameProvider implements IResourceNameProvider {
		public <T extends IResource, S extends T> String toString(IResourceRegistry<T> registry, S resource) {
			StringBuilder sb = new StringBuilder();
			append(registry, resource, sb);
			return sb.toString();
		}	
	}
	public static class SmartNameProvider extends AbstractResourceNameProvider {
		public <T extends IResource> void append(IResourceRegistry<T> registry, T resource, StringBuilder sb) {
			String name = resource.getName();
			sb.append(name);

			int nameOccurrences = registry.getResourceNameOccurrences(resource);
			if (nameOccurrences > 1) {
				if (registry.isResourceVersionAmbiguous(resource)) {
					sb.append(" (");
					sb.append(resource.getURI());
					sb.append(')');
				} else {
					int qualifiedNameOccurrences = registry.getResourceQualifiedNameOccurrences(resource);
					if (qualifiedNameOccurrences > 1) {
						String version = resource.getVersion();
						if (version.length() > 0) {
							sb.append(' ');
							sb.append(version);
						}
					}
					if (nameOccurrences > qualifiedNameOccurrences) {
						sb.append(" (");
						sb.append(resource.getNamespace());
						sb.append(')');
					}
				}
			}
		}
	}
	public static class SmartQualifiedNameProvider extends AbstractResourceNameProvider {
		public <T extends IResource> void append(IResourceRegistry<T> registry, T resource, StringBuilder sb) {
			sb.append(resource.getQualifiedName());

			if (registry.isResourceVersionAmbiguous(resource)) {
				sb.append(" (");
				sb.append(resource.getURI());
				sb.append(')');
			} else {
				int qualifiedNameOccurrences = registry.getResourceQualifiedNameOccurrences(resource);
				if (qualifiedNameOccurrences > 1) {
					String version = resource.getVersion();
					if (version.length() > 0) {
						sb.append(' ');
						sb.append(version);
					}
				}
			}
		}
	}

	public static class ByNameNamespaceVersionURIComparator implements Comparator<IResource> {
		public int compare(IResource o1, IResource o2) {
			int result = o1.getName().compareTo(o2.getName());
			if (result == 0)
				result = o1.getNamespace().compareTo(o2.getNamespace());
			if (result == 0)
				result = o1.getVersion().compareTo(o2.getVersion());
			if (result == 0)
				result = o1.getURI().compareTo(o2.getURI());
			return result;
		}
	}
	public static class ByNamespaceNameVersionURIComparator implements Comparator<IResource> {
		public int compare(IResource o1, IResource o2) {
			int result = o1.getNamespace().compareTo(o2.getNamespace());
			if (result == 0)
				result = o1.getName().compareTo(o2.getName());
			if (result == 0)
				result = o1.getVersion().compareTo(o2.getVersion());
			if (result == 0)
				result = o1.getURI().compareTo(o2.getURI());
			return result;
		}
	}

	public static void defineResourceBindings(IBindingManager bm, File file) {
		bm.wDefValue("file", file);
		String name = file.getName();
		bm.wDefValue("fileNameWithExtension", name);
		bm.wDefValue("fileName", StringUtils.stripFileExtension(name));
		bm.wDefValue("fileExtension", StringUtils.getFileExtension(name));
		File parentFile = file.getParentFile();
		bm.wDefValue("folder", parentFile != null ? parentFile : "");
		bm.wDefValue("folderName", parentFile != null ? parentFile.getPath() : "");
		bm.wDefValue("folderLocation", name = (parentFile != null ? parentFile.getAbsolutePath() : ""));
		bm.wDefValue("folderFullPath", name);
		bm.wDefValue("fileLocationURI", file.toURI().toString());//FIXME
		bm.wDefValue("fileLocation", name = file.getAbsolutePath());
		bm.wDefValue("fileFullPath", name);
		bm.wDefValue("fileLocationName", name = StringUtils.stripFileExtension(name));
		bm.wDefValue("fileFullPathName", name);

		bm.wDefValue("contextURI", parentFile != null ? parentFile.toURI().toString() : null);//FIXME

		bm.wDefValue("debug#reportModeEnabled", true);
		bm.wDefValue("debug#debugModeEnabled", true);
		bm.wDefValue("debug#breakpointsEnabled", true);
	}

	public static void defineResourceBindings(IBindingManager bm, String resourceClasspath) {
		int s = resourceClasspath.lastIndexOf('/');
		String filePath;
		String fileNameWithExtension;
		if (s == -1) {
			filePath = "";
			fileNameWithExtension = resourceClasspath;
		} else {
			filePath = resourceClasspath.substring(0, s);
			fileNameWithExtension = resourceClasspath.substring(s+1);
		}
		String fileName, fileExtension, packageName;
		bm.wDefValue("fileNameWithExtension", fileNameWithExtension);
		bm.wDefValue("fileName", fileName = StringUtils.stripFileExtension(fileNameWithExtension));
		bm.wDefValue("fileExtension", fileExtension = StringUtils.getFileExtension(fileNameWithExtension));
		bm.wDefValue("folderName", filePath);
		bm.wDefValue("packageName", packageName = filePath.replace('/', '.'));

		if ("class".equals(fileExtension)) {
			String compilationUnitName = packageName+'.'+fileName;
			bm.wDefValue("compilationUnitName", compilationUnitName);
			bm.wDefValue("className", fileName);
		}
		try {
			String resourceUri = ReflectionFactory.getClassLoader(bm).getResource(resourceClasspath).toURI().toString();
			bm.wDefValue("contextURI", resourceUri.substring(0, resourceUri.length()-resourceClasspath.length()-1));
		} catch (Exception e) {
		}

		bm.wDefValue("debug#reportModeEnabled", true);
		bm.wDefValue("debug#debugModeEnabled", true);
		bm.wDefValue("debug#breakpointsEnabled", true);
	}

	public static boolean hasFragmentPart(String resourceUri) {
		return resourceUri.indexOf('#') > 0;
	}
	public static String getResourcePart(String resourceUri) {
		int index = resourceUri.indexOf('#');
		return index > 0 ? resourceUri.substring(0, index) : null;
	}
	public static String getFragmentPart(String resourceUri) {
		int index = resourceUri.indexOf('#');
		return index > 0 ? resourceUri.substring(index+1) : null;
	}
	public static String stripFragmentPart(String resourceUri) {
		int index = resourceUri.indexOf('#');
		return index > 0 ? resourceUri.substring(0, index) : resourceUri;
	}
	public static String stripResourcePart(String resourceUri) {
		int index = resourceUri.indexOf('#');
		return index > 0 ? resourceUri.substring(index+1) : resourceUri;
	}

	public static void handleCancelRequest(IBindingManager bm) {
		if (bm.wIsSet("progressMonitor") && ((IOperationProgressMonitor) bm.wGetValue("progressMonitor")).isCanceled())
			throw new OperationCanceledException();
	}
}
