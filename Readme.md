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

## Componentes
#### Unidad Arithmetica, Logica y Unidad de Control -> cerebro
**¿Qué debe tener nuestro cerebro?**
- Acceso a todo
- Lo primero que debe hacer es parsear la entrada, recibira un fichero
  - En el parseo ya se tendrá en cuenta que se puede tener un operando constante, directo o indirecto

#### Unidades lógicas
- **Se van a dividir en:**
  - Input Unit -> Tendrá acceso a la input tape -> cinta de entrada
               -> Recibirá la instrucción y el operando y hará su correspondiente operación
  - Output Unit -> Tendrá acceso a la output tape -> cinta de salida
               -> Recibirá la instrucción y el operando y hará su        correspondiente operación

#### Data memory
- Será dinámica, se irá creando mientras se necesite. Será un hash <int, Registro>
- Registro será una clase abstracta que en principio será un int

#### Program memory

