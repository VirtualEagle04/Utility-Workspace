<html>
    <head>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>

    <%@ page import = "java.util.Date,java.text.SimpleDateFormat"%>
    <%
    
        boolean tieneErrores = false;

        String articulo = request.getParameter("articulo");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int precio = Integer.parseInt(request.getParameter("precioPorUnidad"));
        String tarjeta = request.getParameter("tarjeta");
        long numero = Long.parseLong(request.getParameter("numero"));
        String numeroString = request.getParameter("numero");
        
        Date fecha = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


        

        if(articulo.equals("Seleccionar")){
            tieneErrores=true;
        }
        if(cantidad <= 0 || precio <= 0){
            tieneErrores=true;
        }
        if(tarjeta.equals("American Express")){
            if(numeroString.length() < 15 || numeroString.length() > 15){
                tieneErrores=true;
            }
        }else{
            if(numeroString.length() < 16 || numeroString.length() > 16){
                tieneErrores=true;
            }
        }

        if(!tieneErrores){
            out.println("<p>Se&ntilde;or usuario: <b>PEPITO ACME</b></p>");
            out.println("<p>Su compra fue realizada satisfactoriamente por un valor de <b>$ " + (cantidad*precio) + "</b>. Correspondiente a <b>" + cantidad + " " + articulo + "</b>.</p>");
            out.println("<p>El precio por unidad fue de: <b>$ " + precio + "</b>.</p>");
            out.println("<p>La compra fue realizada con la tarjeta de cr&eacute;dito n&uacute;mero: **** **** **** " + numeroString.substring(numeroString.length()-4) + " de la franquicia <b>" + tarjeta + "</b>.</p>");
            out.println("<p>Fecha de la compra: <b>" + dateFormat.format(fecha) +"</b>.</p>");
        }else{
            out.println("<p style=\"color:red;\"><b>NO FUE POSIBLE REALIZAR EL PROCESO DE COMPRA.</b></p>");
        }
    %>


</html>