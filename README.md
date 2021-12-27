# Compiler
Compilador para el lenguaje de Llull implementado en Python y con la ayuda de la herramienta ANTLR.

## Descriptión
Para utilizarlo, debemos invocar Python pasándole como primer parámetro el archivo llull.py y como segundo parámetro el archivo de texto con extensión .llull del cual
queremos que lea el código. Opcionalmente, podemos introducir un nombre de función (seguido de sus parámetros si es que tiene). De esta manera,
empezaremos la ejecución por la función introducida. Si no introducimos ninguna función se empezará por la función llamada main. En caso que no exista main y no se haya
pasado ninguna función, el programa devolverá una excepción. También, si se ha introducido una función que no existe, el programa devolverá una excepción.

He creado 3 tipos de datos:
- **Numerico**: Enteros y flotantes.
- **Booleano**: 1 o 0.
- **String**: Cadenas de caracteres.
- **Array**: Lista de elementos.

Las operaciones solo se pueden llevar a cabo con variables de tipo númerico o booleano (ya que su valor realmente es un número).
Nuestro compilador soporta las operaciones de suma, resta, multiplicación, división, modulo, y exponenciación. Además, se pueden realizar comentarios multilínea
con el comando ```#*``` donde se desea empezar y ```*#``` donde se desea acabar. Los comentarios de una línea se realizan con el comando ```#```.

El programa se ha de componer de funciones de tipo void, que no devuelven ningún valor. Dentro de las funciones se pueden definir variables de cualquier tipo,
se pueden realizar llamadas a funciones y se puden utilizar elementos como ```if```, ```else```, ```for```, ```while```, ```write```, ```read```, ```array```, 
```get``` o ```set```. Además, se pueden declarar varias funciones con el mismo nombre, siempre y cuando tengan distinto número de parámetros. En el juego de
pruebas podemos ver un ejemplo con esto.


## Examples

```bash
python EvalVisitor.py input.llull
```

[![asciicast](https://asciinema.org/a/LIoB4udnT1NdCnVndCVugrViS.svg)](https://asciinema.org/a/LIoB4udnT1NdCnVndCVugrViS)