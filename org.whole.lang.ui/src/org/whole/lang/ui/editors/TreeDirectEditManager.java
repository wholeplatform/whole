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
package org.whole.lang.ui.editors;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.whole.lang.ui.editparts.ITreeEntityPart;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class TreeDirectEditManager {
	private final TreeTextEditor editor;
	private final ITreeEntityPart entityPart;
	private TreeDirectEditRequest request;

	public TreeDirectEditManager(ITreeEntityPart treeEntityPart) {
		this.entityPart = treeEntityPart;
		this.editor = new TreeTextEditor(getTree());
	}

	public Tree getTree() {
		return getTreeItem().getParent();
	}
	protected TreeItem getTreeItem() {
		return (TreeItem) entityPart.getWidget();
	}

	public void show() {
		final Composite composite = new Composite(editor.getTree(), SWT.NONE);
		final Text text = new Text(composite, SWT.NONE);
		composite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle rect = composite.getClientArea();
				text.setBounds(rect.x + 1, rect.y + 1, rect.width - 2, rect.height - 2);
			}
		});

		Listener listener = new CellTextEditorListener(editor);
		text.addListener(SWT.FocusOut, listener);
		text.addListener(SWT.Traverse, listener);
		text.addListener(SWT.Verify, listener);
		editor.setEditor(composite, getTreeItem());
		text.setText(DataTypeUtils.getAsPresentationString(entityPart.getModelEntity()));
		text.selectAll();
		text.setFocus();
	}

	protected void commit(String value) {
		CommandStack stack = entityPart.getViewer().getEditDomain().getCommandStack();
		stack.execute(entityPart.getCommand(getDirectEditRequest(value)));
	}
	protected TreeDirectEditRequest getDirectEditRequest(String value) {
		if (request == null)
			request = new TreeDirectEditRequest();

		request.setValue(value);
		return request;
	}

	public class CellTextEditorListener implements Listener {
		private final TreeTextEditor editor;

		private CellTextEditorListener(TreeTextEditor editor) {
			this.editor = editor;
		}

		public void handleEvent(final Event e) {
			Text text = ((Text) e.widget);
			switch (e.type) {
			case SWT.FocusOut:
				commit(text.getText());
				editor.getEditor().dispose();
				break;
			case SWT.Verify:
				String newText = text.getText();
				String leftText = newText.substring(0, e.start);
				String rightText = newText.substring(e.end, newText.length());
				GC gc = new GC(text);
				Point size = gc.textExtent(leftText + e.text + rightText);
				gc.dispose();
				size = text.computeSize(size.x, SWT.DEFAULT);
				editor.horizontalAlignment = SWT.LEFT;
				Rectangle itemRect = editor.getItem().getBounds(),
				rect = editor.getTree().getClientArea();
				editor.minimumWidth = Math.max(size.x, itemRect.width) + 2;
				int left = itemRect.x, right = rect.x + rect.width;
				editor.minimumWidth = Math.min(editor.minimumWidth, right - left);
				editor.minimumHeight = size.y + 2;
				editor.layout();
				break;
			case SWT.Traverse:
				switch (e.detail) {
				case SWT.TRAVERSE_RETURN:
					commit(text.getText());
				case SWT.TRAVERSE_ESCAPE:
					editor.getEditor().dispose();
					e.doit = false;
				}
				break;
			}
		}
	}

	public class TreeTextEditor extends TreeEditor {
		protected Tree tree;
		public TreeTextEditor(Tree tree) {
			super(tree);
			this.tree = tree;
		}
		public Tree getTree() {
			return tree;
		}
	}
}