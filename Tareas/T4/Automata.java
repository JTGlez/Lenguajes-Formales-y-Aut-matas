public  class Automata{

  //Autores: NOMBRES DE LOS INTEGRANTES DE EQUIPO

  static void procesaCadena(String cadena){
    // q = δ*(q0,w)
    int q = delta_extendida(0,cadena);
    if(){
      System.out.println("Cadena aceptada");
    }else{
      System.out.println("Cadena rechazada");
    }
  }

  /** Implementación de la función δ* */
  private static int delta_extendida(int estado_actual,String cadena){
    // Si ya no hay símbolos en la entrada
    // Caso base: δ*(q,λ) = q
    if(cadena=="") {
      System.out.println("δ*("+estado_actual+",λ)");
      return estado_actual;
    }

    // Si aún hay símbolos en la entrada
    // Se lee el siguiente símbolo
    char siguiente_simbolo = cadena.charAt(0);
    String resto_cadena = null;
    if(cadena.length()==1) //ya no hay más símbolos
      resto_cadena = "";
    else // el resto de la cadena es la sucadena a partir de la segunda posición
      resto_cadena = cadena.substring(1);
    // Caso recursivo:
    // δ*(q,σw) = δ*(δ(q,σ), w)
    System.out.println("δ*(δ("+estado_actual+","+siguiente_simbolo+"),"+(resto_cadena==""?"λ":resto_cadena)+")");
    return delta_extendida(delta(estado_actual,siguiente_simbolo),resto_cadena);
  }

  /** Implementación de la función δ (transiciones entre estados)
   * @param estado actual
   * @param simbolo leido
   * @return el estado siguiente */
  private static int delta(int estado,char simbolo){

  }

  public static void main(String[] args){
    if(args.length==1){
      Automata.procesaCadena(args[0]);
    }else{
      System.out.println("Uso: java Automata <cadena de entrada>");
    }

  }

}