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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.json.builders.IJSONBuilder;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * @author Riccardo Solmi
 */
public class JSONGeneratorBuilder extends GenericIdentityBuilder implements IJSONBuilder {
	protected JsonGenerator generator;

	public JSONGeneratorBuilder(JsonGenerator generator) {
		this.generator = generator;
	}

    public void value() {
    }

    public void name() {
    }

    public void visit() {
    }

    public void Object() {
    	Object_();
    	_Object();
    }
    public void Object_(int initialCapacity) {
       	Object_();
    }
    public void Object_() {
		try {
	    	generator.writeStartObject();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }
    public void _Object() {
		try {
	    	generator.writeEndObject();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }

    public void Pair() {
    	Pair_();
    	_Pair();
    }
    public void Pair_() {
    }
    public void _Pair() {
    }

    public void Name() {
    }
    public void Name(String value) {
		try {
			generator.writeFieldName(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }

    public void Array() {
    	Array_();
    	_Array();
    }
    public void Array_(int initialCapacity) {
    	Array_();
    }
    public void Array_() {
		try {
	    	generator.writeStartArray();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }
    public void _Array() {
		try {
	    	generator.writeEndArray();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }

    public void String() {
    }
    public void String(String value) {
		try {
			generator.writeString(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }

    public void Decimal() {
    }
    public void Decimal(double value) {
		try {
			generator.writeNumber(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }

    public void Int() {
    }
    public void Int(long value) {
		try {
			generator.writeNumber(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }

    public void Bool() {
    }
    public void Bool(boolean value) {
		try {
			generator.writeBoolean(value);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }

    public void Null() {
		try {
			generator.writeNull();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
    }
    public void Null_() {
        Null();
    }
    public void _Null() {
    }
}
