import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GraphicsEnvironment;
import java.util.Locale;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.border.*;
import javax.swing.JRadioButton;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.GraphicsEnvironment;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.Font;
//various import statements to use classes referenced in this program

/*
 * 
 * NOTE!
 * HIT ENTER ON THE TEXTBOXES FOR THEM TO REGISTER AN EVENT
 */
public class LogoC
{
    private BufferedImage willyWonka;
    private BufferedImage doge;
    private BufferedImage blb;
    private BufferedImage star;
    private BufferedImage willyReal;
    private BufferedImage dogeReal;
    private BufferedImage badReal;
    private BufferedImage starReal;
    //declaration of various BufferedImages to be instantiated later;
    public LogoC() { 
    }
    public void makeUI() {
        JFrame j = new JFrame("MemeCreator - Nishan D'Souza");//declares and initialized a new JFame referenced by j with a string parameter to be a title
        j.setSize(800,500);//invokes the setSize method on the JFrame to manually set the size
        JPanel mainPanel = new JPanel(); //creates a panel which represents the whole JFame, referenced by mainPanel
        BorderLayout mainBL = new BorderLayout();//creates a borderLayout for the mainPanel, which will have west as styling, east as picture choosing, and center as render
        mainPanel.setLayout(mainBL);//invokes setLayout on the mainPanel JPanel with explicit parameter mainBL to set the main panel's layout as the border one from before
        JPanel centerP = new JPanel();//declares 3 panels which represent each part of the main Panel, as described before
        JPanel leftP = new JPanel();
        JPanel rightP = new JPanel();
        mainPanel.add(centerP, BorderLayout.CENTER);//invokes the add method on mainPanel, with the respective inner panel and static variable showing where the component should go as parameters
        mainPanel.add(leftP, BorderLayout.WEST);
        mainPanel.add(rightP, BorderLayout.EAST);
        //the following code is in order to create stylized borders for the left and right panels
        
        leftP.setBorder(new TitledBorder(new EtchedBorder(), "Style"));//invokes the setBorder on the two side panels, with a new TitledBorder and EtchedBorder as parameters
        rightP.setBorder(new TitledBorder(new EtchedBorder(), "Choose Picture"));
        //creating the style panel on the left side
        GridLayout stylin = new GridLayout(10,1);//creates a GridLayout for the style panel,with 10,1 representing the rows and columns needed
        leftP.setLayout(stylin);//invokes the setLayout method on the leftP to set it's layot
        JTextField textbox1 = new JTextField("Caption 1", 14);//contructs and initializes two JTextFields in order for the user to have two captions
        JTextField textbox2 = new JTextField("Caption 2", 14);
        textbox1.setHorizontalAlignment(JTextField.CENTER);//invokes setHorizontalAlignment with a static CENTER parameter on the two textFields to make them center in the panel
        textbox2.setHorizontalAlignment(JTextField.CENTER);
        String[] sizes = new String[] {"10", "12", "16", "18", "20", "24"};//constructs and initializes a String array with various sizes needed for the font
        JComboBox fSize = new JComboBox<>(sizes);//uses the sizes array from before in a JComboBox to make a drop down menu        
        JPanel colorPan = new JPanel();//creates a new JPanel referenced by colorPan to have the RBG textFields on the same row
        GridLayout colorGL = new GridLayout(1,4);
        colorPan.setLayout(colorGL);
        JLabel rgb = new JLabel("Color (RGB)");//declares and initializes JLabels and JTextFields for the RGB value entering
        JTextField r = new JTextField("0", 1);
        JTextField g = new JTextField("0", 1);
        JTextField bB = new JTextField("0", 1);
        r.setHorizontalAlignment(JTextField.CENTER);//invokes the setHorizontalAlignment on all the JTextFields to make them center in the panel
        g.setHorizontalAlignment(JTextField.CENTER);
        bB.setHorizontalAlignment(JTextField.CENTER);
        colorPan.add(rgb);//adds the RGB labels and textFields to the panel referenced by colorPan
        colorPan.add(r);
        colorPan.add(g);
        colorPan.add(bB);
        JPanel checks = new JPanel();//creates a new JPanel referenced by checks to keep the checkboxes on the same row
        GridLayout checkGL = new GridLayout(1,2);
        checks.setLayout(checkGL);
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");
        JComboBox fontFam = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(Locale.ENGLISH));//declares and initializes a new JCOmboBox with a paremeter of the Locale of the Graphics Environemgt, used by the GetLocalGraphicsEnvironment methdo
        checks.add(bold);//adds the various components to their respective panels in order of the gridlayout
        checks.add(italic);
        leftP.add(textbox1);
        leftP.add(textbox2);
        leftP.add(fSize);
        leftP.add(colorPan);        
        leftP.add(checks);
        leftP.add(fontFam);
        
        renderImages();//invokes the renderImages to instantiate all the BufferedImages
        ButtonGroup b = new ButtonGroup();//creates a new ButtonGroup for all the radioButtons
        GridLayout imgs = new GridLayout(1,1);
        rightP.setLayout(imgs);
        JPanel options = new JPanel();
        GridLayout optionsGL = new GridLayout(4,1);
        options.setLayout(optionsGL);
        rightP.add(options);
        JRadioButton willRB = new JRadioButton("Willy Wonka", true);//declares and initializes various JRadioButtons for the image selecton
        JRadioButton dogeRB = new JRadioButton("Doge");
        JRadioButton blbRB = new JRadioButton("Bad Luck Brian");
        JRadioButton starRB = new JRadioButton("Star Trek");
        ImageIcon placeholder = new ImageIcon((Image) willyWonka);
        JLabel img = new JLabel(placeholder);//creates a JLabel to show the image that is currently selected, with the placeholder from before to fill it with something at the star
        b.add(willRB);//adds the radioButtons to the group and options panel
        b.add(dogeRB); 
        b.add(blbRB);
        b.add(starRB);
        options.add(willRB);
        options.add(dogeRB);
        options.add(blbRB);
        options.add(starRB);
        rightP.add(img);
        
        BorderLayout centerBL = new BorderLayout();
        centerP.setLayout(centerBL);
        JPanel imageRender = new JPanel();
        GridLayout imageLay = new GridLayout(3,1);
        imageRender.setLayout(imageLay);
        JLabel topLabel = new JLabel();//constructs and initializes the Jlabels needed to show captions and images
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel realPicture = new JLabel();
        JLabel botLabel = new JLabel();
        botLabel.setHorizontalAlignment(JLabel.CENTER);
        //these labels will be modified in the actionPerformed method below
        class LogoListener implements ActionListener {   //inner class to reference all of the various local variables         
            public void actionPerformed(ActionEvent e) {
                if(willRB.isSelected()==true) {//invokes isSelected on the radioButtons, and if it is selected invokes the setIcon method on the two Jlables;
                    img.setIcon(new ImageIcon(willyWonka));
                    realPicture.setIcon(new ImageIcon(willyReal));
                }
                if(dogeRB.isSelected()==true) {
                    img.setIcon(new ImageIcon(doge));
                    realPicture.setIcon(new ImageIcon(dogeReal));
                }
                if(blbRB.isSelected()==true) {    
                    img.setIcon(new ImageIcon(blb));
                    realPicture.setIcon(new ImageIcon(badReal));
                }
                if(starRB.isSelected()==true) {
                    img.setIcon(new ImageIcon(star));
                    realPicture.setIcon(new ImageIcon(starReal));
                }
                String fontFamily = (String) fontFam.getSelectedItem();//declares various strings and integers to represent the values of the various labels and textboxes, using getText and getSelectedItals
                String text1 = textbox1.getText();
                String text2 = textbox2.getText();               
                int sizeT = Integer.parseInt((String) fSize.getSelectedItem());//typecasted String
                int colorR = Integer.parseInt(r.getText());
                int colorG = Integer.parseInt(g.getText());
                int colorB = Integer.parseInt(bB.getText());
                if(bold.isSelected() && italic.isSelected()) {//if the bold and italic checkboxes are selected, do the follwing
                    topLabel.setFont(new Font(fontFamily, Font.BOLD + Font.ITALIC, sizeT));
                    botLabel.setFont(new Font(fontFamily, Font.BOLD + Font.ITALIC, sizeT));//invokes setFont on the two labels with the fontFamily string, style integers, and size integers

                }
                else if(bold.isSelected()) {
                    topLabel.setFont(new Font(fontFamily, Font.BOLD, sizeT));
                    botLabel.setFont(new Font(fontFamily, Font.BOLD, sizeT));

                }
                else if(italic.isSelected()) {
                    topLabel.setFont(new Font(fontFamily, Font.ITALIC, sizeT));
                    botLabel.setFont(new Font(fontFamily, Font.ITALIC, sizeT));

                }
                else {
                    topLabel.setFont(new Font(fontFamily, 0, sizeT));
                    botLabel.setFont(new Font(fontFamily, 0, sizeT));
                }//^^^ looks like I would pass the fizzbuzz test -_- +1 if you get it
                topLabel.setText(text1);//invokes setText method on the labels with the  strings from before 
                botLabel.setText(text2);
                topLabel.setForeground(new Color(colorR, colorG, colorB));
                botLabel.setForeground(new Color(colorR, colorG, colorB));
                centerP.add(realPicture, BorderLayout.CENTER);//adds the various components to their respective panels.
                centerP.add(topLabel, BorderLayout.NORTH);
                centerP.add(botLabel, BorderLayout.SOUTH);
                j.setVisible(true);
            }
        }
        willRB.addActionListener(new LogoListener());//adds actionListeners to all the various components that need it
        dogeRB.addActionListener(new LogoListener());
        blbRB.addActionListener(new LogoListener());
        starRB.addActionListener(new LogoListener());
        textbox1.addActionListener(new LogoListener());
        textbox2.addActionListener(new LogoListener());
        fontFam.addActionListener(new LogoListener());
        bold.addActionListener(new LogoListener());
        italic.addActionListener(new LogoListener());
        fSize.addActionListener(new LogoListener());
        r.addActionListener(new LogoListener());
        g.addActionListener(new LogoListener());
        bB.addActionListener(new LogoListener());   
        j.add(mainPanel);
        j.setVisible(true);
    }
    public void renderImages() {
        try {//invokes the read method on ImageIo class, with the name of the file as a paremeter
            willyWonka = ImageIO.read(new File("willyWIcon.jpg"));
        }
        catch(IOException e) {//catches an exception if it occurs
        }       
        try {
            doge = ImageIO.read(new File("dogeIcon.jpg"));
        }
        catch(IOException e) {
        }
        try {
            blb = ImageIO.read(new File("badLuckIcon.jpg"));
        }
        catch(IOException e) {
        }
        try {
            star = ImageIO.read(new File("starTrekIcon.jpg"));
        }
        catch(IOException e) {
        }
        try {
            willyReal = ImageIO.read(new File("willyReal.jpg"));
        }
        catch(IOException e) {
        }
        try {
            dogeReal = ImageIO.read(new File("dogeReal.jpg"));
        }
        catch(IOException e) {
        }
        try {
            badReal = ImageIO.read(new File("badReal.png"));
        }
        catch(IOException e) {
        }
        try {
            starReal = ImageIO.read(new File("starReal.jpg"));
        }
        catch(IOException e) {
        }
    }
}