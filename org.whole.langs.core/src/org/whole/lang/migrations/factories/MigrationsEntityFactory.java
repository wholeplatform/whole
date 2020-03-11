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
package org.whole.lang.migrations.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.migrations.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.migrations.reflect.MigrationsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class MigrationsEntityFactory extends GenericEntityFactory {
    public static final MigrationsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static MigrationsEntityFactory instance(IEntityRegistryProvider provider) {
        return new MigrationsEntityFactory(provider);
    }

    protected MigrationsEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public MigrationFrame createMigrationFrame() {
        return create(MigrationsEntityDescriptorEnum.MigrationFrame);
    }

    public MigrationFrame createMigrationFrame(URI uri, Namespace namespace, Name name, Workspace artifacts, MigrationRules rules) {
        return create(MigrationsEntityDescriptorEnum.MigrationFrame, uri, namespace, name, artifacts, rules);
    }

    public IEntityBuilder<MigrationFrame> buildMigrationFrame() {
        return new EntityBuilder<MigrationFrame>(create(MigrationsEntityDescriptorEnum.MigrationFrame));
    }

    public Library createLibrary() {
        return create(MigrationsEntityDescriptorEnum.Library);
    }

    public Library createLibrary(URI uri, Namespace namespace, Name name, MigrationFunctions functions) {
        return create(MigrationsEntityDescriptorEnum.Library, uri, namespace, name, functions);
    }

    public IEntityBuilder<Library> buildLibrary() {
        return new EntityBuilder<Library>(create(MigrationsEntityDescriptorEnum.Library));
    }

    public MigrationFunctions createMigrationFunctions() {
        return create(MigrationsEntityDescriptorEnum.MigrationFunctions);
    }

    public MigrationFunctions createMigrationFunctions(MigrationFunction... entities) {
        return create(MigrationsEntityDescriptorEnum.MigrationFunctions, (IEntity[]) entities);
    }

    public MigrationFunctions createMigrationFunctions(int initialSize) {
        return clone(MigrationsEntityDescriptorEnum.MigrationFunctions, initialSize);
    }

    public MigrationFunction createMigrationFunction() {
        return create(MigrationsEntityDescriptorEnum.MigrationFunction);
    }

    public MigrationFunction createMigrationFunction(Label label, Name name, MigrationRules rules) {
        return create(MigrationsEntityDescriptorEnum.MigrationFunction, label, name, rules);
    }

    public IEntityBuilder<MigrationFunction> buildMigrationFunction() {
        return new EntityBuilder<MigrationFunction>(create(MigrationsEntityDescriptorEnum.MigrationFunction));
    }

    public MigrationRules createMigrationRules() {
        return create(MigrationsEntityDescriptorEnum.MigrationRules);
    }

    public MigrationRules createMigrationRules(MigrationRule... entities) {
        return create(MigrationsEntityDescriptorEnum.MigrationRules, (IEntity[]) entities);
    }

    public MigrationRules createMigrationRules(int initialSize) {
        return clone(MigrationsEntityDescriptorEnum.MigrationRules, initialSize);
    }

    public MigratePatternLanguage createMigratePatternLanguage() {
        return create(MigrationsEntityDescriptorEnum.MigratePatternLanguage);
    }

    public MigratePatternLanguage createMigratePatternLanguage(URI source, URI target, LanguageMigrationRules rules) {
        return create(MigrationsEntityDescriptorEnum.MigratePatternLanguage, source, target, rules);
    }

    public IEntityBuilder<MigratePatternLanguage> buildMigratePatternLanguage() {
        return new EntityBuilder<MigratePatternLanguage>(create(MigrationsEntityDescriptorEnum.MigratePatternLanguage));
    }

    public MigrateLanguage createMigrateLanguage() {
        return create(MigrationsEntityDescriptorEnum.MigrateLanguage);
    }

    public MigrateLanguage createMigrateLanguage(LanguageTest source, LanguageTest target, LanguageMigrationRules rules, Registry registry) {
        return create(MigrationsEntityDescriptorEnum.MigrateLanguage, source, target, rules, registry);
    }

    public IEntityBuilder<MigrateLanguage> buildMigrateLanguage() {
        return new EntityBuilder<MigrateLanguage>(create(MigrationsEntityDescriptorEnum.MigrateLanguage));
    }

    public LanguageMigrationRules createLanguageMigrationRules() {
        return create(MigrationsEntityDescriptorEnum.LanguageMigrationRules);
    }

    public LanguageMigrationRules createLanguageMigrationRules(LanguageMigrationRule... entities) {
        return create(MigrationsEntityDescriptorEnum.LanguageMigrationRules, (IEntity[]) entities);
    }

    public LanguageMigrationRules createLanguageMigrationRules(int initialSize) {
        return clone(MigrationsEntityDescriptorEnum.LanguageMigrationRules, initialSize);
    }

    public MigrateEntityPattern createMigrateEntityPattern() {
        return create(MigrationsEntityDescriptorEnum.MigrateEntityPattern);
    }

    public MigrateEntityPattern createMigrateEntityPattern(Expression source, Expression target) {
        return create(MigrationsEntityDescriptorEnum.MigrateEntityPattern, source, target);
    }

    public IEntityBuilder<MigrateEntityPattern> buildMigrateEntityPattern() {
        return new EntityBuilder<MigrateEntityPattern>(create(MigrationsEntityDescriptorEnum.MigrateEntityPattern));
    }

    public MigrateEntity createMigrateEntity() {
        return create(MigrationsEntityDescriptorEnum.MigrateEntity);
    }

    public MigrateEntity createMigrateEntity(TypeTest source, TypeTest target, EntityMigrationRules rules, Expression when) {
        return create(MigrationsEntityDescriptorEnum.MigrateEntity, source, target, rules, when);
    }

    public IEntityBuilder<MigrateEntity> buildMigrateEntity() {
        return new EntityBuilder<MigrateEntity>(create(MigrationsEntityDescriptorEnum.MigrateEntity));
    }

    public MigrateFeatures createMigrateFeatures() {
        return create(MigrationsEntityDescriptorEnum.MigrateFeatures);
    }

    public MigrateFeatures createMigrateFeatures(MigrateFeature... entities) {
        return create(MigrationsEntityDescriptorEnum.MigrateFeatures, (IEntity[]) entities);
    }

    public MigrateFeatures createMigrateFeatures(int initialSize) {
        return clone(MigrationsEntityDescriptorEnum.MigrateFeatures, initialSize);
    }

    public MigrateFeature createMigrateFeature() {
        return create(MigrationsEntityDescriptorEnum.MigrateFeature);
    }

    public MigrateFeature createMigrateFeature(Expression source, FeatureStep target) {
        return create(MigrationsEntityDescriptorEnum.MigrateFeature, source, target);
    }

    public IEntityBuilder<MigrateFeature> buildMigrateFeature() {
        return new EntityBuilder<MigrateFeature>(create(MigrationsEntityDescriptorEnum.MigrateFeature));
    }

    public MigratePath createMigratePath() {
        return create(MigrationsEntityDescriptorEnum.MigratePath);
    }

    public MigratePath createMigratePath(Expression path) {
        return create(MigrationsEntityDescriptorEnum.MigratePath, path);
    }

    public Source createSource() {
        return create(MigrationsEntityDescriptorEnum.Source);
    }

    public Target createTarget() {
        return create(MigrationsEntityDescriptorEnum.Target);
    }

    public FeatureReference createFeatureReference() {
        return create(MigrationsEntityDescriptorEnum.FeatureReference);
    }

    public FeatureReference createFeatureReference(FeatureStep feature) {
        return create(MigrationsEntityDescriptorEnum.FeatureReference, feature);
    }
}
