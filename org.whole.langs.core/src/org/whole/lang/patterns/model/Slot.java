package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface Slot extends IPatternsEntity, VariationPoint {


    public Name getName();

    public void setName(Name name);

    public BooleanValue getOptional();

    public void setOptional(BooleanValue optional);

    public PathExpression getAdapter();

    public void setAdapter(PathExpression adapter);

    public Type getType();

    public void setType(Type type);

    public Type getResultType();

    public void setResultType(Type resultType);
}
