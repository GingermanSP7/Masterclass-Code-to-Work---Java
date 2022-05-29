package Lezione_1.Modulo2.src.Esercizio3.SerieA;

public class Campionato {
    private Squadra sq[];

    private void ordinaPerPunteggio(Squadra sq[]){          
        for(int i=1;i<sq.length;i++){
            int j = i-1;
            while(j>=0 && sq[j+1].getPunteggio() > sq[j].getPunteggio()){
                Squadra tmp = sq[j+1];
                sq[j+1] = sq[j];
                sq[j] = tmp;
            }
        }
    }

    private void ordinaPerDiffGol(Squadra sq[]){
        int diffGol_sq1 = 0;
        int diffGol_sq2 = 0;
        for(int i=1;i<sq.length;i++){
            int j = i-1;
            diffGol_sq1 = sq[j].getGol_fatti()-sq[j].getGol_subiti();
            while(j>=0 && sq[j+1].getPunteggio() == sq[j].getPunteggio()){
                diffGol_sq2 = sq[j+1].getGol_fatti()-sq[j+1].getGol_subiti();
                if(diffGol_sq2 > diffGol_sq1){
                    Squadra tmp = sq[j+1];
                     sq[j+1] = sq[j];
                     sq[j] = tmp;
                }
                j--;
            }
        }
    }

    Campionato(Squadra sq[]){
        this.sq = sq;
    }

    public void esitoPartita(Squadra casa, int golCasa, Squadra ospite, int golOspite){
        //caso in cui vince la squadra di casa
        if(golCasa > golOspite){
            casa.setPunteggio(casa.getPunteggio()+3);
            casa.setGol_fatti(casa.getGol_fatti()+golCasa);
            casa.setGol_subiti(casa.getGol_subiti()+golOspite);
            return;
        }
        //vince la squadra ospite
        else if(golCasa < golOspite){
            ospite.setPunteggio(ospite.getPunteggio()+3);
            ospite.setGol_fatti(ospite.getGol_fatti()+golOspite);
            ospite.setGol_subiti(ospite.getGol_subiti()+golCasa);
            return;
        }
        //pareggio
        else if(golCasa == golOspite){
            casa.setPunteggio(casa.getPunteggio()+1);
            casa.setGol_fatti(casa.getGol_fatti()+golCasa);

            ospite.setPunteggio((ospite.getPunteggio()+1));
            ospite.setGol_fatti(ospite.getGol_fatti()+golOspite);
            ospite.setGol_subiti(ospite.getGol_subiti()+golCasa);
            return;
        }
        else return;
    }

    public Squadra[] getClassifica(){
        ordinaPerPunteggio(sq);
        ordinaPerDiffGol(sq);
        return sq;
    }

    public Squadra getMiglioreAttacco(){
        Squadra max = sq[0];
        for(int i=1;i<sq.length;i++){
            if(sq[i].getGol_fatti() > max.getGol_fatti()) max = sq[i];
        }
        return max;
    }

    public Squadra getPeggiorDifesa(){
        Squadra p = sq[0];
        for(int i=1;i<sq.length;i++){
            if(sq[i].getGol_subiti() > p.getGol_subiti()) p = sq[i];            
        }
        return p;
    }


    public static void main(String args[]){
        Giocatore g1_Juventus = new Giocatore("1", "Mattia", "Perin");
        Giocatore g2_Juventus = new Giocatore("2", "Giorgio", "Chiellini");
        Giocatore g3_Juventus = new Giocatore("3", "Leonardo", "Bonucci");
        Giocatore g4_Juventus = new Giocatore("4", "Alvaro", "Morata");
        Giocatore g5_Juventus = new Giocatore("5", "Dusan", "Vlahovic");
        
        Giocatore g1_Inter = new Giocatore("6", "Samir", "Handanovic");
        Giocatore g2_Inter = new Giocatore("7", "Robin", "Gosens");
        Giocatore g3_Inter = new Giocatore("8", "Andrea", "Ranocchia");
        Giocatore g4_Inter = new Giocatore("9", "Lautaro", "Martinez");
        Giocatore g5_Inter = new Giocatore("10", "Edin", "Dzeko");
        
        Giocatore g1_Milan = new Giocatore("11", "Mike", "Meignan");
        Giocatore g2_Milan = new Giocatore("12", "Davide","Calabria");
        Giocatore g3_Milan = new Giocatore("13", "Theo", "Hernandez");
        Giocatore g4_Milan = new Giocatore("14", "Rafael", "Leao");
        Giocatore g5_Milan = new Giocatore("15", "Zlatan", "Ibrahimovic");

        Giocatore g1_Roma = new Giocatore("16", "Rui", "Patricio");
        Giocatore g2_Roma = new Giocatore("17", "Davide", "Santon");
        Giocatore g3_Roma = new Giocatore("18", "Leonaro", "Spinnazola");
        Giocatore g4_Roma = new Giocatore("19", "Tammy", "Abraham");
        Giocatore g5_Roma = new Giocatore("20", "Stephan", "El Shaarawy");

        Giocatore g1_Napoli = new Giocatore("21", "Alex", "Meret");
        Giocatore g2_Napoli = new Giocatore("22", "Kalidou", "Koulibaly");
        Giocatore g3_Napoli = new Giocatore("23", "Kevin", "Malcuit");
        Giocatore g4_Napoli = new Giocatore("24", "Lorenzo", "Insigne");
        Giocatore g5_Napoli = new Giocatore("25", "Dries", "Mertens");

        Giocatore juventus[] = {g1_Juventus,g2_Juventus,g3_Juventus,g4_Juventus,g5_Juventus};
        Giocatore inter[] = {g1_Inter,g2_Inter,g3_Inter,g4_Inter,g5_Inter};
        Giocatore milan[] = {g1_Milan,g2_Milan,g3_Milan,g4_Milan,g5_Milan};
        Giocatore roma[] = {g1_Roma,g2_Roma,g3_Roma,g4_Roma,g5_Roma};
        Giocatore napoli[] = {g1_Napoli,g2_Napoli,g3_Napoli,g4_Napoli,g5_Napoli};

        Squadra juv = new Squadra("Juventus", "Juve", juventus);
        Squadra mil = new Squadra("Milan", "Milan", milan);
        Squadra inte = new Squadra("Inter", "Inter", inter);
        Squadra rom = new Squadra("Roma", "Roma", roma);
        Squadra nap = new Squadra("Napoli", "Napoli", napoli);
        
        Squadra s_A[] = {juv,mil,inte,rom,nap};
        Squadra class_serieA[] = null;

        Campionato serieA = new Campionato(s_A);

        serieA.esitoPartita(juv, 3, inte, 2);       
        serieA.esitoPartita(mil, 1, rom, 1);        
        serieA.esitoPartita(nap, 1, inte, 2);
        serieA.esitoPartita(juv, 2, mil, 2);
        serieA.esitoPartita(rom, 1, nap, 0);
        serieA.esitoPartita(mil, 2, inte, 2);
        serieA.esitoPartita(rom, 0, juv, 0);
        serieA.esitoPartita(nap, 2, rom, 1);
        serieA.esitoPartita(mil, 3, juv, 2);

        class_serieA = serieA.getClassifica();
        System.out.println("| NomeSq | | Punti | | Gol Fatti | | Gol Subiti |");
        for(int i=0;i<class_serieA.length;i++){
            System.out.println(class_serieA[i].getNome() + "\t       " +class_serieA[i].getPunteggio() + "\t  " + class_serieA[i].getGol_fatti() + "\t\t" + class_serieA[i].getGol_subiti());
        }

        System.out.println("----------------------");
        System.out.println(serieA.getMiglioreAttacco().getNome() + " -> " + serieA.getMiglioreAttacco().getGol_fatti());
        System.out.println(serieA.getPeggiorDifesa().getNome() + " -> " + serieA.getPeggiorDifesa().getGol_subiti());
        System.out.println("----------------------");

    }   
}
