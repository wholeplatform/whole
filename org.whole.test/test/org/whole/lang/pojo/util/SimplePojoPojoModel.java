package org.whole.lang.pojo.util;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class SimplePojoPojoModel extends AbstractTemplateFactory {


    public void apply(IBuilderOperation op) {
        org.whole.lang.pojo.builders.IPojoBuilder b0 = (org.whole.lang.pojo.builders.IPojoBuilder) op.wGetBuilder(org.whole.lang.pojo.reflect.PojoLanguageKit.URI);
        b0.Library_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.Name("SimplePojo");
        b0.LanguageURI("http://lang.whole.org/SimplePojo");
        b0.Declarations_(6);
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.SimplePojo");
        b0.ReferenceTypes();
        b0.Properties_(15);
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("READ_ONLY");
        b0._Annotations();
        b0.PrimitiveType("boolean");
        b0.Name("fBoolean");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("READ_ONLY");
        b0._Annotations();
        b0.PrimitiveType("byte");
        b0.Name("fByte");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("char");
        b0.Name("fChar");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("double");
        b0.Name("fDouble");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("float");
        b0.Name("fFloat");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("int");
        b0.Name("fInt");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("long");
        b0.Name("fLong");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("short");
        b0.Name("fShort");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("fString");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.SimplePojo");
        b0.Name("leftPojo");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.SimplePojo");
        b0.Name("rightPojo");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("java.util.regex.Pattern");
        b0.Name("pattern");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.AbstractPojo1");
        b0.Name("abstractPojo");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("FIELD_ONLY");
        b0._Annotations();
        b0.ReferenceType("org.whole.lang.pojo.util.EnumPojo");
        b0.Name("enumPojo");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("FIELD_ONLY");
        b0._Annotations();
        b0.ArrayType_();
        b0.CollectionType_();
        b0.CollectionInterface("Set");
        b0.ReferenceType("java.util.regex.Pattern");
        b0._CollectionType();
        b0._ArrayType();
        b0.Name("fSet");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b0.Constructors_(4);
        b0.Constructor_();
        b0.Parameters_(3);
        b0.Parameter_();
        b1.Resolver();
        b1.Resolver();
        b0.Name("fByte");
        b1.Resolver();
        b0._Parameter();
        b0.Parameter_();
        b1.Resolver();
        b1.Resolver();
        b0.Name("fBoolean");
        b1.Resolver();
        b0._Parameter();
        b0.Parameter_();
        b1.Resolver();
        b1.Resolver();
        b0.Name("fDouble");
        b1.Resolver();
        b0._Parameter();
        b0._Parameters();
        b0._Constructor();
        b0.Constructor_();
        b0.Parameters_(2);
        b0.Parameter_();
        b1.Resolver();
        b1.Resolver();
        b0.Name("fByte");
        b1.Resolver();
        b0._Parameter();
        b0.Parameter_();
        b1.Resolver();
        b1.Resolver();
        b0.Name("fBoolean");
        b1.Resolver();
        b0._Parameter();
        b0._Parameters();
        b0._Constructor();
        b0.Constructor_();
        b0.Parameters_(1);
        b0.Parameter_();
        b1.Resolver();
        b1.Resolver();
        b0.Name("fBoolean");
        b1.Resolver();
        b0._Parameter();
        b0._Parameters();
        b0._Constructor();
        b0.Constructor_();
        b0.Parameters();
        b0._Constructor();
        b0._Constructors();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b0.Annotations_(1);
        b0.Modifier("ABSTRACT");
        b0._Annotations();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.AbstractPojo1");
        b0.ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("java.util.regex.Pattern");
        b0.Name("pattern");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b0.Annotations_(1);
        b0.Modifier("ABSTRACT");
        b0._Annotations();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.AbstractPojo2");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("org.whole.lang.pojo.util.AbstractPojo1");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("FIELD_ONLY");
        b0._Annotations();
        b0.PrimitiveType("boolean");
        b0.Name("valid");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b0.Annotations();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.ConcretePojo1");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("org.whole.lang.pojo.util.AbstractPojo1");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("name");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b0.Constructors_(1);
        b0.Constructor_();
        b0.Parameters();
        b0._Constructor();
        b0._Constructors();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b0.Annotations();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.ConcretePojo2");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("org.whole.lang.pojo.util.AbstractPojo2");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("FIELD_ONLY");
        b0._Annotations();
        b0.PrimitiveType("int");
        b0.Name("number");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b0.Constructors_(1);
        b0.Constructor_();
        b0.Parameters();
        b0._Constructor();
        b0._Constructors();
        b0._PojoDeclaration();
        b0.EnumDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("org.whole.lang.pojo.util.EnumPojo");
        b0.Names_(3);
        b0.Name("VALUE1");
        b0.Name("VALUE2");
        b0.Name("VALUE3");
        b0._Names();
        b0._EnumDeclaration();
        b0._Declarations();
        b0._Library();
    }
}
