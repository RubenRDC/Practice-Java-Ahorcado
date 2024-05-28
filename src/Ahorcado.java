import java.util.Random;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        //String[] PalabrasSecretas= new String[10];
        String[] PalabrasSecretas = {"sube","avion","camionero","electrista"};
        int intentosMaximos = 10,errores = 0;
        boolean gano=false;
        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        int numeroAleatorio = r.nextInt(PalabrasSecretas.length);
        
        String PalabraSecretaSeleccionada = PalabrasSecretas[numeroAleatorio];
        System.out.println(numeroAleatorio);
        
        char caracteresRecibidos[] = new char[PalabraSecretaSeleccionada.length()];
        for(int i=0;i<PalabraSecretaSeleccionada.length();i++){
            caracteresRecibidos[i]='_';
        }
        
        System.out.println("Bienvenidos a el ahorcados de Ruben!");
        while (!gano && errores<intentosMaximos) {
            boolean contieneCaracter=false;
            System.out.println("La palabra por adivinar es : "+ String.valueOf(caracteresRecibidos) + " y contiene "+ PalabraSecretaSeleccionada.length()+" Caracteres");
            System.out.print("Ingrese una letra:");
            char letra = Character.toLowerCase(scan.next().charAt(0));

            for(int i=0;i<PalabraSecretaSeleccionada.length();i++){
                if (PalabraSecretaSeleccionada.charAt(i)==letra) {
                    caracteresRecibidos[i] = letra;
                    contieneCaracter=true;
                }
            }
            if (!contieneCaracter) {
                errores++;
                System.out.println("La letra ingresada no se encuentra en la palabra por adivinar, intentos restantes: "+(intentosMaximos-errores));
                if (intentosMaximos==errores) {
                    System.out.println("Haz Perdido el juego.");
                }
            }else if (String.valueOf(caracteresRecibidos).equals(PalabraSecretaSeleccionada)) {
                System.out.println("Felicidades! Haz Ganado! La la palabra ganadora era: "+PalabraSecretaSeleccionada);
                gano=true;
            }
        }
        scan.close();
    }
}
