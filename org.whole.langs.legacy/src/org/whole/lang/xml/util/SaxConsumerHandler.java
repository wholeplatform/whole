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

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.whole.lang.xml.reflect.XmlLanguageKit;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.ext.Locator2;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class SaxConsumerHandler extends DefaultHandler implements LexicalHandler {
	private IXmlBuilder builder;
	private ICommonsBuilder cb;
	private boolean todoProlog = true;
	private boolean todoMisc = true;
	private boolean cdataState = false;
	private boolean produceXmlDecl = false;
	private boolean hasDocTypeDecl = false;
	private boolean docTypeDeclState = false;
	private String xmlVersion, xmlEncoding;
	private String docTypeName, docTypePublicId, docTypeSystemId;

	public SaxConsumerHandler(IBuilderOperation op, boolean produceXmlDecl) {
		this.produceXmlDecl = produceXmlDecl;
		this.builder = (IXmlBuilder) op.wGetBuilder(XmlLanguageKit.URI);
		this.cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
	}

	public static IEntity parse(InputStream is, String encoding) throws ParserConfigurationException, SAXException, IOException {
		return parse(is, encoding, XmlUtils.hasXmlDecl(is, encoding, true));
	}
	public static IEntity parse(InputStream is, String encoding, boolean produceXmlDecl) throws ParserConfigurationException, SAXException, IOException {
		InputSource inputSource = new InputSource(is);
		inputSource.setEncoding(encoding);
		return parse(inputSource, produceXmlDecl);
	}
	public static IEntity parse(Reader reader) throws ParserConfigurationException, SAXException, IOException {
		return parse(reader, XmlUtils.hasXmlDecl(reader, true));
	}
	public static IEntity parse(Reader reader, boolean produceXmlDecl) throws ParserConfigurationException, SAXException, IOException {
		return parse(new InputSource(reader), produceXmlDecl);
	}
	public static IEntity parse(InputSource inputSource, boolean produceXmlDecl) throws ParserConfigurationException, SAXException, IOException {
		ModelBuilderOperation op = new ModelBuilderOperation();
		parse(inputSource, produceXmlDecl, op);
		return op.wGetResult();
	}

	public static void parse(InputStream is, String encoding, IBuilderOperation op) throws ParserConfigurationException, SAXException, IOException {
		parse(is, encoding, XmlUtils.hasXmlDecl(is, encoding, true), op);
	}
	public static void parse(InputStream is, String encoding, boolean produceXmlDecl, IBuilderOperation op) throws ParserConfigurationException, SAXException, IOException {
		InputSource inputSource = new InputSource(is);
		inputSource.setEncoding(encoding);
		parse(inputSource, produceXmlDecl, op);
	}
	public static void parse(Reader reader, IBuilderOperation op) throws ParserConfigurationException, SAXException, IOException {
		parse(reader, XmlUtils.hasXmlDecl(reader, true), op);
	}
	public static void parse(Reader reader, boolean produceXmlDecl, IBuilderOperation op) throws ParserConfigurationException, SAXException, IOException {
		parse(new InputSource(reader), produceXmlDecl, op);
	}

	public static void parse(InputSource inputSource, boolean produceXmlDecl, IBuilderOperation op) throws ParserConfigurationException, SAXException, IOException {
		SaxConsumerHandler saxHandler = new SaxConsumerHandler(op, produceXmlDecl);

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		XMLReader xmlReader = parser.getXMLReader();

		xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
		xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
		xmlReader.setFeature("http://xml.org/sax/features/validation", false);
		xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", saxHandler);

		xmlReader.setContentHandler(saxHandler);            
		xmlReader.setDTDHandler(saxHandler);
		xmlReader.setEntityResolver(saxHandler);
		xmlReader.setErrorHandler(saxHandler);

		xmlReader.parse(inputSource);
	}

	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {
		try {
			URLConnection connection = new URL(systemId).openConnection();
			connection.setConnectTimeout(1000);
			connection.setReadTimeout(1500);
			connection.getInputStream();
		} catch (Exception e) {
			return new InputSource(new StringReader(""));
		}

		return super.resolveEntity(publicId, systemId);
	}

	public void setDocumentLocator(Locator locator) {
		if (locator instanceof Locator2) {
			Locator2 locator2 = (Locator2) locator;
			xmlVersion = locator2.getXMLVersion();
			xmlEncoding = locator2.getEncoding();
		}
	}

	public void comment(char[] ch, int start, int length) throws SAXException {
		if (docTypeDeclState)
			return;
		if (todoProlog) {
			buildPrologStart();
			todoProlog = false;
		}
		builder.Comment_();
		builder.CommentText(new String(ch, start, length));
		builder._Comment();
	}

	public void processingInstruction(String target, String data) throws SAXException {
		if (docTypeDeclState)
			return;
		if (todoProlog) {
			buildPrologStart();
			todoProlog = false;
		}
		builder.PI_();
		builder.Name(target);
		builder.Instruction(data);
		builder._PI();
	}

	public void startDocument() throws SAXException {
		builder.Document_();
	}
	public void endDocument() throws SAXException {
		builder._Document();
	}

	public void startDTD(String name, String publicId, String systemId) throws SAXException {
		docTypeName = name;
		docTypePublicId = publicId;
		docTypeSystemId = systemId;
		hasDocTypeDecl = true;
		docTypeDeclState = true;
	}
	public void endDTD() throws SAXException {
		docTypeDeclState = false;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (todoMisc) {
			if (todoProlog) {
				buildPrologStart();
				todoProlog = false;
			}
			buildPrologEnd();
			todoMisc = false;
		}

		builder.Element_();
		buildName(qName);

		builder.Attributes_(attributes.getLength());
		for (int i=0; i<attributes.getLength(); i++) {
			builder.Attribute_();
			buildName(attributes.getQName(i));
			builder.Value(attributes.getValue(i));
			builder._Attribute();
		}
		builder._Attributes();

		builder.Content_();
	}

	private void buildPrologStart() {
		builder.Prolog_();
		if (produceXmlDecl) {
			builder.XMLDecl_();
			builder.Version(xmlVersion);
			builder.Encoding(xmlEncoding);
			cb.Resolver();
			builder._XMLDecl();
		} else
			cb.Resolver();
		if (hasDocTypeDecl)
			buildDocTypeDecl(docTypeName, docTypePublicId, docTypeSystemId);
		else
			cb.Resolver();
		builder.Misc_();
	}
	private void buildPrologEnd() {
		builder._Misc();
		builder._Prolog();
	}


	public void endElement(String uri, String localName, String qName) throws SAXException {
		builder._Content();
		builder._Element();
	}

	public void startCDATA() throws SAXException {
		builder.CDataSect_();
		cdataState = true;
	}
	public void endCDATA() throws SAXException {
		cdataState = false;
		builder._CDataSect();
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		if (cdataState)
			builder.CDataSectData(new String(ch, start, length));
		else
			builder.CharData(new String(ch, start, length));
	}
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		characters(ch, start, length);
	}

	public void startEntity(String name) throws SAXException {
	}
	public void endEntity(String name) throws SAXException {
	}


	private void buildName(String qName) {
		String[] tag = qName.split(":");
		if (tag.length == 2) {
			builder.QualifiedName_();
			builder.NameSpace(tag[0]);
			builder.Name(tag[1]);
			builder._QualifiedName();
		} else
			builder.Name(tag[0]);
	}

	private void buildDocTypeDecl(String name, String publicId, String systemId) {
		builder.DocTypeDecl_();
		builder.Name(name);

		boolean validPublicId = publicId != null && publicId.length() > 0;
		boolean validSystemId = systemId != null && systemId.length() > 0;
		if (validPublicId && validSystemId) {
			builder.PublicId_();
			builder.PubidLiteral(publicId);
			builder.SystemLiteral(systemId);
			builder._PublicId();
		} else if (validSystemId) {
			builder.SystemId_();
			builder.SystemLiteral(systemId != null ? systemId : publicId);
			builder._SystemId();			
		}

		builder._DocTypeDecl();
	}
}
