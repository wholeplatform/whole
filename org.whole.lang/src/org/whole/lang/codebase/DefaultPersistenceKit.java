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
package org.whole.lang.codebase;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;


/**
 * @author Riccardo Solmi
 */
public class DefaultPersistenceKit extends AbstractGenericPersistenceKit {
	private static class SingletonHolder {
		private static final DefaultPersistenceKit instance = new DefaultPersistenceKit();
	}
	public static final DefaultPersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private DefaultPersistenceKit() {
		super("default", "whole");
	}

	public String getDescription() {
		return ReflectionFactory.getDefaultPersistenceKit().getDescription();
	}

	public boolean isGeneric() {
		return ReflectionFactory.getDefaultPersistenceKit().isGeneric();
	}

	public boolean isMultilanguage() {
		return ReflectionFactory.getDefaultPersistenceKit().isMultilanguage();
	}

	public boolean isLossless() {
		return ReflectionFactory.getDefaultPersistenceKit().isLossless();
	}

	@Override
	public IEntity readModel(IPersistenceProvider pp) throws Exception {
		return ReflectionFactory.getDefaultPersistenceKit().readModel(pp);
	}
	@Override
	public void writeModel(IEntity model, IPersistenceProvider pp) throws Exception {
		ReflectionFactory.getDefaultPersistenceKit().writeModel(model, pp);
	}
}
