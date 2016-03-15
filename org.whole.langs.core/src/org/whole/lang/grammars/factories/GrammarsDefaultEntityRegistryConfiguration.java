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
package org.whole.lang.grammars.factories;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createResolver;

import org.whole.lang.events.IdentityEventHandler;
import org.whole.lang.factories.DefaultEntityRegistryConfiguration;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.grammars.model.CategoryEnum;
import org.whole.lang.grammars.model.Literal;
import org.whole.lang.grammars.model.LiteralTerminal;
import org.whole.lang.grammars.model.RegExp;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class GrammarsDefaultEntityRegistryConfiguration extends DefaultEntityRegistryConfiguration {
	public void apply(IEntityRegistry er) {
		super.apply(er);
		GrammarsEntityFactory ef = GrammarsEntityFactory.instance(er);

		RegExp regex;
		Literal literal;
		IdentityEventHandler deriveLiteralPattern = new IdentityEventHandler() {
			private static final long serialVersionUID = 1L;
			private String derivedPattern;

			@Override
			public void notifyChanged(IEntity source, FeatureDescriptor featureDesc, String oldValue, String newValue) {
				IEntity parent = source.wGetParent();
				if (parent instanceof LiteralTerminal) {
					LiteralTerminal literalTerminal = (LiteralTerminal) parent;
					Literal literal = literalTerminal.getLiteral();
					if (literal == source) {
						derivedPattern = StringUtils.quoteRegex(newValue);
						literalTerminal.getPattern().wSetValue(derivedPattern);
					} else if (newValue != derivedPattern) {
						source.wRemoveChangeEventHandler(this);		
						literal.wRemoveChangeEventHandler(this);	
					}
				}
			}
		};

		er.put(ef.createEmpty(ef.createLiteral("")));
		er.put(ef.createChoose(2));
		er.put(ef.createConcatenate(2));
		er.put(ef.createLiteralTerminal(
				regex = ef.createRegExp("pattern"),
				ef.createCategory(CategoryEnum.DELIMITER),
				literal = ef.createLiteral("literal")));
		regex.wAddChangeEventHandler(deriveLiteralPattern);
		literal.wAddChangeEventHandler(deriveLiteralPattern);

		er.put(ef.createDataTerminal(
				ef.createRegExp(".*"),
				ef.createCategory(CategoryEnum.LITERAL),
				ef.createFormat("%s")));
		er.put(ef.createAs(
				ef.createNonTerminal("nt"),
				ef.createName("name")));
		er.put(ef.createByLines(1));
		er.put(ef.createBySize(10));
		er.put(ef.createRepeat(
				ef.createSize(0),
				ef.createUnbounded(),
				ef.buildLiteralTerminal().set(GrammarsFeatureDescriptorEnum.literal, ",").getResult(),
				createResolver(GrammarsEntityDescriptorEnum.Rule)));
		er.put(ef.createBySize(5));
		er.put(ef.createGrammar(
				ef.createName("GrammarName"),
				createResolver(GrammarsEntityDescriptorEnum.TargetLanguage),
				createResolver(GrammarsEntityDescriptorEnum.NonTerminal),
				ef.createLiteralTerminal(
						ef.createRegExp("\\p{javaWhitespace}*"),
						ef.createCategory(CategoryEnum.SEPARATOR),
						ef.createLiteral("")),
				ef.createProductions(0),
				ef.createProductions(
						ef.create(GrammarsEntityDescriptorEnum.Production, 
								ef.createNonTerminal("StartSymbol"),
								createResolver(GrammarsEntityDescriptorEnum.Rule))),

//				ef.createURI("http://examples.whole.org/GrammarName"),
//				ef.createNamespace("org.whole.examples.grammarname"),
				createResolver(GrammarsEntityDescriptorEnum.URI),
				createResolver(GrammarsEntityDescriptorEnum.Namespace),

				createResolver(GrammarsEntityDescriptorEnum.Version),
				createResolver(GrammarsEntityDescriptorEnum.Literal),
				createResolver(GrammarsEntityDescriptorEnum.Literal),
				createResolver(GrammarsEntityDescriptorEnum.Literal)));
	}
}
