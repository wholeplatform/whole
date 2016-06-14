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
package org.whole.gen;

import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.gen.lang.reflect.GenOperationsDeployer;
import org.whole.lang.artifacts.builders.IArtifactsBuilder;
import org.whole.lang.artifacts.reflect.ArtifactsLanguageKit;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * Use HeadlessGeneratorTest.launch to launch this test
 * 
 * @author Riccardo Solmi
 */
public class ArtifactsGeneratorTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
		ReflectionFactory.deploy(GenOperationsDeployer.class);
	}

    @Test
    public void testGenerateArtifacts() {
		IBindingManager env = BindingManagerFactory.instance.createArguments();
		IEntity artifact = getMetadataPattern();

		IBindingScope args = BindingManagerFactory.instance.createSimpleScope();
		args.wDefValue("packageName", "artifact.test");
		Matcher.substitute(artifact, args, false);
		
		args.wClear();
		args.wDefValue("templateManagerName", "MyTM");
		Matcher.substitute(artifact, args, false);

		ArtifactsGeneratorOperation.generate(artifact, env);
		
//		String pn = env.wStringValue("packageName");
//		String fn = env.wStringValue("fileName");
//		String l = env.wStringValue("location");
//		String n = env.wStringValue("name");
	}
	private IEntity getMetadataPattern() {
		ModelBuilderOperation op = new ModelBuilderOperation();
		IArtifactsBuilder b0 = (IArtifactsBuilder) op.wGetBuilder(ArtifactsLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
        b0.Workspace_();
        cb.Resolver();
        b0.Projects_(1);
        b0.Project_();
        b0.Name("test.java.project2");
        b0.Natures_(1);
        b0.Nature("org.eclipse.jdt.core.javanature");
        b0._Natures();
        cb.Resolver();
        b0.Artifacts_(1);
        b0.FolderArtifact_();
        b0.Name("src/org.whole.lang");
        b0.Metadata_();
        b0.Copyright("Copyright 2004-2013 _name_.");
        b0.License("* All rights reserved. This program and the accompanying materials\n* are made available under the terms of the GNU Lesser General Public License\n* which accompanies this distribution, and is available at\n* http://www.gnu.org/copyleft/lesser.html");
        b0.Author("_name_");
        b0.Attributes_(1);
        b0.Attribute("source");
        b0._Attributes();
        b0._Metadata();
        b0.Artifacts_(1);
        b0.PackageArtifact_();
        b0.Name("org.whole.lang");
        cb.Resolver();
        b0.Artifacts();
        b0._PackageArtifact();
        b0._Artifacts();
        b0._FolderArtifact();
        b0._Artifacts();
        b0._Project();
        b0._Projects();
        b0._Workspace();
		return op.wGetResult();
	}

	@Test
    public void testGenerate() throws Exception {
		IBindingManager env = BindingManagerFactory.instance.createArguments();
		env.wDefValue("projectName", "testProject");
		env.wDefValue("sourceFolderName", "src");
		env.wDefValue("packageName", "org.whole.lang.templates.codebase");

		IEntity templates = XmlBuilderPersistenceKit.instance().readModel(
				new ClasspathPersistenceProvider("org/whole/lang/templates/codebase/TemplateManagerArtifactsTemplates.xwl"));
		ArtifactsGeneratorOperation.generate(templates, env);
	}
}
