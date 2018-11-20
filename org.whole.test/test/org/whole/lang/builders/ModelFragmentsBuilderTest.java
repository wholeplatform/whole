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
package org.whole.lang.builders;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.builders.builder.ModelFeaturesBuilder;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.codebase.ModelsModel;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.templates.ITemplateFactory;
import org.whole.lang.util.EntityUtils;

public class ModelFragmentsBuilderTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testModelFeaturesBuilder() {
		ITemplateFactory<Model> modelsModel = new ModelsModel();		
		final Features features = ModelsEntityFactory.instance.createFeatures(0);

		modelsModel.apply(new SpecificBuilderAdapterOperation(
				new ModelFeaturesBuilder(features)));

		int count = 0;
		Model model = modelsModel.create();
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable i = f.createFilter(f.createDescendantOrSelf(), f.createHasType(ModelsEntityDescriptorEnum.Feature.getURI()));
		i.reset(model);
		for (Feature feature = (Feature) i.evaluateNext(); feature != null;
					 feature = (Feature) i.evaluateNext())
			if (EntityUtils.isNotResolver(feature))
				count++;

		assertEquals(features.wSize(), count);
	}

    @Test
    public void testModelFeaturesBuilderWithFeatureEvents() {
		ITemplateFactory<Model> modelsModel = new ModelsModelWithFeatureEvents();		
		Features features = ModelsEntityFactory.instance.createFeatures(0);

		modelsModel.apply(new SpecificBuilderAdapterOperation(
				new ModelFeaturesBuilder(features)));
		
		int count = 0;
		Model model = modelsModel.create();
		ExecutableFactory f = ExecutableFactory.instance;
		IExecutable i = f.createFilter(f.createDescendantOrSelf(), f.createHasType(ModelsEntityDescriptorEnum.Feature.getURI()));
		i.reset(model);
		for (Feature feature = (Feature) i.evaluateNext(); feature != null;
				 feature = (Feature) i.evaluateNext())
		if (EntityUtils.isNotResolver(feature))
				count++;

		assertEquals(features.wSize(), count);
	}
}
