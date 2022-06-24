package Logic;

public class Calculadora {
    //INSTANCIAS DIFERENTES METODOS
    private Warshall warshall;
    private Conexidad conexidad;
    private Producto_Logico producto_logico;
    private Producto_Logico_Simple producto_logico_simple;

    public Calculadora(){};

    public String resolverWarshal(int cantNodos, int[][] matriz){
        String respuesta = "";
        warshall = new Warshall(cantNodos, matriz);
        respuesta = warshall.resolver();
        return respuesta;
    }

    public String resolverConexidad(int cantNodos, int[][] matriz){
        String respuesta = "";
        conexidad = new Conexidad(cantNodos, matriz);
        respuesta = conexidad.resolver();
        return  respuesta;
    }

    public String resolverProductoLogico(int cantNodos, int[][] matriz){
        String respuesta = "";
        producto_logico = new Producto_Logico(cantNodos,matriz);
        respuesta=producto_logico.resolver();
        return respuesta;
    }

    public String resolverProductoLogicoSimple(int cantNodos, int[][] matriz){
        String respuesta="";
        producto_logico_simple = new Producto_Logico_Simple(cantNodos, matriz,matriz);
        respuesta=producto_logico_simple.resolver();
        return respuesta;
    }

}
