package com.JD.lab5;



import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

public class FmtCoords extends CellProcessorAdaptor {


    public FmtCoords() {
    }

    public Object execute(Object value, CsvContext context) {
        this.validateInputNotNull(value, context);
        if (!(value instanceof Coordinates)) {
            throw new SuperCsvCellProcessorException("Broken coordinates to write", context, this);
        } else {
            String res = "" + ((Coordinates)value).getX() + "," + ((Coordinates)value).getY();
            return this.next.execute(res, context);
        }
    }
}