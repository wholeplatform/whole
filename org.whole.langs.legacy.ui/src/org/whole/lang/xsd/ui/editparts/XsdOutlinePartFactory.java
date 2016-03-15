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
package org.whole.lang.xsd.ui.editparts;

import java.beans.PropertyChangeEvent;

import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.xsi.ui.editparts.XsiOutlinePartFactory;
import org.whole.lang.xsi.ui.editparts.XsiSimpleElementPart;

/**
 * @author Enrico Persiani
 */
public class XsdOutlinePartFactory extends XsiOutlinePartFactory {
	public XsdOutlinePartFactory() {
	}
	public XsdOutlinePartFactory(boolean hideOptionals) {
		super(hideOptionals);
	}

	@Override
	protected void createElementPart(IEntity modelEntity, boolean isRoot) {
		if (EntityUtils.isSimple(modelEntity))
			part = new XsdSimpleElementPart(hideOptionals, isRoot);
		else
			super.createElementPart(modelEntity, isRoot);
	}

	@Override
	protected void createDefaultPart(IEntity modelEntity, boolean isRoot) {
		switch (modelEntity.wGetEntityDescriptor().getOrdinal()) {
		case XsdEntityDescriptorEnum.AttributeUseOrGroups_ord:
			part = new CompositeColumnWithPlaceholderPart() {
				@SuppressWarnings("unchecked")
				@Override
				protected void propertyChangeUI(PropertyChangeEvent evt) {
					IEntity parent = getModelEntity().wGetParent();
					if (!EntityUtils.isNull(parent))
						ModelObserver.getObserver(parent, getViewer().getEditPartRegistry()).refresh();
					super.propertyChangeUI(evt);
				}
			};
			break;

		case XsdEntityDescriptorEnum.NamespaceDecls_ord:
			part = new CompositeRowWithPlaceholderPart() {
				@SuppressWarnings("unchecked")
				@Override
				protected void propertyChangeUI(PropertyChangeEvent evt) {
					IEntity parent = getModelEntity().wGetParent();
					if (!EntityUtils.isNull(parent))
						ModelObserver.getObserver(parent, getViewer().getEditPartRegistry()).refresh();
					super.propertyChangeUI(evt);
				}
			};
			break;

		case XsdEntityDescriptorEnum.NamespaceDecl_ord:
			part = new NamespaceDeclPart();
			break;

		case XsdEntityDescriptorEnum.DeclaredContent_ord:
			part = new DeclaredContentPart(hideOptionals);
			break;

		case XsdEntityDescriptorEnum.ElementRef_ord:
			part = new XsiSimpleElementPart(hideOptionals, "element", isRoot);
			break;

		case XsdEntityDescriptorEnum.AttributeUseRef_ord:
			part = new XsiSimpleElementPart(hideOptionals, "attribute", isRoot);
			break;

		case XsdEntityDescriptorEnum.AttributeGroupRef_ord:
			part = new XsiSimpleElementPart(hideOptionals, "attributeGroup", isRoot);
			break;

		case XsdEntityDescriptorEnum.ModelGroupRef_ord:
			part = new XsiSimpleElementPart(hideOptionals, "group", isRoot);
			break;

		case XsdEntityDescriptorEnum.Unbounded_ord:
			part = new UnboundedPart();
			break;

		case XsdEntityDescriptorEnum.Attributes_ord:
			part = new CompositeRowWithPlaceholderPart();
			break;

		default:
			super.createDefaultPart(modelEntity, isRoot);
		}
	}
}
