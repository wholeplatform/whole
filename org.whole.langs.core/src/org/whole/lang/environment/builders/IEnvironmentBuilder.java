/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.environment.builders;

import org.whole.lang.builders.IBuilder;
import java.util.Date;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public interface IEnvironmentBuilder extends IBuilder {


    public void visit();

    public void value();

    public void name();

    public void BooleanData();

    public void BooleanData(boolean value);

    public void ByteData();

    public void ByteData(byte value);

    public void CharData();

    public void CharData(char value);

    public void DoubleData();

    public void DoubleData(double value);

    public void FloatData();

    public void FloatData(float value);

    public void IntData();

    public void IntData(int value);

    public void LongData();

    public void LongData(long value);

    public void ShortData();

    public void ShortData(short value);

    public void StringData();

    public void StringData(String value);

    public void DateData();

    public void DateData(Date value);

    public void DateData(String value);

    public void ObjectData();

    public void ObjectData(Object value);

    public void ObjectData(String value);

    public void Tuple();

    public void Tuple_();

    public void Tuple_(int initialCapacity);

    public void _Tuple();

    public void ContainmentTuple();

    public void ContainmentTuple_();

    public void ContainmentTuple_(int initialCapacity);

    public void _ContainmentTuple();

    public void Void();

    public void Void_();

    public void _Void();

    public void Bindings();

    public void Bindings_();

    public void Bindings_(int initialCapacity);

    public void _Bindings();

    public void Binding();

    public void Binding_();

    public void _Binding();

    public void Name();

    public void Name(String value);

    public void Value();

    public void Value(IEntity value);

    public void Value(String value);
}
