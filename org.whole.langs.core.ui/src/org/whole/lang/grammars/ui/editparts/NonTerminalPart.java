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
package org.whole.lang.grammars.ui.editparts;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.grammars.model.Production;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.ui.figures.NonTerminalFigure;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractDataEntityPart;
import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class NonTerminalPart extends AbstractDataEntityPart {
	public IFigure createFigure() {
		return new NonTerminalFigure(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				final IEntity nt = getModelEntity();
				IEntity grammar = Matcher.findAncestor(GrammarsEntityDescriptorEnum.Grammar, nt);
				if (grammar != null) {
					IEntity p = Matcher.find(GenericTraversalFactory.instance.all(
							GenericMatcherFactory.instance.hasTypeMatcher(GrammarsEntityDescriptorEnum.Production),
							new AbstractVisitor() {
								public void visit(IEntity entity) {
									if (!Matcher.match(nt, ((Production) entity).getName()))
										throw new VisitException();
							}}), grammar, false);
					if (p != null)
						getViewer().selectAndReveal(p);
				}
			}
		});
	}
}