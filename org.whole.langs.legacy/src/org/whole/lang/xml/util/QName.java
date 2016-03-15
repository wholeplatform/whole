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
/**
 * 
 */
package org.whole.lang.xml.util;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.xml.model.IName;
import org.whole.lang.xml.model.Name;
import org.whole.lang.xml.model.QualifiedName;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

/**
 * @author Enrico Persiani
 */
public class QName {
	private final String namespaceURI;
	private final String localPart;
	private final String prefix;

	public QName(String namespaceURI, String localPart, String prefix) {
		this.namespaceURI = namespaceURI;
		this.localPart = localPart;
		this.prefix = prefix;
	}
	public QName(String namespaceURI, String localPart) {
		this(namespaceURI, localPart, null);
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public String getLocalPart() {
		return localPart;
	}

	public String getPrefix() {
		return prefix;
	}

	@Override
	public String toString() {
		return "{" + (prefix != null ? prefix + "=": "") + namespaceURI + "}:" + localPart;
	}

	public static QName create(String namespaceURI, String xmlName, String prefix) {
		return new QName(namespaceURI, xmlName, prefix);
	}
	public static QName create(String namespaceURI, String xmlName) {
		return new QName(namespaceURI, xmlName);
	}
	public static QName create(IBindingManager namespaceDecls, String namespaceURI, IName xmlName) {
		if (Matcher.match(XmlEntityDescriptorEnum.QualifiedName, xmlName)) {
			QualifiedName qname = (QualifiedName) xmlName;
			String prefix = qname.getNameSpace().getValue();
			String name = qname.getName().getValue();

			return create(namespaceDecls.wStringValue(prefix), name, prefix);
		} else
			return create(namespaceURI, ((Name) xmlName).getValue());
	}
}
