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
package org.whole.lang.resources;

import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.IPersistenceProvider;

/**
 * @author Riccardo Solmi
 * 
 * Classpath URI syntax:
 *   classpath:/package/path/resourcename
 */
public class ClasspathURIResolver extends AbstractURIResolver {
	public static final String URI_PREFIX = "classpath:/";
	public static final int URI_PREFIX_LENGTH = URI_PREFIX.length();

	public boolean canResolve(String contextUri, String uri) {
		try {
			return uri.substring(0, URI_PREFIX_LENGTH).equalsIgnoreCase(URI_PREFIX);
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public IPersistenceProvider resolve(String contextUri, String uri) {
		return new ClasspathPersistenceProvider(getResourceClasspath(uri));
	}

	public String getResourceClasspath(String uri) {
		return uri.substring(URI_PREFIX_LENGTH);
	}
}
