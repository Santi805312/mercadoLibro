package com.ingenieriaSoftware2.dto;

import com.ingenieriaSoftware2.entity.Enums;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class ModelDtos {
    private ModelDtos() {}
    public record UsuarioDto(String email,String nombreUsuario,Enums.RolUsuario rol,BigDecimal saldoTotal,BigDecimal saldoReservado,BigDecimal reputacionPromedio,Enums.EstadoCuenta estadoCuenta,Boolean notificacionEmail,Boolean notificacionInapp,Enums.FrecuenciaNotificacion frecuenciaNotificacion,LocalTime horaResumenDiario) {}
    public record LibroMetadataCacheDto(String isbn,String googleBooksId,String titulo,String autores,BigDecimal puntuacionExterna,LocalDateTime fechaCacheBibliografico,LocalDateTime fechaCachePuntuacion) {}
    public record CategoriaDto(String nombre,String categoriaPadreId) {}
    public record PublicacionDto(String isbn,String emailPropietarioId,LocalDateTime horaDePublicacion,Enums.CalidadLibro estadoFisico,BigDecimal valorPuntosSolicitado,BigDecimal valorReferenciaCalculado,String comentario,Enums.EstadoPublicacion estado,Enums.ColorSemaforo colorSemaforo) {}
    public record CompraDto(String compradorId,String isbn,String propietarioId,LocalDateTime horaDePublicacion,BigDecimal puntos) {}
    public record IntercambioDto(String isbnSolicitante,String propietarioIdSolicitante,LocalDateTime horaDePublicacionSolicitante,String isbnOfrecida,String propietarioIdOfrecida,LocalDateTime horaDePublicacionOfrecida,Enums.TipoIntercambio tipo,Enums.EstadoIntercambio estado,BigDecimal puntosComprometidos) {}
    public record MovimientoPuntosDto(String isbnSolicitante,String propietarioIdSolicitante,LocalDateTime horaDePublicacionSolicitante,String isbnOfrecida,String propietarioIdOfrecida,LocalDateTime horaDePublicacionOfrecida,String idUsuario,Enums.TipoMovimiento tipo,Long monto) {}
    public record CadenaDto(String isbnSolicitanteAnterior,String propietarioIdSolicitanteAnterior,LocalDateTime horaDePublicacionSolicitanteAnterior,String isbnOfrecidaAnterior,String propietarioIdOfrecidaAnterior,LocalDateTime horaDePublicacionOfrecidaAnterior,String isbnSolicitanteSiguiente,String propietarioIdSolicitanteSiguiente,LocalDateTime horaDePublicacionSolicitanteSiguiente,String isbnOfrecidaSiguiente,String propietarioIdOfrecidaSiguiente,LocalDateTime horaDePublicacionOfrecidaSiguiente,Enums.EstadoCadena estado) {}
    public record ResenaDto(String isbnSolicitante,String propietarioIdSolicitante,LocalDateTime horaDePublicacionSolicitante,String isbnOfrecida,String propietarioIdOfrecida,LocalDateTime horaDePublicacionOfrecida,String emailReviewer,Short calificacion,String comentario,Enums.CalidadResena calidad) {}
    public record ReporteDto(String emailReportanteId,LocalDateTime horaReporte,String emailReportadoId,Enums.EntidadReporte entidadTipo,Enums.MotivoReporte motivo,Enums.EstadoReporte estado) {}
    public record BaneoDto(String emailReportanteId,LocalDateTime horaReporte,String emailReportadoId,LocalDateTime fechaInicio,LocalDateTime fechaFin) {}
    public record BajarCalificacionDto(String emailReportanteId,LocalDateTime horaReporte,String emailReportadoId,Short castigo) {}
    public record CartelMalIntercambiadorDto(String emailReportanteId,LocalDateTime horaReporte,String emailReportadoId,Boolean cartel) {}
    public record ListaDto(String emailUsuario,String isbn,String notaPrivada,BigDecimal precioMin,BigDecimal precioMax,Enums.CalidadLibro[] condicionesAceptables,LocalDateTime fechaAgregado) {}
    public record ClasificadoEnDto(String isbn,String nombreCategoria) {}
    public record PublicacionHistorialPrecioDto(String isbn,String emailPropietarioId,LocalDateTime horaDePublicacion,LocalDateTime fechaCambio,BigDecimal valorPuntosAnterior,BigDecimal valorPuntosNuevo,Enums.ColorSemaforo colorAnterior,Enums.ColorSemaforo colorNuevo) {}
    public record NotificacionDto(Long id,String emailUsuario,String isbn,String emailPropietarioId,LocalDateTime horaDePublicacion,Enums.TipoNotificacion tipo,Boolean leida,Boolean archivada,LocalDateTime fechaCreacion) {}
}
