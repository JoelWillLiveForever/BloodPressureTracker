package jo.joelly.bpt.blood_pressure;

import java.time.LocalDateTime;

public class BloodPressure
{
    private int _systolic, _diastolic, _pulse;
    private LocalDateTime _dateTime;

    public BloodPressure( int systolic, int diastolic, int pulse, LocalDateTime dateTime )
    {
        this._systolic = systolic;
        this._diastolic = diastolic;
        this._pulse = pulse;
        this._dateTime = dateTime;
    }

    public int getSystolic()
    {
        return _systolic;
    }

    public void setSystolic( int systolic )
    {
        _systolic = systolic;
    }

    public int getDiastolic()
    {
        return _diastolic;
    }

    public void setDiastolic( int diastolic )
    {
        _diastolic = diastolic;
    }

    public int getPulse()
    {
        return _pulse;
    }

    public void setPulse( int pulse )
    {
        _pulse = pulse;
    }

    public LocalDateTime getDateTime()
    {
        return _dateTime;
    }

    public void setDateTime( LocalDateTime dateTime )
    {
        _dateTime = dateTime;
    }
}
