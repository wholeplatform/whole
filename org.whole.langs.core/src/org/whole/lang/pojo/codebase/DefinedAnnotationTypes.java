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
package org.whole.lang.pojo.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class DefinedAnnotationTypes extends AbstractTemplateFactory {


    public void apply(IBuilderOperation op) {
        org.whole.lang.pojo.builders.IPojoBuilder b0 = (org.whole.lang.pojo.builders.IPojoBuilder) op.wGetBuilder(org.whole.lang.pojo.reflect.PojoLanguageKit.URI);
        b0.Library_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.Name("DefinedAnnotations");
        b0.LanguageURI("http://lang.whole.org/DefinedAnnotations");
        b0.Declarations_(17);
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Deprecated");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Documented");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("SuppressWarnings");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Target");
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("ElementType");
        b0.Name("value");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b0._AnnotationDeclaration();
        b0.EnumDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("ElementType");
        b0.Names_(3);
        b0.Name("enum");
        b0.Name("pojo");
        b0.Name("property");
        b0._Names();
        b0._EnumDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Retention");
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("RetentionPolicy");
        b0.Name("value");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b0._AnnotationDeclaration();
        b0.EnumDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("RetentionPolicy");
        b0.Names_(3);
        b0.Name("source");
        b0.Name("class");
        b0.Name("runtime");
        b0._Names();
        b0._EnumDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Abstract");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Derived");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Final");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Id");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Optional");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Reference");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Shared");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("Transient");
        b0.Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("TypeRelations");
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.ArrayType_();
        b0.ReferenceType("Name");
        b0._ArrayType();
        b0.Name("types");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b0._AnnotationDeclaration();
        b0.AnnotationDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("JavaDoc");
        b0.Properties_(3);
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("description");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("license");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("author");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b0._AnnotationDeclaration();
        b0._Declarations();
        b0._Library();
    }
}
