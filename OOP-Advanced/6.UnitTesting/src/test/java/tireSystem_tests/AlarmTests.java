package tireSystem_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import tirePressureMonitoringSystem.Alarm;
import tirePressureMonitoringSystem.Sensor;

public class AlarmTests {
    private static final double NORMAL_PRESSURE = 18.0;
    private static final double LOW_PRESSURE = 15.0;
    private static final double HIGH_PRESSURE = 22.0;
    private static final double BORDER_LOW_PRESSURE = 17.0;
    private static final double BORDER_HIGH_PRESSURE = 21.0;

    private Alarm alarm ;
    private Sensor sensor ;

    @Before
    public void initializeAlarm(){
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(this.sensor);
    }

    @Test
    public void alarmShouldBeOffWhenInitialized(){
        Assert.assertTrue(!this.alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffForNormalPressure(){
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        Assert.assertTrue(!this.alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOnForLowPressure(){
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOnForHighPressure(){
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffForBorderLowPressure(){
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(BORDER_LOW_PRESSURE);
        alarm.check();
        Assert.assertTrue(!this.alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffForBorderHighPressure(){
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(BORDER_HIGH_PRESSURE);
        alarm.check();
        Assert.assertTrue(!this.alarm.getAlarmOn());
    }
}
