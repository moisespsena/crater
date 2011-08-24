package com.moisespsena.crater.vraptor.serialization.xstream.querystring.format;

import com.moisespsena.crater.vraptor.serialization.xstream.querystring.QSWriter.Path;
import com.thoughtworks.xstream.core.util.QuickWriter;

/**
 * Formatação no estilo array
 * 
 * <p>
 * Formata os valores da Query String em forma de array
 * </p>
 * <p>
 * Considere a Classe:
 * </p>
 * 
 * <pre>
 * <code>puclic class User {
 * 	private String name = "MyName";
 * 	private String lastName = "TheLastName";
 * 
 * 	// getters and setters ...
 * }</code>
 * </pre>
 * 
 * <p>
 * Apos a serializacao, tera resultado semelhante a:
 * </p>
 * 
 * <pre>
 * <code>user[name]=MyName&amp;user[lastName]=TheLastName</code>
 * </pre>
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 23/08/2011
 * 
 */
public class ArrayQSFormatWriter extends AbstractQSFormatWriter {

	public ArrayQSFormatWriter() {
		super();
	}

	public ArrayQSFormatWriter(final char[] varSeparator) {
		super(varSeparator);
	}

	public ArrayQSFormatWriter(final String encoding) {
		super(encoding);
	}

	public ArrayQSFormatWriter(final String encoding, final char[] varSeparator) {
		super(encoding, varSeparator);
	}

	@Override
	protected void writePathEntryBegin(final Path path,
			final QuickWriter writer, final boolean hasMore,
			final boolean isFirst) {
		if (!isFirst) {
			writer.write('[');
		}
	}

	@Override
	protected void writePathEntryEnd(final Path path, final QuickWriter writer,
			final boolean hasMore, final boolean isFirst) {
		if (!isFirst) {
			writer.write(']');
		}
	}

}
