/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.editors.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.templates.AbstractTemplateFactory;

public class PojoTextualEditor extends AbstractTemplateFactory<Editor> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.editors.builders.IEditorsBuilder b0 = (org.whole.lang.editors.builders.IEditorsBuilder) op.wGetBuilder(org.whole.lang.editors.reflect.EditorsLanguageKit.URI);
        b0.Editor_();
        b0.Identifier("PojoTextual");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.ModelComponent_();
        b0.Identifier("Pojo");
        b0._ModelComponent();
        b0.ViewComponent_();
        b0.ViewDeclarations_(11);
        b0.SimpleFigureDeclaration_();
        b0.Identifier("PojoModelFigure");
        b0.FoldableTextualFigure_();
        b0.TextualFigure_(2);
        b0.Row_(4);
        b0.ChildPlace();
        b0.KeywordToken("model");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0.Row_(2);
        b0.Indent();
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0.TextualFigure_(1);
        b0.Row_(4);
        b0.ChildPlace();
        b0.KeywordToken("model");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0._TextualFigure();
        b0._FoldableTextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("EnumDeclarationFigure");
        b0.FoldableTextualFigure_();
        b0.TextualFigure_(2);
        b0.Row_(4);
        b0.ChildPlace();
        b0.KeywordToken("enum");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0.Row_(2);
        b0.Indent();
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0.TextualFigure_(1);
        b0.Row_(4);
        b0.ChildPlace();
        b0.KeywordToken("enum");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0._TextualFigure();
        b0._FoldableTextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("AnnotationDeclarationFigure");
        b0.FoldableTextualFigure_();
        b0.TextualFigure_(2);
        b0.Row_(4);
        b0.ChildPlace();
        b0.KeywordToken("annotation");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0.Row_(2);
        b0.Indent();
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0.TextualFigure_(1);
        b0.Row_(4);
        b0.ChildPlace();
        b0.KeywordToken("annotation");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0._TextualFigure();
        b0._FoldableTextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("PojoDeclarationFigure");
        b0.FoldableTextualFigure_();
        b0.TextualFigure_(2);
        b0.Row_(6);
        b0.ChildPlace();
        b0.KeywordToken("pojo");
        b0.ChildPlace();
        b0.KeywordToken("extends");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0.Row_(2);
        b0.Indent();
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0.TextualFigure_(1);
        b0.Row_(6);
        b0.ChildPlace();
        b0.KeywordToken("pojo");
        b0.ChildPlace();
        b0.KeywordToken("extends");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0._TextualFigure();
        b0._FoldableTextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("SimplePropertyFigure");
        b0.TextualFigure_(1);
        b0.Row_(4);
        b0.ChildPlace();
        b0.KeywordToken("property");
        b0.ChildPlace();
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("ArrayTypeFigure");
        b0.TextualFigure_(1);
        b0.Row_(2);
        b0.ChildPlace();
        b0.ParenthesisToken("[]");
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("MapTypeFigure");
        b0.TextualFigure_(1);
        b0.Row_(6);
        b0.KeywordToken("map");
        b0.ParenthesisToken("<");
        b0.ChildPlace();
        b0.OperatorToken(",");
        b0.ChildPlace();
        b0.ParenthesisToken(">");
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("CollectionTypeFigure");
        b0.TextualFigure_(1);
        b0.Row_(4);
        b0.ChildPlace();
        b0.ParenthesisToken("<");
        b0.ChildPlace();
        b0.ParenthesisToken(">");
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("MarkerAnnotationFigure");
        b0.TextualFigure_(1);
        b0.Row_(2);
        b0.OperatorToken("@");
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("AnnotationFigure");
        b0.TextualFigure_(1);
        b0.Row_(5);
        b0.OperatorToken("@");
        b0.ChildPlace();
        b0.ParenthesisToken("(");
        b0.ChildPlace();
        b0.ParenthesisToken(")");
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("PropertyValuePairFigure");
        b0.TextualFigure_(1);
        b0.Row_(3);
        b0.ChildPlace();
        b0.OperatorToken("=");
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0._ViewDeclarations();
        b0._ViewComponent();
        b0.ControllerComponent_();
        b0.ControllerDeclarations_(13);
        b0.PartDeclaration_();
        b0.Identifier("PojoModelPart");
        b0.Identifier("PojoModel");
        b0.Identifier("PojoModelFigure");
        b0.EntityFeatures_(3);
        b0.Identifier("annotations");
        b0.Identifier("name");
        b0.Identifier("declarations");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("EnumDeclarationPart");
        b0.Identifier("EnumDeclaration");
        b0.Identifier("EnumDeclarationFigure");
        b0.EntityFeatures_(3);
        b0.Identifier("annotations");
        b0.Identifier("name");
        b0.Identifier("values");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("AnnotationDeclarationPart");
        b0.Identifier("AnnotationDeclaration");
        b0.Identifier("AnnotationDeclarationFigure");
        b0.EntityFeatures_(3);
        b0.Identifier("annotations");
        b0.Identifier("name");
        b0.Identifier("properties");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("PojoDeclarationPart");
        b0.Identifier("PojoDeclaration");
        b0.Identifier("PojoDeclarationFigure");
        b0.EntityFeatures_(4);
        b0.Identifier("annotations");
        b0.Identifier("name");
        b0.Identifier("types");
        b0.Identifier("properties");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("SimplePropertyPart");
        b0.Identifier("SimpleProperty");
        b0.Identifier("SimplePropertyFigure");
        b0.EntityFeatures_(3);
        b0.Identifier("annotations");
        b0.Identifier("type");
        b0.Identifier("name");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("ArrayTypePart");
        b0.Identifier("ArrayType");
        b0.Identifier("ArrayTypeFigure");
        b0.EntityFeatures_(1);
        b0.Identifier("elementType");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("MapTypePart");
        b0.Identifier("MapType");
        b0.Identifier("MapTypeFigure");
        b0.EntityFeatures_(2);
        b0.Identifier("keyType");
        b0.Identifier("valueType");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("CollectionTypePart");
        b0.Identifier("CollectionType");
        b0.Identifier("CollectionTypeFigure");
        b0.EntityFeatures_(2);
        b0.Identifier("collectionInterface");
        b0.Identifier("elementType");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("MarkerAnnotationPart");
        b0.Identifier("MarkerAnnotation");
        b0.Identifier("MarkerAnnotationFigure");
        b0.EntityFeatures_(1);
        b0.Identifier("name");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("SinglePropertyAnnotationPart");
        b0.Identifier("SinglePropertyAnnotation");
        b0.Identifier("AnnotationFigure");
        b0.EntityFeatures_(2);
        b0.Identifier("name");
        b0.Identifier("value");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("MultiplePropertiesAnnotationPart");
        b0.Identifier("MultiplePropertiesAnnotation");
        b0.Identifier("AnnotationFigure");
        b0.EntityFeatures_(2);
        b0.Identifier("name");
        b0.Identifier("propertyValuePairs");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("PropertyValuePairPart");
        b0.Identifier("PropertyValuePair");
        b0.Identifier("PropertyValuePairFigure");
        b0.EntityFeatures_(2);
        b0.Identifier("name");
        b0.Identifier("value");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.GenericPartDeclaration_();
        b0.GenericPartName("CompositeRow");
        b0.EntityNames_(3);
        b0.Identifier("Annotations");
        b0.Identifier("Names");
        b0.Identifier("ArrayData");
        b0._EntityNames();
        b0._GenericPartDeclaration();
        b0._ControllerDeclarations();
        b0._ControllerComponent();
        b0._Editor();
    }
}
