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
package org.whole.lang.grammars.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.grammars.model.And;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.ByDelimiter;
import org.whole.lang.grammars.model.ByLines;
import org.whole.lang.grammars.model.BySize;
import org.whole.lang.grammars.model.Choose;
import org.whole.lang.grammars.model.Concatenate;
import org.whole.lang.grammars.model.CustomDataType;
import org.whole.lang.grammars.model.DataTerminal;
import org.whole.lang.grammars.model.DataType;
import org.whole.lang.grammars.model.Empty;
import org.whole.lang.grammars.model.Format;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.IGrammarsEntity;
import org.whole.lang.grammars.model.Indent;
import org.whole.lang.grammars.model.LanguageDescriptor;
import org.whole.lang.grammars.model.Literal;
import org.whole.lang.grammars.model.LiteralTerminal;
import org.whole.lang.grammars.model.Name;
import org.whole.lang.grammars.model.Namespace;
import org.whole.lang.grammars.model.NewLine;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Not;
import org.whole.lang.grammars.model.Optional;
import org.whole.lang.grammars.model.Or;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.model.RegExp;
import org.whole.lang.grammars.model.Repeat;
import org.whole.lang.grammars.model.Size;
import org.whole.lang.grammars.model.Space;
import org.whole.lang.grammars.model.Split;
import org.whole.lang.grammars.model.URI;
import org.whole.lang.grammars.model.Unbounded;
import org.whole.lang.grammars.model.Version;
import org.whole.lang.grammars.model.When;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.grammars.visitors.GrammarsIdentityDefaultVisitor;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.DeclarationTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IFragmentPart;
import org.whole.lang.ui.editparts.LanguageURINamespacePart;
import org.whole.lang.ui.editparts.LiteralDataEntityPart;
import org.whole.lang.ui.editparts.ModuleNameTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNamespaceTextualEntityPart;
import org.whole.lang.ui.notations.editparts.QuotedAsNeededStringDataEntityPart;
import org.whole.lang.ui.notations.editparts.QuotedAsNeededStringTextualEntityPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class GrammarsPartFactoryVisitor extends GrammarsIdentityDefaultVisitor implements
		IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IGrammarsEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		part = new org.whole.lang.ui.editparts.PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(IGrammarsEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(URI entity) {
		IEntity parent = entity.wGetParent();
		if (EntityUtils.hasParent(entity) && Matcher.match(GrammarsEntityDescriptorEnum.Grammar, parent) && parent.wGet(GrammarsFeatureDescriptorEnum.targetLanguage) == entity)
			part = new LanguageURINamespacePart();
		else
			part = new ContentTextualEntityPart();
	}
	@Override
	public void visit(Namespace entity) {
		part = new ModuleNamespaceTextualEntityPart();
	}
	@Override
	public void visit(Version entity) {
		part = new ContentTextualEntityPart();
	}

	@Override
	public void visit(LanguageDescriptor entity) {
		part = new LanguageDescriptorPart();
	}

	@Override
	public void visit(Productions entity) {
		part = new ProductionsPart();
	}

	@Override
	public void visit(Grammar entity) {
		part = new GrammarPart();
	}

	@Override
	public void visit(Production entity) {
		if (context instanceof ProductionsPart || context instanceof IFragmentPart)
			part = new ProductionPart();
		else
			part = new ProductionInlinePart();
	}

	@Override
	public void visit(DataTerminal entity) {
		part = new DataTerminalPart();
	}

	@Override
	public void visit(Empty entity) {
		part = new EmptyPart();
	}

	@Override
	public void visit(Space entity) {
		part = new SpacePart();
	}

	@Override
	public void visit(Indent entity) {
		part = new IndentPart();
	}

	@Override
	public void visit(NewLine entity) {
		part = new NewLinePart();
	}

	@Override
	public void visit(Optional entity) {
		part = new OptionalPart();
	}
	
	@Override
	public void visit(Repeat entity) {
		part = new RepeatPart();
	}

	@Override
	public void visit(Concatenate entity) {
		part = new ConcatenatePart();
	}

	@Override
	public void visit(Choose entity) {
		part = new ChoosePart();
	}

	@Override
	public void visit(When entity) {
		part = new WhenPart();
	}

	@Override
	public void visit(Split entity) {
		part = new SplitPart();
	}

	@Override
	public void visit(As entity) {
		part = new AsPart();
	}

	@Override
	public void visit(LiteralTerminal entity) {
		part = new LiteralTerminalPart();
	}

	@Override
	public void visit(NonTerminal entity) {
		Object parentEntity = context.getModel();
		if (parentEntity instanceof Production && entity == ((Production) parentEntity).getName())
			part = new DeclarationTextualEntityPart();
		else if (parentEntity instanceof Repeat && entity == ((Repeat) parentEntity).getSeparator())
			part = new ContentTextualEntityPart();
		else
			part = new NonTerminalPart();
	}

	@Override
	public void visit(Literal entity) {
		part = new QuotedAsNeededStringDataEntityPart();
	}

	@Override
	public void visit(Unbounded entity) {
		part = new UnboundedPart();
	}

	@Override
	public void visit(RegExp entity) {
		part = new QuotedAsNeededStringTextualEntityPart();
	}

	@Override
	public void visit(Format entity) {
		part = new QuotedAsNeededStringDataEntityPart();
	}

	@Override
	public void visit(Name entity) {
		IEntity parent = entity.wGetParent();
		if (Matcher.match(GrammarsEntityDescriptorEnum.Grammar, parent) ||
				Matcher.match(GrammarsEntityDescriptorEnum.LanguageDescriptor, parent))
			part = new ModuleNameTextualEntityPart();
		else
			part = new ContentTextualEntityPart();
	}

	@Override
	public void visit(DataType entity) {
		part = new LiteralDataEntityPart();
	}

	@Override
	public void visit(CustomDataType entity) {
		part = new ContentTextualEntityPart();
	}

	@Override
	public void visit(Size entity) {
		part = new ContentDataEntityPart();
	}

	@Override
	public void visit(ByDelimiter entity) {
		part = new ByDelimiterPart();
	}

	@Override
	public void visit(BySize entity) {
		part = new BySizePart();
	}

	@Override
	public void visit(ByLines entity) {
		part = new ByLinesPart();
	}

	@Override
	public void visit(And entity) {
		part = new AndPart();
	}

	@Override
	public void visit(Or entity) {
		part = new OrPart();
	}

	@Override
	public void visit(Not entity) {
		part = new NotPart();
	}
}