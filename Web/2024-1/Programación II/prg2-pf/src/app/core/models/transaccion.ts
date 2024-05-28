export interface Transaccion {
    id: number;
    fechaHora: Date
    usuario: string;
    idProducto: number;
    cantComprada: number;
    valorUnitario: number;
    idTipoPago: number;
    idBanco: number;
    idFranquicia: number;
    numTarjeta: string;
    estado: string;
}
