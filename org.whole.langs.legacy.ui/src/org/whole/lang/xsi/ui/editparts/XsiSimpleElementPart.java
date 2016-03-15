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

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.EditPart;
import org.whole.lang.events.IChangeEventHandler;
import org.whole.lang.events.IdentityChangeEventHandler;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.mapping.util.MappingStrategyUtils;
import org.whole.lang.xsi.ui.figures.XsiSimpleElementNodeFigure;

/** 
 * @author Enrico Persiani
 */
public class XsiSimpleElementPart extends AbstractContentPanePart {
	protected boolean hideOptionals;
	protected String tagName;
	protected boolean isRoot;

	public XsiSimpleElementPart(boolean hideOptionals, boolean isRoot) {
		this(hideOptionals, null, isRoot);
	}
	public XsiSimpleElementPart(boolean hideOptionals, String tagName, boolean isRoot) {
		this.hideOptionals = hideOptionals;
		this.tagName = tagName;
		this.isRoot = isRoot;
	}
	public XsiSimpleElementPart() {
		this(false, false);
	}

	@Override
	protected IFigure createFigure() {
		IEntityFigure figure = new XsiSimpleElementNodeFigure(hasContents(), createLabel(), getAttributes().size(), getContents().size());
		if (isRoot)
			figure.setBorder(new MarginBorder(4, 8, 2, 4));
		return figure;
	}

	protected EntityLabel createLabel() {
		if (tagName == null)
			tagName = MappingStrategyUtils.getElementNCName(getModelEntity());
		EntityLabel label = LabelFactory.createContent(tagName);
		label.setIcon(NotationImages.XML_TAG16);
		return label;
	}

	protected boolean hasContents() {
		int contentsSize = getContents().size();
		if (contentsSize == 0)
			return false;
		else if (contentsSize > 1)
			return true;
		else {
			IEntity content = getContents().get(0);
			return !EntityUtils.isData(content) ||
					!DataTypeUtils.getAsPresentationString(content).equals("");
		}
	}

	@Override
	protected List<IEntity> getModelSpecificChildren() {
		List<IEntity> children = new ArrayList<IEntity>();
		children.addAll(getAttributes());
		children.addAll(getContents());
		return children;
	}

	protected List<IEntity> attributes;
	protected List<IEntity> getAttributes() {
		if (attributes == null)
			createFeatureLists();
		return attributes;
	}

	protected List<IEntity> contents;
	protected List<IEntity> getContents() {
		if (contents == null)
			createFeatureLists();
		return contents;
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		createFeatureLists();
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	protected void refreshVisuals() {
		XsiSimpleElementNodeFigure figure = (XsiSimpleElementNodeFigure) getFigure();
		List<IEntity> children = getModelChildren();
		for (int i=0, size=children.size(); i<size; i++) {
			IEntity child = children.get(i);
			figure.setContentPaneVisible(i, !hideOptionals || isVisibleChild(child));
		}
	}
	protected boolean isVisibleChild(IEntity child) {
		return (!(EntityUtils.isResolver(child) && EntityUtils.isOptional(child)) &&
				!(EntityUtils.isComposite(child) && child.wIsEmpty()));
	}

	protected IChangeEventHandler eventHandler;
	@SuppressWarnings("serial")
	protected IChangeEventHandler getRefreshChangeEventHandler() {
		if (eventHandler == null)
			eventHandler = new IdentityChangeEventHandler() {
				public void notifyAdded(IEntity source, FeatureDescriptor featureDesc, int index, IEntity newValue) {
					refresh();
				}
				public void notifyRemoved(IEntity source, FeatureDescriptor featureDesc, int index, IEntity oldValue) {
					refresh();
				}
				private void refresh() {
					getViewer().getControl().getDisplay().asyncExec(new Runnable() {
						public void run() {
							refreshVisuals();
						}
					});
				}
		};
		return eventHandler;
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		super.addChildVisual(childEditPart, index);
		IEntity child = ((IEntityPart) childEditPart).getModelEntity();
		if (EntityUtils.isComposite(child))
			child.wAddChangeEventHandler(getRefreshChangeEventHandler());
	}
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		super.removeChildVisual(childEditPart);
		IEntity child = ((IEntityPart) childEditPart).getModelEntity();
		if (EntityUtils.isComposite(child))
			child.wRemoveChangeEventHandler(getRefreshChangeEventHandler());
	}

	protected void createFeatureLists() {
		attributes = new ArrayList<IEntity>();
		contents = new ArrayList<IEntity>();

		IEntity entity = getModelEntity();

		IEntityIterator<IEntity> i = IteratorFactory.childIterator();
		i.reset(entity);
		for (IEntity child : i) {
			IMappingStrategy strategy = MappingStrategyUtils.getMappingStrategy(child);

			if (showAsAttribute(strategy, child))
				attributes.add(child);
			else if (showAsContent(strategy, child))
				contents.add(child);
		}
	}

	protected boolean showAsAttribute(IMappingStrategy strategy, IEntity child) {
		return strategy.isAttributeMapping(child);
	}
	protected boolean showAsContent(IMappingStrategy strategy, IEntity child) {
		return !showAsAttribute(strategy, child);
	}
}
