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
package org.whole.lang.xml.builders;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.queries.model.Path;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.xml.codebase.XmlNormalizerBuilderOperation;
import org.whole.lang.xml.model.Document;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;

public class XmlNormalizerBuilderTest {

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Test
    public void testNormalizationWithoutCDataSectMerge() {
		try {
			// create queries
			Path findNestedContent = (Path) XmlNormalizerBuilderTemplateManager.instance().create("findNestedContent");
			Path findMissingContentEntities = (Path) XmlNormalizerBuilderTemplateManager.instance().create("findMissingContentEntities");
			Path findConsecutiveCharDataOrCDataSect = (Path) XmlNormalizerBuilderTemplateManager.instance().create("findConsecutiveCharDataOrCDataSect");

			// create sample xml model
			SampleXmlModel sampleXmlModelTemplate = new SampleXmlModel();
			Document xmlDocument = sampleXmlModelTemplate.create();

			// has nested Content
			IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(findNestedContent, xmlDocument);
			assertTrue(iterator.hasNext());

			// has nested implied Content
			iterator = BehaviorUtils.compileAndLazyEvaluate(findMissingContentEntities, xmlDocument);
			assertTrue(iterator.hasNext());

			// has consecutive CharData or consecutive CDataSect
			iterator = BehaviorUtils.compileAndLazyEvaluate(findConsecutiveCharDataOrCDataSect, xmlDocument);
			assertTrue(iterator.hasNext());

			// create normalized sample xml model
			ModelBuilderOperation mop = new ModelBuilderOperation();
			XmlNormalizerBuilderOperation xnop = new XmlNormalizerBuilderOperation(mop);
			sampleXmlModelTemplate.apply(xnop);
			Document normalizedXmlDocument = (Document) mop.wGetResult();

			// no nested Content
			iterator = BehaviorUtils.compileAndLazyEvaluate(findNestedContent, normalizedXmlDocument);
			assertFalse(iterator.hasNext());

			// no nested implied Content
			iterator = BehaviorUtils.compileAndLazyEvaluate(findMissingContentEntities, normalizedXmlDocument);
			assertFalse(iterator.hasNext());

			// no consecutive CharData or consecutive CDataSect
			iterator = BehaviorUtils.compileAndLazyEvaluate(findConsecutiveCharDataOrCDataSect, normalizedXmlDocument);
			assertFalse(iterator.hasNext());

			// both normalization strategies must yield the same result
			assertTrue(Matcher.match(normalizedXmlDocument, NormalizerOperation.normalize(xmlDocument)));
		} catch (Exception e) {
			fail();
		}
	}

    @Test
    public void testNormalizationWithCDataSectMerge() {
		try {
			// create queries
			Path findNestedContent = (Path) XmlNormalizerBuilderTemplateManager.instance().create("findNestedContent");
			Path findMissingContentEntities = (Path) XmlNormalizerBuilderTemplateManager.instance().create("findMissingContentEntities");
			Path findConsecutiveCharDataOrCDataSect = (Path) XmlNormalizerBuilderTemplateManager.instance().create("findConsecutiveCharDataOrCDataSect");

			// create normalized sample xml model
			SampleXmlModel sampleXmlModelTemplate = new SampleXmlModel();
			Document xmlDocument = sampleXmlModelTemplate.create();

			IBindingManager parameters = BindingManagerFactory.instance.createArguments();
			parameters.wDefValue("mergeCDataSect", true);
			ModelBuilderOperation mop = new ModelBuilderOperation();
			XmlNormalizerBuilderOperation xnop = new XmlNormalizerBuilderOperation(mop, parameters);
			sampleXmlModelTemplate.apply(xnop);
			Document normalizedXmlDocument = (Document) mop.wGetResult();

			// no nested Content
			IEntityIterator<IEntity> iterator = BehaviorUtils.compileAndLazyEvaluate(findNestedContent, normalizedXmlDocument);
			assertFalse(iterator.hasNext());

			// no nested implied Content
			iterator = BehaviorUtils.compileAndLazyEvaluate(findMissingContentEntities, normalizedXmlDocument);
			assertFalse(iterator.hasNext());

			// no consecutive CharData
			iterator = BehaviorUtils.compileAndLazyEvaluate(findConsecutiveCharDataOrCDataSect, normalizedXmlDocument);
			assertFalse(iterator.hasNext());

			// no CDataSect at all
			iterator = IteratorFactory.descendantOrSelfMatcherIterator().withPattern(XmlEntityDescriptorEnum.CDataSect);
			iterator.reset(normalizedXmlDocument);
			assertFalse(iterator.hasNext());

			// both normalization strategies must yield the same result
			assertTrue(Matcher.match(normalizedXmlDocument, NormalizerOperation.normalize(xmlDocument, parameters)));
		} catch (Exception e) {
			fail();
		}
	}
}
