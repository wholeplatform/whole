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

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceProvider;

/**
 * @author Riccardo Solmi
 */
public class FileURIResolver extends AbstractURIResolver {
	public static final String URI_PREFIX = "file://";
	public static final int URI_PREFIX_LENGTH = URI_PREFIX.length();

	public boolean canResolve(String contextUri, String uri) {
		try {
			return uri.substring(0, URI_PREFIX_LENGTH).equalsIgnoreCase(URI_PREFIX) &&
				(uri.charAt(URI_PREFIX_LENGTH)=='/' || getHost(uri).equalsIgnoreCase("localhost"));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	public IPersistenceProvider resolve(String contextUri, String uri) {
		return new FilePersistenceProvider(new File(getURI(uri)));
	}

	public String getHost(String uri) {
		return uri.substring(URI_PREFIX_LENGTH, uri.indexOf('/', URI_PREFIX_LENGTH));
	}
	public String getPath(String uri) {
		return uri.substring(uri.indexOf('/', URI_PREFIX_LENGTH)+1);
	}

	public URI getURI(String uriString) {
		try {
			return new URI("file:///"+getPath(uriString));
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(e);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
