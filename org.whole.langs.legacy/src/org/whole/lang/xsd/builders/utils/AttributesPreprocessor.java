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
package org.whole.lang.xsd.builders.utils;

import static org.whole.lang.xsd.util.NamespaceUtils.calculateInternalNamespace;
import static org.whole.lang.xsd.util.NamespaceUtils.getDefaultNamespace;
import static org.whole.lang.xsd.util.NamespaceUtils.isXsiNamespace;
import static org.whole.lang.xsd.util.NamespaceUtils.redefineDefaultNamespace;
import static org.whole.lang.xsd.util.NamespaceUtils.redefineNamespace;

import java.io.File;
import java.io.IOException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.model.Attribute;
import org.whole.lang.xml.model.Attributes;
import org.whole.lang.xml.util.QName;
import org.whole.lang.xml.util.ResourceResolver;
import org.whole.lang.xsd.codebase.XsdDeployStrategies;
import org.whole.lang.xsd.factories.XsdEntityFactory;
import org.whole.lang.xsd.model.NamespaceDecl;
import org.whole.lang.xsd.model.Schema;
import org.whole.lang.xsd.util.SchemaUtils;

/**
 * @author Enrico Persiani
 */
public class AttributesPreprocessor {
	private IBindingManager bindings;
	private IBindingManager namespaces;

	public AttributesPreprocessor(IBindingManager bindings, IBindingManager namespaces) {
		this.namespaces = namespaces;
		this.bindings = bindings;
	}

	private String getCurrentFolderLocation() {
		try {
			return new File(".").getCanonicalPath();
		} catch (IOException e) {
			throw new IllegalStateException("cannot find current folder location", e);
		}
	}
	protected String getFolderLocation() {
		return bindings.wIsSet("folderLocation") ? bindings.wStringValue("folderLocation") : getCurrentFolderLocation();
	}
	/* was LSResourceResolver, workaround for Android compatibility */
	protected ResourceResolver getLSResourceResolver() {
		return bindings.wIsSet("lsResourceResolver") ? (ResourceResolver) bindings.wGetValue("lsResourceResolver") :
			(bindings.wIsSet("packageName") ? new ResourceResolver(bindings.wStringValue("packageName")) : null);
	}

	public void preprocess(Attributes attributes) {
		IEntityIterator<Attribute> iterator = IteratorFactory.<Attribute>childIterator();
		iterator.reset(attributes);
		while(iterator.hasNext()) {
			Attribute attribute = iterator.next();

			if (updateNamespaceDeclarations(attribute) || processXsiDirectives(attribute))
				iterator.remove();
		}
	}

	private IBindingManager results = BindingManagerFactory.instance.createBindingManager();
	protected boolean updateNamespaceDeclarations(Attribute attribute) {
		results.wClear();
		if (!AttributesMatcherFactory.matchNamespaceDeclaration(attribute, results)) 
			return false;
		
		String uri = results.wStringValue("uri");

		if (results.wIsSet("xmlns")) {
			String prefix = results.wStringValue("xmlns");
			redefineNamespace(namespaces, prefix, uri);
		} else
			redefineDefaultNamespace(namespaces, uri);

		return true;
	}

	public boolean hasExplicitType() {
		return bindings.wLocalNames().contains("xsiType");
	}

	public EntityDescriptor<?> getExplicitType() {
		String[] typeRef = bindings.wStringValue("xsiType").split(":");
		if (typeRef.length == 1) {
			
		} else {
			
		}
		String targetNamespace = typeRef.length == 1 ?
				getDefaultNamespace(namespaces) : namespaces.wStringValue(typeRef[0]);
		
//		QName qname = QName.create(namespaces, attribute.getName(), getDefaultNamespace(namespaces));
//		QName.create(namespaces, , getDefaultNamespace(namespaces));
		return null;//CommonsDataTypePersistenceParser.getEntityDescriptor(edUri);
	}

	protected boolean processXsiDirectives(Attribute attribute) {
		QName qname = QName.create(namespaces, getDefaultNamespace(namespaces), attribute.getName());

		if (!isXsiNamespace(qname.getNamespaceURI()))
			return false;

		if ("schemaLocation".equals(qname.getLocalPart()))
			processSchemaLocation(attribute.getValue().wStringValue());
		else if ("noNamespaceSchemaLocation".equals(qname.getLocalPart()))
			processNoNamespaceSchemaLocation(attribute.getValue().wStringValue());
		else if ("type".equals(qname.getLocalPart()))
			bindings.wDefValue("xsiType", attribute.getValue().getValue());
		else if ("nil".equals(qname.getLocalPart()))
			bindings.wDefValue("nil", true);
		else
			throw new IllegalStateException("unknown xml schema instance directive");

		return true;
	}

	protected void processNoNamespaceSchemaLocation(String schemaLocationUrl) {
		String targetNamespace = calculateInternalNamespace(true);
		Schema schema = SchemaUtils.load(targetNamespace, schemaLocationUrl, getFolderLocation(), getLSResourceResolver());

		// add the generated default namespace to the schema
		final XsdEntityFactory xef = XsdEntityFactory.instance;
		NamespaceDecl namespaceDecl = xef.createNamespaceDecl();
		namespaceDecl.setUri(xef.createAnyURI(targetNamespace));
		schema.getNamespaces().add(namespaceDecl);
		schema.setTargetNamespace(xef.createAnyURI(targetNamespace));

		if (XsdDeployStrategies.shouldDeploy(bindings, targetNamespace))
			SchemaUtils.deploy(schema, BindingManagerFactory.instance.createArguments());

		redefineDefaultNamespace(namespaces, targetNamespace);
	}

	protected void processSchemaLocation(String schemaLocations) {
		String[] locations = schemaLocations.split("\\s+");
		if (locations.length % 2 != 0)
			throw new IllegalArgumentException("bad schemaLocation directive "+schemaLocations);

		for (int i=0; i<locations.length; i+=2) {
			String targetNamespace = locations[i];
			String schemaLocation = locations[i+1];

			if (XsdDeployStrategies.shouldDeploy(bindings, targetNamespace))
				SchemaUtils.deploy(targetNamespace, schemaLocation, getFolderLocation(), getLSResourceResolver());
//FIXME				XsdRegistry.instance().getURIResolverRegistry().addLocator(targetNamespace, schemaLocation);
		}
	}
}
