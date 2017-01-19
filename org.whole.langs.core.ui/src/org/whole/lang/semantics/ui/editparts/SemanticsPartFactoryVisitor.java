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
package org.whole.lang.semantics.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.queries.ui.editparts.ChooseTablePart;
import org.whole.lang.semantics.model.AnyType;
import org.whole.lang.semantics.model.BindingOp;
import org.whole.lang.semantics.model.BindingsScope;
import org.whole.lang.semantics.model.ChooseTemplate;
import org.whole.lang.semantics.model.Configuration;
import org.whole.lang.semantics.model.ElseTemplate;
import org.whole.lang.semantics.model.EntityType;
import org.whole.lang.semantics.model.EnvType;
import org.whole.lang.semantics.model.EnvironmentType;
import org.whole.lang.semantics.model.EnvironmentVariable;
import org.whole.lang.semantics.model.ExecutionRule;
import org.whole.lang.semantics.model.ForTemplate;
import org.whole.lang.semantics.model.FunctionApplication;
import org.whole.lang.semantics.model.FunctionType;
import org.whole.lang.semantics.model.ISemanticsEntity;
import org.whole.lang.semantics.model.IfDefTemplate;
import org.whole.lang.semantics.model.IfTemplate;
import org.whole.lang.semantics.model.InferenceRule;
import org.whole.lang.semantics.model.InferenceRules;
import org.whole.lang.semantics.model.InlineTemplate;
import org.whole.lang.semantics.model.InputBinding;
import org.whole.lang.semantics.model.InputBindings;
import org.whole.lang.semantics.model.LanguageType;
import org.whole.lang.semantics.model.LegacyType;
import org.whole.lang.semantics.model.LocalBinding;
import org.whole.lang.semantics.model.LocalBindings;
import org.whole.lang.semantics.model.Name;
import org.whole.lang.semantics.model.Namespace;
import org.whole.lang.semantics.model.Num;
import org.whole.lang.semantics.model.OutputBinding;
import org.whole.lang.semantics.model.OutputBindings;
import org.whole.lang.semantics.model.Premises;
import org.whole.lang.semantics.model.ProductType;
import org.whole.lang.semantics.model.Rename;
import org.whole.lang.semantics.model.RenameGroup;
import org.whole.lang.semantics.model.RuleName;
import org.whole.lang.semantics.model.Rules;
import org.whole.lang.semantics.model.SemanticFunction;
import org.whole.lang.semantics.model.SemanticFunctions;
import org.whole.lang.semantics.model.SemanticTheory;
import org.whole.lang.semantics.model.SequenceType;
import org.whole.lang.semantics.model.StageChange;
import org.whole.lang.semantics.model.StructuredVariable;
import org.whole.lang.semantics.model.SubtypeType;
import org.whole.lang.semantics.model.SupertypeType;
import org.whole.lang.semantics.model.Transition;
import org.whole.lang.semantics.model.TypeCast;
import org.whole.lang.semantics.model.TypedVariable;
import org.whole.lang.semantics.model.URI;
import org.whole.lang.semantics.model.UnionType;
import org.whole.lang.semantics.model.Variable;
import org.whole.lang.semantics.model.VariableValue;
import org.whole.lang.semantics.model.Version;
import org.whole.lang.semantics.model.WhereTemplate;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.semantics.visitors.SemanticsIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.AbstractDataEntityPart;
import org.whole.lang.ui.editparts.AnyTypePart;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.ContentDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.EntityTypePart;
import org.whole.lang.ui.editparts.EnvTypePart;
import org.whole.lang.ui.editparts.FunctionNamePart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.LanguageTypePart;
import org.whole.lang.ui.editparts.LiteralDataEntityPart;
import org.whole.lang.ui.editparts.ModuleNameTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNamespaceTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.editparts.SmallContentTextualEntityPart;
import org.whole.lang.ui.editparts.SmallIdentifierTextualEntityPart;
import org.whole.lang.ui.editparts.VariableDataEntityPart;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class SemanticsPartFactoryVisitor extends SemanticsIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((ISemanticsEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(ISemanticsEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(SemanticTheory entity) {
		part = new SemanticTheoryPart();
	}

	@Override
	public void visit(SemanticFunctions entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}

	@Override
	public void visit(SemanticFunction entity) {
		part = new SemanticFunctionPart();
	}

	@Override
	public void visit(Rules entity) {
		part = new ChooseTablePart();
	}
	@Override
	public void visit(InferenceRules entity) {
		part = new InferenceRulesTablePart();
	}

	@Override
	public void visit(ExecutionRule entity) {
		part = new ExecutionRulePart();
	}
	@Override
	public void visit(InferenceRule entity) {
		part = new InferenceRulePart();
	}

	@Override
	public void visit(Premises entity) {
		part = new PremisesPart();
	}

	@Override
	public void visit(Transition entity) {
		part = new TransitionPart();
	}

	@Override
	public void visit(Configuration entity) {
		part = new ConfigurationPart();
	}

	@Override
	public void visit(BindingsScope entity) {
		part = new BindingsScopePart();
	}

	@Override
	public void visit(LocalBindings entity) {
		part = new BindingsTablePart();
	}

	@Override
	public void visit(LocalBinding entity) {
		part = new LocalBindingPart();
	}

	@Override
	public void visit(BindingOp entity) {
		part = new ContentDataEntityPart();
	}

	@Override
	public void visit(EnvironmentVariable entity) {
		part = new EnvironmentVariablePart();
	}

	@Override
	public void visit(TypeCast entity) {
		part = new TypeCastPart();
	}

	@Override
	public void visit(FunctionApplication entity) {
		part = new FunctionApplicationPart();
	}

	@Override
	public void visit(StageChange entity) {
		part = new AbstractDataEntityPart() {
			public IFigure createFigure() {
				return LabelFactory.createMonospaceSmall();
			}
		};
	}

	@Override
	public void visit(EnvironmentType entity) {
		part = new EnvironmentTypePart();
	}
	@Override
	public void visit(LegacyType entity) {
		part = new LiteralDataEntityPart();
	}
	
	@Override
	public void visit(EntityType entity) {
		part = new EntityTypePart();
	}
	
	@Override
	public void visit(AnyType entity) {
		part = new AnyTypePart();
	}

	@Override
	public void visit(EnvType entity) {
		part = new EnvTypePart();
	}

	@Override
	public void visit(LanguageType entity) {
		part = new LanguageTypePart();
	}

	@Override
	public void visit(UnionType entity) {
		part = new UnionTypePart();
	}

	@Override
	public void visit(FunctionType entity) {
		part = new FunctionTypePart();
	}

	@Override
	public void visit(ProductType entity) {
		part = new ProductTypePart();
	}

	@Override
	public void visit(SequenceType entity) {
		part = new SequenceTypePart();
	}

	@Override
	public void visit(SubtypeType entity) {
		part = new SubtypeTypePart();
	}
	@Override
	public void visit(SupertypeType entity) {
		part = new SupertypeTypePart();
	}

	@Override
	public void visit(TypedVariable entity) {
		part = new TypedVariablePart();
	}

	@Override
	public void visit(Variable entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(SemanticsEntityDescriptorEnum.StructuredVariable, parent) ||
					Matcher.match(SemanticsEntityDescriptorEnum.TypedVariable, parent) ||
					Matcher.match(SemanticsEntityDescriptorEnum.OutputBinding, parent)) {
				part = new VariableDataEntityPart();
				return;
			}
		}
		part = new VariablePart();
	}

	@Override
	public void visit(VariableValue entity) {
		part = new VariableValuePart();
	}

	@Override
	public void visit(Name entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(SemanticsEntityDescriptorEnum.FunctionApplication, parent)) {
				part = new FunctionNamePart();
				return;
			} else if (Matcher.match(SemanticsEntityDescriptorEnum.RuleName, parent) &&
					(parent.wGet(SemanticsFeatureDescriptorEnum.sup) == entity ||
							parent.wGet(SemanticsFeatureDescriptorEnum.sub) == entity)) {
				part = new SmallContentTextualEntityPart();
				return;
			} else if (Matcher.match(SemanticsEntityDescriptorEnum.SemanticTheory, parent)) {
				part = new ModuleNameTextualEntityPart();
				return;
			}
		}
		part = new ContentTextualEntityPart();
	}

	@Override
	public void visit(Num entity) {
		part = new SmallIdentifierTextualEntityPart();
	}

	@Override
	public void visit(StructuredVariable entity) {
		part = new StructuredVariablePart();
	}

	@Override
	public void visit(RenameGroup entity) {
		part = new CompositeColumnWithPlaceholderPart();
	}
	@Override
	public void visit(Rename entity) {
		part = new RenamePart();
	}

	@Override
	public void visit(RuleName entity) {
		part = new RuleNamePart();
	}

	@Override
	public void visit(OutputBindings entity) {
		part = new OutputBindingsTablePart();
	}
	@Override
	public void visit(OutputBinding entity) {
		part = new OutputBindingRowPart();
	}

	@Override
	public void visit(InputBindings entity) {
		part = new InputBindingsTablePart();
	}
	@Override
	public void visit(InputBinding entity) {
		part = new InputBindingRowPart();
	}

	@Override
	public void visit(InlineTemplate entity) {
		part = new InlineTemplatePart();
	};

	@Override
	public void visit(ChooseTemplate entity) {
		part = new ChooseTemplateTablePart();
	}

	@Override
	public void visit(WhereTemplate entity) {
		part = new WhereTemplatePart();
	}
	@Override
	public void visit(ForTemplate entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(SemanticsEntityDescriptorEnum.ChooseTemplate, parent)) {
					part = new ForTemplateRowPart();
					return;
			}
		}
		part = new ForTemplatePart();
	}
	@Override
	public void visit(IfTemplate entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(SemanticsEntityDescriptorEnum.ChooseTemplate, parent)) {
					part = new IfTemplateRowPart();
					return;
			}
		}
		part = new IfTemplatePart();		
	}
	@Override
	public void visit(IfDefTemplate entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(SemanticsEntityDescriptorEnum.ChooseTemplate, parent)) {
					part = new IfDefTemplateRowPart();
					return;
			}
		}
		part = new IfDefTemplatePart();
	};
	@Override
	public void visit(ElseTemplate entity) {
		part = new ElseTemplateRowPart();
	}

	public void visit(URI entity) {
		part = new ContentTextualEntityPart();
	}
	public void visit(Namespace entity) {
		part = new ModuleNamespaceTextualEntityPart();
	}
	public void visit(Version entity) {
		part = new ContentTextualEntityPart();
	}
}