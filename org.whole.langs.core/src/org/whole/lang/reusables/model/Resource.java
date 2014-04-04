package org.whole.lang.reusables.model;


/**
 *  @generator  Whole
 */
public interface Resource extends IReusablesEntity, Source {


    public Locator getLocator();

    public void setLocator(Locator locator);

    public Persistence getPersistence();

    public void setPersistence(Persistence persistence);

    public Registry getRegistry();

    public void setRegistry(Registry registry);
}
