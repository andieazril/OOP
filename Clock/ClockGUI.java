import javax.swing.*;
import java.awt.*;
import java.time.LocalDate; 
import java.time.LocalTime;

public class ClockGUI extends JFrame 
{

    private ClockDisplay clockLogic;
    private JLabel timeLabel;
    private JLabel dateLabel; 
    private JLabel tempLabel; 

    public ClockGUI() 
    {
        clockLogic = new ClockDisplay();

        setTitle("Jam Digital Lengkap");
        setSize(450, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 60));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        
        tempLabel = new JLabel();
        tempLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel(new BorderLayout());

        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));


        bottomPanel.add(dateLabel, BorderLayout.WEST);  
        bottomPanel.add(tempLabel, BorderLayout.EAST); 
        
        add(timeLabel, BorderLayout.CENTER);  
        add(bottomPanel, BorderLayout.SOUTH); 

        startClock();
    }

    private void startClock() {
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {

        LocalTime nowTime = LocalTime.now();
        LocalDate nowDate = LocalDate.now();
        
        double currentTemp = 29.5; 

        clockLogic.setTime(nowTime.getHour(), nowTime.getMinute(), nowTime.getSecond());
        clockLogic.setDate(nowDate.getDayOfMonth(), nowDate.getMonthValue(), nowDate.getYear());
        clockLogic.setTemperature(currentTemp);

        String timeString = clockLogic.getTimeString();
        String dateString = clockLogic.getDateString();
        String tempString = clockLogic.getTempString();
        
        timeLabel.setText(timeString);
        dateLabel.setText(dateString);
        tempLabel.setText(tempString);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClockGUI clockWindow = new ClockGUI();
            clockWindow.setVisible(true);
        });
    }
}