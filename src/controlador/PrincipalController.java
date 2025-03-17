package controlador;

import modelo.Calculadora;
import modelo.Cargar;
import vistas.*;

public class PrincipalController {
    
    private static String Mes = "";
    private static String Efectivo = "";
    private static String Cahorro = "";
    private static String Cahorro2 = "";
    private static String Cahorro3 = "";
    private static String OtraMoneda = "";
    private static String Prestamo = "";
    private static String Prestamo2 = "";
    private static String Consumos = "";
    private static String Gastos = "";
    private static String Deudas = "";
    private static String Entidades = "";
    private static String Obser = "";
    
    private static String ObsEfect = "";
    
    private static String ConsigxMes = "";
    private static String ConsigC2xMes = "";
    private static String ConsigC3xMes = "";
    
    private static String AcumCons = "";
    private static String AcumInv = "";
    
    private static String ApertInv = "";
    
    private static String ObsCuentaAhorro = "";
    private static String ObOM = "";
    private static String ob_inv1 = "";
    private static String ob_inv2 = "";
    private static String ob_compra = "";
    private static String ob_gastos = "";
    private static String Ob_deudas = "";

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
        Cahorro3 = ventanaPrincipal.getjTextField26().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField26().getText();
        OtraMoneda = ventanaPrincipal.getjTextField9().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField9().getText();
        Prestamo = ventanaPrincipal.getjTextField4().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField4().getText();
        Prestamo2 = ventanaPrincipal.getjTextField8().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField8().getText();
        Consumos = ventanaPrincipal.getjTextField7().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField7().getText();
        Gastos = ventanaPrincipal.getjTextField6().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField6().getText();
        Deudas = ventanaPrincipal.getjTextField12().getText().isEmpty() ? "0" : ventanaPrincipal.getjTextField12().getText();
        Entidades = ventanaPrincipal.getjTextField11().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField11().getText();
        Obser = ventanaPrincipal.getjTextField5().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField5().getText();
        
        ObsEfect = ventanaPrincipal.getjTextField21().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField21().getText();
        
        ConsigxMes = ventanaPrincipal.getjTextField13().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField13().getText();
        ConsigC2xMes = ventanaPrincipal.getjTextField20().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField20().getText();
        ConsigC3xMes = ventanaPrincipal.getjTextField27().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField27().getText();
        ApertInv = ventanaPrincipal.getjTextField23().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField23().getText();
        
        AcumCons = ventanaPrincipal.getjTextField24().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField24().getText();
        AcumInv = ventanaPrincipal.getjTextField25().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField25().getText();
        
        ObsCuentaAhorro = ventanaPrincipal.getjTextField19().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField19().getText();
        ObOM = ventanaPrincipal.getjTextField22().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField22().getText();
        ob_inv1 = ventanaPrincipal.getjTextField14().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField14().getText();
        ob_inv2 = ventanaPrincipal.getjTextField15().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField15().getText();
        ob_compra = ventanaPrincipal.getjTextField16().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField16().getText();
        ob_gastos = ventanaPrincipal.getjTextField17().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField17().getText();
        Ob_deudas = ventanaPrincipal.getjTextField18().getText().isEmpty() ? "vacio" : ventanaPrincipal.getjTextField18().getText();
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
                                           Cahorro3,
                                          Prestamo,
                                          Prestamo2,
                                          OtraMoneda
                                          );
      // Total Actual a string
       String strTotalAc = String.valueOf(Activos);
       //System.out.println("Resultado: " + TotalAc); 
       
       int Patrimonio = calculadora.Patrimonio(strTotalAc,Deudas);
       
      // Calculadora calculadora2 = new Calculadora();
       int acum = calculadora.AcumuladoConsig(ConsigxMes,ConsigC2xMes);
      // int acum2 = calculadora.AcumuladoInver(ApertInv);
       
       
               
       String Datos = ("<html>"
                    + "Mes: " + Mes 
               + "<br>*******************************" 
                    + "<br>Efectivo: " + Efectivo
               + "<br>ObsEfectivo: " + ObsEfect
               + "<br>*******************************" 
                    + "<br>Cuenta de ahorro: " + Cahorro
                    + "<br>Cuenta de ahorro2: " + Cahorro2 
                    + "<br>Cuenta de ahorro3: " + Cahorro3 
               + "<br>ConsignacionesXMesC1: " + ConsigxMes
               + "<br>ConsignacionesXMesC2: " + ConsigC2xMes
               + "<br>ConsignacionesXMesC3: " + ConsigC3xMes
               + "<br>ObsCuentaAhorro: " + ObsCuentaAhorro
               + "<br>*******************************" 
                    + "<br>Otra Moneda: " + OtraMoneda
               + "<br>ObsOM: " + ObOM
               + "<br>*******************************" 
               + "<br>AperturaInversiones: " + ApertInv
                    + "<br>Inversion: " + Prestamo
               + "<br>ObsInv1: " + ob_inv1
                    + "<br>Inversion2: " + Prestamo2
               + "<br>ObsInv2: " + ob_inv2
               + "<br>*******************************" 
                    + "<br>Compras: " + Consumos
               + "<br>ObsCompra: " + ob_compra
                    + "<br>Gastos: " + Gastos
               + "<br>ObsGastos: " + ob_gastos 
                    + "<br>Deudas: " + Deudas 
               + "<br>ObsDeudas: " + Ob_deudas
               + "<br>*******************************" 
                    + "<br>Activos: " + strTotalAc
                    + "<br>Pasivos: " + Deudas
                    + "<br>Patrimonio: " + Patrimonio
               + "<br>*******************************" 
               + "<br>AcumConsignaciones: " + AcumCons
               + "<br>AcumInversiones: " + AcumInv
                    + "<br>Observaciones: " + Obser
                    + "<br>Entidades: " + Entidades

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
    
    String numEfectivo = (Carga[2].contains(": ")) ? Carga[2].split(": ")[1].trim() : "";
    String ObsEfectC = (Carga[3].contains(": ")) ? Carga[3].split(": ")[1].trim() : "";
    
    String numCahorro = (Carga[5].contains(": ")) ? Carga[5].split(": ")[1].trim() : "";
    String numCahorro2 = (Carga[6].contains(": ")) ? Carga[6].split(": ")[1].trim() : "";
    String numCahorro3 = (Carga[7].contains(": ")) ? Carga[7].split(": ")[1].trim() : "";
    
    String ConsigxMesC = (Carga[8].contains(": ")) ? Carga[8].split(": ")[1].trim() : "";
    String ConsigxMesC2 = (Carga[9].contains(": ")) ? Carga[9].split(": ")[1].trim() : "";
    String ConsigxMesC3 = (Carga[10].contains(": ")) ? Carga[10].split(": ")[1].trim() : "";
    String ObsCuentaAhorroC = (Carga[11].contains(": ")) ? Carga[11].split(": ")[1].trim() : "";
    
    String numOtherCurrency = (Carga[13].contains(": ")) ? Carga[13].split(": ")[1].trim() : "";
    String ObOMC = (Carga[14].contains(": ")) ? Carga[14].split(": ")[1].trim() : "";
    
    String Apt_inv = (Carga[16].contains(": ")) ? Carga[16].split(": ")[1].trim() : "";
    String numInvest1 = (Carga[17].contains(": ")) ? Carga[17].split(": ")[1].trim() : "";
    String ob_inv1C = (Carga[18].contains(": ")) ? Carga[18].split(": ")[1].trim() : "";
    String numInvest2 = (Carga[19].contains(": ")) ? Carga[19].split(": ")[1].trim() : "";
    String ob_inv2C = (Carga[20].contains(": ")) ? Carga[20].split(": ")[1].trim() : "";
    
    String numConsumos = (Carga[22].contains(": ")) ? Carga[22].split(": ")[1].trim() : "";
    String ob_compraC = (Carga[23].contains(": ")) ? Carga[23].split(": ")[1].trim() : "";
    String numGastos = (Carga[24].contains(": ")) ? Carga[24].split(": ")[1].trim() : "";
    String ob_gastosC  = (Carga[25].contains(": ")) ? Carga[25].split(": ")[1].trim() : "";
    String numDeuda = (Carga[26].contains(": ")) ? Carga[26].split(": ")[1].trim() : ""; 
    String Ob_deudasC = (Carga[27].contains(": ")) ? Carga[27].split(": ")[1].trim() : "";
    
    String Acum_con = (Carga[33].contains(": ")) ? Carga[33].split(": ")[1].trim() : "";
    String Acum_inv  = (Carga[34].contains(": ")) ? Carga[34].split(": ")[1].trim() : "";
    String Obs = (Carga[35].contains(": ")) ? Carga[35].split(": ")[1].trim() : "";
    String entidades = (Carga[36].contains(": ")) ? Carga[36].split(": ")[1].trim() : "";
    
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
        ventanaPrincipal.setjTextField26(numCahorro3);
        ventanaPrincipal.setjTextField11(entidades); 
        ventanaPrincipal.setjTextField12(numDeuda);
        
        ventanaPrincipal.setjTextField21(ObsEfectC);
        
        ventanaPrincipal.setjTextField13(ConsigxMesC);
        ventanaPrincipal.setjTextField20(ConsigxMesC2);
        ventanaPrincipal.setjTextField27(ConsigxMesC3);
        
        ventanaPrincipal.setjTextField19(ObsCuentaAhorroC);
        ventanaPrincipal.setjTextField22(ObOMC);
        ventanaPrincipal.setjTextField14(ob_inv1C);
        ventanaPrincipal.setjTextField15(ob_inv2C);
        ventanaPrincipal.setjTextField16(ob_compraC);
        ventanaPrincipal.setjTextField17(ob_gastosC);
        ventanaPrincipal.setjTextField18(Ob_deudasC);
        
        ventanaPrincipal.setjTextField23(Apt_inv);
        ventanaPrincipal.setjTextField24(Acum_con);
        ventanaPrincipal.setjTextField25(Acum_inv); 
        
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
