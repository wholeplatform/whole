/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.migrations.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.migrations.model.*;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class MigrationsEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int MigrationFrame_ord = 0;
    public static final int Library_ord = 1;
    public static final int MigrationFunctions_ord = 2;
    public static final int MigrationFunction_ord = 3;
    public static final int MigrationRules_ord = 4;
    public static final int MigratePatternLanguage_ord = 5;
    public static final int MigrateLanguage_ord = 6;
    public static final int LanguageMigrationRules_ord = 7;
    public static final int LanguageMigrationRule_ord = 8;
    public static final int MigrateEntityPattern_ord = 9;
    public static final int MigrateEntity_ord = 10;
    public static final int EntityMigrationRules_ord = 11;
    public static final int MigrateFeatures_ord = 12;
    public static final int MigrateFeature_ord = 13;
    public static final int MigratePath_ord = 14;
    public static final int Source_ord = 15;
    public static final int Target_ord = 16;
    public static final int FeatureReference_ord = 17;
    public static final int TypeTest_ord = 18;
    public static final int Label_ord = 19;
    public static final int MigrationRule_ord = 20;
    public static final int Registry_ord = 21;
    public static final int URI_ord = 22;
    public static final int Namespace_ord = 23;
    public static final int Name_ord = 24;
    public static final int FeatureStep_ord = 25;
    public static final int Expression_ord = 26;
    public static final int LanguageTest_ord = 27;
    public static final int Workspace_ord = 28;
    public static final MigrationsEntityDescriptorEnum instance = new MigrationsEntityDescriptorEnum();
    public static final EntityDescriptor<MigrationFrame> MigrationFrame = (EntityDescriptor<MigrationFrame>) instance.valueOf(MigrationFrame_ord);
    public static final EntityDescriptor<Library> Library = (EntityDescriptor<Library>) instance.valueOf(Library_ord);
    public static final EntityDescriptor<MigrationFunctions> MigrationFunctions = (EntityDescriptor<MigrationFunctions>) instance.valueOf(MigrationFunctions_ord);
    public static final EntityDescriptor<MigrationFunction> MigrationFunction = (EntityDescriptor<MigrationFunction>) instance.valueOf(MigrationFunction_ord);
    public static final EntityDescriptor<MigrationRules> MigrationRules = (EntityDescriptor<MigrationRules>) instance.valueOf(MigrationRules_ord);
    public static final EntityDescriptor<MigratePatternLanguage> MigratePatternLanguage = (EntityDescriptor<MigratePatternLanguage>) instance.valueOf(MigratePatternLanguage_ord);
    public static final EntityDescriptor<MigrateLanguage> MigrateLanguage = (EntityDescriptor<MigrateLanguage>) instance.valueOf(MigrateLanguage_ord);
    public static final EntityDescriptor<LanguageMigrationRules> LanguageMigrationRules = (EntityDescriptor<LanguageMigrationRules>) instance.valueOf(LanguageMigrationRules_ord);
    public static final EntityDescriptor<LanguageMigrationRule> LanguageMigrationRule = (EntityDescriptor<LanguageMigrationRule>) instance.valueOf(LanguageMigrationRule_ord);
    public static final EntityDescriptor<MigrateEntityPattern> MigrateEntityPattern = (EntityDescriptor<MigrateEntityPattern>) instance.valueOf(MigrateEntityPattern_ord);
    public static final EntityDescriptor<MigrateEntity> MigrateEntity = (EntityDescriptor<MigrateEntity>) instance.valueOf(MigrateEntity_ord);
    public static final EntityDescriptor<EntityMigrationRules> EntityMigrationRules = (EntityDescriptor<EntityMigrationRules>) instance.valueOf(EntityMigrationRules_ord);
    public static final EntityDescriptor<MigrateFeatures> MigrateFeatures = (EntityDescriptor<MigrateFeatures>) instance.valueOf(MigrateFeatures_ord);
    public static final EntityDescriptor<MigrateFeature> MigrateFeature = (EntityDescriptor<MigrateFeature>) instance.valueOf(MigrateFeature_ord);
    public static final EntityDescriptor<MigratePath> MigratePath = (EntityDescriptor<MigratePath>) instance.valueOf(MigratePath_ord);
    public static final EntityDescriptor<Source> Source = (EntityDescriptor<Source>) instance.valueOf(Source_ord);
    public static final EntityDescriptor<Target> Target = (EntityDescriptor<Target>) instance.valueOf(Target_ord);
    public static final EntityDescriptor<FeatureReference> FeatureReference = (EntityDescriptor<FeatureReference>) instance.valueOf(FeatureReference_ord);
    public static final EntityDescriptor<TypeTest> TypeTest = (EntityDescriptor<TypeTest>) instance.valueOf(TypeTest_ord);
    public static final EntityDescriptor<Label> Label = (EntityDescriptor<Label>) instance.valueOf(Label_ord);
    public static final EntityDescriptor<MigrationRule> MigrationRule = (EntityDescriptor<MigrationRule>) instance.valueOf(MigrationRule_ord);
    public static final EntityDescriptor<Registry> Registry = (EntityDescriptor<Registry>) instance.valueOf(Registry_ord);
    public static final EntityDescriptor<URI> URI = (EntityDescriptor<URI>) instance.valueOf(URI_ord);
    public static final EntityDescriptor<Namespace> Namespace = (EntityDescriptor<Namespace>) instance.valueOf(Namespace_ord);
    public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance.valueOf(Name_ord);
    public static final EntityDescriptor<FeatureStep> FeatureStep = (EntityDescriptor<FeatureStep>) instance.valueOf(FeatureStep_ord);
    public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance.valueOf(Expression_ord);
    public static final EntityDescriptor<LanguageTest> LanguageTest = (EntityDescriptor<LanguageTest>) instance.valueOf(LanguageTest_ord);
    public static final EntityDescriptor<Workspace> Workspace = (EntityDescriptor<Workspace>) instance.valueOf(Workspace_ord);

    private MigrationsEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(MigrationFrame_ord, "MigrationFrame", MigrationFrame.class, false).withFeature(MigrationsFeatureDescriptorEnum.uri, URI_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.namespace, Namespace_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.name, Name_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.artifacts, Workspace_ord).withFeature(MigrationsFeatureDescriptorEnum.rules, MigrationRules_ord);
        putSimpleEntity(Library_ord, "Library", Library.class, false).withFeature(MigrationsFeatureDescriptorEnum.uri, URI_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.namespace, Namespace_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.name, Name_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.functions, MigrationFunctions_ord);
        putCompositeEntity(MigrationFunctions_ord, "MigrationFunctions", MigrationFunctions.class, false, MigrationFunction_ord, true, false);
        putSimpleEntity(MigrationFunction_ord, "MigrationFunction", MigrationFunction.class, false).withFeature(MigrationsFeatureDescriptorEnum.label, Label_ord).withFeature(MigrationsFeatureDescriptorEnum.name, Name_ord).withFeature(MigrationsFeatureDescriptorEnum.rules, MigrationRules_ord);
        putCompositeEntity(MigrationRules_ord, "MigrationRules", MigrationRules.class, false, MigrationRule_ord, true, false);
        putSimpleEntity(MigratePatternLanguage_ord, "MigratePatternLanguage", MigratePatternLanguage.class, false).withFeature(MigrationsFeatureDescriptorEnum.source, URI_ord).withFeature(MigrationsFeatureDescriptorEnum.target, URI_ord).withFeature(MigrationsFeatureDescriptorEnum.rules, LanguageMigrationRules_ord, true, false, false, false, false);
        putSimpleEntity(MigrateLanguage_ord, "MigrateLanguage", MigrateLanguage.class, false).withFeature(MigrationsFeatureDescriptorEnum.source, LanguageTest_ord).withFeature(MigrationsFeatureDescriptorEnum.target, LanguageTest_ord).withFeature(MigrationsFeatureDescriptorEnum.rules, LanguageMigrationRules_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.registry, Registry_ord, true, false, false, false, false);
        putCompositeEntity(LanguageMigrationRules_ord, "LanguageMigrationRules", LanguageMigrationRules.class, false, LanguageMigrationRule_ord, true, false);
        putSimpleEntity(LanguageMigrationRule_ord, "LanguageMigrationRule", LanguageMigrationRule.class, true, MigrateEntityPattern_ord, MigrateEntity_ord);
        putSimpleEntity(MigrateEntityPattern_ord, "MigrateEntityPattern", MigrateEntityPattern.class, false).withFeature(MigrationsFeatureDescriptorEnum.source, Expression_ord).withFeature(MigrationsFeatureDescriptorEnum.target, Expression_ord);
        putSimpleEntity(MigrateEntity_ord, "MigrateEntity", MigrateEntity.class, false).withFeature(MigrationsFeatureDescriptorEnum.source, TypeTest_ord).withFeature(MigrationsFeatureDescriptorEnum.target, TypeTest_ord).withFeature(MigrationsFeatureDescriptorEnum.rules, EntityMigrationRules_ord, true, false, false, false, false).withFeature(MigrationsFeatureDescriptorEnum.when, Expression_ord, true, false, false, false, false);
        putSimpleEntity(EntityMigrationRules_ord, "EntityMigrationRules", EntityMigrationRules.class, true, MigrateFeatures_ord);
        putCompositeEntity(MigrateFeatures_ord, "MigrateFeatures", MigrateFeatures.class, false, MigrateFeature_ord, true, false);
        putSimpleEntity(MigrateFeature_ord, "MigrateFeature", MigrateFeature.class, false).withFeature(MigrationsFeatureDescriptorEnum.source, Expression_ord).withFeature(MigrationsFeatureDescriptorEnum.target, FeatureStep_ord);
        putSimpleEntity(MigratePath_ord, "MigratePath", MigratePath.class, false).withFeature(MigrationsFeatureDescriptorEnum.path, Expression_ord);
        putSimpleEntity(Source_ord, "Source", Source.class, false);
        putSimpleEntity(Target_ord, "Target", Target.class, false);
        putSimpleEntity(FeatureReference_ord, "FeatureReference", FeatureReference.class, false).withFeature(MigrationsFeatureDescriptorEnum.feature, FeatureStep_ord);
        putSimpleEntity(TypeTest_ord, "TypeTest", TypeTest.class, true);
        putSimpleEntity(Label_ord, "Label", Label.class, true);
        putSimpleEntity(MigrationRule_ord, "MigrationRule", MigrationRule.class, true, MigrateEntityPattern_ord, MigrateEntity_ord, MigrateLanguage_ord, LanguageMigrationRule_ord, MigratePatternLanguage_ord);
        putSimpleEntity(Registry_ord, "Registry", Registry.class, true);
        putSimpleEntity(URI_ord, "URI", URI.class, true);
        putSimpleEntity(Namespace_ord, "Namespace", Namespace.class, true);
        putSimpleEntity(Name_ord, "Name", Name.class, true);
        putSimpleEntity(FeatureStep_ord, "FeatureStep", FeatureStep.class, true);
        putSimpleEntity(Expression_ord, "Expression", Expression.class, true, Target_ord, MigratePath_ord, Source_ord, FeatureReference_ord);
        putSimpleEntity(LanguageTest_ord, "LanguageTest", LanguageTest.class, true);
        putSimpleEntity(Workspace_ord, "Workspace", Workspace.class, true);
    }

    protected void initForeignTypeRelations() {
        setAliasOf(true, "http://lang.whole.org/Semantics#URI", URI_ord);
        setAliasOf(true, "http://lang.whole.org/Semantics#Namespace", Namespace_ord);
        setAliasOf(true, "http://lang.whole.org/Semantics#Name", Name_ord);
        setAliasOf(true, "http://lang.whole.org/Artifacts#Workspace", Workspace_ord);
        setAliasOf(true, "http://lang.whole.org/Actions#Label", Label_ord);
        setAliasOf(true, "whole:org.whole.lang.patterns:PatternsModel#URI", URI_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#LanguageTest", LanguageTest_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#Registry", Registry_ord);
        setAssignableFromForeignType(true, "http://lang.whole.org/Queries#Expression", LanguageMigrationRule_ord, EntityMigrationRules_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#Expression", Expression_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#TypeTest", TypeTest_ord);
        setAliasOf(true, "http://lang.whole.org/Queries#FeatureStep", FeatureStep_ord);
    }
}
