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
package org.whole.lang.templates;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.artifacts.builders.IArtifactsBuilder;
import org.whole.lang.artifacts.model.AttributeEnum;
import org.whole.lang.artifacts.model.FolderArtifact;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsLanguageKit;
import org.whole.lang.artifacts.templates.ResourceTemplate;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.codebase.OrderedMatcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public class ResourceTemplateTest {
	private HashMap<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();
	
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
		comparatorsMap.put(ArtifactsEntityDescriptorEnum.Artifacts, new OrderedMatcher.SimpleFeatureComparator(ArtifactsFeatureDescriptorEnum.name));

		new File("data/testfolder/empty.folder").mkdir();
	}

    @Test
    public void testReadArtifacts() {
		File testfolder = new File("data/testfolder");
		ResourceTemplate template = new ResourceTemplate(testfolder);
		ModelBuilderOperation op = new ModelBuilderOperation();
		template.apply(op);
		IEntity artifacts = getFilesystemPattern();
		IEntity artifactsFromFilesystem = op.wGetResult();
		assertTrue(OrderedMatcher.match(artifacts, artifactsFromFilesystem, comparatorsMap));
	}

    @Test
    public void testSubtreeArtifacts() {
		File testfolder = new File("data/testfolder");
		File testsubfolder = new File("data/testfolder/subfolder");
		ResourceTemplate template = new ResourceTemplate(testfolder);
		ModelBuilderOperation op = new ModelBuilderOperation();
		template.apply(op);
		IEntity testFolder = op.wGetResult();
		template = new ResourceTemplate(testsubfolder);
		op = new ModelBuilderOperation();
		template.apply(op);
		IEntity testSubFolder = op.wGetResult();

		FolderArtifact compareTo = null;
		IEntityIterator<FolderArtifact> iterator = IteratorFactory.<FolderArtifact>childMatcherIterator()
				.withPattern(ArtifactsEntityDescriptorEnum.FolderArtifact);
		iterator.reset(testFolder.wGet(ArtifactsFeatureDescriptorEnum.artifacts));
		while (iterator.hasNext()) {
			FolderArtifact folder = iterator.next();
			if (folder.getName().wEquals(testSubFolder.wGet(ArtifactsFeatureDescriptorEnum.name))) {
				compareTo = folder;
				break;
			}
		}
		assertNotNull(compareTo);
		assertTrue(OrderedMatcher.match(testSubFolder, compareTo, comparatorsMap));
	}

    @Test
    public void testReadOnlyArtifact() throws IOException {
		IEntity readOnlyMetadata = getMetadataPattern();

		File tempFile = File.createTempFile("whole", null);
		tempFile.deleteOnExit();
		ResourceTemplate template = new ResourceTemplate(tempFile);
		ModelBuilderOperation op = new ModelBuilderOperation();
		template.apply(op);
		IEntity readWriteArtifact = op.wGetResult();
		assertFalse(Matcher.match(readOnlyMetadata, readWriteArtifact));

		tempFile.setReadOnly();
		template = new ResourceTemplate(tempFile);
		op = new ModelBuilderOperation();
		template.apply(op);
		IEntity readOnlyArtifact = op.wGetResult();
		assertFalse(Matcher.match(readOnlyMetadata, readOnlyArtifact));
	}

	private IEntity getMetadataPattern() {
		ModelBuilderOperation op = new ModelBuilderOperation();
		IArtifactsBuilder ab = (IArtifactsBuilder) op.wGetBuilder(ArtifactsLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		ab.Metadata_();
		cb.Resolver();
		cb.Resolver();
		cb.Resolver();
		ab.Attributes_(1);
		ab.Attribute(AttributeEnum.readonly);
		ab._Attributes();
		cb.Resolver();
		ab._Metadata();
		return op.wGetResult();
	}

	private IEntity getFilesystemPattern() {
		ModelBuilderOperation op = new ModelBuilderOperation();
		IArtifactsBuilder ab = (IArtifactsBuilder) op.wGetBuilder(ArtifactsLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		ab.FolderArtifact_();
		ab.Name("testfolder");
		cb.Resolver();
		ab.Artifacts_(3);

		ab.FolderArtifact_();
		ab.Name("empty.folder");
		cb.Resolver();
		ab.Artifacts();
		ab._FolderArtifact();

		ab.FolderArtifact_();
		ab.Name("subfolder");
		cb.Resolver();
		ab.Artifacts_(1);

		ab.FileArtifact_();
		ab.NameWithExtension_();
		ab.Name("test");
		ab.Extension("txt");
		ab._NameWithExtension();
		cb.Resolver();
		cb.Resolver();
		ab._FileArtifact();

		ab._Artifacts();
		ab._FolderArtifact();

		ab.FileArtifact_();
		ab.NameWithExtension_();
		ab.Name("test.extensions");
		ab.Extension("txt");
		ab._NameWithExtension();
		cb.Resolver();
		cb.Resolver();
		ab._FileArtifact();

		ab.FileArtifact_();
		ab.Name("withoutext");
		cb.Resolver();
		cb.Resolver();
		ab._FileArtifact();
		return op.wGetResult();
	}
}
