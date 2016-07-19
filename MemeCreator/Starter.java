//starter class to draw the interface and start event handling
public class Starter
{
    public static void main(String[] args) {
        LogoC c = new LogoC();//constructs new LogoC with reference c in order to make the UI
        c.makeUI();//invokes the void makeUI method on LogoC referenced by c to start the program
    }
}
