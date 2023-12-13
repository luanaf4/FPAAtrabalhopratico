# Resultados do Algoritmo de Programação Dinâmica

### Explicação da Implementação do Algoritmo



### Resultados dos Conjuntos Especificados
```text
Total de Km por conjunto de rotas do Caminhão 1:[300Km, 335Km]
Total de Km por conjunto de rotas do Caminhão 2:[300Km, 311Km]
Total de Km por conjunto de rotas do Caminhão 3:[300Km, 334Km]
```

 - A maior diferença de rotas no primeiro conjunto é igual a `0` Km.
 - A maior diferença de rotas no segundo conjunto é de `24` Km.

> **Notas:** Antes de chegar a este resultado eu testei esse mesmo algoritmo sem ordenar as rotas previamente e os resultados foram:
>```
> Total de Km por conjunto de rotas do Caminhão 1:[310Km, 332Km]
> Total de Km por conjunto de rotas do Caminhão 2:[303Km, 305Km]
> Total de Km por conjunto de rotas do Caminhão 3:[287Km, 343Km]
>```
> - A maior diferença de rotas no primeiro conjunto é igual a `23` Km.
> - A maior diferença de rotas no segundo conjunto é de `38` Km.
 

### Resultados dos Testes do Trabalho
Os integrantes do meu grupo encontraram o seguinte cenário que atingisse um tempo de execução em até 30 segundos na solução feita em Backtracking

 - Quantidade de Caminhões: 3
 - Quantidade de Rotas: 22 (variável que se modificou)
 - Quantidade de Conjuntos de Rotas: 10

Foi mantido a quantidade de conjuntos de rotas e incrementado a quantidade de rotas do problema até que foi encontrado o valor 22 que é o valor anterior para que o algoritmo gaste mais de 30 segundos em execução.

Visto esse cenário, para o teste do algoritmo de Programação dinâmica foi feito da seguinte forma:

#### Execuções Juntas
Execuções Juntas se consiste em um único código que irá calcular todas as situações em uma única execução, isso é, irá calcular 10 diferetes valores de T 10 vezes cada um para gerar a média de tempo gasto por eles.

**Valores Iniciais**
 - Quantidade de Caminhões: 3
 - Quantidade de Rotas: $\sum_{i=1}^{10} (22 \cdot i)$
 - Quantidade de Conjuntos de Rotas: 10

A partir desses valores, o algoritmo é executado 10 vezes antes que o conjunto aumente para se calcular a média do tempo gasto dentro dessas 10 execuções.
Após isso o número de quantidade de rotas é multiplicado pelo número da iteração no momento, portanto na primeira execução o número de rotas é igual a 22, na segunda iteração é 22 * 2, na terceira 22 * 3 e etc...
Nesse formato a solução em Programação Dinâmica apresentou os seguintes resultados:

| Número da Iteração | Tempo médio de 10 Execuções |
| ------------------ | --------------------------- |
| 1                  | 15ms                        |
| 2                  | 2ms                         |
| 3                  | 7ms                         |
| 4                  | 18ms                        |
| 5                  | 26ms                        |
| 6                  | 29ms                        |
| 7                  | 42ms                        |
| 8                  | 50ms                        |
| 9                  | 61ms                        |
| 10                 | 82ms                        |


#### Execuções Separadas
Se consiste em execuções separadas de cada situação de T, o código apenas executará 10 vezes para aquele dado valor de T, depois que a execução se encerrar, será feito o calculo do próximo valor de T visando gastar menos memória.

**Valores Iniciais**
 - Quantidade de Caminhões: 3
 - Quantidade de Rotas: $\sum_{i=1}^{10} (22 \cdot i)$
 - Quantidade de Conjuntos de Rotas: 10

| Valor de T | Tempo médio de 10 Execuções |
| -----------| --------------------------- |
| 1T         | 17ms                        |
| 2T         | 41ms                        |
| 3T         | 30ms                        |
| 4T         | 45ms                        |
| 5T         | 50ms                        |
| 6T         | 63ms                        |
| 7T         | 79ms                        | 
| 8T         | 83ms                        | 
| 9T         | 100ms                       | 
| 10T        | 114ms                       | 

### Teste Extra
Nesse teste será definido uma quantidade estática de rotas e então será incrementado a quantidade de conjuntos de rotas por iteração para anáise do algoritmo de Programação Dinâmica.

**Valores Iniciais**
 - Quantidade de Caminhões: 3
 - Quantidade de Rotas: 100 
 - Quantidade de Conjuntos de Rotas: T = $\sum_{i=1}^{30} (10 \cdot i)$

| Valor de T | Tempo médio de 10 Execuções |
|------------|-----------------------------|
| 1T         | 43ms                        |
| 2T         | 34ms                        |
| 3T         | 75ms                        |
| 4T         | 74ms                        |
| 5T         | 85ms                        |
| 6T         | 101ms                       |
| 7T         | 118ms                       |
| 8T         | 134ms                       |
| 9T         | 167ms                       |
| 10T        | 191ms                       |
| 11T        | 192ms                       |
| 12T        | 227ms                       |
| 13T        | 237ms                       |
| 14T        | 315ms                       |
| 15T        | 279ms                       |
| 16T        | 302ms                       |
| 17T        | 369ms                       |
| 18T        | 334ms                       |
| 19T        | 390ms                       |
| 20T        | 453ms                       |
| 21T        | 408ms                       |
| 22T        | 436ms                       |
| 23T        | 448ms                       |
| 24T        | 490ms                       |
| 25T        | 515ms                       |
| 26T        | 506ms                       |
| 27T        | 561ms                       |
| 28T        | 576ms                       |
| 29T        | 570ms                       |
| 30T        | 651ms                       |