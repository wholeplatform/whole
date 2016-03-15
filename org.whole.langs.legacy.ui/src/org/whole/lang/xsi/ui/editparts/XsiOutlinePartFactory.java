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
package org.whole.lang.xsi.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.notations.outline.editparts.DefaultOutlinePartFactory;
import org.whole.lang.ui.notations.outline.editparts.OutlinePartFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xsd.mapping.util.MappingStrategyUtils;
import org.whole.lang.xsi.ui.figures.UnknownLabel;

/**
 * @author Enrico Persiani
 */
public class XsiOutlinePartFactory implements IEditPartFactory {
	protected EditPart part, context;
	protected boolean hideOptionals;

	public XsiOutlinePartFactory() {
		this(false);
	}
	public XsiOutlinePartFactory(boolean hideOptionals) {
		this.hideOptionals = hideOptionals;
	}

	public EditPart createEditPart(EditPart context, Object model) {
		this.context = context;
		createPart((IEntity) model);
		return part;
	}

	protected void createPart(IEntity entity) {
		IEntity parent = entity.wGetParent();
		boolean isRoot = EntityUtils.isFragment(parent);
		if (MappingStrategyUtils.hasElementNCName(entity))
			createElementPart(entity, isRoot);
		else if (MappingStrategyUtils.hasAttributeNCName(entity))
			createAttributePart(entity, isRoot);
		else if (!parent.wGetLanguageKit().equals(entity.wGetLanguageKit()))
			createUnknownPart(entity, isRoot);
		else
			createDefaultPart(entity, isRoot);
	}

	protected void createElementPart(IEntity entity, boolean isRoot) {
		switch (entity.wGetEntityKind()) {
		case SIMPLE:
			part = new XsiSimpleElementPart(hideOptionals, isRoot);
			break;
		case COMPOSITE:
			part = new XsiCompositeElementPart(isRoot);
			break;
		case DATA:
			part = new XsiDataElementPart(isRoot);
			break;
		default:
			createDefaultPart(entity, isRoot);
			break;
		}
	}

	protected void createAttributePart(IEntity entity, boolean isRoot) {
		switch (entity.wGetEntityKind()) {
		case DATA:
			part = new XsiDataAttributePart();
			break;
		case COMPOSITE:
			part = new XsiCompositeAttributePart();
			break;
		default:
			createDefaultPart(entity, isRoot);
			break;
		}
	}

	protected void createUnknownPart(IEntity entity, boolean isRoot) {
		switch (entity.wGetEntityKind()) {
		case DATA:
			part = new XsiDataElementPart(isRoot) {
				protected EntityLabel createLabel() {
					return new UnknownLabel();
				};
			};
			break;
		case COMPOSITE:
			part = new XsiCompositeElementPart(isRoot) {
				protected EntityLabel createLabel() {
					return new UnknownLabel();
				};
			};
			break;
		case SIMPLE:
			part = new XsiSimpleElementPart(false, isRoot) {
				protected EntityLabel createLabel() {
					return new UnknownLabel();
				};
			};
			break;
		default:
			part = OutlinePartFactory.instance().createEditPart(context, entity);
		}
	}

	protected void createDefaultPart(IEntity entity, boolean isRoot) {
		switch (entity.wGetEntityKind()) {
		case DATA:
			part = new XsiDataContentPart();
			break;
		case COMPOSITE:
			part = DefaultOutlinePartFactory.instance().createEditPart(context, entity);
			break;
		case SIMPLE:
			part = new XsiSimpleStructuralPart();
			break;
		default:
			part = OutlinePartFactory.instance().createEditPart(context, entity);
		}
	}
}
