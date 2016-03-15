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
package org.whole.lang.grammars.visitors;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.DataType;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.LanguageDescriptor;
import org.whole.lang.grammars.model.Name;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Productions;
import org.whole.lang.grammars.model.Repeat;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.model.Template;
import org.whole.lang.grammars.model.When;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.util.GrammarsUtils;
import org.whole.lang.iterators.AbstractPatternFilterIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.ScannerIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.models.factories.ModelsEntityFactory;
import org.whole.lang.models.model.ComponentModifierEnum;
import org.whole.lang.models.model.CompositeEntity;
import org.whole.lang.models.model.DataEntity;
import org.whole.lang.models.model.EntityModifierEnum;
import org.whole.lang.models.model.EnumEntity;
import org.whole.lang.models.model.EnumValues;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.model.FeatureModifierEnum;
import org.whole.lang.models.model.Features;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.model.ModelDeclaration;
import org.whole.lang.models.model.ModelDeclarations;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.model.SimpleName;
import org.whole.lang.models.model.Types;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.models.reflect.ModelsFeatureDescriptorEnum;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class Grammars2ModelsVisitor extends GrammarsTraverseAllVisitor {
	private ModelDeclarations modelDeclarations;
	private Map<String, ModelDeclaration> declarationMap = new HashMap<String, ModelDeclaration>(); // entityName -> ModelDeclaration
	private Map<String, Production> productionMap = new HashMap<String, Production>(); // ntName -> Production
	private Map<String, Production> lexiconMap = new HashMap<String, Production>(); // ntName -> Production
	private String name;
	protected boolean normalizeGrammar;

	public Grammars2ModelsVisitor(boolean normalizeGrammar) {
		this.normalizeGrammar = normalizeGrammar;
	}

	protected boolean isLexicalNonTerminal(NonTerminal nt) {
		return lexiconMap.keySet().contains(nt.getValue());
	}

	protected Grammar normalize(Grammar grammar) {
		if (normalizeGrammar) {
			grammar = EntityUtils.clone(grammar);
			NormalizerOperation.normalize(grammar);
		}
		return grammar;
	}

	@Override
	public void visit(Grammar entity) {
		entity = normalize(entity);

		IEntityIterator<Production> lexiconIiterator = IteratorFactory.<Production>childIterator();
		lexiconIiterator.reset(entity.getLexicalStructure());
		for (Production p : lexiconIiterator)
			lexiconMap.put(p.getName().getValue(), p);

		LanguageDescriptor ld = (LanguageDescriptor) entity.getTargetLanguage();
		ModelsEntityFactory mf = ModelsEntityFactory.instance;
		Model model = mf.createModel(
				mf.createSimpleName(ld.getName().getValue()),
				mf.createTypeRelations(),
				modelDeclarations = mf.createModelDeclarations(),
				mf.createNamespace(ld.getNamespace().getValue()),
				EntityUtils.isResolver(ld.getVersion()) ?
						CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.Version) :
						mf.createVersion(ld.getVersion().getValue()),
				mf.createURI(ld.getUri().getValue()));

		entity.getPhraseStructure().accept(this);
		
		setResult(model);
	}

	@Override
	public void visit(Productions entity) {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;

		ScannerIterator<Production> i = IteratorFactory.<Production>childScannerIterator();
		i.reset(entity);
		for (Production p : i) {
			String eName = getMappedEntityName(p);
			ModelDeclaration mDecl = CommonsEntityAdapterFactory.createResolver(ModelsEntityDescriptorEnum.ModelDeclaration);

			productionMap.put(p.getName().getValue(), p);
			declarationMap.put(eName, mDecl);
			modelDeclarations.wAdd(mDecl);
			
			mDecl.setModifiers(mf.createEntityModifiers());
			mDecl.setName(mf.createSimpleName(eName));
			mDecl.setTypes(mf.createTypes());
		}

		super.visit(entity);
	}

	@Override
	public void visit(Production entity) {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;
		String eName = getMappedEntityName(entity);
		Rule rule = entity.getRule();
		
		AbstractPatternFilterIterator<Rule> ruleIterator = IteratorFactory.<Rule>descendantOrSelfMatcherIterator().withPattern(GrammarsEntityDescriptorEnum.Rule);
		ruleIterator.reset(rule);
		while (ruleIterator.hasNext()) {
			rule = ruleIterator.next();

			switch (rule.wGetEntityOrd()) {
			// map productions with a single lexical non-terminal as data entities
			case GrammarsEntityDescriptorEnum.NonTerminal_ord:
				if (!isLexicalNonTerminal((NonTerminal) rule) ||
						!EntityUtils.hasParent(rule) ||
						!Matcher.match(GrammarsEntityDescriptorEnum.Production, rule.wGetParent()) ||
						!Matcher.match(GrammarsEntityDescriptorEnum.DataTerminal, lexiconMap.get(((NonTerminal) rule).getValue()).getRule()))
					break;
			case GrammarsEntityDescriptorEnum.DataTerminal_ord:
				DataEntity de = getModelDeclaration(eName, ModelsEntityDescriptorEnum.DataEntity);
				Template template = entity.getTemplate();
				if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.DataType, template))
					de.getDataType().wSetValue(GrammarsUtils.getDataType((DataType) template));
				else if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.CustomDataType, template))
					de.getDataType().wSetValue(template.wStringValue());
				return;
			case GrammarsEntityDescriptorEnum.Choose_ord:

				boolean isPolymorphic = false;
				AbstractPatternFilterIterator<NonTerminal> ruleIterator2 = IteratorFactory.<NonTerminal>descendantOrSelfMatcherIterator()
						.withPattern(GrammarsEntityDescriptorEnum.NonTerminal);
				ruleIterator2.reset(rule);
				for (NonTerminal nt2 : ruleIterator2)
					if (!isLexicalNonTerminal(nt2)) {
						ensureType(getModelDeclaration(getMappedEntityName(nt2)).getTypes(), eName);
						isPolymorphic = true;
					}

				if (isPolymorphic) {
					SimpleEntity se = getModelDeclaration(eName, ModelsEntityDescriptorEnum.SimpleEntity);
					se.getModifiers().wAdd(mf.createEntityModifier(EntityModifierEnum._abstract));
					return;
				} else if (!rule.wIsEmpty() && Matcher.match(GrammarsEntityDescriptorEnum.As, rule.wGet(0))) {
					EnumEntity ee = getModelDeclaration(eName, ModelsEntityDescriptorEnum.EnumEntity);
					EnumValues enumValues = ModelsEntityFactory.instance.createEnumValues(0);
					AbstractPatternFilterIterator<As> ruleIterator3 = IteratorFactory.<As>descendantOrSelfMatcherIterator()
							.withPattern(GrammarsEntityDescriptorEnum.As);
					ruleIterator3.reset(rule);
					for (As as : ruleIterator3)
						enumValues.wAdd(ModelsEntityFactory.instance.createEnumValue(as.getName().getValue()));
					ee.setValues(enumValues);
					return;
				}
//				while (ruleIterator.skipTo(GrammarsEntityDescriptorEnum.NonTerminal)) {
//					NonTerminal nt = ruleIterator.next(GrammarsEntityDescriptorEnum.NonTerminal);
//					ensureType(getModelDeclaration(getMappedEntityName(nt)).getTypes(), eName);
//				}
				break;
			case GrammarsEntityDescriptorEnum.Repeat_ord:
				if (ruleIterator.skipTo(GrammarsEntityDescriptorEnum.NonTerminal)) {

					//FIXME wrongly assumes that the separator, if present, is a lexical token
					if (!EntityUtils.isResolver(((Repeat) rule).getSeparator())) {//if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.NonTerminal, ((Repeat) rule).getSeparator())) {
						ruleIterator.next();
						ruleIterator.skipTo(GrammarsEntityDescriptorEnum.NonTerminal);
					}

					NonTerminal nt = null;
					AbstractPatternFilterIterator<NonTerminal> ruleIterator4 = IteratorFactory.<NonTerminal>descendantOrSelfMatcherIterator()
							.withPattern(GrammarsEntityDescriptorEnum.NonTerminal);
					ruleIterator4.reset(rule);
					for (NonTerminal nt2 : ruleIterator4)
						if (!isLexicalNonTerminal(nt2)) {
							nt = nt2;
							break;
						}
					//FIXME after normalization, component type can be polymorphic
					// by now we assume that the separator, if present, is a lexical token
					if (nt == null)
						break;

// the above statements replace this code, allowing lexical Repeat rule
//					NonTerminal nt = ruleIterator.next(GrammarsEntityDescriptorEnum.NonTerminal);
//					while (isLexicalNonTerminal(nt)) {
//						nt = ruleIterator.next(GrammarsEntityDescriptorEnum.NonTerminal);
//					}
					
					CompositeEntity ce = getModelDeclaration(eName, ModelsEntityDescriptorEnum.CompositeEntity);
					
					ce.setComponentType(mf.createSimpleName(getMappedEntityName(nt)));
					ce.getComponentModifiers().wAdd(mf.createComponentModifier(ComponentModifierEnum.ordered));
				}
				return;
			case GrammarsEntityDescriptorEnum.As_ord:
				As asRule = (As) rule;
// normalization invariants assure that this branch is unreachable
//				if (Matcher.match(GrammarsEntityDescriptorEnum.LiteralTerminal, asRule.getRule())) {
//					EnumEntity ee = getModelDeclaration(eName, ModelsEntityDescriptorEnum.EnumEntity);
//					
//					ee.getValues().wAdd(mf.createEnumValue(getMappedName(asRule)));
//					
//					while (ruleIterator.skipTo(GrammarsEntityDescriptorEnum.As)) {
//						rule = ruleIterator.next(GrammarsEntityDescriptorEnum.As);
//						asRule = (As) rule;
//
//						ee.getValues().wAdd(mf.createEnumValue(getMappedName(asRule)));
//					}
//				} else {
					SimpleEntity se = getModelDeclaration(eName, ModelsEntityDescriptorEnum.SimpleEntity);
					Features features = se.getFeatures();
					
					ensureFeature(features, ruleIterator, asRule);
					
					while (ruleIterator.hasNext()) {
						rule = ruleIterator.next();
						
						switch (rule.wGetEntityOrd()) {
						case GrammarsEntityDescriptorEnum.As_ord:
							asRule = (As) rule;
							ensureFeature(features, ruleIterator, asRule);
							break;
// normalization invariants assure that this branch is unreachable (choose rules nested into as rules always become fresh productions)
//						case GrammarsEntityDescriptorEnum.Choose_ord:
//							ruleIterator.prune();
//							
//							se.getModifiers().wAdd(mf.createEntityModifier(EntityModifierEnum._abstract));
//
//							for (NonTerminal nt2 : IteratorFactory.<NonTerminal>topDownMatcherIterator(rule).usePattern(GrammarsEntityDescriptorEnum.NonTerminal))
//								ensureType(getModelDeclaration(getMappedEntityName(nt2)).getTypes(), eName);
						}
					}
//				}
				return;
			case GrammarsEntityDescriptorEnum.Concatenate_ord:
				break;
			}
		}
		getModelDeclaration(eName, ModelsEntityDescriptorEnum.SimpleEntity);
	}

	@Override
	public void visit(Name entity) {
		name = entity.getValue();
	}

	@Override
	public void visit(NonTerminal entity) {
		name = entity.getValue();
	}

	protected void ensureType(Types types, String typeName) {
		AbstractPatternFilterIterator<SimpleName> i = IteratorFactory.<SimpleName>childMatcherIterator()
				.withPattern(ModelsEntityDescriptorEnum.SimpleName);
		i.reset(types);
		for (SimpleName type : i)
			if (typeName.equals(type.getValue()))
				return;
		types.wAdd(ModelsEntityFactory.instance.createSimpleName(typeName));
	}

	protected void ensureFeature(Features features, IEntityIterator<Rule> ruleIterator, As asRule) {
		String featureName = getMappedName(asRule);
		AbstractPatternFilterIterator<Feature> i = IteratorFactory.<Feature>childMatcherIterator()
				.withPattern(ModelsEntityDescriptorEnum.Feature);
		i.reset(features);
		for (Feature feature : i)
			if (featureName.equals(feature.getName().getValue()))
				return;
		features.wAdd(createFeature(ruleIterator, featureName));
	}

	protected Feature createFeature(IEntityIterator<Rule> ruleIterator, String featureName) {
		ModelsEntityFactory mf = ModelsEntityFactory.instance;
		IEntityBuilder<Feature> fb = mf.buildFeature();
		fb.set(ModelsFeatureDescriptorEnum.name, featureName);
		while (ruleIterator.hasNext()) {
			Rule rule = ruleIterator.next();
			
			switch (rule.wGetEntityOrd()) {
//			case GrammarsEntityDescriptorEnum.Optional_ord:
//				fb.set(ModelsFeatureDescriptorEnum.modifiers,
//						mf.createFeatureModifiers(
//								mf.createFeatureModifier(FeatureModifierEnum.optional)));
//				break;
			case GrammarsEntityDescriptorEnum.When_ord:
				When when = (When) rule;
				((AbstractPatternFilterIterator<Rule>) ruleIterator).skipTo(when.getRule());
				break;
			case GrammarsEntityDescriptorEnum.NonTerminal_ord:
				if (isLexicalNonTerminal((NonTerminal) rule) &&
						EntityUtils.hasParent(rule) &&
						Matcher.match(GrammarsEntityDescriptorEnum.Concatenate, rule.wGetParent()))
					break;

				fb.set(ModelsFeatureDescriptorEnum.type,
						mf.createSimpleName(getMappedEntityName((NonTerminal) rule)));
				
				IEntity ancestor = null;
				IEntityIterator<IEntity> iterator = IteratorFactory.ancestorIterator();
				iterator.reset(Matcher.findAncestor(GrammarsEntityDescriptorEnum.As, rule));
				while (iterator.hasNext() && !Matcher.match(GrammarsEntityDescriptorEnum.Production, ancestor = iterator.next()))
					if (Matcher.match(GrammarsEntityDescriptorEnum.Optional, ancestor))
						fb.set(ModelsFeatureDescriptorEnum.modifiers,
								mf.createFeatureModifiers(
										mf.createFeatureModifier(FeatureModifierEnum.optional)));

				return fb.getResult();
			}
		}
		throw new IllegalArgumentException("Missing NonTerminal");
	}

	protected String getMappedName(As as) {
		as.getName().accept(this);
		return name;
	}
	protected String getMappedEntityName(NonTerminal nt) {
		return getMappedEntityName(productionMap.get(nt.getValue()));
	}
	protected String getMappedEntityName(Production production) {
		return production.getName().getValue();//FIXME use template
	}

	protected ModelDeclaration getModelDeclaration(String name) {
		return declarationMap.get(name);
	}
	protected <T extends ModelDeclaration> T getModelDeclaration(String name, EntityDescriptor<T> ed) {
		ModelDeclaration e = declarationMap.get(name);
		T result = e.wResolveWith(ed);
		if (result != e)
			declarationMap.put(name, result);
		return result;
	}
}
