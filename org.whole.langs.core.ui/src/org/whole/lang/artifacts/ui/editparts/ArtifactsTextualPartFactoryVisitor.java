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
package org.whole.lang.artifacts.ui.editparts;

import org.eclipse.gef.EditPart;
import org.whole.lang.artifacts.model.FileArtifact;
import org.whole.lang.artifacts.model.IArtifactsEntity;
import org.whole.lang.artifacts.model.Metadata;
import org.whole.lang.artifacts.model.NameWithExtension;
import org.whole.lang.artifacts.visitors.ArtifactsIdentityDefaultVisitor;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class ArtifactsTextualPartFactoryVisitor extends ArtifactsIdentityDefaultVisitor implements IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IArtifactsEntity) modelEntity).accept(this);
		return part;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	public void visit(IArtifactsEntity entity) {
		part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
	}

	public void visit(FileArtifact entity) {
		part = new FileArtifactPart();
	}

	public void visit(Metadata entity) {
		part = new MetadataPart();
	}

	public void visit(NameWithExtension entity) {
		part = new NameWithExtensionPart();
	}
}