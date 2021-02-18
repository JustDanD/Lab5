package com.JD.lab5;

import java.io.*;
import java.util.Map;

import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.io.CsvBeanReader;


public class IO {
    //private String filename;

        private static CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(), // name
                new NotNull(), // coordX
                new NotNull(), // CoordY
                new ParseDouble(), // health
                new NotNull(), // heartCount
                new Optional(), // loyal
                new NotNull(), // meleeWeapon
                new NotNull(), // chapterName
                new NotNull(), // parentLegion
        };
        return processors;
    }

    public static void readFrom(String path) {
        Map<String, String> env = System.getenv();
        String fileName = System.getenv(path);
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
            InputStreamReader inr = new InputStreamReader(in);
            CsvBeanReader beanReader = new CsvBeanReader(inr, CsvPreference.STANDARD_PREFERENCE);
            String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            CsvMarine m = beanReader.read(CsvMarine.class, header, processors);
            System.out.println(m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
