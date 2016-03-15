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

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;
import org.whole.lang.xml.util.InputStreamInput;
import org.whole.lang.xml.util.ResourceResolver;
import org.whole.lang.xml.util.XmlUtils;
import org.whole.lang.xsd.codebase.XsdPersistenceKit;
import org.whole.lang.xsd.model.Schema;

/**
 * @author Enrico Persiani
 */
public class SchemaUtils {
	public static final String ANY_TYPE_NAME = "AnyType";
	public static String getAnyTypeEntityName() {
		return ANY_TYPE_NAME;
	}
	public static boolean hasAnyTypeEntityName(EntityDescriptor<?> ed) {
		return ANY_TYPE_NAME.equals(ed.getName());
	}
	public static boolean isAnyType(EntityDescriptor<?> ed) {
		return hasAnyTypeEntityName(ed) && ed.isSupertypeOfAny();
	}

	public static String calculateQualifiedName(String uriString) {
		URI uri = XmlUtils.parseURI(uriString);//TODO subclass
		StringBuilder sb = new StringBuilder("org.whole.lang.xsd");
		Pattern pattern = Pattern.compile("\\p{javaJavaIdentifierPart}+");
		Matcher matcher = pattern.matcher(uri.getSchemeSpecificPart());
		while (matcher.find()) {
			sb.append('.');
			String part = matcher.group().toLowerCase();
			if (!Character.isJavaIdentifierStart(part.charAt(0)))
				sb.append('_');
			sb.append(part);
		}
		return sb.toString();
	}
	public static String calculateNamespace(String uri) {
		return StringUtils.toPackageName(calculateQualifiedName(uri));
	}
	public static String calculateName(String uri) {
		return StringUtils.toSimpleName(calculateQualifiedName(uri));
	}

	/* was LSInput, workaround for Android compatibility */
	private static InputStreamInput resolve(String namespaceURI, String schemaLocationURI, IBindingManager bindings) {
		return resolve(namespaceURI, schemaLocationURI, bindings.wStringValue("folderLocation"),
				/* was (LSResourceResolver), workaround for Android compatibility */
				(ResourceResolver) bindings.wGetValue("lsResourceResolver"));
	}
//	/* was LSInput, workaround for Android compatibility */
//	private static InputStreamInput resolve(String namespaceURI, String schemaLocationURI, String folderLocation) {
//		return resolve(namespaceURI, schemaLocationURI, folderLocation, null);
//	}
	/* was LSInput, workaround for Android compatibility */
	private static InputStreamInput resolve(String namespaceURI, String schemaLocationURI, String folderLocation,
			/* was LSResourceResolver, workaround for Android compatibility */
			ResourceResolver lsResourceResolver) {
		try {
			// try to resolve using provided LSResourceResolver
			URI schemaLocation = new URI(schemaLocationURI);
			URI folder = new File(folderLocation).toURI();
			if (lsResourceResolver != null) {
				/* was LSInput, workaround for Android compatibility */
				InputStreamInput lsInput = lsResourceResolver.resolveResource(NamespaceUtils.XSD_NAMESPACE_URI, namespaceURI, null,
						schemaLocationURI, schemaLocation.isAbsolute() ? null : folder.toASCIIString());
				if (lsInput != null)
					return lsInput;
			}

			// try to resolve directly using provided schemaLocation
			schemaLocation = folder.resolve(schemaLocation);

			URLConnection connection = schemaLocation.toURL().openConnection();
			InputStream is = connection.getInputStream();
			return new InputStreamInput(is);

		} catch (Exception e) {
			// fail silently
		}
		return null;
	}

	private static Schema load(String namespaceURI, String schemaLocationURI, IBindingManager bindings) {
		return load(resolve(namespaceURI, schemaLocationURI, bindings));
	}
//	public static Schema load(String namespaceURI, String schemaLocationURI, String folderLocation) {
//		return load(namespaceURI, schemaLocationURI, folderLocation, null);
//	}

	public static Schema load(String namespaceURI, String schemaLocationURI, String folderLocation,
			/* was LSResourceResolver, workaround for Android compatibility */
			ResourceResolver lsResourceResolver) {
		return load(resolve(namespaceURI, schemaLocationURI, folderLocation, lsResourceResolver));
	}
	public static Schema load(InputStreamInput source) {
		try {
			return (Schema) XsdPersistenceKit.instance().readModel(
					new StreamPersistenceProvider(source.getByteStream()));
		} catch (Exception e) {
			return null;
		}
	}

	private static void deploy(String namespaceURI, String schemaLocationURI, IBindingManager bindings) {
		deploy(load(namespaceURI, schemaLocationURI, bindings), bindings);
	}
//	public static void deploy(String namespaceURI, String schemaLocationURI, String folderLocation) {
//		deploy(namespaceURI, schemaLocationURI, folderLocation, null);
//	}

	public static void deploy(String namespaceURI, String schemaLocationURI, String folderLocation, 
			/* was LSResourceResolver, workaround for Android compatibility */
			ResourceResolver lsResourceResolver) {
		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		bindings.wDefValue("folderLocation", folderLocation);
		bindings.wDefValue("lsResourceResolver", lsResourceResolver);
		deploy(namespaceURI, schemaLocationURI, bindings);
	}
	public static void deploy(Schema schema, IBindingManager bindings) {
		if (schema != null)
			InterpreterOperation.interpret(schema, bindings);
	}
}
