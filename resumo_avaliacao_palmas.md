# Resumo da Avaliação - Equipe Palmas (OAT 1)

## 1. Arquivos Revisados
- `src/main/java/br/com/mecaniqa/Peca.java`
- `src/main/java/br/com/mecaniqa/Servico.java`
- `src/main/java/br/com/mecaniqa/Gerenciador.java`
- `src/main/java/br/com/mecaniqa/MecaniQAApplication.java`

## 2. Grade de Avaliação (Barema)

| Critério | Peso | Porcentagem Atingida | Nota Obtida | Resumo da Avaliação |
| :--- | :---: | :---: | :---: | :--- |
| **Aspectos dos Códigos** — Nome significativos de Classes, atributos e métodos | 0,5 | 75% | 0,38 | Maioria dos nomes é clara, mas há parâmetros e variáveis confusos (`Peca nome`, `Servico y`, variável `codigoPeca` armazenando índice retornado pela busca) e inconsistência (`buscarPeca` vs `procurarServico`). |
| **Aspectos dos Códigos** — Nomenclatura de identificadores de acordo com o estilo da linguagem | 0,5 | 100% | 0,50 | Padrões do Java respeitados corretamente (PascalCase para classes, camelCase para métodos/variáveis e UPPER_SNAKE_CASE para constantes). |
| **TADs e Gerenciador** — Estrutura Base: Definição das classes Peça e Serviço (TADs) estritamente como structs, contendo apenas atributos públicos e nenhum método interno. | 1,0 | 25% | 0,25 | Embora os atributos sejam públicos e sem getters/setters, as classes `Peca` e `Servico` não são structs: contêm construtores, arrays estáticos e todos os métodos de negócio (CRUD) dentro delas. |
| **TADs e Gerenciador** — Memória: Declaração e inicialização correta dos arrays unidimensionais de tamanho fixo para armazenar os dados. | 1,0 | 100% | 1,00 | Arrays estáticos unidimensionais (`Peca[100]` e `Servico[50]`) declarados e inicializados corretamente, sem uso de Collections de `java.util`. |
| **TADs e Gerenciador** — Isolamento: Toda a lógica de negócio (CRUD) foi isolada e implementada através de métodos estáticos na classe de Gerenciador | 1,0 | 25% | 0,25 | Os métodos são estáticos, porém não foram isolados na classe `Gerenciador` (que contém apenas um `main` de teste). Toda a lógica CRUD ficou acoplada dentro das próprias classes `Peca` e `Servico`. |
| **Listas Estáticas** — Algoritmo (Busca): Implementação correta do método estático de Busca Linear, retornando o índice do registro ou um indicativo de erro. | 1,0 | 100% | 1,00 | `buscarPeca` e `procurarServico` implementam corretamente a busca linear até o índice válido, retornando o índice encontrado ou `-1`. |
| **Listas Estáticas** — Os métodos de atualização chamam obrigatoriamente os métodos de Busca Linear para descobrir o índice do objeto antes de acessar os atributos diretamente para modificá-los. | 1,0 | 75% | 0,75 | Ambos `mudarPeca` e `mudarServico` chamam a busca linear e modificam os atributos públicos diretamente. Porém, há um bug em `Peca.mudarPeca`: na atualização de `quantidade`, foi usado `pecas[codigoBusca]` (o código) em vez de `pecas[codigoPeca]` (o índice). |
| **Listas Estáticas** — Inserção de Peça: O método isolado adiciona a peça corretamente no primeiro espaço vazio e incrementa a variável de controle específica do array de peças. | 1,0 | 100% | 1,00 | Verifica capacidade máxima (`proximoIndex < MAX_PECAS`), insere diretamente em `pecas[proximoIndex]` e incrementa `proximoIndex` (incluindo método extra de inserção por posição). |
| **Listas Estáticas** — Remoção de Peça: Algoritmo (Busca) e reorganização dos elementos contíguos do array de peças, atualizando o índice de controle sem deixar "buracos". | 1,0 | 100% | 1,00 | Chama `buscarPeca`, realiza shift-left corretamente sem deixar buracos e decrementa `proximoIndex` (dica: limpar a última posição com `null`). |
| **Listas Estáticas** — Inserção de Serviço: O método isolado adiciona o serviço no primeiro espaço vazio e incrementa a variável de controle específica do array de serviços. | 1,0 | 100% | 1,00 | Verifica capacidade máxima (`indexValido < MAX_SERVICOS`), insere em `servicos[indexValido]` e incrementa `indexValido`. |
| **Listas Estáticas** — Remoção de Serviço: O método aplica exclusão lógica ou reorganiza os elementos contíguos do array de serviços, atualizando o índice de controle sem deixar "buracos". | 1,0 | 100% | 1,00 | Chama `procurarServico`, reorganiza os elementos sem deixar buracos e decrementa `indexValido` (dica: atribuir `null` à última posição liberada). |

## 3. Resultado Final
- **Aspectos dos Códigos:** 0,88 / 1,00 (0,875)
- **TADs e Gerenciador:** 1,50 / 3,00
- **Listas Estáticas:** 5,75 / 6,00
- **Nota Final:** **8,13 / 10,00** (exato: 8,125)

**Considerações Gerais:** Excelente domínio dos algoritmos de listas estáticas (inserção em O(1) com checagem de limite, busca linear retornando índice/-1, remoção com shift-left e até inserção em posição arbitrária!). Os pontos que descontaram nota foram de arquitetura/organização: a lógica de negócio e os arrays foram colocados dentro das classes `Peca` e `Servico` em vez de serem isolados no `Gerenciador` (quebrando a regra de structs), além de um pequeno bug de índice em `mudarPeca` (`pecas[codigoBusca].quantidade`).
