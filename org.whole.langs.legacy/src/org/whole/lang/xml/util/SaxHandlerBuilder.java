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
package org.whole.lang.xml.util;

import java.util.regex.Pattern;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.ext.Locator2Impl;
import org.xml.sax.helpers.AttributesImpl;

/**
 * @author Enrico Persiani
 */
public class SaxHandlerBuilder extends GenericIdentityBuilder implements IXmlBuilder  {
	private static final String DEFAULT_NS = "xmlns";
	private static final Pattern NS_ATTRNAME_PATTERN = Pattern.compile(DEFAULT_NS+"(:[^:]+)?");

	protected ContentHandler contentHandler;
	protected LexicalHandler lexicalHandler;
	protected String defaultNamespaceUri;
	protected IBindingManager bindingManager;

	public SaxHandlerBuilder(ContentHandler contentHandler, LexicalHandler lexicalHandler, String defaultNamespaceUri) {
		this.contentHandler = contentHandler;
		this.lexicalHandler = lexicalHandler;
		this.defaultNamespaceUri = defaultNamespaceUri;
		this.bindingManager = BindingManagerFactory.instance.createBindingManager();

		Locator2Impl locator = new Locator2Impl();
		locator.setColumnNumber(-1);
		locator.setLineNumber(-1);
		locator.setXMLVersion("1.0");
		this.bindingManager.wDefValue("documentStarted", false);
		this.bindingManager.wDefValue("locator", locator);
		this.bindingManager.wDefValue("builderStrategy", new BuilderStrategy());
	}

	protected boolean isDocumentStarted() {
		return this.bindingManager.wBooleanValue("documentStarted");
	}
	protected void setDocumentStarted() {
		this.bindingManager.wSetValue("documentStarted", true);
	}
	protected void conditionalStartDocument() {
		try {
			if (!isDocumentStarted()) {
				contentHandler.setDocumentLocator(getLocator());
				contentHandler.startDocument();
				setDocumentStarted();
			}
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}
	protected Locator2Impl getLocator() {
		return (Locator2Impl) bindingManager.wGetValue("locator");
	}
	protected BuilderStrategy getBuilderStrategy() {
		return (BuilderStrategy) bindingManager.wGetValue("builderStrategy");
	}
	protected void pushBuilderStrategy() {
		bindingManager.wEnterScope();
		bindingManager.wDefValue("builderStrategy", new BuilderStrategy());
	}
	protected void popBuilderStrategy() {
		bindingManager.wExitScope();
	}

	protected String createNamepaceId(String prefix, String name) {
		StringBuilder qName = new StringBuilder();
		qName.append(prefix == null ? DEFAULT_NS : prefix);
		qName.append(':');
		qName.append(name);
		return qName.toString();
	}
	protected void bindNamespaceUri(String namespace, String name, String uri) {
		bindingManager.wDefValue(createNamepaceId(namespace, name), uri);
	}
	protected String getNamespaceUri(String namespace) {
		String namepaceId = createNamepaceId(null,
				namespace == null ? DEFAULT_NS : namespace);
		return bindingManager.wIsSet(namepaceId) ? 
				bindingManager.wStringValue(namepaceId) : defaultNamespaceUri;
	}

	public void visit() {
	}

	public void nameSpace() {
	}

	public void value() {
	}

	public void content() {
	}

	public void attributes() {
	}

	public void tag() {
	}

	public void text() {
	}

	public void instruction() {
	}

	public void pubidLiteral() {
	}

	public void systemLiteral() {
	}

	public void externalId() {
	}

	public void name() {
	}

	public void standalone() {
	}

	public void encoding() {
	}

	public void version() {
	}

	public void misc() {
	}

	public void docTypeDecl() {
	}

	public void xmlDecl() {
	}

	public void element() {
	}

	public void prolog() {
	}

	public void Document() {
	}

	public void Document_() {
	}

	public void _Document() {
		try {
			contentHandler.endDocument();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void Prolog() {
	}

	public void Prolog_() {
	}

	public void _Prolog() {
		conditionalStartDocument();
	}

	public void XMLDecl() {
	}

	public void XMLDecl_() {
	}

	public void _XMLDecl() {
		conditionalStartDocument();
	}

	public void Version() {
	}

	public void Version(String value) {
		getLocator().setXMLVersion(value);
	}

	public void Encoding() {
	}

	public void Encoding(String value) {
		getLocator().setEncoding(value);
	}

	public void Standalone() {
	}

	public void Standalone(boolean value) {
	}

	public void DocTypeDecl() {
	}

	public void DocTypeDecl_() {
		getBuilderStrategy().reset();
	}

	public void _DocTypeDecl() {
		try {
			lexicalHandler.startDTD(getBuilderStrategy().asQName(),
					getLocator().getPublicId(), getLocator().getSystemId());
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void SystemId() {
	}

	public void SystemId_() {
	}

	public void _SystemId() {
	}

	public void SystemLiteral() {
	}

	public void SystemLiteral(String value) {
		getLocator().setSystemId(value.length() == 0 ? null : value);
	}

	public void PublicId() {
	}

	public void PublicId_() {
	}

	public void _PublicId() {
	}

	public void PubidLiteral() {
	}

	public void PubidLiteral(String value) {
		getLocator().setPublicId(value.length() == 0 ? null : value);
	}

	public void Misc() {
	}

	public void Misc_() {
	}

	public void Misc_(int initialCapacity) {
	}

	public void _Misc() {
	}

	public void PI() {
	}

	public void PI_() {
		conditionalStartDocument();
		try {
			getBuilderStrategy().pendingStartElement();
			getBuilderStrategy().reset();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void _PI() {
	}

	public void Instruction() {
	}

	public void Instruction(String value) {
		try {
			String target = getBuilderStrategy().asQName();
			contentHandler.processingInstruction(target, value);
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void Comment() {
	}

	public void Comment_() {
		conditionalStartDocument();
		try {
			getBuilderStrategy().pendingStartElement();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void _Comment() {
	}

	public void CommentText() {
	}

	public void CommentText(String value) {
		try {
			char[] comment = value.toCharArray();
			lexicalHandler.comment(comment, 0, comment.length);
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void Element() {
	}

	public void Element_() {
		try {
			getBuilderStrategy().pendingStartElement();
			pushBuilderStrategy();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void _Element() {
		try {
			getBuilderStrategy().pendingStartElement();
			getBuilderStrategy().endElement();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		} finally {
			popBuilderStrategy();
		}
	}

	public void Attributes() {
	}
	
	public void Attributes_(int initialCapacity) {
		Attributes_();
	}

	public void Attributes_() {
		getBuilderStrategy().Attributes_();
	}

	public void _Attributes() {
	}

	public void Attribute() {
	}

	public void Attribute_() {
		getBuilderStrategy().Attribute_();
	}

	public void _Attribute() {
		getBuilderStrategy()._Attribute();
	}

	public void Name() {
	}

	public void Name(String value) {
		getBuilderStrategy().Name(value);
	}

	public void QualifiedName() {
	}

	public void QualifiedName_() {
	}

	public void _QualifiedName() {
	}

	public void NameSpace() {
	}

	public void NameSpace(String value) {
		getBuilderStrategy().NameSpace(value);
	}

	public void Value() {
	}

	public void Value(String value) {
		getBuilderStrategy().Value(value);
	}

	public void Content() {
		Content_();
		_Content();
	}

	public void Content_() {
		try {
			getBuilderStrategy().pendingStartElement();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void Content_(int initialCapacity) {
	}

	public void _Content() {
	}

	public void CharData() {
	}

	public void CharData(String value) {
		try {
			getBuilderStrategy().pendingStartElement();
			char[] chars = value.toCharArray();
			contentHandler.characters(chars, 0, chars.length);
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void CDataSect() {
	}

	public void CDataSect_(int initialCapacity) {
		CDataSect_();
	}

	public void CDataSect_() {
		try {
			getBuilderStrategy().pendingStartElement();
			lexicalHandler.startCDATA();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public void _CDataSect() {
		try {
			lexicalHandler.endCDATA();
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void CDataSectData() {
	}

	public void CDataSectData(String value) {
		try {
			char[] chars = value.toCharArray();
			contentHandler.characters(chars, 0, chars.length);
		} catch (SAXException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static class IdentityLexicalHandler implements LexicalHandler {
		public void startDTD(String name, String publicId, String systemId) {
		}
		public void endDTD() {
		}
		public void startEntity(String name) {
		}
		public void endEntity(String name) {
		}
		public void startCDATA() {
		}
		public void endCDATA() {
		}
		public void comment(char[] ch, int start, int length) {
		}
	}

	public class NameStrategy {
		protected String namespace;
		protected String name;

		public NameStrategy() {
		}
		
		public String getNamespace() {
			return namespace;
		}
		public String getName() {
			return name;
		}

		public String asQName() {
			if (name == null)
				throw new IllegalStateException("name never set");
			return namespace != null ?
					namespace + ':' + name : name;
		}
		public void reset() {
			this.name = null;
			this.namespace = null;
		}
	
		public void Name(String name) {
			if (this.name != null)
				throw new IllegalStateException("name overwritten");
			this.name = name;
		}
		public void NameSpace(String namespace) {
			if (this.namespace != null)
				throw new IllegalStateException("namespace overwritten");
			this.namespace = namespace;
		}
	}

	public class BuilderStrategy extends NameStrategy {
		protected AttributesImpl attributes;
		protected boolean pending;
		protected String elementNamespace;
		protected String elementName;
		protected String elementQName;
		protected String value;

		public BuilderStrategy() {
			this.attributes = new AttributesImpl();
		}

		public void Attributes_() {
			this.elementNamespace = getNamespace();
			this.elementName = getName();
			this.elementQName = asQName();
			this.pending = true;
			reset();
		}
		public void _Attributes() {
		}
		public void Attribute_() {
		}
		public void _Attribute() {
			String uri = "";
			if (NS_ATTRNAME_PATTERN.matcher(asQName()).matches())
				bindNamespaceUri(getNamespace(), getName(), value);
			else if (getNamespace() != null)
				uri = getNamespaceUri(getNamespace());

			this.attributes.addAttribute(uri, getName(), asQName(), "CDATA", value);
			reset();
		}
		public void Value(String value) {
			this.value = value;
		}

		public void pendingStartElement() throws SAXException {
			if (pending) {
				String uri = getNamespaceUri(elementNamespace);
				contentHandler.startElement(uri, elementName, elementQName, attributes);
				pending = false;
			}
		}
		public void endElement() throws SAXException {
			String uri = getNamespaceUri(elementNamespace);
			contentHandler.endElement(uri, elementName, elementQName);
		}
	}
}
