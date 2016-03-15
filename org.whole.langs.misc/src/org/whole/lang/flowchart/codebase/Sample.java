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
package org.whole.lang.flowchart.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;

public class Sample extends AbstractTemplateFactory<org.whole.lang.flowchart.model.Flowchart> {


	public void apply(IBuilderOperation op) {
		org.whole.lang.flowchart.builders.IFlowchartBuilder b0 = (org.whole.lang.flowchart.builders.IFlowchartBuilder) op.wGetBuilder(org.whole.lang.flowchart.reflect.FlowchartLanguageKit.URI);
		b0.Flowchart_();
		b0.Nodes_(7);
		b0.Join_();
		b0.Pixels(88);
		b0.Pixels(362);
		b0.Pixels(50);
		b0.Pixels(16);
		b0.Text("join");
		b0.Transitions();
		org.whole.lang.commons.builders.ICommonsBuilder b1 = (org.whole.lang.commons.builders.ICommonsBuilder) op.wGetBuilder(org.whole.lang.commons.reflect.CommonsLanguageKit.URI);
		b1.Resolver();
		b0._Join();
		b0.Exit_();
		b0.Pixels(105);
		b0.Pixels(434);
		b0.Pixels(16);
		b0.Pixels(16);
		b0.Text("exit");
		b1.Resolver();
		b0._Exit();
		b0.Block_();
		b0.Pixels(0);
		b0.Pixels(274);
		b0.Pixels(50);
		b0.Pixels(40);
		b0.Text("block");
		b1.Resolver();
		b1.Resolver();
		b0._Block();
		b0.Choice_();
		b0.Pixels(79);
		b0.Pixels(168);
		b0.Pixels(67);
		b0.Pixels(46);
		b0.Text("choice");
		b1.Resolver();
		b1.Resolver();
		b1.Resolver();
		b0._Choice();
		b0.Block_();
		b0.Pixels(88);
		b0.Pixels(69);
		b0.Pixels(50);
		b0.Pixels(40);
		b0.Text("block");
		b1.Resolver();
		b1.Resolver();
		b0._Block();
		b0.Entry_();
		b0.Pixels(105);
		b0.Pixels(3);
		b0.Pixels(16);
		b0.Pixels(16);
		b0.Text("entry");
		b1.Resolver();
		b0._Entry();
		b0.Block_();
		b0.Pixels(172);
		b0.Pixels(274);
		b0.Pixels(50);
		b0.Pixels(40);
		b0.Text("block");
		b1.Resolver();
		b1.Resolver();
		b0._Block();
		b0._Nodes();
		b0.Transitions();
		b0._Flowchart();
	}
}
