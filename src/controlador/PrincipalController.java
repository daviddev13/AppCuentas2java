package controlador;

import modelo.Calculadora;
import modelo.Cargar;
import vistas.*;

public class PrincipalController {
    
    private static String Mes = "";
    private static String Efectivo = "";
    private static String Cahorro = "";
    private static String Cahorro2 = "";
    private static String OtraMoneda = "";
    private static String Prestamo = "";
    private static String Prestamo2 = "";
    private static String Consumos = "";
    private static String Gastos = "";
    private static String Deudas = "";
    private static String Entidades = "";
    private static String Obser = "";
    private static String UrlUser = "";
            
    public static VistaPrincipal ventanaPrincipal = new VistaPrincipal();
    public static VistaLoad ventanaLoad = new VistaLoad();
    
    public static void mostrar()
    {
       ventanaPrincipal.setVisible(true);
    }
    public static void ocultar()
    {
       ventanaPrincipal.setVisible(false);
    }
    public static void getDatosWindow()
    {
        Mes = ventanaPrincipal.getjTextField1().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField1().getText();
        System.out.println("Mes en getDatosWindow: " + Mes);
        Efectivo = ventanaPrincipal.getjTextField2().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField2().getText();
        Cahorro = ventanaPrincipal.getjTextField3().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField3().getText();
        Cahorro2 = ventanaPrincipal.getjTextField10().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField10().getText();
        OtraMoneda = ventanaPrincipal.getjTextField9().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField9().getText();
        Prestamo = ventanaPrincipal.getjTextField4().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField4().getText();
        Prestamo2 = ventanaPrincipal.getjTextField8().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField8().getText();
        Consumos = ventanaPrincipal.getjTextField7().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField7().getText();
        Gastos = ventanaPrincipal.getjTextField6().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField6().getText();
        Deudas = ventanaPrincipal.getjTextField12().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField12().getText();
        Entidades = ventanaPrincipal.getjTextField11().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField11().getText();
        Obser = ventanaPrincipal.getjTextField5().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField5().getText();
    }
    public static void eventoBotonConfirmarDatos()
    {
       System.out.println("Clicked Confirmar Datos"); 
       getDatosWindow();
       SaveController.mostrarConfirm();
       //Ir a funcion calcular total actual
       Calculadora calculadora = new Calculadora();        
       int Activos = calculadora.Activos(Efectivo, 
                                           Cahorro,
                                           Cahorro2,
                                          Prestamo,
                                          Prestamo2,
                                          OtraMoneda
                                          );
      // Total Actual a string
       String strTotalAc = String.valueOf(Activos);
       //System.out.println("Resultado: " + TotalAc); 
       
       int Patrimonio = calculadora.Patrimonio(strTotalAc,Deudas);
       
       
       
       String Datos = ("<html>"
                    + "Mes: " + Mes 
                    + "<br>Entidades: " + Entidades
                    + "<br>Efectivo: " + Efectivo
                    + "<br>Cuenta de ahorro: " + Cahorro
                    + "<br>Cuenta de ahorro2: " + Cahorro2                     
                    + "<br>Otra Moneda: " + OtraMoneda
                    + "<br>Inversion: " + Prestamo
                    + "<br>Inversion2: " + Prestamo2
                    + "<br>Consumos: " + Consumos
                    + "<br>Gastos: " + Gastos
                    + "<br>Deudas: " + Deudas
                    + "<br>Observaciones: " + Obser
                    + "<br>Activos: " + strTotalAc
                    + "<br>Pasivos: " + Deudas
                    + "<br>Patrimonio: " + Patrimonio
                    + "</html>");
       //Envio datos a controlador de ventana save
       SaveController.setDatos(Datos);
    }
    public static void BottonLoadSave()
    {
        System.out.println("Load Save clicked!");
        getDataWindowSave();
        System.out.println("2:"+Mes+UrlUser);
        
        String[] Carga;            
        //getDatosWindow();
        String textoMesAct = Mes;
        String referencia = "Mes Actual";
       
        // método para cargar contenido anterior de archivo
        Carga = Cargar.cargarArchivo(textoMesAct,referencia,UrlUser);
     
       // Extraer número de la linea con verificaciones
    String numMes = (Carga[0].contains(": ")) ? Carga[0].split(": ")[1].trim() : "";
    String entidades = (Carga[1].contains(": ")) ? Carga[1].split(": ")[1].trim() : "";
    String numEfectivo = (Carga[2].contains(": ")) ? Carga[2].split(": ")[1].trim() : "";
    String numCahorro = (Carga[3].contains(": ")) ? Carga[3].split(": ")[1].trim() : "";
    String numCahorro2 = (Carga[4].contains(": ")) ? Carga[4].split(": ")[1].trim() : "";
    String numOtherCurrency = (Carga[5].contains(": ")) ? Carga[5].split(": ")[1].trim() : "";
    String numInvest1 = (Carga[6].contains(": ")) ? Carga[6].split(": ")[1].trim() : "";
    String numInvest2 = (Carga[7].contains(": ")) ? Carga[7].split(": ")[1].trim() : "";
    String numConsumos = (Carga[8].contains(": ")) ? Carga[8].split(": ")[1].trim() : "";
    String numGastos = (Carga[9].contains(": ")) ? Carga[9].split(": ")[1].trim() : "";
    String numDeuda = (Carga[10].contains(": ")) ? Carga[10].split(": ")[1].trim() : "";
    String Obs = (Carga[11].contains(": ")) ? Carga[11].split(": ")[1].trim() : "";


        // Asignar el valor al campoEfectivo
        ventanaPrincipal.setjTextField1(numMes);
        ventanaPrincipal.setjTextField2(numEfectivo);
        ventanaPrincipal.setjTextField3(numCahorro);
        ventanaPrincipal.setjTextField4(numInvest1);
        ventanaPrincipal.setjTextField5(Obs);    
        ventanaPrincipal.setjTextField6(numGastos);
        ventanaPrincipal.setjTextField7(numConsumos);
        ventanaPrincipal.setjTextField8(numInvest2);
        ventanaPrincipal.setjTextField9(numOtherCurrency);
        ventanaPrincipal.setjTextField10(numCahorro2);
        ventanaPrincipal.setjTextField11(entidades); 
        ventanaPrincipal.setjTextField12(numDeuda);
        ocultarLoadSave();
    }

    static String SendMes() 
    {
       String Datos2 = ventanaPrincipal.getjTextField1().getText();     
       //System.out.println("field1 es:"+Datos2);
       return Datos2;
    }
    
    public static void mostrarLoadSave()
    {
       ventanaLoad.setVisible(true);
    }
    public static void ocultarLoadSave()
    {
       ventanaLoad.setVisible(false);
    }
    public static void getDataWindowSave()
    {
       //Mes = ventanaLoad.getjTextField1().getText();
       UrlUser = ventanaLoad.getjTextField2().getText();
       System.out.println(Mes+UrlUser);
    }
}
