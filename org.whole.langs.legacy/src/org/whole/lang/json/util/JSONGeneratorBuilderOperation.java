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

import org.whole.lang.builders.AbstractBuilderOperation;
import org.whole.lang.builders.GenericFailureBuilder;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.json.reflect.JSONLanguageKit;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * @author Riccardo Solmi
 */
public class JSONGeneratorBuilderOperation extends AbstractBuilderOperation {
	public static final String ID = "JSONGeneratorBuilder";
	protected JsonGenerator generator;

	public JSONGeneratorBuilderOperation(JsonGenerator generator) {
		this.generator = generator;
	}

	public String wGetOperationId() {
		return ID;
	}

	protected IBuilder createGenericBuilder() {
		return createGenericBuilderAdapter(JSONLanguageKit.URI, false);//FIXME add generic filter to failure for non JSON calls
	}

	protected IBuilder createSpecificBuilder(String languageURI) {
		if (languageURI.equals(JSONLanguageKit.URI))
			return new JSONGeneratorBuilder(generator);
		else
			return createSpecificBuilderAdapterOperation(new GenericFailureBuilder()).wGetBuilder(languageURI, false);
	}
}
