package com.JD.lab5;



import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

public class FmtChapter extends CellProcessorAdaptor {


    public FmtChapter() {
    }

    public Object execute(Object value, CsvContext context) {
        this.validateInputNotNull(value, context);
        if (!(value instanceof Chapter)) {
            throw new SuperCsvCellProcessorException("Broken chapter to write", context, this);
        } else {
            String res = ((Chapter)value).getName() + "," + ((Chapter)value).getParentLegion();
            return this.next.execute(res, context);
        }
    }
}
