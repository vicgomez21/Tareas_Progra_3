/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilasycolas;

/**
 *
 * @author SOPORTE
 */
public class PilasyColas {

    /**
     /* @param args the command line arguments
     */
    public static void pila() {
        PilaLista pila = new PilaLista();
        print("Apilar(PUSH) Pila --> \n");
        print("" + pila.insertar(10)+ "\n");
        print("" + pila.insertar(20)+ "\n");
        print("" + pila.insertar(80)+ "\n");
        print("" + pila.insertar(40)+ "\n");
        print("" + pila.insertar(50)+ "\n");
        print("" + pila.insertar(60)+ "\n");
        print(" Desapilar(POP) Pila -->" + "\n");
        print("" + pila.quitar()+ "\n");
        print("" + pila.quitar()+ "\n");
        print("" + pila.quitar()+ "\n");
        print("" + pila.quitar()+ "\n");
        print("" + pila.quitar()+ "\n");
        print("" + pila.quitar());
   }

    public static void cola() {
        ColaLista cola = new ColaLista();
        print("Apilar(QUEUE) Cola --> \n");
        print("" + cola.insertar(10)+ "\n");
        print("" + cola.insertar(200)+ "\n");
        print("" + cola.insertar(32)+ "\n");
        print("" + cola.insertar(44)+ "\n");
        print("" + cola.insertar(18)+ "\n");
        print("" + cola.insertar(58)+ "\n");
        print(" Desapilar(DEQUEUE) Cola -->" + "\n");
        print("" + cola.quitar()+ "\n");
        print("" + cola.quitar()+ "\n");
        print("" + cola.quitar()+ "\n");
        print("" + cola.quitar()+ "\n");
        print("" + cola.quitar()+ "\n");
        print("" + cola.quitar()+ "\n");
    }

    public static void print(String numero) {
        System.out.print(numero);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        //pila();
        cola();
       System.out.println("    "+"Terminada la aplicacion");
    }

}
