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

import java.util.Collections;
import java.util.Date;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.contexts.IBuilderContext;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.xml.builders.IXmlBuilder;
import org.whole.lang.xml.reflect.XmlLanguageKit;

/**
 * Stream from IBuilder to IXmlBuilder
 * 
 * @author Riccardo Solmi
 */
public class XmlStoreProducerBuilder implements IBuilder {
	private IXmlBuilder xb;
	private IBindingManager bm;
	private String newPrefix = null;
	private String namespaceURI = null;

	public XmlStoreProducerBuilder(IBuilderOperation targetOperation) {
		xb = (IXmlBuilder) targetOperation.wGetBuilder(XmlLanguageKit.URI);
		bm = BindingManagerFactory.instance.createBindingManager();
	}

	protected String getNamespacePrefix(ILanguageKit languageKit) {
		String languageURI = languageKit.getURI();
		String prefix;
		if (bm.wIsSet(languageURI))
			prefix = bm.wStringValue(languageURI);
		else {
			prefix = newPrefix = calculateNamespacePrefix(languageKit);
			namespaceURI = languageKit.getURI();
			bm.wDefValue(languageURI, prefix);
		}
		return prefix;
	}
	protected String calculateNamespacePrefix(ILanguageKit languageKit) {
		String prefix = languageKit.getName().toLowerCase();
		if (!XmlUtils.isNCName(prefix))
			prefix = XmlUtils.toNCName(prefix);

		if (prefix.startsWith("xml"))
			prefix = "w"+prefix;

		return getNamespacePrefixGenerator().nextFreshName(prefix);
	}
	protected FreshNameGenerator getNamespacePrefixGenerator() {
		if (!bm.wLocalNames().contains("xmlNamespacePrefixGenerator"))
			bm.wDefValue("xmlNamespacePrefixGenerator", new FreshNameGenerator(bm.wIsSet("xmlNamespacePrefixGenerator") ?
					((FreshNameGenerator) bm.wGetValue("xmlNamespacePrefixGenerator")).getBoundNames() : 
						Collections.<String>emptySet()));
		return (FreshNameGenerator) bm.wGetValue("xmlNamespacePrefixGenerator");
	}

	public void buildStartDocument() {
		xb.Document_();
		xb.Prolog_();
		xb.XMLDecl_();
		xb.Version("1.0");
		xb._XMLDecl();
		xb._Prolog();
	}
	public void buildEndDocument() {
		xb._Document();
	}

	public void buildStartContent() {
		xb.Content_();
	}
	public void buildEndContent() {
		xb._Content();
	}

	protected void buildQualifiedName(String namespace, String name) {
		xb.QualifiedName_();
		xb.NameSpace(namespace);
		xb.Name(name);
		xb._QualifiedName();
	}
	protected void buildQualifiedName(EntityDescriptor<?> ed) {
		buildQualifiedName(getNamespacePrefix(ed.getLanguageKit()), ed.getImplName());
	}

	protected void buildAttribute(String name, String value) {
		xb.Attribute_();
		xb.Name(name);
		xb.Value(value);
		xb._Attribute();
	}
	protected void buildQualifiedAttribute(String namespace, String name, String value) {
		xb.Attribute_();
		buildQualifiedName(namespace, name);
		xb.Value(value);
		xb._Attribute();
	}
	protected void buildNamespaceAttribute(String qualifier, String uri) {
		buildQualifiedAttribute("xmlns", qualifier, uri);
	}
	protected int newNamespace() {
		return newPrefix == null ? 0 : 1;
	}
	protected void optBuildNamespaceAttribute() {
		if (newNamespace() == 1) {
			buildNamespaceAttribute(newPrefix, namespaceURI);
			newPrefix = null;
		}
	}


	protected void buildValueElement(EntityDescriptor<?> ed, String value) {
		bm.wEnterScope();
		xb.Element_();
		buildQualifiedName(ed);
		xb.Attributes_(newNamespace() + 1);
		optBuildNamespaceAttribute();
		buildAttribute("value", value);
		xb._Attributes();
		xb._Element();
		bm.wExitScope();
	}


	public void bos() {
		bm.wEnterScope();
		buildStartDocument();
	}
	
	public void eos() {
		buildEndDocument();
		bm.wExitScope();
	}

	public void wEntity_(EntityDescriptor<?> ed) {
		bm.wEnterScope();
		xb.Element_();
		buildQualifiedName(ed);
		xb.Attributes_(newNamespace());
		optBuildNamespaceAttribute();
		xb._Attributes();
		xb.Content_();
	}
	public void wEntity_(EntityDescriptor<?> ed, int initialCapacity) {
		bm.wEnterScope();
		xb.Element_();
		buildQualifiedName(ed);
		xb.Attributes_(newNamespace() + 1);
		optBuildNamespaceAttribute();
		buildAttribute("initialCapacity", Integer.toString(initialCapacity));
		xb._Attributes();
		xb.Content_(initialCapacity);
	}
    public void _wEntity(EntityDescriptor<?> ed) {
		xb._Content();
		xb._Element();    	
		bm.wExitScope();
    }

    public void wEntity(EntityDescriptor<?> ed) {
		bm.wEnterScope();
		xb.Element_();
		buildQualifiedName(ed);
		xb.Attributes_(newNamespace());
		optBuildNamespaceAttribute();
		xb._Attributes();
		xb._Element();
		bm.wExitScope();
    }

	public void wEntity(EntityDescriptor<?> ed, boolean value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseBoolean(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, byte value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseByte(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, char value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseChar(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, double value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseDouble(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, float value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseFloat(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, int value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseInt(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, long value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseLong(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, short value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseShort(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, String value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseString(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, Date value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseDate(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, EnumValue value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseEnumValue(ed, value));
	}
	public void wEntity(EntityDescriptor<?> ed, Object value) {
		buildValueElement(ed, DataTypeUtils.getDataTypeParser(ed, DataTypeParsers.PERSISTENCE).unparseObject(ed, value));
	}


	public void wSetBuilderContext(IBuilderContext context) {
	}
	public void wSetEntityContext(IEntityContext context) {
	}

	public void wDefault() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wEntity() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wEntity_() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void _wEntity() {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wFeature(int index) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wFeature(FeatureDescriptor feature) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void wFeature(ITemplate template) {
		// TODO
		throw new UnsupportedOperationException();
	}
}
