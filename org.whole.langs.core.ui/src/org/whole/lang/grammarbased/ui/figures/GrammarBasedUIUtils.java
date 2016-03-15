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
package org.whole.lang.grammarbased.ui.figures;

import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.figures.CompositeFigure;
import org.whole.lang.ui.figures.CompositePlaceHolderBorder;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.StringSeparatedCompositeColumnFigure;
import org.whole.lang.ui.figures.StringSeparatedCompositeRowFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.ICompositeEntityLayout;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.StackLayout;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;


/**
 * @author Enrico Persiani
 */
public class GrammarBasedUIUtils {
	public static IEntityFigure createSequenceFigure(IEntity entity, ContentPaneFigure contentPaneFigure, boolean embed) {
		FeatureDescriptorEnum fdEnum = entity.wGetLanguageKit().getFeatureDescriptorEnum();
		IEntity multiline = entity.wGet(fdEnum.valueOf("multiline"));
		ICompositeEntityLayout layout = EntityUtils.safeBooleanValue(multiline, false) ?
				new ColumnLayout() : new RowLayout();

		//TODO complete optional behavior
		IEntity optional = entity.wGet(fdEnum.valueOf("optional"));

		IEntityFigure figure;
		if (embed) {
			contentPaneFigure.setLayoutManager(layout.withSpacing(5));
			figure = contentPaneFigure;
		} else
			figure = new EntityFigure(layout.withSpacing(5));

		IEntity childFigures = entity.wGet(fdEnum.valueOf("figures"));
		for (int i=0, size=childFigures.wSize(); i<size; i++)
			addChildFigure(childFigures.wGet(i), contentPaneFigure, figure);

		return figure;
	}

	public static IEntityFigure createTerminalFigure(IEntity entity) {
		FeatureDescriptorEnum fdEnum = entity.wGetLanguageKit().getFeatureDescriptorEnum();

		IEntity category = entity.wGet(fdEnum.valueOf("category"));
		IEntity literal = entity.wGet(fdEnum.valueOf("literal"));

		EntityLabel label = createEntityLabel(category);
		label.setText(StringUtils.unescapeString(DataTypeUtils.getAsPresentationString(literal)));

		return label;
	}

	public static IEntityFigure createIndent() {
		return new EntityFigure(new StackLayout().withMarginLeft(32 - 5));
	}

	public static IEntityFigure createNonTerminalFigure(IEntity entity, ContentPaneFigure contentPaneFigure) {
		int i=0, size=contentPaneFigure.getContentPanesSize();
		for (; i<size; i++)
			if (contentPaneFigure.getContentPane(i) == null)
				break;
		return (IEntityFigure) (contentPaneFigure instanceof CompositeEntityFigure ?
				contentPaneFigure.createContentPane(i, createCompositeFigure(entity)) :
					contentPaneFigure.createContentPane(i));
	}

		
	public static void addChildFigure(IEntity entity, ContentPaneFigure contentPaneFigure, IEntityFigure parent) {
		addChildFigure(entity, contentPaneFigure, parent, false);
	}
	public static void addChildFigure(IEntity entity, ContentPaneFigure contentPaneFigure, IEntityFigure parent, boolean embed) {
		if (!EntityUtils.isNotResolver(entity))
			return;

		String edName = entity.wGetEntityDescriptor().getName();
		if ("SequenceFigure".equals(edName)) {
			IEntityFigure child = createSequenceFigure(entity, contentPaneFigure, embed);
			if (!embed)
				parent.add(child);
		}
		else if ("NonTerminalFigure".equals(edName))
			parent.add(createNonTerminalFigure(entity, contentPaneFigure));
		else if ("TerminalFigure".equals(edName))
			parent.add(createTerminalFigure(entity));
		else if ("Indent".equals(edName))
			parent.add(createIndent());
	}

	public static EntityLabel createEntityLabel(IEntity entity) {
		String category = DataTypeUtils.getAsPresentationString(entity);
		EntityLabel label = null;

		if ("KEYWORD".equals(category))
			label = LabelFactory.createKeyword();
		else if ("DELIMITER".equals(category))
			label = LabelFactory.createLiteral();
		else if ("IDENTIFIER".equals(category))
			label = LabelFactory.createIdentifier();
		else if ("LITERAL".equals(category))
			label = LabelFactory.createContent();
		else if ("OPERATOR".equals(category))
			label = LabelFactory.createContentLight();
		else if ("PARENTHESIS".equals(category))
			label = LabelFactory.createContentLighter();
		else if ("SEPARATOR".equals(category))
			label = LabelFactory.createLiteral();//FIXME missing label category

		return label;
	}

	public static String calculateSeparator(IEntity entity) {
		EntityDescriptorEnum edEnum = entity.wGetLanguageKit().getEntityDescriptorEnum();

		StringBuilder sb = new StringBuilder();
		IEntityIterator<IEntity> iterator = IteratorFactory.descendantOrSelfMatcherIterator().withPattern(edEnum.valueOf("Literal"));
		iterator.reset(entity);
		while (iterator.hasNext())
			sb.append(EntityUtils.safeStringValue(iterator.next(), ""));
		String separatorText = sb.toString();
		return separatorText.trim();
	}

	public static IEntityFigure createCompositeFigure(IEntity entity) {
		ILanguageKit lk = entity.wGetLanguageKit();
		EntityDescriptorEnum edEnum = lk.getEntityDescriptorEnum();
		FeatureDescriptorEnum fdEnum = lk.getFeatureDescriptorEnum();

		IEntity configuration = Matcher.findAncestor(edEnum.valueOf("CompositePart"), entity);

		IEntity multiline = configuration.wGet(fdEnum.valueOf("multiline"));
		boolean isMultiline = EntityUtils.safeBooleanValue(multiline, false);

		IEntity columns = configuration.wGet(fdEnum.valueOf("columns"));
		int columnsNum = EntityUtils.safeIntValue(columns, 0);

		IEntity separator = configuration.wGet(fdEnum.valueOf("separator"));

		IEntityFigure entityFigure;
		if (EntityUtils.isNotResolver(separator)) {
			String separatorText = GrammarBasedUIUtils.calculateSeparator(separator);
			CompositeFigure compositeFigure = isMultiline ? new StringSeparatedCompositeColumnFigure(separatorText, 10) :
				new StringSeparatedCompositeRowFigure(separatorText, 10);
			if (isMultiline)
				compositeFigure.getLayoutManager().withMinorAlignment(Alignment.LEADING);
			entityFigure = compositeFigure;
		} else if (columnsNum > 0) {
			TableFigure tableFigure = new TableFigure(columnsNum);
			tableFigure.setBorder(CompositePlaceHolderBorder.OPTIONAL_VERTICAL);
			entityFigure = tableFigure;
		} else
			entityFigure = new CompositeFigure(!isMultiline, true);

		return entityFigure;
	}
}
