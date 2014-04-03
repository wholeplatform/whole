package org.whole.lang.modules.model;


/**
 *  @generator  Whole
 */
public interface Resource extends IModulesEntity {


    public Locator getLocator();

    public void setLocator(Locator locator);

    public Persistence getPersistence();

    public void setPersistence(Persistence persistence);

    public Registry getRegistry();

    public void setRegistry(Registry registry);
}
