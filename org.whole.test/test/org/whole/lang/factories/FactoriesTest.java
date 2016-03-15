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
package org.whole.lang.factories;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.builders.GenericBuilderAdapterOperation;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.builders.IBuilderFactory;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.builders.SpecificBuilderAdapterOperation;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.ExtendedModifiers;
import org.whole.lang.java.model.ModifierEnum;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.builders.IModelsBuilder;
import org.whole.lang.models.builders.ModelsGenericBuilderAdapter;
import org.whole.lang.models.builders.ModelsSpecificBuilderAdapter;
import org.whole.lang.models.codebase.JavaScriptModel;
import org.whole.lang.models.codebase.ModelsModel;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.TypeRelations;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.properties.factories.PropertiesEntityFactory;
import org.whole.lang.properties.model.Entries;
import org.whole.lang.properties.model.Property;
import org.whole.lang.properties.reflect.PropertiesEntityDescriptorEnum;
import org.whole.lang.properties.reflect.PropertiesLanguageKit;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.testentities.factories.TestEntitiesEntityFactory;
import org.whole.lang.testentities.model.ByteTestEntity;
import org.whole.lang.testentities.model.CharTestEntity;
import org.whole.lang.testentities.model.ShortTestEntity;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;
import org.whole.langs.test.TestLanguagesDeployer;
import org.whole.test.SlowTests;

/**
 * @author Riccardo Solmi
 */
@Category(SlowTests.class)
public class FactoriesTest {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
        ReflectionFactory.deploy(TestLanguagesDeployer.class);
    }

    @Test
	public void testCompositeFactoryMethods() {
    	IEntityRegistry efi = ReflectionFactory.getLanguageKit(PropertiesLanguageKit.URI)
    		.getEntityRegistry(RegistryConfigurations.DEFAULT);
    	PropertiesEntityFactory ef = PropertiesEntityFactory.instance;
    	Entries p = ef.createEntries(ef.createProperty(), ef.create(PropertiesEntityDescriptorEnum.Property, "p2", "v2"));
    	efi.put(p);

    	Entries e1 = ef.createEntries();
    	Assert.assertEquals(2, e1.wSize());
    	Entries e2 = ef.createEntries(new Property[0]);
    	Assert.assertEquals(0, e2.wSize());
    	Entries e3 = ef.createEntries(ef.create(PropertiesEntityDescriptorEnum.Property, "p1", "v1"));
    	Assert.assertEquals(1, e3.wSize());
    }

    @Test
	public void testDataFactoryMethodsWithPromotions() {
    	TestEntitiesEntityFactory ef = TestEntitiesEntityFactory.instance;

    	ByteTestEntity be1 = ef.createByteTestEntity((byte) 23);    	
    	Assert.assertEquals((byte) 23, be1.wByteValue());
    	ByteTestEntity be2 = ef.create(TestEntitiesEntityDescriptorEnum.ByteTestEntity,
    			(byte) 23);
    	Assert.assertEquals((byte) 23, be2.wByteValue());

    	CharTestEntity ce1 = ef.createCharTestEntity('c');    	
    	Assert.assertEquals('c', ce1.wCharValue());
    	CharTestEntity ce2 = ef.create(TestEntitiesEntityDescriptorEnum.CharTestEntity,
    			'c');
    	Assert.assertEquals('c', ce2.wCharValue());
    	CharTestEntity ce3 = ef.create(TestEntitiesEntityDescriptorEnum.CharTestEntity,
				(char) 65);
    	Assert.assertEquals(65, ce3.wCharValue());

    	ShortTestEntity se1 = ef.createShortTestEntity((short) 12345);    	
    	Assert.assertEquals((short) 12345, se1.wShortValue());
    	ShortTestEntity se2 = ef.create(TestEntitiesEntityDescriptorEnum.ShortTestEntity,
    			(short) 12345);
    	Assert.assertEquals((short) 12345, se2.wShortValue());
    }

    @Test
	public void testSimpleEntityFactoryMethodWithObjects() {
    	JavaEntityFactory ef = JavaEntityFactory.instance;
    	
    	ef.buildMethodInvocation()
    		.set(JavaFeatureDescriptorEnum.name, "methodName").getResult();
    	
    	ef.create(JavaEntityDescriptorEnum.MethodInvocation,
    			ef.createThisExpression(), ef.createTypes(),
    			"methodName", ef.createArguments());
    	
    	ef.create(JavaEntityDescriptorEnum.MethodInvocation,
    			ef.createThisExpression(), ef.createTypes(),
    			"methodName"); //with less arguments
    }
   
	//TODO replace test language with one having unique constraints
    @Test
	public void testUniqueConstraint() {
    	JavaEntityFactory ef = JavaEntityFactory.instance;
    	JavaEntityFactory sef = JavaEntityFactory.instance(RegistryConfigurations.STRICT);

    	ExtendedModifiers e = ef.createExtendedModifiers(
    			ef.createModifier(ModifierEnum._abstract),
    			ef.createModifier(ModifierEnum._abstract));
    	e.wAdd(ef.createModifier(ModifierEnum._abstract));
    	Assert.assertEquals(3, e.wSize());

    	ExtendedModifiers se = sef.createExtendedModifiers(
    			sef.createModifier(ModifierEnum._abstract),
    			sef.createModifier(ModifierEnum._abstract));
    	se.wAdd(ef.createModifier(ModifierEnum._abstract));
    	Assert.assertEquals(3, se.wSize());//TODO was 1
    	
    	Assert.assertTrue(Matcher.match(se, e)); //TODO was false
    	Assert.assertFalse(Matcher.match(se, ef.createExtendedModifiers(
    			ef.createModifier(ModifierEnum._abstract)))); //TODO was true
    }

    @Test
	public void testStrictMatch() {
    	IEntity model = new JavaScriptModel().create();
    	
    	ModelBuilderOperation op = new ModelBuilderOperation(
    			RegistryConfigurations.STRICT);
    	new JavaScriptModel().apply(op);
    	IEntity strictModel = op.wGetResult();
    	
    	Assert.assertTrue(Matcher.match(model, strictModel));

    	op = new ModelBuilderOperation(RegistryConfigurations.RESOLVER);
    	new JavaScriptModel().apply(op);
    	IEntity resolverModel = op.wGetResult();
    	
    	Assert.assertTrue(Matcher.match(model, resolverModel));
    	Assert.assertTrue(Matcher.match(strictModel, resolverModel));
    }

    @Test
	public void testDynamicFactory() {
    	TypeRelations typeRelations = ModelsEntityFactory.instance.createTypeRelations();
    	IEntityFactory ef = GenericEntityFactory.instance(RegistryConfigurations.CUSTOM);

    	InterpreterOperation.interpret(new ModelsModel().create());
		ILanguageKit lk = ReflectionFactory.getLanguageKit("http://lang.whole.org/Models");

    	EntityDescriptorEnum edEnum = lk.getEntityDescriptorEnum();
    	typeRelations.wAdd(ef.create(edEnum.valueOf("TypeAliasOf")));

//    	PrettyPrinterOperation.prettyPrint(typeRelations);
    	Assert.assertFalse(typeRelations.wIsAdapter());


    	ReflectionFactory.deploy(new ModelsLanguageDynamicTestDeployer());


    	IEntity e1 = ef.create(ModelsEntityDescriptorEnum.TypeRelations,
    			ef.create(ModelsEntityDescriptorEnum.TypeAliasOf),
    			ef.create(ModelsEntityDescriptorEnum.SubtypesOf).wGetAdaptee(false));

    	PrettyPrinterOperation.prettyPrint(e1);
    	Assert.assertTrue(e1.wIsAdapter());
    }

    @Test
	public void testDynamicMatch() {
    	ReflectionFactory.deploy(new ModelsLanguageDynamicTestDeployer());
    	
    	IEntity model = new JavaScriptModel().create();
    	
    	ModelBuilderOperation op = new ModelBuilderOperation(
    			RegistryConfigurations.CUSTOM);
    	new JavaScriptModel().apply(op);
    	IEntity dynamicModel = op.wGetResult();
  
    	Assert.assertTrue(Matcher.match(model, dynamicModel));
    }

    public static class ModelsDynamicTestLanguageKit extends ModelsLanguageKit {
    	@Override
    	protected IEntityRegistry createCustomEntityRegistry() {
        	IEntityRegistry er = createDynamicEntityRegistry();
        	DefaultEntityRegistryConfiguration.instance.apply(er);
        	return er;
    	}
    }
    public static class ModelsLanguageDynamicTestDeployer extends AbstractLanguageExtensionDeployer {
    	public void deploy(ReflectionFactory platform) {
    		platform.addLanguageKit(new ModelsDynamicTestLanguageKit());
    		platform.addOperationFactory(ModelsLanguageKit.URI,
    				GenericBuilderAdapterOperation.ID, new IBuilderFactory() {
    					public IBuilder create(IBuilder strategy,
    							IEntityContext entityContext) {
    						return new ModelsGenericBuilderAdapter(
    								(IModelsBuilder) strategy, entityContext);
    					}
    				});
    		platform.addOperationFactory(ModelsLanguageKit.URI,
    				SpecificBuilderAdapterOperation.ID, new IBuilderFactory() {
    					public IBuilder create(IBuilder strategy,
    							IEntityContext entityContext) {
    						return new ModelsSpecificBuilderAdapter(strategy,
    								entityContext);
    					}
    				});
    	}
    }
}
