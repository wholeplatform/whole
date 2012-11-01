package org.whole.lang.xsd.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.xsd.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.xsd.reflect.XsdEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class XsdEntityFactory extends GenericEntityFactory {
	public static final XsdEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static XsdEntityFactory instance(IEntityRegistryProvider provider) {
		return new XsdEntityFactory(provider);
	}

	protected XsdEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Schema createSchema() {
		return create(XsdEntityDescriptorEnum.Schema);
	}

	public Schema createSchema(NamespaceDecls namespaces, StringData id,
			Attributes attributes, AnyURI targetNamespace, StringData version,
			XMLLanguageType language, Qualify attributeFormDefault,
			Qualify elementFormDefault, DerivationSet blockDefault,
			DerivationSet finalDefault, SchemaDirectives directives,
			SchemaComponents components) {
		return create(XsdEntityDescriptorEnum.Schema, namespaces, id,
				attributes, targetNamespace, version, language,
				attributeFormDefault, elementFormDefault, blockDefault,
				finalDefault, directives, components);
	}

	public IEntityBuilder<Schema> buildSchema() {
		return new EntityBuilder<Schema>(create(XsdEntityDescriptorEnum.Schema));
	}

	public SchemaDirectives createSchemaDirectives() {
		return create(XsdEntityDescriptorEnum.SchemaDirectives);
	}

	public SchemaDirectives createSchemaDirectives(SchemaDirective... entities) {
		return create(XsdEntityDescriptorEnum.SchemaDirectives,
				(IEntity[]) entities);
	}

	public SchemaDirectives createSchemaDirectives(int initialSize) {
		return clone(XsdEntityDescriptorEnum.SchemaDirectives, initialSize);
	}

	public Include createInclude() {
		return create(XsdEntityDescriptorEnum.Include);
	}

	public Include createInclude(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Annotation annotation, AnyURI schemaLocation) {
		return create(XsdEntityDescriptorEnum.Include, namespaces, id,
				attributes, annotation, schemaLocation);
	}

	public IEntityBuilder<Include> buildInclude() {
		return new EntityBuilder<Include>(
				create(XsdEntityDescriptorEnum.Include));
	}

	public Redefine createRedefine() {
		return create(XsdEntityDescriptorEnum.Redefine);
	}

	public Redefine createRedefine(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Annotation annotation,
			AnyURI schemaLocation, RedefineComponents definitions) {
		return create(XsdEntityDescriptorEnum.Redefine, namespaces, id,
				attributes, annotation, schemaLocation, definitions);
	}

	public IEntityBuilder<Redefine> buildRedefine() {
		return new EntityBuilder<Redefine>(
				create(XsdEntityDescriptorEnum.Redefine));
	}

	public RedefineComponents createRedefineComponents() {
		return create(XsdEntityDescriptorEnum.RedefineComponents);
	}

	public RedefineComponents createRedefineComponents(
			RedefineComponent... entities) {
		return create(XsdEntityDescriptorEnum.RedefineComponents,
				(IEntity[]) entities);
	}

	public RedefineComponents createRedefineComponents(int initialSize) {
		return clone(XsdEntityDescriptorEnum.RedefineComponents, initialSize);
	}

	public Import createImport() {
		return create(XsdEntityDescriptorEnum.Import);
	}

	public Import createImport(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Annotation annotation, AnyURI namespace,
			AnyURI schemaLocation) {
		return create(XsdEntityDescriptorEnum.Import, namespaces, id,
				attributes, annotation, namespace, schemaLocation);
	}

	public IEntityBuilder<Import> buildImport() {
		return new EntityBuilder<Import>(create(XsdEntityDescriptorEnum.Import));
	}

	public Annotation createAnnotation() {
		return create(XsdEntityDescriptorEnum.Annotation);
	}

	public Annotation createAnnotation(NamespaceDecls namespaces,
			StringData id, Attributes attributes, AnnotationList list) {
		return create(XsdEntityDescriptorEnum.Annotation, namespaces, id,
				attributes, list);
	}

	public IEntityBuilder<Annotation> buildAnnotation() {
		return new EntityBuilder<Annotation>(
				create(XsdEntityDescriptorEnum.Annotation));
	}

	public AnnotationList createAnnotationList() {
		return create(XsdEntityDescriptorEnum.AnnotationList);
	}

	public AnnotationList createAnnotationList(AnnotationType... entities) {
		return create(XsdEntityDescriptorEnum.AnnotationList,
				(IEntity[]) entities);
	}

	public AnnotationList createAnnotationList(int initialSize) {
		return clone(XsdEntityDescriptorEnum.AnnotationList, initialSize);
	}

	public Appinfo createAppinfo() {
		return create(XsdEntityDescriptorEnum.Appinfo);
	}

	public Appinfo createAppinfo(NamespaceDecls namespaces, StringData id,
			Attributes attributes, AnyURI source, AnnotationContents content) {
		return create(XsdEntityDescriptorEnum.Appinfo, namespaces, id,
				attributes, source, content);
	}

	public IEntityBuilder<Appinfo> buildAppinfo() {
		return new EntityBuilder<Appinfo>(
				create(XsdEntityDescriptorEnum.Appinfo));
	}

	public Documentation createDocumentation() {
		return create(XsdEntityDescriptorEnum.Documentation);
	}

	public Documentation createDocumentation(NamespaceDecls namespaces,
			StringData id, Attributes attributes, AnyURI source,
			XMLLanguageType language, AnnotationContents content) {
		return create(XsdEntityDescriptorEnum.Documentation, namespaces, id,
				attributes, source, language, content);
	}

	public IEntityBuilder<Documentation> buildDocumentation() {
		return new EntityBuilder<Documentation>(
				create(XsdEntityDescriptorEnum.Documentation));
	}

	public AnnotationContents createAnnotationContents() {
		return create(XsdEntityDescriptorEnum.AnnotationContents);
	}

	public AnnotationContents createAnnotationContents(
			AnnotationContent... entities) {
		return create(XsdEntityDescriptorEnum.AnnotationContents,
				(IEntity[]) entities);
	}

	public AnnotationContents createAnnotationContents(int initialSize) {
		return clone(XsdEntityDescriptorEnum.AnnotationContents, initialSize);
	}

	public SchemaComponents createSchemaComponents() {
		return create(XsdEntityDescriptorEnum.SchemaComponents);
	}

	public SchemaComponents createSchemaComponents(SchemaComponent... entities) {
		return create(XsdEntityDescriptorEnum.SchemaComponents,
				(IEntity[]) entities);
	}

	public SchemaComponents createSchemaComponents(int initialSize) {
		return clone(XsdEntityDescriptorEnum.SchemaComponents, initialSize);
	}

	public NotationDecl createNotationDecl() {
		return create(XsdEntityDescriptorEnum.NotationDecl);
	}

	public NotationDecl createNotationDecl(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name,
			StringData _public, AnyURI system, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.NotationDecl, namespaces, id,
				attributes, name, _public, system, annotation);
	}

	public IEntityBuilder<NotationDecl> buildNotationDecl() {
		return new EntityBuilder<NotationDecl>(
				create(XsdEntityDescriptorEnum.NotationDecl));
	}

	public ElementDecl createElementDecl() {
		return create(XsdEntityDescriptorEnum.ElementDecl);
	}

	public ElementDecl createElementDecl(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name, Bounded minOccurs,
			Occurrence maxOccurs, QName type, BooleanData _abstract,
			BooleanData nillable, StringData defaultValue,
			StringData fixedValue, Qualify form, DerivationSet block,
			DerivationSet _final, QName substitutionGroup,
			Annotation annotation, TypeDef typeDef,
			IdentityConstraintDefs identityConstraintDefs) {
		return create(XsdEntityDescriptorEnum.ElementDecl, namespaces, id,
				attributes, name, minOccurs, maxOccurs, type, _abstract,
				nillable, defaultValue, fixedValue, form, block, _final,
				substitutionGroup, annotation, typeDef, identityConstraintDefs);
	}

	public IEntityBuilder<ElementDecl> buildElementDecl() {
		return new EntityBuilder<ElementDecl>(
				create(XsdEntityDescriptorEnum.ElementDecl));
	}

	public ElementRef createElementRef() {
		return create(XsdEntityDescriptorEnum.ElementRef);
	}

	public ElementRef createElementRef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Bounded minOccurs,
			Occurrence maxOccurs, QName ref, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.ElementRef, namespaces, id,
				attributes, minOccurs, maxOccurs, ref, annotation);
	}

	public IEntityBuilder<ElementRef> buildElementRef() {
		return new EntityBuilder<ElementRef>(
				create(XsdEntityDescriptorEnum.ElementRef));
	}

	public IdentityConstraintDefs createIdentityConstraintDefs() {
		return create(XsdEntityDescriptorEnum.IdentityConstraintDefs);
	}

	public IdentityConstraintDefs createIdentityConstraintDefs(
			IdentityConstraintDef... entities) {
		return create(XsdEntityDescriptorEnum.IdentityConstraintDefs,
				(IEntity[]) entities);
	}

	public IdentityConstraintDefs createIdentityConstraintDefs(int initialSize) {
		return clone(XsdEntityDescriptorEnum.IdentityConstraintDefs,
				initialSize);
	}

	public Fields createFields() {
		return create(XsdEntityDescriptorEnum.Fields);
	}

	public Fields createFields(Field... entities) {
		return create(XsdEntityDescriptorEnum.Fields, (IEntity[]) entities);
	}

	public Fields createFields(int initialSize) {
		return clone(XsdEntityDescriptorEnum.Fields, initialSize);
	}

	public Selector createSelector() {
		return create(XsdEntityDescriptorEnum.Selector);
	}

	public Selector createSelector(NamespaceDecls namespaces, StringData id,
			Attributes attributes, XPath xpath, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.Selector, namespaces, id,
				attributes, xpath, annotation);
	}

	public IEntityBuilder<Selector> buildSelector() {
		return new EntityBuilder<Selector>(
				create(XsdEntityDescriptorEnum.Selector));
	}

	public Field createField() {
		return create(XsdEntityDescriptorEnum.Field);
	}

	public Field createField(NamespaceDecls namespaces, StringData id,
			Attributes attributes, XPath xpath, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.Field, namespaces, id,
				attributes, xpath, annotation);
	}

	public IEntityBuilder<Field> buildField() {
		return new EntityBuilder<Field>(create(XsdEntityDescriptorEnum.Field));
	}

	public Unique createUnique() {
		return create(XsdEntityDescriptorEnum.Unique);
	}

	public Unique createUnique(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Name name, Annotation annotation,
			Selector selector, Fields fields) {
		return create(XsdEntityDescriptorEnum.Unique, namespaces, id,
				attributes, name, annotation, selector, fields);
	}

	public IEntityBuilder<Unique> buildUnique() {
		return new EntityBuilder<Unique>(create(XsdEntityDescriptorEnum.Unique));
	}

	public Key createKey() {
		return create(XsdEntityDescriptorEnum.Key);
	}

	public Key createKey(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Name name, Annotation annotation,
			Selector selector, Fields fields) {
		return create(XsdEntityDescriptorEnum.Key, namespaces, id, attributes,
				name, annotation, selector, fields);
	}

	public IEntityBuilder<Key> buildKey() {
		return new EntityBuilder<Key>(create(XsdEntityDescriptorEnum.Key));
	}

	public Keyref createKeyref() {
		return create(XsdEntityDescriptorEnum.Keyref);
	}

	public Keyref createKeyref(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Name name, QName refer,
			Annotation annotation, Selector selector, Fields fields) {
		return create(XsdEntityDescriptorEnum.Keyref, namespaces, id,
				attributes, name, refer, annotation, selector, fields);
	}

	public IEntityBuilder<Keyref> buildKeyref() {
		return new EntityBuilder<Keyref>(create(XsdEntityDescriptorEnum.Keyref));
	}

	public SimpleTypeDefs createSimpleTypeDefs() {
		return create(XsdEntityDescriptorEnum.SimpleTypeDefs);
	}

	public SimpleTypeDefs createSimpleTypeDefs(SimpleTypeDef... entities) {
		return create(XsdEntityDescriptorEnum.SimpleTypeDefs,
				(IEntity[]) entities);
	}

	public SimpleTypeDefs createSimpleTypeDefs(int initialSize) {
		return clone(XsdEntityDescriptorEnum.SimpleTypeDefs, initialSize);
	}

	public SimpleTypeDef createSimpleTypeDef() {
		return create(XsdEntityDescriptorEnum.SimpleTypeDef);
	}

	public SimpleTypeDef createSimpleTypeDef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name,
			DerivationSet _final, Annotation annotation,
			SimpleTypeContent content) {
		return create(XsdEntityDescriptorEnum.SimpleTypeDef, namespaces, id,
				attributes, name, _final, annotation, content);
	}

	public IEntityBuilder<SimpleTypeDef> buildSimpleTypeDef() {
		return new EntityBuilder<SimpleTypeDef>(
				create(XsdEntityDescriptorEnum.SimpleTypeDef));
	}

	public ComplexTypeDef createComplexTypeDef() {
		return create(XsdEntityDescriptorEnum.ComplexTypeDef);
	}

	public ComplexTypeDef createComplexTypeDef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name,
			DerivationSet _final, BooleanData _abstract, BooleanData mixed,
			DerivationSet block, Annotation annotation,
			ComplexTypeContent content) {
		return create(XsdEntityDescriptorEnum.ComplexTypeDef, namespaces, id,
				attributes, name, _final, _abstract, mixed, block, annotation,
				content);
	}

	public IEntityBuilder<ComplexTypeDef> buildComplexTypeDef() {
		return new EntityBuilder<ComplexTypeDef>(
				create(XsdEntityDescriptorEnum.ComplexTypeDef));
	}

	public AttributeDecl createAttributeDecl() {
		return create(XsdEntityDescriptorEnum.AttributeDecl);
	}

	public AttributeDecl createAttributeDecl(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name, QName simpleType,
			StringData defaultValue, StringData fixedValue,
			Annotation annotation, SimpleTypeDef simpleTypeDef) {
		return create(XsdEntityDescriptorEnum.AttributeDecl, namespaces, id,
				attributes, name, simpleType, defaultValue, fixedValue,
				annotation, simpleTypeDef);
	}

	public IEntityBuilder<AttributeDecl> buildAttributeDecl() {
		return new EntityBuilder<AttributeDecl>(
				create(XsdEntityDescriptorEnum.AttributeDecl));
	}

	public AttributeUseOrGroups createAttributeUseOrGroups() {
		return create(XsdEntityDescriptorEnum.AttributeUseOrGroups);
	}

	public AttributeUseOrGroups createAttributeUseOrGroups(
			AttributeUseOrGroup... entities) {
		return create(XsdEntityDescriptorEnum.AttributeUseOrGroups,
				(IEntity[]) entities);
	}

	public AttributeUseOrGroups createAttributeUseOrGroups(int initialSize) {
		return clone(XsdEntityDescriptorEnum.AttributeUseOrGroups, initialSize);
	}

	public AttributeUseDecl createAttributeUseDecl() {
		return create(XsdEntityDescriptorEnum.AttributeUseDecl);
	}

	public AttributeUseDecl createAttributeUseDecl(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name, QName simpleType,
			Use use, Qualify form, StringData defaultValue,
			StringData fixedValue, Annotation annotation,
			SimpleTypeDef simpleTypeDef) {
		return create(XsdEntityDescriptorEnum.AttributeUseDecl, namespaces, id,
				attributes, name, simpleType, use, form, defaultValue,
				fixedValue, annotation, simpleTypeDef);
	}

	public IEntityBuilder<AttributeUseDecl> buildAttributeUseDecl() {
		return new EntityBuilder<AttributeUseDecl>(
				create(XsdEntityDescriptorEnum.AttributeUseDecl));
	}

	public AttributeUseRef createAttributeUseRef() {
		return create(XsdEntityDescriptorEnum.AttributeUseRef);
	}

	public AttributeUseRef createAttributeUseRef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, QName ref, Use use,
			Qualify form, StringData defaultValue, StringData fixedValue,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.AttributeUseRef, namespaces, id,
				attributes, ref, use, form, defaultValue, fixedValue,
				annotation);
	}

	public IEntityBuilder<AttributeUseRef> buildAttributeUseRef() {
		return new EntityBuilder<AttributeUseRef>(
				create(XsdEntityDescriptorEnum.AttributeUseRef));
	}

	public AnyAttribute createAnyAttribute() {
		return create(XsdEntityDescriptorEnum.AnyAttribute);
	}

	public AnyAttribute createAnyAttribute(NamespaceDecls namespaces,
			StringData id, Attributes attributes,
			NamespaceSpecs namespaceSpecs, ProcessContents processContents,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.AnyAttribute, namespaces, id,
				attributes, namespaceSpecs, processContents, annotation);
	}

	public IEntityBuilder<AnyAttribute> buildAnyAttribute() {
		return new EntityBuilder<AnyAttribute>(
				create(XsdEntityDescriptorEnum.AnyAttribute));
	}

	public AttributeGroupDef createAttributeGroupDef() {
		return create(XsdEntityDescriptorEnum.AttributeGroupDef);
	}

	public AttributeGroupDef createAttributeGroupDef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name,
			Annotation annotation, AttributeUseOrGroups attributeUses,
			AnyAttribute anyAttribute) {
		return create(XsdEntityDescriptorEnum.AttributeGroupDef, namespaces,
				id, attributes, name, annotation, attributeUses, anyAttribute);
	}

	public IEntityBuilder<AttributeGroupDef> buildAttributeGroupDef() {
		return new EntityBuilder<AttributeGroupDef>(
				create(XsdEntityDescriptorEnum.AttributeGroupDef));
	}

	public AttributeGroupRef createAttributeGroupRef() {
		return create(XsdEntityDescriptorEnum.AttributeGroupRef);
	}

	public AttributeGroupRef createAttributeGroupRef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, QName ref,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.AttributeGroupRef, namespaces,
				id, attributes, ref, annotation);
	}

	public IEntityBuilder<AttributeGroupRef> buildAttributeGroupRef() {
		return new EntityBuilder<AttributeGroupRef>(
				create(XsdEntityDescriptorEnum.AttributeGroupRef));
	}

	public ModelGroupDef createModelGroupDef() {
		return create(XsdEntityDescriptorEnum.ModelGroupDef);
	}

	public ModelGroupDef createModelGroupDef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Name name,
			Annotation annotation, ModelGroup modelGroup) {
		return create(XsdEntityDescriptorEnum.ModelGroupDef, namespaces, id,
				attributes, name, annotation, modelGroup);
	}

	public IEntityBuilder<ModelGroupDef> buildModelGroupDef() {
		return new EntityBuilder<ModelGroupDef>(
				create(XsdEntityDescriptorEnum.ModelGroupDef));
	}

	public ModelGroupRef createModelGroupRef() {
		return create(XsdEntityDescriptorEnum.ModelGroupRef);
	}

	public ModelGroupRef createModelGroupRef(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Bounded minOccurs,
			Occurrence maxOccurs, QName ref, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.ModelGroupRef, namespaces, id,
				attributes, minOccurs, maxOccurs, ref, annotation);
	}

	public IEntityBuilder<ModelGroupRef> buildModelGroupRef() {
		return new EntityBuilder<ModelGroupRef>(
				create(XsdEntityDescriptorEnum.ModelGroupRef));
	}

	public Particles createParticles() {
		return create(XsdEntityDescriptorEnum.Particles);
	}

	public Particles createParticles(Particle... entities) {
		return create(XsdEntityDescriptorEnum.Particles, (IEntity[]) entities);
	}

	public Particles createParticles(int initialSize) {
		return clone(XsdEntityDescriptorEnum.Particles, initialSize);
	}

	public List createList() {
		return create(XsdEntityDescriptorEnum.List);
	}

	public List createList(NamespaceDecls namespaces, StringData id,
			Attributes attributes, QName itemType, Annotation annotation,
			SimpleTypeDef itemTypeDef) {
		return create(XsdEntityDescriptorEnum.List, namespaces, id, attributes,
				itemType, annotation, itemTypeDef);
	}

	public IEntityBuilder<List> buildList() {
		return new EntityBuilder<List>(create(XsdEntityDescriptorEnum.List));
	}

	public Union createUnion() {
		return create(XsdEntityDescriptorEnum.Union);
	}

	public Union createUnion(NamespaceDecls namespaces, StringData id,
			Attributes attributes, MemberTypes memberTypes,
			Annotation annotation, SimpleTypeDefs memberTypesDefs) {
		return create(XsdEntityDescriptorEnum.Union, namespaces, id,
				attributes, memberTypes, annotation, memberTypesDefs);
	}

	public IEntityBuilder<Union> buildUnion() {
		return new EntityBuilder<Union>(create(XsdEntityDescriptorEnum.Union));
	}

	public SimpleTypeRestriction createSimpleTypeRestriction() {
		return create(XsdEntityDescriptorEnum.SimpleTypeRestriction);
	}

	public SimpleTypeRestriction createSimpleTypeRestriction(
			NamespaceDecls namespaces, StringData id, Attributes attributes,
			QName base, Annotation annotation, SimpleTypeDef baseDef,
			Facets facets) {
		return create(XsdEntityDescriptorEnum.SimpleTypeRestriction,
				namespaces, id, attributes, base, annotation, baseDef, facets);
	}

	public IEntityBuilder<SimpleTypeRestriction> buildSimpleTypeRestriction() {
		return new EntityBuilder<SimpleTypeRestriction>(
				create(XsdEntityDescriptorEnum.SimpleTypeRestriction));
	}

	public Facets createFacets() {
		return create(XsdEntityDescriptorEnum.Facets);
	}

	public Facets createFacets(Facet... entities) {
		return create(XsdEntityDescriptorEnum.Facets, (IEntity[]) entities);
	}

	public Facets createFacets(int initialSize) {
		return clone(XsdEntityDescriptorEnum.Facets, initialSize);
	}

	public WhiteSpace createWhiteSpace() {
		return create(XsdEntityDescriptorEnum.WhiteSpace);
	}

	public WhiteSpace createWhiteSpace(NamespaceDecls namespaces,
			StringData id, Attributes attributes, BooleanData fixed,
			WhiteSpaceProcessing value, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.WhiteSpace, namespaces, id,
				attributes, fixed, value, annotation);
	}

	public IEntityBuilder<WhiteSpace> buildWhiteSpace() {
		return new EntityBuilder<WhiteSpace>(
				create(XsdEntityDescriptorEnum.WhiteSpace));
	}

	public Length createLength() {
		return create(XsdEntityDescriptorEnum.Length);
	}

	public Length createLength(NamespaceDecls namespaces, StringData id,
			Attributes attributes, BooleanData fixed, IntegerData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.Length, namespaces, id,
				attributes, fixed, value, annotation);
	}

	public IEntityBuilder<Length> buildLength() {
		return new EntityBuilder<Length>(create(XsdEntityDescriptorEnum.Length));
	}

	public MinLength createMinLength() {
		return create(XsdEntityDescriptorEnum.MinLength);
	}

	public MinLength createMinLength(NamespaceDecls namespaces, StringData id,
			Attributes attributes, BooleanData fixed, IntegerData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.MinLength, namespaces, id,
				attributes, fixed, value, annotation);
	}

	public IEntityBuilder<MinLength> buildMinLength() {
		return new EntityBuilder<MinLength>(
				create(XsdEntityDescriptorEnum.MinLength));
	}

	public MaxLength createMaxLength() {
		return create(XsdEntityDescriptorEnum.MaxLength);
	}

	public MaxLength createMaxLength(NamespaceDecls namespaces, StringData id,
			Attributes attributes, BooleanData fixed, IntegerData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.MaxLength, namespaces, id,
				attributes, fixed, value, annotation);
	}

	public IEntityBuilder<MaxLength> buildMaxLength() {
		return new EntityBuilder<MaxLength>(
				create(XsdEntityDescriptorEnum.MaxLength));
	}

	public MinInclusive createMinInclusive() {
		return create(XsdEntityDescriptorEnum.MinInclusive);
	}

	public MinInclusive createMinInclusive(NamespaceDecls namespaces,
			StringData id, Attributes attributes, StringData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.MinInclusive, namespaces, id,
				attributes, value, annotation);
	}

	public IEntityBuilder<MinInclusive> buildMinInclusive() {
		return new EntityBuilder<MinInclusive>(
				create(XsdEntityDescriptorEnum.MinInclusive));
	}

	public MaxInclusive createMaxInclusive() {
		return create(XsdEntityDescriptorEnum.MaxInclusive);
	}

	public MaxInclusive createMaxInclusive(NamespaceDecls namespaces,
			StringData id, Attributes attributes, StringData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.MaxInclusive, namespaces, id,
				attributes, value, annotation);
	}

	public IEntityBuilder<MaxInclusive> buildMaxInclusive() {
		return new EntityBuilder<MaxInclusive>(
				create(XsdEntityDescriptorEnum.MaxInclusive));
	}

	public MinExclusive createMinExclusive() {
		return create(XsdEntityDescriptorEnum.MinExclusive);
	}

	public MinExclusive createMinExclusive(NamespaceDecls namespaces,
			StringData id, Attributes attributes, StringData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.MinExclusive, namespaces, id,
				attributes, value, annotation);
	}

	public IEntityBuilder<MinExclusive> buildMinExclusive() {
		return new EntityBuilder<MinExclusive>(
				create(XsdEntityDescriptorEnum.MinExclusive));
	}

	public MaxExclusive createMaxExclusive() {
		return create(XsdEntityDescriptorEnum.MaxExclusive);
	}

	public MaxExclusive createMaxExclusive(NamespaceDecls namespaces,
			StringData id, Attributes attributes, StringData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.MaxExclusive, namespaces, id,
				attributes, value, annotation);
	}

	public IEntityBuilder<MaxExclusive> buildMaxExclusive() {
		return new EntityBuilder<MaxExclusive>(
				create(XsdEntityDescriptorEnum.MaxExclusive));
	}

	public TotalDigits createTotalDigits() {
		return create(XsdEntityDescriptorEnum.TotalDigits);
	}

	public TotalDigits createTotalDigits(NamespaceDecls namespaces,
			StringData id, Attributes attributes, BooleanData fixed,
			IntegerData value, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.TotalDigits, namespaces, id,
				attributes, fixed, value, annotation);
	}

	public IEntityBuilder<TotalDigits> buildTotalDigits() {
		return new EntityBuilder<TotalDigits>(
				create(XsdEntityDescriptorEnum.TotalDigits));
	}

	public FractionDigits createFractionDigits() {
		return create(XsdEntityDescriptorEnum.FractionDigits);
	}

	public FractionDigits createFractionDigits(NamespaceDecls namespaces,
			StringData id, Attributes attributes, BooleanData fixed,
			IntegerData value, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.FractionDigits, namespaces, id,
				attributes, fixed, value, annotation);
	}

	public IEntityBuilder<FractionDigits> buildFractionDigits() {
		return new EntityBuilder<FractionDigits>(
				create(XsdEntityDescriptorEnum.FractionDigits));
	}

	public Pattern createPattern() {
		return create(XsdEntityDescriptorEnum.Pattern);
	}

	public Pattern createPattern(NamespaceDecls namespaces, StringData id,
			Attributes attributes, StringData value, Annotation annotation) {
		return create(XsdEntityDescriptorEnum.Pattern, namespaces, id,
				attributes, value, annotation);
	}

	public IEntityBuilder<Pattern> buildPattern() {
		return new EntityBuilder<Pattern>(
				create(XsdEntityDescriptorEnum.Pattern));
	}

	public Enumeration createEnumeration() {
		return create(XsdEntityDescriptorEnum.Enumeration);
	}

	public Enumeration createEnumeration(NamespaceDecls namespaces,
			StringData id, Attributes attributes, StringData value,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.Enumeration, namespaces, id,
				attributes, value, annotation);
	}

	public IEntityBuilder<Enumeration> buildEnumeration() {
		return new EntityBuilder<Enumeration>(
				create(XsdEntityDescriptorEnum.Enumeration));
	}

	public SimpleContent createSimpleContent() {
		return create(XsdEntityDescriptorEnum.SimpleContent);
	}

	public SimpleContent createSimpleContent(NamespaceDecls namespaces,
			StringData id, Attributes attributes, Annotation annotation,
			SimpleDerivation derivation) {
		return create(XsdEntityDescriptorEnum.SimpleContent, namespaces, id,
				attributes, annotation, derivation);
	}

	public IEntityBuilder<SimpleContent> buildSimpleContent() {
		return new EntityBuilder<SimpleContent>(
				create(XsdEntityDescriptorEnum.SimpleContent));
	}

	public ComplexRestriction createComplexRestriction() {
		return create(XsdEntityDescriptorEnum.ComplexRestriction);
	}

	public ComplexRestriction createComplexRestriction(
			NamespaceDecls namespaces, StringData id, Attributes attributes,
			QName base, Annotation annotation, DeclaredContent content) {
		return create(XsdEntityDescriptorEnum.ComplexRestriction, namespaces,
				id, attributes, base, annotation, content);
	}

	public IEntityBuilder<ComplexRestriction> buildComplexRestriction() {
		return new EntityBuilder<ComplexRestriction>(
				create(XsdEntityDescriptorEnum.ComplexRestriction));
	}

	public ComplexExtension createComplexExtension() {
		return create(XsdEntityDescriptorEnum.ComplexExtension);
	}

	public ComplexExtension createComplexExtension(NamespaceDecls namespaces,
			StringData id, Attributes attributes, QName base,
			Annotation annotation, DeclaredContent content) {
		return create(XsdEntityDescriptorEnum.ComplexExtension, namespaces, id,
				attributes, base, annotation, content);
	}

	public IEntityBuilder<ComplexExtension> buildComplexExtension() {
		return new EntityBuilder<ComplexExtension>(
				create(XsdEntityDescriptorEnum.ComplexExtension));
	}

	public SimpleRestriction createSimpleRestriction() {
		return create(XsdEntityDescriptorEnum.SimpleRestriction);
	}

	public SimpleRestriction createSimpleRestriction(NamespaceDecls namespaces,
			StringData id, Attributes attributes, QName base,
			Annotation annotation, SimpleTypeDef baseDef, Facets facets,
			AttributeUseOrGroups attributeUses, AnyAttribute anyAttribute) {
		return create(XsdEntityDescriptorEnum.SimpleRestriction, namespaces,
				id, attributes, base, annotation, baseDef, facets,
				attributeUses, anyAttribute);
	}

	public IEntityBuilder<SimpleRestriction> buildSimpleRestriction() {
		return new EntityBuilder<SimpleRestriction>(
				create(XsdEntityDescriptorEnum.SimpleRestriction));
	}

	public SimpleExtension createSimpleExtension() {
		return create(XsdEntityDescriptorEnum.SimpleExtension);
	}

	public SimpleExtension createSimpleExtension(NamespaceDecls namespaces,
			StringData id, Attributes attributes, QName base,
			Annotation annotation, AttributeUseOrGroups attributeUses,
			AnyAttribute anyAttribute) {
		return create(XsdEntityDescriptorEnum.SimpleExtension, namespaces, id,
				attributes, base, annotation, attributeUses, anyAttribute);
	}

	public IEntityBuilder<SimpleExtension> buildSimpleExtension() {
		return new EntityBuilder<SimpleExtension>(
				create(XsdEntityDescriptorEnum.SimpleExtension));
	}

	public ComplexContent createComplexContent() {
		return create(XsdEntityDescriptorEnum.ComplexContent);
	}

	public ComplexContent createComplexContent(NamespaceDecls namespaces,
			StringData id, Attributes attributes, BooleanData mixed,
			Annotation annotation, ComplexDerivation derivation) {
		return create(XsdEntityDescriptorEnum.ComplexContent, namespaces, id,
				attributes, mixed, annotation, derivation);
	}

	public IEntityBuilder<ComplexContent> buildComplexContent() {
		return new EntityBuilder<ComplexContent>(
				create(XsdEntityDescriptorEnum.ComplexContent));
	}

	public DeclaredContent createDeclaredContent() {
		return create(XsdEntityDescriptorEnum.DeclaredContent);
	}

	public DeclaredContent createDeclaredContent(ModelGroup modelGroup,
			AttributeUseOrGroups attributeUses, AnyAttribute anyAttribute) {
		return create(XsdEntityDescriptorEnum.DeclaredContent, modelGroup,
				attributeUses, anyAttribute);
	}

	public IEntityBuilder<DeclaredContent> buildDeclaredContent() {
		return new EntityBuilder<DeclaredContent>(
				create(XsdEntityDescriptorEnum.DeclaredContent));
	}

	public Sequence createSequence() {
		return create(XsdEntityDescriptorEnum.Sequence);
	}

	public Sequence createSequence(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Bounded minOccurs, Occurrence maxOccurs,
			Annotation annotation, Particles particles) {
		return create(XsdEntityDescriptorEnum.Sequence, namespaces, id,
				attributes, minOccurs, maxOccurs, annotation, particles);
	}

	public IEntityBuilder<Sequence> buildSequence() {
		return new EntityBuilder<Sequence>(
				create(XsdEntityDescriptorEnum.Sequence));
	}

	public Choice createChoice() {
		return create(XsdEntityDescriptorEnum.Choice);
	}

	public Choice createChoice(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Bounded minOccurs, Occurrence maxOccurs,
			Annotation annotation, Particles particles) {
		return create(XsdEntityDescriptorEnum.Choice, namespaces, id,
				attributes, minOccurs, maxOccurs, annotation, particles);
	}

	public IEntityBuilder<Choice> buildChoice() {
		return new EntityBuilder<Choice>(create(XsdEntityDescriptorEnum.Choice));
	}

	public All createAll() {
		return create(XsdEntityDescriptorEnum.All);
	}

	public All createAll(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Bounded minOccurs, Occurrence maxOccurs,
			Annotation annotation, Particles particles) {
		return create(XsdEntityDescriptorEnum.All, namespaces, id, attributes,
				minOccurs, maxOccurs, annotation, particles);
	}

	public IEntityBuilder<All> buildAll() {
		return new EntityBuilder<All>(create(XsdEntityDescriptorEnum.All));
	}

	public Any createAny() {
		return create(XsdEntityDescriptorEnum.Any);
	}

	public Any createAny(NamespaceDecls namespaces, StringData id,
			Attributes attributes, Bounded minOccurs, Occurrence maxOccurs,
			NamespaceSpecs namespaceSpecs, ProcessContents processContents,
			Annotation annotation) {
		return create(XsdEntityDescriptorEnum.Any, namespaces, id, attributes,
				minOccurs, maxOccurs, namespaceSpecs, processContents,
				annotation);
	}

	public IEntityBuilder<Any> buildAny() {
		return new EntityBuilder<Any>(create(XsdEntityDescriptorEnum.Any));
	}

	public Bounded createBounded() {
		return create(XsdEntityDescriptorEnum.Bounded);
	}

	public Bounded createBounded(int value) {
		return create(XsdEntityDescriptorEnum.Bounded, value);
	}

	public Unbounded createUnbounded() {
		return create(XsdEntityDescriptorEnum.Unbounded);
	}

	public MemberTypes createMemberTypes() {
		return create(XsdEntityDescriptorEnum.MemberTypes);
	}

	public MemberTypes createMemberTypes(QName... entities) {
		return create(XsdEntityDescriptorEnum.MemberTypes, (IEntity[]) entities);
	}

	public MemberTypes createMemberTypes(int initialSize) {
		return clone(XsdEntityDescriptorEnum.MemberTypes, initialSize);
	}

	public Name createName() {
		return create(XsdEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(XsdEntityDescriptorEnum.Name, value);
	}

	public QName createQName() {
		return create(XsdEntityDescriptorEnum.QName);
	}

	public QName createQName(String value) {
		return create(XsdEntityDescriptorEnum.QName, value);
	}

	public AnyURI createAnyURI() {
		return create(XsdEntityDescriptorEnum.AnyURI);
	}

	public AnyURI createAnyURI(String value) {
		return create(XsdEntityDescriptorEnum.AnyURI, value);
	}

	public NamespaceDecl createNamespaceDecl() {
		return create(XsdEntityDescriptorEnum.NamespaceDecl);
	}

	public NamespaceDecl createNamespaceDecl(Name prefix, AnyURI uri) {
		return create(XsdEntityDescriptorEnum.NamespaceDecl, prefix, uri);
	}

	public IEntityBuilder<NamespaceDecl> buildNamespaceDecl() {
		return new EntityBuilder<NamespaceDecl>(
				create(XsdEntityDescriptorEnum.NamespaceDecl));
	}

	public NamespaceDecls createNamespaceDecls() {
		return create(XsdEntityDescriptorEnum.NamespaceDecls);
	}

	public NamespaceDecls createNamespaceDecls(NamespaceDecl... entities) {
		return create(XsdEntityDescriptorEnum.NamespaceDecls,
				(IEntity[]) entities);
	}

	public NamespaceDecls createNamespaceDecls(int initialSize) {
		return clone(XsdEntityDescriptorEnum.NamespaceDecls, initialSize);
	}

	public Attributes createAttributes() {
		return create(XsdEntityDescriptorEnum.Attributes);
	}

	public Attributes createAttributes(Attribute... entities) {
		return create(XsdEntityDescriptorEnum.Attributes, (IEntity[]) entities);
	}

	public Attributes createAttributes(int initialSize) {
		return clone(XsdEntityDescriptorEnum.Attributes, initialSize);
	}

	public ProcessContents createProcessContents() {
		return create(XsdEntityDescriptorEnum.ProcessContents);
	}

	public ProcessContents createProcessContents(ProcessContentsEnum.Value value) {
		return create(XsdEntityDescriptorEnum.ProcessContents, value);
	}

	public AnyNamespaceSpecs createAnyNamespaceSpecs() {
		return create(XsdEntityDescriptorEnum.AnyNamespaceSpecs);
	}

	public OtherNamespaceSpecs createOtherNamespaceSpecs() {
		return create(XsdEntityDescriptorEnum.OtherNamespaceSpecs);
	}

	public NamespaceSpecsList createNamespaceSpecsList() {
		return create(XsdEntityDescriptorEnum.NamespaceSpecsList);
	}

	public NamespaceSpecsList createNamespaceSpecsList(
			NamespaceSpec... entities) {
		return create(XsdEntityDescriptorEnum.NamespaceSpecsList,
				(IEntity[]) entities);
	}

	public NamespaceSpecsList createNamespaceSpecsList(int initialSize) {
		return clone(XsdEntityDescriptorEnum.NamespaceSpecsList, initialSize);
	}

	public TargetNamespaceSpec createTargetNamespaceSpec() {
		return create(XsdEntityDescriptorEnum.TargetNamespaceSpec);
	}

	public LocalNamespaceSpec createLocalNamespaceSpec() {
		return create(XsdEntityDescriptorEnum.LocalNamespaceSpec);
	}

	public DerivationAll createDerivationAll() {
		return create(XsdEntityDescriptorEnum.DerivationAll);
	}

	public DerivationList createDerivationList() {
		return create(XsdEntityDescriptorEnum.DerivationList);
	}

	public DerivationList createDerivationList(DerivationControl... entities) {
		return create(XsdEntityDescriptorEnum.DerivationList,
				(IEntity[]) entities);
	}

	public DerivationList createDerivationList(int initialSize) {
		return clone(XsdEntityDescriptorEnum.DerivationList, initialSize);
	}

	public DerivationControl createDerivationControl() {
		return create(XsdEntityDescriptorEnum.DerivationControl);
	}

	public DerivationControl createDerivationControl(
			DerivationControlEnum.Value value) {
		return create(XsdEntityDescriptorEnum.DerivationControl, value);
	}

	public Use createUse() {
		return create(XsdEntityDescriptorEnum.Use);
	}

	public Use createUse(UseEnum.Value value) {
		return create(XsdEntityDescriptorEnum.Use, value);
	}

	public WhiteSpaceProcessing createWhiteSpaceProcessing() {
		return create(XsdEntityDescriptorEnum.WhiteSpaceProcessing);
	}

	public WhiteSpaceProcessing createWhiteSpaceProcessing(
			WhiteSpaceProcessingEnum.Value value) {
		return create(XsdEntityDescriptorEnum.WhiteSpaceProcessing, value);
	}

	public MixedText createMixedText() {
		return create(XsdEntityDescriptorEnum.MixedText);
	}

	public MixedText createMixedText(String value) {
		return create(XsdEntityDescriptorEnum.MixedText, value);
	}

	public XPathString createXPathString() {
		return create(XsdEntityDescriptorEnum.XPathString);
	}

	public XPathString createXPathString(String value) {
		return create(XsdEntityDescriptorEnum.XPathString, value);
	}

	public StringData createStringData() {
		return create(XsdEntityDescriptorEnum.StringData);
	}

	public StringData createStringData(String value) {
		return create(XsdEntityDescriptorEnum.StringData, value);
	}

	public IntegerData createIntegerData() {
		return create(XsdEntityDescriptorEnum.IntegerData);
	}

	public IntegerData createIntegerData(java.math.BigInteger value) {
		return create(XsdEntityDescriptorEnum.IntegerData, value);
	}

	public BooleanData createBooleanData() {
		return create(XsdEntityDescriptorEnum.BooleanData);
	}

	public BooleanData createBooleanData(boolean value) {
		return create(XsdEntityDescriptorEnum.BooleanData, value);
	}

	public Qualify createQualify() {
		return create(XsdEntityDescriptorEnum.Qualify);
	}

	public Qualify createQualify(QualifyEnum.Value value) {
		return create(XsdEntityDescriptorEnum.Qualify, value);
	}
}
