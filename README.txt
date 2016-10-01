Requisitos para a execução:
Netbeans 8, jdk, jre

Passos:

- Baixe a pasta .zip do projeto disponível no GitHub

- Importe o projeto no NetBeans através do menu File >> Import Project >> From ZIP

- Na aba Services, crie um novo Java DB com nome db_test1, usuário 'ronny', senha '123'
	- Conecte-se ao banco recém-criado clicando com o botão direito e depois em 'Connect'
	- Expanda o schema 'RONNY' e clique com o botão direito do mouse na pasta 'Tables'
	- Para criar cada tabela do banco, clique em 'Recreate Table' e selecione o arquivo .grab na pasta 'db_table_structures' da tabela de nome correspondente

- Siga os passos no arquivo db_environment_setup.txt para adicionar as bibliotecas derby.jar e derbyclient.jar ao projeto

- Baixe as seguintes tabelas:
	- http://agencia.tse.jus.br/estatistica/sead/odsele/perfil_eleitor_secao/perfil_eleitor_secao_2014_RN.zip
	- http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_cand/consulta_cand_2014.zip
	- http://agencia.tse.jus.br/estatistica/sead/odsele/bem_candidato/bem_candidato_2014.zip
	- http://agencia.tse.jus.br/estatistica/sead/odsele/consulta_legendas/consulta_legendas_2014.zip
	- http://agencia.tse.jus.br/estatistica/sead/odsele/votacao_candidato_munzona/votacao_candidato_munzona_2014.zip
	- http://agencia.tse.jus.br/estatistica/sead/odsele/votacao_partido_munzona/votacao_partido_munzona_2014.zip
	- http://www.tse.jus.br/hotSites/pesquisas-eleitorais/resultados_anos/votacao/votacao_secao_eleitoral_2014.html

- Nas classes FileTableReader, modifique PATH para o destino do arquivo de texto da tabela correspondente baixada no passo anterior

- Na classe Main, execute os seguintes comandos:
	- DAOTSE myDAO = new DAOTSE();
	- myDAO.connect();
	- // Para cada tabela do banco:
	- myDAO.insertAll[nome_da_tabela]();
	- myDAO.disconnect();

Para abrir o programa pela interface, execute o arquivo GUI.java. O botão 'Query' realiza uma busca que ainda está sendo aprimorada.
