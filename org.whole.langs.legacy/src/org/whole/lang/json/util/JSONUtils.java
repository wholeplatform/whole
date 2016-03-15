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
package org.whole.lang.json.util;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.json.factories.JSONEntityFactory;
import org.whole.lang.json.model.Pair;
import org.whole.lang.json.model.Value;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class JSONUtils {
    public static Map<String, Value> toMap(IEntity entity) {
		Map<String, Value> map = new HashMap<String, Value>();

		if (Matcher.matchImpl(JSONEntityDescriptorEnum.Object, entity)) {
			org.whole.lang.json.model.Object object = (org.whole.lang.json.model.Object) entity;
			for (int i=0, size=object.size(); i<size; i++) {
				Pair pair = object.get(i);
				map.put(pair.getName().getValue(), pair.getValue());
			}
		}

    	return map;
    }
    public static Value get(IEntity entity, String name) {
		if (Matcher.matchImpl(JSONEntityDescriptorEnum.Object, entity)) {
			org.whole.lang.json.model.Object object = (org.whole.lang.json.model.Object) entity;
			for (int i=0, size=object.size(); i<size; i++) {
				Pair pair = object.get(i);
				if (pair.getName().getValue().equals(name))
					return pair.getValue();
			}
		}
		return null;
    }
    public static void set(IEntity entity, String name, Value value) {
		if (!Matcher.matchImpl(JSONEntityDescriptorEnum.Object, entity))
			throw new IllegalArgumentException();

		org.whole.lang.json.model.Object object = (org.whole.lang.json.model.Object) entity;

		for (int i=0, size=object.size(); i<size; i++) {
			Pair pair = object.get(i);
			if (pair.getName().getValue().equals(name)) {
				pair.setValue(value);
				return;
			}
		}

		JSONEntityFactory ef = JSONEntityFactory.instance;
		object.add(ef.createPair(ef.createName(name), value));
    }
}
