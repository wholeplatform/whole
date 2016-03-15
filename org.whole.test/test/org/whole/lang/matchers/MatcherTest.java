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
package org.whole.lang.matchers;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.artifacts.builders.IArtifactsBuilder;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsLanguageKit;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.model.Variable;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.java.model.ClassDeclaration;
import org.whole.lang.java.model.MethodInvocation;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.matchers.GenericMatcherFactory.AbstractVariableVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.models.reflect.ModelsTemplateManager;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testentities.codebase.TestingModel;
import org.whole.lang.testentities.model.ListTestEntity;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.TraverseAllFilter;
import org.whole.langs.test.TestLanguagesDeployer;

/**
 * @author Riccardo Solmi
 */
public class MatcherTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() {
		ReflectionFactory.deploy(TestLanguagesDeployer.class);
	}

    @Test
    public void testMatch() {
		ListTestEntity testModel = new TestingModel().create();
		IEntity tPattern1 = EntityUtils.clone(testModel);
		assertTrue(Matcher.match(tPattern1, testModel));
	}

    @Test
    public void testMatchBindings() {
		IEntity pattern = buildArtifactsPattern(true);
		IEntity model = buildArtifactsPattern(false);
		IBindingManager bindings = BindingManagerFactory.instance
				.createBindingManager();

		if (Matcher.match(pattern, model, bindings)) {
			assertEquals("LGPL", bindings.wStringValue("licenseText"));
			return;
		}
		fail();
	}

    @Test
    public void testSubstitute() {
		SimpleEntity entityPattern = new SimpleEntityPattern().create();
		IBindingManager bindings = BindingManagerFactory.instance
				.createBindingManager();
		bindings.wDef("entityName", ModelsEntityFactory.instance
				.createSimpleName("SE"));

		Matcher.substitute(entityPattern, bindings, false);

		assertEquals("SE", entityPattern.getName().wStringValue());
	}

    @Test
    public void testDataSubstitute() {
		SimpleEntity entityPattern = new SimpleEntityPattern().create();
		IBindingManager bindings = BindingManagerFactory.instance
				.createBindingManager();
		bindings.wDefValue("entityName", "SE");

		Matcher.substitute(entityPattern, bindings, false);

		assertEquals("SE", entityPattern.getName().wStringValue());
		assertEquals(ModelsEntityDescriptorEnum.SimpleName, entityPattern
				.getName().wGetEntityDescriptor());
	}

    @Test
    public void testSubstituteValue() {
		SimpleEntity entityPattern = new SimpleEntityPattern().create();

		IBindingScope args = BindingManagerFactory.instance.createSimpleScope();
		args.wDefValue("entityName", "SE");
		Matcher.substitute(entityPattern, args, false);

		assertEquals("SE", entityPattern.getName().wStringValue());
		assertEquals(ModelsEntityDescriptorEnum.SimpleName, entityPattern
				.getName().wGetEntityDescriptor());
	}

    @Test
    public void testMultipleSubstitute() {
		Model modelPattern = new ModelPattern().create();
		IBindingManager bindings = BindingManagerFactory.instance
				.createBindingManager();
		bindings.wDefValue("dataEntity", "DE");

		IBindingScope args = BindingManagerFactory.instance.createSimpleScope();
		args.wDefValue("dataEntity", "DE");
		Matcher.substitute(modelPattern,  args, false);

		SimpleName var1 = (SimpleName) modelPattern.getDeclarations().wGet(0)
				.wGet(ModelsFeatureDescriptorEnum.features).wGet(0).wGet(
						ModelsFeatureDescriptorEnum.type);
		SimpleName var2 = (SimpleName) modelPattern.getDeclarations().wGet(1)
				.wGet(ModelsFeatureDescriptorEnum.name);

		assertEquals("DE", var1.wStringValue());
		assertEquals("DE", var2.wStringValue());
		assertNotSame(var1, var2);
	}

    @Test
    public void testMultipleTypesSubstitute() {
		ClassDeclaration functionPattern = new FunctionPattern().create();
		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		bindings.wDefValue("factName", "factorial");
		bindings.wDefValue("factArg", 5);

		Matcher.substitute(functionPattern, bindings, false);

		IEntity var1 = functionPattern.getBodyDeclarations().wGet(0).wGet(
				JavaFeatureDescriptorEnum.name);

		MethodInvocation methodInvocation = (MethodInvocation)
			functionPattern.getBodyDeclarations()
				.wGet(1).wGet(JavaFeatureDescriptorEnum.body).wGet(0)
				.wGet(JavaFeatureDescriptorEnum.expression)
				.wGet(JavaFeatureDescriptorEnum.arguments).wGet(0);

		IEntity var2 = methodInvocation.getName();
		IEntity var3 = methodInvocation.getArguments().wGet(0);

		assertEquals("factorial", var1.wStringValue());
		assertEquals("factorial", var2.wStringValue());
		assertEquals(5, var3.wByteValue());
	}

    @Test
    public void testRemoveVars() {
		IEntity pattern = new SimpleEntityPattern().create();
		
		Matcher.removeVars(pattern, true);
		
	    GenericTraversalFactory.instance.topDown(
	    	    new AbstractVariableVisitor() {
	    	    	public void visitVariable(Variable variable) {
	    	    		fail();
	    	    	}
	    	    }, false
	    ).visit(pattern);
	}

    @Test
    public void testRename() {
		Feature featurePattern = new FeaturePattern().create();
		Variable var = (Variable) featurePattern.getType().wGetAdaptee(false);
		assertEquals("featureType", var.getVarName().getValue());

		Matcher.rename(featurePattern, "featureType", "fType", false);

		assertEquals("fType", var.getVarName().getValue());
	}

    @Test
    public void testRenameMap() {
		Feature featurePattern = new FeaturePattern().create();
		Variable var1 = (Variable) featurePattern.getType().wGetAdaptee(false);
		Variable var2 = (Variable) featurePattern.getName().wGetAdaptee(false);
		assertEquals("featureType", var1.getVarName().getValue());
		assertEquals("featureName", var2.getVarName().getValue());

		Map<String, String> map = new HashMap<String, String>();
		map.put("featureType", "fType");
		map.put("featureName", "fName");
		Matcher.rename(featurePattern, map, false);

		assertEquals("fType", var1.getVarName().getValue());
		assertEquals("fName", var2.getVarName().getValue());
	}

    @Test
    public void testMultipleRename() {
		Model modelPattern = new ModelPattern().create();
		Variable var1 = (Variable) modelPattern.getDeclarations()
				.wGet(0).wGet(ModelsFeatureDescriptorEnum.features).wGet(0)
				.wGet(ModelsFeatureDescriptorEnum.type).wGetAdaptee(false);
		Variable var2 = (Variable) modelPattern.getDeclarations()
				.wGet(1).wGet(ModelsFeatureDescriptorEnum.name).wGetAdaptee(false);
		assertEquals("dataEntity", var1.getVarName().getValue());
		assertEquals("dataEntity", var2.getVarName().getValue());

		Matcher.rename(modelPattern, "dataEntity", "DE", false);

		assertEquals("DE", var1.getVarName().getValue());
		assertEquals("DE", var2.getVarName().getValue());
	}

	public IEntity buildArtifactsPattern(boolean isPattern) {
		ModelBuilderOperation op = new ModelBuilderOperation();

		IArtifactsBuilder b0 = (IArtifactsBuilder) op.wGetBuilder(ArtifactsLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		b0.PackageArtifact_();
		b0.Name("org.whole.lang.models");
		cb.Resolver();
		b0.Artifacts_(1);
		b0.FileArtifact_();
		cb.Resolver();
		b0.Metadata_();
		b0.Copyright("Copyright 2004-2016 Riccardo Solmi.");
		if (isPattern)
			cb.Variable("licenseText", ArtifactsEntityDescriptorEnum.License, QuantifierEnum.MANDATORY);
		else
			b0.License("LGPL");

		b0.Author("Riccardo Solmi");
		b0._Metadata();
		cb.Resolver();
		b0._FileArtifact();
		b0._Artifacts();
		b0._PackageArtifact();
		return op.wGetResult();
	}

	@Test
    public void testCompareSimpleEntityWithResolver() {
		SimpleEntity concrete = ModelsEntityFactory.instance.createSimpleEntity();
		SimpleEntity resolver = CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.SimpleEntity);
		assertFalse(Matcher.match(concrete, resolver));
	}

	@Test
    public void testForceMatch() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		IEntity textModel = ModelsTemplateManager.instance().create("Text model");
		IEntity modifiedTextModel = new ModifiedTextModel().create();
		
		// test forced match
		assertFalse(Matcher.match(textModel, modifiedTextModel));
		assertTrue(Matcher.forceMatch(textModel, modifiedTextModel));
		textModel.wAccept(new AbstractGenericForcedMatcher(bm, TraverseAllFilter.instance) {
			protected void forceMatch(IEntity pattern, IEntity model) {
				assertTrue(EntityUtils.isResolver(model));
			}
		}, modifiedTextModel);
	}

	@Test
    public void testForceMatchUsingVariables() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		IEntity textModel = ModelsTemplateManager.instance().create("Text model");
		IEntity modifiedTextModel = new ModifiedTextModel().create();

		assertTrue(Matcher.forceMatchUsingVariables(textModel, modifiedTextModel));
		assertTrue(Matcher.match(modifiedTextModel, textModel, bm));

		assertTrue(bm.wIsSet("name"));
		assertTrue(bm.wIsSet("composite_element"));
		assertTrue(bm.wIsSet("modifiers"));
		assertTrue(bm.wIsSet("composite_element1"));

		Matcher.substitute(modifiedTextModel, bm, false);
		assertTrue(Matcher.match(modifiedTextModel, textModel));
	}
}
