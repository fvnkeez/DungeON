package mensajes;
import static ansi.Ansi.*;

/**
 * FECHA: 24/04/2025
 * @version 1.8
 * @author Dani Fuente
 * Descripción: Programa para manejar la sala con el jefe final.
 */
public class SalaFinal {

    public static void mostrarSalaFinal() {
        System.out.println(GREEN + "\n╔════════════════════════════════╗");
        System.out.println("║        SALA ACTUAL: " + AZUL + "SALA 6" + GREEN + "     ║");
        System.out.println("╚════════════════════════════════╝");
        
        try {
            System.out.print(BOLD + RED + "\n\n\n\n\n\n\n                  Esta sala no parece normal, escuchas algo acercarse");
            Thread.sleep(300); System.out.print(".");
            Thread.sleep(300); System.out.print(".");
            Thread.sleep(300); System.out.println(".");
        
            Thread.sleep(1200);

            Thread.sleep(1200);

            // Animación en zigzag hacia la derecha con corrupción progresiva
            String[][] carteles = {
                {
                    "╔════════════════════════════════╗",
                    "║        SALA ACTUAL: SALA 6     ║",
                    "╚════════════════════════════════╝"
                },
                {
                    "╔═══════▓═══════════════════════╗",
                    "║        SALA ACTUAL: SA_A 6     ║",
                    "╚═══════════════════▒═══════════╝"
                },
                {
                    "╔═══════░═#═════════════════════╗",
                    "║        SALA ACT_∆L: S∆_A ░     ║",
                    "╚═════▓═══════════════▒═══════╝"
                },
                {
                    "╔═▓═══#═══▐▌▌▌▐▌▐▌▐▐▌▐▐▐▐▌▐▌▌══╗",
                    "║ ▒▒ S@L@ ERR▲R ▓▓▓ C0RRUPT3D ░║",
                    "╚═╩═══▐▌▌▐▌▐▌▐▐▐▌▐▌▌▌▐▐▌▐▐▌═══╝"
                }
            };

            int[] posiciones = {5, 8, 6, 10, 7, 12, 9, 14, 11, 16, 13, 18}; // zigzag
            for (int i = 0; i < posiciones.length; i++) {
                Thread.sleep(70);
                String espacios = " ".repeat(posiciones[i]);
                String[] cartelActual = carteles[Math.min(i / 3, carteles.length - 1)];
                for (String linea : cartelActual) {
                    System.out.println(espacios + linea);
                }
                System.out.println();
            }

            // Letras "corrompiéndose"
            Thread.sleep(800);
            System.out.println("                  ║        SALA ACTUAL: SALA █     ║");
            Thread.sleep(600);
            System.out.println("                  ║        SALA ACTUAL: S∆L∆ ▒▒▒   ║");
            Thread.sleep(600);
            System.out.println("                  ║        ███ CORRUPCIÓN ███      ║");

        
            Thread.sleep(500);
            System.out.println("\n\n                  ╔═╬═══▐█▌▌▌▐▌▐▌▐▐▌▐▐▐▐▌▐▌▌▌▐▐▌═══╬═╗");
            System.out.println("                  ║ ▓▓ ERR0R: ╣ SAL▲A_C❒RRUPT3D ║ S▲LA 6 ║");
            System.out.println("                  ╚═╩═══█▌▌▐▌▐▌▐▐▐▌▐▌▌▌▐▐▌▐▌▌▐▐▌▐▐▌═══╩═╝");
        
            Thread.sleep(800);
            System.out.println("                  ⚠ SYSTEM FAILURE ▓▓▓ Memory Leak Detected...");
            Thread.sleep(1000);
            System.out.println("                  ☠ Unauthorized entity detected in: SALA 6");
            Thread.sleep(800);
            System.out.println("                  █▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█");
        
            // Efecto tipo glitch
            for (int i = 0; i < 5; i++) {
                Thread.sleep(250);
                System.out.println("                  █▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█");
            }
        
                    
            Thread.sleep(1500);
            System.out.println("                  █▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█");
            Thread.sleep(1000);
            System.out.println("                  ▒ La realidad empieza a distorsionarse ▒");
            Thread.sleep(1000);
            System.out.println("                  █▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█");
            Thread.sleep(1200);

            System.out.println(RED + "\n\n\n                  ──────────── ACCESO A LA SALA FINAL ────────────\n");
            Thread.sleep(1500);
            System.out.println("                          ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██");
            System.out.println("                        ██▓▓     " + BOLD + "XAL'THŸGOR" + RED + "     ▓▓██");
            System.out.println("                      ██▓▓   El Devorador de Realidades   ▓▓██");
            System.out.println("                          ██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██");


            System.out.println("""                                                                                      
                                                                                                    
           %%@@@@#                           **@@@@@@@@@                            @@@@*           
        ::***++*-=+#@=                   @@@@@@@@@@@@@@@@-#                    =@#*=:=-**-:*@       
          +%%%*@%%%#*=%@#               %@%@@*@@@%@@@@%@@@@@@               *@*==#%%%@#*%%=         
          @*%@@@@@@%##*-@@@           @@@%@@#@*@@+@@@@@#@*#@%=            =@#-**#%@@@*@@%#          
          @#+%@@@@@@%##**%@%     -   %*%#%@##%*@@-@#*@@@%***@*@@  #@    @@#:***###***%@@@=          
          %@@@@@@@%%%##**=%@-    =@#@@%*#%%#%+##@*%@@#@@*#=#*%*%+ @*   %@%+*++**##%###+****         
        @%#--------=-++=+*=@@#  *@ :*%%%##*%+#@@#-#@=*%@@*@*#=+*  #@- %%***=:*@%%%#####%#:*#@       
      +#=::::**::-*##@@@@:+:#@@@@% *##%%**-%=%@%=**@#%%@+**=#***:  -%@@=+@@@*:=***#*%**#***:***     
       @:**#%@%%#*##***:#%=@@@:   *#-*:*@#%%#*@%**%#*#%@*+*#@-*%*   :@@@%-******###%@@*%@#*%@       
         #@%@@@@@%%%#*****+@@@@   #*###*%=*@*=-@##@##+:#:@@@#***%   +@@:**+****=##%@@@@***:         
          :*##@#%@-=:=++=:@@@:     @-#:-=-:#%*:#::@*:%%-===:=*=%    %@@@##%%%%:***#%@@@@@%          
          @@@@@@@@*--@%#*::@@#     ##%@:====:-:=@*::::-===:@@@+     ##@******=:=**#**@@@%#          
          #%@%%+%##=-*****+@%@@% -%@:@#%@@@##:@@::@@:@@%@+%@%*-    =%**@=+*********-*#:=#%#         
          @%#-#*+*#%###**==%::+@@=**::%%#-:@##@@@@@@@:#-*@%%::=#*@%-:--:#@+**#*#%%#****#+*+         
          =**-*#%@#@+%=#*##---#:*@*:#%=#=#@*%##@@@@****#@:*=%*%@@:@-:@=---%:**%%@%%%+***++%#        
         %#=**#%%@%@=@#=%:=@@:-:-:%#*:=*:@-@*#@%#@@@#=###:%=%##**:@+*=++=--#:#%@#%%##      +%       
        @%       *@@+#*#==+@****---****:%:@%-@@***#@@:*#%*:*##**=*#@%****++=#=**=*                  
                  #%#+#==+%#=*=#:*=#@@#:@@*:@@*%**%*@%*+*%@@=-+****:@******=-#:*#                   
                   @-*=+*=#@*+*#*@@+@@@@#*@@@%@+=::@%@@:#%#+@@@***+=@#**=+*+=-*:*                   
                   @*-=+*=-+@-:@*@*:@%+=*@@%@*:-%*+:#%@@:*:#%@@@**:%*@       %@=+                   
                   @@      =#%@%:::@+#*@@@%@=+#% :=+:%%@@==++#*#***-                                
                             :**#*+@::#%@*#:+@#:@#+*-**#%@+%-###=#                                  
                             @*# %=##*%#%%%:*:%*@*:*-@*###%@##***  @%                               
                        @@+  @#   =**-####=%##+ *:###*:*#*:#%*=--=%*:*@@                            
                       +@   %%*    :**##**=-  @#= %#*::*#*:-%         *:                            
                        *%=##-   %%  =*##=%*##+=@###*#@##*@-=@-   *:@=*@                            
                               #%%=##:**##:%#*-%%##:@:##*-    @*                                    
                               @@     @**#*#*=   -**#*#**:#=%-==                                    
                               @*#%       @@       @@@@   @-:=@                                     
                                                                                                    
                    """);
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
