package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface Library extends IPatternsEntity {


    public URI getUri();

    public void setUri(URI uri);

    public Namespace getNamespace();

    public void setNamespace(Namespace namespace);

    public Name getName();

    public void setName(Name name);

    public Version getVersion();

    public void setVersion(Version version);

    public Declarations getDeclarations();

    public void setDeclarations(Declarations declarations);
}
