/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.xsd.resources;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.ResourceRegistry;
import org.whole.lang.resources.URLURIResolver;
import org.whole.lang.xml.util.InputStreamInput;
import org.whole.lang.xsd.codebase.MappingStrategyRegistry;
import org.whole.lang.xsd.codebase.SchemaMapping;
import org.whole.lang.xsd.model.Schema;
import org.whole.lang.xsd.util.SchemaUtils;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class XsdRegistry extends ResourceRegistry<IResource> {
	private static class SingletonHolder {
		private static final XsdRegistry instance = new XsdRegistry();
	}
	public static final XsdRegistry instance() {
		XsdRegistry registry = SingletonHolder.instance;

		String registryId = Schema.class.getName();
		if (!ResourceRegistry.hasRegistry(registryId)) {
			ResourceRegistry.putRegistry(registryId, registry);
			
			// setup some internal schemas and mappings
			registry.deploySchemaForSchema();
			registry.predeploySchemas("XMLNamespace.xsd");
		}

		return registry;
	}
	public static void initialize() {
		instance();
	}

	protected XsdRegistry() {
		super(new URLURIResolver());
		getResourceFactoryRegistry().setDefaultResourceFactory(
				new XsdResourceFactory(getResourceFactoryRegistry()));
	}

	protected void deploySchemaForSchema() {
		String location = "XMLSchema.xsd";

		MappingStrategyRegistry.instance().putMappingModel(new SchemaMapping().create());

		//FIXME replace with real schema for schema model with annotations
		InputStream is = getClass().getResourceAsStream(location);
		Schema schemaForSchema = SchemaUtils.load(new InputStreamInput(is));
		putSchema(location, schemaForSchema, true);
	}

	protected void predeploySchemas(String... locations) {
		IBindingManager args = BindingManagerFactory.instance.createArguments();
		args.wDefValue("predeployed", true);
		args.wDefValue("fileName", "");
		args.wDefValue("fileExtension", "");
		args.wDefValue("fileNameWithExtension", "");
		args.wDefValue("fileLocationURI", "");

		for (String location : locations) {
			String fileNameWithExtension = location.replaceFirst("^.*/", "");
			String filename = fileNameWithExtension.replaceFirst("\\.[^\\.]*$", "");
			args.wSetValue("fileName", filename);
			args.wSetValue("fileExtension", fileNameWithExtension.substring(filename.length()+1));
			args.wSetValue("fileNameWithExtension", fileNameWithExtension);
			args.wSetValue("fileLocationURI", getClass().getResource(location).toExternalForm());

			InputStream is = getClass().getResourceAsStream(location);
			Schema schema = SchemaUtils.load(new InputStreamInput(is));
			InterpreterOperation.interpret(schema, args);
		}
	}

	public boolean putSchema(String location, Schema schema) {
		return putSchema(location, schema, false);
	}
	public boolean putSchema(String location, Schema schema, boolean predeployed) {
		String targetNamespace = schema.getTargetNamespace().getValue();
//		updateSchemaLocation(targetNamespace, location);
		//FIXME put location somewhere
		return addResource(schema, targetNamespace, false);
//		return  schemaMap.put(targetNamespace, schema) != null;
	}
	public boolean removeSchema(Schema schema) {
		return removeSchema(schema.getTargetNamespace().getValue());
	}
	public boolean removeSchema(String targetNamespace) {
//		updateSchemaLocation(targetNamespace, null);
		//FIXME clear location somewhere
		return removeResource(targetNamespace);
//		return schemaMap.remove(targetNamespace) != null;
	}

	public Collection<Schema> schemas() {
		Collection<IResource> resources = getResources(true, new Comparator<IResource>() {
			public int compare(IResource s1, IResource s2) {
				return s1.getNamespace().compareTo(s2.getNamespace());
			}
		});
		List<Schema> schemas = new ArrayList<Schema>(resources.size());
		for (IResource resource : resources)
			schemas.add(resource.<Schema>getEntity());
		return Collections.unmodifiableList(schemas);
	}

	public Schema getSchemaFor(IEntity entity) {
		return getSchemaFor(entity.wGetLanguageKit().getURI());
	}
	public Schema getSchemaFor(String targetNamespace) {
		IResource resource = getResource(targetNamespace, false, null);
		return resource != null ? resource.<Schema>getEntity() : null;
	}

	public boolean containsSchema(Schema s) {
		return containsSchemaFor(s.getTargetNamespace().getValue());
	}
	public boolean containsSchemaFor(IEntity entity) {
		return containsSchemaFor(entity.wGetLanguageKit().getURI());
	}
	public boolean containsSchemaFor(String targetNamespace) {
		return containsResource(targetNamespace, false, null);
	}
}
