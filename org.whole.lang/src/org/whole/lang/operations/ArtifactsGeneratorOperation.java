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
package org.whole.lang.operations;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.BehaviorUtils;

/**
 * @author Riccardo Solmi
 */
public class ArtifactsGeneratorOperation extends AbstractOperation {
	public static final String ID = "ArtifactsGenerator";

	public static void generate(IEntity program, IBindingManager args) {
		ArtifactsGeneratorOperation gen = new ArtifactsGeneratorOperation(args);
		gen.stagedVisit(program);
		gen.stagedVisit(gen.getResult());
	}

	protected ArtifactsGeneratorOperation(IBindingManager args) {
		super(ID, args, null);

		if (!args.wIsSet("workspace")) {
			IEntity ws = ReflectionFactory.getLanguageKit("http://lang.whole.org/Artifacts", false, null).getTemplateManager().create("workspace template");
			ws = BehaviorUtils.evaluate(ws, 1, args);
			args.wDef("workspace", ws);
		}

		getEnvironmentManager().createEnvironment("artifacts", args).wEnterScope();
	}

	public IEntity getResult() {
		IBindingManager bm = getArtifactsEnvironment();
		if (bm.wIsSet("packageArtifactsPoint") && bm.wGet("packageArtifactsPoint").wIsEmpty() &&
				bm.wGet("packagesPoint").wSize() == 1 &&
				bm.wGet("projectArtifactsPoint").wSize() == 1)
			bm.wGet("projectsPoint").wRemove(bm.wGet("projectArtifactsPoint").wGetParent());

		IEntity workspace = bm.wGet("workspace");
		Matcher.substitute(workspace, bm, false);
		Matcher.removeVars(workspace, false);
		return workspace;
	}

	public IBindingManager getArtifactsEnvironment() {
		return getEnvironmentManager().getEnvironment("artifacts");
	}
}
