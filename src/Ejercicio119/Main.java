/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 119 | 2025-10-27               │
 * └─────────────────────────────────────────────────────────────────────────┘
 * PROMPT COMPLETO DEL EJERCICIO #119:
 * Agente el ejercicio final, el #119, siempre dame los mismo del anterior todos los archivos anteriores, este igual es ya mas extenso que los demás, siempre usa los parámetros anteriores, siempre muestra las salidas en cuadros elegantes al usuario final, siempre que los Menús sea simples de usar, te enviare un super prompt para que no te salgas de los lineamientos que necesito, siempre los archivos (MiLibrería, Utilidades, Operaciones, Utilidades, Menús y el Main)
El ejercicios dice:
═════════════════════════════════════════════════════════
                        ENUNCIADO DEL EJERCICIO
═══════════════════════════════════════════════════════

TÍTULO: "Consultas y el inicio de la parte financiera"

DESCRIPCIÓN:
La clínica de nutrición requiere ahora un sistema que combine:
1. Control de expedientes de pacientes (ya existente)
2. Control financiero de consultas y pagos
═════════════════════════════════════════════════════════
                        ESTRUCTURAS DE DATOS
═════════════════════════════════════════════════════════

ESTRUCTURA 1: PACIENTE (Ya existente, pero recordar)
- int expediente (número único del paciente)
- String nombre
- String apellido
- int edad
- char sexo ('M' o 'F')
- String diagnostico

ESTRUCTURA 2: FECHA (fechac)
┌───────────────────────────────────────────────────────┐
│ Campo        │ Tipo                      │ Descripción                                                                             │
├───────────────────────────────────────────────────────┤
│ año        │ int                                  │ Año de la consulta (ej: 2025)                                            │
│ mes        │ int                                 │  Mes (1-12, validar que no sea <1 ni >12)                        │
│ día        │ int                                  │ Día (1-31, validar según el mes)                                         │
└───────────────────────────────────────────────────────┘

ESTRUCTURA 3: EXPEDIENTE DE PAGO (expedientePago)
┌───────────────────────────────────────────────────────┐
│ Campo        │ Tipo        │ Descripción                                                                                            │
├───────────────────────────────────────────────────────┤
│ expediente   │ int                      │ Coincide con expediente del paciente                              │
│ consultas    │ fechac[100]      │ Arreglo de fechas de consultas                                           │
│ montos       │ double[100]        │ Costo de cada consulta (índice i)                                      │
│ numConsultas │ int                  │ Contador de consultas realizadas                                      │
│ pagado       │ double                │ Total pagado por el paciente                                                │
│ pendiente    │ double             │ Deuda actual del paciente                                                    │
───────────────────────────────────────────────────────┘

RELACIÓN:
- consultas[i] tiene el costo en montos[i]
- Ejemplo: Si consultas[0] es 15/03/2025, montos[0] tiene el precio de esa consulta

═════════════════════════════════════════════════════════
                        FUNCIONALIDADES REQUERIDAS
════════════════════════════════════════════════════════

MENÚ PRINCIPAL DEL SISTEMA:
╔═══════════════════════════════════════════════════════╗
║                   CLÍNICA DE NUTRICIÓN - MENÚ PRINCIPAL                                                       ║
╠═══════════════════════════════════════════════════════╣
║  1. Gestión de Pacientes                                                                                                                 ║
║  2. Realizar Consulta                                                                                                                       ║
║  3. Registrar Pago                                                                                                                            ║
║  4. Estadísticas                                                                                                                                 ║
║  0. Salir                                                                                                                                                ║
╚═══════════════════════════════════════════════════════════════════════╝

-------------------------------------------------------------------
OPCIÓN 1: GESTIÓN DE PACIENTES
-------------------------------------------------------------------
Submenú:
  a) Agregar nuevo paciente
  b) Buscar paciente por expediente
  c) Modificar datos de paciente
  d) Listar todos los pacientes
  e) Volver al menú principal

Al CREAR un paciente:
- Se crea automáticamente su expedientePago
- expedientePago.expediente = paciente.expediente
- expedientePago.pagado = 0.0
- expedientePago.pendiente = 0.0
- expedientePago.numConsultas = 0

-------------------------------------------------------------------
OPCIÓN 2: REALIZAR CONSULTA
-------------------------------------------------------------------
Proceso:
1. Solicitar número de expediente (validar que exista)
2. Solicitar fecha de la consulta (día, mes, año con validaciones)
3. Solicitar costo de la consulta (double, mayor a 0)
4. Preguntar: "¿El paciente paga ahora? (S/N)"

   SI PAGA:
   - Solicitar monto pagado
   - Si paga COMPLETO: actualizar pagado
   - Si paga PARCIAL: actualizar pagado y pendiente

   NO PAGA:
   - Todo el monto va a pendiente (deuda)

5. Guardar en el expedientePago:
   - consultas[numConsultas] = fecha ingresada
   - montos[numConsultas] = costo
   - Incrementar numConsultas
   - Actualizar pagado y/o pendiente

6. Mostrar resumen:
╔═══════════════════════════════════════════════════════╗
║                        CONSULTA REGISTRADA                                                                                      ║
╠═══════════════════════════════════════════════════════╣
║  Paciente: [Nombre Apellido]                                                                                                        ║
║  Expediente: [###]                                                                                                                          ║
║  Fecha consulta: DD/MM/AAAA                                                                                                  ║
║  Costo: $XX.XX                                                                                                                                ║
║  Pagó: $XX.XX                                                                                                                                  ║
║  Deuda actual: $XX.XX                                                                                                                   ║
╚═══════════════════════════════════════════════════════╝

-------------------------------------------------------------------
OPCIÓN 3: REGISTRAR PAGO (Abono a deuda)
-------------------------------------------------------------------
Proceso:
1. Solicitar número de expediente (validar que exista)
2. Mostrar deuda actual del paciente
3. Si deuda > 0:
   - Solicitar monto a abonar (validar que sea > 0 y <= deuda)
   - Actualizar: pagado += monto
   - Actualizar: pendiente -= monto
   - Mostrar nuevo estado de cuenta
4. Si deuda = 0:
   - Informar que el paciente no tiene deudas pendientes

Mostrar:
╔═══════════════════════════════════════════════════════╗
║                          PAGO REGISTRADO                                                                                              ║
╠═══════════════════════════════════════════════════════╣
║  Paciente: [Nombre Apellido]                                                                                                        ║
║  Abono realizado: $XX.XX                                                                                                             ║
║  Total pagado: $XX.XX                                                                                                                   ║
║  Deuda restante: $XX.XX                                                                                                              ║
╚═══════════════════════════════════════════════════════╝

-------------------------------------------------------------------
OPCIÓN 4: ESTADÍSTICAS
-------------------------------------------------------------------
Submenú:
  a) Estadísticas por sexo (contar M y F)
  b) Estadísticas por diagnóstico (contar cada tipo)
  c) Listado de deudores (NUEVO)
  d) Volver al menú principal

NUEVO: LISTADO DE DEUDORES
- Mostrar SOLO pacientes con pendiente > 0
- Ordenar de MAYOR a MENOR deuda
- Formato de tabla:

╔═══════════════════════════════════════════════════════╗
║         PACIENTES CON DEUDA - ORDENADOS POR MONTO     ║
╠═══════════════════════════════════════════════════════╣
║ Expediente │ Nombre            │ Deuda       │ Pagado ║
╠═══════════════════════════════════════════════════════╣
║    105     │ Juan Pérez        │ $450.00     │ $150.00║
║    102     │ María López       │ $320.00     │ $80.00 ║
║    108     │ Carlos Martínez   │ $200.00     │ $300.00║
╠═══════════════════════════════════════════════════════╣
║ TOTAL DEUDA CLÍNICA: $970.00                          ║
╚═══════════════════════════════════════════════════════╝

════════════════════════════════════════════════════
FUNCIONES REQUERIDAS (En las carpetas que componen el ejercico)
═════════════════════════════════════════════════════════

FUNCIONES DE GESTIÓN:
- crearPaciente() - Crear paciente y su expedientePago
- buscarPaciente() - Buscar por expediente
- modificarPaciente() - Modificar datos
- listarPacientes() - Mostrar todos

FUNCIONES DE CONSULTAS:
- registrarConsulta() - Registrar nueva consulta
- validarFecha() - Validar día, mes, año correctos
- calcularCostoTotal() - Sumar todos los montos

FUNCIONES DE PAGOS:
- registrarPago() - Procesar pago/abono
- actualizarDeuda() - Actualizar pagado y pendiente
- verificarDeuda() - Revisar si tiene deuda

FUNCIONES DE ESTADÍSTICAS:
- contarPorSexo() - Contar M y F
- contarPorDiagnostico() - Agrupar por diagnóstico
- obtenerDeudores() - Filtrar pacientes con deuda > 0
- ordenarPorDeuda() - Ordenar de mayor a menor (usar algoritmo de ordenamiento)

FUNCIONES DE VALIDACIÓN:
- validarExpediente() - Verificar que expediente exista
- validarMonto() - Verificar monto > 0
- validarDia() - Día válido según mes (considerar febrero)
- validarMes() - Entre 1 y 12
- validarAnio() - Año razonable (ej: 2020-2030)

FUNCIONES DE FORMATO:
- mostrarSello() - Sello personalizado
- centrarTexto() - Centrar texto en cuadros
- formatearFecha() - DD/MM/AAAA
- formatearMoneda() - $XX.XX
- obtenerTexto() - Textos bilingües

═══════════════════════════════════════════════════════════════════════════
                        VALIDACIONES CRÍTICAS
═══════════════════════════════════════════════════════════════════════════

FECHAS:
- Mes: 1-12
- Día: 1-31 (ajustar según mes)
- Febrero: 28 días (29 si año bisiesto - función extra)
- Meses de 30 días: abril, junio, septiembre, noviembre
- Meses de 31 días: enero, marzo, mayo, julio, agosto, octubre, diciembre

MONTOS:
- Siempre mayor a 0
- Al abonar: no puede ser mayor que la deuda
- Usar double para permitir centavos

EXPEDIENTES:
- No permitir expedientes duplicados
- Al buscar, validar que exista
- Números enteros positivos

════════════════════════════════════════════════════════
                        CONSIDERACIONES ESPECIALES
═════════════════════════════════════════════════════════

1. LÍMITES:
   - Máximo 100 pacientes
   - Máximo 100 consultas por paciente

2. ORDENAMIENTO:
   - Para deudores: usar algoritmo de burbuja o selección
   - Ordenar de mayor a menor pendiente

3. MANEJO DE ARREGLOS:
   - Usar contadores para saber cuántos elementos hay
   - No dejar espacios vacíos entre elementos

4. DISEÑO DE SALIDAS:
   - TODOS los cuadros deben cerrar perfectamente
   - Usar Math.max(0, ...) en todos los .repeat()
   - Alinear columnas en tablas
   - Formato de moneda: $XX.XX (siempre 2 decimales)
   - Formato de fecha: DD/MM/AAAA

5. EXPERIENCIA DE USUARIO:
   - Mensajes claros y específicos
   - Confirmar acciones importantes
   - Mostrar resúmenes después de operaciones
   - Permitir volver al menú anterior
════════════════════════════════════════════════════════
                        EJEMPLO DE FLUJO COMPLETO
═════════════════════════════════════════════════════════

1. Usuario selecciona idioma (ES/EN)
2. Menú principal
3. Selecciona "Gestión de Pacientes" → Crear paciente
   - Ingresa datos: Juan Pérez, 35 años, M, Obesidad
   - Sistema asigna expediente: 101
   - Se crea expedientePago[101] automáticamente
4. Vuelve al menú principal
5. Selecciona "Realizar Consulta"
   - Expediente: 101
   - Fecha: 24/10/2025
   - Costo: $150.00
   - ¿Paga ahora? S
   - Monto: $100.00
   - Sistema: pagado=$100, pendiente=$50
6. Vuelve al menú principal
7. Selecciona "Registrar Pago"
   - Expediente: 101
   - Deuda actual: $50.00
   - Abono: $50.00
   - Sistema: pagado=$150, pendiente=$0
8. Estadísticas → Deudores → No aparece Juan (ya pagó todo)
════════════════════════════════════════════════════════

Por favor, genera el código completo de ambos archivos siguiendo todas
estas especificaciones. El código debe ser funcional, bien comentado, con
cuadros perfectamente alineados y todas las validaciones implementadas.
 */
package Ejercicio119;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utilidades.mostrarSello();
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}