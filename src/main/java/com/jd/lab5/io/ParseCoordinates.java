package com.jd.lab5.io;

import com.jd.lab5.data.Coordinates;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.LongCellProcessor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

public class ParseCoordinates extends CellProcessorAdaptor implements StringCellProcessor {
    public ParseCoordinates() {

    }

    public ParseCoordinates(LongCellProcessor next) {
        super(next);
    }

    @Override
    public Coordinates execute(Object value, CsvContext context) {
        this.validateInputNotNull(value, context);
        if (value instanceof String) {
            String[] parts = ((String) value).split(",");
            if (parts.length != 2)
                throw new SuperCsvCellProcessorException("Not enough coordinates", context, this);
            try {
                long x;
                float y;
                x = Long.parseLong(parts[0]);
                y = Float.parseFloat(parts[1]);
                return new Coordinates(x, y);
            } catch (Exception e) {
                throw new SuperCsvCellProcessorException("Wrong coordinates", context, this);
            }
        }
        return null;
    }
}
