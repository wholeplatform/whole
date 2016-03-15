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
package org.whole.lang.properties.util;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createVariable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.ScannerIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.properties.factories.PropertiesEntityFactory;
import org.whole.lang.properties.model.Entries;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.model.Property;
import org.whole.lang.properties.model.PropertyValue;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class PropertiesUtils {
	public static String getProperty(Properties props, String name) {
		return getProperty(props, name, null);
	}
	public static String getProperty(Properties props, String name, String defaultValue) {
		if (EntityUtils.isResolver(props))
			return defaultValue;

		PropertiesEntityFactory lf = PropertiesEntityFactory.instance;

		Property pattern = lf.createProperty(
				lf.createPropertyName(name),
				createVariable(PropertiesEntityDescriptorEnum.PropertyValue, "value"));
		
		Property property = Matcher.findChild(pattern, props.getEntries());
		if (property == null)
			return getProperty(props.getDefaults(), name, defaultValue);
		else
			return property.getValue().wStringValue();
	}
	public static String setProperty(Properties props, String name, String value) {
		PropertiesEntityFactory lf = PropertiesEntityFactory.instance;

		Property pattern = lf.createProperty(
				lf.createPropertyName(name),
				createVariable(PropertiesEntityDescriptorEnum.PropertyValue, "value"));
		
		Property property = Matcher.findChild(pattern, props.getEntries());
		if (property != null) {
			PropertyValue pv = property.getValue();
			String oldValue = pv.wStringValue();
			pv.wSetValue(value);
			return oldValue;
		} else {
			pattern.setValue(lf.createPropertyValue(value));
			props.getEntries().wAdd(pattern);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static Properties translate(java.util.Properties jProps) throws IOException {
		PropertiesEntityFactory lf = PropertiesEntityFactory.instance;

		Properties props = lf.create(PropertiesEntityDescriptorEnum.Properties);
		Entries entries = props.getEntries();
		if (entries.wSize() == 1)
			entries.wRemove(0); //workaround for removing the resolver
		Enumeration<String> names = (Enumeration<String>) jProps.propertyNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = jProps.getProperty(name);
			entries.wAdd(lf.createProperty(
					lf.createPropertyName(name),
					//FIXME workaround for null valued property returned from System.getProperties()
					value != null ? lf.createPropertyValue(value) : CommonsEntityAdapterFactory.createResolver(PropertiesEntityDescriptorEnum.PropertyValue)));
		}

		return props;
	}
	public static java.util.Properties translate(Properties props) {
		if (EntityUtils.isResolver(props))
			return null;

		java.util.Properties jProps = new java.util.Properties(
				translate(props.getDefaults()));

		props.getEntries();
		ScannerIterator<Property> i = IteratorFactory.<Property>childScannerIterator();
		i.reset(props.getEntries());
		for (Property p : i)
			try {
				PropertyValue value = p.getValue();
				if (!EntityUtils.isResolver(value)) //FIXME workaround for null valued property returned from System.getProperties()
					jProps.setProperty(p.getName().wStringValue(), value.wStringValue());
			} catch (IllegalArgumentException e) {
			}

		return jProps;
	}

	public static Properties loadFromText(InputStream in) throws IOException {
		java.util.Properties jProps = new java.util.Properties();
		jProps.load(in);
		return translate(jProps);
	}
	public static void saveToText(Properties props, OutputStream out, String comment) throws IOException {
		java.util.Properties jProps = translate(props);
		jProps.store(out, comment);
	}

	public static Properties loadFromXML(InputStream in) throws IOException {
		java.util.Properties jProps = new java.util.Properties();
		jProps.loadFromXML(in);
		return translate(jProps);
	}
	public static void saveToXml(Properties props, OutputStream out, String comment) throws IOException {
		java.util.Properties jProps = translate(props);
		jProps.storeToXML(out, comment);
	}	
	public static void saveToXml(Properties props, OutputStream out, String comment, String encoding) throws IOException {
		java.util.Properties jProps = translate(props);
		jProps.storeToXML(out, comment, encoding);
	}	
}
