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
package org.whole.lang.visitors;

import org.whole.gen.JavaModelGenerator;
import org.whole.lang.artifacts.model.Author;
import org.whole.lang.artifacts.model.Copyright;
import org.whole.lang.artifacts.model.License;
import org.whole.lang.artifacts.model.PackageName;
import org.whole.lang.artifacts.visitors.ArtifactsTraverseAllVisitor;
import org.whole.lang.operations.JavaCompilerOperation;


/**
 * @author Riccardo Solmi
 */
public class ArtifactsJavaModelGeneratorVisitor extends ArtifactsTraverseAllVisitor {
	public ArtifactsJavaModelGeneratorVisitor() {
		super(null);
		wSetVisitor1(this);
	}

	protected JavaModelGenerator getGenerator() {
		return (JavaModelGenerator) ((JavaCompilerOperation) getOperation()).getGenerator();
	}


	public void visit(Copyright entity) {
		getGenerator().setCopyright(entity.getValue());
	}

	public void visit(License entity) {
		getGenerator().setLicense(entity.getValue());
	}

	public void visit(Author entity) {
		getGenerator().setAuthor(entity.getValue());
	}

	public void visit(PackageName entity) {
		getGenerator().setBasePackagePrefix(entity.wStringValue());
	}
}
