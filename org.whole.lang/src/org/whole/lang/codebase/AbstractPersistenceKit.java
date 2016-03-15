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
package org.whole.lang.codebase;

import java.nio.charset.Charset;

import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractPersistenceKit implements IPersistenceKit {
	private String name;
	private String fileExtension;
	protected boolean autoClose = true;
	
	public AbstractPersistenceKit(String name, String fileExtension) {
		this.name = name;
		this.fileExtension = fileExtension;
	}

	public IPersistenceKit withAutoClose(boolean value) {
		this.autoClose = value;
		return this;
	}

	public String getId() {
		return getClass().getName();
	}

	public String getDescription() {
		return name;// + "(*." + fileExtension + ")";
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public boolean isMultilanguage() {
		return true;
	}

	public IEntity readModel(IPersistenceProvider pp) throws Exception {
		try {
			doInitDefaultEncoding(null, pp);
			doBeforeReading(pp);
			return doAfterReading(doReadModel(pp), pp);
		} finally {
			doClose(pp);
		}
	}
	public void writeModel(IEntity model, IPersistenceProvider pp) throws Exception {
		try {
			doInitDefaultEncoding(model, pp);
			doWriteModel(doBeforeWriting(model, pp), pp);
			doAfterWriting(model, pp);
		} finally {
			doClose(pp);
		}
	}

	protected void doInitDefaultEncoding(IEntity model, IPersistenceProvider pp) throws Exception {
		String defaultEncoding = getDefaultEncoding();
		if (defaultEncoding != null)
			pp.withDefaultEncoding(defaultEncoding);
	}
	protected String getDefaultEncoding() {
		return Charset.defaultCharset().name();
	}

	protected void doBeforeReading(IPersistenceProvider pp) throws Exception {
	}
	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		throw new UnsupportedOperationException();		
	}
	protected IEntity doAfterReading(IEntity model, IPersistenceProvider pp) throws Exception {
		return model;
	}

	protected IEntity doBeforeWriting(IEntity model, IPersistenceProvider pp) throws Exception {
		return model;
	}
	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		throw new UnsupportedOperationException();
	}
	protected void doAfterWriting(IEntity model, IPersistenceProvider pp) throws Exception {
	}

	protected void doClose(IPersistenceProvider pp) throws Exception {
		if (autoClose)
			pp.closeStream();
	}

	public int compareTo(IPersistenceKit persistenceKit) {
		return getDescription().compareTo(persistenceKit.getDescription());
	}

	public String toString() {
		return getDescription();
	}
}
