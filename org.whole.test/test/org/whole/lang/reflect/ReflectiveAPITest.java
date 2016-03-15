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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.json.reflect.JSONLanguageKit;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.EditorsModel;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.models.reflect.ModelsLanguageKit;

/**
 * @author Riccardo Solmi
 */
public class ReflectiveAPITest {
    private Model model;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Before
    public void setUp() {
        model = new EditorsModel().create();
    }

	@Test
	public void testMetaModel() {
		IEntity metaModel = ReflectionFactory.getLanguageKit(JSONLanguageKit.URI, false, null).getMetaModel();
		IEntity templateModel = ReflectionFactory.getLanguageKit(ModelsLanguageKit.URI, false, null).getTemplateManager().create("JSON model");
		assertTrue(Matcher.match(metaModel, templateModel));
	}

	@Test
	public void testModelEnumerations() {
        EntityDescriptorEnum entitiesEnum = model.wGetEntityDescriptor().getEntityDescriptorEnum();
        ModelsEntityDescriptorEnum mEEnum = ModelsEntityDescriptorEnum.instance;
        assertSame(mEEnum, entitiesEnum);

    	FeatureDescriptorEnum featuresEnum = model.wGetEntityDescriptor().getFeatureDescriptorEnum();
    	ModelsFeatureDescriptorEnum mFEnum = ModelsFeatureDescriptorEnum.instance;
        assertSame(mFEnum, featuresEnum);
    }
    
	@Test
	public void testDescriptorsEnum() {
        EntityDescriptorEnum entitiesEnum = model.wGetEntityDescriptor().getEntityDescriptorEnum();
       	FeatureDescriptorEnum featuresEnum = model.wGetEntityDescriptor().getFeatureDescriptorEnum();
       	
       	ILanguageKit languageKit = entitiesEnum.getLanguageKit();
       	assertSame(languageKit, featuresEnum.getLanguageKit());

       	for (EntityDescriptor<?> ed : entitiesEnum.values()) {
			assertSame(entitiesEnum, ed.getEnumType());
			assertSame(entitiesEnum, ed.getEntityDescriptorEnum());
			assertSame(featuresEnum, ed.getFeatureDescriptorEnum());
			assertSame(languageKit, ed.getLanguageKit());
		}

       	for (FeatureDescriptor fd : featuresEnum.values()) {
       		if (fd.getOrdinal() >= 0) {
       			assertSame(featuresEnum, fd.getEnumType());
       			assertSame(featuresEnum, fd.getFeatureDescriptorEnum());
       			assertSame(languageKit, fd.getLanguageKit());
       		}
		}
    }

	@Test
	public void testEntityId() {
    	switch (model.wGetEntityOrd()) {
		case ModelsEntityDescriptorEnum.Model_ord:
			break;
		default:
			fail();
    	}
    }

	@Test
	public void testEntityHasFeature() {
        List<FeatureDescriptor> modelFeatures = model.wGetEntityDescriptor().getFeatureDescriptorEnum().values();
        
        //TODO for each entity
        Model m = (Model) model;
        List<FeatureDescriptor> entityFeatures = m.wGetEntityDescriptor().getEntityFeatureDescriptors();
        
        assertTrue(modelFeatures.containsAll(entityFeatures));
        
        for (FeatureDescriptor fd : entityFeatures)
            assertTrue(m.wContains(fd));
        
        List<FeatureDescriptor> otherFeatures = new ArrayList<FeatureDescriptor>(modelFeatures);
        otherFeatures.removeAll(entityFeatures);
        for (FeatureDescriptor fd : otherFeatures)
            assertFalse(m.wContains(fd));
    }
    
	@Test
	public void testIterators() {
        //TODO for each entity
        Model m = model;

        List<IEntity> features = new ArrayList<IEntity>();
        IEntityIterator<IEntity> i = IteratorFactory.childIterator();
        i.reset(m);
		for (IEntity e : i)
            features.add(e);

        assertSame(m.getName(), features.get(0));
        assertSame(m.getTypeRelations(), features.get(1));
        assertSame(m.getDeclarations(), features.get(2));
    }

	@Test
	public void testGetters() {
        Model m = model;
        assertSame(m.getTypeRelations(), m.wGet(ModelsFeatureDescriptorEnum.typeRelations));
        //TODO for each feature
    }
    //TODO testSetters() set getr + setr get
}
