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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.executables.ExecutableFactory;
import org.whole.lang.executables.IExecutable;
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
			IExecutable<IEntity> executable = BehaviorUtils.compileAndLazyEvaluate(findNestedContent, xmlDocument);
			assertNotNull(executable.evaluateNext());

			// has nested implied Content
			executable = BehaviorUtils.compileAndLazyEvaluate(findMissingContentEntities, xmlDocument);
			assertNotNull(executable.evaluateNext());

			// has consecutive CharData or consecutive CDataSect
			executable = BehaviorUtils.compileAndLazyEvaluate(findConsecutiveCharDataOrCDataSect, xmlDocument);
			assertNotNull(executable.evaluateNext());

			// create normalized sample xml model
			ModelBuilderOperation mop = new ModelBuilderOperation();
			XmlNormalizerBuilderOperation xnop = new XmlNormalizerBuilderOperation(mop);
			sampleXmlModelTemplate.apply(xnop);
			Document normalizedXmlDocument = (Document) mop.wGetResult();

			// no nested Content
			executable = BehaviorUtils.compileAndLazyEvaluate(findNestedContent, normalizedXmlDocument);
			assertNull(executable.evaluateNext());

			// no nested implied Content
			executable = BehaviorUtils.compileAndLazyEvaluate(findMissingContentEntities, normalizedXmlDocument);
			assertNull(executable.evaluateNext());

			// no consecutive CharData or consecutive CDataSect
			executable = BehaviorUtils.compileAndLazyEvaluate(findConsecutiveCharDataOrCDataSect, normalizedXmlDocument);
			assertNull(executable.evaluateNext());

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
			IExecutable<IEntity> executable = BehaviorUtils.compileAndLazyEvaluate(findNestedContent, normalizedXmlDocument);
			assertNull(executable.evaluateNext());

			// no nested implied Content
			executable = BehaviorUtils.compileAndLazyEvaluate(findMissingContentEntities, normalizedXmlDocument);
			assertNull(executable.evaluateNext());

			// no consecutive CharData
			executable = BehaviorUtils.compileAndLazyEvaluate(findConsecutiveCharDataOrCDataSect, normalizedXmlDocument);
			assertNull(executable.evaluateNext());

			// no CDataSect at all
			ExecutableFactory f = ExecutableFactory.instance;
			executable = f.createFilter(f.createDescendantOrSelf(), f.createHasType(XmlEntityDescriptorEnum.CDataSect.getURI()));
			executable.reset(normalizedXmlDocument);
			assertNull(executable.evaluateNext());

			// both normalization strategies must yield the same result
			assertTrue(Matcher.match(normalizedXmlDocument, NormalizerOperation.normalize(xmlDocument, parameters)));
		} catch (Exception e) {
			fail();
		}
	}
}
