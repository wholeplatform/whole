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
package org.whole.lang.editors.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.templates.AbstractTemplateFactory;

public class TemplatesTextualEditor extends AbstractTemplateFactory<Editor> {

    public void apply(IBuilderOperation op){
        org.whole.lang.editors.builders.IEditorsBuilder b0 = (org.whole.lang.editors.builders.IEditorsBuilder) op.wGetBuilder(org.whole.lang.editors.reflect.EditorsLanguageKit.URI);
        b0.Editor_();
        b0.Identifier("TemplatesTextual");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.ModelComponent_();
        b0.Identifier("Templates");
        b0._ModelComponent();
        b0.ViewComponent_();
        b0.ViewDeclarations_(3);
        b0.SimpleFigureDeclaration_();
        b0.Identifier("TemplateManagerFigure");
        b0.FoldableTextualFigure_();
        b0.TextualFigure_(2);
        b0.Row_(3);
        b0.KeywordToken("templates");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0.Row_(2);
        b0.Indent();
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0.TextualFigure_(1);
        b0.Row_(3);
        b0.KeywordToken("templates");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0._TextualFigure();
        b0._FoldableTextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("TemplateFactoryFigure");
        b0.FoldableTextualFigure_();
        b0.TextualFigure_(2);
        b0.Row_(5);
        b0.KeywordToken("template");
        b0.ChildPlace();
        b0.KeywordToken("for");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0.Row_(2);
        b0.Indent();
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0.TextualFigure_(1);
        b0.Row_(5);
        b0.KeywordToken("template");
        b0.ChildPlace();
        b0.KeywordToken("for");
        b0.ChildPlace();
        b0.FoldingToggle();
        b0._Row();
        b0._TextualFigure();
        b0._FoldableTextualFigure();
        b0._SimpleFigureDeclaration();
        b0.SimpleFigureDeclaration_();
        b0.Identifier("QualifiedNameFigure");
        b0.TextualFigure_(1);
        b0.Row_(3);
        b0.ChildPlace();
        b0.OperatorToken(".");
        b0.ChildPlace();
        b0._Row();
        b0._TextualFigure();
        b0._SimpleFigureDeclaration();
        b0._ViewDeclarations();
        b0._ViewComponent();
        b0.ControllerComponent_();
        b0.ControllerDeclarations_(4);
        b0.PartDeclaration_();
        b0.Identifier("TemplateManagerPart");
        b0.Identifier("TemplateManager");
        b0.Identifier("TemplateManagerFigure");
        b0.EntityFeatures_(2);
        b0.Identifier("name");
        b0.Identifier("templates");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("TemplateFactoryPart");
        b0.Identifier("TemplateFactory");
        b0.Identifier("TemplateFactoryFigure");
        b0.EntityFeatures_(3);
        b0.Identifier("name");
        b0.Identifier("forNames");
        b0.Identifier("template");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0.GenericPartDeclaration_();
        b0.GenericPartName("CompositeColumn");
        b0.EntityNames_(1);
        b0.Identifier("Templates");
        b0._EntityNames();
        b0._GenericPartDeclaration();
        b0.PartDeclaration_();
        b0.Identifier("QualifiedNamePart");
        b0.Identifier("QualifiedName");
        b0.Identifier("QualifiedNameFigure");
        b0.EntityFeatures_(2);
        b0.Identifier("qualifier");
        b0.Identifier("name");
        b0._EntityFeatures();
        b0._PartDeclaration();
        b0._ControllerDeclarations();
        b0._ControllerComponent();
        b0._Editor();
    }
}
