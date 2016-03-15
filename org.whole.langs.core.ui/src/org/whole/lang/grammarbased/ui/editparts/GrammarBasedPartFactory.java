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
package org.whole.lang.grammarbased.ui.editparts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.whole.lang.grammars.codebase.GrammarsRegistry;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class GrammarBasedPartFactory implements IEditPartFactory {
	private static class SingletonHolder {
		private static final GrammarBasedPartFactory instance = new GrammarBasedPartFactory();
	}
	public static GrammarBasedPartFactory instance() {
		return SingletonHolder.instance;
	}

	final protected Map<String, Map<String, IEntity>> configurationsMap; // grammarURI -> configurations
	protected GrammarBasedPartFactory() {
		this.configurationsMap = new HashMap<String, Map<String,IEntity>>();
	}

	public synchronized Map<String, IEntity> putConfigurations(String grammarURI, Map<String, IEntity> configurations) {
		return configurationsMap.put(grammarURI, configurations);
	}
	public synchronized Map<String, IEntity> getConfigurations(String grammarURI) {
		return configurationsMap.get(grammarURI);
	}

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part;
		IEntity entity = (IEntity) model;

		if (entity.wIsAdapter())
			part = new org.whole.lang.ui.editparts.PlaceHolderPart();
		else
			part = createEntityPart(entity);

		return part != null ? part : DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	protected IEntityPart createEntityPart(IEntity entity) {
		Grammar grammar = GrammarsRegistry.instance().getGrammarsFor(entity).iterator().next();
		Map<String, IEntity> configurations = getConfigurations(grammar.getUri().getValue());

		IEntity configuration = configurations.get(entity.wGetEntityDescriptor().getName());
		if (configuration == null)
			return null;

		IEntityPart entityPart = null;
		switch (entity.wGetEntityKind()) {
		case COMPOSITE:
			if (!configuration.wGetEntityDescriptor().getName().equals("CompositePart"))
				throw new IllegalArgumentException();
			entityPart = new CompositeEntityPart(configuration);
			break;

		case SIMPLE:
			if (!configuration.wGetEntityDescriptor().getName().equals("SimplePart"))
				throw new IllegalArgumentException();
			entityPart = new SimpleEntityPart(configuration);
			break;

		case DATA:
			if (!configuration.wGetEntityDescriptor().getName().equals("DataPart") &&
					!configuration.wGetEntityDescriptor().getName().equals("EnumPart"))
				throw new IllegalArgumentException();
			entityPart = DataTypeUtils.getDataKind(entity).isEnumValue() ?
					new EnumEntityPart(configuration) : new DataEntityPart(configuration);
			break;
		}

		return entityPart;
	}
}
