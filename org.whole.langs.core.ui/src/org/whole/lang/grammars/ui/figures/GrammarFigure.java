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
package org.whole.lang.grammars.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.HeadersTableFigure;
import org.whole.lang.ui.figures.TableFigure;
import org.whole.lang.ui.figures.TableRowFigure;
import org.whole.lang.ui.layout.ColumnLayout;

/**
 * @author Riccardo Solmi
 */
public class GrammarFigure extends ContentPaneFigure {
	public GrammarFigure() {
		initContentPanes(12);
		setLayoutManager(new ColumnLayout().withSpacing(10).withMargin(16, 16, 10, 16));

		IFigure headersFigure = new HeadersTableFigure();

		TableRowFigure uriRowFigure = new TableRowFigure();
		uriRowFigure.addContentLighter("URI");
		uriRowFigure.add(createContentPane(0));
		headersFigure.add(uriRowFigure);
		
		TableRowFigure namespaceRowFigure = new TableRowFigure();
		namespaceRowFigure.addContentLighter("Namespace");
		namespaceRowFigure.add(createContentPane(1));
		headersFigure.add(namespaceRowFigure);

		TableRowFigure grammarRowFigure = new TableRowFigure();
		grammarRowFigure.addContentLighter("Grammar Name");
		grammarRowFigure.add(createContentPane(2));
		headersFigure.add(grammarRowFigure);

		TableRowFigure versionRowFigure = new TableRowFigure();
		versionRowFigure.addContentLighter("Version");
		versionRowFigure.add(createContentPane(3));
		headersFigure.add(versionRowFigure);

		TableRowFigure targetLanguageRowFigure = new TableRowFigure();
		targetLanguageRowFigure.addContentLighter("Target Language");
		targetLanguageRowFigure.add(createContentPane(4));
		headersFigure.add(targetLanguageRowFigure);

		TableRowFigure startSymbolRowFigure = new TableRowFigure();
		startSymbolRowFigure.addContentLighter("Start Symbol");
		startSymbolRowFigure.add(createContentPane(5));
		headersFigure.add(startSymbolRowFigure);

		add(headersFigure);

		Label l1 = (Label) addKeyword("Phrase Structure");
		l1.setBorder(new MarginBorder(20,0,0,0));
		l1.setTextAlignment(PositionConstants.TOP);
		
		add(createContentPane(7, new MarginBorder(0,4,0,0)));
		
		Label l2 = (Label) addKeyword("Lexical Structure");
		l2.setBorder(new MarginBorder(20,0,0,0));
		l2.setTextAlignment(PositionConstants.TOP);

		IFigure lexicalTableFigure = new TableFigure(2);

		TableRowFigure delimiterRowFigure = new TableRowFigure();
		delimiterRowFigure.addContentLighter("Delimiter");
		delimiterRowFigure.add(createContentPane(6));
		lexicalTableFigure.add(delimiterRowFigure);

		TableRowFigure spaceLiteralRowFigure = new TableRowFigure();
		spaceLiteralRowFigure.addContentLighter("Space Literal");
		spaceLiteralRowFigure.add(createContentPane(9));
		lexicalTableFigure.add(spaceLiteralRowFigure);

		TableRowFigure indentLiteralRowFigure = new TableRowFigure();
		indentLiteralRowFigure.addContentLighter("Indent Literal");
		indentLiteralRowFigure.add(createContentPane(10));
		lexicalTableFigure.add(indentLiteralRowFigure);

		TableRowFigure newLineLiteralRowFigure = new TableRowFigure();
		newLineLiteralRowFigure.addContentLighter("New Line Literal");
		newLineLiteralRowFigure.add(createContentPane(11));
		lexicalTableFigure.add(newLineLiteralRowFigure);

		add(lexicalTableFigure);

		add(createContentPane(8, new MarginBorder(0,4,0,0)));
	}
}
