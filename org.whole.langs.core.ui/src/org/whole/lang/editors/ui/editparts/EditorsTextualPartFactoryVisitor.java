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
package org.whole.lang.editors.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.editors.model.ChildPlace;
import org.whole.lang.editors.model.ControllerComponent;
import org.whole.lang.editors.model.DelimiterToken;
import org.whole.lang.editors.model.Editor;
import org.whole.lang.editors.model.EntityFeatures;
import org.whole.lang.editors.model.EntityNames;
import org.whole.lang.editors.model.FoldableTextualFigure;
import org.whole.lang.editors.model.FoldingToggle;
import org.whole.lang.editors.model.GenericPartDeclaration;
import org.whole.lang.editors.model.GenericPartName;
import org.whole.lang.editors.model.IEditorsEntity;
import org.whole.lang.editors.model.Indent;
import org.whole.lang.editors.model.JavaPartDeclaration;
import org.whole.lang.editors.model.KeywordToken;
import org.whole.lang.editors.model.LiteralToken;
import org.whole.lang.editors.model.ModelComponent;
import org.whole.lang.editors.model.OperatorToken;
import org.whole.lang.editors.model.ParenthesisToken;
import org.whole.lang.editors.model.PartDeclaration;
import org.whole.lang.editors.model.Row;
import org.whole.lang.editors.model.SimpleFigureDeclaration;
import org.whole.lang.editors.model.TextualFigure;
import org.whole.lang.editors.model.ViewComponent;
import org.whole.lang.editors.visitors.EditorsIdentityDefaultVisitor;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.CompositeRowPart;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.KeywordDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.ContentLightDataEntityPart;
import org.whole.lang.ui.editparts.ContentLighterDataEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/**
 * @author Riccardo Solmi
 */
public class EditorsTextualPartFactoryVisitor extends EditorsIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IEditorsEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IEditorsEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(Editor entity) {
		part = new EditorPart();
	}

	public void visit(ModelComponent entity) {
		part = new ModelComponentPart();
	}

	public void visit(ControllerComponent entity) {
		part = new ControllerComponentPart();
	}

	public void visit(PartDeclaration entity) {
		part = new PartDeclarationPart();
	}

	public void visit(JavaPartDeclaration entity) {
		part = new JavaPartDeclarationPart();
	}

	public void visit(GenericPartName entity) {
		part = new KeywordDataEntityPart();
	}

	public void visit(GenericPartDeclaration entity) {
		part = new GenericPartDeclarationPart();
	}

	public void visit(EntityFeatures entity) {
		part = new CompositeRowPart();
	}

	public void visit(ViewComponent entity) {
		part = new ViewComponentPart();
	}

	public void visit(SimpleFigureDeclaration entity) {
		part = new SimpleFigureDeclarationPart();
	}

	public void visit(FoldableTextualFigure entity) {
		part = new FoldableTextualPart();
	}

	public void visit(TextualFigure entity) {
		part = new TextualFigurePart();
	}

	public void visit(Row entity) {
		part = new CompositeRowPart();
	}

	public void visit(KeywordToken entity) {
		part = new KeywordTokenPart();
	}

	public void visit(LiteralToken entity) {
		part = new ContentTextualEntityPart();
	}

	public void visit(OperatorToken entity) {
		part = new ContentLightDataEntityPart();
	}

	public void visit(DelimiterToken entity) {
		part = new LiteralTextualEntityPart();
	}

	public void visit(ParenthesisToken entity) {
		part = new ContentLighterDataEntityPart();
	}

	public void visit(ChildPlace entity) {
		part = new ChildPlacePart();
	}

	public void visit(Indent entity) {
		part = new IndentPart();
	}
	
	public void visit(FoldingToggle entity) {
		part = new FoldingTogglePart();
	}
	
	public void visit(EntityNames entity) {
		part = new CompositeRowPart();
	}

}
