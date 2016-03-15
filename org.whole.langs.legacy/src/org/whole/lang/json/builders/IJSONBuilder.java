/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.json.builders;

import org.whole.lang.builders.IBuilder;

/**
 *  @generator Whole
 */
public interface IJSONBuilder extends IBuilder {


    public void visit();

    public void value();

    public void name();

    public void Object();

    public void Object_();

    public void Object_(int initialCapacity);

    public void _Object();

    public void Pair();

    public void Pair_();

    public void _Pair();

    public void Name();

    public void Name(String value);

    public void Array();

    public void Array_();

    public void Array_(int initialCapacity);

    public void _Array();

    public void String();

    public void String(String value);

    public void Decimal();

    public void Decimal(double value);

    public void Int();

    public void Int(long value);

    public void Bool();

    public void Bool(boolean value);

    public void Null();

    public void Null_();

    public void _Null();
}
