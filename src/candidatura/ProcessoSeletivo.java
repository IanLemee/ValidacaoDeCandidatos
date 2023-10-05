package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatos = {"Felipe", "Ana", "Ian","Marcia", "Roberto"};
		for (String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
		
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if (continuarTentando) {
				tentativasRealizadas++;
			} else {
				System.out.println("Contato realizado com sucesso");
			}
			
		} while(continuarTentando && tentativasRealizadas < 3);
		
		if (atendeu) {
			System.out.println("Conseguimos contato com o " + candidato + " Na " + tentativasRealizadas + " Tentativa realizada");
		} else {
			System.out.println("Nao conseguimos contato com o " + candidato + " Na " + tentativasRealizadas + " Tentativa realizada");
		}
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"Felipe", "Ana", "Ian","Marcia", "Roberto"};
		System.out.println("Imprimindo a lista de candidados informando o indice do elemento");
		for(int indice = 0; indice < candidatos.length; indice++) {
			System.out.println("O candidato de numero " + (indice+1) + " e o " + candidatos[indice]);
		}
		
		System.out.println("Forma abreviada de intercacao for each");
		
		for(String candidato: candidatos) {
			System.out.println("o candidadto selecionado foi " + candidato);
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {
				"Felipe", "Ana", "Ian",
				"Marcia", "Roberto", "Rogerio", 
				"Rodrigo", "Alice","Luana", 
				"Matheus", "Isabella"
				};
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000.0;
		
		while(candidatosSelecionados > 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " solicitou esse valor de salario" + salarioPretendido);
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " Foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("Ligar para o candidato com contra proposta");
		} else {
			System.out.println("Aguardando o resultado dos demais candidatos");
		}
	}
}
