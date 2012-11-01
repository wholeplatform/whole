package org.whole.lang.xsd.util;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class Artifacts extends AbstractTemplateFactory<org.whole.lang.artifacts.model.Workspace> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.artifacts.builders.IArtifactsBuilder b0 = (org.whole.lang.artifacts.builders.IArtifactsBuilder) op.wGetBuilder(org.whole.lang.artifacts.reflect.ArtifactsLanguageKit.URI);
        b0.Workspace_();
        b0.Metadata_();
        b0.Copyright("© 2007-2009 Artifacts Inc.");
        b0.License("MPL");
        b0.Author("Enrico Persiani");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b1.Resolver();
        b0._Metadata();
        b0.Projects_(1);
        b0.Project_();
        b0.Name("TestProject");
        b0.Natures_(1);
        b0.Nature("org.eclipse.jdt.core.javabuilder");
        b0._Natures();
        b1.Resolver();
        b0.Artifacts_(2);
        b0.FolderArtifact_();
        b0.Name("src");
        b0.Metadata_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b0.Attributes_(1);
        b0.Attribute("source");
        b0._Attributes();
        b1.Resolver();
        b0._Metadata();
        b0.Artifacts_(1);
        b0.PackageArtifact_();
        b0.Name("org.whole.lang.test");
        b1.Resolver();
        b0.Artifacts_(1);
        b0.FileArtifact_();
        b0.NameWithExtension_();
        b0.Name("Example");
        b0.Extension("java");
        b0._NameWithExtension();
        b0.Metadata_();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b1.Resolver();
        b0.PersistenceKitId("org.whole.lang.java.codebase.JavaSourcePersistenceKit");
        b0._Metadata();
        b1.Resolver();
        b0._FileArtifact();
        b0._Artifacts();
        b0._PackageArtifact();
        b0._Artifacts();
        b0._FolderArtifact();
        b0.FolderArtifact_();
        b0.Name("bin");
        b1.Resolver();
        b0.Artifacts_(0);
        b0._Artifacts();
        b0._FolderArtifact();
        b0._Artifacts();
        b1.Resolver();
        b0._Project();
        b0._Projects();
        b0._Workspace();
    }
}
