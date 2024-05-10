package cli;

import ui.TicketReservationSystemUI;

public class main {
    public static void main(String[] args) {
        TicketReservationSystemUI ticketReservationSystemUI = new TicketReservationSystemUI();
        LoginInterface lg = new LoginInterface();
        lg.execute();
    }
}
