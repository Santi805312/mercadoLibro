package com.ingenieriaSoftware2.entity;

public final class Enums {
    private Enums() {}

    public enum RolUsuario { ADMINISTRADOR, USUARIO }
    public enum EstadoCuenta { ACTIVA, SUSPENDIDA, BANEADA }
    public enum FrecuenciaNotificacion { INSTANTANEA, DIARIA }
    public enum CalidadLibro { NUEVO, COMO_NUEVO, BUENO, ACEPTABLE, MALO }
    public enum EstadoPublicacion { DISPONIBLE, RESERVADA, VENDIDA, ELIMINADA }
    public enum ColorSemaforo { VERDE, AMARILLO, ROJO, SIN_REFERENCIA }
    public enum TipoIntercambio { DIRECTO, CON_PUNTOS }
    public enum EstadoIntercambio { PENDIENTE, ACEPTADO, RECHAZADO, CANCELADO, COMPLETADO }
    public enum TipoMovimiento { INGRESO, EGRESO, RESERVA, LIBERACION_RESERVA, DEVOLUCION }
    public enum EstadoCadena { ACTIVA, COMPLETADA, CANCELADA }
    public enum CalidadResena { POSITIVA, NEGATIVA }
    public enum EntidadReporte { USUARIO, PUBLICACION, INTERCAMBIO }
    public enum MotivoReporte { MAL_ESTADO_LIBRO, INCUMPLIMIENTO_INTERCAMBIO, FRAUDE, COMPORTAMIENTO_INADECUADO, OTRO }
    public enum EstadoReporte { PENDIENTE, EN_REVISION, RESUELTO, RECHAZADO }
    public enum TipoNotificacion { PUBLICACION_NUEVA, BAJA_PRECIO, CRUCE_VERDE, OTRO }
}
