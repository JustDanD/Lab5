package com.JD.lab5;

import java.io.*;
import java.util.Map;
import java.util.TreeSet;

import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.io.CsvBeanReader;


public class IO {
    //private String filename;

        private static CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new ParseLong()), //id
                new NotNull(), //name
                new NotNull(new ParseCoordinates()), //coordinates
                new NotNull(new ParseDate("yyyy-mm-dd")), //data
                new NotNull(new ParseDouble()), //health
                new NotNull(new ParseLong()), //heartCount
                new Optional(new ParseBool()), //loyal
                new NotNull(), //MeleeWeapon
                new NotNull(new ParseChapter()), //Chapter
        };
        return processors;
    }

    public static void readFrom(String path) {
        TreeSet<SpaceMarine> inputTree = new TreeSet<SpaceMarine>();
        String fileName = System.getenv(path);
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
            InputStreamReader inr = new InputStreamReader(in);
            CsvBeanReader beanReader = new CsvBeanReader(inr, CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
            String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getProcessors();
            SpaceMarine m;
            while ((m = beanReader.read(SpaceMarine.class, header, processors)) != null) {
                /*if (m.isLoyal())
                    m.setLoyal(false);*/
                inputTree.add(m);
            }

            System.out.println(inputTree);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
