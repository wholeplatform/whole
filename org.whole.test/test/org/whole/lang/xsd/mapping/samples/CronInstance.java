package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

public class CronInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {
	private ILanguageKit lk;

    public CronInstance(ILanguageKit lk) {
    	this.lk = lk;
	}

	public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = lk.getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Cronentries-Type"));
        b0.wEntity_(e1.valueOf("Cronentries-TypeSeq"));
        b0.wEntity_(e1.valueOf("Cronentries-TypeList"), 2);
        b0.wEntity_(e1.valueOf("Cron-Type"));
        b0.wEntity_(e1.valueOf("Cron-TypeSet"));
        b0.wEntity(e1.valueOf("XSString"), "/recache");
        b0.wEntity(e1.valueOf("XSString"), "Repopulate the cache every 2 minutes");
        b0.wEntity(e1.valueOf("XSString"), "every 2 minutes");
        b0.Resolver();
        b0._wEntity(e1.valueOf("Cron-TypeSet"));
        b0._wEntity(e1.valueOf("Cron-Type"));
        b0.wEntity_(e1.valueOf("Cron-Type"));
        b0.wEntity_(e1.valueOf("Cron-TypeSet"));
        b0.wEntity(e1.valueOf("XSString"), "/weeklyreport");
        b0.wEntity(e1.valueOf("XSString"), "Mail out a weekly report");
        b0.wEntity(e1.valueOf("XSString"), "every monday 08:30");
        b0.wEntity(e1.valueOf("XSString"), "America/New_York");
        b0._wEntity(e1.valueOf("Cron-TypeSet"));
        b0._wEntity(e1.valueOf("Cron-Type"));
        b0._wEntity(e1.valueOf("Cronentries-TypeList"));
        b0._wEntity(e1.valueOf("Cronentries-TypeSeq"));
        b0._wEntity(e1.valueOf("Cronentries-Type"));
    }
}
