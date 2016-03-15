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
package org.whole.lang.operations;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.properties.factories.PropertiesEntityFactory;
import org.whole.lang.properties.model.Entries;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesLanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.factories.XmlEntityFactory;
import org.whole.lang.xml.model.CDataSect;
import org.whole.lang.xml.reflect.XmlLanguageKit;

/**
 * @author Riccardo Solmi
 */
public class NormalizerOperationTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testDefaultBehavior() {
    	assertFalse(ReflectionFactory.getLanguageKit(PropertiesLanguageKit.URI)
    			.hasVisitor(NormalizerOperation.ID));

    	PropertiesEntityFactory ef = PropertiesEntityFactory.instance;
    	Entries entries = ef.createEntries(
    			ef.createProperty(),
    			ef.create(PropertiesEntityDescriptorEnum.Property, "p2", "v2"));

    	Entries entriesOrig = EntityUtils.clone(entries);
    	NormalizerOperation.normalize(entries);

    	assertTrue(Matcher.match(entriesOrig, entries));
    }

    @Test
    public void testXmlBehavior() {
    	assertTrue(ReflectionFactory.getLanguageKit(XmlLanguageKit.URI)
    			.hasVisitor(NormalizerOperation.ID));

    	XmlEntityFactory ef = XmlEntityFactory.instance;
    	CDataSect data = ef.createCDataSect(
    			ef.createCDataSectData("one"),
    			ef.createCDataSectData("two"),
    			ef.createCDataSectData("three"));

    	CDataSect dataOrig = EntityUtils.clone(data);
    	NormalizerOperation.normalize(data);

    	assertFalse(Matcher.match(dataOrig, data));

    	CDataSect dataOrig2 = EntityUtils.clone(data);
    	NormalizerOperation.normalize(data);

    	assertTrue(Matcher.match(dataOrig2, data));
    }
}
