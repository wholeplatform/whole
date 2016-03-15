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

import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.json.factories.JSONEntityFactory;
import org.whole.lang.json.model.Value;
import org.whole.lang.json.reflect.JSONLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.CloneOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public class JSONLDEntityEncoder extends CloneOperation {
	@Override
	protected IEntity applyRules(IEntity entity) {
		if (entity.wGetLanguageKit().getURI().equals(JSONLanguageKit.URI))
			return super.applyRules(entity);
		else
			return encode(entity);
	}

	public Value encode(IEntity entity) {
		JSONEntityFactory ef = JSONEntityFactory.instance(RegistryConfigurations.RESOLVER);
		
		org.whole.lang.json.model.Object resultObject = ef.createObject(entity.wSize());
		setCopy(entity, resultObject);

		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		resultObject.add(ef.createPair(ef.createName("@type"), ef.createString(ed.getURI())));

		switch (ed.getEntityKind()) {
		case SIMPLE:
			for (int i=0; i<entity.wSize(); i++)
				resultObject.add(
						ef.createPair(ef.createName(entity.wGetFeatureDescriptor(i).getName()),
								encode(entity.wGet(i))));
			break;
		case COMPOSITE:
			org.whole.lang.json.model.Array arrayLiteral = ef.createArray(entity.wSize());
			resultObject.add(ef.createPair(ef.createName(
					ed.getCompositeKind().isOrdered() ? "@list" : "@set"), arrayLiteral));
			for (int i=0; i<entity.wSize(); i++)
				arrayLiteral.add(encode(entity.wGet(i)));
			break;
		default:
		case DATA:
			Value value = null;
			switch (ed.getDataKind()) {
			case BOOLEAN:
				value = ef.createBool(entity.wBooleanValue());
				break;
			case BYTE:
				value = ef.createInt(entity.wByteValue());
				break;
			case SHORT:
				value = ef.createInt(entity.wShortValue());
				break;
			case INT:
				value = ef.createInt(entity.wIntValue());
				break;
			case LONG:
				value = ef.createInt(entity.wLongValue());
				break;
			case FLOAT:
				value = ef.createDecimal(entity.wFloatValue());
				break;
			case DOUBLE:
				value = ef.createDecimal(entity.wDoubleValue());
				break;
			case STRING:
				value = ef.createString(entity.wStringValue());
				break;
			default:
				value = ef.createString(DataTypeUtils.getAsPersistenceString(entity));
			}
			resultObject.add(ef.createPair(ef.createName("@value"), value));
		}
		return resultObject;
	}
}
