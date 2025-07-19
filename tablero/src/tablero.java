package tablero;
import java.awt.*;
/*Equipo:
Cortes Juarez Edson Albert
Perez Perez Evelyn Michelle
Solano Ortega Fernando
Vergara Alarcon Roberto
*/
public class tablero extends Frame
{
       public tablero()
       {
        super("Plano cartesiano");
        setSize(300,300);
        setLayout(new GridLayout(8,8));
        Button boton1 = new Button("Torre A8");add(boton1);
        boton1.setBackground(Color.white);
        

        Button boton2 = new Button("Caballo B8");add(boton2);
        boton2.setBackground(Color.BLACK);

        Button boton3 = new Button("Alfil C8");add(boton3);
        boton3.setBackground(Color.white);

        Button boton4 = new Button("Reyna D8"); add(boton4);
        boton4.setBackground(Color.BLACK);

        Button boton5 = new Button("Rey E8");add(boton5);
        boton5.setBackground(Color.white);

        Button boton6 = new Button("Alfil F8"); add(boton6);
        boton6.setBackground(Color.BLACK);

        Button boton7 = new Button("Caballo G8");add(boton7);
        boton7.setBackground(Color.white);

        Button boton8 = new Button("Torre H8"); add(boton8);
        boton8.setBackground(Color.BLACK);

        Button boton9 = new Button("Peon A7");add(boton9);
        boton9.setBackground(Color.BLACK);

        Button boton10 = new Button("Peon B7");add(boton10);
        boton10.setBackground(Color.white);

        Button boton11 = new Button("Peon C7");add(boton11);
        boton11.setBackground(Color.BLACK);

        Button boton12 = new Button("Peon D7");add(boton12);
        boton12.setBackground(Color.white);

        Button boton13 = new Button("Peon E7"); add(boton13);
        boton13.setBackground(Color.BLACK);

        Button boton14 = new Button("Peon F7");add(boton14);
        boton14.setBackground(Color.white);

        Button boton15 = new Button("Peon G7"); add(boton15);
        boton15.setBackground(Color.BLACK);

        Button boton16 = new Button("Peon H7");add(boton16);
        boton16.setBackground(Color.white);

        Button boton17 = new Button(""); add(boton17);
        boton17.setBackground(Color.white);

        Button boton18 = new Button("");add(boton18);
        boton18.setBackground(Color.BLACK);

        Button boton19 = new Button("");add(boton19);
        boton19.setBackground(Color.white);

        Button boton20 = new Button("");add(boton20);
        boton20.setBackground(Color.BLACK);

        Button boton21 = new Button("");add(boton21);
        boton21.setBackground(Color.white);

        Button boton22 = new Button(""); add(boton22);
        boton22.setBackground(Color.BLACK);

        Button boton23 = new Button("");add(boton23);
        boton23.setBackground(Color.white);

        Button boton24 = new Button(""); add(boton24);
        boton24.setBackground(Color.BLACK);

        Button boton25 = new Button("");add(boton25);
        boton25.setBackground(Color.BLACK);

        Button boton26 = new Button(""); add(boton26);
        boton26.setBackground(Color.white);

        Button boton27 = new Button("");add(boton27);
        boton27.setBackground(Color.BLACK);

        Button boton28 = new Button("");add(boton28);
        boton28.setBackground(Color.white);

        Button boton29 = new Button("");add(boton29);
        boton29.setBackground(Color.black);

        Button boton30 = new Button("");add(boton30);
        boton30.setBackground(Color.white);

        Button boton31 = new Button(""); add(boton31);
        boton31.setBackground(Color.BLACK);

        Button boton32 = new Button("");add(boton32);
        boton32.setBackground(Color.white);

        Button boton33 = new Button(""); add(boton33);
        boton33.setBackground(Color.white);

        Button boton34 = new Button("");add(boton34);
        boton34.setBackground(Color.BLACK);

        Button boton35 = new Button(""); add(boton35);
        boton35.setBackground(Color.white);

        Button boton36 = new Button("");add(boton36);
        boton36.setBackground(Color.BLACK);

        Button boton37 = new Button("");add(boton37);
        boton37.setBackground(Color.white);

        Button boton38 = new Button("");add(boton38);
        boton38.setBackground(Color.BLACK);

        Button boton39 = new Button("");add(boton39);
        boton39.setBackground(Color.white);

        Button boton40 = new Button(""); add(boton40);
        boton40.setBackground(Color.BLACK);

        Button boton41 = new Button("");add(boton41);
        boton41.setBackground(Color.BLACK);

        Button boton42 = new Button(""); add(boton42);
        boton42.setBackground(Color.white);

        Button boton43 = new Button("");add(boton43);
        boton43.setBackground(Color.BLACK);

        Button boton44 = new Button(""); add(boton44);
        boton44.setBackground(Color.white);

        Button boton45 = new Button("");add(boton45);
        boton45.setBackground(Color.BLACK);

        Button boton46 = new Button("");add(boton46);
        boton46.setBackground(Color.white);

        Button boton47 = new Button("");add(boton47);
        boton47.setBackground(Color.BLACK);

        Button boton48 = new Button("");add(boton48);
        boton48.setBackground(Color.white);

        Button boton49 = new Button("Peon A2");add(boton49);
        boton49.setBackground(Color.white);

        Button boton50 = new Button("Peon B2"); add(boton50);
        boton50.setBackground(Color.BLACK);

        Button boton51 = new Button("Peon C2");add(boton51);
        boton51.setBackground(Color.white);

        Button boton52 = new Button("Peon D2"); add(boton52);
        boton52.setBackground(Color.BLACK);

        Button boton53 = new Button("Peon E2");add(boton53);
        boton53.setBackground(Color.white);

        Button boton54 = new Button("Peon F2");add(boton54);
        boton54.setBackground(Color.BLACK);

        Button boton55 = new Button("Peon G2");add(boton55);
        boton55.setBackground(Color.white);

        Button boton56 = new Button("Peon H2");add(boton56);
        boton56.setBackground(Color.BLACK);

        Button boton57 = new Button("Torre A1"); add(boton57);
        boton57.setBackground(Color.BLACK);

        Button boton58 = new Button("Caballo B1");add(boton58);
        boton58.setBackground(Color.white);

        Button boton59 = new Button("Alfil C1"); add(boton59);
        boton59.setBackground(Color.BLACK);

        Button boton60 = new Button("Reyna D1");add(boton60);
        boton60.setBackground(Color.white);

        Button boton61 = new Button("Rey E1"); add(boton61);
        boton61.setBackground(Color.black);

        Button boton62 = new Button("Alfil F1");add(boton62);
        boton62.setBackground(Color.white);

        Button boton63 = new Button("Caballo G1");add(boton63);
        boton63.setBackground(Color.BLACK);

        Button boton64 = new Button("Torre H1");add(boton64);
        boton64.setBackground(Color.white);

        setVisible(true);
       }
       public static void main(String[] args)
       {
        tablero f = new tablero();
       }
}