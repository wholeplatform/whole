package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

public class QueueInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {
	private ILanguageKit lk;

    public QueueInstance(ILanguageKit lk) {
    	this.lk = lk;
	}

	public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = lk.getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Queue-entries-Type"));
        b0.wEntity_(e1.valueOf("Queue-entries-TypeSeq"));
        b0.wEntity_(e1.valueOf("Queue-entries-TypeList"), 3);
        b0.wEntity_(e1.valueOf("Queue-Type"));
        b0.wEntity_(e1.valueOf("Queue-TypeSet"));
        b0.wEntity(e1.valueOf("Name-Type"), "default");
        b0.wEntity(e1.valueOf("Rate-Type"), "1/s");
        b0.Resolver();
        b0._wEntity(e1.valueOf("Queue-TypeSet"));
        b0._wEntity(e1.valueOf("Queue-Type"));
        b0.wEntity_(e1.valueOf("Queue-Type"));
        b0.wEntity_(e1.valueOf("Queue-TypeSet"));
        b0.wEntity(e1.valueOf("Name-Type"), "mail-queue");
        b0.wEntity(e1.valueOf("Rate-Type"), "2000/d");
        b0.wEntity(e1.valueOf("XSNonNegativeInteger"), "10");
        b0._wEntity(e1.valueOf("Queue-TypeSet"));
        b0._wEntity(e1.valueOf("Queue-Type"));
        b0.wEntity_(e1.valueOf("Queue-Type"));
        b0.wEntity_(e1.valueOf("Queue-TypeSet"));
        b0.wEntity(e1.valueOf("Name-Type"), "background-processing");
        b0.wEntity(e1.valueOf("Rate-Type"), "5/s");
        b0.Resolver();
        b0._wEntity(e1.valueOf("Queue-TypeSet"));
        b0._wEntity(e1.valueOf("Queue-Type"));
        b0._wEntity(e1.valueOf("Queue-entries-TypeList"));
        b0._wEntity(e1.valueOf("Queue-entries-TypeSeq"));
        b0._wEntity(e1.valueOf("Queue-entries-Type"));
    }
}
