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
package org.whole.lang.reflect;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.properties.factories.PropertiesEntityFactory;
import org.whole.lang.properties.model.Entries;
import org.whole.lang.properties.model.PropertyName;
import org.whole.lang.properties.reflect.PropertiesFeatureDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class DescriptorsTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
	public void testCompositeEntityDescriptorIndexOf() {
    	PropertiesEntityFactory ef = PropertiesEntityFactory.instance;
    	Entries e1 = ef.createEntries();
    	EntityDescriptor<?> ed = e1.wGetEntityDescriptor();
    	int i1 = ed.indexOf(CommonsFeatureDescriptorEnum.composite_element);
    	assertEquals(0, i1);
    	
    	int i2 = ed.indexOf(PropertiesFeatureDescriptorEnum.name);
    	assertEquals(-1, i2);

    	int i3 = e1.wIndexOf(CommonsFeatureDescriptorEnum.composite_element);
    	assertEquals(0, i3);
    }

    @Test
	public void testDataEntityDescriptorIndexOf() {
    	PropertiesEntityFactory ef = PropertiesEntityFactory.instance;
    	PropertyName e1 = ef.createPropertyName("pn1");
    	EntityDescriptor<?> ed = e1.wGetEntityDescriptor();
    	int i1 = ed.indexOf(CommonsFeatureDescriptorEnum.data_value);
    	assertEquals(0, i1);
    }
}
