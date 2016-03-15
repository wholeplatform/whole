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

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.whole.lang.artifacts.factories.ArtifactsEntityFactory;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.artifacts.templates.ResourceTemplate;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.codebase.OrderedMatcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResourceArtifactsGeneratorTest {
	private File workspaceFolder;
	private IEntity artifacts;

	private Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();
	
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
		comparatorsMap.put(ArtifactsEntityDescriptorEnum.Artifacts, new OrderedMatcher.SimpleFeatureComparator(ArtifactsFeatureDescriptorEnum.name));
		workspaceFolder = new File("..");
		artifacts = new ArtifactsSampleModel().create();
	}

    @Test
    public void test1GenerateWorkspace() {
		assertTrue(workspaceFolder.exists());

		IBindingManager bindings = BindingManagerFactory.instance.createArguments();
		bindings.wDefValue("folderLocation", workspaceFolder.getAbsolutePath());

		ArtifactsGeneratorOperation.generate(artifacts, bindings);

		File genFolder = new File("data/gen");
		assertTrue(genFolder.exists());
	}

    @Test
    public void test2CompareArtifacts() {
		ArtifactsEntityFactory aef = ArtifactsEntityFactory.instance;

		File genFolder = new File("data/gen");
		ResourceTemplate resourceTemplate = new ResourceTemplate(genFolder);
		ModelBuilderOperation mop = new ModelBuilderOperation();
		resourceTemplate.apply(mop);

		IEntity artifactsRevEng = mop.wGetResult();
		
		IEntity artifactsSubTree = Matcher.find(
				aef.createFolderArtifact(
						aef.createName("gen"),
						CommonsEntityAdapterFactory.createVariable(ArtifactsEntityDescriptorEnum.Metadata, "metadata"),
						CommonsEntityAdapterFactory.createVariable(ArtifactsEntityDescriptorEnum.Artifacts, "artifacts")),
						artifacts, false);
		assertNotNull(artifactsSubTree);
		assertTrue(OrderedMatcher.match(artifactsRevEng, artifactsSubTree, comparatorsMap));
	}
}
