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
package org.whole.lang.ui.notations.styledtree.editparts;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.LiteralDataEntityPart;
import org.whole.lang.ui.editparts.LiteralTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.FeatureStyling;
import org.whole.lang.ui.notations.styledtree.styling.IEntityStyling;
import org.whole.lang.ui.notations.styledtree.styling.IFeatureStyling;
import org.whole.lang.ui.notations.styledtree.styling.INotationStyling;
import org.whole.lang.ui.notations.styledtree.styling.IStylingFactory;
import org.whole.lang.ui.notations.styledtree.styling.NotationStyling;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling.LayoutStyle;

/**
 * @author Riccardo Solmi
 */
public class StyledTreePartFactory implements IEditPartFactory, IStylingFactory {
	private static class SingletonHolder {
		private static final StyledTreePartFactory instance = new StyledTreePartFactory();
	}
	public static StyledTreePartFactory instance() {
		return SingletonHolder.instance;
	}

	public boolean isAdaptive() {
		return false;
	}

	protected INotationStyling notationStyling = new NotationStyling();
	public INotationStyling getNotationStyling() {
		return notationStyling;
	}

	public IEntityStyling createEntityStyling(IEntityPart contextPart, IEntity entity) {
		return createEntityStyling(contextPart, entity.wGetEntityDescriptor());
	}
	public static IEntityStyling createEntityStyling(IEntityPart contextPart, EntityDescriptor<?> ed) {
		EntityKinds kind = ed.getEntityKind();
		LayoutStyle layoutStyle = getLayoutStyle(ed);
		return new EntityStyling(ed.getURI(), kind, layoutStyle, getFeaturesStyling(
				(kind.isComposite() && layoutStyle.equals(LayoutStyle.COMPOSITE_TABLE) ? ed.getEntityDescriptor(0) : ed)
						.getEntityFeatureDescriptors()));
	}
	public static IFeatureStyling[] getFeaturesStyling(List<FeatureDescriptor> efDescriptors) {
		IFeatureStyling[] featuresStyling = new IFeatureStyling[efDescriptors.size()];
		int i = 0;
		for (FeatureDescriptor fd : efDescriptors)
			featuresStyling[i++] = new FeatureStyling(
					fd.getName(), !fd.getEntityDescriptor().getDataKind().isNotAData(), true, getAlignment(fd.getEntityDescriptor()));
		return featuresStyling;
	}
	public static Alignment getAlignment(EntityDescriptor<?> columnEntityDescriptor) {
		switch (columnEntityDescriptor.getDataKind()) {
		case BOOLEAN:
		case BYTE:
		case CHAR:
		case DOUBLE:
		case FLOAT:
		case INT:
		case LONG:
		case SHORT:
			return Alignment.TRAILING;
		default:
			return Alignment.LEADING;
		}
	}
	public static LayoutStyle getLayoutStyle(EntityDescriptor<?> ed) {
		EntityKinds kind = ed.getEntityKind();
		switch (kind) {
		case SIMPLE:
			return LayoutStyle.SIMPLE_TABLE;
		case COMPOSITE:
			EntityDescriptor<?> ced = ed.getEntityDescriptor(0);
			if (ced.isPolymorphic() || ced.getEntityKind().isComposite())
				return LayoutStyle.TREE;
			else
				return LayoutStyle.COMPOSITE_TABLE;
		default:
			return LayoutStyle.TREE;
		}
	}

	public String getTypeIdentifier(IEntity entity) {
		return entity.wGetEntityDescriptor().getURI();
	}

	public IEntity getParentEntity(IEntity entity) {
		return entity.wGetParent();
	}
	public IEntityPart getParentPart(IEntityPart part) {
		return (IEntityPart) part.getParent();
	}

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		IEntityPart contextPart = (IEntityPart) context;
		IEntity entity = (IEntity) modelEntity;
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();

		if (ed.equals(CommonsEntityDescriptorEnum.Resolver))
			return new PlaceHolderPart();
		else {
			IEntityStyling entityStyling = notationStyling.getEntityStyling(this, contextPart, entity);

			switch (ed.getEntityKind()) {
			case SIMPLE:
				return new SimpleEntityStyledTreePart(this, entityStyling);
			case COMPOSITE:
				return new CompositeEntityStyledTreePart(this, entityStyling);
			default:
			case DATA:
				//TODO test
				if (entity.wGetEntityDescriptor().getName().equals("SimpleName") &&
						entity.wGetParent().wGetEntityDescriptor().getName().equals("Feature"))
					entity.wGetEntityDescriptor();
				switch (notationStyling.getEmbeddingStyle(this, contextPart, entity)) {
				case TABLE_CELL:
					switch (ed.getDataKind()) {//TODO replace with styling features
					case STRING:
						return new LiteralTextualEntityPart();
					default:
						return new LiteralDataEntityPart();
					}
				case NONE:
				default:
					return new DataEntityStyledTreePart(this, entityStyling);
				}
			}
		}
	}
}
