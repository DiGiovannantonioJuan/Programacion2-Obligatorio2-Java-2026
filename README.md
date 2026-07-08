Decisiones de diseño - Obligatorio 2 
Estructura de clases del dominio 
1. Persona como superclase abstracta de Cliente y Funcionario: ambos 
comparten nombre y celular, así que esos atributos quedaron en Persona y se usa 
herencia para evitar duplicación. 
2. Zona y Departamento como clases separadas, con relación bidireccional: cada 
Departamento referencia a su Zona, y cada Zona tiene su 
ArrayList<Departamento>. No se modelaron como String porque la Zona tiene 
comportamiento propio y es la unidad sobre la que se calculan tarifas y se filtran 
paquetes/envíos. 
3. Tarifa como clase propia: cada Tarifa se asocia a una Zona y contiene los 4 
precios por categoría de peso, con su propia lógica (actualizarPrecios()) y su 
propia persistencia en TARIFAS.TXT. 
4. LogTransacciones como clase independiente, responsable únicamente de 
escribir/leer/borrar Transacciones.log. Sistema le delega vía 
log.registrarTransaccion(...) sin conocer el formato de fecha ni el manejo del 
archivo (respeta CRH). 
5. Observador (patrón Observer) como interfaz separada, con Sistema manteniendo 
una ArrayList<Observador> y avisarObservadores() llamado al final de cada 
alta/modificación, para que las ventanas abiertas se actualicen sin que Sistema 
conozca su detalle. 
Estructuras de datos en Sistema 
6. Sistema mantiene tanto ArrayList como HashMap en paralelo para Clientes, 
Funcionarios, Paquetes y Envíos (p. ej. listaClientes + mapaClientes). El 
ArrayList se usa para recorrer/mostrar en orden (listas, tablas, JLists con 
setListData()), y el HashMap se usa para búsquedas directas por clave 
(buscarCliente(), buscarPaquete(), buscarEnvio(), etc.) sin tener que iterar 
toda la lista. Las claves elegidas son: nombre (en minúsculas/trim) para Cliente y 
Funcionario, identificador (en minúsculas/trim) para Paquete, y numeroEnvio 
(Integer) para Envío. 
7. Toda operación de alta debe mantener sincronizados ambos estructuras (agregar 
al ArrayList y al HashMap en la misma operación), ya que se decidió no derivar uno 
del otro dinámicamente, para mantener O(1) en las búsquedas por clave. 
Modelo de dominio 
8. Envio tiene su propio atributo recepcionado (boolean) — el estado de recepción del 
envío es independiente y no se infiere a partir de los estados de los paquetes que 
contiene. 
9. Los cambios de estado sobre Paquete se realizan en Sistema.registrarEnvio(), 
no en la ventana ni en el constructor de Envio. La vista no debe modificar el estado del 
dominio directamente. 
10. clienteRemitente agregado a Paquete, necesario para poder implementar 
VentanaConsultaPorCliente (buscar paquetes por cliente remitente). 
11. Ordenamiento de Cliente vía Comparable<Cliente>.compareTo() dentro de la 
propia clase Cliente — no en Sistema. Mismo criterio para cualquier Comparator: 
no corresponde a Sistema, sino a la clase del objeto que se ordena. 
Patrones de UI / lógica reutilizada 
12. "Total" como estado ficticio en VentanaPaquetesPorEstado: se reutiliza 
contarPaquetesPorZonaYEstado() pasando un valor especial que actúa como 
"todos los estados", evitando duplicar lógica de conteo. 
13. Flujo de VentanaIngresoPaquetes dividido en dos ventanas 
(VentanaIngresoPaquetes → VentanaIngresoPaquetesSig): primero se calcula 
y muestra el precio del paquete a ingresar para que el usuario confirme antes de 
registrarlo, y solo al confirmar se abre la segunda ventana con la tabla completa de 
paquetes ya cargados. Se separó así para no mezclar el paso de "cálculo/confirmación" 
con la "visualización final", siguiendo la letra del obligatorio que pide informar el precio 
antes de confirmar los datos. 
Declaración sobre uso de Inteligencia Artificial Generativa 
Durante el desarrollo de este obligatorio se utilizaron como apoyo Claude y el GPT del curso 
"ProfeP2Chat". Su uso se limitó a: (a) discutir y validar decisiones de diseño; (b) revisar y 
corregir métodos de la capa Sistema e Interfaz, implementados primero por el estudiante; 
(c) documentar las decisiones de diseño tomadas durante el proyecto; y (d) brindar apoyo en el 
diseño visual de las ventanas de interfaz. Todo el código entregado fue comprendido, verificado 
y probado por el estudiante, quien puede explicar y justificar cada una de las decisiones 
tomadas en el proyecto. 
