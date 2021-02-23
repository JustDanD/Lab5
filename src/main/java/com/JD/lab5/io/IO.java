package com.JD.lab5.io;

import com.JD.lab5.data.SpaceMarine;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.util.TreeSet;


public class IO {

    private static CellProcessor[] getReadingProcessors() {
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

    private static CellProcessor[] getWritingProcessors() {
        final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new FmtNumber("")), //id
                new NotNull(), //name
                new NotNull(new FmtCoords()), //coordinates
                new NotNull(new FmtDate("yyyy-mm-dd")), //data
                new NotNull(new FmtNumber("")), //health
                new NotNull(new FmtNumber("")), //heartCount
                new Optional(new FmtBool("true", "false")), //loyal
                new NotNull(new FmtMeleeWeapon()), //MeleeWeapon
                new NotNull(new FmtChapter()), //Chapter
        };
        return processors;
    }

    public static TreeSet<SpaceMarine> readFrom(String path) {
        TreeSet<SpaceMarine> inputTree = new TreeSet<SpaceMarine>();
        String fileName = System.getenv(path);
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
            InputStreamReader inr = new InputStreamReader(in);
            CsvBeanReader beanReader = new CsvBeanReader(inr, CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
            String[] header = beanReader.getHeader(true);
            final CellProcessor[] processors = getReadingProcessors();
            SpaceMarine m;
            while ((m = beanReader.read(SpaceMarine.class, header, processors)) != null) {
                inputTree.add(m);
            }
        } catch (Exception e) {
            System.out.println("Ошибка загрузки коллекции:" + e.getMessage());
        }
        return inputTree;
    }

    public static void writeTo(String path, TreeSet<SpaceMarine> col) {
        try {
            ICsvBeanWriter beanWriter = new CsvBeanWriter(new BufferedWriter(new FileWriter(path)), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
            final String[] header = new String[]{"id", "name", "coordinates", "creationDate", "health", "heartCount", "loyal", "meleeWeapon", "chapter"};
            final CellProcessor[] processors = getWritingProcessors();
            beanWriter.writeHeader(header);
            for (final SpaceMarine marine : col) {
                beanWriter.write(marine, header, processors);
            }
            beanWriter.close();
            System.out.println("Коллекция успешно сохранена");
        } catch (Exception e) {
            System.out.println("Ошибка сохранения:" + e.getMessage());
        }
    }
}
