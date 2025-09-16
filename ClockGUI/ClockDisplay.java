public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String displayString;
    
    private NumberDisplay day;
    private NumberDisplay month;
    private NumberDisplay year;
    private double temperature;

    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        
        day = new NumberDisplay(32);   
        month = new NumberDisplay(13);   
        year = new NumberDisplay(10000); 
        
        setDate(1, 1, 2025);
        this.temperature = 25.0;
        
        updateDisplay();
    }

    public void timeTick()
    {
        seconds.increment();
        if(seconds.getValue() == 0) {
            minutes.increment();
            if(minutes.getValue() == 0) {
                hours.increment();
            }
        }
        updateDisplay();
    }

    public void setTime(int hour, int minute, int second)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }
    
    public void setDate(int day, int month, int year)
    {
        this.day.setValue(day);
        this.month.setValue(month);
        this.year.setValue(year);
    }
    
    public void setTemperature(double temp)
    {
        this.temperature = temp;
    }

    public String getTimeString()
    {
        return displayString;
    }
    
    public String getDateString()
    {
        String yearValue = String.format("%04d", year.getValue());
        return day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + yearValue;
    }
    
    public String getTempString()
    {
        return String.format("%.1f°C", temperature);
    }

    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" +
                        minutes.getDisplayValue() + ":" +
                        seconds.getDisplayValue();
    }
}