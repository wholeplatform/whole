package org.whole.lang.grammars.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class GrammarsModelContext extends EntityContext {
	public GrammarsModelContext(IEntity root) {
		super(root);
	}

	public GrammarsModelContext getName() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.name);
	}

	public void setName(GrammarsModelContext name) {
		wSet(GrammarsFeatureDescriptorEnum.name, name);
	}

	public GrammarsModelContext getTargetLanguage() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.targetLanguage);
	}

	public void setTargetLanguage(GrammarsModelContext targetLanguage) {
		wSet(GrammarsFeatureDescriptorEnum.targetLanguage, targetLanguage);
	}

	public GrammarsModelContext getStartSymbol() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.startSymbol);
	}

	public void setStartSymbol(GrammarsModelContext startSymbol) {
		wSet(GrammarsFeatureDescriptorEnum.startSymbol, startSymbol);
	}

	public GrammarsModelContext getDelimiter() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.delimiter);
	}

	public void setDelimiter(GrammarsModelContext delimiter) {
		wSet(GrammarsFeatureDescriptorEnum.delimiter, delimiter);
	}

	public GrammarsModelContext getLexicalStructure() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.lexicalStructure);
	}

	public void setLexicalStructure(GrammarsModelContext lexicalStructure) {
		wSet(GrammarsFeatureDescriptorEnum.lexicalStructure, lexicalStructure);
	}

	public GrammarsModelContext getPhraseStructure() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.phraseStructure);
	}

	public void setPhraseStructure(GrammarsModelContext phraseStructure) {
		wSet(GrammarsFeatureDescriptorEnum.phraseStructure, phraseStructure);
	}

	public GrammarsModelContext getUri() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.uri);
	}

	public void setUri(GrammarsModelContext uri) {
		wSet(GrammarsFeatureDescriptorEnum.uri, uri);
	}

	public GrammarsModelContext getNamespace() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.namespace);
	}

	public void setNamespace(GrammarsModelContext namespace) {
		wSet(GrammarsFeatureDescriptorEnum.namespace, namespace);
	}

	public GrammarsModelContext getVersion() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.version);
	}

	public void setVersion(GrammarsModelContext version) {
		wSet(GrammarsFeatureDescriptorEnum.version, version);
	}

	public GrammarsModelContext getSpaceLiteral() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.spaceLiteral);
	}

	public void setSpaceLiteral(GrammarsModelContext spaceLiteral) {
		wSet(GrammarsFeatureDescriptorEnum.spaceLiteral, spaceLiteral);
	}

	public GrammarsModelContext getIndentLiteral() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.indentLiteral);
	}

	public void setIndentLiteral(GrammarsModelContext indentLiteral) {
		wSet(GrammarsFeatureDescriptorEnum.indentLiteral, indentLiteral);
	}

	public GrammarsModelContext getNewLineLiteral() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.newLineLiteral);
	}

	public void setNewLineLiteral(GrammarsModelContext newLineLiteral) {
		wSet(GrammarsFeatureDescriptorEnum.newLineLiteral, newLineLiteral);
	}

	public GrammarsModelContext getRule() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.rule);
	}

	public void setRule(GrammarsModelContext rule) {
		wSet(GrammarsFeatureDescriptorEnum.rule, rule);
	}

	public GrammarsModelContext getTemplate() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.template);
	}

	public void setTemplate(GrammarsModelContext template) {
		wSet(GrammarsFeatureDescriptorEnum.template, template);
	}

	public GrammarsModelContext getPredicate1() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.predicate1);
	}

	public void setPredicate1(GrammarsModelContext predicate1) {
		wSet(GrammarsFeatureDescriptorEnum.predicate1, predicate1);
	}

	public GrammarsModelContext getPredicate2() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.predicate2);
	}

	public void setPredicate2(GrammarsModelContext predicate2) {
		wSet(GrammarsFeatureDescriptorEnum.predicate2, predicate2);
	}

	public GrammarsModelContext getPredicate() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.predicate);
	}

	public void setPredicate(GrammarsModelContext predicate) {
		wSet(GrammarsFeatureDescriptorEnum.predicate, predicate);
	}

	public GrammarsModelContext getLiteral() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.literal);
	}

	public void setLiteral(GrammarsModelContext literal) {
		wSet(GrammarsFeatureDescriptorEnum.literal, literal);
	}

	public GrammarsModelContext getPattern() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.pattern);
	}

	public void setPattern(GrammarsModelContext pattern) {
		wSet(GrammarsFeatureDescriptorEnum.pattern, pattern);
	}

	public GrammarsModelContext getCategory() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.category);
	}

	public void setCategory(GrammarsModelContext category) {
		wSet(GrammarsFeatureDescriptorEnum.category, category);
	}

	public GrammarsModelContext getFormat() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.format);
	}

	public void setFormat(GrammarsModelContext format) {
		wSet(GrammarsFeatureDescriptorEnum.format, format);
	}

	public GrammarsModelContext getLowerBound() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.lowerBound);
	}

	public void setLowerBound(GrammarsModelContext lowerBound) {
		wSet(GrammarsFeatureDescriptorEnum.lowerBound, lowerBound);
	}

	public GrammarsModelContext getUpperBound() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.upperBound);
	}

	public void setUpperBound(GrammarsModelContext upperBound) {
		wSet(GrammarsFeatureDescriptorEnum.upperBound, upperBound);
	}

	public GrammarsModelContext getSeparator() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.separator);
	}

	public void setSeparator(GrammarsModelContext separator) {
		wSet(GrammarsFeatureDescriptorEnum.separator, separator);
	}

	public GrammarsModelContext getSplitter() {
		return (GrammarsModelContext) wGet(GrammarsFeatureDescriptorEnum.splitter);
	}

	public void setSplitter(GrammarsModelContext splitter) {
		wSet(GrammarsFeatureDescriptorEnum.splitter, splitter);
	}
}
