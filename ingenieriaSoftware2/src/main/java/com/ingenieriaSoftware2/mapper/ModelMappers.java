package com.ingenieriaSoftware2.mapper;

import com.ingenieriaSoftware2.dto.ModelDtos.*;
import com.ingenieriaSoftware2.entity.*;

public final class ModelMappers {
    private ModelMappers() {}
    public static UsuarioDto toDto(Usuario e){return new UsuarioDto(e.getEmail(),e.getNombreUsuario(),e.getRol(),e.getSaldoTotal(),e.getSaldoReservado(),e.getReputacionPromedio(),e.getEstadoCuenta(),e.getNotificacionEmail(),e.getNotificacionInapp(),e.getFrecuenciaNotificacion(),e.getHoraResumenDiario());}
    public static LibroMetadataCacheDto toDto(LibroMetadataCache e){return new LibroMetadataCacheDto(e.getIsbn(),e.getGoogleBooksId(),e.getTitulo(),e.getAutores(),e.getPuntuacionExterna(),e.getFechaCacheBibliografico(),e.getFechaCachePuntuacion());}
    public static CategoriaDto toDto(Categoria e){return new CategoriaDto(e.getNombre(),e.getCategoriaPadreId());}
    public static PublicacionDto toDto(Publicacion e){return new PublicacionDto(e.getIsbn(),e.getEmailPropietarioId(),e.getHoraDePublicacion(),e.getEstadoFisico(),e.getValorPuntosSolicitado(),e.getValorReferenciaCalculado(),e.getComentario(),e.getEstado(),e.getColorSemaforo());}
    public static CompraDto toDto(Compra e){return new CompraDto(e.getCompradorId(),e.getIsbn(),e.getPropietarioId(),e.getHoraDePublicacion(),e.getPuntos());}
    public static IntercambioDto toDto(Intercambio e){return new IntercambioDto(e.getIsbnSolicitante(),e.getPropietarioIdSolicitante(),e.getHoraDePublicacionSolicitante(),e.getIsbnOfrecida(),e.getPropietarioIdOfrecida(),e.getHoraDePublicacionOfrecida(),e.getTipo(),e.getEstado(),e.getPuntosComprometidos());}
    public static MovimientoPuntosDto toDto(MovimientoPuntos e){return new MovimientoPuntosDto(e.getIsbnSolicitante(),e.getPropietarioIdSolicitante(),e.getHoraDePublicacionSolicitante(),e.getIsbnOfrecida(),e.getPropietarioIdOfrecida(),e.getHoraDePublicacionOfrecida(),e.getIdUsuario(),e.getTipo(),e.getMonto());}
    public static CadenaDto toDto(Cadena e){return new CadenaDto(e.getIsbnSolicitanteAnterior(),e.getPropietarioIdSolicitanteAnterior(),e.getHoraDePublicacionSolicitanteAnterior(),e.getIsbnOfrecidaAnterior(),e.getPropietarioIdOfrecidaAnterior(),e.getHoraDePublicacionOfrecidaAnterior(),e.getIsbnSolicitanteSiguiente(),e.getPropietarioIdSolicitanteSiguiente(),e.getHoraDePublicacionSolicitanteSiguiente(),e.getIsbnOfrecidaSiguiente(),e.getPropietarioIdOfrecidaSiguiente(),e.getHoraDePublicacionOfrecidaSiguiente(),e.getEstado());}
    public static ResenaDto toDto(Resena e){return new ResenaDto(e.getIsbnSolicitante(),e.getPropietarioIdSolicitante(),e.getHoraDePublicacionSolicitante(),e.getIsbnOfrecida(),e.getPropietarioIdOfrecida(),e.getHoraDePublicacionOfrecida(),e.getEmailReviewer(),e.getCalificacion(),e.getComentario(),e.getCalidad());}
    public static ReporteDto toDto(Reporte e){return new ReporteDto(e.getEmailReportanteId(),e.getHoraReporte(),e.getEmailReportadoId(),e.getEntidadTipo(),e.getMotivo(),e.getEstado());}
    public static BaneoDto toDto(Baneo e){return new BaneoDto(e.getEmailReportanteId(),e.getHoraReporte(),e.getEmailReportadoId(),e.getFechaInicio(),e.getFechaFin());}
    public static BajarCalificacionDto toDto(BajarCalificacion e){return new BajarCalificacionDto(e.getEmailReportanteId(),e.getHoraReporte(),e.getEmailReportadoId(),e.getCastigo());}
    public static CartelMalIntercambiadorDto toDto(CartelMalIntercambiador e){return new CartelMalIntercambiadorDto(e.getEmailReportanteId(),e.getHoraReporte(),e.getEmailReportadoId(),e.getCartel());}
    public static ListaDto toDto(Lista e){return new ListaDto(e.getEmailUsuario(),e.getIsbn(),e.getNotaPrivada(),e.getPrecioMin(),e.getPrecioMax(),e.getCondicionesAceptables(),e.getFechaAgregado());}
    public static ClasificadoEnDto toDto(ClasificadoEn e){return new ClasificadoEnDto(e.getIsbn(),e.getNombreCategoria());}
    public static PublicacionHistorialPrecioDto toDto(PublicacionHistorialPrecio e){return new PublicacionHistorialPrecioDto(e.getIsbn(),e.getEmailPropietarioId(),e.getHoraDePublicacion(),e.getFechaCambio(),e.getValorPuntosAnterior(),e.getValorPuntosNuevo(),e.getColorAnterior(),e.getColorNuevo());}
    public static NotificacionDto toDto(Notificacion e){return new NotificacionDto(e.getId(),e.getEmailUsuario(),e.getIsbn(),e.getEmailPropietarioId(),e.getHoraDePublicacion(),e.getTipo(),e.getLeida(),e.getArchivada(),e.getFechaCreacion());}
}
