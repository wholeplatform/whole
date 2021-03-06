package org.whole.lang.models.codebase;

import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.models.builders.IModelsBuilder;

/**
 * @generator Whole
 */
public class TestORM extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {
	public void apply(IBuilderOperation op) {
		IModelsBuilder b0 = (IModelsBuilder) op
				.wGetBuilder(ModelsLanguageKit.URI);
		b0.Model_();
		b0.SimpleName("TestORM");
		b0.TypeRelations();
		b0.ModelDeclarations_(71);
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple");
		b0.Types();
		b0.Features_(5);
		b0.Feature_();
		b0.FeatureModifiers_(1);
		b0.FeatureModifier("id");
		b0._FeatureModifiers();
		b0.SimpleName("StringData");
		b0.SimpleName("stringData");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("AllDataTypesSimple");
		b0.SimpleName("allSimple");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("AllDataTypesSimpleEmbedded");
		b0.SimpleName("allSimpleEmbedded");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("AllDataTypesEmbeddedSimple");
		b0.SimpleName("allEmbeddedSimple");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("AllDataTypesEmbeddedSimpleEmbedded");
		b0.SimpleName("allEmbeddedSimpleEmbedded");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllDataTypesSimple");
		b0.Types();
		b0.Features_(11);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("BooleanData");
		b0.SimpleName("booleanValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ByteData");
		b0.SimpleName("byteValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharData");
		b0.SimpleName("charValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DoubleData");
		b0.SimpleName("doubleValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("FloatData");
		b0.SimpleName("floatValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("intValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("LongData");
		b0.SimpleName("longValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ShortData");
		b0.SimpleName("shortValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("StringData");
		b0.SimpleName("stringValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DateData");
		b0.SimpleName("dateValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EnumData");
		b0.SimpleName("enumValue");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllDataTypesSimpleEmbedded");
		b0.Types();
		b0.Features_(11);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("BooleanData");
		b0.SimpleName("booleanValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ByteData");
		b0.SimpleName("byteValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharData");
		b0.SimpleName("charValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DoubleData");
		b0.SimpleName("doubleValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("FloatData");
		b0.SimpleName("floatValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("intValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("LongData");
		b0.SimpleName("longValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ShortData");
		b0.SimpleName("shortValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("StringData");
		b0.SimpleName("stringValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DateData");
		b0.SimpleName("dateValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EnumData");
		b0.SimpleName("enumValue");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllDataTypesEmbeddedSimple");
		b0.Types();
		b0.Features_(11);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("BooleanDataEmbedded");
		b0.SimpleName("booleanValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ByteDataEmbedded");
		b0.SimpleName("byteValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharDataEmbedded");
		b0.SimpleName("charValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DoubleDataEmbedded");
		b0.SimpleName("doubleValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("FloatDataEmbedded");
		b0.SimpleName("floatValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntDataEmbedded");
		b0.SimpleName("intValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("LongDataEmbedded");
		b0.SimpleName("longValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ShortDataEmbedded");
		b0.SimpleName("shortValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("StringDataEmbedded");
		b0.SimpleName("stringValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DateDataEmbedded");
		b0.SimpleName("dateValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EnumDataEmbedded");
		b0.SimpleName("enumValue");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllDataTypesEmbeddedSimpleEmbedded");
		b0.Types();
		b0.Features_(11);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("BooleanDataEmbedded");
		b0.SimpleName("booleanValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ByteDataEmbedded");
		b0.SimpleName("byteValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharDataEmbedded");
		b0.SimpleName("charValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DoubleDataEmbedded");
		b0.SimpleName("doubleValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("FloatDataEmbedded");
		b0.SimpleName("floatValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntDataEmbedded");
		b0.SimpleName("intValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("LongDataEmbedded");
		b0.SimpleName("longValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ShortDataEmbedded");
		b0.SimpleName("shortValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("StringDataEmbedded");
		b0.SimpleName("stringValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("DateDataEmbedded");
		b0.SimpleName("dateValue");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("EnumDataEmbedded");
		b0.SimpleName("enumValue");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ImplicitTypesSimple");
		b0.Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers_(1);
		b0.FeatureModifier("id");
		b0._FeatureModifiers();
		b0.SimpleName("StringData");
		b0.SimpleName("stringData");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("SimpleTypesSimple1I");
		b0.SimpleName("simple1Implicit");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("SimpleTypesSimple2I");
		b0.SimpleName("simple2Implicit");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("SimpleTypesSimple3I");
		b0.SimpleName("simple3Implicit");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple1I");
		b0.Types_(2);
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("IAllTypesImplicit");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple2I");
		b0.Types_(2);
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("IAllTypesImplicit");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharData");
		b0.SimpleName("char1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple3I");
		b0.Types_(2);
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("IAllTypesImplicit");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleImplicit");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple1TPE");
		b0.Types_(2);
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("IAllTypesImplicit");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple2TPE");
		b0.Types_(2);
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("IAllTypesImplicit");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharData");
		b0.SimpleName("char1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple3TPE");
		b0.Types_(2);
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("IAllTypesImplicit");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerEntity");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple1TPT");
		b0.Types_(1);
		b0.SimpleName("ISimpleTablePerType");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple2TPT");
		b0.Types_(1);
		b0.SimpleName("ISimpleTablePerType");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharData");
		b0.SimpleName("char1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple3TPT");
		b0.Types_(1);
		b0.SimpleName("ISimpleTablePerType");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple1AllTPT");
		b0.Types_(1);
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerType");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple2AllTPT");
		b0.Types_(1);
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerType");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharData");
		b0.SimpleName("char1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple3AllTPT");
		b0.Types_(1);
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerType");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerType");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple1AllTPE");
		b0.Types_(1);
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerEntity");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple2AllTPE");
		b0.Types_(1);
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.Features_(4);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("ISimpleTablePerType");
		b0.SimpleName("simple2");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerEntity");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("CharData");
		b0.SimpleName("char1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypesSimple3AllTPE");
		b0.Types_(1);
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.Features_(3);
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerEntity");
		b0.SimpleName("simple1");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IAllTypesTablePerEntity");
		b0.SimpleName("simple3");
		b0._Feature();
		b0.Feature_();
		b0.FeatureModifiers();
		b0.SimpleName("IntData");
		b0.SimpleName("int2");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("BooleanDataEmbeddedListTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("BooleanDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ByteDataEmbeddedListTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("ByteDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("CharDataEmbeddedSetTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("CharDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DoubleDataEmbeddedSetTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("DoubleDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("FloatDataEmbeddedUListTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(2);
		b0.ComponentModifier("unique");
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("FloatDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("IntDataEmbeddedUListTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers_(2);
		b0.ComponentModifier("unique");
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("IntDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("LongDataEmbeddedBagTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers();
		b0.SimpleName("LongDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ShortDataEmbeddedBagTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers();
		b0.SimpleName("ShortDataEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeEmbeddedListTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("AllDataTypesSimpleEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeEmbeddedUListTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(2);
		b0.ComponentModifier("unique");
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("AllDataTypesSimpleEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeEmbeddedSetTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("AllDataTypesSimpleEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeEmbeddedBagTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers();
		b0.SimpleName("AllDataTypesSimpleEmbedded");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeListTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("SimpleTypesSimple");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeListTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("ImplicitTypesSimple");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllTPTTypesListTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("IAllTypesTablePerType");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllTPETypesListTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("ordered");
		b0._ComponentModifiers();
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeSetTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("SimpleTypesSimple");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeSetTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("ImplicitTypesSimple");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllTPTTypesSetTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("IAllTypesTablePerType");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllTPETypesSetTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers_(1);
		b0.ComponentModifier("unique");
		b0._ComponentModifiers();
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeBagTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers();
		b0.SimpleName("SimpleTypesSimple");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("SimpleTypeBagTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers();
		b0.SimpleName("ImplicitTypesSimple");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllTPTTypesBagTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.ComponentModifiers();
		b0.SimpleName("IAllTypesTablePerType");
		b0._CompositeEntity();
		b0.CompositeEntity_();
		b0.EntityModifiers();
		b0.SimpleName("AllTPETypesBagTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.ComponentModifiers();
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._CompositeEntity();
		b0.MapEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DataDataMapTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.SimpleName("IntData");
		b0.SimpleName("StringData");
		b0._MapEntity();
		b0.MapEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DataDataMapTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.SimpleName("IntData");
		b0.SimpleName("StringData");
		b0._MapEntity();
		b0.MapEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DataSimpleMapTPE");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerEntity");
		b0._Types();
		b0.SimpleName("IntData");
		b0.SimpleName("SimpleTypesSimple");
		b0._MapEntity();
		b0.MapEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DataSimpleMapTPT");
		b0.Types_(2);
		b0.SimpleName("IAllTypesImplicit");
		b0.SimpleName("IAllTypesTablePerType");
		b0._Types();
		b0.SimpleName("IntData");
		b0.SimpleName("SimpleTypesSimple");
		b0._MapEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("BooleanData");
		b0.Types();
		b0.DataType("boolean");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ByteData");
		b0.Types();
		b0.DataType("byte");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("CharData");
		b0.Types();
		b0.DataType("char");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DoubleData");
		b0.Types();
		b0.DataType("double");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("FloatData");
		b0.Types();
		b0.DataType("float");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("IntData");
		b0.Types();
		b0.DataType("int");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("LongData");
		b0.Types();
		b0.DataType("long");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ShortData");
		b0.Types();
		b0.DataType("short");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("StringData");
		b0.Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DateData");
		b0.Types();
		b0.DataType("java.util.Date");
		b0._DataEntity();
		b0.EnumEntity_();
		b0.EntityModifiers();
		b0.SimpleName("EnumData");
		b0.Types();
		b0.EnumValues_(6);
		b0.EnumValue("zero");
		b0.EnumValue("one");
		b0.EnumValue("two");
		b0.EnumValue("three");
		b0.EnumValue("four");
		b0.EnumValue("five");
		b0._EnumValues();
		b0._EnumEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("BooleanDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("boolean");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ByteDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("byte");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("CharDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("char");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DoubleDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("double");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("FloatDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("float");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("IntDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("int");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("LongDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("long");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("ShortDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("short");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("StringDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("String");
		b0._DataEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		b0.SimpleName("DateDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.DataType("java.util.Date");
		b0._DataEntity();
		b0.EnumEntity_();
		b0.EntityModifiers();
		b0.SimpleName("EnumDataEmbedded");
		b0.Types_(1);
		b0.SimpleName("IDataEntity");
		b0._Types();
		b0.EnumValues_(6);
		b0.EnumValue("zero");
		b0.EnumValue("one");
		b0.EnumValue("two");
		b0.EnumValue("three");
		b0.EnumValue("four");
		b0.EnumValue("five");
		b0._EnumValues();
		b0._EnumEntity();
		b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.testorm");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/TestORM");
		b0._Model();
	}
}