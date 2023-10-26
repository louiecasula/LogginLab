import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class LogginLabTest {
    private final static Logger logger = Logger.getLogger(LogginLab.class.getName());

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void thresholdExceeds() {
        Integer finalLimit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(finalLimit);

        for (Integer i = 1; i <= finalLimit; i++) {
            if (lab.thresholdExceeds(i)) {
                logger.log(Level.INFO, "Threshold not exceed. Only "+ (finalLimit - i) +" to go!");
                assertTrue(lab.thresholdExceeds(i));
            } else {
                logger.log(Level.INFO, "Threshold finally reached!");
                assertFalse(lab.thresholdExceeds(i));
            }
        }
    }

    @org.junit.Test
    public void thresholdReached() {
        Integer limit = 5;

        LogginLab lab = new LogginLab();
        lab.setThreshold(limit);

        for (Integer i = 1; i <= limit + 1; i++) {
            if (lab.thresholdReached(i)) {
                logger.log(Level.INFO, "Threshold finally exceeded!");
                assertTrue(lab.thresholdReached(i));
            } else if (i == limit) {
                logger.log(Level.INFO, "Threshold met.");
            } else {
                logger.log(Level.INFO, "Threshold not reached! Only "+ (limit - i) +" to go!");
                assertFalse(lab.thresholdReached(i));
            }
        }
    }
}