package org.whole.lang.artifacts.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class WorkspaceTemplate extends AbstractTemplateFactory<org.whole.lang.artifacts.model.Workspace> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.artifacts.builders.IArtifactsBuilder b0 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
        b0.Workspace_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b1.StageDownFragment_();
        org.whole.lang.queries.builders.IQueriesBuilder b2 = (org.whole.lang.queries.builders.IQueriesBuilder) op.wGetBuilder(org.whole.lang.queries.reflect.QueriesLanguageKit.URI);
        b2.Filter_();
        b1.StageUpFragment_();
        b0.Projects_(1);
        b0.Project_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#ProjectName");
        b1.VarName("projectName");
        b1.Quantifier("!");
        b1._Variable();
        b0.Natures_(0);
        b0._Natures();
        b1.Resolver();
        b1.StageDownFragment_();
        b2.Filter_();
        b1.StageUpFragment_();
        b0.Artifacts_(1);
        b0.FolderArtifact_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#Name");
        b1.VarName("sourceFolderName");
        b1.Quantifier("!");
        b1._Variable();
        b1.Resolver();
        b1.StageDownFragment_();
        b2.Filter_();
        b1.StageUpFragment_();
        b0.Artifacts_(1);
        b0.PackageArtifact_();
        b1.Variable_();
        b1.VarType("http://lang.whole.org/Artifacts#PackageName");
        b1.VarName("packageName");
        b1.Quantifier("!");
        b1._Variable();
        b1.Resolver();
        b1.StageDownFragment_();
        b2.Filter_();
        b1.StageUpFragment_();
        b0.Artifacts_(0);
        b0._Artifacts();
        b1._StageUpFragment();
        b2.VariableTest("packageArtifactsPoint");
        b2._Filter();
        b1._StageDownFragment();
        b0._PackageArtifact();
        b0._Artifacts();
        b1._StageUpFragment();
        b2.VariableTest("packagesPoint");
        b2._Filter();
        b1._StageDownFragment();
        b0._FolderArtifact();
        b0._Artifacts();
        b1._StageUpFragment();
        b2.VariableTest("projectArtifactsPoint");
        b2._Filter();
        b1._StageDownFragment();
        b1.Resolver();
        b0._Project();
        b0._Projects();
        b1._StageUpFragment();
        b2.VariableTest("projectsPoint");
        b2._Filter();
        b1._StageDownFragment();
        b0._Workspace();
    }
}
