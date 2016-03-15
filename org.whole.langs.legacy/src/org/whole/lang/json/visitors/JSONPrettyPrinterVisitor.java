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
package org.whole.lang.json.visitors;

import java.io.IOException;

import org.whole.lang.json.model.Array;
import org.whole.lang.json.model.Bool;
import org.whole.lang.json.model.Decimal;
import org.whole.lang.json.model.Int;
import org.whole.lang.json.model.Name;
import org.whole.lang.json.model.Null;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;

/**
 * @author Riccardo Solmi
 */
public class JSONPrettyPrinterVisitor extends JSONTraverseAllVisitor {
	protected IPrettyPrintWriter out;
	protected JsonGenerator generator;

	public JSONPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	protected int nestingLevel;
	protected void startVisit() throws IOException {
		nestingLevel++;
		if (generator == null) {
			JsonFactory factory = new JsonFactory();
			generator = factory.createGenerator(out.asWriter());
			generator.disable(Feature.AUTO_CLOSE_TARGET);
			generator.useDefaultPrettyPrinter();
		}
	}
	protected void endVisit() throws IOException {
		if (--nestingLevel == 0) {
			generator.close();
			generator = null;
		}
	}
	
	@Override
	public void visit(Object entity) {
		try {
			startVisit();
			generator.writeStartObject();
			super.visit(entity);
			generator.writeEndObject();
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(Name entity) {
		try {
			startVisit();
			generator.writeFieldName(entity.getValue());
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(Array entity) {
		try {
			startVisit();
			generator.writeStartArray();
			super.visit(entity);
			generator.writeEndArray();
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(String entity) {
		try {
			startVisit();
			generator.writeString(entity.getValue());
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(Decimal entity) {
		try {
			startVisit();
			generator.writeNumber(entity.getValue());
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(Int entity) {
		try {
			startVisit();
			generator.writeNumber(entity.getValue());
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(Bool entity) {
		try {
			startVisit();
			generator.writeBoolean(entity.isValue());
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void visit(Null entity) {
		try {
			startVisit();
			generator.writeNull();
			endVisit();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
