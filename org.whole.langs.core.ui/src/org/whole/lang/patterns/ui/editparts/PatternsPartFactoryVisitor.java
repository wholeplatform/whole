/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.patterns.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Arguments;
import org.whole.lang.patterns.model.Binding;
import org.whole.lang.patterns.model.BooleanValue;
import org.whole.lang.patterns.model.Choice;
import org.whole.lang.patterns.model.ConditionPoint;
import org.whole.lang.patterns.model.Cut;
import org.whole.lang.patterns.model.Data;
import org.whole.lang.patterns.model.DataType;
import org.whole.lang.patterns.model.Declarations;
import org.whole.lang.patterns.model.DerivationPoint;
import org.whole.lang.patterns.model.EnumValue;
import org.whole.lang.patterns.model.EnumValues;
import org.whole.lang.patterns.model.Enumeration;
import org.whole.lang.patterns.model.FunctionDeclaration;
import org.whole.lang.patterns.model.FunctionPoint;
import org.whole.lang.patterns.model.FunctionStep;
import org.whole.lang.patterns.model.GoalDeclaration;
import org.whole.lang.patterns.model.GoalStep;
import org.whole.lang.patterns.model.IPatternsEntity;
import org.whole.lang.patterns.model.InlinePoint;
import org.whole.lang.patterns.model.Insert;
import org.whole.lang.patterns.model.InsertionPoint;
import org.whole.lang.patterns.model.IterationPoint;
import org.whole.lang.patterns.model.JoinPoint;
import org.whole.lang.patterns.model.JoinPointDeclaration;
import org.whole.lang.patterns.model.JoinPointStep;
import org.whole.lang.patterns.model.Library;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.model.Namespace;
import org.whole.lang.patterns.model.OuterDefinitionStep;
import org.whole.lang.patterns.model.Pattern;
import org.whole.lang.patterns.model.PatternApplication;
import org.whole.lang.patterns.model.PatternInstance;
import org.whole.lang.patterns.model.PatternJoinPointStep;
import org.whole.lang.patterns.model.PatternLanguage;
import org.whole.lang.patterns.model.PatternTypeTest;
import org.whole.lang.patterns.model.Patterns;
import org.whole.lang.patterns.model.Placement;
import org.whole.lang.patterns.model.PointcutDeclaration;
import org.whole.lang.patterns.model.PointcutStep;
import org.whole.lang.patterns.model.Repetition;
import org.whole.lang.patterns.model.ResultPoint;
import org.whole.lang.patterns.model.ResultTypes;
import org.whole.lang.patterns.model.ScopePoint;
import org.whole.lang.patterns.model.SelectionPoint;
import org.whole.lang.patterns.model.SequencePoint;
import org.whole.lang.patterns.model.Slot;
import org.whole.lang.patterns.model.SlotStep;
import org.whole.lang.patterns.model.SlotsDefined;
import org.whole.lang.patterns.model.TemplatePoint;
import org.whole.lang.patterns.model.Types;
import org.whole.lang.patterns.model.URI;
import org.whole.lang.patterns.model.VariableDeclaration;
import org.whole.lang.patterns.model.VariablePoint;
import org.whole.lang.patterns.model.Variant;
import org.whole.lang.patterns.model.VariantSelectionPoint;
import org.whole.lang.patterns.model.VariantSelector;
import org.whole.lang.patterns.model.Variants;
import org.whole.lang.patterns.model.Version;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.PatternsIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.ContentLightDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.DeclarationTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IdentifierTextualEntityPart;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNameTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNamespaceTextualEntityPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;
import org.whole.lang.util.EntityUtils;

/**
 *  @author  Riccardo Solmi
 */
public class PatternsPartFactoryVisitor extends PatternsIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((IPatternsEntity) modelEntity).accept(this);
        return part;
    }

    public void visit(IPatternsEntity entity) {
        part = TablePartFactory.instance().createEditPart(context, entity);
    }

    @Override
    public void visit(Library entity) {
        part = new LibraryPart();
    }

    @Override
    public void visit(PatternLanguage entity) {
        part = new PatternLanguagePart();
    }

    @Override
    public void visit(Patterns entity) {
        part = new PatternsPart();
    }

    @Override
    public void visit(Pattern entity) {
        part = new PatternPart();
    }

    @Override
    public void visit(PatternApplication entity) {
        part = new PatternApplicationPart();
    }

    @Override
    public void visit(PatternInstance entity) {
        part = new PatternInstancePart();
    }

    @Override
    public void visit(Arguments entity) {
        part = new ArgumentsPart();
    }

    @Override
    public void visit(Binding entity) {
        part = new BindingPart();
    }

    @Override
    public void visit(VariablePoint entity) {
        part = new VariablePointPart();
    }

    @Override
    public void visit(FunctionPoint entity) {
        part = new FunctionPointPart();
    }

    @Override
    public void visit(Slot entity) {
        part = new SlotPart();
    }
    
    @Override
    public void visit(BooleanValue entity) {
    	part = new ContentLightDataEntityPart();
    }

    @Override
    public void visit(ResultPoint entity) {
        part = new ResultPointPart();
    }

    @Override
    public void visit(JoinPoint entity) {
        part = new JoinPointPart();
    }

    @Override
    public void visit(InsertionPoint entity) {
        part = new InsertionPointPart();
    }

    @Override
    public void visit(ScopePoint entity) {
        part = new ScopePointPart();
    }

    @Override
    public void visit(TemplatePoint entity) {
        part = new TemplatePointPart();
    }

    @Override
    public void visit(DerivationPoint entity) {
        part = new DerivationPointPart();
    }

    @Override
    public void visit(SelectionPoint entity) {
        part = new SelectionPointPart();
    }

    @Override
    public void visit(ConditionPoint entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(PatternsEntityDescriptorEnum.SelectionPoint, parent)) {
					part = new ConditionPointRowPart();
					return;
			}
		}
		part = new ConditionPointPart();
    }

    @Override
    public void visit(IterationPoint entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(PatternsEntityDescriptorEnum.SelectionPoint, parent)) {
					part = new IterationPointRowPart();
					return;
			}
		}
		part = new IterationPointPart();
    }

    @Override
    public void visit(SequencePoint entity) {
        part = new SequencePointPart();
    }

    @Override
    public void visit(InlinePoint entity) {
        part = new InlinePointPart();
    }

    @Override
    public void visit(VariantSelectionPoint entity) {
    	part = new VariantSelectionPointPart();
    }

    @Override
    public void visit(Variants entity) {
    	part = new VariantsPart();
    }

    @Override
    public void visit(Variant entity) {
    	part = new VariantPart();
    }

    @Override
    public void visit(VariantSelector entity) {
    	part = new VariantSelectorPart();
    }

    @Override
    public void visit(Declarations entity) {
        part = new DeclarationsPart();
    }

    @Override
    public void visit(FunctionDeclaration entity) {
        part = new FunctionDeclarationPart();
    }

    @Override
    public void visit(GoalDeclaration entity) {
        part = new GoalDeclarationPart();
    }

    @Override
    public void visit(PointcutDeclaration entity) {
        part = new PointcutDeclarationPart();
    }

    @Override
    public void visit(JoinPointDeclaration entity) {
        part = new JoinPointDeclarationPart();
    }

    @Override
    public void visit(VariableDeclaration entity) {
        part = new VariableDeclarationPart();
    }

    @Override
    public void visit(Types entity) {
        part = new CommaSeparatedCompositeFlowPart();
    }

    @Override
    public void visit(ResultTypes entity) {
        super.visit(entity);
        //part = new ResultTypesPart();
    }

    @Override
    public void visit(Repetition entity) {
        part = new RepetitionPart();
    }

    @Override
    public void visit(Choice entity) {
        part = new ChoicePart();
    }

    @Override
    public void visit(Enumeration entity) {
        part = new EnumerationPart();
    }

    @Override
    public void visit(EnumValues entity) {
        part = new EnumValuesPart();
    }

    @Override
    public void visit(EnumValue entity) {
        super.visit(entity);
        //part = new EnumValuePart();
    }

    @Override
    public void visit(Data entity) {
    	part = new DataPart();
    }

    @Override
    public void visit(DataType entity) {
    	part = new LiteralTextualEntityPart();
    }

    @Override
    public void visit(Name entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			int parentOrd = parent.wGetEntityDescriptor().getOrdinal();
			switch (parentOrd) {
			case PatternsEntityDescriptorEnum.Pattern_ord:
			case PatternsEntityDescriptorEnum.Repetition_ord:
			case PatternsEntityDescriptorEnum.Choice_ord:
			case PatternsEntityDescriptorEnum.Enumeration_ord:
			case PatternsEntityDescriptorEnum.Data_ord:
			case PatternsEntityDescriptorEnum.PatternApplication_ord:
			case PatternsEntityDescriptorEnum.PatternInstance_ord:
			case PatternsEntityDescriptorEnum.FunctionDeclaration_ord:
			case PatternsEntityDescriptorEnum.FunctionPoint_ord:
				part = new DeclarationTextualEntityPart();
				return;
			case PatternsEntityDescriptorEnum.PointcutDeclaration_ord:
				part = new PointcutStepPart();
				return;
			case PatternsEntityDescriptorEnum.GoalDeclaration_ord:
				part = new GoalStepPart();
				return;
			case PatternsEntityDescriptorEnum.VariablePoint_ord:
			case PatternsEntityDescriptorEnum.VariableDeclaration_ord:
			case PatternsEntityDescriptorEnum.VariantSelectionPoint_ord:
			case PatternsEntityDescriptorEnum.Variant_ord:
				part = new IdentifierTextualEntityPart();
				return;
			case PatternsEntityDescriptorEnum.JoinPointDeclaration_ord:
				part = new JoinPointStepPart();
				return;
			case PatternsEntityDescriptorEnum.VariantSelector_ord:
				part = new VariabilityNamePart();
				return;
			case PatternsEntityDescriptorEnum.JoinPoint_ord:
				part = new ContentTextualEntityPart();
				return;
			case PatternsEntityDescriptorEnum.PatternLanguage_ord:
			case PatternsEntityDescriptorEnum.Library_ord:
				part = new ModuleNameTextualEntityPart();
				return;
			case PatternsEntityDescriptorEnum.EnumValue_ord:
				part = new LiteralTextualEntityPart();
				return;
			case PatternsEntityDescriptorEnum.Binding_ord:
			case PatternsEntityDescriptorEnum.Slot_ord:
			case PatternsEntityDescriptorEnum.InsertionPoint_ord:
				part = new ContentTextualEntityPart();
				return;
			}
		}
		part = new ContentTextualEntityPart();
    }

    @Override
    public void visit(PatternJoinPointStep entity) {
        super.visit(entity);
        //part = new PatternJoinPointStepPart();
    }

    @Override
    public void visit(JoinPointStep entity) {
    	part = new JoinPointStepPart();
    }

    @Override
    public void visit(PointcutStep entity) {
    	part = new PointcutStepPart();
    }

    @Override
    public void visit(GoalStep entity) {
    	part = new GoalStepPart();
    }

    @Override
    public void visit(FunctionStep entity) {
    	part = new FunctionStepPart();
    }

    @Override
    public void visit(SlotStep entity) {
    	part = new SlotStepPart();
    }

    @Override
    public void visit(OuterDefinitionStep entity) {
    	// TODO Auto-generated method stub
    	super.visit(entity);
    }

    @Override
    public void visit(Cut entity) {
        part = new CutPart();
    }

    @Override
    public void visit(Insert entity) {
        part = new InsertPart();
    }

    @Override
    public void visit(Placement entity) {
    	part = new PlacementPart();
    }

    @Override
    public void visit(SlotsDefined entity) {
        part = new SlotsDefinedPart();
    }

    @Override
    public void visit(PatternTypeTest entity) {
    	part = new PatternTypeTestPart();
    }

    @Override
    public void visit(URI entity) {
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
}
