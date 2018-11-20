package org.whole.lang.pojo.visitors;

import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.ArrayType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.CollectionType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.MapType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.PrimitiveType_ord;
import static org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum.ReferenceType_ord;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.pojo.factories.PojoEntityFactory;
import org.whole.lang.pojo.model.ArrayType;
import org.whole.lang.pojo.model.CollectionType;
import org.whole.lang.pojo.model.Declaration;
import org.whole.lang.pojo.model.IPojoEntity;
import org.whole.lang.pojo.model.Library;
import org.whole.lang.pojo.model.MapType;
import org.whole.lang.pojo.model.ModifierEnum;
import org.whole.lang.pojo.model.Name;
import org.whole.lang.pojo.model.Parameter;
import org.whole.lang.pojo.model.PojoDeclaration;
import org.whole.lang.pojo.model.PrimitiveType;
import org.whole.lang.pojo.model.ProductDeclaration;
import org.whole.lang.pojo.model.Property;
import org.whole.lang.pojo.model.ReferenceType;
import org.whole.lang.pojo.model.Template;
import org.whole.lang.pojo.model.Type;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.templates.PojoTemplateManager;
import org.whole.lang.pojo.util.PojoUtils;
import org.whole.lang.queries.model.Path;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.FreshNameGenerator;
import org.whole.lang.util.StringUtils;

public class PojoNormalizerVisitor extends PojoIdentityDefaultVisitor {

	public PojoNormalizerVisitor() {
	}

	@Override
	public void visit(IPojoEntity entity) {
		Library p = Matcher.findAncestor(PojoEntityDescriptorEnum.Library, entity);
		if (p != null)
			visit(p);
	}

	@Override
	public void visit(Library entity) {
		IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
		FreshNameGenerator entityNameGenerator = new FreshNameGenerator();

		resolveTemplateNameCollisionsInDeclarations(entity, bindings, entityNameGenerator);
		createDefaultTemplateInDeclarations(entity, bindings, entityNameGenerator);
		createDefaultTemplateInProperties(entity, bindings);
		createDefaultTypeInParameters(entity, bindings);
		createDefaultTemplateInParameters(entity, bindings);
		addMappingDataTypes(entity, bindings, entityNameGenerator);
	}

	public static  void resolveTemplateNameCollisionsInDeclarations(Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		Path findAllProductDeclarationsWithTemplateName = (Path) PojoTemplateManager.instance().create("findAllProductDeclarationsWithTemplateName");
		bindings.wEnterScope();
		for (ProductDeclaration declaration : BehaviorUtils.compileAndLazyEvaluate(findAllProductDeclarationsWithTemplateName, entity, bindings).<ProductDeclaration>client()) {
			Template template = declaration.getTemplate();
			template.wSetValue(entityNameGenerator.nextFreshName(StringUtils.toSimpleName(template.wStringValue())));
		}
		bindings.wExitScope();
	}

	public static void createDefaultTemplateInDeclarations(Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		PojoEntityFactory pef = PojoEntityFactory.instance;
		Path findAllProductDeclarationsWithEmptyTemplate = (Path) PojoTemplateManager.instance().create("findAllProductDeclarationsWithEmptyTemplate");
		bindings.wEnterScope();
		for (ProductDeclaration declaration : BehaviorUtils.compileAndLazyEvaluate(findAllProductDeclarationsWithEmptyTemplate, entity, bindings).<ProductDeclaration>client()) {
			String name = StringUtils.toSimpleName(bindings.wStringValue("name"));
			declaration.setTemplate(pef.createName(entityNameGenerator.nextFreshName(name)));
		}
		bindings.wExitScope();
	}

	public static void createDefaultTemplateInProperties(Library entity, IBindingManager bindings) {
		Path findAllPropertiesWithoutTemplate = (Path) PojoTemplateManager.instance().create("findAllPropertiesWithoutTemplate");
		bindings.wEnterScope();
		for (Property property : BehaviorUtils.compileAndLazyEvaluate(findAllPropertiesWithoutTemplate, entity, bindings).<Property>client())
			property.setTemplate((Name) EntityUtils.clone(bindings.wGet("name")));
		bindings.wExitScope();
	}

	public static void createDefaultTypeInParameters(Library entity, IBindingManager bindings) {
		Path findAllParametersWithoutType = (Path) PojoTemplateManager.instance().create("findAllParametersWithoutType");
		Path findParameterType = (Path) PojoTemplateManager.instance().create("findPropertyType");
		bindings.wEnterScope();
		for (Parameter parameter : BehaviorUtils.compileAndLazyEvaluate(findAllParametersWithoutType, entity, bindings).<Parameter>client()) {
			PojoDeclaration pojo = (PojoDeclaration) bindings.wGet("pojo");
			Type type = BehaviorUtils.<Type>evaluateFirstResult(findParameterType, pojo, bindings);
			if (type != null)
				parameter.setType(EntityUtils.clone(type));
			else
				throw new IllegalArgumentException("Missing " + bindings.wStringValue("name") +
						" property in " + pojo.getName().wStringValue() + " pojo declaration");
		}
		bindings.wExitScope();
	}

	public static void createDefaultTemplateInParameters(Library entity, IBindingManager bindings) {
		Path findAllParametersWithoutTemlate = (Path) PojoTemplateManager.instance().create("findAllParametersWithoutTemlate");
		Path findParameterTemplate = (Path) PojoTemplateManager.instance().create("findPropertyTemplate");
		bindings.wEnterScope();
		for (Parameter parameter : BehaviorUtils.compileAndLazyEvaluate(findAllParametersWithoutTemlate, entity, bindings).<Parameter>client()) {
			PojoDeclaration pojo = (PojoDeclaration) bindings.wGet("pojo");
			Name name = BehaviorUtils.<Name>evaluateFirstResult(findParameterTemplate, pojo, bindings);
			if (name != null)
				parameter.setTemplate(EntityUtils.clone(name));
		}
		bindings.wExitScope();
	}

	public static void addMappingDataTypes(Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		Path findNonPrimitiveTypes = (Path) PojoTemplateManager.instance().create("findAllPropertyTypes");
		bindings.wEnterScope();
		for (Type type : BehaviorUtils.compileAndLazyEvaluate(findNonPrimitiveTypes, entity, bindings).<Type>client())
			addMappingDataType(type, entity, bindings, entityNameGenerator);
		bindings.wExitScope();
	}

	public static void addMappingDataType(Type type, Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		bindings.wEnterScope();
		
		switch (type.wGetEntityDescriptor().getOrdinal()) {
		case PrimitiveType_ord:
			addPrimitiveTypeMappingDataType((PrimitiveType) type, entity, bindings, entityNameGenerator);
			break;
		case ReferenceType_ord:
			addReferenceTypeMappingDataType((ReferenceType) type, entity, bindings, entityNameGenerator);
			break;
		case ArrayType_ord:
			addArrayTypeMappingDataType((ArrayType) type, entity, bindings, entityNameGenerator);
			break;
		case CollectionType_ord:
			addCollectionTypeMappingDataType((CollectionType) type, entity, bindings, entityNameGenerator);
			break;
		case MapType_ord:
			addMapTypeMappingDataType((MapType) type, entity, bindings, entityNameGenerator);
			break;
		}
		
		bindings.wExitScope();
	}

	public static void addMissingDataTypeDeclaration(Type type, Library entity, FreshNameGenerator entityNameGenerator) {
		if (PojoUtils.findProductDeclaration(type, entity) == null)
			PojoUtils.addDataTypeDeclaration(type, entityNameGenerator.nextFreshName(PojoUtils.calculateTypeName(type)), entity);
	}

	public static void addPrimitiveTypeMappingDataType(PrimitiveType type, Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		addMissingDataTypeDeclaration(type, entity, entityNameGenerator);
	}

	public static void addReferenceTypeMappingDataType(ReferenceType type, Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		Property property = (Property) bindings.wGet("property");
		Declaration declaration = PojoUtils.findProductDeclaration(type, entity);

		boolean hasDataTypeModifier = property.getAnnotations().wContainsValue(ModifierEnum.DATATYPE);
		boolean needsDeclaration = declaration == null;
		boolean needsModifier = property.equals(type.wGetParent()) &&
				!hasDataTypeModifier &&
				(needsDeclaration || Matcher.matchImpl(PojoEntityDescriptorEnum.DataTypeDeclaration, declaration));

		if (needsModifier)
			property.getAnnotations().wAdd(PojoEntityFactory.instance.createModifier(ModifierEnum.DATATYPE));

		if (needsDeclaration)
			PojoUtils.addDataTypeDeclaration(type, entityNameGenerator.nextFreshName(PojoUtils.calculateTypeName(type)), entity);
	}

	public static void addArrayTypeMappingDataType(ArrayType type, Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		addMappingDataType(type.getElementType(), entity, bindings, entityNameGenerator);
		addMissingDataTypeDeclaration(type, entity, entityNameGenerator);
	}

	public static void addCollectionTypeMappingDataType(CollectionType type, Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		addMappingDataType(type.getElementType(), entity, bindings, entityNameGenerator);
		addMissingDataTypeDeclaration(type, entity, entityNameGenerator);
	}

	public static void addMapTypeMappingDataType(MapType type, Library entity, IBindingManager bindings, FreshNameGenerator entityNameGenerator) {
		addMappingDataType(type.getKeyType(), entity, bindings, entityNameGenerator);
		addMappingDataType(type.getValueType(), entity, bindings, entityNameGenerator);
		addMissingDataTypeDeclaration(type, entity, entityNameGenerator);
	}
}
