package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class GrammarAdapter extends AbstractEntityAdapter implements Grammar {
	private static final long serialVersionUID = 1;

	public GrammarAdapter(IEntity implementor) {
		super(implementor);
	}

	public GrammarAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Grammar> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Grammar;
	}

	public Name getName() {
		return wGet(GrammarsFeatureDescriptorEnum.name).wGetAdapter(
				GrammarsEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(GrammarsFeatureDescriptorEnum.name, name);
	}

	public TargetLanguage getTargetLanguage() {
		return wGet(GrammarsFeatureDescriptorEnum.targetLanguage).wGetAdapter(
				GrammarsEntityDescriptorEnum.TargetLanguage);
	}

	public void setTargetLanguage(TargetLanguage targetLanguage) {
		wSet(GrammarsFeatureDescriptorEnum.targetLanguage, targetLanguage);
	}

	public NonTerminal getStartSymbol() {
		return wGet(GrammarsFeatureDescriptorEnum.startSymbol).wGetAdapter(
				GrammarsEntityDescriptorEnum.NonTerminal);
	}

	public void setStartSymbol(NonTerminal startSymbol) {
		wSet(GrammarsFeatureDescriptorEnum.startSymbol, startSymbol);
	}

	public LiteralTerminal getDelimiter() {
		return wGet(GrammarsFeatureDescriptorEnum.delimiter).wGetAdapter(
				GrammarsEntityDescriptorEnum.LiteralTerminal);
	}

	public void setDelimiter(LiteralTerminal delimiter) {
		wSet(GrammarsFeatureDescriptorEnum.delimiter, delimiter);
	}

	public Productions getLexicalStructure() {
		return wGet(GrammarsFeatureDescriptorEnum.lexicalStructure)
				.wGetAdapter(GrammarsEntityDescriptorEnum.Productions);
	}

	public void setLexicalStructure(Productions lexicalStructure) {
		wSet(GrammarsFeatureDescriptorEnum.lexicalStructure, lexicalStructure);
	}

	public Productions getPhraseStructure() {
		return wGet(GrammarsFeatureDescriptorEnum.phraseStructure).wGetAdapter(
				GrammarsEntityDescriptorEnum.Productions);
	}

	public void setPhraseStructure(Productions phraseStructure) {
		wSet(GrammarsFeatureDescriptorEnum.phraseStructure, phraseStructure);
	}

	public URI getUri() {
		return wGet(GrammarsFeatureDescriptorEnum.uri).wGetAdapter(
				GrammarsEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(GrammarsFeatureDescriptorEnum.uri, uri);
	}

	public Namespace getNamespace() {
		return wGet(GrammarsFeatureDescriptorEnum.namespace).wGetAdapter(
				GrammarsEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(GrammarsFeatureDescriptorEnum.namespace, namespace);
	}

	public Version getVersion() {
		return wGet(GrammarsFeatureDescriptorEnum.version).wGetAdapter(
				GrammarsEntityDescriptorEnum.Version);
	}

	public void setVersion(Version version) {
		wSet(GrammarsFeatureDescriptorEnum.version, version);
	}

	public Literal getSpaceLiteral() {
		return wGet(GrammarsFeatureDescriptorEnum.spaceLiteral).wGetAdapter(
				GrammarsEntityDescriptorEnum.Literal);
	}

	public void setSpaceLiteral(Literal spaceLiteral) {
		wSet(GrammarsFeatureDescriptorEnum.spaceLiteral, spaceLiteral);
	}

	public Literal getIndentLiteral() {
		return wGet(GrammarsFeatureDescriptorEnum.indentLiteral).wGetAdapter(
				GrammarsEntityDescriptorEnum.Literal);
	}

	public void setIndentLiteral(Literal indentLiteral) {
		wSet(GrammarsFeatureDescriptorEnum.indentLiteral, indentLiteral);
	}

	public Literal getNewLineLiteral() {
		return wGet(GrammarsFeatureDescriptorEnum.newLineLiteral).wGetAdapter(
				GrammarsEntityDescriptorEnum.Literal);
	}

	public void setNewLineLiteral(Literal newLineLiteral) {
		wSet(GrammarsFeatureDescriptorEnum.newLineLiteral, newLineLiteral);
	}
}
