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
package org.whole.lang.models.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.models.model.AnyType;
import org.whole.lang.models.model.ComponentModifier;
import org.whole.lang.models.model.ComponentModifiers;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.DataType;
import org.whole.lang.models.model.EntityModifier;
import org.whole.lang.models.model.EntityModifiers;
import org.whole.lang.models.model.EntityType;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValue;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifier;
import org.whole.lang.models.model.FeatureModifiers;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.IModelsEntity;
import org.whole.lang.models.model.MapEntity;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.Namespace;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.SubtypesOf;
import org.whole.lang.models.model.SupertypesOf;
import org.whole.lang.models.model.TypeAliasOf;
import org.whole.lang.models.model.TypeRelations;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.model.URI;
import org.whole.lang.models.model.Version;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.models.visitors.ModelsIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.AnyTypePart;
import org.whole.lang.ui.editparts.BarSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeRowPart;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.editparts.ContentLightDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.DeclarationTextualEntityPart;
import org.whole.lang.ui.editparts.EntityTypePart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNameTextualEntityPart;
import org.whole.lang.ui.editparts.ModuleNamespaceTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.notations.table.editparts.TablePartFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ModelsTabularPartFactoryVisitor extends ModelsIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IModelsEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IModelsEntity entity) {
		part = TablePartFactory.instance().createEditPart(context, entity);
	}

	protected boolean parentHasDifferentLanguage(IEntity entity) {
		return !EntityUtils.hasParent(entity) || !entity.wGetLanguageKit().equals(entity.wGetParent().wGetLanguageKit());
	}

	public void visit(DataType entity) {
		part = new LiteralTextualEntityPart();
	}

	public void visit(EnumValue entity) {
		part = new LiteralTextualEntityPart();
	}

	public void visit(Types entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.isAssignableAsIsFrom(ModelsEntityDescriptorEnum.ModelDeclaration, parent)) {
				part = new TypesPart();
				return;
			}
		}
		part = new CommaSeparatedCompositeFlowPart();
	}

	public void visit(TypeRelations entity) {
		part = new CompositeRowWithPlaceholderPart();
	}
	@Override
	public void visit(SupertypesOf entity) {
		part = new SupertypesOfPart();
	}
	@Override
	public void visit(SubtypesOf entity) {
		part = new SubtypesOfPart();
	}
	@Override
	public void visit(TypeAliasOf entity) {
		part = new TypeAliasOfPart();
	}
	@Override
	public void visit(EntityType entity) {
		part = new EntityTypePart();
	}
	@Override
	public void visit(AnyType entity) {
		part = new AnyTypePart();
	}

	public void visit(EntityModifier entity) {
		part = new ContentLightDataEntityPart();
	}

	public void visit(FeatureModifier entity) {
		part = new ContentLightDataEntityPart();
	}

	public void visit(ComponentModifier entity) {
		part = new ContentLightDataEntityPart();
	}

	public void visit(EnumValues entity) {
		part = new BarSeparatedCompositeFlowPart();
	}

	@Override
	public void visit(Model entity) {
		part = new ModelTablePart();
	}

	@Override
	public void visit(ModelDeclarations entity) {
		part = new ModelDeclarationsTablePart();
	}

	@Override
	public void visit(EntityModifiers entity) {
		part = new CompositeRowPart();
	}

	@Override
	public void visit(SimpleEntity entity) {
		if (parentHasDifferentLanguage(entity))
			super.visit(entity);
		else
			part = new SimpleEntityTablePart();
	}
	@Override
	public void visit(Features entity) {
		part = new FeaturesTablePart();
	}
	@Override
	public void visit(Feature entity) {
		if (parentHasDifferentLanguage(entity))
			super.visit(entity);
		else
			part = new FeatureRowPart();
	}
	@Override
	public void visit(FeatureModifiers entity) {
		part = new CompositeRowWithPlaceholderPart();
	}

	@Override
	public void visit(CompositeEntity entity) {
		if (parentHasDifferentLanguage(entity))
			super.visit(entity);
		else
			part = new CompositeEntityTablePart();
	}
	@Override
	public void visit(ComponentModifiers entity) {
		part = new CompositeRowWithPlaceholderPart();
	}

	@Override
	public void visit(MapEntity entity) {
		if (parentHasDifferentLanguage(entity))
			super.visit(entity);
		else
			part = new MapEntityTablePart();
	}

	@Override
	public void visit(DataEntity entity) {
		if (parentHasDifferentLanguage(entity))
			super.visit(entity);
		else
			part = new DataEntityTablePart();
	}

	@Override
	public void visit(EnumEntity entity) {
		if (parentHasDifferentLanguage(entity))
			super.visit(entity);
		else
			part = new EnumEntityTablePart();
	}

	public void visit(SimpleName entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			int parentOrd = parent.wGetEntityDescriptor().getOrdinal();
			switch (parentOrd) {
			case ModelsEntityDescriptorEnum.CompositeEntity_ord:
			case ModelsEntityDescriptorEnum.MapEntity_ord:
				if (!parent.wContains(ModelsFeatureDescriptorEnum.name) ||
						parent.wGet(ModelsFeatureDescriptorEnum.name) != entity)
					break;
			case ModelsEntityDescriptorEnum.SimpleEntity_ord:
			case ModelsEntityDescriptorEnum.EnumEntity_ord:
			case ModelsEntityDescriptorEnum.DataEntity_ord:
				part = new DeclarationTextualEntityPart();
				return;
			case ModelsEntityDescriptorEnum.Model_ord:
				part = new ModuleNameTextualEntityPart();
				return;
			}
		}
		part = new ContentTextualEntityPart();
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
