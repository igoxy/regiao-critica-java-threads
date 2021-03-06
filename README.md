# Região crítica
Repositório voltado para a resposta do problema de região crítica com Threads da disciplina de SO - UEFS

<h2>Descrição do problema</h2>
<p>Criar um objeto chamado Geladeira que cabe 10 litros de leite. Depois, criar uma Thread chamada BebeLeite que dorme (por um tempo aleatório) e quando acorda bebe 1 litro de leite. Depois, devem criar três Threads (Pai, Mae e Tio) que monitoram a geladeira e que observam quanto falta leite e compram mais Leite. A questão deste problema então: vai haver um momento em que eles vão comprar mais leite do que cabe na geladeira? Se sim, vocês devem lançar um alerta quando isso ocorrer, onde a idéia é demonstrar que a "região crítica" não foi bem tratada, e que temos um problema neste ponto.</p>

<h2>Produto</h2>
<p>Deve prover uma solução caso ocorra problema na região critica e apresentar essa solução em código fonte.</p>

<h2>Solução</h2>
<p>O projeto é divido em dois pequenos programas, o primeiro (presente na pasta threads) simula o problema da região crítica, onde as Threads Pai, Mae e Tio podem acessar e modificar atributos da geladeira ao mesmo tempo, de modo que não existe uma restrição para mudanças simultâneas. Para simular esses acontecimentos, foram criados dentro das Threads Pai, Mae e Tio um laço para gastar recursos antes da análise da quantiade de itens da geladeira, isso garante que o sistema mude a Thread que está executando em tempo hábil para que possamos ver um exemplo de não tratamento da região crítica. Sem esse laço, como o programa é muito curto, cada Thread irá executar muito rapidamente, sem que haja a mudança entre elas antes da análise da quantidade de itens da geladeira.</p>

<p>Já o segundo programa (presente na pasta threads2) corrige o problema da região crítica. Nesse segundo programa a solução adotada foi desenvolver um método de visualização da geladeira, utilizando o recurso <b>synchronized</b> do Java. Neste método, as Threads Pai, Mae e Tio podem visualizar a quantidade de leite na geladeira e tomar a decisão se devem efetuar a compra de novos leites para adicionar a geladeira. Porém, graças ao synchronized esse método só pode ser acessado por uma Thread por vez, ou seja, quando uma Thread está utilizando o método, as outras Threads são bloqueadas de utilizá-lo, garantindo assim que os recursos da geladeira não sejam modificados por mais de uma Thread ao mesmo tempo, permitindo que o sistema funcione de modo adequado.</p>
