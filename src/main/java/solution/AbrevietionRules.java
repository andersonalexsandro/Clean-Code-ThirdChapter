package solution;

import java.util.function.UnaryOperator;

public class AbrevietionRules {

    private  String abrevietionSymbol;
    private  String abrevietionFormat;
    private UnaryOperator<String> abrevieteFunction;
    private int minimumWordSize;

    public AbrevietionRules(String abrevietionSymbol, String abrevietionFormat, int minimumWordSize, UnaryOperator<String> abrevieteFunction) {
        this.abrevietionSymbol = abrevietionSymbol;
        this.abrevietionFormat = abrevietionFormat;
        this.abrevieteFunction = abrevieteFunction;
        this.minimumWordSize = minimumWordSize;
    }

    public String getAbrevietionSymbol() {
        return abrevietionSymbol;
    }

    public void setAbrevietionSymbol(String abrevietionSymbol) {
        this.abrevietionSymbol = abrevietionSymbol;
    }

    public String getAbrevietionFormat() {
        return abrevietionFormat;
    }

    public void setAbrevietionFormat(String abrevietionFormat) {
        this.abrevietionFormat = abrevietionFormat;
    }

    public int getMinimumWordSize() {
        return minimumWordSize;
    }

    public void setMinimumWordSize(int minimumWordSize) {
        this.minimumWordSize = minimumWordSize;
    }

    public UnaryOperator<String> getAbrevieteFunction() {
        return abrevieteFunction;
    }

    public void setAbrevieteFunction(UnaryOperator<String> abrevieteFunction) {
        this.abrevieteFunction = abrevieteFunction;
    }

}
