package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface Grammar extends IGrammarsEntity {
	public Name getName();

	public void setName(Name name);

	public TargetLanguage getTargetLanguage();

	public void setTargetLanguage(TargetLanguage targetLanguage);

	public NonTerminal getStartSymbol();

	public void setStartSymbol(NonTerminal startSymbol);

	public LiteralTerminal getDelimiter();

	public void setDelimiter(LiteralTerminal delimiter);

	public Productions getLexicalStructure();

	public void setLexicalStructure(Productions lexicalStructure);

	public Productions getPhraseStructure();

	public void setPhraseStructure(Productions phraseStructure);

	public URI getUri();

	public void setUri(URI uri);

	public Namespace getNamespace();

	public void setNamespace(Namespace namespace);

	public Version getVersion();

	public void setVersion(Version version);

	public Literal getSpaceLiteral();

	public void setSpaceLiteral(Literal spaceLiteral);

	public Literal getIndentLiteral();

	public void setIndentLiteral(Literal indentLiteral);

	public Literal getNewLineLiteral();

	public void setNewLineLiteral(Literal newLineLiteral);
}
