package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class JDOConfigInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = org.whole.lang.reflect.ReflectionFactory.getLanguageKit("http://java.sun.com/xml/ns/jdo/jdoconfig").getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Jdoconfig"));
        b0.wEntity_(e1.valueOf("JdoconfigSeq"));
        b0.wEntity_(e1.valueOf("JdoconfigList"), 1);
        b0.wEntity_(e1.valueOf("Persistence-manager-factory"));
        b0.Resolver();
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "transactions-optional");
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.Resolver();
        b0.wEntity_(e1.valueOf("Persistence-manager-factorySeq"));
        b0.wEntity_(e1.valueOf("Persistence-manager-factoryList"), 6);
        b0.wEntity_(e1.valueOf("Property"));
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "javax.jdo.PersistenceManagerFactoryClass");
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "org.datanucleus.store.appengine.jdo.DatastoreJDOPersistenceManagerFactory");
        b0._wEntity(e1.valueOf("Property"));
        b0.wEntity_(e1.valueOf("Property"));
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "javax.jdo.option.ConnectionURL");
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "appengine");
        b0._wEntity(e1.valueOf("Property"));
        b0.wEntity_(e1.valueOf("Property"));
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "javax.jdo.option.NontransactionalRead");
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "true");
        b0._wEntity(e1.valueOf("Property"));
        b0.wEntity_(e1.valueOf("Property"));
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "javax.jdo.option.NontransactionalWrite");
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "true");
        b0._wEntity(e1.valueOf("Property"));
        b0.wEntity_(e1.valueOf("Property"));
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "javax.jdo.option.RetainValues");
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "true");
        b0._wEntity(e1.valueOf("Property"));
        b0.wEntity_(e1.valueOf("Property"));
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "datanucleus.appengine.autoCreateDatastoreTxns");
        b0.wEntity(e1.valueOf("XSAnySimpleType"), "true");
        b0._wEntity(e1.valueOf("Property"));
        b0._wEntity(e1.valueOf("Persistence-manager-factoryList"));
        b0.Resolver();
        b0._wEntity(e1.valueOf("Persistence-manager-factorySeq"));
        b0._wEntity(e1.valueOf("Persistence-manager-factory"));
        b0._wEntity(e1.valueOf("JdoconfigList"));
        b0._wEntity(e1.valueOf("JdoconfigSeq"));
        b0._wEntity(e1.valueOf("Jdoconfig"));
    }
}
