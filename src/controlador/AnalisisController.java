package controlador;

import modelo.Cargar;
import modelo.RevisarDiferencia;
import vistas.*;

public class AnalisisController {
    
    public static VistaAnalisis ventanaAnalisis = new VistaAnalisis();
    public static VistaLoadAnalisis ventanaLoadAnalisis = new VistaLoadAnalisis();
    
    private static String Mes = "";
    private static String UrlUser = "";
    
    public static void mostrar()
    {
       ventanaAnalisis.setVisible(true);
    }
    public static void ocultar()
    {
       ventanaAnalisis.setVisible(false);
    }
    //Fijar Datos jlabel VistaAnalisis
    public static void setDatos(String Datos)
    {
       ventanaAnalisis.setjLabel1Text(Datos);
    }
    public static void setDatos2(String Datos)
    {
       ventanaAnalisis.setjLabel2Text(Datos);
    }
    public static void setDatos3(String Datos)
    {
       ventanaAnalisis.setjLabel3Text(Datos);
    }
   
    public static void BotonAnalisis()
    {
       mostrar();
       getDataWindowLoadAnalisis();
       System.out.println("Analisis clicked!");
      // String Mes= PrincipalController.SendMes();
       //System.out.println("Mes:"+Mes);
       String[] MesAnt;
       String[] getDiferencia;
      
       // Cargar Mes actual   
       String referencia = "Mes Actual";
       String[] MesAct;
       MesAct = Cargar.cargarArchivo(Mes,referencia,UrlUser);     
       // Etiqueta mesAct en panel
       String EtiMesAct = ("<html>" 
                    + MesAct[0] + "<br>" 
                    +"<br>"
                    + MesAct[12] + "<br>" 
                    + MesAct[13] + "<br>"
                    + MesAct[14] + "<br>"
                    + "</html>");
       setDatos(EtiMesAct);
       
       // Cargar mes anterior
       String referencia2 = "Mes Anterior";
       String MesAnterior = MesAct[0];
       System.out.println(MesAnterior);
       MesAnt = Cargar.cargarArchivo(MesAnterior, referencia2,UrlUser);
       if (MesAnt.length >= 6) 
       {         
          // Etiqueta mesAnt en panel
          String EtiMesAnt = ("<html>" 
                    + MesAnt[0] + "<br>" 
                    +"<br>"
                    + MesAnt[12] + "<br>" 
                    + MesAnt[13] + "<br>"
                    + MesAnt[14] + "<br>"
                     + "</html>");
          setDatos2(EtiMesAnt);
          
          //Metodo para restar MesAnt y MesAct
          getDiferencia = RevisarDiferencia.diferencia(MesAct, MesAnt); 
            
          //Etiqueta Diferencia en panel
          String EtiDiferencia = ("<html>"
                   + "diferencia Activos: " + getDiferencia[0]+
             "<br>"+ "diferencia Pasivos: " + getDiferencia[1]+
             "<br>"+ "diferencia Patrimonio: " + getDiferencia[2]+
                  
                  /*getDiferencia[0]+
             "<br>"+ getDiferencia[1]+ getDiferencia[1]+
             "<br>"+ getDiferencia[2]+ getDiferencia[2]+                   
                   */"</html>");
          setDatos3(EtiDiferencia);
          
          ocultarLoadAnalisis();
        } 
        else 
       {
          // Manejar el caso en el que el array no tiene la longitud esperada
          System.out.println("El array MesAnt no tiene la longitud esperada.");
       }
    }
    
    public static void mostrarLoadAnalisis()
    {
       ventanaLoadAnalisis.setVisible(true);
    }
    public static void ocultarLoadAnalisis()
    {
       ventanaLoadAnalisis.setVisible(false);
    }
    public static void getDataWindowLoadAnalisis()
    {
       //Mes = ventanaLoadAnalisis.getjTextField1().getText();
       UrlUser = ventanaLoadAnalisis.getjTextField2().getText();
       System.out.println(UrlUser);
    }
   
}
