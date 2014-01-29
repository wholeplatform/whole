package org.whole.lang.json.builders;

import org.whole.lang.builders.IBuilder;

/**
 *  @generator  Whole
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
