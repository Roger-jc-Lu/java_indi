/**
 * The class that stores pattern information as an array
 * Roger Lu
 * 01/2020
 */

package pj2;

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
