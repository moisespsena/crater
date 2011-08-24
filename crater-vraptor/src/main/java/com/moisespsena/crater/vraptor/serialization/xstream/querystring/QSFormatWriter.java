package com.moisespsena.crater.vraptor.serialization.xstream.querystring;

import java.util.List;

import com.moisespsena.crater.vraptor.serialization.xstream.querystring.QSWriter.Path;
import com.thoughtworks.xstream.core.util.QuickWriter;

/**
 * Escritor em Formação
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 23/08/2011
 * 
 */
public interface QSFormatWriter {
	/**
	 * Grava o caminho formatado, ou seja, o nome da variavel Query String
	 * 
	 * @param paths
	 * @param writer
	 */
	public void writePath(List<Path> paths, QuickWriter writer);

	/**
	 * Grava o valor formatado
	 * 
	 * @param value
	 * @param writer
	 */
	public void writeValue(String value, QuickWriter writer);
}
