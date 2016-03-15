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
package org.whole.lang.json.codebase;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.json.reflect.JSONLanguageKit;
import org.whole.lang.json.util.JSONParserTemplateFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;

/**
 * @author Riccardo Solmi
 */
public class JSONSourcePersistenceKit extends AbstractSpecificPersistenceKit {
	private static class SingletonHolder {
		private static final JSONSourcePersistenceKit instance = new JSONSourcePersistenceKit();
	}
	public static final JSONSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private JSONSourcePersistenceKit() {
		super("JSON", "json", JSONLanguageKit.URI);
	}

	public boolean isMultilanguage() {
		return false;
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		JsonFactory factory = new JsonFactory();
		//factory.enable(JsonParser.Feature.ALLOW_COMMENTS);
		JsonParser parser = factory.createParser(pp.getInputStream());
		parser.disable(Feature.AUTO_CLOSE_SOURCE);
		try {
			return new JSONParserTemplateFactory(parser).create();
		} finally {
			parser.close();
		}
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		if (!model.wGetLanguageKit().getURI().equals(JSONLanguageKit.URI))
			throw new IllegalArgumentException("A JSON model is required. Was: "+model.wGetLanguageKit());

		PrettyPrinterOperation.prettyPrint(model, pp.getOutputStream(), pp.getEncoding());
	}
}
