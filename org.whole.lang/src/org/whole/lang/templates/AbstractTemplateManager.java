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

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.model.IEntity;


/**
 * @author Riccardo Solmi
 */
public abstract class AbstractTemplateManager implements ITemplateManager {
	private Map<String, ITemplateFactory<?>> registry = new TreeMap<String, ITemplateFactory<?>>();
	
	public void apply(String name, IBuilderOperation op) {
	    get(name).apply(op);
	}

	public IEntity createEmpty() {
		return create("empty");
	}
	public IEntity create(ITemplate template) {
		ModelBuilderOperation op = new ModelBuilderOperation();
		template.apply(op);
		return op.wGetResult();
	}
	public IEntity create(String name) {
		return get(name).create();
	}
	public IEntity share(String name) {
		return get(name).share();
	}

	public ITemplateFactory<?> get(String name) {
		ITemplateFactory<?> template = registry.get(name);
		
		if (template == null)
			throw new IllegalArgumentException("Unregistered template: "+name);
		
		return template;
	}
	public void put(String name, ITemplateFactory<?> factoryMethod) {
		registry.put(name, factoryMethod);
	}
	public void remove(String name) {
		registry.remove(name);
	}
	public Set<String> names() {
		return registry.keySet();
	}
}
