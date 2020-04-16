package Jackson;

public class Pattern{
    protected String elementArray[];
    
    public Pattern(){

    }

    public Pattern(String... element){
        setElementArray(element);
    }

    public String[] getElementArray() {
        return elementArray;
    }

    public void setElementArray(String... element) {
        this.elementArray = element;
    }
}
