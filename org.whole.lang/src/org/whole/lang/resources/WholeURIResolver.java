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

import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 * 
 * Whole URI syntax (urn style):
 *   whole:namespace:name:version
 */
public class WholeURIResolver extends AbstractURIResolver {
	public static final String URI_PREFIX = "whole:";
	public static final int URI_PREFIX_LENGTH = URI_PREFIX.length();

	public boolean canResolve(String contextUri, String uri) {
		try {
			return isWholeScheme(uri) && getUriResolverRegistry().canResolve(contextUri, getLocator(contextUri, uri));
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}
	public IPersistenceProvider resolve(String contextUri, String uri) {
		return getUriResolverRegistry().resolve(contextUri, getLocator(contextUri, uri));
	}

	public String getLocator(String contextUri, String uri) {
		String[] part = uri.split(":");
		StringBuilder sb = new StringBuilder(uri.length());
		if (contextUri != null) {
			sb.append(contextUri);
			sb.append("/");
		} else
			sb.append("classpath:/");
		sb.append(StringUtils.packageURIPath(part[1]));
		sb.append('/');
		sb.append(part[2]);
		sb.append(".xwl");
		return sb.toString();
	}

	public static boolean isWholeScheme(String uri) {
		return uri.substring(0, URI_PREFIX_LENGTH).equalsIgnoreCase(URI_PREFIX);
	}

	public static String getURI(String namespace, String name, String version) {
		StringBuilder sb = new StringBuilder(
				URI_PREFIX_LENGTH+namespace.length()+name.length()+version.length()+2);
		sb.append(URI_PREFIX);
		sb.append(namespace);
		sb.append(':');
		sb.append(name);
		if (version != null && !version.isEmpty()) {
			sb.append(':');
			sb.append(version);
		}
		return sb.toString();
	}

	public static String getNamespace(String uri) {
		if (isWholeScheme(uri)) {
			return uri.substring(URI_PREFIX_LENGTH, uri.indexOf(':', URI_PREFIX_LENGTH));
		} else
			throw new IllegalArgumentException();
	}
	public static String setNamespace(String uri, String namespace) {
		if (isWholeScheme(uri)) {
			String[] part = uri.split(":");
			StringBuilder sb = new StringBuilder(uri.length()-part[1].length()+namespace.length());
			sb.append(part[0]);
			sb.append(':');
			sb.append(namespace);
			sb.append(':');
			sb.append(part[2]);
			if (part.length == 4) {
				sb.append(':');
				sb.append(part[3]);
			}
			return sb.toString();
		} else
			throw new IllegalArgumentException();
	}
	public static String addNamespaceSuffix(String uri, String suffix) {
		if (isWholeScheme(uri)) {
			String[] part = uri.split(":");
			StringBuilder sb = new StringBuilder(uri.length()+suffix.length());
			sb.append(part[0]);
			sb.append(':');
			sb.append(part[1]);
			sb.append(suffix);
			sb.append(':');
			sb.append(part[2]);
			if (part.length == 4) {
				sb.append(':');
				sb.append(part[3]);
			}
			return sb.toString();
		} else
			throw new IllegalArgumentException();
	}

	public static String getName(String uri) {
		if (isWholeScheme(uri)) {
			int startIndex = uri.indexOf(':', URI_PREFIX_LENGTH)+1;
			int endIndex = uri.indexOf(':', startIndex);
			return endIndex<0 ? uri.substring(startIndex) : uri.substring(startIndex, endIndex);
		} else
			throw new IllegalArgumentException();
	}
	public static String setName(String uri, String name) {
		if (isWholeScheme(uri)) {
			String[] part = uri.split(":");
			StringBuilder sb = new StringBuilder(uri.length()-part[2].length()+name.length());
			sb.append(part[0]);
			sb.append(':');
			sb.append(part[1]);
			sb.append(':');
			sb.append(name);
			if (part.length == 4) {
				sb.append(':');
				sb.append(part[3]);
			}
			return sb.toString();
		} else
			throw new IllegalArgumentException();
	}
	public static String addNameSuffix(String uri, String suffix) {
		if (isWholeScheme(uri)) {
			String[] part = uri.split(":");
			StringBuilder sb = new StringBuilder(uri.length()+suffix.length());
			sb.append(part[0]);
			sb.append(':');
			sb.append(part[1]);
			sb.append(':');
			sb.append(part[2]);
			sb.append(suffix);
			if (part.length == 4) {
				sb.append(':');
				sb.append(part[3]);
			}
			return sb.toString();
		} else
			return uri.concat(suffix);
	}

	public static String getVersion(String uri) {
		String[] part = uri.split(":");
		return part.length == 4 ? part[3] : "";
	}
	public static String setVersion(String uri, String version) {
		if (isWholeScheme(uri)) {
			String[] part = uri.split(":");
			StringBuilder sb = new StringBuilder(uri.length()+(part.length == 4 ? -part[3].length() : 1)+version.length());
			sb.append(part[0]);
			sb.append(':');
			sb.append(part[1]);
			sb.append(':');
			sb.append(part[2]);
			sb.append(':');
			sb.append(version);
			return sb.toString();
		} else
			return uri.concat(version);
	}
}
