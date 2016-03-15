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

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Enrico Persiani
 */
public class ResourceLoader {
	private static final Map<String, ResourceLoader> resourceLoaders = new HashMap<String, ResourceLoader>(); 

	public static ResourceLoader instance(String packageName) {
		ResourceLoader resourceLoader = resourceLoaders.get(packageName);
		if (resourceLoader == null) {
			resourceLoader = new ResourceLoader(packageName);
			resourceLoaders.put(packageName, resourceLoader);
		}
		return resourceLoader;
	}

	private final ClassLoader cl;
	private final String packagePath;

	private ResourceLoader(String packageName) {
		cl = Thread.currentThread().getContextClassLoader();
		packagePath = StringUtils.packageURIPath(packageName);
	}

	public URL getResource(String name) {
		return cl.getResource(packagePath+"/"+name);
	}
	public InputStream getResourceAsStream(String name) {
		try {
			URI uri = new URI(name);
			return uri.toURL().openStream();
		} catch (Exception e) {
			return cl.getResourceAsStream(packagePath+"/"+name);
		}
	}
}
