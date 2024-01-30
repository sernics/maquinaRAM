# Esta práctica se basa en el desarrollo de una máquina RAM

## Qué es una máquina RAM:
1. Una máquina RAM es una máquina Secuencial
2. **Todas las instrucciones valen lo mismo**
- Hay un contador de programa que se mueve entre instrucciones -> Su valor inicial suele ser 1
- Hay un número de registros
  - Un registro especial es el r0 -> Que es un acumulador
- Tenemos una cinta de entrada y una cinta de salida
- Memoria interna de lectura / escritura
- Hay que tener en cuenta que tenemos un *catalogo* de instrucciones limitado
- Instrucción: OPERADOR OPERANDO -> ADD 3

## Componentes en los que se divide
1. Memoria de programa
2. Memoria de datos
3. Unidad de aritmética, control y lógica
4. Unidad de entrada
5. Unidad de salida

## Tipos de operandos
- Inmediato -> ADD =3 -> En el registro r0 <- ro + 3
- Directo -> ADD 3 -> En el registro r0 <- r0 + r3
- Indirecto -> ADD *3 -> En el registro r0 <- r0 + [r3] = al registro que indica r3

## Catálogo de instrucciones
- LOAD op
- STORE op
- ADD op
- SUB op
- MUL op
- READ op
- WRITE op
- JUMP etiq
- JZERO etiq -> El control del programa salta a la instrucción indicada por la etiqueta si el valor de r0 == 0
- JGTZ etiq -> El control del programa salta a la instrucción indicada por la etiqueta si el valor de r0 > 0
- HALT -> Se detiene el programa

