public  class Main{

  //Autores: Alvarez Sanchez Miranda y Tellez Gonzalez Jorge Luis

  static void procesaCadena(String cadena){
    // q = d*(q0,w)
    int q = delta_extendida(0, cadena);
    if(q==5){
      System.out.println("Cadena aceptada");

    }else{
      System.out.println("Cadena rechazada");
    }

  }

  /** Implementacion de la funcion (d*) */
  private static int delta_extendida(int estado_actual,String cadena){
    // Si ya no hay simbolos en la entrada
    // Caso base: d*(q,l) = q
    if(cadena=="") {

      System.out.println("d*("+estado_actual+",l)");
      return estado_actual;
      
    }

    // Si aun hay si­mbolos en la entrada
    // Se lee el siguiente si­mbolo
    char siguiente_simbolo = cadena.charAt(0);
    String resto_cadena = null;
    
    if(cadena.length()==1) //ya no hay mas simbolos
      resto_cadena = "";
    else // el resto de la cadena es la subcadena a partir de la segunda posiciÃ³n
      resto_cadena = cadena.substring(1);
    
    // Caso recursivo:
    // d*(q,sw) = d*(d(q,s), w)
    System.out.println("d*(d("+estado_actual+","+siguiente_simbolo+"),"+(resto_cadena==""?"l":resto_cadena)+")");
    return delta_extendida(delta(estado_actual,siguiente_simbolo),resto_cadena);
  }

  /** Implementacion de la funcion d(q,s) (transiciones entre estados)
   * @param estado actual
   * @param simbolo leido
   * @return el estado siguiente */
 private static int delta(int q,char s){

    if(q==0){

      if(s==" ".charAt(0)){
          return q;
      }
      
      if(s=="1".charAt(0)|| s=="2".charAt(0)){
      
          return 1;
      }

       if(s=="x".charAt(0)|| s=="=".charAt(0)){
      
          return -1;
      }


    }

    if(q==1){

      if(s=="x".charAt(0))
      return 2;

      if(s=="1".charAt(0)|| s=="2".charAt(0))
      return 1;

      if(s=="=".charAt(0)){
      
          return -1;
      }
      
    }

    if(q==2){

      if(s=="1".charAt(0)|| s=="2".charAt(0))
      return 3;

      if(s=="x".charAt(0)|| s=="=".charAt(0)){
      
          return -1;
      }

    }

    if(q==3){

      if(s=="1".charAt(0)|| s=="2".charAt(0))
      return 3;

      if(s=="x".charAt(0))
      return 2;

      if(s=="=".charAt(0))
      return 4;

    }

    if(q==4){

      if(s=="1".charAt(0)|| s=="2".charAt(0))
      return 5;

      if(s=="x".charAt(0)|| s=="=".charAt(0)){
      
          return -1;
      }
      
    }
    if(q==5){
      
      if(s=="1".charAt(0)|| s=="2".charAt(0))
      return 5;
      
      
      if(s=="x".charAt(0)|| s=="=".charAt(0)){
      
          return -1;
      }
    }

    return 0;

  }
  public static void main(String[] args){

    System.out.println("Cadenas correctas: \n");
    Main.procesaCadena("1x21=2");
    Main.procesaCadena("1x1x2=11");
    Main.procesaCadena("1x2x2x11=21");

    System.out.println("Cadenas incorrectas: \n");
    Main.procesaCadena("1x");
    Main.procesaCadena("1x2=");
    Main.procesaCadena("=x==");
    Main.procesaCadena("2x1x2");
    Main.procesaCadena("x2x1=1");


    if(args.length==1){
      Main.procesaCadena(args[0]);

    }else{
      System.out.println("Uso: java Automata <cadena de entrada>");
    }

  }

}