import defaulStation.Initializer;
import defaulStation.SaintPetersburgUndergroundBlue;
import model.Train;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class TestTrain {
    Train sameTrain;
    Train sameTrain2;
    Train sameTrain3;
    Train oppsositeTrain;

    @Before
    public void init() {
        new Initializer().work();
        sameTrain = new Train(SaintPetersburgUndergroundBlue.PIONERSKAJA, SaintPetersburgUndergroundBlue.CHERNAJA_RECHKA);
        sameTrain = new Train(SaintPetersburgUndergroundBlue.PETROGRADSKAJA, SaintPetersburgUndergroundBlue.PIONERSKAJA);
        oppsositeTrain = new Train(SaintPetersburgUndergroundBlue.CHERNAJA_RECHKA, SaintPetersburgUndergroundBlue.PIONERSKAJA);

    }

    @Test
    public void testOppositeAccident() {
        System.out.println(sameTrain.hasAccident(oppsositeTrain));
        assertTrue(sameTrain.hasAccident(oppsositeTrain));
    }

    @Test
    public void testInOneStationAccident() {
        System.out.println(sameTrain2.hasAccident(sameTrain3));
        assertTrue(sameTrain2.hasAccident(sameTrain3));

    }
}
