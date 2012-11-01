/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.templates;

import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class PaletteBuilder implements IPaletteBuilder {
	protected PaletteContainer paletteContainer;

	public PaletteBuilder() {
		this(new PaletteRoot());
		//TODO add toolsGroup
	}
	public PaletteBuilder(PaletteContainer paletteContainer) {
		this.paletteContainer = paletteContainer;
	}
	
	public PaletteRoot getResult() {
		return (PaletteRoot) paletteContainer;
	}

	public void Group_(String label) {
		PaletteGroup group = new PaletteGroup(label);
		group.setId(label);

		paletteContainer.add(group);
		paletteContainer = group;
	}
	public void Group_(String label, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge) {
		Group_(label);
		
		paletteContainer.setDescription(shortDesc);
		paletteContainer.setSmallIcon(iconSmall);
		paletteContainer.setLargeIcon(iconLarge);
	}
	public void _Group() {
		paletteContainer = paletteContainer.getParent();
	}

	protected int gefInitialState(int initialState) {
		final int[] states = {
				PaletteDrawer.INITIAL_STATE_OPEN,
				PaletteDrawer.INITIAL_STATE_CLOSED,
				PaletteDrawer.INITIAL_STATE_PINNED_OPEN
		};
		return states[initialState];
	}
	public void Drawer_(String label) {
		Drawer_(label, IPaletteBuilder.INITIAL_STATE_OPEN);
	}
	public void Drawer_(String label, int initialState) {
		PaletteDrawer drawer = new PaletteDrawer(label);
		drawer.setId(label);
		drawer.setInitialState(gefInitialState(initialState));
//		drawer.setVisible(false);

		paletteContainer.add(drawer);
		paletteContainer = drawer;
	}
	public void Drawer_(String label, int initialState, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge) {
		Drawer_(label, initialState);

		paletteContainer.setDescription(shortDesc);
		paletteContainer.setSmallIcon(iconSmall);
		paletteContainer.setLargeIcon(iconLarge);
	}
	public void _Drawer() {
		paletteContainer = paletteContainer.getParent();
	}

	public void Stack_() {
		Stack_(null, null, null);
	}
	public void Stack_(String name, String desc, ImageDescriptor icon) {
		PaletteStack stack = new PaletteStack(name, desc, icon);
		
		paletteContainer.add(stack);
		paletteContainer = stack;
	}
	public void _Stack() {
		paletteContainer = paletteContainer.getParent();
	}


	public void Connection(EntityDescriptor<?> ed) {
		Connection(ed,
				ed.getName(), "Create a " + ed.getName(),
				WholeImages.CONNECTION, WholeImages.CONNECTION);
	}
	public void Connection(EntityDescriptor<?> ed,
			String label, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge) {

		CreationFactory factory = new PrototypeCreationFactory(ed);
		ConnectionCreationToolEntry entry = new ConnectionCreationToolEntry(
				label, shortDesc, factory, iconSmall, iconLarge);
		
		paletteContainer.add(entry);
	}

	public void Template(EntityDescriptor<?> ed) {
		Template(ed,
				ed.getName(), "Create a " + ed.getName(),
				WholeImages.EMPTY, WholeImages.EMPTY);
	}
	public void Template(EntityDescriptor<?> ed,
			String label, String shortDesc,
			ImageDescriptor iconSmall, ImageDescriptor iconLarge) {

		CreationFactory factory = new PrototypeCreationFactory(ed);
		CombinedTemplateCreationEntry entry = new CombinedTemplateCreationEntry(
				label, shortDesc, factory, factory, iconSmall, iconLarge);
		
		paletteContainer.add(entry);
	}

	public void Separator() {
		Separator("");
	}
	public void Separator(String id) {
		PaletteSeparator separator = new PaletteSeparator(id);
		
		paletteContainer.add(separator);
	}

	public static CreationFactory createCreationFactory(Object template) {
		if (template instanceof EntityDescriptor<?>)
			return new PrototypeCreationFactory((EntityDescriptor<?>) template);
		else if (template instanceof IEntity)
			return new EntityCreationFactory((IEntity) template);
		throw new IllegalArgumentException("unsupported template: "+template);
	}

	private static class PrototypeCreationFactory implements CreationFactory {
		private EntityDescriptor<?> ed;

		public PrototypeCreationFactory(EntityDescriptor<?> ed) {
			this.ed = ed;
		}

		public Object getNewObject() {
			return GenericEntityFactory.instance.create(ed);
		}

		public Object getObjectType() {
			return null;//ed.entityType;
		}
	}

	private static class EntityCreationFactory implements CreationFactory {
		private IEntity prototype;

		public EntityCreationFactory(IEntity prototype) {
			this.prototype = prototype;
		}

		public Object getNewObject() {
			return EntityUtils.clone(prototype);
		}

		public Object getObjectType() {
			return null;// prototype.getClass();
		}
	}
}
