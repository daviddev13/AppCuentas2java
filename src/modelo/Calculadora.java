
package modelo;

public class Calculadora {
    
     public int Activos( String textcash, String textSaving, String textSaving2,
                          String textloan, String textloan2, String textOtherCurrency ) 
     {
         // Obtener textos de cada campo
         int numCash = Integer.parseInt(textcash);
         int numSave = Integer.parseInt(textSaving);
         int numSave2 = Integer.parseInt(textSaving2);
         int numLoan = Integer.parseInt(textloan);
         int numLoan2 = Integer.parseInt(textloan2);
         int numOtherCurrency = Integer.parseInt(textOtherCurrency);

         // Calculo Total actual
         int totalAc = numCash + numSave + numSave2 + numLoan + numLoan2 + numOtherCurrency;

         return totalAc;
    } 
     
    public int Patrimonio (String textActivos, String textDeudas)
    {
       int numActivos = Integer.parseInt(textActivos);
       int numDeudas = Integer.parseInt(textDeudas);
       int Patrimonio = numActivos - numDeudas;
       return Patrimonio;
    }
    
    public int AcumuladoConsig (String ConsigxMes, String ConsigC2xMes)
    {
       int Consig1 = Integer.parseInt(ConsigxMes);
       int Consig2 = Integer.parseInt(ConsigC2xMes);
       int Consignaciones = Consig1 + Consig2;
       return Consignaciones;
    }
    
    public int AcumuladoInver (String textActivos, String textDeudas)
    {
       int numActivos = Integer.parseInt(textActivos);
       int numDeudas = Integer.parseInt(textDeudas);
       int Patrimonio = numActivos - numDeudas;
       return Patrimonio;
    }
    
}

 