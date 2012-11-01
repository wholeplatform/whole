package org.whole.lang.testentities.codebase;

import java.util.Date;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.testentities.factories.TestEntitiesEntityFactory;
import org.whole.lang.testentities.model.EnumTestEntityEnum;
import org.whole.lang.testentities.model.ITestEntity;
import org.whole.lang.testentities.model.ListTestEntity;
import org.whole.lang.testentities.model.SimpleTestEntity;
import org.whole.lang.testentities.reflect.TestEntitiesEntityDescriptorEnum;

/**
 * @generator Whole
 */
public class TestingModel extends AbstractTemplateFactory<ListTestEntity> {
	public ListTestEntity create() {
		TestEntitiesEntityFactory lf1 = TestEntitiesEntityFactory.instance;
        SimpleTestEntity e1 = lf1.createSimpleTestEntity(
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ITestEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IStructuralEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ICompositeEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IDataEntity), lf1
                        .createBooleanTestEntity(false), lf1
                        .createByteTestEntity((byte)23), lf1
                        .createCharTestEntity('v'), lf1
                        .createDoubleTestEntity(0.0), lf1
                        .createFloatTestEntity(0.0f), lf1
                        .createIntTestEntity(342), lf1
                        .createLongTestEntity(8365), lf1
                        .createShortTestEntity((short)4355), lf1
                        .createStringTestEntity("text"), lf1
                        .createDateTestEntity(new Date()), lf1
                        .createEnumTestEntity(EnumTestEntityEnum.zero), lf1
                        .createObjectTestEntity(new Object()));
        SimpleTestEntity e2 = lf1.createSimpleTestEntity(e1,
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IStructuralEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ICompositeEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IDataEntity), lf1
                .createBooleanTestEntity(true), lf1
                .createByteTestEntity((byte)123), lf1
                .createCharTestEntity('x'), lf1
                .createDoubleTestEntity(1.2), lf1
                .createFloatTestEntity(234.432f), lf1
                .createIntTestEntity(0), lf1
                .createLongTestEntity(0), lf1
                .createShortTestEntity((short)0), lf1
                .createStringTestEntity("id"), lf1
                .createDateTestEntity(new Date()), lf1
                .createEnumTestEntity(EnumTestEntityEnum.zero), lf1
                .createObjectTestEntity(new Object()));
        SimpleTestEntity e3 = lf1.createSimpleTestEntity(
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ITestEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IStructuralEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ICompositeEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IDataEntity), lf1
                        .createBooleanTestEntity(true), lf1
                        .createByteTestEntity((byte)32), lf1
                        .createCharTestEntity('h'), lf1
                        .createDoubleTestEntity(2134.0), lf1
                        .createFloatTestEntity(234432.44f), lf1
                        .createIntTestEntity(653), lf1
                        .createLongTestEntity(4325345), lf1
                        .createShortTestEntity((short)45), lf1
                        .createStringTestEntity("id"), lf1
                        .createDateTestEntity(new Date()), lf1
                        .createEnumTestEntity(EnumTestEntityEnum.zero), lf1
                        .createObjectTestEntity(new Object()));
        SimpleTestEntity e4 = lf1.createSimpleTestEntity(lf1
                .createListTestEntity(new ITestEntity[] { e2, e3 }),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IStructuralEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ICompositeEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IDataEntity), lf1
                .createBooleanTestEntity(false), lf1
                .createByteTestEntity((byte)1), lf1
                .createCharTestEntity('c'), lf1
                .createDoubleTestEntity(3.5), lf1
                .createFloatTestEntity(2.3f), lf1
                .createIntTestEntity(12), lf1
                .createLongTestEntity(1234), lf1
                .createShortTestEntity((short)21), lf1
                .createStringTestEntity("str"), lf1
                .createDateTestEntity(new Date()), lf1
                .createEnumTestEntity(EnumTestEntityEnum.zero), lf1
                .createObjectTestEntity(new Object()));
        SimpleTestEntity e5 = lf1.createSimpleTestEntity(
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ITestEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IStructuralEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.ICompositeEntity),
                CommonsEntityAdapterFactory.createResolver(TestEntitiesEntityDescriptorEnum.IDataEntity), lf1
                        .createBooleanTestEntity(false), lf1
                        .createByteTestEntity((byte)43), lf1
                        .createCharTestEntity('f'), lf1
                        .createDoubleTestEntity(376364.43), lf1
                        .createFloatTestEntity(12.43f), lf1
                        .createIntTestEntity(6456), lf1
                        .createLongTestEntity(35), lf1
                        .createShortTestEntity((short)34), lf1
                        .createStringTestEntity("id"), lf1
                        .createDateTestEntity(new Date()), lf1
                        .createEnumTestEntity(EnumTestEntityEnum.zero), lf1
                        .createObjectTestEntity(new Object()));
        return lf1.createListTestEntity(new ITestEntity[] {
                e4, e5 });
    }
}