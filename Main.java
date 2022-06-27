import java.util.Scanner;


class Jogo{ //registro que vai guardar o dado
    String campo = "-";
}

public class Main
{
    public static Scanner leitor; //criando o scanner como uma variavel global
    public static Jogo[][] jogo; //criando a matriz como uma variavel global
    
	public static void inserirJogada(int linha, int coluna, int jogador){//função que insere o simbolo na matriz
	   if(jogador == 1)
	       jogo[linha][coluna].campo = "X";
	         
	   else
	       jogo[linha][coluna].campo = "O";   
	}
	
	public static void mostrarMatriz(){
	    System.out.println();
	    for(int i=0; i<3; i++){
	        for(int j=0; j<3; j++)
		        System.out.print("| "+jogo[i][j].campo+" |");
		
		    System.out.println();
		}
		
	}
	
	public static boolean conferirJogadaX(){ //essa função confere se alguem já ganhou, se sim, retorna true, se não, retorna false
	    //primeiro confere possíveis vitorias na horizontal para X, do jogador 1.
	    if((jogo[0][0].campo == jogo[0][1].campo && jogo[0][1].campo == jogo[0][2].campo && jogo[0][2].campo == "X") ||
	    (jogo[1][0].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[1][2].campo && jogo[1][2].campo == "X") ||
	    (jogo[1][0].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[1][2].campo && jogo[1][2].campo == "X")
	    ){
	        return true; //eu também poderia guardar esse valor em uma variável e retornar só no fim da função
	    }
	    
	    //possíveis jogadas na vertical
	    else if((jogo[0][0].campo == jogo[1][0].campo && jogo[1][0].campo == jogo[2][0].campo && jogo[2][0].campo == "X") ||
	    (jogo[0][1].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[2][1].campo && jogo[2][1].campo == "X") ||
	    (jogo[0][2].campo == jogo[1][2].campo && jogo[1][2].campo == jogo[2][2].campo && jogo[2][2].campo == "X")
	    ){
	        return true; 
	    }
	    
	    //possíveis jogadas nas diagonais
	    else if((jogo[0][0].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[2][2].campo && jogo[2][2].campo == "X") ||
	    (jogo[0][2].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[2][0].campo && jogo[2][0].campo == "X")
	    ){
	        return true; 
	    }
	    
	    else{
	        return false;
	    }
	}
	
	public static boolean conferirJogadaO(){ //mesmo coisa que conferirJogadaX, só que para o jogador O
	    //horizontal
	    if((jogo[0][0].campo == jogo[0][1].campo && jogo[0][1].campo == jogo[0][2].campo && jogo[0][2].campo == "O") ||
	    (jogo[1][0].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[1][2].campo && jogo[1][2].campo == "O") ||
	    (jogo[1][0].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[1][2].campo && jogo[1][2].campo == "O")
	    ){
	        return true; 
	    }
	    
	    //vertical
	    else if((jogo[0][0].campo == jogo[1][0].campo && jogo[1][0].campo == jogo[2][0].campo && jogo[2][0].campo == "O") ||
	    (jogo[0][1].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[2][1].campo && jogo[2][1].campo == "O") ||
	    (jogo[0][2].campo == jogo[1][2].campo && jogo[1][2].campo == jogo[2][2].campo && jogo[2][2].campo == "O")
	    ){
	        return true; 
	    }
	    
	    //diagonais
	    else if((jogo[0][0].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[2][2].campo && jogo[2][2].campo == "O") ||
	    (jogo[0][2].campo == jogo[1][1].campo && jogo[1][1].campo == jogo[2][0].campo && jogo[2][0].campo == "O")
	    ){
	        return true; 
	    }
	    
	    else{
	        return false;
	    }
	}
	
	public static void main(String[] args) {
		leitor = new Scanner(System.in);//instanciando o Scanner;
		jogo = new Jogo[3][3]; //instanciando a matriz;
		
		
		
		int linha, coluna, jogador = 1; // a variavel jogador vai identificar qual jogador é
		boolean preenchido; 
		
		int op = 1;
		do{
		    for(int i=0; i<3; i++){
    		    for(int j=0; j<3; j++)
    		        jogo[i][j] = new Jogo(); //instanciando o registro
    		}
    		while(true){
    		    mostrarMatriz(); //mostro a matriz
    		    preenchido = true; ///essa variavel vai iniciar com a ideia de que toda a matriz está ocupada!
    		    //ele é reeiniciado pois será necessário uma nova verificação toda vez que o laço rodar
    		    for(int i=0; i<3; i++){ // esse for verifica se ainda existe campos vazios
        		    for(int j=0; j<3; j++){
        		        if(jogo[i][j].campo == "-"){ // no primeiro campo vazio encontrado, a variavel preenchido muda o valor
        		            preenchido = false;
        		        }
        		        //se não tiver nenhum campo vazio, a variavel sai com o mesmo valor que entrou;
        		    }
    	
    		    }
        		 //se preenchido for false, significa que existe pelo menos 1 campo vazio
        		 if(preenchido == false){
        		     
        		     //verifico quem está jogando
        		      if(jogador == 1){
        		        
            	        do{
                	        System.out.print("Jogador 1 - Digite a linha: ");
                	        linha = leitor.nextInt();
                	        System.out.print("Jogador 1 - Digite a coluna: ");
                	        coluna = leitor.nextInt();
                	        
                	        if(jogo[linha-1][coluna-1].campo != "-"){
                	            System.out.print("\nPosição indisponível! Digite novamente.\n");
                	        }
                	    }while(jogo[linha-1][coluna-1].campo != "-"); //enquanto a posição digitada não for vazia, ele vai pedir uma nova posição;
            	        
            	        inserirJogada(linha-1, coluna-1, jogador); //insere a jogada
            	        if(conferirJogadaX() == true){ //confiro se essa jogada vai ser vitória
            	            mostrarMatriz(); //mostro a matriz
            	            System.out.print("\nJogador 1 ganhou!"); // falo quem ganhou
            	            break; //acabo com o jogo
            	        }
            	        else
            	            jogador = 2; //mudo o jogador e next 
                	  }
                	  else{
                	    do{
                	        System.out.print("Jogador 2 - Digite a linha: ");
                	        linha = leitor.nextInt();
                	        System.out.print("Jogador 2 - Digite a coluna: ");
                	        coluna = leitor.nextInt();
                	        
                	        if(jogo[linha-1][coluna-1].campo != "-"){
                	            System.out.print("\nPosição indisponível! Digite novamente.\n");
                	        }
                	    }while(jogo[linha-1][coluna-1].campo != "-"); //enquanto a posição digitada não for vazia, ele vai pedir uma nova posição;
                	    
            	        inserirJogada(linha-1, coluna-1, jogador); //insere a jogada
            	        if(conferirJogadaO() == true){ //confiro se essa jogada vai ser vitória
            	            mostrarMatriz(); //mostro a matriz
            	            System.out.print("\nJogador 2 ganhou!"); // falo quem ganhou
            	            break; //acabo com o jogo
            	        }
            	        else
            	            jogador = 1; //mudo o jogador e next 
                	  }
        		     
        		 }
        		 //se for igual a verdadeiro, significa que não entrou no if do laço, logo não existe campos vazios
        		else {
        		    System.out.print("\nDeu velha, losers."); 
        		    break;
            	}
        		        
    		}
    		
    		System.out.print("\nDeseja jogar novamente? Digite 1 para SIM ou 2 para NÃO: ");
    		op = leitor.nextInt();
		}while(op != 2);
		
	}
}



