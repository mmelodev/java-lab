package br.com.rpgbasico.gameplay;

public class historia {

    public void introducao(){
            System.out.println("\"******************************\n\n" +
                    "Seja muito bem-vindo ao RPG Básico da Idade Média\n\n" +"******************************\n" +
                    "@Por Murilo Melo - Testes de Conhecimentos de herança e poliformismo\n\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(
                    "Durante três mil anos, em toda a extensão da terra, existiu paz, todos os reinos viviam em harmonia entre si. Os elfos sendo a raça mais antiga detentava do maior conhecimento, tradições e magia. Os magos, de origem desconhecida por todos, dominavam uma magia imparável que poderiam mudar as estruturas da própria terra. Por fim, os homens sendo a raça sem poderes, mas que com sua determinação poderia se tornar mais fortes que qualquer elfo ou mago.\n" +
                    "Elfos construiam suas grandes fortalezas de vidro e aço por toda Terra. Os magos não tinham um lugar único, viviam andando pela terra e apareciam quando tinham que aparecer de acordo com sua vontade. Os homens criaram cidades gigantescas com completa organização política. A Terra era repleta de vida, conhecimento surgindo de todos os lados, evolução das raças e de todos os animais.\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Porém, algo maligno se formava nos cofins da terra. Uma sombra. A harmonia coletiva impedia que os grandes reis de todos reinos suspeitassem de qualquer força maior que poderia acabar com a paz. Noruas, o grande senhor do escuro, se aproveitou disso, planejando, criando estratégias e esperando nos cantos mais remotos da Terra.\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Certo dia, Noruas emergiu das sombras devastando florestas, pequenas cidades, animais e vilas inteiras. Os exercitos de muitas reinos se reuniram para defender os inocentes, mas não adiantou. O poder do senhor do escuro era além de qualquer tipo de ataque direto, uma de sombra passou por cima dos reinos dos homens, apenas o rei Aladian conseguiu espacar com uma pequena quantidade de seu povo, ainda não se sabe quantos mais dos homens estão vivos...\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Os elfos nao tiveram tempo de contra-atacar, se esconderam nos seus lugares sagrados que nem o próprio rei das sombras poderia encontrar...\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Os magos nunca mais foram vistos, os homens e elfos se sentiram abondonados por aqueles que detinham de maior poder, muitos suspeitam que trabalhavam para o senhor do escuro. Bom, nem todos os magos sumiram, apenas um continuva caminhando pela Terra, conhecido como O Mago do Deserto...\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Dezenas de anos se passaram, criaturas horríveis começaram a aparecer por toda a terra, soldados montados a partir dos restos mortais dos elfos e da sombra que fazia parte do senhor do escuro. Soldados sombrios conhecidos como Orks que caçavam os elfos, a raça que o Noruas mais tinha raiva...\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Além de caçar elfos, os Orks matavam qualquer em seu caminho e tinham uma fome imparável por carne humana, poderiam ser vingativos, traidores e terem até seus prórpios objetivos.\n");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Nesse mundo devastado e sem esperança, todos aguardavam seu fim iminente. Entretando, ainda há esperança de alguém que poderia lutar contra esse mal que assola a Terra...\n ");

            primeiraparte novoJogo = new primeiraparte();
            novoJogo.capituloUm();
        }


}
