<html>
    <head>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>
    </head>

    <%@ page import = "java.util.Date, java.text.SimpleDateFormat, java.lang.Exception"%>
    <%

        Date fecha = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        boolean tieneErrores = false;

        int valorNum = 0;
        String valor = "";
        String banco = "";
        String franquicia = "";
        long numero = 0;
        String numeroString = "";

        


        try{
            valorNum = Integer.parseInt(request.getParameter("valor"));
            valor = request.getParameter("valor");

            banco = request.getParameter("banco");
            franquicia = request.getParameter("franquicia");

            numeroString = request.getParameter("numero");
        }catch(Exception e){
            out.println(e.getStackTrace());
        }
        
        //BANCO TIENE VALOR, IGNORAR franquicia Y numero
        if(!banco.equals("Seleccionar")){
                
            //AQUI
            try{
                valorNum = Integer.parseInt(request.getParameter("valor"));
                valor = request.getParameter("valor");

                banco = request.getParameter("banco");

                out.println("<table align='center' border='1'><tr><th>Tx.</th><th>Fecha</th><th>Valor</th><th>Banco</th><th>Tarjeta</th><th>Franquicia</th></tr><tr><td>1</td><td> "+ dateFormat.format(new Date())+ " </td><td>"+valor+"</td><td>"+ banco +"</td><td></td><td></td></tr></table>");
            }catch(Exception e){
                out.println("Exception caso 1");
            }
        }
        //BANCO NO TIENE VALOR, VERIFICAR franquicia y numero
        else if(banco.equals("Seleccionar")){
            if(franquicia.equals("Seleccionar") || numero <= 0){
                tieneErrores = true;
            }else{
                if(franquicia.equals("American Express")){
                    if(numeroString.length() < 15 || numeroString.length() > 15){
                        tieneErrores=true;
                    }
                }else{
                    if(numeroString.length() < 16 || numeroString.length() > 16){
                        tieneErrores=true;
                    }
                }
            }
            //AQUI 
            try{
                valorNum = Integer.parseInt(request.getParameter("valor"));
                valor = request.getParameter("valor");

                banco = request.getParameter("banco");
                franquicia = request.getParameter("franquicia");

                numero = Long.parseLong(request.getParameter("numero"));
                numeroString = request.getParameter("numero");

                out.println("<table align='center' border='1'><tr><th>Tx.</th><th>Fecha</th><th>Valor</th><th>Banco</th><th>Tarjeta</th><th>Franquicia</th></tr><tr><td>1</td><td> "+ dateFormat.format(new Date())+ " </td><td>"+valor+"</td><td></td><td>**** **** **** " + numeroString.substring(numeroString.length()-4) +"</td><td>"+franquicia+"</td></tr></table>");
            }catch(Exception e){
                out.println("Exception caso 2");
            }

        }
       
    %>


</html>