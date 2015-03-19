package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class GrammarImpl extends AbstractSimpleEntity implements Grammar {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Grammar> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Grammar;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Grammar_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(GrammarsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private TargetLanguage targetLanguage;

	public TargetLanguage getTargetLanguage() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.targetLanguage,
				targetLanguage);
	}

	public void setTargetLanguage(TargetLanguage targetLanguage) {
		notifyChanged(GrammarsFeatureDescriptorEnum.targetLanguage,
				this.targetLanguage, this.targetLanguage = targetLanguage);
	}

	private NonTerminal startSymbol;

	public NonTerminal getStartSymbol() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.startSymbol,
				startSymbol);
	}

	public void setStartSymbol(NonTerminal startSymbol) {
		notifyChanged(GrammarsFeatureDescriptorEnum.startSymbol,
				this.startSymbol, this.startSymbol = startSymbol);
	}

	private LiteralTerminal delimiter;

	public LiteralTerminal getDelimiter() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.delimiter,
				delimiter);
	}

	public void setDelimiter(LiteralTerminal delimiter) {
		notifyChanged(GrammarsFeatureDescriptorEnum.delimiter, this.delimiter,
				this.delimiter = delimiter);
	}

	private Productions lexicalStructure;

	public Productions getLexicalStructure() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.lexicalStructure,
				lexicalStructure);
	}

	public void setLexicalStructure(Productions lexicalStructure) {
		notifyChanged(GrammarsFeatureDescriptorEnum.lexicalStructure,
				this.lexicalStructure, this.lexicalStructure = lexicalStructure);
	}

	private Productions phraseStructure;

	public Productions getPhraseStructure() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.phraseStructure,
				phraseStructure);
	}

	public void setPhraseStructure(Productions phraseStructure) {
		notifyChanged(GrammarsFeatureDescriptorEnum.phraseStructure,
				this.phraseStructure, this.phraseStructure = phraseStructure);
	}

	private URI uri;

	public URI getUri() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(URI uri) {
		notifyChanged(GrammarsFeatureDescriptorEnum.uri, this.uri,
				this.uri = uri);
	}

	private Namespace namespace;

	public Namespace getNamespace() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.namespace,
				namespace);
	}

	public void setNamespace(Namespace namespace) {
		notifyChanged(GrammarsFeatureDescriptorEnum.namespace, this.namespace,
				this.namespace = namespace);
	}

	private Version version;

	public Version getVersion() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.version, version);
	}

	public void setVersion(Version version) {
		notifyChanged(GrammarsFeatureDescriptorEnum.version, this.version,
				this.version = version);
	}

	private Literal spaceLiteral;

	public Literal getSpaceLiteral() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.spaceLiteral,
				spaceLiteral);
	}

	public void setSpaceLiteral(Literal spaceLiteral) {
		notifyChanged(GrammarsFeatureDescriptorEnum.spaceLiteral,
				this.spaceLiteral, this.spaceLiteral = spaceLiteral);
	}

	private Literal indentLiteral;

	public Literal getIndentLiteral() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.indentLiteral,
				indentLiteral);
	}

	public void setIndentLiteral(Literal indentLiteral) {
		notifyChanged(GrammarsFeatureDescriptorEnum.indentLiteral,
				this.indentLiteral, this.indentLiteral = indentLiteral);
	}

	private Literal newLineLiteral;

	public Literal getNewLineLiteral() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.newLineLiteral,
				newLineLiteral);
	}

	public void setNewLineLiteral(Literal newLineLiteral) {
		notifyChanged(GrammarsFeatureDescriptorEnum.newLineLiteral,
				this.newLineLiteral, this.newLineLiteral = newLineLiteral);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getTargetLanguage().wGetAdaptee(false);
		case 2:
			return getStartSymbol().wGetAdaptee(false);
		case 3:
			return getDelimiter().wGetAdaptee(false);
		case 4:
			return getLexicalStructure().wGetAdaptee(false);
		case 5:
			return getPhraseStructure().wGetAdaptee(false);
		case 6:
			return getUri().wGetAdaptee(false);
		case 7:
			return getNamespace().wGetAdaptee(false);
		case 8:
			return getVersion().wGetAdaptee(false);
		case 9:
			return getSpaceLiteral().wGetAdaptee(false);
		case 10:
			return getIndentLiteral().wGetAdaptee(false);
		case 11:
			return getNewLineLiteral().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(GrammarsEntityDescriptorEnum.Name));
			break;
		case 1:
			setTargetLanguage(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.TargetLanguage));
			break;
		case 2:
			setStartSymbol(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.NonTerminal));
			break;
		case 3:
			setDelimiter(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.LiteralTerminal));
			break;
		case 4:
			setLexicalStructure(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Productions));
			break;
		case 5:
			setPhraseStructure(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Productions));
			break;
		case 6:
			setUri(value.wGetAdapter(GrammarsEntityDescriptorEnum.URI));
			break;
		case 7:
			setNamespace(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Namespace));
			break;
		case 8:
			setVersion(value.wGetAdapter(GrammarsEntityDescriptorEnum.Version));
			break;
		case 9:
			setSpaceLiteral(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Literal));
			break;
		case 10:
			setIndentLiteral(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Literal));
			break;
		case 11:
			setNewLineLiteral(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Literal));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 12;
	}
}
