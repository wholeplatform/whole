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
package org.whole.lang.xsd.util;

import java.util.regex.Pattern;

import org.whole.lang.bindings.IBindingManager;

/**
 * @author Enrico Persiani
 */
public class NamespaceUtils {
	private static final String INTERNAL_NAMESPACE = "http://lang.whole.org/schema/noTargetNamespace/";
	private static final Pattern INTERNAL_NAMESPACE_PATTERN = Pattern.compile(INTERNAL_NAMESPACE+"(dynamic)|(static)\\d+");

	private static int internalNamespaceCounter = 0;
	public static String calculateInternalNamespace(boolean isDynamic) {
		return INTERNAL_NAMESPACE + (isDynamic ? "dynamic" : "static") + internalNamespaceCounter++;
	}
	public static boolean isInternalNamespace(String targetNamespace) {
		return INTERNAL_NAMESPACE_PATTERN.matcher(targetNamespace).matches();
	}

	public static final String XML_NAMESPACE_PREFIX = "xml";
	public static final String XML_NAMESPACE_URI = "http://www.w3.org/XML/1998/namespace";

	public static final String XSD_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema";
	public static final String XSI_NAMESPACE_URI = "http://www.w3.org/2001/XMLSchema-instance";

	public static boolean isXmlNamespace(String uri) {
		return XML_NAMESPACE_URI.equals(uri);
	}
	public static boolean isXsdNamespace(String uri) {
		return XSD_NAMESPACE_URI.equals(uri);
	}
	public static boolean isXsiNamespace(String uri) {
		return XSI_NAMESPACE_URI.equals(uri);
	}

	public static void redefineNamespace(IBindingManager bm, String prefix, String uri) {
		bm.wDefValue(prefix, uri);
	}

	public static final String DEFAULT_NAMESPACE_PREFIX = "";
	public static final String DEFAULT_NAMESPACE_URI = "";

	public static boolean isDefaultNamespacePrefix(String prefix) {
		return DEFAULT_NAMESPACE_PREFIX.equals(prefix);
	}
	public static String getDefaultNamespace(IBindingManager bm) {
		return bm.wStringValue(DEFAULT_NAMESPACE_PREFIX);
	}
	public static void redefineDefaultNamespace(IBindingManager bm, String uri) {
		redefineNamespace(bm, DEFAULT_NAMESPACE_PREFIX, uri);
	}

	public static IBindingManager initializeNampespaceBindings(IBindingManager bm) {
		bm.wDefValue(DEFAULT_NAMESPACE_PREFIX, DEFAULT_NAMESPACE_URI);
		bm.wDefValue(XML_NAMESPACE_PREFIX, XML_NAMESPACE_URI);
		return bm;
	}
}
