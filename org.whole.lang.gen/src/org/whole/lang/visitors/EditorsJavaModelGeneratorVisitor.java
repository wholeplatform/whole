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
package org.whole.lang.visitors;

import static org.whole.gen.lang.ClassNames.CompositeColumnPartName;
import static org.whole.gen.lang.ClassNames.CompositeRowPartName;
import static org.whole.gen.lang.ClassNames.EmptyOptionalPartName;
import static org.whole.gen.lang.ClassNames.GrammarRuleFigureName;
import static org.whole.gen.lang.ClassNames.GrammarRuleFoldableFigureName;
import static org.whole.gen.lang.ClassNames.PlaceHolderPartName;
import static org.whole.gen.lang.ClassNames.SimpleFoldablePartName;
import static org.whole.gen.lang.ClassNames.SimplePartName;

import org.whole.gen.lang.LanguageGenerator;
import org.whole.gen.lang.ui.editparts.PartBuilder;
import org.whole.gen.lang.ui.figures.FigureBuilder;
import org.whole.gen.lang.visitors.PartFactoryVisitorBuilder;
import org.whole.lang.editors.model.ChildPlace;
import org.whole.lang.editors.model.ControllerComponent;
import org.whole.lang.editors.model.ControllerDeclaration;
import org.whole.lang.editors.model.ControllerDeclarations;
import org.whole.lang.editors.model.DelimiterToken;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.editors.model.EntityFeatures;
import org.whole.lang.editors.model.EntityName;
import org.whole.lang.editors.model.EntityNames;
import org.whole.lang.editors.model.FoldableTextualFigure;
import org.whole.lang.editors.model.FoldingToggle;
import org.whole.lang.editors.model.GenericPartDeclaration;
import org.whole.lang.editors.model.GenericPartName;
import org.whole.lang.editors.model.GenericPartNameEnum;
import org.whole.lang.editors.model.Identifier;
import org.whole.lang.editors.model.IdentifierToken;
import org.whole.lang.editors.model.Indent;
import org.whole.lang.editors.model.JavaPartDeclaration;
import org.whole.lang.editors.model.KeywordToken;
import org.whole.lang.editors.model.LiteralToken;
import org.whole.lang.editors.model.ModelComponent;
import org.whole.lang.editors.model.OperatorToken;
import org.whole.lang.editors.model.ParenthesisToken;
import org.whole.lang.editors.model.PartDeclaration;
import org.whole.lang.editors.model.Row;
import org.whole.lang.editors.model.RowElement;
import org.whole.lang.editors.model.SimpleFigureDeclaration;
import org.whole.lang.editors.model.TextualFigure;
import org.whole.lang.editors.model.ViewComponent;
import org.whole.lang.editors.model.ViewDeclaration;
import org.whole.lang.editors.model.ViewDeclarations;
import org.whole.lang.editors.visitors.EditorsIdentityVisitor;
import org.whole.lang.operations.JavaCompilerOperation;

/**
 * @author Riccardo Solmi
 */
public class EditorsJavaModelGeneratorVisitor extends EditorsIdentityVisitor {
	private LanguageGenerator wgen;
	private FigureBuilder figureBuilder;
	private PartBuilder partBuilder;
	private PartFactoryVisitorBuilder partFactoryVisitorBuilder;
	

	public void visit(Editor editor) {
		String editorName = editor.getEditorName().wStringValue();
		name = null;
		editor.getSuperEditorName().accept(this);
		String superEditorName = name;

		modelName = editorName;
		editor.getModelComponent().accept(this);

		wgen = (LanguageGenerator) ((JavaCompilerOperation) getOperation()).getGenerator();
		wgen.setPackagePrefix(wgen.getBasePackagePrefix()+"."+modelName.toLowerCase());
		wgen.setModelName(modelName);
		wgen.setEditorName(editorName);

		wgen.editorKitBuilder();
		partFactoryVisitorBuilder = wgen.addPartFactoryVisitorBuilder(superEditorName);

		editor.getViewComponent().accept(this);
		editor.getControllerComponent().accept(this);
	}

	String modelName;
	public void visit(ModelComponent entity) {
		entity.getModelName().accept(this);
		modelName = name;
		
	}

	public void visit(ViewComponent view) {
		view.getDeclarations().accept(this);
	}

	public void visit(ViewDeclarations entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((ViewDeclaration) entity.wGet(i)).accept(this);
	}

	public void visit(SimpleFigureDeclaration view) {
		figureBuilder = wgen.newFigureBuilder(view.getName().wStringValue());

		view.getFigure().accept(this);
	}

	public void visit(FoldableTextualFigure entity) {
		entity.getExpandedFigure().accept(this);
		figureBuilder.collapsedLayout();
		entity.getCollapsedFigure().accept(this);
		figureBuilder.expandedLayout();

		figureBuilder.setSuperclass(GrammarRuleFoldableFigureName);
	}

	public void visit(TextualFigure entity) {
		figureBuilder.setSuperclass(GrammarRuleFigureName);

		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				figureBuilder.nextRow();
			((Row) entity.wGet(i)).accept(this);
		}
	}

	public void visit(Row entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((RowElement) entity.wGet(i)).accept(this);
	}

	public void visit(ChildPlace place) {
		figureBuilder.addChildPlace();
	}
	public void visit(Indent token) {
		figureBuilder.addIndent();
	}
	public void visit(FoldingToggle token) {
		figureBuilder.addFoldingToggle();
	}

	public void visit(KeywordToken token) {
		figureBuilder.addToken("Keyword", token.getValue());
	}
	public void visit(LiteralToken token) {
		figureBuilder.addToken("Literal", token.getValue());
	}
	public void visit(IdentifierToken token) {
		figureBuilder.addToken("Identifier", token.getValue());
	}
	public void visit(OperatorToken token) {
		figureBuilder.addToken("Operator", token.getValue());
	}
	public void visit(DelimiterToken token) {
		figureBuilder.addToken("Delimiter", token.getValue());
	}
	public void visit(ParenthesisToken token) {
		figureBuilder.addToken("Parenthesis", token.getValue());
	}

	public void visit(ControllerComponent controller) {
		controller.getDeclarations().accept(this);
	}

	public void visit(ControllerDeclarations entity) {
		for (int i = 0; i < entity.wSize(); i++)
			((ControllerDeclaration) entity.wGet(i)).accept(this);
	}

	String partName;
	String entityName;
	public void visit(PartDeclaration part) {
		partName = part.getPartName().wStringValue();
		entityName = part.getEntityName().wStringValue();
		String figureName = part.getFigureName().wStringValue();
		
		partBuilder = wgen.newPartBuilder(
				partName, entityName, figureName);
		
		partFactoryVisitorBuilder.addPartFactoryVisitMethod(entityName, partName);

		part.getEntityFeatures().accept(this);
	}

	public void visit(EntityFeatures entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			String featureName = entity.wGet(i).wStringValue();
			partBuilder.addChildrenFeature("reference", featureName);
		}
		
		partBuilder.endChildrenFeatures();
	}

	public void visit(JavaPartDeclaration part) {
		part.getPartName().accept(this);
		partName = name;
		part.getEntityNames().accept(this);	
	}

	public void visit(GenericPartDeclaration part) {
		part.getPartName().accept(this);
		part.getEntityNames().accept(this);	
	}

	public void visit(EntityNames entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			((EntityName) entity.wGet(i)).accept(this);
			partFactoryVisitorBuilder.addPartFactoryVisitMethod(entityName = name, partName);
		}
	}

	String name;
	public void visit(Identifier entity) {
		name = entity.getValue();
	}

	public void visit(GenericPartName entity) {
		switch (entity.getValue().getOrdinal()) {
		case GenericPartNameEnum.CompositeColumn_ord:
			partName = CompositeColumnPartName;
			break;
		case GenericPartNameEnum.CompositeRow_ord:
			partName = CompositeRowPartName;
			break;

		case GenericPartNameEnum.ConstructorColumn_ord:
			partName = SimplePartName;//FIXME
			break;
		case GenericPartNameEnum.ConstructorRow_ord:
			partName = SimplePartName;//FIXME
			break;
		case GenericPartNameEnum.FoldableConstructor_ord:
			partName = SimpleFoldablePartName;
			break;

		case GenericPartNameEnum.Resolver_ord:
			partName = PlaceHolderPartName;
			break;
		case GenericPartNameEnum.OptionalResolver_ord:
			partName = EmptyOptionalPartName;
			break;

			//FIXME
		case GenericPartNameEnum.LiteralData_ord:
			partName = CompositeRowPartName;
			break;
		case GenericPartNameEnum.KeywordData_ord:
			partName = CompositeRowPartName;
			break;
		case GenericPartNameEnum.IdentifierData_ord:
			partName = CompositeRowPartName;
			break;
		case GenericPartNameEnum.OperatorData_ord:
			partName = CompositeRowPartName;
			break;
		case GenericPartNameEnum.DelimiterData_ord:
			partName = CompositeRowPartName;
			break;
		case GenericPartNameEnum.ParenthesisData_ord:
			partName = CompositeRowPartName;
			break;
		}
	}
}
