package cli;

import ui.TicketReservationSystemUI;

public class main {
    public static void main(String[] args) {
        if(args.length() == 0){
        TicketReservationSystemUI ticketReservationSystemUI = new TicketReservationSystemUI();
        }
        else if(args[0].equals("console"){
        LoginInterface lg = new LoginInterface();
        lg.execute();
        }
    }
}
