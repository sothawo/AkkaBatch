package com.sothawo.akkabatch;

import java.util.Random;

/**
 * Datensatzverarbeitung. Liefert eine Kopie des Record und verbraucht etwas Zeit.
 */
public final class RecordProcessor {
// ------------------------------ FIELDS ------------------------------

    public static int fibonacci = 1000;
    public static int threadsleep = 10;
    private static Random rand = new Random();

// -------------------------- STATIC METHODS --------------------------

    public static Record processRecord(final Record origin) {
        if (null == origin) {
            throw new IllegalArgumentException("null input");
        }
        Record record =
                new Record(origin.getId(), origin.getSex(), origin.getFirstname(), origin.getLastname(),
                           origin.getZip(), origin.getCity(), origin.getDistrict(), origin.getStreet(),
                           origin.getNumber());
        useTime();
        return record;
    }

    /**
     * verbraucht Zeit
     */
    public static void useTime() {
        if (0 == (rand.nextInt() % 2)) {
            try {
                Thread.sleep(threadsleep);
            } catch (InterruptedException ignored) {
                System.err.println("oops, interrupted");
            }
        } else {
            Fibonacci.calculate(fibonacci);
        }
    }
}