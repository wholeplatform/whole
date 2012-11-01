package org.whole.lang.misc.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.misc.model.Misc;
import org.whole.lang.templates.AbstractTemplateFactory;

public class WholeLanguage extends AbstractTemplateFactory<Misc> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.misc.builders.IMiscBuilder b0 = (org.whole.lang.misc.builders.IMiscBuilder) op.wGetBuilder(org.whole.lang.misc.reflect.MiscLanguageKit.URI);
        b0.Misc_(3);
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.SameStageFragment_();
        org.whole.lang.artifacts.builders.IArtifactsBuilder b2 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
        b2.PackageArtifact_();
        b2.Name("org.whole.lang");
        b2.Metadata_();
        b2.Copyright("Copyright 2004-2012 _name_.");
        b2.License("* All rights reserved. This program and the accompanying materials\n* are made available under the terms of the GNU Lesser General Public License\n* which accompanies this distribution, and is available at\n* http://www.gnu.org/copyleft/lesser.html");
        b2.Author("_name_");
        b1.Resolver();
        b1.Resolver();
        b2._Metadata();
        b1.Resolver();
        b2._PackageArtifact();
        b1._SameStageFragment();
        b1.SameStageFragment_();
        org.whole.lang.models.builders.IModelsBuilder b3 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b3.Model_();
        b3.SimpleName("_id_");
        b3.TypeRelations();
        b3.ModelDeclarations();
        b3._Model();
        b1._SameStageFragment();
        b1.SameStageFragment_();
        org.whole.lang.queries.builders.IQueriesBuilder b4 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b4.QueryDeclaration();
        b1._SameStageFragment();
        b0._Misc();
    }
}
