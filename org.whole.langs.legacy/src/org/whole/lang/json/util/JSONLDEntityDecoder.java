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

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.factories.IEntityFactory;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.json.model.Pair;
import org.whole.lang.json.model.Value;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class JSONLDEntityDecoder extends CloneOperation {
	@Override
	protected IEntity applyRules(IEntity entity) {
		if (Matcher.matchImpl(JSONEntityDescriptorEnum.Object, entity))
			return decode((org.whole.lang.json.model.Object) entity);
		else
			return super.applyRules(entity);
	}

	public IEntity decode(org.whole.lang.json.model.Object jsonEntity) {
		String edUri = null;
		Value body = jsonEntity;
		
		for (int i=0; i<jsonEntity.size(); i++) {
			Pair pair = jsonEntity.get(i);
			String name = pair.getName().getValue();
			if (name.equals("@type"))
				edUri = pair.getValue().wStringValue();
			else if (name.equals("@list") || name.equals("@set") || name.equals("@value"))
				body = pair.getValue();
		}

		if (edUri == null)
			return super.applyRules(jsonEntity);

    	String contextUri = null;//TODO getBindings().wIsSet("contextURI") ? getBindings().wStringValue("contextURI") : null;
    	EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(edUri, true, contextUri);

		IEntityFactory ef = GenericEntityFactory.instance(RegistryConfigurations.RESOLVER);
		IEntity entity = ef.create(ed);
		switch (ed.getEntityKind()) {
		case SIMPLE:
			FeatureDescriptorEnum fdEnum = ed.getFeatureDescriptorEnum();
			for (int i=0; i<body.wSize(); i++) {
				Pair pair = (Pair) body.wGet(i);
				String name = pair.getName().getValue();
				if (!name.startsWith("@")) {
					FeatureDescriptor fd = fdEnum.valueOf(name);
					entity.wSet(fd, applyRules(pair.getValue()));
				}
			}
			break;
		case COMPOSITE:
			for (int i=0; i<body.wSize(); i++)
				entity.wAdd(applyRules(body.wGet(i)));
			break;
		case DATA:
			DataTypeUtils.convert(body, entity);
		}
		return entity;
	}
}
