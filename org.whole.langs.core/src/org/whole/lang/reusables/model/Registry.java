package org.whole.lang.reusables.model;


/**
 *  @generator  Whole
 */
public interface Registry extends IReusablesEntity, Source {


    public URI getLocator();

    public void setLocator(URI locator);

    public URI getUri();

    public void setUri(URI uri);
}
