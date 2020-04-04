/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.swiftsyntax.codebase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.whole.lang.codebase.AbstractSpecificPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.StreamPersistenceProvider;
import org.whole.lang.json.codebase.JSONLDPersistenceKit;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class SwiftSyntaxSourcePersistenceKit extends AbstractSpecificPersistenceKit {
	public static final String FORMAT_PARAM = "swiftsyntax#format";

	private static class SingletonHolder {
		private static final SwiftSyntaxSourcePersistenceKit instance = new SwiftSyntaxSourcePersistenceKit();
	}
	public static final SwiftSyntaxSourcePersistenceKit instance() {
		return SingletonHolder.instance;
	}
	private SwiftSyntaxSourcePersistenceKit() {
		super("SwiftSyntax", "swift", "whole:org.whole.lang.swiftsyntax:SwiftSyntaxModel");
	}

	public boolean isMultilanguage() {
		return false;
	}

	protected void doInitDefaultEncoding(IEntity model, IPersistenceProvider pp) throws Exception {
		String encoding = getDefaultEncoding();

		if (model == null)
			encoding = StringUtils.encodingFromBOM(pp.getInputStream(), encoding);

		pp.withDefaultEncoding(encoding);
	}
	protected String getDefaultEncoding() {
		return "UTF-8";
	}

	protected void streamToSwiftSyntaxSerializer(InputStream input, OutputStream output, String mode) throws Exception {
		ProcessBuilder processBuilder = new ProcessBuilder("/usr/local/bin/SwiftSyntaxSerializer");
		processBuilder.command().add(mode);
		processBuilder.redirectErrorStream(true);
		Process process = processBuilder.start();

		InputStream processOutput = process.getInputStream();
		Thread reader = new Thread(() -> {
			try {
				byte[] buffer = new byte[1024];
				int length;
				while ((length = processOutput.read(buffer)) > 0)
					output.write(buffer, 0, length);
				output.flush();
			} catch (IOException e) {
			}
		});

		OutputStream processInput = process.getOutputStream();
		Thread writer = new Thread(() -> {
			try {
				byte[] buffer = new byte[1024];
				int length;
				while ((length = input.read(buffer)) > 0)
					processInput.write(buffer, 0, length);
				processInput.close();
			} catch (IOException e) {
			}
		});
		reader.start();
		writer.start();

		if (process.waitFor() != 0)
			throw new IllegalStateException("Error during native SwiftSyntax serialization");
	}

	protected IEntity doReadModel(IPersistenceProvider pp) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		streamToSwiftSyntaxSerializer(pp.getInputStream(), baos, "parse");
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		return JSONLDPersistenceKit.instance().readModel(new StreamPersistenceProvider(bais));
	}

	protected void doWriteModel(IEntity model, IPersistenceProvider pp) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JSONLDPersistenceKit.instance().writeModel(model, new StreamPersistenceProvider(baos));
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		streamToSwiftSyntaxSerializer(bais, pp.getOutputStream(),
				pp.getBindings().wIsSet(FORMAT_PARAM) && pp.getBindings().wBooleanValue(FORMAT_PARAM) ? "format" : "unparse");
	}
}
