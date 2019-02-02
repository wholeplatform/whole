/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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

public class ECorePojo extends AbstractTemplateFactory {


    public void apply(IBuilderOperation op) {
        org.whole.lang.pojo.builders.IPojoBuilder b0 = (org.whole.lang.pojo.builders.IPojoBuilder) op.wGetBuilder(org.whole.lang.pojo.reflect.PojoLanguageKit.URI);
        b0.Library_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.Name("ECore");
        b0.LanguageURI("http://lang.whole.org/ECore");
        b0.Declarations_(16);
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EAnnotation");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EModelElement");
        b0._ReferenceTypes();
        b0.Properties_(3);
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("source");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EModelElement");
        b0.Name("eModelElement");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.MapType_();
        b0.PrimitiveType("String");
        b0.PrimitiveType("String");
        b0._MapType();
        b0.Name("details");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EAttribute");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EStructuralFeature");
        b0._ReferenceTypes();
        b0.Properties_(2);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EDataType");
        b0.Name("eAttributeType");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("id");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EClass");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EClassifier");
        b0._ReferenceTypes();
        b0.Properties_(14);
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EClass");
        b0._CollectionType();
        b0.Name("eSuperTypes");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("abstract");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("interface");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EAttribute");
        b0.Name("eIDAttribute");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EStructuralFeature");
        b0._CollectionType();
        b0.Name("eStructuralFeatures");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EOperation");
        b0._CollectionType();
        b0.Name("eOperations");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EAttribute");
        b0._CollectionType();
        b0.Name("eAttributes");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EReference");
        b0._CollectionType();
        b0.Name("eReferences");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EClass");
        b0._CollectionType();
        b0.Name("eAllSuperTypes");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EStructuralFeature");
        b0._CollectionType();
        b0.Name("eAllStructuralFeatures");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EOperation");
        b0._CollectionType();
        b0.Name("eAllOperations");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EAttribute");
        b0._CollectionType();
        b0.Name("eAllAttributes");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EReference");
        b0._CollectionType();
        b0.Name("eAllReferences");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EReference");
        b0._CollectionType();
        b0.Name("eAllContainments");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EClassifier");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("ENamedElement");
        b0._ReferenceTypes();
        b0.Properties_(4);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EPackage");
        b0.Name("ePackage");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("DATATYPE");
        b0._Annotations();
        b0.ReferenceType("Class");
        b0.Name("instanceClass");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("instanceClassName");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("DATATYPE");
        b0._Annotations();
        b0.ReferenceType("Object");
        b0.Name("defaultValue");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EDataType");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EClassifier");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("serializable");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EEnum");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EDataType");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EEnumLiteral");
        b0._CollectionType();
        b0.Name("eLiterals");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EEnumLiteral");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("ENamedElement");
        b0._ReferenceTypes();
        b0.Properties_(3);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EEnum");
        b0.Name("eEnum");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("literal");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("int");
        b0.Name("value");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EFactory");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EModelElement");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EPackage");
        b0.Name("ePackage");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EModelElement");
        b0.ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EAnnotation");
        b0._CollectionType();
        b0.Name("eAnnotations");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("ENamedElement");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EModelElement");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("name");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EOperation");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("ETypedElement");
        b0._ReferenceTypes();
        b0.Properties_(3);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EClass");
        b0.Name("eContainingClass");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EParameter");
        b0._CollectionType();
        b0.Name("eParameters");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EClassifier");
        b0._CollectionType();
        b0.Name("eExceptions");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EPackage");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("ENamedElement");
        b0._ReferenceTypes();
        b0.Properties_(5);
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("nsPrefix");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("nsURI");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EPackage");
        b0.Name("eSuperPackage");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EClassifier");
        b0._CollectionType();
        b0.Name("eClassifiers");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.CollectionType_();
        b0.CollectionInterface("List");
        b0.ReferenceType("EPackage");
        b0._CollectionType();
        b0.Name("eSubpackages");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EParameter");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("ETypedElement");
        b0._ReferenceTypes();
        b0.Properties_(1);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EOperation");
        b0.Name("eOperation");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EReference");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("EStructuralFeature");
        b0._ReferenceTypes();
        b0.Properties_(5);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EClass");
        b0.Name("eReferenceType");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EReference");
        b0.Name("eOpposite");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("container");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("containment");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("resolveProxies");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("EStructuralFeature");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("ETypedElement");
        b0._ReferenceTypes();
        b0.Properties_(9);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EClass");
        b0.Name("eContainingClass");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("int");
        b0.Name("featureID");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("changeable");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("derived");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("transient");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("unsettable");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("volatile");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b0.Annotations_(1);
        b0.Modifier("DATATYPE");
        b0._Annotations();
        b0.ReferenceType("Object");
        b0.Name("defaultValue");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("String");
        b0.Name("defaultValueLiteral");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0.PojoDeclaration_();
        b1.Resolver();
        b1.Resolver();
        b0.ReferenceType("ETypedElement");
        b0.ReferenceTypes_(1);
        b0.ReferenceType("ENamedElement");
        b0._ReferenceTypes();
        b0.Properties_(7);
        b0.Property_();
        b1.Resolver();
        b0.ReferenceType("EClassifier");
        b0.Name("eType");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("many");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("ordered");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("required");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("boolean");
        b0.Name("unique");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("int");
        b0.Name("lowerBound");
        b1.Resolver();
        b0._Property();
        b0.Property_();
        b1.Resolver();
        b0.PrimitiveType("int");
        b0.Name("upperBound");
        b1.Resolver();
        b0._Property();
        b0._Properties();
        b1.Resolver();
        b0._PojoDeclaration();
        b0._Declarations();
        b0._Library();
    }
}
