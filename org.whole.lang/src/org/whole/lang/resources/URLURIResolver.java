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

import java.net.MalformedURLException;
import java.net.URL;

import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.URLPersistenceProvider;


/**
 * @author Riccardo Solmi
 */
public class URLURIResolver extends AbstractURIResolver {
	public boolean canResolve(String contextUri, String uri) {
		try {
			new URL(uri);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}
	public IPersistenceProvider resolve(String contextUri, String uri) {
		try {
			return new URLPersistenceProvider(new URL(uri));
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public String getLocator(String contextUri, String uri) {
		return uri;
	}

	//FIXME remove http restriction
	public static final String URI_PREFIX = "http://";
	public static final int URI_PREFIX_LENGTH = URI_PREFIX.length();

	public static String getNamespace(String uri) {
		//FIXME add non numeric segments -1
		return reverseParts(uri.substring(URI_PREFIX_LENGTH, uri.indexOf('/', URI_PREFIX_LENGTH)));
	}
	public static String getName(String uri) {
		//FIXME last non numeric segment
		int startIndex = uri.indexOf('/', URI_PREFIX_LENGTH);
		return uri.substring(startIndex, uri.indexOf(':', startIndex));
	}
	public static String getVersion(String uri) {
		//FIXME
		return "";
	}
	public static String getURI(String namespace, String name, String version) {
		StringBuilder sb = new StringBuilder(
				URI_PREFIX_LENGTH+namespace.length()+name.length()+version.length()+2);
		sb.append(URI_PREFIX);
		appendReversedParts(sb, namespace);
		sb.append('/');
		sb.append(name.toLowerCase());
		sb.append('/');
		sb.append(version);
		return sb.toString();
	}

	public static String reverseParts(String multipartString) {
		StringBuilder sb = new StringBuilder(multipartString.length());
		appendReversedParts(sb, multipartString);
		return sb.toString();
	}
	public static void appendReversedParts(StringBuilder sb, String multipartString) {
		String[] part = multipartString.split("\\.");
		for (int i=part.length-1; i>=0; i--) {
			sb.append(part[i]);
			sb.append('.');
		}
	}
}
