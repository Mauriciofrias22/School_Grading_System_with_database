Sistema estadistico de calificaciónes por GUI con base de datos

El algoritmo realiza los siguientes calculos:

Exámenes con una calificación menor a la del promedio del grupo
Porcentaje de exámenes excelentes
Materia con el mayor numero de examenes reprobados
Estudiante con el mejor desempeño para la materia idiomas

El sistema genera los datos estadísticos a partir de la siguiente información

Nombre	Género	 Materia	  Nota
marcela	  f	    matemáticas	8.6
daniel	  m	    matemáticas	9.0
marcela	  f	    idiomas	    8.3
daniel	  m	    idiomas	    6.5

Las calificaciones en la escuela se asignan con la siguiente escala de rangos:

Rango de notas	Calificación 
(9 - 10]	        Excelente
(8 - 9]	          Sobresaliente
(6 - 8]	          Regular
(3 - 6]	          Insuficiente
[0 - 3]	          Deficiente

Para facilitar el proceso de ingreso y manipulación de los datos, los valores de tipo string se les asigna un identificador numérico único por categorías:

Nombre	Identificador
armando	  1
nicolas	  2
daniel	  3
maria	    4
marcela	  5
alexandra	6

Materia 	Identificador
idiomas	    1
historia	  2
literatura	3


Género	Identificador
m	        0
f	        1

Ejemplo para prueba

Entrada del programa
18
1.0 0.0 1.0 5.7
1.0 0.0 2.0 0.2
1.0 0.0 3.0 5.0
2.0 0.0 1.0 7.5
2.0 0.0 2.0 9.9
2.0 0.0 3.0 3.5
3.0 0.0 1.0 2.2
3.0 0.0 2.0 5.5
3.0 0.0 3.0 2.2
4.0 1.0 1.0 7.9
4.0 1.0 2.0 2.2
4.0 1.0 3.0 9.9
5.0 1.0 1.0 9.3
5.0 1.0 2.0 9.8
5.0 1.0 3.0 5.8
6.0 1.0 1.0 9.5
6.0 1.0 2.0 7.2
6.0 1.0 3.0 6.6

Salida del programa
9
0.28
literatura
alexandra

Otro aspecto importante es el formato de entrada de los datos, la primera línea de la entrada se trata del número de registros que se deben leer. Las líneas de los registros tienen un formato de tabla, el orden de las columnas es: nombre, género, materia y calificación, las columnas están separadas por un espacio. 

El programa incluye una base de datos relacional con sqllite

La interfaz gráfica del programa contiene los siguientes módulos:

1. Módulo de entrada de datos: Este módulo debe poder ingresar los datos en base de datos. Los datos requeridos son los siguientes: Nombre, Nota, Género y Materia.

2. Módulo de procesamiento de datos: El objetivo de este módulo es a partir de la información en base de datos realizar las operaciones estadísticas requeridas, se debe traer los datos de la base de datos y desplegarlos en el formato requerido en el TextArea de la izquierda, al presionar el botón procesar se deben hacer los cálculos y operaciones requeridas para obtener las respuestas que serán desplegadas en el TextArea de la derecha.

3. Módulo para consultar, y eliminar datos: Este módulo cumple el objetivo de realizar operaciones sobre los registros de la base de datos. Se deben proveer al usuario dos posibles acciones: Consulta de los datos a partir de ya sea el nombre del estudiante o la materia, se deben desplegar los registros de la base datos los cuales cumplen con, por ejemplo si se se provee el nombre camilo se deben desplegar todos los registros de la base datos en los cuales el nombre es camilo, por otro lado si se consulta por materia y se ingresa la materia Geografía, se deben desplegar los registros en los cuales la materia es geografía. La otra acción es la de eliminar registros, si se ingresa un nombre o una materia se deben eliminar todos los registros de la base de datos, los cuales contienen el dato requerido. Las consultas y eliminaciones se deben hacer con una de las dos posibles opciones ya sea por Nombre o por Materia. Si no existe ningún registro que coincida con la información ingresada, se debe desplegar un texto que diga que no se encontraron resultados.
