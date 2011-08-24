+-----------------------------------------------------------------------------+
|                       Crater VRaptor Plugin                                 |
|                                                                             |
|	Author: Moises P. Sena <http://moisespsena.com>                           |
|                                                                             |
|   Crater VRaptor é um plugin pra o Framework WEB VRaptor da Caelum          |
|      (http://vraptor.caelum.com.br)                                         |
+-----------------------------------------------------------------------------+

Para usar os componentes deste plugin no VRaptor, configure o seu 
WEB-INF/web.xml:

	Se parametro de contexto "br.com.caelum.vraptor.packages" nao existir,
	adicione a seguinte entrada:
	
		<context-param>
			<param-name>br.com.caelum.vraptor.packages</param-name>
			<param-value>com.moisespsena.crater.vraptor</param-value>
		</context-param>
		
	Caso exista, apenas adicione o pacote "com.moisespsena.crater.vraptor",
	na tage "param-value" separando com ",", como abaixo:
		
		<context-param>
			<param-name>br.com.caelum.vraptor.packages</param-name>
			<param-value>OTHER_PACKAGE,com.moisespsena.crater.vraptor</param-value>
		</context-param>