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
package org.whole.lang.templates;

import java.util.Set;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.model.IEntity;


/**
 * Extensible Factory of templates.
 * Templates are build on demand.
 * 
 * @author Riccardo Solmi
 */
public interface ITemplateManager {
	public void apply(String name, IBuilderOperation op);

	public IEntity createEmpty();
	public IEntity create(ITemplate template);
	public IEntity create(String name);
	public IEntity share(String name);

	public ITemplateFactory<?> get(String name);
	public void put(String name, ITemplateFactory<?> template);
	public void remove(String name);

	public Set<String> names();
}
