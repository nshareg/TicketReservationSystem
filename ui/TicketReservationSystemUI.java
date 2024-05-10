package ui;
import core.*;
import exception.*;
import java.awt.*;
import javax.swing.*;
public class TicketReservationSystemUI extends JFrame{
    private Core core;
    public TicketReservationSystemUI(){
        core = new Core();
        LoginForm lg = new LoginForm(core);
    }
}
