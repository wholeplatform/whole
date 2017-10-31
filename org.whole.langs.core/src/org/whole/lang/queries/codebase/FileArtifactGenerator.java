package org.whole.lang.queries.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class FileArtifactGenerator extends AbstractTemplateFactory<org.whole.lang.queries.model.impl.SelectImpl> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.queries.builders.IQueriesBuilder b0 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b0.Select_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.StageUpFragment_();
        org.whole.lang.artifacts.builders.IArtifactsBuilder b2 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
        b2.Workspace_();
        b1.Resolver();
        b2.Projects_(1);
        b2.Project_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#ProjectName");
        b1.VarName("projectName");
        b1.Quantifier("MANDATORY");
        b1._Variable();
        b2.Natures();
        b1.Resolver();
        b2.Artifacts_(1);
        b2.FolderArtifact_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("sourceFolderName");
        b1.Quantifier("MANDATORY");
        b1._Variable();
        b1.Resolver();
        b2.Artifacts_(1);
        b2.PackageArtifact_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#PackageName");
        b1.VarName("packageName");
        b1.Quantifier("MANDATORY");
        b1._Variable();
        b1.Resolver();
        b2.Artifacts_(1);
        b2.FileArtifact_();
        b2.NameWithExtension_();
        b2.Name("ArtifactName");
        b2.Extension("extension");
        b2._NameWithExtension();
        b1.Resolver();
        b1.Resolver();
        b2._FileArtifact();
        b2._Artifacts();
        b2._PackageArtifact();
        b2._Artifacts();
        b2._FolderArtifact();
        b2._Artifacts();
        b2._Project();
        b2._Projects();
        b2._Workspace();
        b1._StageUpFragment();
        b0.SelfStep();
        b1.Resolver();
        b0._Select();
    }
}
