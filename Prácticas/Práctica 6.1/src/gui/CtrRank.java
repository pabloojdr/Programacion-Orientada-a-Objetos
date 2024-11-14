package gui;

//import rank.WebExtended;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;


public class CtrRank implements ActionListener {
    private ViewRank vRank;
  //  private WebExtended web;

    public CtrRank(ViewRank vr) {
        vRank = vr;
    }

    public void actionPerformed(ActionEvent event) {
        ViewRank.Command command = ViewRank.Command.valueOf(event.getActionCommand());
        try {
            switch (command) {
                case  CREATE: {
                  
                    break;
                }
                case CLICK: {
                  
                    break;
                }
                case BYNAME: {
                  
                    break;
                }
                case BYRANK: {
                 
                    break;
                }
                case SIMULATE: {
                 
                    break;
                }
                case SWITCH: {
                    
                    break;
                }
            }
        } catch (IllegalArgumentException | NoSuchElementException e) {
            vRank.setError(e.getMessage());
        } catch (NullPointerException e) {
            vRank.setError("Web not create");
//        } catch (IOException e) {
//            vRank.setError("File Not Found");
        }
    }

    private void createLinks(String fn) throws IOException {
     
    }
}
