package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class ArtifactsModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {

    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Artifacts");
        b0.TypeRelations_(0);
        b0._TypeRelations();
        b0.ModelDeclarations_(21);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Workspace");
        b0.Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Metadata");
        b0.SimpleName("metadata");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Projects");
        b0.SimpleName("projects");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Projects");
        b0.Types();
        b0.ComponentModifiers_(2);
        b0.ComponentModifier("unique");
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Project");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Project");
        b0.Types();
        b0.Features_(5);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("id");
        b0._FeatureModifiers();
        b0.SimpleName("ProjectName");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Natures");
        b0.SimpleName("natures");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Metadata");
        b0.SimpleName("metadata");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Artifacts");
        b0.SimpleName("artifacts");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("LocationURI");
        b0.SimpleName("locationURI");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Artifacts");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Artifact");
        b0._CompositeEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("PackageArtifact");
        b0.Types_(1);
        b0.SimpleName("Artifact");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("PackageName");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Metadata");
        b0.SimpleName("metadata");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Artifacts");
        b0.SimpleName("artifacts");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("FolderArtifact");
        b0.Types_(1);
        b0.SimpleName("Artifact");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("FolderName");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Metadata");
        b0.SimpleName("metadata");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Artifacts");
        b0.SimpleName("artifacts");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("FileArtifact");
        b0.Types_(1);
        b0.SimpleName("Artifact");
        b0._Types();
        b0.Features_(3);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("FileName");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Metadata");
        b0.SimpleName("metadata");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Content");
        b0.SimpleName("content");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Natures");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("ordered");
        b0._ComponentModifiers();
        b0.SimpleName("Nature");
        b0._CompositeEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Nature");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("LocationURI");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Metadata");
        b0.Types();
        b0.Features_(5);
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Copyright");
        b0.SimpleName("copyright");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("License");
        b0.SimpleName("license");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Author");
        b0.SimpleName("author");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("Attributes");
        b0.SimpleName("attributes");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers_(1);
        b0.FeatureModifier("optional");
        b0._FeatureModifiers();
        b0.SimpleName("PersistenceKitId");
        b0.SimpleName("persistenceKitId");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Name");
        b0.Types_(4);
        b0.SimpleName("ProjectName");
        b0.SimpleName("PackageName");
        b0.SimpleName("FolderName");
        b0.SimpleName("FileName");
        b0._Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("NameWithExtension");
        b0.Types_(1);
        b0.SimpleName("FileName");
        b0._Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Name");
        b0.SimpleName("name");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Extension");
        b0.SimpleName("extension");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Copyright");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("License");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Author");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Extension");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.CompositeEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Attributes");
        b0.Types();
        b0.ComponentModifiers_(1);
        b0.ComponentModifier("unique");
        b0._ComponentModifiers();
        b0.SimpleName("Attribute");
        b0._CompositeEntity();
        b0.EnumEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Attribute");
        b0.Types();
        b0.EnumValues_(4);
        b0.EnumValue("derived");
        b0.EnumValue("readonly");
        b0.EnumValue("merge");
        b0.EnumValue("source");
        b0._EnumValues();
        b0._EnumEntity();
        b0.DataEntity_();
        b0.EntityModifiers();
        b0.SimpleName("PersistenceKitId");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Content");
        b0.Types();
        b0.Features();
        b0._SimpleEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.artifacts");
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.URI("http://lang.whole.org/Artifacts");
        b0._Model();
    }
}
