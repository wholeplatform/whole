package org.whole.lang.modules.model;


/**
 *  @generator  Whole
 */
public interface Reuse extends IModulesEntity {


    public Resource getResource();

    public void setResource(Resource resource);

    public Adapter getAdapter();

    public void setAdapter(Adapter adapter);

    public Content getOriginal();

    public void setOriginal(Content original);

    public Content getAdapted();

    public void setAdapted(Content adapted);

    public Content getVariant();

    public void setVariant(Content variant);
}
