/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.grammars.templates;

import org.whole.lang.artifacts.builders.IArtifactsBuilder;
import org.whole.lang.artifacts.model.Workspace;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsLanguageKit;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.model.QuantifierEnum;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.ITemplateFactory;

/**
 * @author Riccardo Solmi
 */
public class ModelsArtifactsTemplateManager extends AbstractTemplateManager {
    private static ModelsArtifactsTemplateManager instance;
    public static ModelsArtifactsTemplateManager instance() {
        if (instance == null)
            instance = new ModelsArtifactsTemplateManager();
        return instance;
    }

    private ModelsArtifactsTemplateManager() {
        put("ModelFileArtifact", newModelArtifact(ModelsEntityDescriptorEnum.Model));
    }

    public ITemplateFactory<Workspace> newModelArtifact(final EntityDescriptor<?> fileContentRootED) {
        return new AbstractTemplateFactory<Workspace>() {

            public void apply(org.whole.lang.builders.IBuilderOperation op) {
                IArtifactsBuilder b0 = (IArtifactsBuilder) op.wGetBuilder(ArtifactsLanguageKit.URI);
                ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
                b0.Workspace_();
                cb.Resolver();
                b0.Projects_(1);
                b0.Project_();
                cb.Variable("projectName", ArtifactsEntityDescriptorEnum.Name, QuantifierEnum.MANDATORY);
                cb.Resolver();
                b0.Metadata();
                b0.Artifacts_(1);
                b0.FolderArtifact_();
                cb.Variable("sourceFolderName", ArtifactsEntityDescriptorEnum.Name, QuantifierEnum.MANDATORY);
                b0.Metadata();
                b0.Artifacts_(1);
                b0.PackageArtifact_();
                cb.Variable("packageName", ArtifactsEntityDescriptorEnum.Name, QuantifierEnum.MANDATORY);
                b0.Metadata();
                b0.Artifacts_(1);
                b0.FileArtifact_();
                b0.NameWithExtension_();
                cb.Variable("modelFileName", ArtifactsEntityDescriptorEnum.Name, QuantifierEnum.MANDATORY);
                b0.Extension("java");
                b0._NameWithExtension();
                b0.Metadata_();
                b0.wFeature(ArtifactsFeatureDescriptorEnum.persistenceKitId);
                b0.PersistenceKitId("org.whole.lang.java.codebase.JavaBuilderPersistenceKit");
                b0._Metadata();
                cb.StageUpFragment_();
                cb.Variable("modelFileContent", fileContentRootED, QuantifierEnum.MANDATORY);
                cb._StageUpFragment();
                b0._FileArtifact();
                b0._Artifacts();
                b0._PackageArtifact();
                b0._Artifacts();
                b0._FolderArtifact();
                b0._Artifacts();
                b0._Project();
                b0._Projects();
                b0._Workspace();
            }
        };
    }
}
