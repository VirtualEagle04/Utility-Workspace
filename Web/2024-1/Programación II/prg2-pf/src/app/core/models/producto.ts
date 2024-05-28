export interface Producto {
    id: number;
    idCategoria: number;
    codigo: string;
    descripcion: string;
    existencia: number;
    precioVentaActual: bigint;
    precioVentaAnterior: bigint;
    costoVenta: bigint;
    margenUtilidad: number;
    tieneIva: string;
    stockMinimo: number;
    stockMaximo: number;
    estado: string;
}
