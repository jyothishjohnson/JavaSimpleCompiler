public class Demo{

    private int intVar;
    private String stringVar;
    public char myChar;

    public class Demo(){
    }

    public class Demo(int intVar){
        this.intVar = intVar;
    }

    public class Demo(int intVar,String stringVar){
        this.intVar = intVar;
    }

    public int getIntVar(){
        return intVar;
    }

    public void setIntVar(int intVar) {
        this.intVar = intVar;
    }

    public String getStringVar() {
        return stringVar;
    }

    public void setStringVar(String stringVar){
        this.stringVar = stringVar;
    }
}