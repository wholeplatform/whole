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
package org.whole.lang.model;

import java.beans.PropertyChangeEvent;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.events.IPropertyChangeObserver;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.ComponentModifierEnum;
import org.whole.lang.models.model.ComponentModifiers;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.factories.XmlEntityFactory;
import org.whole.lang.xml.model.Attribute;
import org.whole.lang.xml.model.Attributes;
import org.whole.lang.xsd.factories.XsdEntityFactory;
import org.whole.lang.xsd.mapping.factories.MappingEntityFactory;
import org.whole.lang.xsd.mapping.model.AttributeMapping;
import org.whole.lang.xsd.mapping.model.ElementMapping;
import org.whole.lang.xsd.mapping.model.Mapping;
import org.whole.lang.xsd.mapping.model.Mappings;
import org.whole.lang.xsd.mapping.model.StructuralMapping;
import org.whole.lang.xsd.model.Annotation;
import org.whole.lang.xsd.model.Bounded;
import org.whole.lang.xsd.model.ElementRef;
import org.whole.lang.xsd.model.NamespaceDecls;
import org.whole.lang.xsd.model.QName;
import org.whole.lang.xsd.model.StringData;
import org.whole.test.KnownFailingTests;

/**
 * @author Enrico Persiani
 */
public class ByChildAPITest {

	private static class TestPropertyChangeListener implements IPropertyChangeObserver {
		private IEntity source;
		private FeatureDescriptor fd;
		private Object oldValue;
		private Object newValue;

		public TestPropertyChangeListener(IEntity entity) {
			source = entity;
			ReflectionFactory.makeRootEntity(entity);
			entity.wGetModel().getCompoundModel().addEventListener(this);
		}
		protected void setFeatureDescriptor(FeatureDescriptor fd) {
			this.fd = fd;
		}
		protected void setNewValue(Object newValue) {
			this.newValue = newValue;
		}
		protected void setOldValue(Object oldValue) {
			this.oldValue = oldValue;
		}
		public void propertyChange(PropertyChangeEvent evt) {
			Assert.assertTrue(source == evt.getSource());
			Assert.assertTrue(fd.getName().equals(evt.getPropertyName()));
			Assert.assertTrue(newValue == evt.getNewValue());
			Assert.assertTrue(oldValue == evt.getOldValue());
		}

		public boolean isObserving(IEntity entity) {
			return source == entity;
		}
	}

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	private void orderedCompositeOperationsEntityTest(IEntity[] entitiesArray, int[] businessEquivalence, IEntity entities) {
		// test wIndexOf
		// object identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wIndexOf(entitiesArray[i]) == i);

		// business identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wIndexOf(EntityUtils.clone(entitiesArray[i])) == businessEquivalence[i]);

		// test wGet
		// business identity
		for (int i=0; i<entities.wSize(); i++)
			if (businessEquivalence[i] >= 0)
				Assert.assertTrue(entities.wGet(EntityUtils.clone(entitiesArray[i])).equals(entitiesArray[businessEquivalence[i]]));

		// test wAdd
		IEntity composite = GenericEntityFactory.instance.create(entities.wGetEntityDescriptor());
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(composite.wAdd(EntityUtils.clone(entitiesArray[i])));
		Assert.assertTrue(Matcher.match(composite, entities));
	}

	private void unorderedCompositeOperationsEntityTest(IEntity[] entitiesArray, IEntity entities) {
		// test wIndexOf
		// object identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wIndexOf(entitiesArray[i]) >= 0);

		// business identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wIndexOf(EntityUtils.clone(entitiesArray[i]))>= 0);

		// test wGet
		// business identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wGet(EntityUtils.clone(entitiesArray[i])) != null);

		// test wAdd
		IEntity composite = GenericEntityFactory.instance.create(entities.wGetEntityDescriptor());
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(composite.wAdd(EntityUtils.clone(entitiesArray[i])));

		IEntityIterator<IEntity> i = IteratorFactory.childIterator();
		i.reset(composite);
		for (IEntity child : i)
			Assert.assertTrue(entities.wContains(child));
		Assert.assertTrue(composite.wSize() == entities.wSize());
	}

	private void mapCompositeOperationsEntityTest(IEntity[] entitiesArray, IEntity entities) {
		// test wIndexOf
		// object identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wIndexOf(entitiesArray[i]) >= 0);

		// business identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wIndexOf(EntityUtils.clone(entitiesArray[i]))>= 0);

		// test wGet
		// business identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wGet(EntityUtils.clone(entitiesArray[i])) != null);

		// test wAdd
		IEntity composite = GenericEntityFactory.instance.create(entities.wGetEntityDescriptor());
		for (int i=0; i<entities.wSize(); i++) {
			try {
				composite.wAdd(EntityUtils.clone(entitiesArray[i]));
				Assert.fail();
			} catch (UnsupportedOperationException e) {
			}
		}

	}

	private void commonOperationsEntityTest(IEntity[] entitiesArray, IEntity[] valuesArray, IEntity entities) {
		// test wContains
		for (int i=0; i<entities.wSize(); i++) {
			Assert.assertTrue(entities.wContains(entitiesArray[i]));
			Assert.assertTrue(entities.wContains(EntityUtils.clone(entitiesArray[i])));
		}
		// test wGet
		// object identity
		for (int i=0; i<entities.wSize(); i++)
			Assert.assertTrue(entities.wGet(entitiesArray[i]).equals(valuesArray[i]));

		// test wRemove
		IEntity composite = GenericEntityFactory.instance.create(entities.wGetEntityDescriptor());
		IEntity[] refs = new IEntity[composite.wSize()];
		for (int i=0; i<composite.wSize(); i++)
			refs[i] = composite.wGet(i);

		IEntity composite2 = EntityUtils.clone(composite);
		for (int i=refs.length-1; i>=0; i--) {
			Assert.assertTrue(composite.wRemove(refs[i]));
			Assert.assertTrue(composite2.wRemove(refs[i]));
		}
		Assert.assertTrue(composite.wSize() == 0);
		Assert.assertTrue(composite2.wSize() == 0);
		for (int i=refs.length-1; i>=0; i--) {
			Assert.assertFalse(composite.wRemove(refs[i]));
			Assert.assertFalse(composite2.wRemove(refs[i]));
		}
	}

	private void uniqueOperationsEntityTest(IEntity[] entitiesArray, IEntity entities) {
		// test child uniqueness with wSet(oldChild, newChild)
		IEntity composite = EntityUtils.clone(entities);

		//TODO workaround for wSet boolean result always true
//		Assert.assertFalse(composite.wSet(composite.wGet(0), CloneModelOperation.clone(composite.wGet(1))));
		IEntity oldChild = composite.wGet(0);
		composite.wSet(composite.wGet(0), EntityUtils.clone(composite.wGet(1)));
		Assert.assertSame(oldChild, composite.wGet(0));
		
		IEntityIterator<IEntity> i = IteratorFactory.childIterator();
		i.reset(composite);
		for (IEntity child : i)
			Assert.assertTrue(entities.wContains(child));
		Assert.assertTrue(composite.wSize() == entities.wSize());

		// test child uniqueness with wAdd(child)
		composite = EntityUtils.clone(entities);
		Assert.assertFalse(composite.wAdd(EntityUtils.clone(composite.wGet(1))));

		i = IteratorFactory.childIterator();
		i.reset(composite);
		for (IEntity child : i)
			Assert.assertTrue(entities.wContains(child));
		Assert.assertTrue(composite.wSize() == entities.wSize());
	}

	private void propertyChangeEntityTest(IEntity[] entitiesArray, IEntity entities, IEntity prototype) {
		IEntity newValue = EntityUtils.clone(prototype);

		TestPropertyChangeListener listener = new TestPropertyChangeListener(entities);
		listener.setFeatureDescriptor(CommonsFeatureDescriptorEnum.composite_element);
		
		listener.setNewValue(prototype);
		entities.wAdd(prototype);

		listener.setNewValue(newValue);
		listener.setOldValue(prototype);
		entities.wSet(prototype, newValue);

		listener.setOldValue(newValue);
		listener.setNewValue(null);
		entities.wRemove(newValue);
	}


	@Test
	public void testAbstractUListEntity() {
		XmlEntityFactory xmlf = XmlEntityFactory.instance(RegistryConfigurations.STRICT);

		Attribute a1 = xmlf.createAttribute(xmlf.createName("attr1"), xmlf.createValue("value1"));
		Attribute a2 = xmlf.createAttribute(xmlf.createName("attr2"), xmlf.createValue("value2"));
		Attribute a3 = xmlf.createAttribute(xmlf.createName("attr3"), xmlf.createValue("value3"));

		Attribute[] attributesArray = new Attribute[] {a1, a2, a3};
		int[] businessEquivalence = new int[] {0, 1, 2};
		Attributes attributes = xmlf.createAttributes(attributesArray);

		orderedCompositeOperationsEntityTest(attributesArray, businessEquivalence, attributes);
		commonOperationsEntityTest(attributesArray, attributesArray, attributes);
		uniqueOperationsEntityTest(attributesArray, attributes);
		propertyChangeEntityTest(attributesArray, attributes, xmlf.createAttribute(xmlf.createName("attr4"), xmlf.createValue("value4")));
	}

	@Test
	public void testAbstractListEntity() {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;

		ComponentModifier o = mf.createComponentModifier(ComponentModifierEnum.ordered);
		ComponentModifier r1 = mf.createComponentModifier(ComponentModifierEnum.reference);
		ComponentModifier r2 = mf.createComponentModifier(ComponentModifierEnum.reference);
		ComponentModifier s = mf.createComponentModifier(ComponentModifierEnum.derived);

		ComponentModifier[] modifiersArray = new ComponentModifier[] {o, r1, r2, s};
		int[] businessEquivalence = new int[] {0, 1, 1, 3};
		ComponentModifiers modifiers = mf.createComponentModifiers(modifiersArray);

		orderedCompositeOperationsEntityTest(modifiersArray, businessEquivalence, modifiers);
		commonOperationsEntityTest(modifiersArray, modifiersArray, modifiers);
		propertyChangeEntityTest(modifiersArray, modifiers, mf.createComponentModifier(ComponentModifierEnum.reference));
	}

	@Test
	public void testAbstractSetCompositeEntity() {
		ModelsEntityFactory mf = ModelsEntityFactory.instance(RegistryConfigurations.STRICT);

		ComponentModifier o = mf.createComponentModifier(ComponentModifierEnum.ordered);
		ComponentModifier r = mf.createComponentModifier(ComponentModifierEnum.reference);
		ComponentModifier s = mf.createComponentModifier(ComponentModifierEnum.derived);

		ComponentModifier[] modifiersArray = new ComponentModifier[] {o, r, s};
		ComponentModifiers modifiers = mf.createComponentModifiers(modifiersArray);

		unorderedCompositeOperationsEntityTest(modifiersArray, modifiers);
		commonOperationsEntityTest(modifiersArray, modifiersArray, modifiers);
		uniqueOperationsEntityTest(modifiersArray, modifiers);
		propertyChangeEntityTest(modifiersArray, modifiers, mf.createComponentModifier(ComponentModifierEnum.unique));
	}

	@Category(KnownFailingTests.class)
	@Test
	public void testAbstractBagCompositeEntity() {
		MappingEntityFactory mf = MappingEntityFactory.instance(RegistryConfigurations.STRICT);

		AttributeMapping am = mf.createAttributeMapping();
		ElementMapping em1 = mf.createElementMapping();
		ElementMapping em2 = mf.createElementMapping();
		StructuralMapping cm = mf.createStructuralMapping();

		Mapping[] mappingsArray = new Mapping[] {am, em1, em2, cm};
		Mappings mappings = mf.createMappings(mappingsArray);

		unorderedCompositeOperationsEntityTest(mappingsArray, mappings);
		commonOperationsEntityTest(mappingsArray, mappingsArray, mappings);
		propertyChangeEntityTest(mappingsArray, mappings, mf.createStructuralMapping());
	}

//	public void testAbstractMapEntity() {
//		InfoEntityFactory infof = InfoEntityFactory.instance;
//
//		Value k1 = infof.createValue("key1");
//		Value k2 = infof.createValue("key2");
//		Value k3 = infof.createValue("key3");
//
//		Value v1 = infof.createValue("value");
//		Value v2 = infof.createValue("value");
//		Value v3 = infof.createValue("value");
//
//		Value[] keysArray = new Value[] {k1, k2, k3};
//		Value[] valuesArray = new Value[] {v1, v2, v3};
//		ValuesMap values = infof.createValuesMap();
//		for (int i=0; i<keysArray.length; i++)
//			values.wSet(keysArray[i], valuesArray[i]);
//
//		mapCompositeOperationsEntityTest(keysArray, values);
//		commonOperationsEntityTest(keysArray, valuesArray, values);
//		uniqueOperationsEntityTest(keysArray, values);
//		propertyChangeEntityTest(keysArray, values, infof.createValue("value4"));
//	}

	@Test
	public void testAbstractSimpleEntity() {
		XsdEntityFactory mf = XsdEntityFactory.instance;

		NamespaceDecls decls = mf.createNamespaceDecls(mf.createNamespaceDecl(mf.createName("prefix"), mf.createAnyURI("uri")));
		QName ref = mf.createQName("testQName");
		org.whole.lang.xsd.model.Attributes attributes = mf.createAttributes(0);
		Bounded min = mf.createBounded(1);
		Bounded max = mf.createBounded(1);
		Annotation ann = mf.createAnnotation();
		StringData id = mf.createStringData("myId");

		IEntity[] featuresArray = new IEntity[] {decls, id, attributes, min, max, ref, ann};
		int[] businessEquivalence = new int[] {-1, 1, -1, 3, 3, 5, -1};
		ElementRef elementRef = mf.createElementRef(decls, id, attributes, min, max, ref, ann);

		// test wIndexOf
		// object identity
		for (int i=0; i<elementRef.wSize(); i++)
			Assert.assertTrue(elementRef.wIndexOf(featuresArray[i]) == i);

		// business identity
		for (int i=0; i<elementRef.wSize(); i++)
			Assert.assertTrue(elementRef.wIndexOf(EntityUtils.clone(featuresArray[i])) == businessEquivalence[i]);

		// test wGet
		// business identity
		for (int i=0; i<elementRef.wSize(); i++)
			if (businessEquivalence[i] >= 0)
				Assert.assertTrue(elementRef.wGet(EntityUtils.clone(featuresArray[i])).equals(featuresArray[businessEquivalence[i]]));

		// test wContains
		for (int i=0; i<elementRef.wSize(); i++) {
			Assert.assertTrue(elementRef.wContains(featuresArray[i]));
			if (businessEquivalence[i] >= 0)
				Assert.assertTrue(elementRef.wContains(EntityUtils.clone(featuresArray[i])));
		}
		// test wGet
		// object identity
		for (int i=0; i<elementRef.wSize(); i++)
			Assert.assertTrue(elementRef.wGet(featuresArray[i]).equals(featuresArray[i]));

		// test wRemove
		IEntity entityCopy = EntityUtils.clone(elementRef);
		IEntity[] refs = new IEntity[entityCopy.wSize()];
		for (int i=0; i<entityCopy.wSize(); i++)
			refs[i] = entityCopy.wGet(i);

		IEntity entitySecondCopy = EntityUtils.clone(entityCopy);
		for (int i=refs.length-1; i>=0; i--) {
			Assert.assertTrue(entityCopy.wRemove(refs[i]));
			if (businessEquivalence[i] >= 0)
				Assert.assertTrue(entitySecondCopy.wRemove(refs[i]));
		}
		for (int i=refs.length-1; i>=0; i--) {
			Assert.assertFalse(entityCopy.wRemove(refs[i]));
			if (businessEquivalence[i] >= 0)
				Assert.assertFalse(entitySecondCopy.wRemove(refs[i]));
		}

		IEntity newEntity = EntityUtils.clone(elementRef);
		EntityDescriptor<?> ed = elementRef.wGetEntityDescriptor();
		TestPropertyChangeListener listener = new TestPropertyChangeListener(elementRef);

		for (int i=0; i<newEntity.wSize(); i++) {
			IEntity oldChild = elementRef.wGet(i);
			IEntity newChild = EntityUtils.clone(newEntity.wGet(i));
			listener.setFeatureDescriptor(ed.getEntityFeatureDescriptor(i));
			listener.setOldValue(oldChild);
			listener.setNewValue(newChild);
			elementRef.wSet(oldChild, newChild);
		}
	}
}
