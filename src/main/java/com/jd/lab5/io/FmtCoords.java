package com.jd.lab5.io;


import com.jd.lab5.data.Coordinates;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

/**
 * @author Пименов Данила P3130
 * Выходной парсер для координат.
 */
public class FmtCoords extends CellProcessorAdaptor {


    public FmtCoords() {
    }

    public Object execute(Object value, CsvContext context) {
        this.validateInputNotNull(value, context);
        if (!(value instanceof Coordinates)) {
            throw new SuperCsvCellProcessorException("Broken coordinates to write", context, this);
        } else {
            String res = "" + ((Coordinates) value).getX() + "," + ((Coordinates) value).getY();
            return this.next.execute(res, context);
        }
    }
}