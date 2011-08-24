+-----------------------------------------------------------------------------+
|                       Crater VRaptor Plugin                                 |
|                                                                             |
|	Author: Moises P. Sena <http://moisespsena.com>                           |
|                                                                             |
|   Crater é um conjunto de Plugins e utilitários Java para os diversos fins  |
+-----------------------------------------------------------------------------+

A) Checkout Project and Submit Changes

	1) Download and install Git
	2) Configure your user:
		
		$ git config --global user.name <Your Username>
		$ git config --global user.email <Your Email>
	             
	3) Repository checkout:
	
		$ mkdir crater
		$ cd crater
		$ git init
		$ git remote add crater-main git@github.com:moisespsena/crater.git
		$ git fetch crater-main

		$ git branch dev
		$ git checkout dev
	
	4) Your changes
	5) Commit changes:
	
		$ git commit -m 'Message'
	
	6) Merge your changed in branch 'dev' to 'master'

		$ git checkout master
		$ git merge dev

	7) Commit on remote repository:
	
		$ git push -u creater-main master
	
	More Info:
	+--------------------------------------------------------------------------------------+		
	| NOTE: http://codexico.com.br/blog/linux/tutorial-simples-como-usar-o-git-e-o-github  |
	+--------------------------------------------------------------------------------------+
	
B) Configure your development enviroment

	1) Install JDK
	2) Download Apache Maven
	3) Download Sonatype Nexus
	4) Configure Apache Maven in Sonatype Nexus
	5) Configure your Hosts resolver (*nix = /etc/hosts, Win = C:\Windows\System 32\drivers\etc\hosts)
	6) Deploy project in local Sonatype Nexus

