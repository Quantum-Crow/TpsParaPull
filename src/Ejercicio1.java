public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("Ordenacion");
        System.out.println("Ordenamiento por Inserción");
        System.out.println("Este algoritmo es el más sencillo de comprender ya que es una representacion natural de cómo aplicaríamos el orden a un " +
                "conjunto de elementos.En términos generales, inicialmente se tiene un solo elemento, que por defecto es" +
                "un conjunto ordenado. Después, cuando hay k elementos ordenados de menor a" +
                "mayor, se toma el elemento k+1 y se compara con todos los elementos ya "+
                "ordenados, deteniéndose cuando se encuentra un elemento menoro cuando ya " +
                "no se encuentran elementos. En este punto se inserta el elemento k+1 debiendo desplazarse los " +
                "demás elementos.");
        System.out.println("Algoritmo de la burbuja");
        System.out.println("La ordenación por burbuja es uno de los métodos más fáciles de ordenación, ya " +
                "que el algoritmo de ordenación utilizado es muy simple. " +
                "Este algoritmo consiste en comparar cada elemento de la lista con el siguiente si no están en el orden correcto, se intercambian entre sí sus valores. El\n" +
                "valor más pequeño flota hasta el principio de la lista como si fuera una burbuja en " +
                "un vaso de gaseosa");
        System.out.println("Ordenamiento por selección");
        System.out.println("El algoritmo de ordenamiento por selección es similar al método de la burbuja y " +
                "funciona de la siguiente manera: inicialmente se recorre toda la lista buscando el " +
                "menor de todos los elementos, una vez terminada la recorrida el menor elemento " +
                "se coloca al inicio de la lista recorrida. En la siguiente iteración se recorre " +
                "nuevamente la lista pero comenzando en el segundo elemento");
        System.out.println("Algoritmo Quick-Sort");
        System.out.println("El algoritmo trabaja de la siguiente forma:\n" +
                "● Elegir un elemento de la lista de elementos a ordenar, al que llamaremos pivote.\n" +
                "● Resituar los demás elementos de la lista a cada lado del pivote, de manera que a " +
                "un lado queden todos los menores que él, y al otro los mayores. Los elementos " +
                "iguales al pivote pueden ser colocados tanto a su derecha como a su izquierda, " +
                "dependiendo de la implementación deseada. En este momento, el pivote ocupa " +
                "exactamente el lugar que le corresponderá en la lista ordenada. " +
                "● La lista queda separada en dos sublistas, una formada por los elementos a la" +
                "izquierda del pivote, y otra por los elementos a su derecha. \n" +
                "● Repetir este proceso de forma recursiva para cada sublista mientras éstas " +
                "contengan más de un elemento. Una vez terminado este proceso todos los " +
                "elementos estarán ordenados. " +
                "Como se puede suponer, la eficiencia del algoritmo depende de la posición en la " +
                "que termine el pivote elegido, algunas alternativas son:\n" +
                "● Tomar un elemento cualquiera como pivote, tiene la ventaja de no requerir " +
                "ningún cálculo adicional, lo cual lo hace bastante rápido.\n" +
                "● Otra opción puede ser recorrer la lista para saber de antemano qué elemento " +
                "ocupará la posición central de la lista, para elegirlo como pivote. No obstante, el " +
                "cálculo adicional rebaja bastante la eficiencia del algoritmo en el caso promedio.\n" +
                "● La opción a medio camino es tomar tres elementos de la lista - por ejemplo, el " +
                "primero, el segundo, y el último - y compararlos, eligiendo el valor del medio como " +
                "pivote. ");
        System.out.println("Algoritmos de Busqueda");
        System.out.println("Secuencial");
        System.out.println("Este algoritmo busca el elemento dado, recorriendo secuencialmente la lista desde " +
                "un elemento al siguiente, comenzando en la primera posición de la lista y se " +
                "detiene cuando encuentra el elemento buscado o bien se alcanza el final de la lista " +
                "sin haberlo encontrado");
        System.out.println("Binaria");
        System.out.println("Este algoritmo se utiliza cuando disponemos de una lista ordenada, lo que nos " +
                "permite facilitar la búsqueda, ya que podemos ir disminuyendo el espacio de " +
                "búsqueda a segmentos menores a la lista original y completa. " +
                "La idea es no buscar en aquellos segmentos de la lista donde sabemos que el valor " +
                "seguro que no puede estar, considerando que la lista esta ordenada");
        System.out.println("Algoritmos de Recorrido");
        System.out.println("Profundidad");
        System.out.println("En el recorrido en profundidad, el proceso exige un camino desde el nodo raıź a " +
                "través de un hijo, al descendiente más lejano del primer hijo antes de proseguir a " +
                "un segundo hijo. En otras palabras, en el recorrido en profundidad, todos los " +
                "descendientes de un hijo se procesan antes del siguiente hijo.");
        System.out.println("Anchura");
        System.out.println("En el recorrido en anchura, el proceso se realiza horizontalmente desde el raıź a " +
                "todos sus hijos, a continuación, a los hijos de sus hijos y así ́ sucesivamente hasta " +
                "que todos los nodos han sido procesados. En otras palabras, en el recorrido en " +
                "anchura, cada nivel se procesa totalmente antes de que comience el siguiente " +
                "nivel");
    }
}
