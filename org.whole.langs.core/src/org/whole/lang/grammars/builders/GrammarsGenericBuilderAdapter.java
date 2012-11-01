package org.whole.lang.grammars.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import java.util.regex.Pattern;
import org.whole.lang.model.EnumValue;
import org.whole.lang.grammars.model.CategoryEnum.Value;

/** 
 * @generator Whole
 */
public class GrammarsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IGrammarsBuilder specificBuilder;

	public GrammarsGenericBuilderAdapter(IGrammarsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public GrammarsGenericBuilderAdapter(IGrammarsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case GrammarsFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case GrammarsFeatureDescriptorEnum.targetLanguage_ord:
			specificBuilder.targetLanguage();
			break;
		case GrammarsFeatureDescriptorEnum.startSymbol_ord:
			specificBuilder.startSymbol();
			break;
		case GrammarsFeatureDescriptorEnum.delimiter_ord:
			specificBuilder.delimiter();
			break;
		case GrammarsFeatureDescriptorEnum.lexicalStructure_ord:
			specificBuilder.lexicalStructure();
			break;
		case GrammarsFeatureDescriptorEnum.phraseStructure_ord:
			specificBuilder.phraseStructure();
			break;
		case GrammarsFeatureDescriptorEnum.uri_ord:
			specificBuilder.uri();
			break;
		case GrammarsFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case GrammarsFeatureDescriptorEnum.version_ord:
			specificBuilder.version();
			break;
		case GrammarsFeatureDescriptorEnum.spaceLiteral_ord:
			specificBuilder.spaceLiteral();
			break;
		case GrammarsFeatureDescriptorEnum.indentLiteral_ord:
			specificBuilder.indentLiteral();
			break;
		case GrammarsFeatureDescriptorEnum.newLineLiteral_ord:
			specificBuilder.newLineLiteral();
			break;
		case GrammarsFeatureDescriptorEnum.rule_ord:
			specificBuilder.rule();
			break;
		case GrammarsFeatureDescriptorEnum.template_ord:
			specificBuilder.template();
			break;
		case GrammarsFeatureDescriptorEnum.predicate1_ord:
			specificBuilder.predicate1();
			break;
		case GrammarsFeatureDescriptorEnum.predicate2_ord:
			specificBuilder.predicate2();
			break;
		case GrammarsFeatureDescriptorEnum.predicate_ord:
			specificBuilder.predicate();
			break;
		case GrammarsFeatureDescriptorEnum.literal_ord:
			specificBuilder.literal();
			break;
		case GrammarsFeatureDescriptorEnum.pattern_ord:
			specificBuilder.pattern();
			break;
		case GrammarsFeatureDescriptorEnum.category_ord:
			specificBuilder.category();
			break;
		case GrammarsFeatureDescriptorEnum.format_ord:
			specificBuilder.format();
			break;
		case GrammarsFeatureDescriptorEnum.lowerBound_ord:
			specificBuilder.lowerBound();
			break;
		case GrammarsFeatureDescriptorEnum.upperBound_ord:
			specificBuilder.upperBound();
			break;
		case GrammarsFeatureDescriptorEnum.separator_ord:
			specificBuilder.separator();
			break;
		case GrammarsFeatureDescriptorEnum.splitter_ord:
			specificBuilder.splitter();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.Grammar_ord:
			specificBuilder.Grammar();
			break;
		case GrammarsEntityDescriptorEnum.Productions_ord:
			specificBuilder.Productions();
			break;
		case GrammarsEntityDescriptorEnum.Production_ord:
			specificBuilder.Production();
			break;
		case GrammarsEntityDescriptorEnum.And_ord:
			specificBuilder.And();
			break;
		case GrammarsEntityDescriptorEnum.Or_ord:
			specificBuilder.Or();
			break;
		case GrammarsEntityDescriptorEnum.Not_ord:
			specificBuilder.Not();
			break;
		case GrammarsEntityDescriptorEnum.Empty_ord:
			specificBuilder.Empty();
			break;
		case GrammarsEntityDescriptorEnum.Space_ord:
			specificBuilder.Space();
			break;
		case GrammarsEntityDescriptorEnum.Indent_ord:
			specificBuilder.Indent();
			break;
		case GrammarsEntityDescriptorEnum.NewLine_ord:
			specificBuilder.NewLine();
			break;
		case GrammarsEntityDescriptorEnum.LiteralTerminal_ord:
			specificBuilder.LiteralTerminal();
			break;
		case GrammarsEntityDescriptorEnum.DataTerminal_ord:
			specificBuilder.DataTerminal();
			break;
		case GrammarsEntityDescriptorEnum.Optional_ord:
			specificBuilder.Optional();
			break;
		case GrammarsEntityDescriptorEnum.Repeat_ord:
			specificBuilder.Repeat();
			break;
		case GrammarsEntityDescriptorEnum.Concatenate_ord:
			specificBuilder.Concatenate();
			break;
		case GrammarsEntityDescriptorEnum.Choose_ord:
			specificBuilder.Choose();
			break;
		case GrammarsEntityDescriptorEnum.When_ord:
			specificBuilder.When();
			break;
		case GrammarsEntityDescriptorEnum.As_ord:
			specificBuilder.As();
			break;
		case GrammarsEntityDescriptorEnum.Split_ord:
			specificBuilder.Split();
			break;
		case GrammarsEntityDescriptorEnum.ByDelimiter_ord:
			specificBuilder.ByDelimiter();
			break;
		case GrammarsEntityDescriptorEnum.LanguageDescriptor_ord:
			specificBuilder.LanguageDescriptor();
			break;
		case GrammarsEntityDescriptorEnum.Unbounded_ord:
			specificBuilder.Unbounded();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.Grammar_ord:
			specificBuilder.Grammar_();
			break;
		case GrammarsEntityDescriptorEnum.Productions_ord:
			specificBuilder.Productions_();
			break;
		case GrammarsEntityDescriptorEnum.Production_ord:
			specificBuilder.Production_();
			break;
		case GrammarsEntityDescriptorEnum.And_ord:
			specificBuilder.And_();
			break;
		case GrammarsEntityDescriptorEnum.Or_ord:
			specificBuilder.Or_();
			break;
		case GrammarsEntityDescriptorEnum.Not_ord:
			specificBuilder.Not_();
			break;
		case GrammarsEntityDescriptorEnum.Empty_ord:
			specificBuilder.Empty_();
			break;
		case GrammarsEntityDescriptorEnum.Space_ord:
			specificBuilder.Space_();
			break;
		case GrammarsEntityDescriptorEnum.Indent_ord:
			specificBuilder.Indent_();
			break;
		case GrammarsEntityDescriptorEnum.NewLine_ord:
			specificBuilder.NewLine_();
			break;
		case GrammarsEntityDescriptorEnum.LiteralTerminal_ord:
			specificBuilder.LiteralTerminal_();
			break;
		case GrammarsEntityDescriptorEnum.DataTerminal_ord:
			specificBuilder.DataTerminal_();
			break;
		case GrammarsEntityDescriptorEnum.Optional_ord:
			specificBuilder.Optional_();
			break;
		case GrammarsEntityDescriptorEnum.Repeat_ord:
			specificBuilder.Repeat_();
			break;
		case GrammarsEntityDescriptorEnum.Concatenate_ord:
			specificBuilder.Concatenate_();
			break;
		case GrammarsEntityDescriptorEnum.Choose_ord:
			specificBuilder.Choose_();
			break;
		case GrammarsEntityDescriptorEnum.When_ord:
			specificBuilder.When_();
			break;
		case GrammarsEntityDescriptorEnum.As_ord:
			specificBuilder.As_();
			break;
		case GrammarsEntityDescriptorEnum.Split_ord:
			specificBuilder.Split_();
			break;
		case GrammarsEntityDescriptorEnum.ByDelimiter_ord:
			specificBuilder.ByDelimiter_();
			break;
		case GrammarsEntityDescriptorEnum.LanguageDescriptor_ord:
			specificBuilder.LanguageDescriptor_();
			break;
		case GrammarsEntityDescriptorEnum.Unbounded_ord:
			specificBuilder.Unbounded_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.Grammar_ord:
			specificBuilder._Grammar();
			break;
		case GrammarsEntityDescriptorEnum.Productions_ord:
			specificBuilder._Productions();
			break;
		case GrammarsEntityDescriptorEnum.Production_ord:
			specificBuilder._Production();
			break;
		case GrammarsEntityDescriptorEnum.And_ord:
			specificBuilder._And();
			break;
		case GrammarsEntityDescriptorEnum.Or_ord:
			specificBuilder._Or();
			break;
		case GrammarsEntityDescriptorEnum.Not_ord:
			specificBuilder._Not();
			break;
		case GrammarsEntityDescriptorEnum.Empty_ord:
			specificBuilder._Empty();
			break;
		case GrammarsEntityDescriptorEnum.Space_ord:
			specificBuilder._Space();
			break;
		case GrammarsEntityDescriptorEnum.Indent_ord:
			specificBuilder._Indent();
			break;
		case GrammarsEntityDescriptorEnum.NewLine_ord:
			specificBuilder._NewLine();
			break;
		case GrammarsEntityDescriptorEnum.LiteralTerminal_ord:
			specificBuilder._LiteralTerminal();
			break;
		case GrammarsEntityDescriptorEnum.DataTerminal_ord:
			specificBuilder._DataTerminal();
			break;
		case GrammarsEntityDescriptorEnum.Optional_ord:
			specificBuilder._Optional();
			break;
		case GrammarsEntityDescriptorEnum.Repeat_ord:
			specificBuilder._Repeat();
			break;
		case GrammarsEntityDescriptorEnum.Concatenate_ord:
			specificBuilder._Concatenate();
			break;
		case GrammarsEntityDescriptorEnum.Choose_ord:
			specificBuilder._Choose();
			break;
		case GrammarsEntityDescriptorEnum.When_ord:
			specificBuilder._When();
			break;
		case GrammarsEntityDescriptorEnum.As_ord:
			specificBuilder._As();
			break;
		case GrammarsEntityDescriptorEnum.Split_ord:
			specificBuilder._Split();
			break;
		case GrammarsEntityDescriptorEnum.ByDelimiter_ord:
			specificBuilder._ByDelimiter();
			break;
		case GrammarsEntityDescriptorEnum.LanguageDescriptor_ord:
			specificBuilder._LanguageDescriptor();
			break;
		case GrammarsEntityDescriptorEnum.Unbounded_ord:
			specificBuilder._Unbounded();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.Productions_ord:
			specificBuilder.Productions_(initialCapacity);
			break;
		case GrammarsEntityDescriptorEnum.Concatenate_ord:
			specificBuilder.Concatenate_(initialCapacity);
			break;
		case GrammarsEntityDescriptorEnum.Choose_ord:
			specificBuilder.Choose_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.NonTerminal_ord:
			specificBuilder.NonTerminal(value);
			break;
		case GrammarsEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case GrammarsEntityDescriptorEnum.URI_ord:
			specificBuilder.URI(value);
			break;
		case GrammarsEntityDescriptorEnum.Namespace_ord:
			specificBuilder.Namespace(value);
			break;
		case GrammarsEntityDescriptorEnum.Version_ord:
			specificBuilder.Version(value);
			break;
		case GrammarsEntityDescriptorEnum.Literal_ord:
			specificBuilder.Literal(value);
			break;
		case GrammarsEntityDescriptorEnum.RegExp_ord:
			specificBuilder.RegExp(value);
			break;
		case GrammarsEntityDescriptorEnum.Format_ord:
			specificBuilder.Format(value);
			break;
		case GrammarsEntityDescriptorEnum.CustomDataType_ord:
			specificBuilder.CustomDataType(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.BySize_ord:
			specificBuilder.BySize(value);
			break;
		case GrammarsEntityDescriptorEnum.ByLines_ord:
			specificBuilder.ByLines(value);
			break;
		case GrammarsEntityDescriptorEnum.Size_ord:
			specificBuilder.Size(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Pattern value) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.CompiledPattern_ord:
			specificBuilder.CompiledPattern(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case GrammarsEntityDescriptorEnum.Category_ord:
			specificBuilder.Category((Value) value);
			break;
		case GrammarsEntityDescriptorEnum.DataType_ord:
			specificBuilder
					.DataType((org.whole.lang.grammars.model.DataTypeEnum.Value) value);
			break;
		}
	}
}
