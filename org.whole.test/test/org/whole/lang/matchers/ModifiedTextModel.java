package org.whole.lang.matchers;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class ModifiedTextModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("ModifiedText");
        b0.TypeRelations_(0);
        b0._TypeRelations();
        b0.ModelDeclarations_(6);
        b0.CompositeEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Document");
        b0.Types_(0);
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("IRow");
        b0._CompositeEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Indent");
        b0.Types_(1);
        b0.SimpleName("IRow");
        b0._Types();
        b0.DataType("int");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("RowSeparator");
        b0.Types_(1);
        b0.SimpleName("IRow");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("TextSeparator");
        b0.Types_(3);
        b0.SimpleName("IRow");
        b0.SimpleName("simpleName");
        b0.SimpleName("IText");
        b0._Types();
        b0.Features_(0);
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Row");
        b0.Types_(1);
        b0.SimpleName("IRow");
        b0._Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("IText");
        b0._CompositeEntity();
        b0.EnumEntity_();
        b0.EntityModifiers_(0);
        b0._EntityModifiers();
        b0.SimpleName("Text");
        b0.Types_(1);
        b0.SimpleName("IText");
        b0._Types();
        b0.EnumValues_(2);
        b0.EnumValue("V1");
        b0.EnumValue("V2");
        b0._EnumValues();
        b0._EnumEntity();
        b0._ModelDeclarations();
        b0._Model();
    }
}
