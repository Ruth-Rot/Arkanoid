package animations;

import biuoop.DrawSurface;
import interfaces.Menu;

import java.util.Map;
import java.util.TreeMap;

public class MenuAnimation implements Menu {
    private Map<String,String> selectionMessage;
    private Map<String,Object> selectionObject;
    private String st;

    public MenuAnimation(){
            this.selectionObject = new TreeMap<>();
            this.selectionObject = new TreeMap<>();
            this.st=null;
    }

    @Override
    public void addSelection(String key, String message, Object returnVal) {
        this.selectionMessage.put(key,message);
        this.selectionObject.put(key,returnVal);
    }

    @Override
    public Object getStatus() {
        return this.selectionObject;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, this.st, 40);
    }

    @Override
    public boolean shouldStop() {
        if(this.st == null){
            return false;
        }
        return true;
    }
}
