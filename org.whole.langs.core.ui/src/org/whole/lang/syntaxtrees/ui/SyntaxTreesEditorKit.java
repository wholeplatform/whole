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
package org.whole.lang.syntaxtrees.ui;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesEntityDescriptorEnum;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesFeatureDescriptorEnum;
import org.whole.lang.syntaxtrees.reflect.SyntaxTreesLanguageKit;
import org.whole.lang.ui.editparts.DeclarationTextualEntityPart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
import org.whole.lang.ui.notations.dynamic.DynamicEditorKit;
import org.whole.lang.ui.notations.dynamic.editparts.DynamicPartFactory;
import org.whole.lang.ui.notations.styledtree.editparts.AdaptiveEntityPart;
import org.whole.lang.ui.notations.styledtree.editparts.ChildrenBranchesPart;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.FeatureStyling;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.INotationStyling;
import org.whole.lang.ui.notations.styledtree.styling.IStylingFactory;
import org.whole.lang.ui.notations.styledtree.styling.NotationStyling;
import org.whole.lang.ui.notations.tree.editparts.TreeRightPartFactory;

/**
 * @author Riccardo Solmi
 */
public class SyntaxTreesEditorKit extends DynamicEditorKit implements IStylingFactory {
	private static final long serialVersionUID = 1L;
	
	public boolean isAdaptive() {
		return true;
	}

	private INotationStyling notationStyling;
	public INotationStyling getNotationStyling() {
		return notationStyling;
	}

	public IEntityStyling createEntityStyling(IEntityPart contextPart, IEntity entity) {
		return new EntityStyling(getTypeIdentifier(entity),
				entity.wGetEntityDescriptor().equals(SyntaxTreesEntityDescriptorEnum.Rule) ?
						EntityKinds.COMPOSITE : EntityKinds.DATA);
	}

	public String getTypeIdentifier(IEntity entity) {
		try {
		return entity.wGet(SyntaxTreesFeatureDescriptorEnum.name).wStringValue();
		} catch (IllegalArgumentException e) {
			return "FIXME";
		}
	}

	public IEntity getParentEntity(IEntity entity) {
		IEntity parent = entity.wGetParent();
		return parent.wGetEntityDescriptor().equals(SyntaxTreesEntityDescriptorEnum.Nodes) ?
				parent.wGetParent() : parent;
	}
	public IEntityPart getParentPart(IEntityPart part) {
		IEntityPart parentPart = (IEntityPart) part.getParent();
		IEntity parent = parentPart.getModelEntity();
		return parent.wGetEntityDescriptor().equals(SyntaxTreesEntityDescriptorEnum.Nodes) ?
				(IEntityPart) parentPart.getParent() : parentPart;
	}

	public SyntaxTreesEditorKit() {
		super("Syntax Tree", 5);
		setCanApply(applyLanguage(SyntaxTreesLanguageKit.URI));

		notationStyling = new NotationStyling();

		//TODO ? add choose/when selectors
		notationStyling.addEntityStyling(new EntityStyling("parserRuleSpec", EntityKinds.SIMPLE,
				new FeatureStyling("ref", true, true),
				new FeatureStyling("colon", true, false),
				new FeatureStyling("expression", false, true),
				new FeatureStyling("semi", true, false),
				new FeatureStyling("exceptionGroup", false, true)));
		notationStyling.addEntityStyling(new EntityStyling("lexerRuleSpec", EntityKinds.SIMPLE,
				new FeatureStyling("ref", true, true),
				new FeatureStyling("colon", true, false),
				new FeatureStyling("expression", false, true),
				new FeatureStyling("semi", true, false)));

		DynamicPartFactory partFactory = getPartFactory();
		partFactory.setDefaultPartFactory(TreeRightPartFactory.instance());
		partFactory.chooseFactoryMethod(SyntaxTreesEntityDescriptorEnum.Rule)
				.when((pf, p, e) -> e.wGet(SyntaxTreesFeatureDescriptorEnum.name).wStringValue().equals("parserRuleSpec"),
						(pf, p, e) -> new AdaptiveEntityPart(this,
								SyntaxTreesFeatureDescriptorEnum.name, SyntaxTreesFeatureDescriptorEnum.children) )
				.when((pf, p, e) -> e.wGet(SyntaxTreesFeatureDescriptorEnum.name).wStringValue().equals("lexerRuleSpec"),
						(pf, p, e) -> new AdaptiveEntityPart(this,
								SyntaxTreesFeatureDescriptorEnum.name, SyntaxTreesFeatureDescriptorEnum.children) )
				.otherwise((pf, p, e) -> new AdaptiveEntityPart(this,
						SyntaxTreesFeatureDescriptorEnum.name, SyntaxTreesFeatureDescriptorEnum.children) );
		partFactory.putFactoryMethod(SyntaxTreesEntityDescriptorEnum.Nodes,
				(pf, p, e) -> new ChildrenBranchesPart() );
		partFactory.putFactoryMethod(SyntaxTreesEntityDescriptorEnum.Literal,
				(pf, p, e) -> new AdaptiveEntityPart(this,
						SyntaxTreesFeatureDescriptorEnum.name, SyntaxTreesFeatureDescriptorEnum.text) );
		partFactory.putFactoryMethod(SyntaxTreesEntityDescriptorEnum.Terminal,
				(pf, p, e) -> new AdaptiveEntityPart(this,
						SyntaxTreesFeatureDescriptorEnum.name, SyntaxTreesFeatureDescriptorEnum.text) );
		partFactory.putFactoryMethod(SyntaxTreesEntityDescriptorEnum.Name,
				(pf, p, e) -> new DeclarationTextualEntityPart() );
		partFactory.putFactoryMethod(SyntaxTreesEntityDescriptorEnum.Text,
				(pf, p, e) -> new LiteralTextualEntityPart() );

	}
}
