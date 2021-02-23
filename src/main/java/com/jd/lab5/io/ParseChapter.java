package com.jd.lab5.io;

import com.jd.lab5.data.Chapter;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.LongCellProcessor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

public class ParseChapter extends CellProcessorAdaptor implements StringCellProcessor {
    public ParseChapter() {

    }

    public ParseChapter(LongCellProcessor next) {
        super(next);
    }

    @Override
    public Chapter execute(Object value, CsvContext context) {
        this.validateInputNotNull(value, context);
        if (value instanceof String) {
            String[] parts = ((String) value).split(",");
            if (parts.length > 2 || parts.length < 1)
                throw new SuperCsvCellProcessorException("Broken chapter", context, this);
            if (parts.length == 1)
                return new Chapter(parts[0], "");
            return new Chapter(parts[0], parts[1]);
        }
        return null;
    }
}