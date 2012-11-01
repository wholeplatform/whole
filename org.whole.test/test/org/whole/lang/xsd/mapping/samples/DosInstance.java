package org.whole.lang.xsd.mapping.samples;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

public class DosInstance extends AbstractTemplateFactory<org.whole.lang.model.IEntity> {
	private ILanguageKit lk;

	public DosInstance(ILanguageKit lk) {
		this.lk = lk;
	}

    public void apply(IBuilderOperation op) {
        org.whole.lang.commons.builders.ICommonsBuilder b0 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        org.whole.lang.reflect.EntityDescriptorEnum e1 = lk.getEntityDescriptorEnum();
        b0.wEntity_(e1.valueOf("Blacklistentries-Type"));
        b0.wEntity_(e1.valueOf("Blacklistentries-TypeSeq"));
        b0.wEntity_(e1.valueOf("Blacklistentries-TypeList"), 4);
        b0.wEntity_(e1.valueOf("Blacklist-Type"));
        b0.wEntity_(e1.valueOf("Blacklist-TypeSet"));
        b0.wEntity(e1.valueOf("XSString"), "1.2.3.4");
        b0.wEntity(e1.valueOf("XSString"), "a single IP address");
        b0._wEntity(e1.valueOf("Blacklist-TypeSet"));
        b0._wEntity(e1.valueOf("Blacklist-Type"));
        b0.wEntity_(e1.valueOf("Blacklist-Type"));
        b0.wEntity_(e1.valueOf("Blacklist-TypeSet"));
        b0.wEntity(e1.valueOf("XSString"), "1.2.3.4/24");
        b0.wEntity(e1.valueOf("XSString"), "an IPv4 subnet");
        b0._wEntity(e1.valueOf("Blacklist-TypeSet"));
        b0._wEntity(e1.valueOf("Blacklist-Type"));
        b0.wEntity_(e1.valueOf("Blacklist-Type"));
        b0.wEntity_(e1.valueOf("Blacklist-TypeSet"));
        b0.wEntity(e1.valueOf("XSString"), "abcd::123:4567");
        b0.wEntity(e1.valueOf("XSString"), "an IPv6 address");
        b0._wEntity(e1.valueOf("Blacklist-TypeSet"));
        b0._wEntity(e1.valueOf("Blacklist-Type"));
        b0.wEntity_(e1.valueOf("Blacklist-Type"));
        b0.wEntity_(e1.valueOf("Blacklist-TypeSet"));
        b0.wEntity(e1.valueOf("XSString"), "abcd::123:4567/48");
        b0.wEntity(e1.valueOf("XSString"), "an IPv6 subnet");
        b0._wEntity(e1.valueOf("Blacklist-TypeSet"));
        b0._wEntity(e1.valueOf("Blacklist-Type"));
        b0._wEntity(e1.valueOf("Blacklistentries-TypeList"));
        b0._wEntity(e1.valueOf("Blacklistentries-TypeSeq"));
        b0._wEntity(e1.valueOf("Blacklistentries-Type"));
    }
}
