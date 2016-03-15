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
package org.whole.lang.properties;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.properties.factories.PropertiesEntityFactory;
import org.whole.lang.properties.model.Properties;
import org.whole.lang.properties.model.Property;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesTemplateManager;
import org.whole.lang.properties.util.PropertiesUtils;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class PropertiesTest {

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Test
	public void testGetSetProperty() {
		PropertiesEntityFactory lf = PropertiesEntityFactory.instance;

		Properties props = lf.createProperties(
				lf.createComment("Test properties"),
				createResolver(PropertiesEntityDescriptorEnum.Properties),
				lf.createEntries(new Property[] {
					lf.createProperty(
							lf.createPropertyName("prop1"),
							lf.createPropertyValue("value 1")),
							lf.createProperty(
									lf.createPropertyName("prop2"),
									lf.createPropertyValue("value 2"))	
				}));
		
		String prop1Value = PropertiesUtils.getProperty(props, "prop1");
		Assert.assertEquals("value 1", prop1Value);
	}

	@Test
	public void testTranslate() {
		java.util.Properties jProps = new java.util.Properties();
		jProps.setProperty("key1", "value1");
		jProps.setProperty("key2", "value2");
		jProps.setProperty("key3", "value3");
		jProps.setProperty("key4", "value4");
		
		try {
			Properties props = PropertiesUtils.translate(jProps);
			Assert.assertEquals(4, props.getEntries().wSize());
			Assert.assertTrue(EntityUtils.isResolver(props.getDefaults()));

			java.util.Properties jProps3 = PropertiesUtils.translate(props);
			Assert.assertEquals(jProps, jProps3);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void testLoadAsText() throws IOException {
		Properties props1 = PropertiesUtils.loadFromText(PropertiesTest.class.getResourceAsStream("plugin.properties"));
		Properties props2 = PropertiesUtils.loadFromText(PropertiesTest.class.getResourceAsStream("build.properties"));

		PropertiesUtils.saveToText(props2, System.out, "comment");
		PropertiesUtils.saveToXml(props1, System.out, "comment");
	}

	@Test
	public void testSystemProperties() throws IOException {
		Properties props = (Properties) PropertiesTemplateManager.instance().create("System Properties");
		PropertiesUtils.saveToText(props, System.out, "comment");
	}
}
