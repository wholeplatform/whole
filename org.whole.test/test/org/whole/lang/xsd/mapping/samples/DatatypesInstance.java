package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class DatatypesInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://samples.lang.whole.org/datatypes", true, null).getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("DataTypes"));
        b0.wEntity_(e1.valueOf("DataTypesList"), 36);
        b0.wEntity(e1.valueOf("XSBoolean"), true);
        b0.wEntity(e1.valueOf("XSBoolean"), false);
        b0.wEntity(e1.valueOf("XSByte"), (byte) 127);
        b0.wEntity(e1.valueOf("XSByte"), (byte) -128);
        b0.wEntity(e1.valueOf("XSShort"), (short) -32768);
        b0.wEntity(e1.valueOf("XSShort"), (short) 32767);
        b0.wEntity(e1.valueOf("XSInt"), -2147483648);
        b0.wEntity(e1.valueOf("XSInt"), 2147483647);
        b0.wEntity(e1.valueOf("XSLong"), -9223372036854775808l);
        b0.wEntity(e1.valueOf("XSLong"), 9223372036854775807l);
        b0.wEntity(e1.valueOf("XSFloat"), -1.0E8f);
        b0.wEntity(e1.valueOf("XSFloat"), 1.0E10f);
        b0.wEntity(e1.valueOf("XSFloat"), Float.NEGATIVE_INFINITY);
        b0.wEntity(e1.valueOf("XSFloat"), Float.POSITIVE_INFINITY);
        b0.wEntity(e1.valueOf("XSFloat"), Float.NaN);
        b0.wEntity(e1.valueOf("XSFloat"), 3.14f);
        b0.wEntity(e1.valueOf("XSFloat"), -10000.0f);
        b0.wEntity(e1.valueOf("XSFloat"), 1.26743237E15f);
        b0.wEntity(e1.valueOf("XSDouble"), -9.9999999E7);
        b0.wEntity(e1.valueOf("XSDouble"), 9.9999999E7);
        b0.wEntity(e1.valueOf("XSDouble"), Double.NaN);
        b0.wEntity(e1.valueOf("XSDouble"), Double.NEGATIVE_INFINITY);
        b0.wEntity(e1.valueOf("XSDouble"), Double.POSITIVE_INFINITY);
        b0.wEntity(e1.valueOf("XSDouble"), 3.14);
        b0.wEntity(e1.valueOf("XSDouble"), -10000.0);
        b0.wEntity(e1.valueOf("XSDouble"), 1.26743233E15);
        b0.wEntity(e1.valueOf("MyEnumeration"), "1000");
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "zxc  o pop 435zxc");
        b0.wEntity(e1.valueOf("XSDecimal"), "8347923570435095219358.73248923874");
        b0.wEntity(e1.valueOf("XSInteger"), "834792357043509521935873248923874");
        b0.wEntity(e1.valueOf("XSDate"), "1999-10-10");
        b0.wEntity(e1.valueOf("XSDateTime"), "1990-11-30T12:30:43Z");
        b0.wEntity(e1.valueOf("XSTime"), "12:30:43");
        b0.wEntity(e1.valueOf("XSGYearMonth"), "1990-11");
        b0.wEntity_(e1.valueOf("IntDataTypeSeq"));
        b0.wEntity(e1.valueOf("XSString"), "xxxxxxxxx");
        b0.wEntity(e1.valueOf("XSString"), "yyyyyyyyy");
        b0._wEntity(e1.valueOf("IntDataTypeSeq"));
        b0.wEntity(e1.valueOf("XSDuration"), "P5Y");
        b0._wEntity(e1.valueOf("DataTypesList"));
        b0._wEntity(e1.valueOf("DataTypes"));
    }
}
