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
package org.whole.lang.models.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class ScriptsModel extends AbstractTemplateFactory<org.whole.lang.models.model.Model> {


    public void apply(IBuilderOperation op) {
        org.whole.lang.models.builders.IModelsBuilder b0 = (org.whole.lang.models.builders.IModelsBuilder) op.wGetBuilder(org.whole.lang.models.reflect.ModelsLanguageKit.URI);
        b0.Model_();
        b0.SimpleName("Scripts");
        b0.TypeRelations_(0);
        b0._TypeRelations();
        b0.ModelDeclarations_(3);
        b0.SimpleEntity_();
        b0.EntityModifiers();
        b0.SimpleName("Script");
        b0.Types();
        b0.Features_(2);
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("LanguageName");
        b0.SimpleName("languageName");
        b0._Feature();
        b0.Feature_();
        b0.FeatureModifiers();
        b0.SimpleName("Source");
        b0.SimpleName("source");
        b0._Feature();
        b0._Features();
        b0._SimpleEntity();
        b0.DataEntity_();
        org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
        b1.Resolver();
        b0.SimpleName("LanguageName");
        b0.Types();
        b0.DataType("String");
        b0._DataEntity();
        b0.SimpleEntity_();
        b0.EntityModifiers_(1);
        b0.EntityModifier("abstract");
        b0._EntityModifiers();
        b0.SimpleName("Source");
        b0.Types();
        b0.Features();
        b0._SimpleEntity();
        b0._ModelDeclarations();
        b0.Namespace("org.whole.lang.scripts");
        b1.Resolver();
        b0.URI("http://lang.whole.org/Scripts");
        b0._Model();
    }
}
