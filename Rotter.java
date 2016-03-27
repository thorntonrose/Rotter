import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Rotter extends Applet {
   private BorderLayout borderLayout1 = new BorderLayout();
   private BorderLayout borderLayout2 = new BorderLayout();
   private GridLayout   gridLayout1 = new GridLayout();
   private Panel        textPanel = new Panel();
   private Panel        controlPanel = new Panel();
   private Panel        buttonPanel = new Panel();
   private Button       rot13Button = new Button();
   private Button       rot13n5Button = new Button();
   private Button       clearButton = new Button();
   private TextArea     textArea = new TextArea("", 0, 0, 
      TextArea.SCROLLBARS_VERTICAL_ONLY);

   //--------------------------------------------------------------------------
   
   public Rotter() {
   }
   
   //--------------------------------------------------------------------------

   public void init() {
      textArea.setFont(new Font("Dialog", Font.PLAIN, 12));
      
      rot13Button.setLabel("Rot13");
      rot13Button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            rot13();
         }
      });

      rot13n5Button.setLabel("Rot13n5");
      rot13n5Button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            rot13n5();
         }
      });

      clearButton.setLabel("Clear");
      clearButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent event) {
            clear();
         }
      });

      gridLayout1.setHgap(5);
      gridLayout1.setVgap(0);
      gridLayout1.setColumns(3);

      // buttonPanel.setBackground(new Color(224,224,224));
      buttonPanel.setLayout(gridLayout1);
      buttonPanel.add(rot13Button);
      buttonPanel.add(rot13n5Button);
      buttonPanel.add(clearButton);
      
      // controlPanel.setBackground(buttonPanel.getBackground());
      controlPanel.setLayout(borderLayout2);
      controlPanel.add(buttonPanel, BorderLayout.WEST);

      borderLayout1.setVgap(5);
      
      setLayout(borderLayout1);
      add(textArea, BorderLayout.CENTER);
      add(controlPanel, BorderLayout.SOUTH);
   }

   private void rot13() {
      textArea.setText(StrUtil.rot13(textArea.getText()));
   }

   private void rot13n5() {
      textArea.setText(StrUtil.rot13n5(textArea.getText()));
   }
   
   private void clear() {
      textArea.setText("");
   }
}
