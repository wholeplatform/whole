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
package org.whole.lang.frames.ui.editparts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.whole.lang.features.ui.editparts.AttributeRightPart;
import org.whole.lang.features.ui.editparts.CardinalityPart;
import org.whole.lang.features.ui.editparts.CloneGroupRightPart;
import org.whole.lang.features.ui.editparts.FeatureReferencePart;
import org.whole.lang.features.ui.editparts.FeatureRightPart;
import org.whole.lang.features.ui.editparts.FeaturesPart;
import org.whole.lang.features.ui.editparts.SubfeaturesRightPart;
import org.whole.lang.features.ui.editparts.SubsetGroupRightPart;
import org.whole.lang.features.ui.editparts.VariableFeatureRightPart;
import org.whole.lang.frames.events.FramesChangeEventHandler;
import org.whole.lang.frames.model.Advices;
import org.whole.lang.frames.model.After;
import org.whole.lang.frames.model.Around;
import org.whole.lang.frames.model.Attribute;
import org.whole.lang.frames.model.Before;
import org.whole.lang.frames.model.Cardinality;
import org.whole.lang.frames.model.CloneGroup;
import org.whole.lang.frames.model.ConditionPoint;
import org.whole.lang.frames.model.Domain;
import org.whole.lang.frames.model.Empty;
import org.whole.lang.frames.model.EntityType;
import org.whole.lang.frames.model.Exclude;
import org.whole.lang.frames.model.Feature;
import org.whole.lang.frames.model.FeatureName;
import org.whole.lang.frames.model.FeatureReference;
import org.whole.lang.frames.model.FeatureRename;
import org.whole.lang.frames.model.Features;
import org.whole.lang.frames.model.Frame;
import org.whole.lang.frames.model.IFramesEntity;
import org.whole.lang.frames.model.IncludePoint;
import org.whole.lang.frames.model.InlineContent;
import org.whole.lang.frames.model.Into;
import org.whole.lang.frames.model.IterationPoint;
import org.whole.lang.frames.model.JoinPoint;
import org.whole.lang.frames.model.MutuallyExclude;
import org.whole.lang.frames.model.MutuallyRequire;
import org.whole.lang.frames.model.Name;
import org.whole.lang.frames.model.Namespace;
import org.whole.lang.frames.model.Pointcut;
import org.whole.lang.frames.model.Relations;
import org.whole.lang.frames.model.Require;
import org.whole.lang.frames.model.ReusePoint;
import org.whole.lang.frames.model.SelectionPoint;
import org.whole.lang.frames.model.SolitaryFeatures;
import org.whole.lang.frames.model.Subfeatures;
import org.whole.lang.frames.model.SubsetGroup;
import org.whole.lang.frames.model.URI;
import org.whole.lang.frames.model.VariableFeature;
import org.whole.lang.frames.model.VariableFeatures;
import org.whole.lang.frames.model.Variants;
import org.whole.lang.frames.model.Version;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.ui.figures.AdviceFigure;
import org.whole.lang.frames.visitors.FramesIdentityDefaultVisitor;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.ContentLighterDataEntityPartWithRoundBrackets;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.DeclarationTextualEntityPart;
import org.whole.lang.ui.editparts.EntityTypePart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IdentifierTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNameTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNamespaceTextualEntityPart;
import org.whole.lang.ui.figures.FigureConstants;
import org.whole.lang.ui.figures.RoundBracketsBorder;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class FramesPartFactoryVisitor extends FramesIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;

		//for adaptive entities
		if (!(modelEntity instanceof IFramesEntity))
			modelEntity = ((IEntity) modelEntity).wGetAdaptee(false);

		((IFramesEntity) modelEntity).accept(this);
		return part;
	}

	public void visit(IFramesEntity entity) {
		part = TablePartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(Name entity) {
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent)) {
			if (Matcher.match(FramesEntityDescriptorEnum.Frame, parent)) {
				part = new ModuleNameTextualEntityPart();
				return;
			}
		}
		super.visit(entity);
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

	protected FramesChangeEventHandler framesChangeEventHandler;

	@Override
	public void visit(Frame entity) {
		part = new FramePart();

		if (framesChangeEventHandler == null) {
			framesChangeEventHandler = new FramesChangeEventHandler(((IEntityPart) context).getViewer().getContext());
			entity.wGetModel().getCompoundModel().addChangeEventHandler(framesChangeEventHandler);
		}
	}


	@Override
	public void visit(Relations entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	
	@Override
	public void visit(Pointcut entity) {
		part = new PointcutPart();
	}


	@Override
	public void visit(JoinPoint entity) {
		part = new JoinPointPart();
	}

	@Override
	public void visit(ConditionPoint entity) {
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) &&
				Matcher.match(FramesEntityDescriptorEnum.Variants, parent))
			part = new ConditionPointRowPart();
		else
			part = new ConditionPointPart();
	}

	@Override
	public void visit(IterationPoint entity) {
		part = new IterationPointPart();
	}

	@Override
	public void visit(SelectionPoint entity) {
		part = new SelectionPointPart();
	}

	@Override
	public void visit(Variants entity) {
		part = new VariantsTablePart();
	}

	@Override
	public void visit(ReusePoint entity) {
		part = new ReusePointPart();
	}

	@Override
	public void visit(IncludePoint entity) {
		part = new IncludePointPart();
	}

	@Override
	public void visit(Advices entity) {
		part = new AdvicesPart();
	}

	@Override
	public void visit(Before entity) {
		part = new AdvicePart() {
			@Override
			protected IFigure createFigure() {
				return new AdviceFigure("before");
			}
		};
	}
	@Override
	public void visit(After entity) {
		part = new AdvicePart() {
			@Override
			protected IFigure createFigure() {
				return new AdviceFigure("after ");
			}
		};
	}
	@Override
	public void visit(Around entity) {
		part = new AdvicePart() {
			@Override
			protected IFigure createFigure() {
				return new AdviceFigure("around");
			}
		};
	}
	@Override
	public void visit(Into entity) {
		part = new AdvicePart() {
			@Override
			protected IFigure createFigure() {
				return new AdviceFigure("into  ");
			}
		};
	}

	@Override
	public void visit(Empty entity) {
		part = new EmptyPart();
	}

	@Override
	public void visit(InlineContent entity) {
		part = new InlineContentPart();
	}
	
	@Override
	public void visit(FeatureName entity) {
		IEntity parent = entity.wGetParent();
		if (EntityUtils.hasParent(entity)) {
			if (Matcher.match(FramesEntityDescriptorEnum.Feature, parent) ||
					Matcher.match(FramesEntityDescriptorEnum.FeatureRename, parent) ||
					Matcher.match(FramesEntityDescriptorEnum.FeatureReference, parent) ||
					Matcher.match(FramesEntityDescriptorEnum.Attribute, parent)) {
				part = new DeclarationTextualEntityPart();
				return;
			}
		}
		part = new IdentifierTextualEntityPart();
	}

	@Override
	public void visit(FeatureReference entity) {
		part = new FeatureReferencePart();
	}

	@Override
	public void visit(Feature entity) {
		part = new FeatureRightPart();
	}

	@Override
	public void visit(SubsetGroup entity) {
		part = new SubsetGroupRightPart();
	}

	@Override
	public void visit(CloneGroup entity) {
		part = new CloneGroupRightPart();
	}

	@Override
	public void visit(Features entity) {
		part = new FeaturesPart();
	}

	@Override
	public void visit(Subfeatures entity) {
		part = new SubfeaturesRightPart();
	}

	@Override
	public void visit(SolitaryFeatures entity) {
		part = new SubfeaturesRightPart();
	}

	@Override
	public void visit(VariableFeatures entity) {
		part = new SubfeaturesRightPart();
	}

	@Override
	public void visit(VariableFeature entity) {
		part = new VariableFeatureRightPart();
	}

	@Override
	public void visit(FeatureRename entity) {
		part = new FeatureRenamePart();
	}

	@Override
	public void visit(Attribute entity) {
		part = new AttributeRightPart();
	}

	@Override
	public void visit(Cardinality entity) {
		part = new CardinalityPart();
	}

	@Override
	public void visit(Domain entity) {
		part = new ContentLighterDataEntityPartWithRoundBrackets();
	}
	@Override
	public void visit(EntityType entity) {
		part = new EntityTypePart()	{
			public IFigure createFigure() {
				IFigure f = super.createFigure();
				f.setBorder(new RoundBracketsBorder() {
					@Override
					protected void setBracketsStyle(Graphics g) {
						g.setForegroundColor(FigureConstants.contentLighterColor);
					}
				});
				return f;
			}
		};
	}

	@Override
	public void visit(MutuallyRequire entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(MutuallyExclude entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Require entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Exclude entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
}
