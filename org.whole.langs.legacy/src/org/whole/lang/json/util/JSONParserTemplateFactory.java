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

import java.io.IOException;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.json.builders.IJSONBuilder;
import org.whole.lang.json.factories.JSONEntityFactory;
import org.whole.lang.json.model.Value;
import org.whole.lang.json.reflect.JSONLanguageKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.templates.ITemplateFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * @author Riccardo Solmi
 */
public class JSONParserTemplateFactory implements ITemplateFactory<Value> {
	private Value template;
	protected JsonParser parser;
	protected JSONEntityFactory factory;
	protected IJSONBuilder builder;

	public JSONParserTemplateFactory(JsonParser parser) {
		this.parser = parser;
		this.factory = JSONEntityFactory.instance(RegistryConfigurations.RESOLVER);
	}

	public void apply(IBuilderOperation operation) {
		this.builder = (IJSONBuilder) operation.wGetBuilder(JSONLanguageKit.URI);
		try {
			stream();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public Value create() {
		try {
			return (Value) build();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	public Value share() {
		if (template == null)
			template = create();
		return template;
	}

	public void stream() throws JsonParseException, IOException {
		switch (parser.nextToken()) {
		case START_OBJECT:
			builder.Object_();
			do {
				stream();
			} while (parser.getCurrentToken() != JsonToken.END_OBJECT);
			parser.clearCurrentToken();
			break;
		case FIELD_NAME:
			builder.Pair_();
			builder.Name(parser.getText());
			stream();
			builder._Pair();
			break;
		case END_OBJECT:
			builder._Object();
			break;
		case START_ARRAY:
			builder.Array_();
			do {
				stream();
			} while (parser.getCurrentToken() != JsonToken.END_ARRAY);
			parser.clearCurrentToken();
			break;
		case END_ARRAY:
			builder._Array();
			break;
		case VALUE_STRING:
			builder.String(parser.getText());
			break;
		case VALUE_NUMBER_FLOAT:
			builder.Decimal(parser.getDoubleValue());
			break;
		case VALUE_NUMBER_INT:
			builder.Int(parser.getLongValue());
			break;
		case VALUE_FALSE:
			builder.Bool(false);
			break;
		case VALUE_TRUE:
			builder.Bool(true);
			break;
		case VALUE_NULL:
			builder.Null();
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public IEntity build() throws JsonParseException, IOException {
		switch (parser.nextToken()) {
		case START_OBJECT:
			Value object = factory.createObject();
			do {
				IEntity value = build();
				if (parser.getCurrentToken() == JsonToken.END_OBJECT) {
					parser.clearCurrentToken();
					return object;
				}
				object.wAdd(value);
			} while (true);
		case FIELD_NAME:
			return factory.createPair(factory.createName(parser.getText()), (Value) build());
		case END_OBJECT:
			return null;
		case START_ARRAY:
			Value array = factory.createArray();
			do {
				IEntity value = build();
				if (parser.getCurrentToken() == JsonToken.END_ARRAY) {
					parser.clearCurrentToken();
					return array;
				}
				array.wAdd(value);
			} while (true);
		case END_ARRAY:
			return null;
		case VALUE_STRING:
			return factory.createString(parser.getText());
		case VALUE_NUMBER_FLOAT:
			return factory.createDecimal(parser.getDoubleValue());
		case VALUE_NUMBER_INT:
			return factory.createInt(parser.getLongValue());
		case VALUE_FALSE:
			return factory.createBool(false);
		case VALUE_TRUE:
			return factory.createBool(true);
		case VALUE_NULL:
			return factory.createNull();
		default:
			throw new IllegalArgumentException();
		}
	}
}
