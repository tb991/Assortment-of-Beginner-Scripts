// draws pixels (plural)
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class DrawAPixel extends JPanel{	
	private BufferedImage puffer;
	private JFrame window;
	private Graphics g;
    int xprogress = 0;
    int yprogress = 0;
	public DrawAPixel() {
		window = new JFrame("Red Pixel");
		window.setSize(320, 240);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		setBounds(0, 0, 320, 240);
		window.add(this);
		window.setVisible(true);
	}
	@Override
	public void paint(Graphics gr) {
		if(g == null) {
			puffer = (BufferedImage) createImage(getWidth(), getHeight());
			g = puffer.getGraphics();
		}
        if (xprogress==100){
            yprogress = yprogress + 1;
            xprogress= 0;
        }
		g.setColor(new Color(255, 0, 0));
		g.drawRect(xprogress, yprogress, 1, 1);
		gr.drawImage(puffer, 0, 0, this);
        xprogress++;
	}
	public static void main(String[] args) {
		DrawAPixel a = new DrawAPixel();
        int x = 0;
        while (x < 9999){
            a.paint(a.getGraphics());
            x++;
        }
	}
}
