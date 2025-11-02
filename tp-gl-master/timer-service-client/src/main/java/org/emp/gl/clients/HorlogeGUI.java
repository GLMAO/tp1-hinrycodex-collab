package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class HorlogeGUI extends JFrame implements TimerChangeListener {
    private JLabel timeLabel;
    private TimerService timerService;
    
    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;
        this.timerService.addTimeChangeListener(this);
        
        setTitle("Horloge - Observer Pattern");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Create time display
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Digital-7", Font.BOLD, 72));
        timeLabel.setForeground(new Color(0, 200, 0));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        add(timeLabel, BorderLayout.CENTER);
        
        // Info panel
        JPanel infoPanel = new JPanel();
        infoPanel.add(new JLabel("Real-time clock using Observer Pattern"));
        add(infoPanel, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        // Initial display
        updateDisplay();
    }
    
    private void updateDisplay() {
        String time = String.format("%02d:%02d:%02d", 
            timerService.getHeures(),
            timerService.getMinutes(),
            timerService.getSecondes());
        timeLabel.setText(time);
    }
    
    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        SwingUtilities.invokeLater(() -> updateDisplay());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TimerService timerService = new org.emp.gl.time.service.impl.DummyTimeServiceImpl();
            new HorlogeGUI(timerService);
        });
    }
}