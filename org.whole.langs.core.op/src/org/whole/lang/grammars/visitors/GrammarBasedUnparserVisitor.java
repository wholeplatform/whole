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

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.grammars.model.As;
import org.whole.lang.grammars.model.BySize;
import org.whole.lang.grammars.model.Choose;
import org.whole.lang.grammars.model.Concatenate;
import org.whole.lang.grammars.model.DataTerminal;
import org.whole.lang.grammars.model.Empty;
import org.whole.lang.grammars.model.Format;
import org.whole.lang.grammars.model.Grammar;
import org.whole.lang.grammars.model.Indent;
import org.whole.lang.grammars.model.Literal;
import org.whole.lang.grammars.model.LiteralTerminal;
import org.whole.lang.grammars.model.Name;
import org.whole.lang.grammars.model.NewLine;
import org.whole.lang.grammars.model.NonTerminal;
import org.whole.lang.grammars.model.Optional;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.model.Repeat;
import org.whole.lang.grammars.model.Rule;
import org.whole.lang.grammars.model.Space;
import org.whole.lang.grammars.model.Split;
import org.whole.lang.grammars.model.Splitter;
import org.whole.lang.grammars.model.When;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.ScannerIterator;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class GrammarBasedUnparserVisitor extends GrammarsTraverseAllVisitor {
	protected IEntity model;
	private FeatureDescriptorEnum fdEnum;
	private Appendable appendable;

	private Map<String, Production> nameProductionMap = new HashMap<String, Production>();
	private Set<String> lexiconSet = new HashSet<String>();
	private String name;

	private String delimiter = "";
	private boolean delimited = false;
	private String space = " ";
	private String newLine = "\n";
	private String indent = "    ";
	private StringBuilder indentation = new StringBuilder();
	private boolean isNewLine = true;

	protected GrammarBasedUnparserVisitor(IEntity model, IBindingManager bindingManager) {
		this.model = model;
		this.fdEnum = model.wGetEntityDescriptor().getFeatureDescriptorEnum();
		setBindings(bindingManager);
	}
	public GrammarBasedUnparserVisitor(IEntity model, Appendable appendable, IBindingManager bindingManager) {
		this(model, bindingManager);
		this.appendable = appendable;
	}

	protected String getAsString(IEntity entity) {
		return DataTypeUtils.getAsPersistenceString(entity);
	}

	protected void appendDelimiter() {
		delimited = true;
		append(delimiter);
	}
	protected void append(CharSequence csq) {
		final int csqLength = csq.length();
		if (csqLength == 0)
			return;

		try {
			if (isNewLine)
				appendable.append(indentation);
			appendable.append(csq);
		} catch (IOException e) {
			throw new IllegalStateException("cannot append characters", e);
		}

		final int newLineLength = newLine.length();
		isNewLine = csqLength >= newLineLength && newLine.equals(csq.subSequence(csqLength-newLineLength, csqLength));
	}
	protected boolean appendModelEntityAsFragment() {
		if (!EntityUtils.isFragment(model))
			return false;

		IEntity result = BehaviorUtils.evaluate(model, +1, getBindings());			
		append(PrettyPrinterOperation.toPrettyPrintString(EntityUtils.getFragmentRoot(result)));
		return true;
	}

	protected void normalize(Grammar entity) {
		Grammar g = entity;//FIXME ensure normalized: NormalizerOperation.normalize(entity);

		ScannerIterator<Production> li = IteratorFactory.<Production>childScannerIterator();
		li.reset(g.getLexicalStructure());
		for (Production p : li) {
			String name = p.getName().getValue();
			nameProductionMap.put(name, p);
			lexiconSet.add(name);
		}
		ScannerIterator<Production> pi = IteratorFactory.<Production>childScannerIterator();
		pi.reset(g.getPhraseStructure());
		for (Production p : pi)
			nameProductionMap.put(p.getName().getValue(), p);
	}

	protected final boolean isLexicon(NonTerminal nt) {
		return isLexicon(nt.getValue());
	}
	protected final boolean isLexicon(String nt) {
		return lexiconSet.contains(nt);
	}

	public void unparse(IEntity model) {
		this.model = model;
	}
	
	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		if (EntityUtils.isFragment(entity))
			return true;
		else
			return super.visitAdapter(entity);
	}

	@Override
	public void visit(Grammar entity) {
		LiteralTerminal lt = entity.getDelimiter();
		if (EntityUtils.isNotResolver(lt))
			delimiter = lt.getLiteral().getValue();
		space = EntityUtils.safeStringValue(entity.getSpaceLiteral(), space);
		indent = EntityUtils.safeStringValue(entity.getIndentLiteral(), indent);
		newLine = EntityUtils.safeStringValue(entity.getNewLineLiteral(), newLine);

		normalize(entity);

		if (!appendModelEntityAsFragment())
			nameProductionMap.get(model.wGetEntityDescriptor().getName()).accept(this);

		if (delimited)
			appendDelimiter();
	}

	@Override
	public void visit(Production entity) {
		int indentationLength = indentation.length();

		entity.getRule().accept(this);

		if (!isLexicon(entity.getName()))
			indentation.setLength(indentationLength);
	}

	@Override
	public void visit(Concatenate entity) {
		if (!appendModelEntityAsFragment())
			for (int i = 0; i < entity.wSize(); i++)
				((Rule) entity.wGet(i)).accept(this);
	}

	@Override
	public void visit(Repeat entity) {
		if (!appendModelEntityAsFragment()) {
			IEntity parentEntity = model;
			for (int i=0; i<parentEntity.wSize(); i++) {
				model = parentEntity.wGet(i);
				if (i>0)
					entity.getSeparator().accept(this);
				entity.getRule().accept(this);
			}
			model = parentEntity;
		}
	}

	@Override
	public void visit(Optional entity) {
		As as = Matcher.find(GrammarsEntityDescriptorEnum.As, entity, false);
		if (as ==  null || (as != null && !EntityUtils.isResolver(model.wGet(fdEnum.valueOf(as.getName().getValue())))))
			entity.getRule().accept(this);
	}

	@Override
	public void visit(When entity) {
		entity.getRule().accept(this);
	}

	private IVisitor phraseNonTerminal = GenericTraversalFactory.instance.all(
			GenericMatcherFactory.instance.hasTypeMatcher(GrammarsEntityDescriptorEnum.NonTerminal),
			new AbstractVisitor() {
				public void visit(IEntity entity) {
					if (isLexicon((NonTerminal) entity))
						throw new VisitException();
				}
			});

	@Override
	public void visit(Choose entity) {
		if (!appendModelEntityAsFragment()) {
			if (Matcher.match(GrammarsEntityDescriptorEnum.As, entity.wGet(0)))
				append(getAsString(model));
			else {
				// get rule using model entity
				EntityDescriptorEnum edEnum = model.wGetLanguageKit().getEntityDescriptorEnum();

				Rule rule = null;
				for (int size=entity.wSize(), i=0; rule == null && i<size; i++) {
					Rule child = (Rule) entity.wGet(i);

					NonTerminal nt = (NonTerminal) Matcher.find(phraseNonTerminal, child, false);
					if (Matcher.isAssignableAsIsFrom(edEnum.valueOf(nt.getValue()), model))//TODO test was isAssignableFrom
						rule = child;
				}

				if (rule != null)
					rule.accept(this);
				else
					throw new IllegalStateException("missing choose rule for model entity");
			}
		}
	}

	@Override
	public void visit(As entity) {
		entity.getName().accept(this);//get the feature name
		IEntity parentEntity = model;
		model = model.wGet(fdEnum.valueOf(name));
		entity.getRule().accept(this);
		model = parentEntity;
	}
	
	@Override
	public void visit(NonTerminal entity) {
		nameProductionMap.get(entity.getValue()).accept(this);
	}

	@Override
	public void visit(Name entity) {
		name = entity.getValue();
	}

	@Override
	public void visit(Empty entity) {
		entity.getLiteral().accept(this);
	}
	
	@Override
	public void visit(Space entity) {
		append(space);
	}
	
	@Override
	public void visit(Indent entity) {
		if (isNewLine)
			indentation.append(indent);
		else
			append(indent);
	}
	
	@Override
	public void visit(NewLine entity) {
		append(newLine);
	}

	@Override
	public void visit(LiteralTerminal entity) {
		appendDelimiter();
		entity.getLiteral().accept(this);
	}

	@Override
	public void visit(DataTerminal entity) {
		appendDelimiter();
		if (!appendModelEntityAsFragment())
			entity.getFormat().accept(this);
	}

	@Override
	public void visit(Format entity) {
		append(getAsString(model));
	}

	@Override
	public void visit(Literal entity) {
		IEntity result;

		if (EntityUtils.isFragment(entity)) {
			IBindingManager bindings = getBindings();
			bindings.wEnterScope();
			bindings.wDef("self", model);
			result = BehaviorUtils.evaluate(entity, 0, bindings);
			bindings.wExitScope();
		} else
			result = entity;

		append(result.wStringValue());
	}

	public void visit(Split entity) {
		Splitter splitter = entity.getSplitter();
		//FIXME workaround
		if (Matcher.matchImpl(GrammarsEntityDescriptorEnum.BySize, splitter)) {
			// use a temporary appendable
			Appendable oldAppendable = appendable;
			StringBuilder sb;
			appendable = sb = new StringBuilder();
			entity.getRule().accept(this);
			appendable = oldAppendable;
			// pad the result buffer
			int size = ((BySize) splitter).getValue();
			for (int i=sb.length(); i<size; i++)
				sb.append(' ');
			append(sb.toString());
		} else
			super.visit(entity);
	}
}
