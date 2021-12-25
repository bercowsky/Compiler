# Compiler
Compilador para el lenguaje de Llull implementado en Python y con la ayuda de la herramienta ANTLR.

## Descriptión
Para utilizarlo, debemos invocar Python pasándole como primer parámetro el archivo llull.py y como segundo parámetro el archivo de texto con extensión .llull del cual
queremos que lea el código. Opcionalmente, podemos introducir un nombre de función (seguido de sus parámetros si es que tiene). De esta manera,
empezaremos la ejecución por la función introducida. Si no introducimos ninguna función se empezará por la función llamada main. En caso que no exista main y no se haya
pasado ninguna función, el programa devolverá una excepción. También, si se ha introducido una función que no existe, el programa devolverá una excepción.



## Examples

```bash
python EvalVisitor.py input.llull
```