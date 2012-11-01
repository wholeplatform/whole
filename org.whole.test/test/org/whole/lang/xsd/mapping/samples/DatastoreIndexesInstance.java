package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

public class DatastoreIndexesInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {
	private ILanguageKit lk;

    public DatastoreIndexesInstance(ILanguageKit lk) {
    	this.lk = lk;
	}

	public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = lk.getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Datastore-indexesType"));
        b0.wEntity(e1.valueOf("XSBoolean"), true);
        b0.wEntity_(e1.valueOf("Datastore-indexesTypeSeq"));
        b0.wEntity_(e1.valueOf("Datastore-indexesTypeList"), 2);
        b0.wEntity_(e1.valueOf("Datastore-indexType"));
        b0.wEntity(e1.valueOf("XSString"), "Employee");
        b0.wEntity(e1.valueOf("XSBoolean"), false);
        b0.Resolver();
        b0.wEntity_(e1.valueOf("Datastore-indexTypeSeq"));
        b0.wEntity_(e1.valueOf("Datastore-indexTypeList"), 2);
        b0.wEntity_(e1.valueOf("PropertyType"));
        b0.wEntity(e1.valueOf("XSString"), "lastName");
        b0.wEntity(e1.valueOf("DirectionType"), "asc");
        b0.wEntity(e1.valueOf("XSString"), "");
        b0._wEntity(e1.valueOf("PropertyType"));
        b0.wEntity_(e1.valueOf("PropertyType"));
        b0.wEntity(e1.valueOf("XSString"), "hireDate");
        b0.wEntity(e1.valueOf("DirectionType"), "desc");
        b0.wEntity(e1.valueOf("XSString"), "");
        b0._wEntity(e1.valueOf("PropertyType"));
        b0._wEntity(e1.valueOf("Datastore-indexTypeList"));
        b0._wEntity(e1.valueOf("Datastore-indexTypeSeq"));
        b0._wEntity(e1.valueOf("Datastore-indexType"));
        b0.wEntity_(e1.valueOf("Datastore-indexType"));
        b0.wEntity(e1.valueOf("XSString"), "Project");
        b0.wEntity(e1.valueOf("XSBoolean"), false);
        b0.Resolver();
        b0.wEntity_(e1.valueOf("Datastore-indexTypeSeq"));
        b0.wEntity_(e1.valueOf("Datastore-indexTypeList"), 1);
        b0.wEntity_(e1.valueOf("PropertyType"));
        b0.wEntity(e1.valueOf("XSString"), "dueDate");
        b0.wEntity(e1.valueOf("DirectionType"), "asc");
        b0.wEntity(e1.valueOf("XSString"), "");
        b0._wEntity(e1.valueOf("PropertyType"));
        b0._wEntity(e1.valueOf("Datastore-indexTypeList"));
        b0._wEntity(e1.valueOf("Datastore-indexTypeSeq"));
        b0._wEntity(e1.valueOf("Datastore-indexType"));
        b0._wEntity(e1.valueOf("Datastore-indexesTypeList"));
        b0._wEntity(e1.valueOf("Datastore-indexesTypeSeq"));
        b0._wEntity(e1.valueOf("Datastore-indexesType"));
    }
}
