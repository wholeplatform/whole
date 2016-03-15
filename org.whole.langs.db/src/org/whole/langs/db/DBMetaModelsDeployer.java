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
package org.whole.langs.db;

import org.whole.lang.dbcfg.reflect.DBCFGLanguageKit;
import org.whole.lang.rdb.reflect.RDBLanguageKit;
import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.sql.reflect.SQLLanguageKit;

/**
 * @author Enrico Persiani
 */
public class DBMetaModelsDeployer extends AbstractLanguageExtensionDeployer {
	public void deploy(ReflectionFactory platform) {
		platform.setMetaModelTemplate(DBCFGLanguageKit.URI, "org.whole.lang.models.codebase.DBCFGModel");
		platform.setMetaModelTemplate(RDBLanguageKit.URI, "org.whole.lang.models.codebase.RDBModel");
		platform.setMetaModelTemplate(SQLLanguageKit.URI, "org.whole.lang.models.codebase.SQLModel");
	}

	public void undeploy(ReflectionFactory platform) {
		platform.unsetMetaModelTemplate(DBCFGLanguageKit.URI);
		platform.unsetMetaModelTemplate(RDBLanguageKit.URI);
		platform.unsetMetaModelTemplate(SQLLanguageKit.URI);
	}
}
